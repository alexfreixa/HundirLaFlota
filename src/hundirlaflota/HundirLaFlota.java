/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author Alex Freixa i Max Freixa
 */
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        int t = 0;
        int n = 0;
        
        int nombreVaixells = nombreVaixells();
        int[] midaVaixell = midaVaixells(nombreVaixells);
        int midaTaulell = midaTaulell();
        
        int[][] taulell = generaTaulell(midaTaulell, midaVaixell);
        buscaZero(taulell, midaVaixell);
        dibuixaTaulell(taulell);
        
    }

    public static int nombreVaixells() {

        Scanner in = new Scanner(System.in);
        int nombreVaixells;

        do {

            System.out.print("Introdueix el nombre de vaixells (màxim 10): ");
            nombreVaixells = in.nextInt();
            
        } while (nombreVaixells > 0 && nombreVaixells > 10);
        
        if (nombreVaixells == 0) {
            acaba();
        }
        
        return nombreVaixells;
    }

    public static int[] midaVaixells(int nombreVaixells) {

        Scanner in = new Scanner(System.in);
        int[] vaixells = new int[nombreVaixells];
        
        for (int i = 0; i < vaixells.length; i++) {
            System.out.print("Introdueix la mida del vaixell " + (i+1) +": ");
            vaixells[i] = in.nextInt();
        }
        
        return vaixells;
    }

    public static int midaTaulell() {

        Scanner in = new Scanner(System.in);
        int midaTaulell;
        
        do {

            System.out.print("Introdueix la mida del taulell: ");
            midaTaulell = in.nextInt();
            
        } while (midaTaulell < 0 || midaTaulell >= 128);
        
        return midaTaulell;

    }
    
    public static int[][] generaTaulell(int midaTaulell, int[] midaVaixell) {

        int[][] taulell = new int[midaTaulell][midaTaulell];

        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell.length; j++) {
                System.out.print(taulell[i][j]);
            }
            System.out.println();
        }
        
        return taulell;
        
    }
    
    public static int[][] buscaZero(int[][] taulell, int[]midaVaixell) {
        
        int minim = 0;
        int maxim = taulell.length;
        int colocats = 0;

        for (int i = 0; i < midaVaixell.length; i++) {
        
        int x = (int) (Math.random() * maxim) + minim;
        int y = (int) (Math.random() * maxim) + minim;
        int mida = midaVaixell[i];
        
            try {

                for (int j = 0; j < mida; j++) {
                    
                    switch(casAleatori()) {
            
                    case 1:
                        //Amunt
                        taulell[x-j][y] = 1;
                      break;

                    case 2:
                      //Avall
                        taulell[x + j][y] = 1;
                      break;

                    case 3:
                      //Dreta
                        taulell[x][y+j] = 1;
                      break;

                    case 4:
                      //Esquerra
                        taulell[x][y-j] = 1;
                      break;

                    case 5:
                      //Amunt-Esquerra
                        taulell[x-j][y-j] = 1;
                      break;

                    case 6:
                      //Amunt-Dreta
                        taulell[x-j][y+j] = 1;
                      break;

                    case 7:
                      //Avall-Esquerra
                        taulell[x+j][y+j] = 1;
                      break;

                    case 8:
                      //Avall-Dreta
                        taulell[x-j][y-j] = 1;
                      break;

                    default:
                      //
                }
                    
                }

            } catch (Exception e) {

                System.out.println("Something went wrong: " + e);

            }
        
        }
        
        return taulell;
            
    }
    
    public static void dibuixaTaulell(int[][] taulell) {

        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell.length; j++) {
                System.out.print(taulell[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        
    }
    
    public static int casAleatori() {
        int aleatori = (int) (Math.random() * 1) + 1;
        return aleatori;
    }

    
    public static void acaba() {
        
        //Acaba el programa
        
    }

}


/*


                if (taulell[x-j][y] == 0) { //Amunt
                    
                    taulell[x-j][y] = 1;
                    
                }
            
                else if (taulell[x + j][y] == 0) { //Avall
                    
                    taulell[x + j][y] = 1;
                    
                } else if (taulell[x][y+j] == 0) { //Dreta
                    
                    taulell[x][y+j] = 1;
                        
                    
                } else if (taulell[x][y-j] == 0) { //Esquerra
                    
                    taulell[x][y-j] = 1;
                    
                } else if (taulell[x-j][y-j] == 0) { //Diagonal Amunt-Esquerra
                    
                    taulell[x-j][y-j] = 1;
                    
                } else if (taulell[x-j][y+j] == 0) { //Diagonal Amunt-Dreta
                    
                    taulell[x-j][y-j] = 1;
                    
                } else if (taulell[x+j][y-j] == 0) { //Diagonal Avall-Esquerra
                    
                    taulell[x+j][y+j] = 1;
                
                } else if (taulell[x+j][y+j] == 0) { //Diagonal Avall-Dreta
                    
                    taulell[x-j][y-j] = 1;
                    
                } else {
                    System.out.println("-");
                }





                        for (int z = 0; z < mida; z++){
                            
                            if ((x-j > 0) && (y > 0)) { //Si es positiu (es a dir que estem buscant dins el taulell).
                                if (taulell[x-j][y] == 0) { //Si hi ha "mar", es a dir "0".
                                    comptador++; //Compta que es pot posar en aquesta posicio.
                                } else {
                                    System.out.println("|||||||||||<<<NO SEGUEIX MAR>>>|||||||||||");
                                    comptador = 0;
                                    break;
                                }
                            } else {
                                System.out.println("|||||||||||<<<REINICIANT>>>|||||||||||");
                                comptador = 0;
                                break;
                            }
                            
                        } //Comprova si on hi busca és dins el taulell i hi ha "0".

                        if (comptador == mida) {
                            
                            System.out.println("Comptador: " + comptador + ", Mida: " + mida);
                            
                            for (int k = 0; k < mida; k++) {
                                taulell[x-j][y] = 1;
                                comptador = 0;
                                colocats++;
                            }
                            
                        } //Si el comptador ha sumat el mateix numero que la mida especifica del vaixell, farà els canvis al taulell


*/