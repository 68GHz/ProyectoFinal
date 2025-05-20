package hotel.modelos;

public class CheckIn {
    private Huesped huesped;
    private Habitacion habitacionAsignada;
    private NodoServicio serviciosAdquiridos; // Lista enlazada para los servicios
    private double total;

    public CheckIn(Huesped huesped, Habitacion habitacionAsignada) {
        this.huesped = huesped;
        this.habitacionAsignada = habitacionAsignada;
        this.serviciosAdquiridos = null;
        this.total = calcularCostoEstadia();
    }

    public double calcularCostoEstadia() {
        double costoHabitacion = 0;
        switch (habitacionAsignada.getTipo()) {
            case "Sencilla":
                costoHabitacion = 155000;
                break;
            case "Doble":
                costoHabitacion = 80000;
                break;
            case "Familiar":
                costoHabitacion = 55000;
                break;
        }
        return costoHabitacion;
    }

    public void agregarServicio(Servicio servicio) {
        NodoServicio nuevoServicio = new NodoServicio(servicio);
        if (serviciosAdquiridos == null) {
            serviciosAdquiridos = nuevoServicio;
        } else {
            NodoServicio actual = serviciosAdquiridos;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoServicio;
        }
        total += servicio.getPrecio();
    }

    public double calcularTotal() {
        return total;
    }

    public void mostrarFactura() {
        System.out.println("Factura para: " + huesped.getNombre());
        System.out.println("Habitación: " + habitacionAsignada.getNumero());
        System.out.println("Total por estadía: $" + calcularTotal());
        NodoServicio actual = serviciosAdquiridos;
        while (actual != null) {
            System.out.println(actual.servicio.getNombre() + " - $" + actual.servicio.getPrecio());
            actual = actual.siguiente;
        }
        System.out.println("Total final: $" + calcularTotal());
    }

    //nodo interno para la lista de servicios adquiridos
    private class NodoServicio {
        private Servicio servicio;
        private NodoServicio siguiente;

        public NodoServicio(Servicio servicio) {
            this.servicio = servicio;
            this.siguiente = null;
        }
    }
}
