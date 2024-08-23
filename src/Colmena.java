import java.util.ArrayList;

public class Colmena {
    private String id;
    private String ubicacion;
    private String estadoSalud;
    private int cantidadAbejas;
    private double produccionMiel;
    private AbejaReina abejaReina;
    private ArrayList<Inspeccion> inspecciones;

    public Colmena(String id, String ubicacion, String estadoSalud, int cantidadAbejas, double produccionMiel, AbejaReina abejaReina) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estadoSalud = estadoSalud;
        this.cantidadAbejas = cantidadAbejas;
        this.produccionMiel = produccionMiel;
        this.abejaReina = abejaReina;
        this.inspecciones = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void agregarInspeccion(Inspeccion inspeccion) {
        this.inspecciones.add(inspeccion);
    }

    public void actualizarEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public ArrayList<Inspeccion> getInspecciones() {
        return inspecciones;
    }

    @Override
    public String toString() {
        return "Colmena ID: " + id + ", Ubicación: " + ubicacion + ", Estado de Salud: " + estadoSalud + ", Abejas: " + cantidadAbejas + ", Producción de Miel: " + produccionMiel;
    }
}
