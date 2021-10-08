/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import java.util.Arrays;

/**
 *
 * @author celes
 */
public class mlr {
    private double fin[];

   
   public double []  mlr (double datos[][]){
       mlr mrl=new mlr();
       double x[][]= mrl.MatrizNormal_x(datos);
       double xt[][]= mrl.traspuesta_xt(datos);
       double multiplicar[][]=mrl.Multiplicar_x_xt(datos, x, xt);
       double deter= mrl.determinante(multiplicar);
       double adjunta[][]= mrl.adjunta(multiplicar,deter);
       double ma [] = mrl.Multiplicar_y_por_xt(xt, datos);
       fin=mrl.calculandoFinal(adjunta, ma);
       return fin;
    }
    /*public static void main(String[] args) {
        double[][] datos= new double[][]{
				{41.9,29.1,251.3},
				{43.4,29.3,251.3},
				{43.9,29.5,248.3},
				{44.5,29.7,267.5},
				{47.3,29.9,273},
				{47.5,30.3,276.5},
				{47.9,30.5,270.3},
				{50.2,30.7,274.9},
				{52.8,30.8,285},
                                {53.2,30.9,290},
				{56.7,31.5,297},
				{57,31.7,302.5},
				{63.5,31.9,304.5},
				{65.3,32,309.3},
				{71.1,32.1,321.7},
				{77,32.5,330.7},
				{77.8,32.9,349}
				};
        mlr mrl=new mlr();
        double x[][]= mrl.MatrizNormal_x(datos);
        double xt[][]= mrl.traspuesta_xt(datos);
       double multiplicar[][]=mrl.Multiplicar_x_xt(datos, x, xt);
       double deter= mrl.determinante(multiplicar);
       double adjunta[][]= mrl.adjunta(multiplicar,deter);
       double ma [] = mrl.Multiplicar_y_por_xt(xt, datos);
       double[] i=mrl.calculandoFinal(adjunta, ma);
       
       predicciones p=new predicciones();
        System.out.println( p.TheNormalequationapproach(i,80.5, 33.7));
        System.out.println( Arrays.toString(p.GradientDescent(5.5,80.5, 33.7)));
       
    }*/
    public double [][] traspuesta_xt(double datos [][]){
        double traspuesta[][] = new double[datos[0].length][datos.length];
        
         for (int i = 0; i < datos.length; i++) {
                traspuesta[0][i]=1;
                traspuesta[1][i]=datos[i][0];
                traspuesta[2][i]=datos[i][1]; 
        }
        
        
         return traspuesta;
    }
    
    public double[][] MatrizNormal_x(double datos[][]){
         double matriz1[][]= new double[datos.length][datos[0].length];
         for (int i = 0; i < datos.length; i++) {
                matriz1[i][0]=1;
                matriz1[i][1]=datos[i][0];
                matriz1[i][2]=datos[i][1]; 
        }
        
        return matriz1;
    }
    
    public double []  Multiplicar_y_por_xt(double traspuesta[][], double [][]datos){
         double mult[]=new double[3];
        for (int i = 0; i < datos.length; i++) {
             
         mult[0]+=datos[i][2]*traspuesta[0][i];
         mult[1]+=datos[i][2]*traspuesta[1][i];
         mult[2]+=datos[i][2]*traspuesta[2][i];
            
        }
        
     //   System.out.println(Arrays.toString(mult));
        return mult;
    }
    
    public  double [][] Multiplicar_x_xt (double datos[][], double x[][],double xt[][]){
        double [][] x_xt = new double[3][3];
        
        for (int i = 0; i < datos.length; i++) {
            x_xt[0][0]+=x[i][0]*xt[0][i];
            x_xt[0][1]+=x[i][0]*xt[1][i];
            x_xt[0][2]+=x[i][0]*xt[2][i];
            
            x_xt[1][0]+=x[i][1]*xt[0][i];
            x_xt[1][1]+=x[i][1]*xt[1][i];
            x_xt[1][2]+=x[i][1]*xt[2][i];
            
            x_xt[2][0]+=x[i][2]*xt[0][i];
            x_xt[2][1]+=x[i][2]*xt[1][i];
            x_xt[2][2]+=x[i][2]*xt[2][i];
        }
      // System.out.println("Normal; "+ Arrays.deepToString(x_xt));
        return x_xt;
    }
    
    public  double  determinante(double x_xt[][]){
        double determinante;
        double dete[][] =new double[3][5];
        //dete=x_xt;
        
        for (int i = 0; i < x_xt.length; i++) {
            
            dete[i][0]= x_xt[i][0];
            dete[i][1]= x_xt[i][1];
            dete[i][2]= x_xt[i][2];
            dete[i][3]= x_xt[i][0];
            dete[i][4]=x_xt[i][1];
        }
        
      //  System.out.println(Arrays.deepToString(dete));
       double a = (dete[0][0]*dete[1][1]*dete[2][2])+(dete[0][1]*dete[1][2]*dete[2][3])+(dete[0][2]*dete[1][3]*dete[2][4]);
       double b = (dete[2][0]*dete[1][1]*dete[0][2])+(dete[2][1]*dete[1][2]*dete[0][3])+(dete[2][2]*dete[1][3]*dete[0][4]);
       determinante= a-b;
        return  determinante;
    }

    public double [][] adjunta (double xt[][] ,double  d){
    //calculo de adjuntos
    //para poder dividirlo entre la determunante
      double adjunta[][] =new double[3][3];
      
    
       adjunta[0][0]=((xt[1][1]*xt[2][2]) - (xt[1][2]*xt[2][1]))/d;
       adjunta[0][1]=(-((xt[1][0]*xt[2][2]) - (xt[1][2]*xt[2][0])))/d;
       adjunta[0][2]=((xt[1][0]*xt[2][1]) - (xt[1][1]*xt[2][0]))/d;
       
       adjunta[1][0]=(-((xt[0][1]*xt[2][2]) - (xt[0][2]*xt[2][1])))/d;
       adjunta[1][1]=((xt[0][0]*xt[2][2]) - (xt[0][2]*xt[2][0]))/d;
       adjunta[1][2]=(-((xt[0][0]*xt[2][1]) - (xt[0][1]*xt[2][0])))/d;
       
       adjunta[2][0]=((xt[0][1]*xt[1][2]) - (xt[0][2]*xt[1][1]))/d;
       adjunta[2][1]=(-((xt[0][0]*xt[1][2]) - (xt[0][2]*xt[1][0])))/d;
       adjunta[2][2]=((xt[0][0]*xt[1][1]) - (xt[0][1]*xt[1][0]))/d;
       
       
            return adjunta;
    }

    public  double []  calculandoFinal(double [][]inversa, double []y_xt){
        double fin []= new double[3];
        
         
            fin[0]=(inversa[0][0]*y_xt[0])+(inversa[0][1]*y_xt[1])+(inversa[0][2]*y_xt[2]);
            fin[1]=(inversa[1][0]*y_xt[0])+(inversa[1][1]*y_xt[1])+(inversa[1][2]*y_xt[2]);
            fin[2]=(inversa[2][0]*y_xt[0])+(inversa[2][1]*y_xt[1])+(inversa[2][2]*y_xt[2]);
            
         
       // System.out.println(Arrays.toString(fin));
        return fin;
        
    }
}
