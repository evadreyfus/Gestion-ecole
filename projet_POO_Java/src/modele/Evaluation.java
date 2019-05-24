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
public class Evaluation {
    
    private Integer pk_id;
    
    private Integer fk_detailBulletin;
    
    private double note;
    
    private String appreciation;
    
    public Evaluation(){
        super();
    }

    public Evaluation(Integer pk_id, Integer fk_detailBulletin, double note, String appreciation) {
        super();
        this.pk_id = pk_id;
        this.fk_detailBulletin = fk_detailBulletin;
        this.note = note;
        this.appreciation = appreciation;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public Integer getFk_detailBulletin() {
        return fk_detailBulletin;
    }

    public void setFk_detailBulletin(Integer fk_detailBulletin) {
        this.fk_detailBulletin = fk_detailBulletin;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
    
    
}
