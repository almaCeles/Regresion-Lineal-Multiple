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
    public gradiente(double datos[][],double  paso){
        this.datos=datos;
        this.a=paso;
    }
    public void  yo() {
        System.out.println("8754");
    }
   
    
    public double [] caculrInternos(){
        double internoYsumax[]=new double[2];
        for (int i = 0; i < datos.length; i++) {
           internoYsumax[0]+=(datos[i][0]-(b0+b1*datos[i][1]));
           internoYsumax[1]+= datos[i][1];
        }      
        return internoYsumax;
    }
   
    public  void calcularBs(){
        
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[0];
        double b[]=new double[2];
              
        b0= (-2/datos.length)*interno;
        b1= (-2/datos.length)*(sumaX*interno);
      
       
    }
    public double error(){
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[1];
        double primera=(1/datos.length);
        double error = Math.pow(interno,2)*1/datos.length;  //(interno * interno)Math.pow(interno,2)
        System.out.println("el error es " + error);
        while(error >  0.5){
        
            interno=caculrInternos()[0] ;
            caluclarNewBs();
            error = (1/datos.length)*(Math.pow(interno,2));
        }
        System.out.println("el error es " + error);
        System.out.println("las betas son b0" +b0+" b1; "+b1 );
        return error;
        
    }
    public void caluclarNewBs(){
        double interno=caculrInternos()[0] ;
        double sumaX= caculrInternos()[1];
        b0= b0 - (a*interno);
        b1= b1 - (a*(sumaX*interno));
    }
    
    public double predecir( double dato){
        return b0 + b1 * dato;
    }
}
