package com.mycompany.proyectofinalmate;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ProyectoFinalMate {


    // ===== OPERACIONES =====
    public static void union(Set<Integer> A, Set<Integer> B) {
        Set<Integer> resultado = new HashSet<>(A);
        resultado.addAll(B);
        System.out.println("Union (A U B): " + resultado);
    }

    public static void interseccion(Set<Integer> A, Set<Integer> B) {
        Set<Integer> resultado = new HashSet<>(A);
        resultado.retainAll(B);
        System.out.println("Interseccion (A A B): " + resultado);
    }

    public static void diferencia(Set<Integer> A, Set<Integer> B) {
        Set<Integer> resultado = new HashSet<>(A);
        resultado.removeAll(B);
        System.out.println("Diferencia (A - B): " + resultado);
    }

    // ===== INGRESO DE CONJUNTOS =====
    public static Set<Integer> ingresarConjunto(Scanner sc, String nombre) {

        Set<Integer> conjunto = new HashSet<>();
        int cantidad = 0;

        while (true) {
            try {
                System.out.print("Cantidad de elementos del conjunto " + nombre + ": ");
                cantidad = sc.nextInt();
                if (cantidad > 0) break;
                System.out.println("Debe ser mayor a 0.");
            } catch (Exception e) {
                System.out.println("Error: ingrese un numero entero.");
                sc.nextLine();
            }
        }

        for (int i = 1; i <= cantidad; i++) {
            while (true) {
                try {
                    System.out.print("Elemento " + i + " del conjunto " + nombre + ": ");
                    conjunto.add(sc.nextInt());
                    break;
                } catch (Exception e) {
                    System.out.println("Error: solo numeros enteros.");
                    sc.nextLine();
                }
            }
        }
        return conjunto;
    }

    // ===== SUBMENÚ TEORÍA DE CONJUNTOS =====
    public static void teoriaDeConjuntos(Scanner sc) {

        int opcion = 0;

        Set<Integer> A = ingresarConjunto(sc, "A");
        Set<Integer> B = ingresarConjunto(sc, "B");

        do {
            try {
                System.out.println("\n--- TEORIA DE CONJUNTOS ---");
                System.out.println("1.- Union");
                System.out.println("2.- Interseccion");
                System.out.println("3.- Diferencia (A - B)");
                System.out.println("4.- Volver al menu principal");
                System.out.print("Elija una opcion: ");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        union(A, B);
                        break;
                    case 2:
                        interseccion(A, B);
                        break;
                    case 3:
                        diferencia(A, B);
                        break;
                    case 4:
                        System.out.println("Regresando al menu principal...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número valido.");
                sc.nextLine();
            }

        } while (opcion != 4);
    }

    // ===== MENÚ PRINCIPAL =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            try {
                System.out.println("\n===== PROYECTO FINAL =====");
                System.out.println("1.- Teoria de Conjuntos");
                System.out.println("2.- Ecuaciones Lineales");
                System.out.println("3.- Problema Planteado");
                System.out.println("4.- Salir");
                System.out.print("Escoja una opcion: ");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        teoriaDeConjuntos(sc);
                        break;
                    case 2:
                        System.out.println("Modulo de ecuaciones lineales (pendiente).");
                        break;
                    case 3:
                        System.out.println("Modulo de problema planteado (pendiente).");
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un numero valido.");
                sc.nextLine();
            }

        } while (opcion != 4);

        sc.close();
    }
}
