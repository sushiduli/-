(function ContextMenu($angular, $document) {

    "use strict";

    /**
     * @module ngContextMenu
     * @author Adam Timberlake
     * @link https://github.com/Wildhoney/ngContextMenu
     */
    var module = $angular.module('ngContextMenu', []);

    /**
     * @module ngContextMenu
     * @service ContextMenu
     * @author Adam Timberlake
     * @link https://github.com/Wildhoney/ngContextMenu
     */
    module.factory('contextMenu', ['$rootScope', function contextMenuService($rootScope) {

        /**
         * @method cancelAll
         * @return {void}
         */
        function cancelAll() {
            $rootScope.$broadcast('context-menu/close');
        }

        return { cancelAll: cancelAll, eventBound: false };

    }]);

    /**
     * @module ngContextMenu
     * @directive contextMenu
     * @author Adam Timberlake
     * @link https://github.com/Wildhoney/ngContextMenu
     */
    module.directive('contextMenu', ['$timeout', '$interpolate', '$compile', 'contextMenu', '$templateRequest',
                                     // patch by sunwei
                                     '$parse',

        function contextMenuDirective($timeout, $interpolate, $compile, contextMenu, $templateRequest, $parse) {

            return {

                /**
                 * @property restrict
                 * @type {String}
                 */
                restrict: 'EA',

                /**
                 * @property scope
                 * @type {Boolean}
                 */
                scope: true,

                /**
                 * @property require
                 * @type {String}
                 */
                require: '?ngModel',

                /**
                 * @method link
                 * @param {Object} scope
                 * @param {angular.element} element
                 * @param {Object} attributes
                 * @param {Object} model
                 * @return {void}
                 */
                link: function link(scope, element, attributes, model) {

                    if (!contextMenu.eventBound) {

                        // Bind to the `document` if we haven't already.
                        $document.addEventListener('click', function click() {
                            contextMenu.cancelAll();
                            scope.$apply();
                        });

                        contextMenu.eventBound = true;

                    }

                    /**
                     * @method closeMenu
                     * @return {void}
                     */
                    function closeMenu() {

                        if (scope.menu) {
                            scope.menu.remove();
                            scope.menu     = null;
                            scope.position = null;
                        }

                    }

                    scope.$on('context-menu/close', closeMenu);

                    /**
                     * @method getModel
                     * @return {Object}
                     */
                    function getModel() {
                        return model ? $angular.extend(scope, model.$modelValue) : scope;
                    }
                    
                    // patch by sunwei
                    var fnBefore = $parse(attributes.contextMenuBefore);
                    // patch end

                    /**
                     * @method render
                     * @param {Object} event
                     * @param {String} [strategy="append"]
                     * @return {void}
                     */
                    function render(event, strategy) {
                        // patch by sunwei
                        scope.$apply(function() {
                            // event.preventDefault();
                            fnBefore(scope, {$event:event});
                        });
                        // patch end

                        strategy = strategy || 'append';

                        if ('preventDefault' in event) {

                            contextMenu.cancelAll();
                            event.stopPropagation();
                            event.preventDefault();
                            scope.position = { x: event.clientX, y: event.clientY };

                        } else {

                            if (!scope.menu) {
                                return;
                            }

                        }

                        $templateRequest(attributes.contextMenu).then(function then(response) {
                            var compiled     = $compile(response)($angular.extend(getModel())),
                                menu         = $angular.element(compiled);

                            // Determine whether to append new, or replace an existing.
                            switch (strategy) {
                                case ('append'): element.append(menu); break;
                                default: scope.menu.replaceWith(menu); break;
                            }
                            // patch by sunwei
                            var x = scope.position.x <= $(window).width() / 2.0;
                            var y = scope.position.y <= $(window).height() / 2.0;
                            var l = x ? scope.position.x : scope.position.x - menu.width();
                            var t = y ? scope.position.y : scope.position.y - menu.height();
                            
                            menu.css({
                            	position: 'fixed',
                            	top: y ? (scope.position.y + 'px') : 'auto',
                            	left: x ? (scope.position.x + 'px') : 'auto',
                            	right: x ? 'auto' : ($(window).width() - scope.position.x + 'px'),
                            	bottom: y ? 'auto' : ($(window).height() - scope.position.y + 'px')
                            });
                            
//                            menu.css({
//                                position: 'fixed',
//                                top: 0,
//                                left: 0,
//                                transform: $interpolate('translate({{x}}px, {{y}}px)')({
//                                    x: scope.position.x, y: scope.position.y
//                                })
//
//                            });
                            // patch end

                            scope.menu = menu;
                            scope.menu.bind('click', closeMenu);

                        });

                    }

                    if (model) {

                        var listener = function listener() {
                            return model.$modelValue;
                        };

                        // Listen for updates to the model...
                        scope.$watch(listener, function modelChanged() {
                            render({}, 'replaceWith');
                        }, true);

                    }

                    element.bind(attributes.contextEvent || 'contextmenu', render);

                }

            }

        }]);

})(window.angular, window.document);
