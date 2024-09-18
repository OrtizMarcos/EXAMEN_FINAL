package ucom.py.entity;

// Defino la clase Cliente
public class Cliente {

    // Atributos privados de la clase Cliente
    private Integer idCliente;  // Identificador único del cliente
    private String nombres;     // Nombres del cliente
    private String apellidos;   // Apellidos del cliente

    // Constructor de la clase Cliente que inicializa los atributos
    public Cliente(Integer idCliente, String nombres, String apellidos) {
        this.idCliente = idCliente;       // Asigna el ID del cliente
        this.nombres = nombres;           // Asigna los nombres del cliente
        this.apellidos = apellidos;       // Asigna los apellidos del cliente
    }

    // Métodos Getter y Setter para acceder y modificar los atributos

    // Obtiene el valor de idCliente
    public Integer getIdCliente() {
        return idCliente;
    }

    // Establece el valor de idCliente
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    // Obtiene el valor de nombres
    public String getNombres() {
        return nombres;
    }

    // Establece el valor de nombres
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Obtiene el valor de apellidos
    public String getApellidos() {
        return apellidos;
    }

    // Establece el valor de apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
