/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_carlosfortin_11911015;

/**
 *
 * @author Carlos Fortin
 */
import java.util.Random;
import java.util.Scanner;
public class Lab1_CarlosFortin_11911015 {

    /**
     * @param args the command line arguments
     */
    public static Random rand=new Random();
    public static Scanner leer=new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        
        //ejercicio 1
        System.out.println("Laboratorio 1");
        System.out.println("Ejercicio 1");
        int[][] matrix=fillMatrix(4,4);
        System.out.println("La matriz generada es: ");
        printMatrix(matrix,0,0);
        System.out.println("La suma de los elementos de la matriz generada es: "+sumMatrix(matrix,0,0));
        System.out.println();
        //ejercicio 2
        System.out.println("Ejercicio 2");
        int[][] matrix2=fillMatrix(4,4);
        int[] posibles=new int[16];
        int cont=0,div;
        System.out.println("Ingrese un numero: ");
        div=leer.nextInt();
        printMatrix(matrix2,0,0);
        posibles=posiblesDivisores(matrix2,posibles,cont,0,0,div);
        System.out.println();
        printArray(posibles,0);
        
        
        
    }//fin main
    
    public static void printMatrix(int[][] matrix,int f,int c){
        
        if(f==matrix.length-1 && c==matrix[0].length-1)
            System.out.println("["+matrix[f][c]+"]"+" ");
        else
        {
            if(c==matrix[0].length-1)
            {
                System.out.println("["+matrix[f][c]+"]");
                printMatrix(matrix,f+1,0);
            }
            else
            {
                System.out.print("["+matrix[f][c]+"]"+" ");
                printMatrix(matrix,f,c+1);
            }
        }
        
    }
    
    public static int sumMatrix(int[][] m,int f,int c){
        
        if(f==m.length-1 && c==m[0].length-1)
            return m[f][c];
        else
        {
            if(c==m[0].length-1)
            {
                return m[f][c]+sumMatrix(m,f+1,0);
            }
            else
            {
                return m[f][c]+sumMatrix(m,f,c+1);
            }
        }
        
    }
    
    public static int[][] fillMatrix(int f,int c){
        
        int[][] temporal=new int[f][c];
        for(int i=0;i<f;i++)
        {
            for(int j=0;j<c;j++)
            {
                temporal[i][j]=1+rand.nextInt(20);
            }
        }
        
        return temporal;
    }
    
    public static int[] posiblesDivisores(int[][] m,int[] p,int cont,int f,int c,int div){
        
        if(f==m.length-1 && c==m[0].length-1)
        {
            if(m[f][c]%div==0)
            {
                p[cont]=m[f][c];
            }
        }
        else
        {
            if(c==m[0].length-1)
                if(m[f][c]%div==0)
                {
                    p[cont]=m[f][c];
                    posiblesDivisores(m,p,cont+1,f+1,0,div);
                }
                else
                {
                    p[cont]=0;
                    posiblesDivisores(m,p,cont+1,f+1,0,div);
                }
            else
                if(f==m.length-1)
                    if(m[f][c]%div==0)
                {
                    p[cont]=m[f][c];
                    posiblesDivisores(m,p,cont+1,f,c+1,div);
                }
                else
                {
                    p[cont]=0;
                    posiblesDivisores(m,p,cont+1,f,c+1,div);
                }
            
        }
        
        return p;
        
    }
    
    public static void printArray(int[] p,int e){
        
        if(e==p.length-1)
            //if(p[e]!=-1)
                System.out.println("["+p[e]+"]");
        else
            //if(p[e]!=-1)
            {
                System.out.print("["+p[e]+"]"+" ");
                printArray(p,e+1);
            }
    }
    
}
