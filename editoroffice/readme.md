# Mediasphere 项目说明

## 开发环境配置

本项目采用Gradle完成项目依赖和构建的工作，对开发环境有如下要求：

* jdk：1.8
* eclipse：>=4.5

首先需要为eclipse安装gradle的插件：Buildship，可以在“About”-“Eclipse Marketplace”中找到并安装。具体可以参考：https://projects.eclipse.org/projects/tools.buildship

将代码从服务器上获取（git等相关操作不在这里说明）之后，可以将gradle.properties.example文件复制到当前用户目录下的.gradle文件夹中，并改名为gradle.properties，如果已经有同名文件存在，请核对一下文件的内容，确保gradle.properties.example中所在的配置项都存在。

最后，通过Eclipse的Import功能导入“Gradle Project”，期间一路选择默认即可。注意：为了以树形结构显示mediasphere中的各个子项目，请不要将Eclipse的Workspace创建到Mediasphere仓库所在目录中。