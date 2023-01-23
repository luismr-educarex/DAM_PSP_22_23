package es.psp.unidad2.practicas.carreraanimales;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class formVentana  extends JFrame {
      
        JPanel[] panelAnimal;
        JLabel[] labelAnimal;
        String[] nombres = {"Uno","Dos","Tres"};
        JButton btnEmpezar;
        int anchoVentana = 900;
        
    public formVentana() {

        setLayout(new  GridLayout(0,1));
        
        panelAnimal = new JPanel[3];
        labelAnimal = new JLabel[3];
        
        for (int i= 0;i<3;i++){
            panelAnimal[i] = new JPanel();
            add(panelAnimal[i]);
            labelAnimal[i] = new JLabel(nombres[i]);
            labelAnimal[i].setIcon(new ImageIcon (getClass().getResource("caracol.png")));
            labelAnimal[i].setLocation(0, 0);
            panelAnimal[i].add(labelAnimal[i]);
           
        }
     btnEmpezar = new JButton("Empezar");
     btnEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	//este método es el que se ejecuta cuando se le da al botón "Empezar"
                
            }
        });
      add(btnEmpezar);
      
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(20,20);
      setSize(anchoVentana,600);
      setVisible(true);
      setTitle("Carrera animales");
      setResizable(false);

      
    }
   
    
}
