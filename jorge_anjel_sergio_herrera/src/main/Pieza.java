package main;

import java.util.Scanner;

/**
 *
 * @Autores: Sergio Herrera, Jorge Anjel
 * @Fecha: 21/10/2017
 *
 */

public class Pieza {

    String pieza[][];
    int PORCENTAJE_GATOS;
    int PORCENTAJE_RATONES;
    int svAncho;
    int svLargo;

    public void ingPieza() {

        while (true) {

            Scanner leer = new Scanner(System.in);

            System.out.print("Ingrese ancho y alto de la pieza: ");
            String cantidad = leer.nextLine();

            if (cantidad.contains(",")) {
                String[] lugar = cantidad.split(",");

                int largo = Integer.parseInt(lugar[0]);
                int ancho = Integer.parseInt(lugar[1]);

                this.svAncho = ancho;
                this.svLargo = largo;

                byte MAXIMO = 20;

                if (largo > MAXIMO || ancho > MAXIMO) {
                    System.out.println("El largo y ancho deben ser menores que " + MAXIMO + ".");
                    continue;
                }

                if (largo < 0 || ancho < 0) {
                    System.out.println("El largo y ancho no puden ser negativos.");
                    continue;
                }

                this.pieza = new String[largo][ancho];

                this.PORCENTAJE_GATOS = 10;
                this.PORCENTAJE_RATONES = 4;

                for (int i = 0; i < pieza.length; i++) {
                    for (int j = 0; j < pieza[i].length; j++) {
                        pieza[i][j] = "-";
                    }
                }
            }
            muestraPieza();
            break;
        }
    }

    public void ingGato() {
        int contCat = 0;
        int gato;

        Scanner leer = new Scanner(System.in);

        int calcPorc = (svLargo * svAncho) / PORCENTAJE_GATOS;

        System.out.println("Solo puede ingresar [" + calcPorc + "] gatos como máximo.");

        while (true) {
            System.out.print("N° de gatos: ");

            gato = Integer.parseInt(leer.nextLine());

            if (gato > calcPorc) {
                System.out.println("No puede ingresar más gatos de lo permitido.");
                continue;
            }

            if (gato < 0) {
                System.out.println("Ingrese un número positivo.");
                continue;
            }

            if (gato <= calcPorc) {
                break;
            }

            if (gato == 0) {
                break;
            }

        }

        while (true) {
            muestraPieza();

            contCat += 1;

            if (gato == 0) {
                break;
            }

            System.out.println("GATO N°" + contCat);
            System.out.println("-----------------------------------------");

            System.out.print("Ingrese filas y columnas [x, y]: ");

            String cantCat = leer.nextLine();

            if (cantCat.contains(",")) {
                String[] lugar = cantCat.split(",");

                int largo = Integer.parseInt(lugar[0]);
                int ancho = Integer.parseInt(lugar[1]);

                if (largo >= svLargo || ancho >= svAncho) {
                    System.out.println("El largo y ancho no puden pasar el límite de la matriz.");
                    contCat = 0;
                    continue;
                }

                if (largo < 0 || ancho < 0) {
                    System.out.println("El largo y ancho no puden ser negativos.");
                    contCat = 0;
                    continue;
                }

                this.pieza[largo][ancho] = "G";

                muestraPieza();

                if (contCat == gato) {
                    break;
                }
            }
        }
    }

    public void ingRaton() {
        int contRtn = 0;
        int raton;

        Scanner leer = new Scanner(System.in);

        int calcPorc = (svLargo * svAncho) / PORCENTAJE_RATONES;

        System.out.println("Solo puede ingresar [" + calcPorc + "] ratones como máximo.");

        while (true) {
            System.out.print("N° de ratones: ");

            raton = Integer.parseInt(leer.nextLine());

            if (raton > calcPorc) {
                System.out.println("No puede ingresar más ratones de lo permitido.");
                continue;
            }

            if (raton < 0) {
                System.out.println("Ingrese un número positivo.");
                continue;
            }

            if (raton <= calcPorc) {
                break;
            }

            if (raton == 0) {
                break;
            }
        }

        while (true) {
            muestraPieza();

            contRtn += 1;

            if (raton == 0) {
                break;
            }

            System.out.println("RATON N°" + contRtn);
            System.out.println("-----------------------------------------");

            System.out.print("Ingrese lugar del ratón [x,y]: ");

            String cantRtn = leer.nextLine();

            if (cantRtn.contains(",")) {
                String[] lugar = cantRtn.split(",");

                int largo = Integer.parseInt(lugar[0]);
                int ancho = Integer.parseInt(lugar[1]);

                if (largo >= svLargo || ancho >= svAncho) {
                    System.out.println("El largo y ancho no puden pasar el límite de la matriz.");
                    contRtn = 0;
                    continue;
                }

                if (largo < 0 || ancho < 0) {
                    System.out.println("El largo y ancho no puden ser negativos.");
                    contRtn = 0;
                    continue;
                }

                this.pieza[largo][ancho] = "R";

                muestraPieza();

                if (contRtn == raton) {
                    break;
                }
            }
        }
    }

