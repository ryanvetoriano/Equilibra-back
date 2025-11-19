package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.model.Usuario;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioBO bo;

    @GET
    public List<Usuario> listar() { return bo.listar(); }

    @GET
    @Path("/{id}")
    public Usuario buscar(@PathParam("id") Long id) { return bo.buscar(id); }

    @POST
    @Transactional
    public Response salvar(Usuario u) {
        bo.salvarOuAtualizar(u);
        return Response.status(Response.Status.CREATED).entity(u).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Usuario u) {
        Usuario existente = bo.buscar(id);

        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNome(u.getNome());
        existente.setEmail(u.getEmail());
        existente.setSenha(u.getSenha());

        bo.salvarOuAtualizar(existente); // usa o mesmo método do POST para persistir

        return Response.ok(existente).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean ok = bo.deletar(id);
        return ok ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
