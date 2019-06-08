/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.*;
/**
 *
 * @author evadr
 */
public class MenuChoix extends JFrame{
    
    public MenuChoix()
    {
        this.setTitle("Gestion école - Choix");
                this.setSize(600,400);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                
        JPanel panel = new JPanel();
        
        JButton b_eleve = new JButton("Eleve");
        JButton b_enseignant = new JButton("Enseignant");
        
        Panneau p1 = new Panneau();
        p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
        
        p1.add(b_eleve);
        p1.add(b_enseignant);
                
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(p1);
        
        
        this.getContentPane().add(panel);
        this.setVisible(true);
        
                b_eleve.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        MenuRechercheEleve rechercheEleve = new MenuRechercheEleve();
                        
                    }
                });
                
                
                b_enseignant.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                            
                    }
                });       
                
       
    }
    
}