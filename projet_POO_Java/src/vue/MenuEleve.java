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
 * @author xavier.barras
 */
public class MenuEleve extends JFrame{
    public MenuEleve(Personne eleveDAO){
        Personne eleve = new Eleve(eleveDAO.getPk_id(),eleveDAO.getNom(),eleveDAO.getPrenom(),eleveDAO.getType());
        
        this.setTitle("Gestion école - Etudiant");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        
        Lab nom = new Lab("Nom : " + eleve.getNom());
        Lab prenom = new Lab("Prénom : " + eleve.getPrenom());
        
        p1.add(nom);
        p2.add(prenom);
        
        panel.add(p1);
        panel.add(p2);
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
