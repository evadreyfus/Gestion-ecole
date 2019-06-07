/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Niveau;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class NiveauDAO extends DAO<Niveau> {
  public NiveauDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Niveau obj) {
         try {
        this.connect.getStmt().executeUpdate("INSERT INTO niveau(nom)"
                + " VALUES ('" + obj.getNom() + "')");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Niveau obj) {
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM niveau WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Niveau obj) {
        try{
    
        this.connect.getStmt().executeUpdate("UPDATE niveau"
                + " SET"
                + " nom = '" + obj.getNom()
                + "' WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }
  

  public Niveau find(String nom) {
    Niveau niveau = new Niveau();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT * FROM niveau WHERE nom = '" + nom + "'");
      if(result.first())
        niveau = new Niveau(
          result.getInt("id"),
          result.getString("note"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return niveau;
  }
} 