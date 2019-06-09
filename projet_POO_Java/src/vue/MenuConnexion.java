    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import controleur.Connexion;

/**
 *
 * @author xavier.barras
 */
public class MenuConnexion extends JFrame{
    
    public MenuConnexion(){

                //Titre fenetre       
		this.setTitle("Gestion école - Connexion");
                
                //Taille fenetre
                this.setSize(600,400);
                
                //Fin du build quand on ferme la fenetre
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Je sais plus mais c'est important
                this.setLocationRelativeTo(null); 
             
                //Création de la box princiapel
		JPanel panel = new JPanel();
                
                //Creation des boutons et des zones de texte
		JButton b_connexion = new JButton("Connexion");
                
		JLabel l_id = new JLabel("Identifiant : ");
                ZoneTexte identifiant = new ZoneTexte();
                
		JLabel l_mdp = new JLabel("Mot de passe : ");
                ZoneTexte mdp = new ZoneTexte();
                
                JButton b_quitter = new JButton("Quitter");
                
                
                //Creation de JPanel(Panneau) supplémentaire pour avoir une disposition des boutons et autres de facon imbriqué
                Panneau p1 = new Panneau();
                p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
                
                Panneau p2= new Panneau();
                p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
                
                Panneau p3 = new Panneau();
                p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
                
                Panneau p4 = new Panneau();
                p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
                
                
                //On ajout nos boutons et autres aux différents JPanel
                p1.add(l_id);
                p1.add(identifiant);
                
                p2.add(l_mdp);
                p2.add(mdp);
                
                p3.add(b_connexion);
               
                p4.add(b_quitter);
                
                
                //Paramétrage de la Box principale
                panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                
                //Ajout des Boxs secondaires sur la Box principale
                panel.add(p1);
                panel.add(p2);
                panel.add(p3);
                panel.add(p4);
                
                //On rend la Box visible
                this.getContentPane().add(panel);
                this.setVisible(true);
                
                
                
                //Programmation bouton Connexion
                b_connexion.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                            
                            //Si les identifiants et mdp sont corrects on accède à la page Choix d'où le constructeur de MenuChoix
                            if(identifiant.getText().equals("root") && mdp.getText().equals("")){
                                
                                MenuChoix choix = new MenuChoix();
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Identifiant ou Mot de passe incorrects");
                            }

                    }
                });
                
                
                //Programmation bouton Quitter
                b_quitter.addActionListener((ActionEvent e) -> {
                    System.exit(0);
                });
                    
                
	}
    
}
