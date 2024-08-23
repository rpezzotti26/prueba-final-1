import java.util.Date;

public class Inspeccion {
    private Date fecha;
    private String resultado;
    private String accionesTomadas;

    public Inspeccion(Date fecha, String resultado, String accionesTomadas) {
        this.fecha = fecha;
        this.resultado = resultado;
        this.accionesTomadas = accionesTomadas;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public String getAccionesTomadas() {
        return accionesTomadas;
    }
}
