package com.job.time.tracker.exception;



import com.job.time.tracker.dto.ErrorDTO;
import com.job.time.tracker.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(NotFoundException notFoundException){
		
		final ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setDescription(notFoundException.getMessage());
		errorDTO.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		
		final List<ErrorDTO> errorList = new ArrayList<>();
		errorList.add(errorDTO);
		
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setResponse(null);
		responseDTO.setStatus(HttpStatus.NOT_FOUND.value());
		responseDTO.setSuccess(false);
		responseDTO.setErrors(errorList);
		
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(){

		final ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		
		final List<ErrorDTO> errorList = new ArrayList<>();
		errorList.add(errorDTO);
		
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setResponse(null);
		responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseDTO.setSuccess(false);
		responseDTO.setErrors(errorList);
		
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ResponseDTO> customException( BusinessException businessException ){
		final ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDTO.setDescription(businessException.getMessage());
		
		final List<ErrorDTO> errorList = new ArrayList<>();
		errorList.add(errorDTO);
		
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setResponse(null);
		responseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		responseDTO.setSuccess(false);
		responseDTO.setErrors(errorList);
		
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);
	}

}
