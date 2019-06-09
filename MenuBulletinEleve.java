/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import modele.*;
import java.util.ArrayList;
import DAO.*;


/**
 *
 * @author evadr
 */
public class MenuBulletinEleve extends JFrame{
   MenuBulletinEleve(Personne eleveDAO){
        Personne eleve = new Eleve(eleveDAO.getPk_id(),eleveDAO.getNom(),eleveDAO.getPrenom(),eleveDAO.getType());
        
        ArrayList<AffichageDetailBulletin> list = eleve.findAllDetailBulletin();        
        
        this.setTitle("Gestion école - Eleve");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        
        p1.setMinimumSize(new Dimension(300,100));
        p2.setMinimumSize(new Dimension(300,100));
        p3.setMinimumSize(new Dimension(300,100));

        Lab nom = new Lab("Nom : " + eleve.getNom());
        Lab prenom = new Lab("Prénom : " + eleve.getPrenom());
        
        p1.add(nom);
        p2.add(prenom);
        p3.add(new Lab("Matière  Moyenne  Appreciation"));
        
        
        for(int i=0;i<list.size();i++){
            p3.add(new Lab(list.get(i).affichage()));
            p3.add(this.goTo(list.get(i).getIdDetail(),list.get(i).getNom()));
        }
       
        
        Panneau p5 = new Panneau();

        JButton b_menu = new JButton ("MENU");
        b_menu.setForeground(Color.BLUE);
        b_menu.setFont(new java.awt.Font("Century",1,14));

        p5.setLayout(new BoxLayout(p5,BoxLayout.PAGE_AXIS));

        p5.add(b_menu);

        b_menu.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent event){                        
                                MenuChoix m = new MenuChoix();                       
                            }
                 });
        
        
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p5);
       
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
    
    public JButton goTo(Integer idDB,String matiere){
        JButton jb = new JButton("Détails");
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                MenuEvaluation menuEval = new MenuEvaluation(idDB,matiere);
            }
        });
        
        return jb;
    }
}