    public void ingMueble() {
        int contMbl = 0;
        int mueble;

        Scanner leer = new Scanner(System.in);

        while (true) {

            System.out.print("N° de muebles: ");

            mueble = Integer.parseInt(leer.nextLine());

            if (mueble < 0) {
                System.out.println("Ingrese un número positivo.");
                continue;
            }

            if (mueble <= pieza.length) {
                break;
            }

            if (mueble >= svLargo || mueble >= svAncho) {
                System.out.println("No puede ingresar un número mayor a la matriz.");
                continue;
            }

            if (mueble == 0) {
                break;
            }

        }

        while (true) {
            contMbl += 1;

            muestraPieza();

            System.out.print("Ingrese esquina superior del mueble [x, y]: ");

            String cantMbl = leer.nextLine();

            if (cantMbl.contains(",")) {
                String[] izquierda = cantMbl.split(",");

                int xs = Integer.parseInt(izquierda[0]);
                int ys = Integer.parseInt(izquierda[1]);

                pieza[xs][ys] = "x";
                
                if (xs + 2 >= svLargo) {
                    pieza[xs-1][ys] = "x";
                    pieza[xs-2][ys] = "x";
                } else {
                    pieza[xs+2][ys] = "x";
                    pieza[xs+1][ys] = "x";
                }

                muestraPieza();

                System.out.print("Ingrese esquina inferor del mueble [x, y]: ");
                String cantMbl2 = leer.nextLine();

                if (cantMbl2.contains(",")) {
                    String[] derecha = cantMbl2.split(",");

                    int xd = Integer.parseInt(derecha[0]);
                    int yd = Integer.parseInt(derecha[1]);

                    pieza[xd][yd] = "x";

                    if (xd + 2 >= svLargo) {
                        pieza[xd-1][yd] = "x";
                        pieza[xd-2][yd] = "x";
                    } else {
                        pieza[xd+2][yd] = "x";
                        pieza[xd+1][yd] = "x";
                    }

                    muestraPieza();

                    if (contMbl == mueble) {

                        muestraPieza();

                        System.out.println("Proceder?");
                        System.out.println("1.- SI");
                        System.out.println("2.- NO");
                        System.out.println("-----------------------------------------");
                        System.out.print("OP: ");
                        int opc = Integer.parseInt(leer.nextLine());

                        if (opc == 1) {
                            for (int i = 0; i < pieza.length; i++) {
                                for (int j = 0; j < pieza[i].length; j++) {
                                    if (pieza[i][j].contains("x")) {
                                        pieza[i][j] = "M";
                                    }
                                }
                            }
                            muestraPieza();
                        }

                        if (opc == 2) {
                            contMbl = 0;
                            for (int i = 0; i < pieza.length; i++) {
                                for (int j = 0; j < pieza[i].length; j++) {
                                    if (pieza[i][j].contains("x") || pieza[i][j].contains("M")) {
                                        pieza[i][j] = "-";
                                    }
                                }
                            }
                            continue;
                        }
                        break;
                    }
                }
            }
        }
    }

    public void muestraPieza() {
        System.out.println("-----------------------------------------");

        for (int k = 0; k < svAncho; k++) {
            if (k == 0) {
                System.out.print("f/c");
            }
            if (k >= 10) {
                System.out.print(" " + k);
            } else {
                System.out.print(" " + "0" + k);
            }
        }

        System.out.println();

        for (int i = 0; i < svLargo; i++) {
            if (i >= 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(" " + "0" + i + " ");
            }

            for (int j = 0; j < pieza[i].length; j++) {
                System.out.print(" " + pieza[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}
