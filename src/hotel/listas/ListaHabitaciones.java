package hotel.listas;
import hotel.modelos.Habitacion;
public class ListaHabitaciones {
    private Habitacion CAB;

    public void agregarHabitacion(int numero, String tipo, String estado){
        Habitacion nueva=new Habitacion(numero, tipo, estado);
        if (CAB==null){
            CAB=nueva;
        }else {
            Habitacion actual=CAB;
            while(actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente=nueva;
        }
    }
    public void mostrarHabitaciones() {
        Habitacion actual=CAB;
        while(actual!=null){
            System.out.println("Numero: " + actual.getNumero() +
                    " | Tipo: " + actual.getTipo() +
                    " | Estado: " + actual.getEstado());
            actual=actual.siguiente;
        }
    }
}
