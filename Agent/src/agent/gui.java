/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author celes
 */
public class gui extends JFrame {
    private agent myAgent;
    private JTextField xValueField;
    private JTextField xValueField2;
    private JTextField valorGradiente;
     private JTextField pasoA;
    gui(agent a){
        super(a.getLocalName());
        
        myAgent =a;
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        p.add(new JLabel("Ingresa Valor :"));
        xValueField = new JTextField(15);
        p.add(xValueField);

        p.add(new JLabel("Ingresa Valor :")); 
        xValueField2 = new JTextField(15); 
        p.add(xValueField2); 

        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Calcular The Normal equation approach ");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String xValue2 = xValueField2.getText().trim();
                    String xValue= xValueField.getText().trim();
                    myAgent.predecir(Double.parseDouble(xValue), Double.parseDouble(xValue2)); 
                    xValueField.setText("");
                    xValueField2.setText("");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(gui.this, "valor invalido"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }); 
            p = new JPanel();
	    p.add(addButton);
	    getContentPane().add(p, BorderLayout.SOUTH);
           
            
     
        
        p.add(new JLabel("Ingresa Valor para calcular gradiente srl:")); 
        valorGradiente= new JTextField(15); 
        p.add(valorGradiente); 
        
        
        
             JButton Button = new JButton("Calcular Gradient Descent ");
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String valorGradient = valorGradiente.getText().trim();
                    
                    myAgent.predecir2( Double.parseDouble(valorGradient)); 
                    valorGradiente.setText("");
                    pasoA.setText("");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(gui.this, "valor invalido"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }); 
        
	    p.add(Button);
	    getContentPane().add(p, BorderLayout.SOUTH);
             setResizable(false);
    }
    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}
    
}
