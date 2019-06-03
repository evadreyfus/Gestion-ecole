/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Trimestre;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class TrimestreDAO extends DAO<Trimestre> {
  public TrimestreDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Trimestre obj) {
    return false;
  }

  @Override
  public boolean delete(Trimestre obj) {
    return false;
  }
  
  @Override
  public boolean update(Trimestre obj) {
    return false;
  }
  
@Override
  public Trimestre find(Integer id) {
    Trimestre trimestre = new Trimestre();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE pk_id = " + id);
      if(result.first())
        trimestre = new Trimestre(
          id,
          result.getInt("numero"),
          result.getInt("debut"),
          result.getInt("fin"),
          result.getInt("annee scolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trimestre;
  }
} 
