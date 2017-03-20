package com.property.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.property.mgt.domain.Client;
import com.property.mgt.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	// Used for displaying clients

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String listClients(Model model) {
		List<Client> clientList = clientService.findAll();
		model.addAttribute("clientList", clientList);
		return "clients";
	}

	// display add client form

	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String inputClient() {
		return "addClients";
	}

	// Save the client
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("client") Client client, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "addClients";
		}

		// do the try catch exception handling later
		clientService.save(client);

		redirectAttributes.addFlashAttribute("client", client);

		return "redirect:/clientDetails";
	}

	// Display the details of a saved client

	@RequestMapping(value = "/clientDetails", method = RequestMethod.GET)
	public String displayClientDetails() {
		return "clientDetails";
	}

}
