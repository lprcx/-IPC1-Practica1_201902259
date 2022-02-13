/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipc1.practica1_201902259;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IPC1Practica1_201902259 {

    static String nombre;
    static String tamanio;
    static String posicion;
    static int comida, paredes, trampas;

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("----PACMAN - IPC 1---");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Tabla de Posiciones");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    menuJuego();

                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Hasta la procsimaaa");
                    break;
                default:
                    System.out.println("Dato inválido");

            }
        } while (opcion != 3);

    }
    //Creación de matrices globales
    static String[][] tablerocomida;
    static String[][] tableropared;
    static String[][] tablerotrampas;
    static String[] iconos;
    static int iconjug;
    static String ficha;

    public static void menuJuego() {
        Scanner sn = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Ingrese su nombre:");
        nombre = sn.next();
        System.out.println("Ingrese el tamaño de su tablero [mxn]:");
        tamanio = sn.next();
        //Obteniendo el porcentaje de comida y tamaño del tablero
        String[] tamtab = tamanio.split("x");
        int m = Integer.parseInt(tamtab[0]);
        int n = Integer.parseInt(tamtab[1]);
        double tamcom = (m * n) * (0.4);
        double tampar = (m * n) * (0.2);
        double tamtramp = (m * n) * (0.2);
        System.out.println("Ingrese cantidad de comida [0-" + (int) tamcom + "]");
        //Para validar el rango
        do {
            comida = sn.nextInt();
            if (comida > (int) tamcom || comida < 0) {
                System.out.println("Valor fuera del rango");

            }
        } while (comida > (int) tamcom || comida < 0);

        //paredes     
        System.out.println("Ingrese cantidad de paredes [0-" + (int) tampar + "]");

        do {
            paredes = sn.nextInt();
            if (paredes > (int) tampar || paredes < 0) {
                System.out.println("Valor fuera del rango");

            }
        } while (paredes > (int) tampar || paredes < 0);
        //trampas        
        System.out.println("Ingrese cantidad de trampas [0-" + (int) tamtramp + "]");

        do {
            trampas = sn.nextInt();
            if (trampas > (int) tamtramp || trampas < 0) {
                System.out.println("Valor fuera del rango");

            }
        } while (trampas > (int) tamtramp || trampas < 0);

        //System.out.println("m:" + m);
        //System.out.println("n" + n);
        tablerocomida = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tablerocomida[i][j] = " ";
            }

        }

        //Icono
        int[] ascci = {178, 175, 166, 195, 184, 244, 169, 157, 190, 241};
        iconos = new String[10];
        char[] ico = new char[10];
        for (int i = 0; i < 10; i++) {
            ico[i] = (char) ascci[i];
            iconos[i] = String.valueOf(ico[i]);
        }

        System.out.println("Seleccione un número de icono:");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ". " + iconos[i] + "       ");
        }
        System.out.println("");
        iconjug = sn.nextInt();

        ficha = iconos[iconjug - 1];
        System.out.println("tu ficha es: " + ficha);

        //Estableciendo la comida aleatoriamente
        int mm = m - 1;
        int nn = n - 1;
        int contador = 1;
        while (contador <= comida) {
            String x;
            if (ran.nextBoolean() == true) {
                x = "@";
            } else {
                x = "?";
            }

            int i = ran.nextInt((mm - 0) + 1);
            int j = ran.nextInt((nn - 0) + 1);
            if (tablerocomida[i][j].equals(" ")) {
                tablerocomida[i][j] = x;
                contador++;
            }

        }
        /*
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tablerocomida[i][j] + "|");

            }
            System.out.println("");

        } */
        //tablero pared
        tableropared = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tableropared[i][j] = " ";
            }
        }
        int contadorr = 1;
        while (contadorr <= paredes) {

            int k = ran.nextInt((mm - 0) + 1);
            int l = ran.nextInt((nn - 0) + 1);
            if (tableropared[k][l].equals(" ")) {
                tableropared[k][l] = "#";
                contadorr++;
            }

        }
        /*
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(tableropared[j][k] + "|");

            }
            System.out.println("");
        }
         */
        //tablero trampas
        tablerotrampas = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tablerotrampas[i][j] = " ";
            }
        }
        int contadorrr = 1;
        while (contadorrr <= trampas) {

            int k = ran.nextInt((mm - 0) + 1);
            int l = ran.nextInt((nn - 0) + 1);
            if (tablerotrampas[k][l].equals(" ")) {
                tablerotrampas[k][l] = "X";
                contadorrr++;
            }

        }
        /*
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(tablerotrampas[j][k] + "|");

            }
            System.out.println("");
        }
         */
        System.out.println("-----------------------");
        System.out.println("Jugador: " + nombre);
        tablerounido(m, n);

        //Posición inicial del jugador
        System.out.println("-----------------------");
        System.out.println("Ingrese la posición inicial del Jugador (fila,columna)");

        int filaj;
        int columnaj;

        do {
            posicion = sn.next();
            String[] postab = posicion.split(",");
            filaj = Integer.parseInt(postab[0]);
            columnaj = Integer.parseInt(postab[1]);

            System.out.println("Su posición es: " + posicion);
            if (filaj > m || columnaj > n) {
                System.out.println("Esta posición no se encuentra en el tablero, ingrese una nueva");

            }
        } while (filaj > m || columnaj > n);

        Jugar(filaj, columnaj, ficha, nombre);
    }
    static String[][] tablerojuego;

    public static void tablerounido(int x, int y) {
        tablerojuego = new String[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablerojuego[i][j] = " ";
            }

        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!tablerocomida[i][j].equals(" ")) {
                    tablerojuego[i][j] = tablerocomida[i][j];

                }
                if (!tablerotrampas[i][j].equals(" ")) {
                    tablerojuego[i][j] = tablerotrampas[i][j];
                }

                if (!tableropared[i][j].equals(" ")) {
                    tablerojuego[i][j] = tableropared[i][j];

                }

            }

        }
        for (int j = 0; j < x; j++) {
            for (int k = 0; k < y; k++) {
                System.out.print(tablerojuego[j][k] + "|");

            }
            System.out.println("");
        }

    }

    public static void Jugar(int xj, int yj, String fichajug, String nombre) {

        Scanner sn = new Scanner(System.in);
        tablerojuego[xj][yj] = fichajug;
        int punteo = 0;
        int vidas = 3;
        String cambpos = "";

        do {
            System.out.println("--------------");
            System.out.println("Jugador: " + nombre + "     Punteo: " + punteo + "      Vidas: " + vidas);

            for (int j = 0; j < tablerojuego.length; j++) {
                System.out.print("|");
                for (int k = 0; k < tablerojuego[j].length; k++) {
                    System.out.print(tablerojuego[j][k] + "  ");

                }
                System.out.print("|");
                System.out.println("");
            }
            cambpos = sn.next();
            switch (cambpos) {
                case "a":
                    int yjaux = 0;
                    if ((yj - 1) < 0) {
                        yjaux = tablerojuego[0].length - 1;

                    } else {
                        yjaux = yj - 1;
                    }
                    if (tablerojuego[xj][yjaux].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xj][yjaux].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "s":
                    int xjaux1 = 0;
                    if ((xj + 1) > (tablerojuego.length - 1)) {
                        xjaux1 = 0;

                    } else {
                        xjaux1 = xj + 1;
                    }
                    if (tablerojuego[xjaux1][yj].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xjaux1][yj].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "w":
                    int xjaux = 0;
                    if ((xj - 1) < 0) {
                        xjaux = tablerojuego.length - 1;

                    } else {
                        xjaux = xj - 1;
                    }
                    if (tablerojuego[xjaux][yj].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xjaux][yj].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "d":
                    int yjaux1 = 0;
                    if ((yj + 1) > (tablerojuego[0].length - 1)) {
                        yjaux1 = 0;

                    } else {
                        yjaux1 = yj + 1;
                    }
                    if (tablerojuego[xj][yjaux1].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xj][yjaux1].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "4":

                    if ((yj - 1) < 0) {
                        yjaux = tablerojuego[0].length - 1;

                    } else {
                        yjaux = yj - 1;
                    }
                    if (tablerojuego[xj][yjaux].equals("@") || tablerojuego[xj][yjaux].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xj][yjaux].equals("?") || tablerojuego[xj][yjaux].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        yj = yj - 1;
                        if (yj < 0) {
                            yj = tablerojuego[0].length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;

                case "5":
                    if ((xj + 1) > (tablerojuego.length - 1)) {
                        xjaux1 = 0;

                    } else {
                        xjaux1 = xj + 1;
                    }
                    if (tablerojuego[xjaux1][yj].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xjaux1][yj].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        xj = xj + 1;
                        if (xj > (tablerojuego.length - 1)) {
                            xj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;

                case "8":
                    if ((xj - 1) < 0) {
                        xjaux = tablerojuego.length - 1;

                    } else {
                        xjaux = xj - 1;
                    }
                    if (tablerojuego[xjaux][yj].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xjaux][yj].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else if (tablerojuego[xjaux][yj].equals("X")) {
                        vidas = vidas - 1;

                    } else if (tablerojuego[xjaux][yj].equals("#")) {

                    } else {
                        tablerojuego[xj][yj] = " ";
                        xj = xj - 1;
                        if (xj < 0) {
                            xj = tablerojuego.length - 1;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "6":

                    if ((yj + 1) > (tablerojuego[0].length - 1)) {
                        yjaux1 = 0;

                    } else {
                        yjaux1 = yj + 1;
                    }
                    if (tablerojuego[xj][yjaux1].equals("@")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 5;
                    } else if (tablerojuego[xj][yjaux1].equals("?")) {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                        punteo = punteo + 10;
                    } else {
                        tablerojuego[xj][yj] = " ";
                        yj = yj + 1;
                        if (yj > (tablerojuego[0].length - 1)) {
                            yj = 0;
                            tablerojuego[xj][yj] = ficha;

                        } else {
                            tablerojuego[xj][yj] = ficha;
                        }
                    }

                    break;
                case "e":
                    System.out.println("------------");
                    break;
                default:
                    System.out.println("Ingrese un comando válido");
                    break;

            }
            if (vidas == 0) {
                System.out.println("                                                                                       \n"
                        + " @@@@@@@@   @@@@@@   @@@@@@@@@@   @@@@@@@@      @@@@@@   @@@  @@@  @@@@@@@@  @@@@@@@   \n"
                        + "@@@@@@@@@  @@@@@@@@  @@@@@@@@@@@  @@@@@@@@     @@@@@@@@  @@@  @@@  @@@@@@@@  @@@@@@@@  \n"
                        + "!@@        @@!  @@@  @@! @@! @@!  @@!          @@!  @@@  @@!  @@@  @@!       @@!  @@@  \n"
                        + "!@!        !@!  @!@  !@! !@! !@!  !@!          !@!  @!@  !@!  @!@  !@!       !@!  @!@  \n"
                        + "!@! @!@!@  @!@!@!@!  @!! !!@ @!@  @!!!:!       @!@  !@!  @!@  !@!  @!!!:!    @!@!!@!   \n"
                        + "!!! !!@!!  !!!@!!!!  !@!   ! !@!  !!!!!:       !@!  !!!  !@!  !!!  !!!!!:    !!@!@!    \n"
                        + ":!!   !!:  !!:  !!!  !!:     !!:  !!:          !!:  !!!  :!:  !!:  !!:       !!: :!!   \n"
                        + ":!:   !::  :!:  !:!  :!:     :!:  :!:          :!:  !:!   ::!!:!   :!:       :!:  !:!  \n"
                        + " ::: ::::  ::   :::  :::     ::    :: ::::     ::::: ::    ::::     :: ::::  ::   :::  \n"
                        + " :: :: :    :   : :   :      :    : :: ::       : :  :      :      : :: ::    :   : :");
                break;

            }
        } while (!cambpos.equals("e"));
    }
}
