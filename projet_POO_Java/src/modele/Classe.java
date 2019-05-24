/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author xavier.barras
 */
public class Classe {

    private Integer pk_id;

    private String nom;
    
    private Integer fk_Ecole_id;
    
    private Integer fk_Niveau_id;
    
    private Integer fk_AnneeScolaire_id;

    public Classe(){
        
    }
    
    public Classe(Integer pk_id, String nom, Integer fk_Ecole_id, Integer fk_Niveau_id, Integer fk_AnneeScolaire_id) {
        super();
        this.pk_id = pk_id;
        this.nom = nom;
        this.fk_Ecole_id = fk_Ecole_id;
        this.fk_Niveau_id = fk_Niveau_id;
        this.fk_AnneeScolaire_id = fk_AnneeScolaire_id;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getFk_Ecole_id() {
        return fk_Ecole_id;
    }

    public void setFk_Ecole_id(Integer fk_Ecole_id) {
        this.fk_Ecole_id = fk_Ecole_id;
    }

    public Integer getFk_Niveau_id() {
        return fk_Niveau_id;
    }

    public void setFk_Niveau_id(Integer fk_Niveau_id) {
        this.fk_Niveau_id = fk_Niveau_id;
    }

    public Integer getFk_AnneeScolaire_id() {
        return fk_AnneeScolaire_id;
    }

    public void setFk_AnneeScolaire_id(Integer fk_AnneeScolaire_id) {
        this.fk_AnneeScolaire_id = fk_AnneeScolaire_id;
    }
    
    
    
}
