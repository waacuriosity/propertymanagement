package com.property.mgt.service;

import java.util.List;

import com.property.mgt.domain.Client;

public interface ClientService {

	List<Client> findAll();

	void save(Client client);

}
