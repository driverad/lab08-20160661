package model.entity;

import java.util.Date;
import model.*;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Resource {

	@PrimaryKey
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String name;
	@Persistent
	private boolean status;
	@Persistent
	private Date created;

	public Resource(String name,  boolean status, Date created) {
		this.name = name;
		this.status = status;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
