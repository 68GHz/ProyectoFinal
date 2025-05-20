package hotel.modelos;

public class Servicio {
    public Servicio siguiente;
    private String codigo;
    private String nombre;
    private double precio;

    public Servicio(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
