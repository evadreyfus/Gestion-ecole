/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author evadr
 */
public class AffichageClasse {
    
    private String classe;
    private String nom;
    private String prenom;

    public AffichageClasse(String classe, String nom, String prenom) {
        this.classe = classe;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String affichage(){
        return " " + this.nom + " " + this.prenom + " ";
    }
    
    public String affichageClasse(){
        return " " + this.classe;
    }
    
}