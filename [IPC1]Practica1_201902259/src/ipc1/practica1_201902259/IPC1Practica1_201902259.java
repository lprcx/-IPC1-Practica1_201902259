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

    static String[][] tablerocomida;
    static String[][] tableropared;

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
        System.out.println("Ingrese cantidad de comida [0-" + (int) tamcom + "]");
        comida = sn.nextInt();
        System.out.println("Ingrese cantidad de paredes:");
        paredes = sn.nextInt();
        System.out.println("Ingrese cantidad de trampas:");
        trampas = sn.nextInt();

        //System.out.println("m:" + m);
        //System.out.println("n" + n);
        tablerocomida = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tablerocomida[i][j] = " ";
            }

        }
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
            tablerocomida[ran.nextInt((mm - 0) + 1)][ran.nextInt((nn - 0) + 1)] = x;

            contador++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tablerocomida[i][j] + "|");
            }
            System.out.println("");

        }
            //tablero pared
        tableropared = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tableropared[i][j] = " ";
            }

        }

    }
}
