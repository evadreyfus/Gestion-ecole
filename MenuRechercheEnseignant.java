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
import controleur.Connexion;
import java.sql.SQLException;
import modele.*;
/**
 *
 * @author evadr
 */
public class MenuRechercheEnseignant extends JFrame {
    
    public MenuRechercheEnseignant()
    {
        this.setTitle("Gestion école - Enseignant");
                this.setSize(600,400);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null); 
             
        
		JPanel panel = new JPanel();
                
		JButton b_rechercher = new JButton("Rechercher");
                
		JLabel l_nom = new JLabel("Nom : ");
                ZoneTexte nom = new ZoneTexte();
                
		JLabel l_prenom = new JLabel("Prénom : ");
                ZoneTexte prenom = new ZoneTexte();
                
                Panneau p1 = new Panneau();
                p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
                
                Panneau p2= new Panneau();
                p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
                
                Panneau p3 = new Panneau();
                p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
                
                p1.add(l_nom);
                p1.add(nom);
                
                p2.add(l_prenom);
                p2.add(prenom);
                
                p3.add(b_rechercher);
                
                panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                panel.add(p1);
                panel.add(p2);
                panel.add(p3);
                
                
                this.getContentPane().add(panel);
                this.setVisible(true);
                
                  b_rechercher.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                   
                    PersonneDAO enseignantDAO= new PersonneDAO();
                    Personne enseignant=enseignantDAO.find(nom.getText(),prenom.getText(),2); 
                    MenuEnseignant menuEnseignant = new MenuEnseignant(enseignant);
                    
                    }
                });
    }
}
