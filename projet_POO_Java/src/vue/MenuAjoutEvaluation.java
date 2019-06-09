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
public class MenuAjoutEvaluation extends JFrame {
    public MenuAjoutEvaluation(Integer detailbulletin)
    {
        
        
        this.setTitle("Gestion école - Ajout Evaluation");
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
        
        JButton b_ajout = new JButton("Ajouter");
        
        JLabel l_note = new JLabel("Note : ");
        ZoneTexte note = new ZoneTexte();
        note.setMaximumSize(new Dimension(150,30));
        
        
        JLabel l_appreciation = new JLabel("Appréciation : ");
        ZoneTexte appreciation = new ZoneTexte();
        note.setMaximumSize(new Dimension(150,30));

        
        p1.add(l_note);
        p1.add(note);
        
        p2.add(l_appreciation);
        p2.add(appreciation);
        
        p3.add(b_ajout);
        
        Panneau p5 = new Panneau();

        JButton b_menu = new JButton ("MENU");
        b_menu.setForeground(Color.BLUE);
        b_menu.setFont(new java.awt.Font("Century",1,14));

        p5.setLayout(new BoxLayout(p5,BoxLayout.PAGE_AXIS));

        p5.add(b_menu);

        b_ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EvaluationDAO evalDAO = new EvaluationDAO();
                double d = Double.parseDouble(note.getText());
                Evaluation eval = new Evaluation(detailbulletin,d,appreciation.getText());
                evalDAO.create(eval);
                MenuChoix menuChoix = new MenuChoix();
            }
        });
        
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