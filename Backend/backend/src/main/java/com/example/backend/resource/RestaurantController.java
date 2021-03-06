package com.example.backend.resource;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.modal.Restaurants;
import com.example.backend.repository.RestaurantRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value="/")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository repository;
	
	@PostMapping(value="saveRestaurant")
	public ResponseEntity<Restaurants> saveRestaurant(@RequestBody Restaurants restaurant) {
		try {
			Restaurants rest = repository.save(restaurant);
			return new ResponseEntity<>(rest, HttpStatus.CREATED);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("getAll")
    public ResponseEntity<List<Restaurants>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
	
	@RequestMapping(value="getRestaurants", method = RequestMethod.GET)
	public List<Restaurants> getRestaurants(){
		List<Restaurants> rest = repository.findAll();
		System.out.println("hi");
		return rest;
		
	}
	@GetMapping("/getRestaurant/{id}")
	public Optional<Restaurants> getRestaurant(@PathVariable ObjectId id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRestaurant(@PathVariable ObjectId id) {
		repository.deleteById(id);
		return "deleted restaurant";
	}
	
}












