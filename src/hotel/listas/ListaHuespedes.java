package hotel.listas;

import hotel.modelos.Huesped;
import hotel.modelos.CheckIn;
import hotel.modelos.Habitacion;

public class ListaHuespedes {
    private NodoHuesped CAB;

    public ListaHuespedes() {
        this.CAB = null;
    }

    public void agregarHuesped(Huesped huesped, Habitacion habitacion) {
        CheckIn checkIn = new CheckIn(huesped, habitacion);
        NodoHuesped nuevoHuesped = new NodoHuesped(huesped, checkIn);
        if (CAB == null) {
            CAB = nuevoHuesped;
        } else {
            NodoHuesped actual = CAB;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoHuesped;
        }
    }

    public void mostrarHuespedes() {
        NodoHuesped actual = CAB;
        while (actual != null) {
            System.out.println("Huésped: " + actual.huesped.getNombre());
            actual.checkIn.mostrarFactura(); // Mostrar la factura de cada huésped
            actual = actual.siguiente;
        }
    }

    private class NodoHuesped {
        private Huesped huesped;
        private CheckIn checkIn;
        private NodoHuesped siguiente;

        public NodoHuesped(Huesped huesped, CheckIn checkIn) {
            this.huesped = huesped;
            this.checkIn = checkIn;
            this.siguiente = null;
        }
    }
}
