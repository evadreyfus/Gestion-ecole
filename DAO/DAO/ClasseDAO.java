/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Classe;
import java.sql.ResultSet;
import java.sql.*;
import controleur.Connexion;

/**
 *
 * @author evadr
 */
public class ClasseDAO extends DAO<Classe> {
  public ClasseDAO (Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Classe obj) {
    try{
        this.connect.getStmt().executeUpdate("INSERT INTO classe(nom,niveau,anneescolaire) VALUES ('" + obj.getNom() + "'," + obj.getFk_Niveau_id()+ "," + obj.getFk_AnneeScolaire_id() + ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Classe obj) {
      try{
          this.connect.getStmt().executeUpdate("DELETE FROM classe WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Classe obj) {
      
    try{
    
        this.connect.getStmt().executeUpdate("UPDATE classe"
                + " SET"
                + " nom = '" + obj.getNom()
                + "', niveau  = " + obj.getFk_Niveau_id()
                + ", anneescolaire = " + obj.getFk_AnneeScolaire_id()
                + " WHERE id = " +obj.getPk_id() + "");
          
    }catch(SQLException e){
        e.printStackTrace();
    }   
    return false;
  }
  
  

  
   public Classe find(String nom, Integer niveau, Integer anneescolaire) {
    Classe classe = new Classe();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT c.id, c.nom, c.niveau, c.anneescolaire"
              + " FROM classe c"
              + " INNER JOIN niveau n ON n.id=" + niveau
              + " INNER JOIN anneescolaire a ON a.annee=" + anneescolaire +""
              + " WHERE c.nom = '" + nom + "'" );
      if(result.first())
        classe = new Classe(
          result.getInt("id"),
          result.getString("nom"),
          result.getInt("niveau"),
          result.getInt("anneescolaire"));  
      
        //Affichage test
        System.out.println(classe.toString());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
  }
}