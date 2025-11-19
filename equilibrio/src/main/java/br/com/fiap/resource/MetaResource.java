package br.com.fiap.resource;

import br.com.fiap.bo.MetaBO;
import br.com.fiap.model.Meta;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/metas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MetaResource {

    @Inject
    MetaBO bo;

    @GET
    public List<Meta> listar() { return bo.listar(); }

    @GET
    @Path("/{id}")
    public Meta buscar(@PathParam("id") Long id) { return bo.buscar(id); }

    @POST
    @Transactional
    public Response salvar(Meta m) {
        bo.salvar(m);
        return Response.status(Response.Status.CREATED).entity(m).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean ok = bo.deletar(id);
        return ok ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
