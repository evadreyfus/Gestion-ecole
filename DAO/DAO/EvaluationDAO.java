/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Evaluation;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class EvaluationDAO extends DAO<Evaluation> {
  public EvaluationDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Evaluation obj) {
           try {
        this.connect.getStmt().executeUpdate("INSERT INTO evaluation(detailbulletin,note,appreciation)"
                + " VALUES (" + obj.getFk_detailBulletin()+ "," + obj.getNote()+ ",'" + obj.getAppreciation()+ "')");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Evaluation obj) {
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM evaluation WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Evaluation obj) {
      try{
    
        this.connect.getStmt().executeUpdate("UPDATE evaluation"
                + " SET"
                + " detailbulletin = " + obj.getFk_detailBulletin()
                + ", note = " + obj.getNote()
                + ", appreciation = '" + obj.getAppreciation()
                + "' WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }
  
  // TESTER SI IL FAUT PAS METTRE L'APPRECIATION EN PARAMETRE
  public Evaluation find(Integer detailbulletin, double note) {
    Evaluation evaluation = new Evaluation();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT e.id,e.detailbulletin,e.note,e.appreciation"
              + " FROM evaluation e"
              + "INNER JOIN detailbulletin db ON db.id = " + detailbulletin + ""
              + " WHERE note = " + note);
      if(result.first())
        evaluation = new Evaluation(
          result.getInt("id"),
          result.getInt("detailbulletin"),
          result.getDouble("note"),
          result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return evaluation;
  }
} 
  