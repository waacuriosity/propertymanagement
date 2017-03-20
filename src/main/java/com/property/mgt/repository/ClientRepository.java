package com.property.mgt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.property.mgt.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, int> {

}
