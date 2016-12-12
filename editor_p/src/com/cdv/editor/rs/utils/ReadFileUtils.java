package com.cdv.editor.rs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cdv.editor.rs.program.ProgramBasic;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReadFileUtils {
	
	@Value("classpath:test.json")
	protected Resource _programBasic;
	
	public List<ProgramBasic> getProgramBasic() throws IOException{
		
		ObjectMapper _mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		_mapper.setDateFormat(df);
		List<ProgramBasic> basics = new ArrayList<>();
		try (InputStream ins = _programBasic.getInputStream()) {
			ProgramBasic[] programs = _mapper.readValue(ins, ProgramBasic[].class);
			for (ProgramBasic programBasic : programs) {
				basics.add(programBasic);
			}
		}
		return basics;
	}
	
	
	public static void main(String[] args) {
		
	}
}
