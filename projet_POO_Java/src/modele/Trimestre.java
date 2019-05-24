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
public class Trimestre {
    
    private Integer pk_id;
    
    private Integer numero;
    
    //Type a vérifier
    private Integer debut;
    
    //Type à vérifier
    private Integer fin;
    
    //AnneeScolaire.id#
    private Integer fk_AnneScolaire_id;
    
    public Trimestre(){
        super();
    }
    
    public Trimestre(Integer pk_id, Integer numero,Integer debut, Integer fin, Integer fk_AnneeScolaire_id){
        super();
        this.pk_id=pk_id;
        this.numero=numero;
        this.debut=debut;
        this.fin=fin;
        this.fk_AnneScolaire_id=fk_AnneeScolaire_id;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getDebut() {
        return debut;
    }

    public void setDebut(Integer debut) {
        this.debut = debut;
    }

    public Integer getFin() {
        return fin;
    }

    public void setFin(Integer fin) {
        this.fin = fin;
    }

    public Integer getFk_AnneScolaire_id() {
        return fk_AnneScolaire_id;
    }

    public void setFk_AnneScolaire_id(Integer fk_AnneScolaire_id) {
        this.fk_AnneScolaire_id = fk_AnneScolaire_id;
    }
    
    
    
}
