/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Personne;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class PersonneDAO extends DAO<Personne> {
  public PersonneDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Personne obj) {
       try {
        this.connect.getStmt().executeUpdate("INSERT INTO personne(nom,prenom,type)"
                + " VALUES ('" + obj.getNom()+ "','" + obj.getPrenom()+ "'," + obj.getType()+ ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Personne obj) {
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM personne WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Personne obj) {
         try{
    
        this.connect.getStmt().executeUpdate("UPDATE personne"
                + " SET"
                + " nom = '" + obj.getNom()
                + "', prenom = '" + obj.getPrenom()
                + "', type = " + obj.getType()
                + " WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }
  

  public Personne find(String nom,String prenom,Integer type) {
    Personne personne = new Personne();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT *"
              + " FROM personne"
              + " WHERE nom = '" + nom + "'"
              + " AND prenom = '" + prenom + "'"
              + " AND type = " + type + "");
      if(result.first())
        personne = new Personne(
          result.getInt("id"),
          result.getString("nom"),
          result.getString("prenom"),
          result.getInt("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personne;
  }
} 