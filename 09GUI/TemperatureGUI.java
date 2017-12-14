import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureGUI extends JFrame implements ActionListener{
    private Container pane;
    private JButton CtoF;
    private JButton FtoC;
    private JTextField temperature;
    private JTextField result;


    public TemperatureGUI(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  
	CtoF = new JButton("CtoF Convert");
	FtoC = new JButton("FtoC Convert");
	temperature = new JTextField("Enter Temperature Here",12);
	result=new JTextField(12);
	CtoF.addActionListener(this);
	FtoC.addActionListener(this);
	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(temperature);
	result.setEditable(false);
	pane.add(result);
		

    }

    public static void main(String[] args) {
     TemperatureGUI g = new TemperatureGUI();
     g.setVisible(true);
    }
    
    
    

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	try{
	   double t= Double.parseDouble(temperature.getText());
	   if(e.getSource() == CtoF){
	       t=((t*(1.8)+32));
	       result.setText(""+t);
	   }
	   else{
	       t=((t-32)/1.8);
	       result.setText(""+t);
	       
	   }
	}
	catch(Exception NumberFormatException){
	    result.setText("It is not a number");
	}
	
	
    }
    

}
