package com.cdv.editor.rs.program;

import com.newautovideo.ce.ws.ProgramType;

@SuppressWarnings("serial")
public class ProgramBasic extends ProgramType
{

	
	private String programCode;
	private String programName;
	//添加绑定状态属性
	private int status;
	private String statusDesc;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

}
