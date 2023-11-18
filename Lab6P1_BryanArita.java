/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_bryanarita;

import java.util.Random;
import java.util.Scanner;

public class Lab6P1_BryanArita {

    static Scanner duki = new Scanner(System.in);
    static Random rndm = new Random();

    public static void main(String[] args) {

        System.out.println("*****MENU*****"
                + "\n[1] Conjuntos"
                + "\n[2] Cuantos primos tienes?"
                + "\n[3] Salir del programa"
                + "\nIngrese su opcion:");
        int opcion = duki.nextInt();
        while (opcion != 3) {
            switch (opcion) {
                case 1:
                    System.out.print("Size SET1: ");
                    int n1 = duki.nextInt();
                    char array[] = new char[n1];

                    System.out.print("Size SET2:");
                    int n2 = duki.nextInt();
                    char array2[] = new char[n2];

                    array2 = llenando(n2);
                    array = llenando(n1);
                    System.out.println("Conjuntos generados: ");
                    
                    System.out.print("SET1: ");
                    imprimir(array);

                    System.out.print("\nSET2: ");
                    imprimir(array2);

                    System.out.println("\n1. Interseccion");
                    System.out.println("2. Diferencia"
                            + "\n Ingrese una opcion: ");
                    int opcion2 = duki.nextInt();

                    if (opcion2 == 1) {
                        System.out.println("INTERSECTION(SET1,SET2): ");
                        imprimir(interseccion(array,array2));
                    } else if (opcion2 == 2) {
                        System.out.println("DIFFERENCE(SET1,SET2): ");
                    } else {
                        System.out.println("Ingrese solo una de las opciones mostradas");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el tamano del arreglo a generar: ");
                    int tama = duki.nextInt();
                    int tamano[] = new int[tama];
                    
                    if (tama<1){
                        System.out.println("debe de ser mayor que 1");
                    }
                    else{
                    System.out.print("\nIngrese el limite INFERIOR: ");
                    int inferior = duki.nextInt();
                    int limite1[] = new int[inferior];
                    
                    System.out.print("\nIngrese el limite SUPERIOR: ");
                    int superior = duki.nextInt();
                    int limite2[] = new int[superior];
                    
                    if (superior>inferior){
                        System.out.println("");
                        imprimir2(limite1=genRandArray(tama,inferior,superior));
                        System.out.println("");
                        imprimir2(limite2=getTotalPrimeCount(limite1));
                        System.out.println("");
                        
                    }
                    else{
                        System.out.println("el numero superior debe de ser mayor al inferior");
                    }
                    }// fin del else de tamano
                    break;

                default:
                    System.out.println("Ingrese solo 1 o 2!!");
            }
        System.out.println("\n*****MENU*****"
                + "\n[1] Conjuntos"
                + "\n[2] Cuantos primos tienes?"
                + "\n[3] Salir del programa"
                + "\nIngrese su opcion:");
            opcion = duki.nextInt();
        }
    }

    public static void imprimir(char size[]) {
        for (int i = 0; i < size.length; i++) {
            System.out.print("[" + size[i] + "]");
        }
    }// fin de imprimir
    
       public static void imprimir2(int size[]) {
        for (int i = 0; i < size.length; i++) {
            System.out.print("[" + size[i] + "]");
        }
    }// fin de imprimir


    public static int[] size(int size) {
        int temporal[] = new int[size];
        for (int i = 0; i < size; i++) {
            temporal[i] = duki.nextInt();
        }
        return temporal;
    }// fin del public size

    
    public static char[] llenando(int size) {
        char[] letra = new char[size];
        for (int i = 0; i < size; i++) {
            int alat = rndm.nextInt(8) + 65;
            letra[i] = (char) alat;
        }
        return letra;
    }

   public static char[] interseccion(char[] se1, char[] se2) {
        char  num = 0;
        if (se1.length > se2.length){
        num = (char) se2.length;
        }else if (se2.length>se1.length){
           num = (char) se1.length; 
        }
        char intersec[] = new char[num];
        for (int i = 0; i < se1.length-1; i++) {
            for (int j = 0; j < se2.length-1; j++) {
                if (se1[i] == se2[j]) {
                    intersec[i] = se1[i];
                }
            }
        }
        return intersec;
    }
    
    
    public static int [] genRandArray (int num1,int num2, int num3){
        int numtotal[]=new int [num1];
         for (int i = 0; i < num1; i++) {
            int alateorio = rndm.nextInt((num3-num2)+1)+num2;
            numtotal[i]= alateorio;
        }
        return numtotal;
    }
     
    
    public static boolean isPrime(int num){
        boolean primo=false;
        int cont=0;
        for (int i=1;i<num+1;i++){
            if (num%i==0){
                cont++;
            }
        }
            if (cont<=2){
                primo=true;
            }
            else{
                primo=false;
            }
        
        return primo;
    }// fin de boolean
    
    public static int countPrimeFactors(int num){
           int cont2=0;
        for (int i=1;i<num;i++){
            if (num%i==0 && isPrime(i)){
                cont2++;
            }
        }
             return cont2;
        }
    
    public static int []getTotalPrimeCount(int[]enteros){
        int ent[]=new int [enteros.length];
         for (int i = 0; i < enteros.length; i++) {
         ent[i]=countPrimeFactors(enteros[i]);
         }
       return ent;
    }
    


}// fin de la clase
