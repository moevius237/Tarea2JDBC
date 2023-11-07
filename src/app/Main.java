package app;

import Model.Cultivacion;
import Model.Personajes;
import mysql.CultivacionAccesDb;
import mysql.LoginAccesDB;
import mysql.PersonajesAccesDB;
import util.DatabaseConection;
import util.MenuUtil;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        Scanner sc = new Scanner(System.in);
        boolean d = true;
        try {
            con = DatabaseConection.getCon();
            while (d) {
                System.out.println("Introduce usuario: ");
                String user = sc.next();
                System.out.println("Introduce contraseña: ");
                String pass = sc.next();
                LoginAccesDB loginAccesDB = new LoginAccesDB();
                if (loginAccesDB.autentica(user, pass)) {
                    System.out.println("Inicio de sesion exitoso");
                    d = false;
                } else {
                    System.out.println("Inicio de sesion fallido, Intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int elec = 0;
        while (elec != 5) {
            MenuUtil.menu();
            try {

                elec = sc.nextInt();
                sc.nextLine();
                switch (elec) {
                    case 1:
                        int mostrarele = 0;
                        while (mostrarele != 3) {
                            try {

                                System.out.println("Que quieres ver 1. Personajes 2. Cultivacion 3. Salir");
                                mostrarele = sc.nextInt();
                                switch (mostrarele) {
                                    case 1:
                                        System.out.println("Elegistes personaje");
                                        System.out.println(PersonajesAccesDB.getPersonajes());
                                        break;
                                    case 2:
                                        System.out.println("Elegistes cultivacion");
                                        System.out.println(CultivacionAccesDb.getCultivacion());
                                        break;
                                    case 3:
                                        System.out.println("Saliendo de mostrar personaje");
                                        break;
                                    default:
                                        System.out.println("Introduce una opcion valida");
                                        break;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Debes introducir un numero entero");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 2:
                        int agregarele = 0;
                        while (agregarele != 3) {
                            try {

                                System.out.println("Que Insertar 1. Personajes 2. Cultivacion 3. Salir");
                                agregarele = sc.nextInt();
                                switch (agregarele) {
                                    case 1:
                                        System.out.println("Elegistes personaje");
                                        System.out.println("Elige un nombre , no se pueden repetir" + PersonajesAccesDB.MostrarNombres());
                                        String perso = sc.next();
                                        if (!PersonajesAccesDB.existePerso(perso)) {
                                            System.out.println("Elige una raza ");
                                            String raza = sc.next();
                                            System.out.println("Elige una edad");
                                            int edad = sc.nextInt();
                                            System.out.println("Elige un dao");
                                            String dao = sc.next();
                                            System.out.println("Elige una etapa para insertar en el personaje" + PersonajesAccesDB.MostrarEtapa());
                                            String etapa = sc.next();

                                            PersonajesAccesDB.insertPersonajes(new Personajes(perso, raza, edad, dao, etapa));
                                            System.out.println("SE inserto correctamente");
                                        }else {
                                            System.out.println("Ese personaje ya existe");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Elegistes cultivacion");
                                        System.out.println("Elige una etapa , no se pueden repetir "  + PersonajesAccesDB.MostrarEtapa());
                                        String eta = sc.next();
                                        if (!CultivacionAccesDb.existeCulti(eta)) {
                                            System.out.println("Elige un tipo");
                                            String tipo = sc.next();
                                            System.out.println("Elige una tecnica");
                                            String tec = sc.next();

                                            CultivacionAccesDb.insertCultivacion(new Cultivacion(eta, tipo, tec));
                                            System.out.println("SE inserto correctamene");
                                        }else {
                                            System.out.println("Esa etapa ya existe");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Saliendo de mostrar personaje");
                                        break;
                                    default:
                                        System.out.println("Introduce una opcion valida");
                                        break;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Debes introducir un numero entero");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 3:
                        int updateele = 0;
                        while (updateele != 3) {
                            try {

                                System.out.println("Que quieres actuzalizar 1. Personajes 2. Cultivacion 3. Salir");
                                updateele = sc.nextInt();
                                switch (updateele) {
                                    case 1:
                                        System.out.println("Elegistes personaje");
                                        System.out.println("Elige el nombre de un personaje que actualizar" + PersonajesAccesDB.MostrarNombres());
                                        String antiguo = sc.next();
                                        if (PersonajesAccesDB.existePerso(antiguo)) {
                                            System.out.println("Elige un nombre");
                                            String perso = sc.next();
                                            System.out.println("Elige una raza ");
                                            String raza = sc.next();
                                            System.out.println("Elige una edad");
                                            int edad = sc.nextInt();
                                            System.out.println("Elige un dao");
                                            String dao = sc.next();
                                            System.out.println("Elige una etapa para actualizar en el personaje" + PersonajesAccesDB.MostrarEtapa());
                                            String etapa = sc.next();

                                            PersonajesAccesDB.updatePerson(
                                                    new Personajes(perso, raza, edad, dao, etapa), antiguo);
                                            System.out.println("Se ha actualizado correctamente " + antiguo);
                                        }else{
                                            System.out.println("Ese personaje no existe");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Elegistes cultivacion");
                                        System.out.println("Elige el nombre de una etapa de cultivo que actualizar" + PersonajesAccesDB.MostrarEtapa());
                                        String anteCUlti = sc.next();
                                        if (CultivacionAccesDb.existeCulti(anteCUlti)){
                                            System.out.println("Elige una nueva etapa");
                                            String etpas = sc.next();
                                            System.out.println("Elige un nuevo tipo");
                                            String tipo = sc.next();
                                            System.out.println("Elige una nuevo tecnica");
                                            String tecni = sc.next();

                                            CultivacionAccesDb.updateCultivo(new Cultivacion(etpas,tipo,tecni),anteCUlti);
                                            System.out.println("Se ha actualizado correctamente " + anteCUlti);
                                        }else{
                                            System.out.println("Esa etapa no existe");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Saliendo de mostrar personaje");
                                        break;
                                    default:
                                        System.out.println("Introduce una opcion valida");
                                        break;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Debes introducir un numero entero");
                                sc.nextLine();
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Elige un personaje para borrar " + PersonajesAccesDB.MostrarNombres());
                        String borrar = sc.next();
                        if(PersonajesAccesDB.existePerso(borrar)){
                        PersonajesAccesDB.eliminarPersonaje(borrar);
                        System.out.println("Se ha eliminado con exito");
                        }else {
                            System.out.println("Ese personaje no existe");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo de la aplicacion");
                        break;
                    default:
                        System.out.println("Opcion no valida, Introduzca un valor valido");
                        break;
                }

            } catch (InputMismatchException e){
                System.out.println("Debes introducir un numero entero");
                sc.nextLine();
            }
        }
    }
}
