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

    private List<PresupuestoMensual> presupuestos = new ArrayList<>();

    // Constructor para agregar datos iniciales
    public PresupuestoRepository() {
        // Agregar algunos presupuestos de ejemplo
        presupuestos.add(new PresupuestoMensual() {{
            setIdPresupuesto(1);
            setFechaInicio(LocalDate.of(2024, 1, 1));
            setFechaFin(LocalDate.of(2024, 12, 31));
            setSaldoInicial(1000);
            setSaldoFinal(800);
            setEstado("Activo");
            setIdCliente(1);
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

    public long countPresupuestos() {
        return presupuestos.size();
    }

    public List<PresupuestoMensual> findByRango(Integer rangoInicial, Integer rangoFinal) {
        return presupuestos.stream()
                .filter(p -> p.getSaldoInicial() >= rangoInicial && p.getSaldoFinal() <= rangoFinal)
                .collect(Collectors.toList());
    }

    public List<PresupuestoMensual> findMaxSaldoFinal() {
        if (presupuestos.isEmpty()) {
            return Collections.emptyList();
        }
        int maxSaldoFinal = presupuestos.stream()
                .mapToInt(PresupuestoMensual::getSaldoFinal)
                .max()
                .orElse(0);
        return presupuestos.stream()
                .filter(p -> p.getSaldoFinal() == maxSaldoFinal)
                .collect(Collectors.toList());
    }
}
