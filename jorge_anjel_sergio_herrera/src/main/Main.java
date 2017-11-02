package main;

/**
 *
 * @Autores: Sergio Herrera, Jorge Anjel
 * @Fecha: 21/10/2017
 *
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("-----------------------------------------");
        System.out.println("Regla: Todo lo que sea coordenada");
        System.out.println("Se debe ingresar separado por una");
        System.out.println("coma. EJ: 1,4");
        System.out.println("-----------------------------------------");

        Pieza p = new Pieza();

        p.ingPieza();
        p.ingGato();
        p.ingRaton();
        p.ingMueble();
    }
}
