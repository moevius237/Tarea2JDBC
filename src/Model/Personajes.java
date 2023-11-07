package Model;

public class Personajes {
    private String name;
    private String raza;
    private int edad;
    private String dao;
    private String cultivacionName;

    public Personajes(String name, String raza, int edad, String dao, String cultivacionName) {
        this.name = name;
        this.raza = raza;
        this.edad = edad;
        this.dao = dao;

        this.cultivacionName = cultivacionName;
    }

    public Personajes() {

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


    public String getCultivacionName() {
        return cultivacionName;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "name='" + name + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", dao='" + dao + '\'' +
                ", cultivacionName='" + cultivacionName + '\'' +
                '}';
    }

    public void setCultivacionName(String cultivacionName) {
        this.cultivacionName = cultivacionName;
    }
}