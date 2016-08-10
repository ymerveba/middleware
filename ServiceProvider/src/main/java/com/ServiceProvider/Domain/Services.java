package com.ServiceProvider.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Services implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@Column(name = "id")
int id;

@Column(name = "service_name")
String serviceName;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getServiceName() {
	return serviceName;
}

public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}

@Override
public String toString() {
	return "Services [id=" + id + ", serviceName=" + serviceName + "]";
}





}
