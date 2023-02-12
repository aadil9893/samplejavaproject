package com.coachingclass.AadilClasses.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coachingclass.AadilClasses.model.Seller;
import com.coachingclass.AadilClasses.repository.SellerRepo;

@Service
public class SellerService {

	
	@Autowired
	private SellerRepo sellerRepo;
	
	
	public Seller registerSeller(@RequestBody Seller seller) {
		return sellerRepo.save(seller);
	}
	
	public List<Seller>getSeller(){
		return (List<Seller>) sellerRepo.findAll();
	}
	
}
