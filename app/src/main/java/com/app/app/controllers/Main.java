package com.app.app.controllers;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*Suponer un sistema de reserva de asientos para un anfiteatro.
          El teatro cuenta con 10 filas de 10 asientos cada una.
          Se necesita desarrollar un sistema (sin uso de bd).
          1. Cargar el mapa de las filas y asientos. Indicando con una "X"
          los asientos ocupados y con una "L" los asientos libres.
          Al iniciar el programa, todos los asientos deben estar libres.
          2. Manejar la reserva de asientos contemplando que un asiento
          SOLO PUEDE SER RESERVADO si se encuentra en estado "L",
          en caso de que este en estado "X", de deberá permitir al comprador
          elegir otro asiento.
          Si se encuentra en estado "L", deberá pasar automaticamente al
          estado "X"
          3. Para finalizar el programa se deberá ingresar un valor en particular.
          Contemplar que no existe una cantidad exacta de veces que el
          programa se pueda ejecutar.
          4. Contemplar que solo existen 10 filas y 10 asientos. No
          se pueden vender asientos fuera de esas numeraciones. No
          se permite sobreventa.

          */

        int fila = 10;
        int columna = 10;
        String[][] asiento = new String[11][11];

        for(int i=1; i<= fila; i++)
        {
            for(int j=1; j<= columna; j++) asiento[i][j] = "L";
        }

        int opcionIngresada = 1;

        while (opcionIngresada != 0)
        {
            Scanner textoFila = new Scanner(System.in);
            System.out.println("Ingrese la fila que desea: ");
            int filaTeatro = textoFila.nextInt();

            while (filaTeatro <= 0 || filaTeatro >= 11)
            {
                System.out.println("La fila elegida es incorrecta. Por favor elija una desde el 1 al 10:");
                filaTeatro = textoFila.nextInt();
            }

            Scanner textoColumna = new Scanner(System.in);
            System.out.println("Ingrese el asiento que desea: ");
            int asientoSolicitado = textoColumna.nextInt();

            while (asientoSolicitado <= 0 || asientoSolicitado >= 11)
            {
                System.out.println("El asiento es incorrecto. Por favor elija uno desde el 1 al 10:");
                asientoSolicitado = textoColumna.nextInt();
            }

            if(asiento[filaTeatro][asientoSolicitado].equals("L"))
            {
                asiento[filaTeatro][asientoSolicitado]= "X";
            }
            else
            {
                System.out.println("El asiento esta vendido.");
            }
            Scanner opcion = new Scanner(System.in);
            System.out.println("¿Desea seguir comprando? (1=SI, 0=NO)");
            opcionIngresada = opcion.nextInt();
        }

        Scanner opcionVerVentas = new Scanner(System.in);
        System.out.println("¿Desea ver las ventas del teatro? (1=SI, 0=NO)");
        int verVentas = opcionVerVentas.nextInt();
        if(verVentas == 1)
        {
            for(int i=1; i<= fila; i++)
            {
                for(int j=1; j<= columna; j++)
                {
                    System.out.print(asiento[i][j] + "  ");
                }
                System.out.print("\n");
            }
        }
        else
        {
            System.out.println("Programa finalizado.");
        }
    }
}
