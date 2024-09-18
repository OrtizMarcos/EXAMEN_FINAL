package ucom.py.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ucom.py.entity.PresupuestoMensual;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PresupuestoRepository {

    // Defino una lista en memoria para almacenar los presupuestos
    private List<PresupuestoMensual> presupuestos = new ArrayList<>();

    // Constructor donde inicializo algunos presupuestos de ejemplo
    public PresupuestoRepository() {
        // Agrego manualmente presupuestos con valores iniciales
        presupuestos.add(new PresupuestoMensual() {{
            setIdPresupuesto(1);  // Establezco el ID del presupuesto
            setFechaInicio(LocalDate.of(2024, 1, 1));  // Defino la fecha de inicio
            setFechaFin(LocalDate.of(2024, 12, 31));   // Defino la fecha de fin
            setSaldoInicial(1000);   // Establezco el saldo inicial
            setSaldoFinal(800);      // Establezco el saldo final
            setEstado("Activo");     // Asigno el estado del presupuesto
            setIdCliente(1);         // Asocio el presupuesto con un cliente
        }});
        presupuestos.add(new PresupuestoMensual() {{
            setIdPresupuesto(2);
            setFechaInicio(LocalDate.of(2024, 1, 1));
            setFechaFin(LocalDate.of(2024, 6, 30));
            setSaldoInicial(1500);
            setSaldoFinal(1000);
            setEstado("Activo");
            setIdCliente(2);
        }});
        presupuestos.add(new PresupuestoMensual() {{
            setIdPresupuesto(3);
            setFechaInicio(LocalDate.of(2024, 7, 1));
            setFechaFin(LocalDate.of(2024, 12, 31));
            setSaldoInicial(1200);
            setSaldoFinal(1100);
            setEstado("Cerrado");
            setIdCliente(1);
        }});
        presupuestos.add(new PresupuestoMensual() {{
            setIdPresupuesto(4);
            setFechaInicio(LocalDate.of(2024, 1, 1));
            setFechaFin(LocalDate.of(2024, 12, 31));
            setSaldoInicial(2000);
            setSaldoFinal(1900);
            setEstado("Activo");
            setIdCliente(3);
        }});
    }

    // Método para contar la cantidad de presupuestos
    public long countPresupuestos() {
        return presupuestos.size();  // Devuelvo el tamaño de la lista de presupuestos
    }

    // Método para buscar presupuestos dentro de un rango de saldo
    public List<PresupuestoMensual> findByRango(Integer rangoInicial, Integer rangoFinal) {
        // Filtro los presupuestos que estén dentro del rango indicado
        return presupuestos.stream()
                .filter(p -> p.getSaldoInicial() >= rangoInicial && p.getSaldoFinal() <= rangoFinal)
                .collect(Collectors.toList());  // Devuelvo la lista filtrada
    }

    // Método para encontrar el presupuesto con el saldo final más alto
    public List<PresupuestoMensual> findMaxSaldoFinal() {
        // Si no hay presupuestos, devuelvo una lista vacía
        if (presupuestos.isEmpty()) {
            return Collections.emptyList();
        }
        // Encuentro el saldo final más alto entre los presupuestos
        int maxSaldoFinal = presupuestos.stream()
                .mapToInt(PresupuestoMensual::getSaldoFinal)
                .max()
                .orElse(0);  // Si no hay máximo, uso 0 por defecto
        // Filtro los presupuestos que tienen ese saldo final máximo
        return presupuestos.stream()
                .filter(p -> p.getSaldoFinal() == maxSaldoFinal)
                .collect(Collectors.toList());
    }
}
