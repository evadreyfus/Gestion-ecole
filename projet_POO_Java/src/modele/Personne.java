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
public class Personne {
    
    private Integer pk_id;
    
    private String nom;
    
    private String prenom;
    
    private Integer type;

    public Personne(){
        super();
    }
    
    public Personne(Integer pk_id, String nom, String prenom, Integer type) {
        super();
        this.pk_id = pk_id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }
    
    
}
