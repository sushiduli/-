package com.cdv.editor.rs.impl;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.cdv.editor.rs.TitleEditorRS;
import com.cdv.editor.rs.program.JsonResult;
import com.cdv.editor.rs.program.ProgramBasic;
import com.cdv.editor.rs.program.ProgramDetailResp;
import com.cdv.editor.rs.program.QueryProgramCodeResp;
import com.cdv.editor.rs.utils.ReadFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newautovideo.ce.ws.CEPortType;
import com.newautovideo.ce.ws.CEServiceLocator;
import com.newautovideo.ce.ws.GetProgramRequest;
import com.newautovideo.ce.ws.ProgramType;
import com.newautovideo.ce.ws.SetProgramStatusRequest;
import com.newautovideo.ce.ws.SetProgramStatusResponse;

@RestController
public class TitleEditorRSImpl implements TitleEditorRS {

	private static Logger logger = LoggerFactory.getLogger(TitleEditorRSImpl.class);

	private String programcodeAddr;

	private CEServiceLocator _ceService = new CEServiceLocator();

	private CEPortType port = null;

	@Override
	public JsonResult<QueryProgramCodeResp> getProgCode(String broadcastDate, String groupName, String stationId,
			String programName,String proType) {

		try {
			// 获取节目代码地址
			programcodeAddr = System.getProperty("es.title.programcode.url");

			port = _ceService.getCEPort(new URL(programcodeAddr));
			GetProgramRequest request = new GetProgramRequest();
			if (StringUtils.hasLength(broadcastDate)) {
				request.setBroadcastDate(new SimpleDateFormat("yyyy-MM-dd").parse(broadcastDate));
			}
			if (StringUtils.hasLength(groupName)) {
				request.setColumn(groupName);
			}
			if (StringUtils.hasLength(programName)) {
				request.setProgramName(programName);
			}
			if(StringUtils.hasLength(proType)){
				request.setProgramType(proType);
			}
			ProgramType[] programs = port.getProgram(request);
			List<ProgramBasic> programBasicInfo = new ArrayList<>();
			ProgramBasic programBasic = null;
			if (null != programs && programs.length > 0) {
				for (int i = 0; i < programs.length; i++) {
					programBasic = new ProgramBasic();
					programBasic.setProgramCode(programs[i].getProgramCode());
					programBasic.setProgramName(programs[i].getProgramName());
					programBasic.setStatus(programs[i].getStatus());
					programBasic.setStatusDesc(programs[i].getStatus() == 1?"已绑定":"未绑定");
					programBasicInfo.add(programBasic);
				}
			}

			JsonResult<QueryProgramCodeResp> response = new JsonResult<>();
			response.setCode(0);
			response.setMessage("success");
			QueryProgramCodeResp resp = new QueryProgramCodeResp();
			resp.setProgramBasicInfo(programBasicInfo);
			response.setResult(resp);
			return response;
		} catch (Throwable e) {
			logger.error("调用获取节目代码服务失败" + e.getMessage(), e);
			return null;
		}
	}

	@Override
	public JsonResult<ProgramDetailResp> bindProgramCode(String progcode) {

		try {

			ProgramDetailResp resp = new ProgramDetailResp();

			// 获取节目代码地址
			programcodeAddr = System.getProperty("es.title.programcode.url");
			port = _ceService.getCEPort(new URL(programcodeAddr));

			SetProgramStatusRequest request = new SetProgramStatusRequest();
			request.setProgramCode(progcode);
			request.setStatus(1);
			SetProgramStatusResponse statusResponse = port.setProgramStatus(request);
			logger.info("绑节目代码返回结果：" + statusResponse.getResult() + "==描述：" + statusResponse.getDescription());

			resp.setProgramCode(progcode);
			GetProgramRequest getProgramrequest = new GetProgramRequest();
			getProgramrequest.setProgramCode(progcode);
			ProgramType[] programs = port.getProgram(getProgramrequest);
			if (null != programs && programs.length > 0) {
				resp.setDuration(programs[0].getLength());
				resp.setPlanAirTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(programs[0].getEditCloseTime()));
				resp.setProgramName(programs[0].getProgramName());
				resp.setProgramType(programs[0].getProgramType());
				resp.setChannelID(programs[0].getChannelName());
				resp.setProgramStatus(programs[0].getStatus() + "");
			}
			JsonResult<ProgramDetailResp> response = new JsonResult<>();
			response.setCode(0);
			response.setMessage("success");
			response.setResult(resp);
			return response;
		} catch (Throwable e) {
			logger.error("调用服务绑定节目代码失败" + e.getMessage(), e);
			return null;
		}
	}

	@Override
	public JsonResult<ProgramDetailResp> unbindProgramCode(String progcode) {
		try {
			programcodeAddr = System.getProperty("es.title.programcode.url");
			port = _ceService.getCEPort(new URL(programcodeAddr));

			SetProgramStatusRequest request = new SetProgramStatusRequest();
			request.setProgramCode(progcode);
			request.setStatus(0);
			SetProgramStatusResponse statusResponse = port.setProgramStatus(request);
			logger.info("解绑节目代码返回结果：" + statusResponse.getResult() + "==描述：" + statusResponse.getDescription());
			JsonResult<ProgramDetailResp> response = new JsonResult<>();
			response.setCode(0);
			response.setMessage("success");
			return response;
		} catch (Throwable e) {
			logger.error("解绑服务绑定节目代码失败" + e.getMessage(), e);
			return null;
		}
	}

	@Autowired
	ReadFileUtils _readFile;
	
	@Override
	public JsonResult<QueryProgramCodeResp> getProgramBasic() {
		JsonResult<QueryProgramCodeResp> results = new JsonResult<>();
		try {
			List<ProgramBasic> lists  = _readFile.getProgramBasic();
			results.setCode(0);
			results.setMessage("成功了");
			QueryProgramCodeResp resp = new QueryProgramCodeResp();
			resp.setProgramBasicInfo(lists);
			results.setResult(resp);
			String result = new ObjectMapper().writeValueAsString(results);
			logger.debug("test--JSON:"+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
}
