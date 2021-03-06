package com.company;

import java.util.Scanner;

public class Main {
private static class PrimosEntreSi extends Exception{

}

    public static void main(String[] args) throws PrimosEntreSi, InterruptedException {
        // write your code here
        int a = 0;
        int b = 0;
        boolean correcto = false;
        Scanner leer = new Scanner(System.in);
        while (!correcto) {
            while (!correcto) {
                System.out.println("Introduzca longitud del marco");
                try {
                    a = leer.nextInt();
                    leer.nextLine();
                    correcto = true;
                } catch (Exception e) {
                    System.out.println("Numero no valido");
                    leer.nextLine();
                }
            }
            correcto = false;
            while (!correcto) {
                System.out.println("Introduzca altura del marco");
                try {
                    b = leer.nextInt();
                    leer.nextLine();
                    correcto = true;
                } catch (Exception e) {
                    System.out.println("Número no válido");
                    leer.nextLine();
                }
            }
           // try {
            long inicio = System.currentTimeMillis();
            Thread.sleep(2000);
                System.out.println("Las baldosas deberán medir  " + BuscaMCD(a, b));
                long fin= System.currentTimeMillis();
                double tiempo = (double) ((fin-inicio/1000));
            System.out.println("MCD tarda "+tiempo+" segundos");

            long inicio2=System.currentTimeMillis();
            Thread.sleep(2000);
               System.out.println("Las baldosas deberán medir  "+calcularCuerda(a,b));
              long fin2=System.currentTimeMillis();
            double tiempo2 = (double) ((fin2-inicio2/1000));
            System.out.println("Con recursividad tarda "+tiempo2+" segundos");
                long medidaBaldosa = BuscaMCD(a,b);
                System.out.println("Por lo tanto haran falta "+ CalcularBaldosas(medidaBaldosa,a,b) + " baldosas");
                correcto=true;
         /*   } catch (PrimosEntreSi e) {
                System.out.println("Las medidas son primas entre si.");
                correcto = false;
            }*/
        }
    }

    private static long CalcularBaldosas(long medidaBaldosa, int a, int b) {
        long baldosasTotal = (a/medidaBaldosa) * ( b/medidaBaldosa);
        return baldosasTotal;
    }

    private static long BuscaMCD(int a, int b) /*throws PrimosEntreSi*/ {
        int contador = 1;
        long mcd = 0;
        if (a > b) {
            while (contador <= b) {
                if ((a % contador) == 0 && (b % contador) == 0) {
                    mcd = contador;
                }
                contador++;
            }
        } else {
            while (contador <= a) {
                if ((a % contador == 0) && (b % contador == 0)) {
                    mcd = contador;
                }
                contador++;
            }
        }
     /*   if (mcd==1) {
            throw new PrimosEntreSi();
        }*/
        return mcd;
    }

    public static long calcularCuerda(int a, int b){
    if (a==b) return a;
    if (a>b)  {return calcularCuerda(a-b , b);}
    else {return calcularCuerda(a,b-a);}
    }
}
