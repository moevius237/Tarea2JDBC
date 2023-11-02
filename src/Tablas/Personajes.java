package Tablas;

public class Personajes {
    private String name;
    private String raza;
    private int edad;
    private String dao;
    private int reinoName;
    private String cultivacionName;

    public Personajes(String name, String raza, int edad, String dao, int reinoName, String cultivacionName) {
        this.name = name;
        this.raza = raza;
        this.edad = edad;
        this.dao = dao;
        this.reinoName = reinoName;
        this.cultivacionName = cultivacionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDao() {
        return dao;
    }

    public void setDao(String dao) {
        this.dao = dao;
    }

    public int getReinoName() {
        return reinoName;
    }

    public void setReinoName(int reinoName) {
        this.reinoName = reinoName;
    }

    public String getCultivacionName() {
        return cultivacionName;
    }

    public void setCultivacionName(String cultivacionName) {
        this.cultivacionName = cultivacionName;
    }
}