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
public class predicciones {
    
    public double TheNormalequationapproach(double [] b, double n1, double n2){
        double r;
        r= b[0]+(b[1]*n1)+(b[2]*n2);
        return r;
    }
    
    public double [] GradientDescent(double ps,double  x, double z){
        
        //respecto  a esta ecuacion y=b0 +b1 (x1) + b2(x2)
        //sacar las derivadas parciales
        //formulas
        //x*ps(Derivada parcial x)
        //x*ps(Derivada parcial z)
        
        double derivadaParcialX=1.238723269;
        double derivadaParcialZ=12.08235332;
        
        double y[]=new double[2];
        
        y[0]=x*ps*derivadaParcialX;
        y[1]=x*ps*derivadaParcialZ;
        
        return y;
        
    }
    
    
}
