package ucom.py.entity;

import java.time.LocalDate;

// Definición de la clase PresupuestoMensual
public class PresupuestoMensual {

    // Atributos privados de la clase PresupuestoMensual
    private Integer idPresupuesto;  // Identificador único del presupuesto mensual
    private LocalDate fechaInicio;  // Fecha de inicio del presupuesto
    private LocalDate fechaFin;     // Fecha de finalización del presupuesto
    private Integer saldoInicial;   // Saldo inicial asignado al presupuesto
    private Integer saldoFinal;     // Saldo final calculado al cierre del presupuesto
    private String estado;          // Estado del presupuesto (por ejemplo, activo o inactivo)
    private Integer idCliente;      // Identificador del cliente asociado a este presupuesto

    // Métodos Getter y Setter para acceder y modificar los atributos

    // Obtiene el valor de idPresupuesto
    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    // Establece el valor de idPresupuesto
    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    // Obtiene la fecha de inicio del presupuesto
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    // Establece la fecha de inicio del presupuesto
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // Obtiene la fecha de finalización del presupuesto
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    // Establece la fecha de finalización del presupuesto
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Obtiene el saldo inicial del presupuesto
    public Integer getSaldoInicial() {
        return saldoInicial;
    }

    // Establece el saldo inicial del presupuesto
    public void setSaldoInicial(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    // Obtiene el saldo final del presupuesto
    public Integer getSaldoFinal() {
        return saldoFinal;
    }

    // Establece el saldo final del presupuesto
    public void setSaldoFinal(Integer saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    // Obtiene el estado del presupuesto (activo, inactivo, etc.)
    public String getEstado() {
        return estado;
    }

    // Establece el estado del presupuesto
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Obtiene el identificador del cliente asociado al presupuesto
    public Integer getIdCliente() {
        return idCliente;
    }

    // Establece el identificador del cliente asociado al presupuesto
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
