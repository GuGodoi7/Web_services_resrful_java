package br.com.fiap.megafarma.controller;

import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.Remedio;
import br.com.fiap.megafarma.model.repository.RemedioRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/megafarma")
public class RemedioResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Remedio> resposta = RemedioRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Remedio remedio) {
		Remedio resposta = RemedioRepository.save(remedio);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); // 201 - Created
		} else {
			response = Response.status(400); // 400 - Bad Request
		}
		response.entity(resposta);
		return response.build();
	}
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (RemedioRepository.delete(id)) {
			ResponseBuilder response = Response.noContent(); // 204 - No Content
			return response.build(); 
		} else {
			ResponseBuilder response = Response.status(400);
			return response.build();
		}
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Remedio remedio) {
		Remedio resposta = RemedioRepository.update(remedio);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} 
		else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
}

