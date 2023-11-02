package Tablas;

public class Cultivacion {
    private String etapa;
    private String tipo;
    private String tecnica;

    public Cultivacion(String etapa, String tipo, String tecnica) {
        this.etapa = etapa;
        this.tipo = tipo;
        this.tecnica = tecnica;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}
