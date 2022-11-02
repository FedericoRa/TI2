package ui;

import model.GeoController;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private GeoController controller;

    public Main() {
        sc= new Scanner(System.in);
        controller = new GeoController();
    }


    public static void main(String[] args) throws Exception {

        Main obj = new Main();

        int option = 0;

        do{
            option = obj.showMenu();
            obj.executeOperation(option);

        }while (option!=0);
    }

    public int showMenu() {
        int option=0;
        System.out.println(
                "Bienvenido \n" +
                "Seleccione una opcion\n" +
                        "(1) Insertar comando \n" +
                        "(2) Importar datos desde archivo .SQL\n"+
                        "(0) Salir"
        );
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void executeOperation(int operation) throws Exception {

        switch(operation) {
            case 0:
                System.out.println("Cerrando Programa");
                break;
            case 1:
                insertCommand();
                break;
            case 2:
                importText();
                break;
            default:
                System.out.println("Error, opcion invalilda");

        }
    }

    public void insertCommand() throws exceptions.CountryDoesNotExist {

        System.out.println("Por favor ingresa la consulta que desea hacer");
        String consult = sc.nextLine();
        String[] partsConsult = consult.split(" ");

        if (partsConsult[0].equalsIgnoreCase("insert")) {
            controller.insertFuntion(partsConsult, consult);
        } else {
            if (partsConsult[0].equalsIgnoreCase("select")) {
                controller.insertConsult(partsConsult, consult);
            } else {
                if (partsConsult[0].equalsIgnoreCase("delete")) {
                } else {
                    System.out.println("La operacion que intenta hacer no es valida");
                }
            }
        }
    }

    public void importText() {
        controller.importText();
    }
}
