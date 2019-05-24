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
public class Inscription {
    
    private Integer pk_id;
    
    private Integer fk_classe;
    
    private Integer fk_personne;
    
    public Inscription(){
        super();
   
    }

    public Inscription(Integer pk_id, Integer fk_classe, Integer fk_personne) {
        this.pk_id = pk_id;
        this.fk_classe = fk_classe;
        this.fk_personne = fk_personne;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public Integer getFk_classe() {
        return fk_classe;
    }

    public void setFk_classe(Integer fk_classe) {
        this.fk_classe = fk_classe;
    }

    public Integer getFk_personne() {
        return fk_personne;
    }

    public void setFk_personne(Integer fk_personne) {
        this.fk_personne = fk_personne;
    }
    
    
}
