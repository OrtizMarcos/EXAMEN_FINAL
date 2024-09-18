package ucom.py.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ucom.py.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteRepository {

    // Defino una lista para almacenar los clientes en memoria
    private List<Cliente> clientes = new ArrayList<>();

    // Constructor donde agrego algunos clientes de ejemplo al iniciar el repositorio
    public ClienteRepository() {
        // Agrego manualmente algunos clientes con ID, nombres y apellidos
        clientes.add(new Cliente(1, "Juan", "Perez"));
        clientes.add(new Cliente(2, "María", "Gomez"));
        clientes.add(new Cliente(3, "Carlos", "Garcia"));
        clientes.add(new Cliente(4, "Ana", "Martinez"));
    }

    // Método para buscar clientes por nombre y apellido
    public List<Cliente> buscarClientes(String nombres, String apellidos) {
        // Filtro la lista de clientes en base a los parámetros de búsqueda.
        // Si no se pasa el nombre o apellido, no aplico el filtro correspondiente
        return clientes.stream()
                .filter(c -> (nombres == null || c.getNombres().toLowerCase().contains(nombres.toLowerCase())) &&
                             (apellidos == null || c.getApellidos().toLowerCase().contains(apellidos.toLowerCase())))
                .collect(Collectors.toList());  // Devuelvo la lista filtrada
    }
}
