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
public class DetailBulletin {
    
    private Integer pk_id;
    
    private Integer fk_bulletin;
    
    private Integer fk_enseignement;
    
    private String appreciation;

    public DetailBulletin(){
        super();
    }
    
    public DetailBulletin(Integer pk_id, Integer fk_bulletin, Integer fk_enseignement, String appreciation) {
        super();
        this.pk_id = pk_id;
        this.fk_bulletin = fk_bulletin;
        this.fk_enseignement = fk_enseignement;
        this.appreciation = appreciation;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public Integer getFk_bulletin() {
        return fk_bulletin;
    }

    public void setFk_bulletin(Integer fk_bulletin) {
        this.fk_bulletin = fk_bulletin;
    }

    public Integer getFk_enseignement() {
        return fk_enseignement;
    }

    public void setFk_enseignement(Integer fk_enseignement) {
        this.fk_enseignement = fk_enseignement;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
    
    
    
   
}
