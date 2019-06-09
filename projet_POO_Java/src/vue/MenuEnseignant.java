/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import modele.Eleve;
import modele.Personne;


/**
 *
 * @author evadr
 */
public class MenuEnseignant extends JFrame{
    public MenuEnseignant(Personne enseignantDAO){
        Personne enseignant = new Eleve(enseignantDAO.getPk_id(),enseignantDAO.getNom(),enseignantDAO.getPrenom(),enseignantDAO.getType());
        
        this.setTitle("Gestion école - Enseignant");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        JButton b_menu = new JButton ("MENU");
        b_menu.setForeground(Color.BLUE);
        b_menu.setFont(new java.awt.Font("Century",1,14));
        
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        
        Lab nom = new Lab("Nom : " + enseignant.getNom());
        Lab prenom = new Lab("Prénom : " + enseignant.getPrenom());
        
        p1.add(nom);
        p2.add(prenom);
        p3.add(b_menu);
        
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        this.getContentPane().add(panel);
        this.setVisible(true);
        
        b_menu.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){                        
                        MenuChoix m = new MenuChoix();                       
                    }
         });
    }
}