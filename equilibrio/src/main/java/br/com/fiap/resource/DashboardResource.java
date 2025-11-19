package br.com.fiap.resource;

import br.com.fiap.model.Tarefa;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

@Path("/dashboard")
@Produces(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @GET
    @Path("/{idUsuario}")
    @Transactional
    public Map<String, Integer> resumoPorTipo(@PathParam("idUsuario") Long idUsuario) {
        List<Object[]> results = Tarefa.getEntityManager()
            .createQuery("SELECT c.tipo, SUM(t.duracaoMin) FROM Tarefa t JOIN t.categoria c WHERE t.usuario.idUsuario = :id GROUP BY c.tipo")
            .setParameter("id", idUsuario)
            .getResultList();

        Map<String, Integer> map = new HashMap<>();
        for (Object[] r : results) {
            map.put((String) r[0], ((Number) r[1]).intValue());
        }
        return map;
    }

    @GET
    @Path("/{idUsuario}/mensagem")
    @Transactional
    public Map<String, String> mensagem(@PathParam("idUsuario") Long idUsuario) {
        Number trabalho = (Number) Tarefa.getEntityManager()
            .createQuery("SELECT SUM(t.duracaoMin) FROM Tarefa t JOIN t.categoria c WHERE t.usuario.idUsuario=:id AND c.tipo='TRABALHO'")
            .setParameter("id", idUsuario)
            .getSingleResult();

        Number pessoal = (Number) Tarefa.getEntityManager()
            .createQuery("SELECT SUM(t.duracaoMin) FROM Tarefa t JOIN t.categoria c WHERE t.usuario.idUsuario=:id AND c.tipo='PESSOAL'")
            .setParameter("id", idUsuario)
            .getSingleResult();

        int t = trabalho == null ? 0 : trabalho.intValue();
        int p = pessoal == null ? 0 : pessoal.intValue();
        String msg = (p == 0 || t > p * 2)
            ? "Você está dedicando muito tempo ao trabalho. Faça pausas!"
            : "Ótimo equilíbrio!";
        return Map.of("mensagem", msg);
    }
}
