package com.citibanamex.bne.jdbcserver.errohandling;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ErrorResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorResolver.class);
	
	public static final String HTTPMESSAGENOTREADABLEEXCEPTION_ERROR_CODE = "PME-410";
	public static final String METHODARGUMENTNOTVALIDEXCEPTION_ERROR_CODE = "PME-411";
	public static final String SQLEXCEPTION_ERROR_CODE = "PME-420";
	public static final String BADSQLGRAMMAREXCEPTION_ERROR_CODE = "PME-422";
	public static final String EXCEPTION_ERROR_CODE = "PME-500";
	public static final String UNCATEGORIZEDSQLEXCEPTION_ERROR_CODE ="PME-522";
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse resolveException(HttpServletRequest req, Exception e) {
		logger.error(e.getMessage(), e);

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.FATAL.name());
		errorResponse.setCode(EXCEPTION_ERROR_CODE);
		errorResponse.setDetails(e.getMessage());

		return errorResponse;
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse resolveUncategorizedSqlException(HttpServletRequest request, SQLException e) {
		logger.error(e.getMessage(), e);

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(SQLEXCEPTION_ERROR_CODE);
		errorResponse.setDetails(e.getMessage());

		return errorResponse;
	}
	
	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse resolveBadSqlGrammarException(HttpServletRequest req, BadSqlGrammarException e) {
		logger.error(e.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(BADSQLGRAMMAREXCEPTION_ERROR_CODE);
		errorResponse.setDetails(e.getMessage());

		return errorResponse;
	}
	
	@ExceptionHandler(UncategorizedSQLException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse resolveUncategorizedSqlException(HttpServletRequest request,
			UncategorizedSQLException e) {
		logger.error(e.getMessage(), e);

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(UNCATEGORIZEDSQLEXCEPTION_ERROR_CODE);
		errorResponse.setDetails(e.getMessage());

		return errorResponse;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse resolveHttpMessageNotReadableException(HttpServletRequest req,
			HttpMessageNotReadableException e) {
		logger.error(e.getMessage(), e);

		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(HTTPMESSAGENOTREADABLEEXCEPTION_ERROR_CODE);
		errorResponse.setDetails(e.getMessage());

		return errorResponse;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
			MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(METHODARGUMENTNOTVALIDEXCEPTION_ERROR_CODE);

		Map<String, List<String>> groupedErrors = new HashMap<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String message = fieldError.getDefaultMessage();
			String field = fieldError.getField();

			List<String> fieldsByMessage = groupedErrors.get(message);
			if (fieldsByMessage == null) {
				fieldsByMessage = new ArrayList<>();
				groupedErrors.put(message, fieldsByMessage);
			}
			fieldsByMessage.add(field);
		}

		if (!groupedErrors.isEmpty()) {
			errorResponse.setDetails(groupedErrors.toString());
		}

		return errorResponse;
	}

}