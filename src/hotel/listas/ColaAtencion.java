package hotel.listas;

import hotel.modelos.Huesped;

public class ColaAtencion {
    private NodoCola CAB;
    private NodoCola cola;

    public ColaAtencion() {
        this.CAB = null;
        this.cola = null;
    }

    public void agregarHuesped(Huesped huesped) {
        NodoCola nuevo = new NodoCola(huesped);
        if (cola == null) {
            CAB = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
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

    // Nodo interno para la cola
    private class NodoCola {
        private Huesped huesped;
        private NodoCola siguiente;

        public NodoCola(Huesped huesped) {
            this.huesped = huesped;
            this.siguiente = null;
        }
    }
}
