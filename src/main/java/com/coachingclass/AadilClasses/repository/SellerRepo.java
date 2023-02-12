package com.coachingclass.AadilClasses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coachingclass.AadilClasses.model.Seller;



@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {
	public List<Seller> findAll();
	public Optional<Seller> findById(Long id);
	
	public Seller findByEmailAndPassword(String email, String password);
	
	public Seller findById(Integer id);
}
