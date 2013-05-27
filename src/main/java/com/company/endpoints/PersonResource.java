package com.company.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.company.domain.Person;
import com.company.service.DefaultService;
import com.sun.istack.logging.Logger;

@Path("/persons")
@Controller
public class PersonResource {
	@Autowired
	private DefaultService defaultSerice;
	
	@POST
	@Produces("application/json; charset=UTF-8")
	public Response addPerson(@QueryParam("firstname") String firstname,
							  @QueryParam("lastname") String lastname)  {
		Logger log = Logger.getLogger(PersonResource.class);
		
		try {
			defaultSerice.updateService(firstname, lastname);
			return Response.status(Status.CREATED).entity(new Person()).build();
		}catch(RuntimeException e) {
			//log.log(level, message)
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
		}
	}
}
