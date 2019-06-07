/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Discipline;
import java.sql.ResultSet;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */
public class DisciplineDAO extends DAO<Discipline> {
  public DisciplineDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Discipline obj) {
     
     try{
         this.connect.getStmt().executeUpdate("INSERT INTO discipline(nom)"
                 + "VALUES('" + obj.getNom() + "')");
     }catch(SQLException e){
         e.printStackTrace();
     }  
    return false;
  }

  @Override
  public boolean delete(Discipline obj) {
    
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM discipline WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Discipline obj) {
    try{
    
        this.connect.getStmt().executeUpdate("UPDATE discipline"
                + " SET"
                + " nom = '" + obj.getNom()
                + "' WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }    
      
    return false;
  }
  
   public Discipline find(String nom) {
    Discipline discipline = new Discipline();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT * FROM discipline WHERE nom = " + nom);
      if(result.first())
        discipline = new Discipline(
          result.getInt("id"),
          result.getString("nom"));  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return discipline;
  }
}