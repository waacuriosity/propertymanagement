package com.property.mgt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.property.mgt.domain.Client;
import com.property.mgt.repository.ClientRepository;
import com.property.mgt.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return (List<Client>)clientRepository.findAll();
	}

}
