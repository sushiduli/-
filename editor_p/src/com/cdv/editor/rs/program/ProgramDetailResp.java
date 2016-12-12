package com.cdv.editor.rs.program;

import com.newautovideo.ce.ws.ProgramType;

public class ProgramDetailResp extends ProgramType{
		
		private static final long serialVersionUID = -905309254633824771L;
	
		private  String programCode;
	    private  String programName;
	    private String programType;
	    private String planAirTime;
	    private long duration;
		private String channelID;
		private String programStatus;

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

		public String getProgramType() {
			return programType;
		}

		public void setProgramType(String programType) {
			this.programType = programType;
		}

		public String getPlanAirTime() {
			return planAirTime;
		}

		public void setPlanAirTime(String planAirTime) {
			this.planAirTime = planAirTime;
		}

		public long getDuration() {
			return duration;
		}

		public void setDuration(long duration) {
			this.duration = duration;
		}

		public String getChannelID() {
			return channelID;
		}

		public void setChannelID(String channelID) {
			this.channelID = channelID;
		}

		public String getProgramStatus() {
			return programStatus;
		}

		public void setProgramStatus(String programStatus) {
			this.programStatus = programStatus;
		}

	}

