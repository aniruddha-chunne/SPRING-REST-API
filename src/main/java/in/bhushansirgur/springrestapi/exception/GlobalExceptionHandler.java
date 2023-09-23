package in.bhushansirgur.springrestapi.exception;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler 
{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		
		Map<String, Object> body = new LinkedHashMap();
		body.put("timeStamps", System.currentTimeMillis());
		body.put("status", status.value());
		
		//get all the errors
		
		List<String> errors = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(x -> x.getDefaultMessage())
								.collect(Collectors.toList());
		
		body.put("errors", errors);
		
		return new ResponseEntity<Object>(body, status);
	}
	
}
