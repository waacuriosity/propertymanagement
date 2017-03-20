package com.property.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.property.mgt.domain.Client;
import com.property.mgt.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	public ClientController(){
		
	}
	
	// Used for displaying clients
	
	@RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
	public String listClients(Model model) {
		List<Client> clientList = clientService.findAll();
		model.addAttribute("clientList", clientList);
		return "clients";
	}
	
	// display add client form
	
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String addClient()
	
	
}
