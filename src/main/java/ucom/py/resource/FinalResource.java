package ucom.py.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ucom.py.entity.Cliente;
import ucom.py.entity.PresupuestoMensual;
import ucom.py.repository.ClienteRepository;
import ucom.py.repository.PresupuestoRepository;

import java.util.List;

@Path("/final")
public class FinalResource {

    @Inject
    PresupuestoRepository presupuestoRepository;

    @Inject
    ClienteRepository clienteRepository;

    // Contador de presupuestos
    @GET
    @Path("/presupuestos/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response contarPresupuestos() {
        long count = presupuestoRepository.countPresupuestos();
        return Response.ok(count).build();
    }

    // Filtrar presupuestos por rango de montos
    @GET
    @Path("/presupuestos-mensual/{rangoInicial}/{rangoFinal}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorRango(@PathParam("rangoInicial") Integer rangoInicial, @PathParam("rangoFinal") Integer rangoFinal) {
        List<PresupuestoMensual> resultados = presupuestoRepository.findByRango(rangoInicial, rangoFinal);
        if (resultados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron presupuestos en el rango especificado").build();
        }
        return Response.ok(resultados).build();
    }

    // Obtener el presupuesto más alto
    @GET
    @Path("/presupuestos-mensual/mayor-presupuesto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMaxSaldoFinal() {
        List<PresupuestoMensual> resultados = presupuestoRepository.findMaxSaldoFinal();
        if (resultados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron presupuestos").build();
        }
        return Response.ok(resultados).build();
    }

    // Buscar clientes por nombres o apellidos
    @GET
    @Path("/clientes/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientes(@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos) {
        List<Cliente> clientes = clienteRepository.buscarClientes(nombres, apellidos);
        return Response.ok(clientes).build();
    }
}
