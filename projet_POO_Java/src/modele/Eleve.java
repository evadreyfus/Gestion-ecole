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
public class Eleve extends Personne {
    
    public Eleve(){
        super();
    }
    
    public Eleve(Integer pk_id, String nom, String prenom, Integer type){
        super(pk_id,nom,prenom,type);
    }
}
