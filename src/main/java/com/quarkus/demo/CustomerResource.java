package com.quarkus.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> findCustomers() {
		return Customer.listAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) 
	public Customer newCustomer(Customer customer) {
		customer.id= null;
		customer.persist();
		return customer;
		
	}
}
