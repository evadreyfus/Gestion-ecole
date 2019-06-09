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
public class MenuRechercheEleve extends JFrame {
    
    public MenuRechercheEleve()
    {
        this.setTitle("Gestion école - Etudiant");
                this.setSize(600,400);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null); 
             
        
		JPanel panel = new JPanel();
                
                JButton b_menu = new JButton ("MENU");
                b_menu.setForeground(Color.BLUE);
                b_menu.setFont(new java.awt.Font("Century",1,14));
               
                
		JButton b_bulletin = new JButton("Bulletin");
                JButton b_classe = new JButton("Classe");
                
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
                
                Panneau p4 = new Panneau();
                p4.setLayout(new BoxLayout(p4,BoxLayout.PAGE_AXIS));
                
                p1.add(l_nom);
                p1.add(nom);
                
                p2.add(l_prenom);
                p2.add(prenom);
                
                p3.add(b_bulletin);
                p3.add(b_classe);
                
                p4.add(b_menu);
                
                panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                panel.add(p1);
                panel.add(p2);
                panel.add(p3);
                panel.add(p4);
                
                this.getContentPane().add(panel);
                this.setVisible(true);
                
                  b_bulletin.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                   
                    PersonneDAO eleveDAO= new PersonneDAO();
                    Personne eleve=eleveDAO.find(nom.getText(),prenom.getText(),1); 
                    MenuBulletinEleve menuEleve = new MenuBulletinEleve(eleve);
                    
                    }
                });
                  
                 b_classe.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent event){
                         PersonneDAO eleveDAO = new PersonneDAO();
                         Personne eleve = eleveDAO.find(nom.getText(),prenom.getText(),1);
                         MenuClasseEleve menuClasse = new MenuClasseEleve(eleve);
                     }
                 });
                  
                  b_menu.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){                        
                        MenuChoix m = new MenuChoix();                       
                    }
                });
    }
}