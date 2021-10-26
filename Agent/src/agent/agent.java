/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ReceiverBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author celes
 */
public class agent  extends Agent {
    gui gui;
    static double[][] datos= new double[][]{
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
    public void setup(){
        System.out.println("Hola Mundo");
        gui gui = new gui(this);
	gui.showGui(); 
        
    }
    protected void takeDown() {
        gui.dispose();
    }
    public void predecir( double n1, double n2){
        addBehaviour(new OneShotBehaviour() {
            public void action() {
              
                  
               mlr m= new mlr();
               double [] fin= m.mlr(datos);
                System.out.println("yi="+fin[0]+"+"+fin[1]+"("+n1+")"+fin[2]+"("+n2+")");
               predicciones p=new predicciones();
             System.out.println("y : " + p.TheNormalequationapproach(fin,n1,n2)); 
            }
        });
    }
    
    public void predecir2( double paso, double gradiente){
         
        addBehaviour(new SimpleBehaviour () {
         boolean finished = false;
            public void action() {
                double[][] dato= new double[][]{
				{3,1},
				{6,2},
				{9,3},
				{12,4},
				{15,5},
				{18,6},
				{21,7},
				{24,8},
				{27,9},
                                
				};
                  
                  
               gradiente g= new gradiente(dato,paso);
               g.error();
                System.out.println("el valor predecido es "+ g.predecir(gradiente));
               finished = true;
               /*double [] fin= m.mlr(datos);
               predicciones p=new predicciones();
               System.out.println("Y : " + p.GradientDescent(0.5,n1,n2)); 
                finished = true;*/
            }         

            @Override
            public boolean done() {
              return finished;
            }
    });
    }
    
    
}
