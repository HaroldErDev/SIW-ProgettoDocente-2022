package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.BuffetService;

@Controller
public class BuffetController {
	
	@Autowired
	private BuffetService buffetService;
}