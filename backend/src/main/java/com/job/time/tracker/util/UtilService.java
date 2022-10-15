package com.job.time.tracker.util;


import com.job.time.tracker.dto.ResponseDTO;

public class UtilService {
	
	public static ResponseDTO getResponseDTO() {
		final ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setStatus(200);
		responseDTO.setSuccess(true);
		
		return responseDTO;
	}
	
	

}
