package hotel.listas;

import hotel.modelos.Servicio;

public class ListaServicios {
    private Servicio CAB;

    public void agregarServicio(String codigo, String nombre, double precio) {
        Servicio nuevo = new Servicio(codigo, nombre, precio);
        if (CAB == null) {
            CAB = nuevo;
        } else {
            Servicio actual = CAB;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void mostrarServicios() {
        Servicio actual = CAB;
        while (actual != null) {
            System.out.println("Código: " + actual.getCodigo() +
                    " | Nombre: " + actual.getNombre() +
                    " | Precio: $" + actual.getPrecio());
            actual = actual.siguiente;
        }
    }
}
