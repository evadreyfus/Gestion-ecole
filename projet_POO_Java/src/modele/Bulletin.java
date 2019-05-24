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
public class Bulletin {
    
    private Integer pk_id;
    
    private Integer fk_trimestre;
    
    private Integer fk_inscription;
    
    private String appreciation;
    
    public Bulletin(){
        super();
    }

    public Bulletin(Integer pk_id, Integer fk_trimestre, Integer fk_inscription, String appreciation) {
        super();
        this.pk_id = pk_id;
        this.fk_trimestre = fk_trimestre;
        this.fk_inscription = fk_inscription;
        this.appreciation = appreciation;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public Integer getFk_trimestre() {
        return fk_trimestre;
    }

    public void setFk_trimestre(Integer fk_trimestre) {
        this.fk_trimestre = fk_trimestre;
    }

    public Integer getFk_inscription() {
        return fk_inscription;
    }

    public void setFk_inscription(Integer fk_inscription) {
        this.fk_inscription = fk_inscription;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
    
    
    
}
