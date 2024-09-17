package ucom.py.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ucom.py.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        // Agregar algunos clientes de ejemplo
        clientes.add(new Cliente(1, "Juan", "Perez"));
        clientes.add(new Cliente(2, "María", "Gomez"));
        clientes.add(new Cliente(3, "Carlos", "Garcia"));
        clientes.add(new Cliente(4, "Ana", "Martinez"));
    }

    public List<Cliente> buscarClientes(String nombres, String apellidos) {
        return clientes.stream()
                .filter(c -> (nombres == null || c.getNombres().toLowerCase().contains(nombres.toLowerCase())) &&
                             (apellidos == null || c.getApellidos().toLowerCase().contains(apellidos.toLowerCase())))
                .collect(Collectors.toList());
    }
}
