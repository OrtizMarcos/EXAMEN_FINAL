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

    // Inyecto el repositorio de presupuestos
    @Inject
    PresupuestoRepository presupuestoRepository;

    // Inyecto el repositorio de clientes
    @Inject
    ClienteRepository clienteRepository;

    // Endpoint para contar la cantidad de presupuestos
    @GET
    @Path("/presupuestos/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response contarPresupuestos() {
        long count = presupuestoRepository.countPresupuestos();  // Llamo al método del repositorio para contar los presupuestos
        return Response.ok(count).build();  // Devuelvo la respuesta con la cantidad
    }

    // Endpoint para filtrar presupuestos por un rango de montos
    @GET
    @Path("/presupuestos-mensual/{rangoInicial}/{rangoFinal}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorRango(@PathParam("rangoInicial") Integer rangoInicial, @PathParam("rangoFinal") Integer rangoFinal) {
        // Llamo al repositorio para buscar los presupuestos que se encuentran en el rango de saldo especificado
        List<PresupuestoMensual> resultados = presupuestoRepository.findByRango(rangoInicial, rangoFinal);
        
        // Si no se encuentran presupuestos, devuelvo un mensaje 404
        if (resultados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron presupuestos en el rango especificado")
                    .build();
        }
        // Si se encuentran presupuestos, los devuelvo en la respuesta
        return Response.ok(resultados).build();
    }

    // Endpoint para obtener el presupuesto con el saldo final más alto
    @GET
    @Path("/presupuestos-mensual/mayor-presupuesto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMaxSaldoFinal() {
        // Llamo al repositorio para obtener el presupuesto con el saldo final más alto
        List<PresupuestoMensual> resultados = presupuestoRepository.findMaxSaldoFinal();
        
        // Si no hay presupuestos disponibles, devuelvo un mensaje 404
        if (resultados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron presupuestos")
                    .build();
        }
        // Devuelvo la lista de presupuestos con el saldo más alto
        return Response.ok(resultados).build();
    }

    // Endpoint para buscar clientes por nombres o apellidos
    @GET
    @Path("/clientes/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientes(@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos) {
        // Llamo al repositorio para buscar los clientes que coincidan con el nombre o apellido
        List<Cliente> clientes = clienteRepository.buscarClientes(nombres, apellidos);
        return Response.ok(clientes).build();  // Devuelvo la lista de clientes encontrados
    }
}
