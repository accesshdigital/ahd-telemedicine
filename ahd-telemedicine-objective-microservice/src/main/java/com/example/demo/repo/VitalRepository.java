package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vital;



	public interface VitalRepository extends JpaRepository<Vital, Integer>{  

}
