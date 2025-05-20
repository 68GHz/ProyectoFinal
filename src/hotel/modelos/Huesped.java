package hotel.modelos;

public class Huesped {
    private String documento;
    private String nombre;
    private int edad;
    private String genero;

    public Huesped(String documento, String nombre, int edad, String genero) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }
}
