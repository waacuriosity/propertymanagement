package com.property.mgt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="person_id")
public class PersonOwner extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long personOwnerId;

	public long getPersonOwnerId() {
		return personOwnerId;
	}

	public void setPersonOwnerId(long personOwnerId) {
		this.personOwnerId = personOwnerId;
	}
	
	

}
