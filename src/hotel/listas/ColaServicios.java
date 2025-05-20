package hotel.listas;

import hotel.modelos.Huesped;

public class ColaServicios {
    private NodoColaServicios CAB;
    private NodoColaServicios cola;
    private int capacidadMaxima;

    public ColaServicios(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.CAB = null;
        this.cola = null;
    }

    public boolean agregarHuesped(Huesped huesped) {
        if (getNumeroEnEspera() < capacidadMaxima) {
            NodoColaServicios nuevo = new NodoColaServicios(huesped);
            if (cola == null) {
                CAB = nuevo;
                cola = nuevo;
            } else {
                cola.siguiente = nuevo;
                cola = nuevo;
            }
            return true; // Se pudo agregar
        } else {
            return false; // No hay espacio
        }
    }

    public Huesped atenderHuesped() {
        if (CAB != null) {
            Huesped huespedAtendido = CAB.huesped;
            CAB = CAB.siguiente;
            if (CAB == null) {
                cola = null; // La cola está vacía
            }
            return huespedAtendido;
        }
        return null;
    }

    private int getNumeroEnEspera() {
        int count = 0;
        NodoColaServicios actual = CAB;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    // Nodo interno para la cola
    private class NodoColaServicios {
        private Huesped huesped;
        private NodoColaServicios siguiente;

        public NodoColaServicios(Huesped huesped) {
            this.huesped = huesped;
            this.siguiente = null;
        }
    }
}
