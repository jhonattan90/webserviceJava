package br.edu.opet.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.opet.controller.ChamadoController;
import br.edu.opet.dto.ChamadoDTO;
import br.edu.opet.model.Chamado;

@Path("/chamado")
public class ChamadoWebService {
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO cadastrar(Chamado pChamado) {
		return ChamadoController.cadastrar(pChamado);
	}

	@GET
	@Path("/Recuperar/{idChamado}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO recuperar(@PathParam("idChamado") int pIdChamado) {
		return ChamadoController.recuperar(pIdChamado);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO atualizar(Chamado pAluno) {
		return ChamadoController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idChamado}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO remover(@PathParam("idChamado") int pChamado) {
		return ChamadoController.remover(pChamado);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO pesquisar() {
		return ChamadoController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChamadoDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return ChamadoController.pesquisarPorNome(pNome);
	}
}
