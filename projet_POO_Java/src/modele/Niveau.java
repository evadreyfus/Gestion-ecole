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
public class Niveau {
    
    private Integer pk_id;
    
    private String nom;

    public Niveau(){
        super();
    }
    
    public Niveau(Integer pk_id, String nom) {
        super();
        this.pk_id = pk_id;
        this.nom = nom;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setId(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    
}
