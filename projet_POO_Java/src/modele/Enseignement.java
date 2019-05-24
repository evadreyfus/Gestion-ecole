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
public class Enseignement {
    
    private Integer pk_id;
    
    private Integer fk_classe;
    
    private Integer fk_discipline;
    
    private Integer fk_Personne;

    public Enseignement(){
        super();
    }
    
    public Enseignement(Integer pk_id, Integer fk_classe, Integer fk_discipline, Integer fk_Personne) {
        super();
        this.pk_id = pk_id;
        this.fk_classe = fk_classe;
        this.fk_discipline = fk_discipline;
        this.fk_Personne = fk_Personne;
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

    public Integer getFk_discipline() {
        return fk_discipline;
    }

    public void setFk_discipline(Integer fk_discipline) {
        this.fk_discipline = fk_discipline;
    }

    public Integer getFk_Personne() {
        return fk_Personne;
    }

    public void setFk_Personne(Integer fk_Personne) {
        this.fk_Personne = fk_Personne;
    }
    
    
    
}
