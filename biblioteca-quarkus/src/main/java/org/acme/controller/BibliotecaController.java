package org.acme.controller;

import java.util.List;

import java.util.Optional;

import org.acme.model.Biblioteca;
import org.acme.service.BibliotecaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/biblioteca")
public class BibliotecaController {

	@Inject
	BibliotecaService bibliotecaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterLista(){
		return Response.ok(bibliotecaService.obterNomes()).build();
	}
	@POST@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response incluir(Biblioteca biblioteca) {
		System.out.println("1");
		biblioteca.persist();
		System.out.println("2");
		return Response.status(Response.Status.CREATED).entity(biblioteca).build();
	}
}
