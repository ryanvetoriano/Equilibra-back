package br.com.fiap.resource;

import br.com.fiap.bo.CategoriaBO;
import br.com.fiap.model.Categoria;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaBO bo;

    @GET
    public List<Categoria> listar() { return bo.listar(); }

    @GET
    @Path("/{id}")
    public Categoria buscar(@PathParam("id") Long id) { return bo.buscar(id); }

    @POST
    @Transactional
    public Response salvar(Categoria c) {
        bo.salvar(c);
        return Response.status(Response.Status.CREATED).entity(c).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean ok = bo.deletar(id);
        return ok ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
