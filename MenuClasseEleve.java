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
public class MenuClasseEleve extends JFrame {
    public MenuClasseEleve(Personne eleveDAO)
    {
        Personne eleve = new Eleve(eleveDAO.getPk_id(),eleveDAO.getNom(),eleveDAO.getPrenom(),eleveDAO.getType());
        
        ArrayList<AffichageClasse> list = eleve.findAllStudentClass();
       //ArrayList<String> list 
        
        this.setTitle("Gestion école - Classe Etudiant");
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

        Lab classe = new Lab("Classe : " + list.get(0).getClasse());
      
        
        p1.add(classe);
        
        for(int i=0;i<list.size();i++){
            
            
            p3.add(new Lab(list.get(i).affichage()));
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
    
}