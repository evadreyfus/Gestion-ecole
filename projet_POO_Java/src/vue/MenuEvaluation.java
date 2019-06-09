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
import modele.Evaluation;
import java.util.ArrayList;
/**
 *
 * @author xavier.barras
 */
public class MenuEvaluation extends JFrame {
    
    public MenuEvaluation(Integer idDetailBulletin, String matiere){
        EvaluationDAO evalDAO = new EvaluationDAO(); 
        ArrayList<Evaluation> list = evalDAO.findAllEvalForCourse(idDetailBulletin);
        
        this.setTitle("Gestion école - Evaluations");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        
        JPanel p4 = new JPanel();
        Panneau p5 = new Panneau();
        
        JButton b_menu = new JButton ("MENU");
        b_menu.setForeground(Color.BLUE);
        b_menu.setFont(new java.awt.Font("Century",1,14));
        
        JButton b_add = new JButton ("Ajouter evaluation");
        JButton b_delete = new JButton ("Supprimer evaluation");
        JButton b_update = new JButton ("Mettre à jour evaluation");
  
        p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
        p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
         
        p5.add(b_menu);
        
        p4.add(this.goToAdd(list.get(0).getFk_detailBulletin()));
        p4.add(new Lab("Note  Appréciation"));
        for(int i=0;i<list.size();i++){
            p4.add(new Lab(list.get(i).affichage()));
            p4.add(this.goToDelete(list.get(i).getPk_id()));
            p4.add(this.goToUpdate(list.get(i)));
                
        }
        
        
        
       
        panel.add(p4);
        panel.add(p5);
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        this.getContentPane().add(panel);
        this.setVisible(true);
        
         b_menu.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent event){                        
                                MenuChoix m = new MenuChoix();                       
                            }
                 });
         
      
    }
    
    public JButton goToAdd(Integer detailbulletin){
       JButton add = new JButton("Ajouter une évaluation");
       add.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent event){
               MenuAjoutEvaluation ajout = new MenuAjoutEvaluation(detailbulletin);
           }
       });
       
       
       return add;
    }
    
    public JButton goToDelete(Integer evaluation){
        JButton delete = new JButton("Supprimer");
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                EvaluationDAO evalDAO = new EvaluationDAO();
                Evaluation eval = evalDAO.findById(evaluation);
                
                evalDAO.delete(eval);
            }
        });
        return delete;
    }
    
    public JButton goToUpdate(Evaluation eval){
        JButton update = new JButton("Modifier");
        
        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                MenuUpdateEvaluation updateEval = new MenuUpdateEvaluation(eval);
            }
        });
        
        
        return update;
    }
}