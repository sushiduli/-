
package com.jboss.rest.service.handler;

public interface ServerListener
{
	/** 服务器运行状态变更响应
	 * @param serverStatus 服务器运行状态
	 */
	void onServerStatusChanged(int serverStatus);
}
