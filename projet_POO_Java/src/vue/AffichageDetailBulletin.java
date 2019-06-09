/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author xavier.barras
 */
public class AffichageDetailBulletin {
    
    private Integer idDetail;
    
    private String nom;
    
    private String appreciation;
    
    private double moyenne; 

    public AffichageDetailBulletin(Integer idDetail,String nom, String appreciation,double moyenne) {
        this.idDetail= idDetail;
        this.nom = nom;
        this.appreciation = appreciation;
        this.moyenne = moyenne;
    }

    public Integer getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Integer idDetail) {
        this.idDetail = idDetail;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    
    public String affichage(){
        return this.nom + " " + this.appreciation + " " + this.moyenne + " ";
    }
    
  
}
