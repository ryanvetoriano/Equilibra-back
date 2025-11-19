package br.com.fiap.resource;

import br.com.fiap.bo.TarefaBO;
import br.com.fiap.model.Tarefa;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tarefas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarefaResource {

    @Inject
    TarefaBO bo;

    @GET
    public List<Tarefa> listar() { return bo.listar(); }

    @GET
    @Path("/{id}")
    public Tarefa buscar(@PathParam("id") Long id) { return bo.buscar(id); }

    @POST
    @Transactional
    public Response salvar(Tarefa tarefa) {
        bo.salvar(tarefa);
        return Response.status(Response.Status.CREATED).entity(tarefa).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Tarefa data) {
        Tarefa t = bo.buscar(id);
        if (t == null) return Response.status(Response.Status.NOT_FOUND).build();
        t.titulo = data.titulo;
        t.descricao = data.descricao;
        t.duracaoMin = data.duracaoMin;
        t.dataTarefa = data.dataTarefa;
        t.usuario = data.usuario;
        t.categoria = data.categoria;
        bo.salvar(t);
        return Response.ok(t).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean ok = bo.deletar(id);
        return ok ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/usuario/{idUsuario}")
    public List<Tarefa> listarPorUsuario(@PathParam("idUsuario") Long idUsuario) {
        return bo.listarPorUsuario(idUsuario);
    }
}
