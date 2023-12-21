package in.irctc.restControllerAdviceHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.irctc.error.ErrorDetails;
import in.irctc.exception.TouristNotFoundException;


@RestControllerAdvice
public class AdviceHandler {
	//for specific error
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails>handlingTuoristNotFound(TouristNotFoundException  tf)
	{
		ErrorDetails details=new ErrorDetails( LocalDateTime.now(),tf.getMessage(),"404-not found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	//for the general exception like sql syntax error 
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handlingTuoristNotFound1(Exception  e)
	{
		ErrorDetails details=new ErrorDetails( LocalDateTime.now(),e.getMessage(),"404-not found at");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
