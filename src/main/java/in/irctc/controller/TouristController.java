package in.irctc.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.irctc.model.Tourist;
import in.irctc.service.TouristService;

@RestController
@RequestMapping("/tourist")
public class TouristController {

	@Autowired
	private TouristService touristService;
	@PostMapping("/register")
	public ResponseEntity<String> touristRegistration(@RequestBody Tourist tourist)
	{
			touristService.registerTourist(tourist);
			
			
		return new ResponseEntity<String>("Registration is succesfull",HttpStatus.OK);
		
		
	}
	@GetMapping("/gettourist")
	public ResponseEntity<?> fetchTourist()
	{
		
			ArrayList<Tourist> l=touristService.fetchingTouristbyId();
			return new ResponseEntity<ArrayList<Tourist>>(l,HttpStatus.OK);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?>fetchById(@PathVariable("id") int id)
	{
		
			Tourist t=touristService.findById(id);
			
		return new ResponseEntity<Tourist>(t,HttpStatus.OK);
		
	}
	@PutMapping("/update/{id}")
	public  ResponseEntity<?>update(@RequestBody Tourist tourist,@PathVariable int id)
	{
	  Tourist t=touristService.updateTourist(id,tourist);
		return new ResponseEntity<Tourist>(t,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?>update(@PathVariable int id)
	{
		Tourist t=touristService.deleteTourist(id);
		return new ResponseEntity<Tourist>(t,HttpStatus.OK);
		
	}
}
