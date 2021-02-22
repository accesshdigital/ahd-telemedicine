package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Vital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private ArrayList<String> identifier;
	private String weight;
	private String height;
	private String generalExamination;


	

	
}
