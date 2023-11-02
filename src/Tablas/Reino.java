package Tablas;

public class Reino {
    private String nombre;
    private boolean demoniaco;
    private int  numero;
    private boolean caotico;

    public Reino(String nombre, boolean demoniaco, int numero, boolean caotico) {
        this.nombre = nombre;
        this.demoniaco = demoniaco;
        this.numero = numero;
        this.caotico = caotico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDemoniaco() {
        return demoniaco;
    }

    public void setDemoniaco(boolean demoniaco) {
        this.demoniaco = demoniaco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isCaotico() {
        return caotico;
    }

    public void setCaotico(boolean caotico) {
        this.caotico = caotico;
    }
}
