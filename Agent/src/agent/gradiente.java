/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

/**
 *
 * @author celes
 */
public class gradiente {
    double b0=0, b1=0, a=0.003;
    double datos[][];
    public gradiente(double datos[][]){
        this.datos=datos;
        
    }
  
   
    
    public double [] caculrInternos(){
        double internoYsumax[]=new double[2];
        for (int i = 0; i < datos.length; i++) {
           internoYsumax[0]+=(datos[i][0]-(b0+b1*datos[i][1]));
           internoYsumax[1]+= datos[i][1]*(datos[i][0]-(b0+b1*datos[i][1]));
        }      
        return internoYsumax;
    }
   
    public  void calcularBs(){
        
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[1];
     
              
        b0= (-2.0/datos.length)*interno;
        b1= (-2.0/datos.length)*sumaX;
      
       
    }
    public double error(){
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[1];
       
        double error = (1.0/datos.length)*(Math.pow(interno,2)) ;  //(interno * interno)Math.pow(interno,2)
        System.out.println("el error es " +error);
        for (int i = 0; i < 170000 ; i++) {
             
            caluclarNewBs();
            error = (1.0/datos.length)*(Math.pow(interno,2));
        }
        System.out.println("el error es " + error);
        System.out.println("las betas son b0: " +b0+" b1: "+b1 );
        return error;
        
    }
    public void caluclarNewBs(){
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[1];
        b0= b0 - (a*((-2.0/datos.length)*interno));
        b1= b1 - (a*((-2.0/datos.length)*sumaX));
    }
    
    public double predecir( double dato){
        return b0 + b1 * dato;
    }
}
