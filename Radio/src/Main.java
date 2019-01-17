import classes.Radio;
import utils.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Radio myRadio = new Radio();
        Boolean run = true;
        Scanner input = new Scanner(System.in);
        int option;
        int button;

        while (run) {
            System.out.println(myRadio);

            if (myRadio.getState()) {
                System.out.println(Menu.menu2());
                option = input.nextInt();

                if (option == 1) {
                    myRadio.toggle();
                } else if (option == 2) {
                    myRadio.changeFrecuency();
                } else if (option == 3) {
                    myRadio.changeStation(true);
                } else if (option == 4) {
                    myRadio.changeStation(false);
                } else if (option == 5) {
                    System.out.println("Seleccione un boton para guardar la estacion: (1-12)");
                    button = input.nextInt();
                    if (button <= 12 && button >= 1) {
                        myRadio.saveStation(button);
                    } else {
                        System.out.println("Ese boton no existe");
                    }
                } else if (option == 6) {
                    System.out.println("Seleccione un boton para seleccionar la estacion: (1-12)");
                    button = input.nextInt();
                    if (button <= 12 && button >= 1) {
                        myRadio.changeStationButton(button);
                    } else {
                        System.out.println("Ese boton no existe");
                    }
                }

            } else {
                System.out.println(Menu.menu1());
                System.out.print("Ingrese una opcion: ");
                option = input.nextInt();

                if (option == 1) {
                    myRadio.toggle();
                } else if (option == 2) {
                    System.out.println("Adios");
                    run = false;
                } else {
                    System.out.println("Opcion invalida");
                }
            }

        }
    }
}
