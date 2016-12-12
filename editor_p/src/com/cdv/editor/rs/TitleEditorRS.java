package com.cdv.editor.rs;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdv.editor.rs.program.JsonResult;
import com.cdv.editor.rs.program.ProgramDetailResp;
import com.cdv.editor.rs.program.QueryProgramCodeResp;


@RequestMapping("/api/edit/title")
public interface TitleEditorRS {

	//获取节目信息
	@RequestMapping(value="/getProgramList",method = RequestMethod.GET)
	JsonResult<QueryProgramCodeResp> getProgCode(
			@RequestParam(value = "broadcastDate", required = true) String broadcastDate, 
			@RequestParam(value="groupName",required = true) String groupName,
			@RequestParam(value = "stationId", required = true) String stationId,
			@RequestParam(value = "programName", required = true) String programName,
			@RequestParam(value = "proType", required = false) String proType
			);
	
	//绑定节目代码
	@RequestMapping(value="/bindProgramCode",method = RequestMethod.GET)
	JsonResult<ProgramDetailResp> bindProgramCode(@RequestParam(value="progcode",required = true) String progcode);
	
	@RequestMapping(value="/unbindProgramCode",method = RequestMethod.GET)
	JsonResult<ProgramDetailResp> unbindProgramCode(@RequestParam(value="progcode",required = true) String progcode);
	
	@RequestMapping(value="/test/json")
	JsonResult<QueryProgramCodeResp> getProgramBasic();
	
}
