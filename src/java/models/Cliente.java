package models;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private double salario;

    public double getSalario() {
        return salario;
    }
    public Cliente(int id, String nombre, String direccion, String correo, String telefono, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.salario = salario;
    }

    
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", salario=" + salario + '}';
    }
    
    
}
