package com.coachingclass.AadilClasses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coachingclass.AadilClasses.Service.SellerService;
import com.coachingclass.AadilClasses.model.Seller;
import com.coachingclass.AadilClasses.repository.SellerRepo;



@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RestController
@RequestMapping("/E-COMM")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerRepo sellerRepo;
	
	@PostMapping("/PostSellerdata")
	public Seller registerTeacher(@RequestBody Seller seller) {
		return sellerService.registerSeller(seller);
	}
	@GetMapping(path="/GetSellerdata")
	public List<Seller>getSellerr(){
		List<Seller> sellerList = new ArrayList<>();
		sellerList=	sellerService.getSeller();
		System.out.println("testing git");
		return sellerList;
				 
	}
	@GetMapping("/PullSellerdata/{email}/{password}")
	public ResponseEntity<Seller> getByEmailAndPassword(@PathVariable String email, @PathVariable String password){
		System.out.println("changes for commit");
		Seller seller = sellerRepo.findByEmailAndPassword(email, password);
		return ResponseEntity.ok().body(seller);
	}
	
	@GetMapping("/fetchSeller/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable Integer id){
		Seller getSell = sellerRepo.findById(id);
		return ResponseEntity.ok().body(getSell);
	}
}
