/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Inscription;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class InscriptionDAO extends DAO<Inscription> {
  public InscriptionDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Inscription obj) {
      try {
        this.connect.getStmt().executeUpdate("INSERT INTO inscription(classe,personne)"
                + " VALUES (" + obj.getFk_classe()+ "," + obj.getFk_personne()+ ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Inscription obj) {
        try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM inscription WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Inscription obj) {
      try{
    
        this.connect.getStmt().executeUpdate("UPDATE inscription"
                + " SET"
                + " classe = " + obj.getFk_classe()
                + ", personne = " + obj.getFk_personne()
                + " WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }  
    return false;
  }
  

  public Inscription find(Integer classe,Integer personne) {
    Inscription inscription = new Inscription();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT i.id,i.classe,i.personne"
              + " FROM inscription i"
              + " INNER JOIN classe c ON c.id = " + classe + ""
              + " INNER JOIN personne p ON p.id = " + personne + "");
      if(result.first())
        inscription = new Inscription(
          result.getInt("id"),
          result.getInt("classe"),
          result.getInt("personne"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inscription;
  }
} 