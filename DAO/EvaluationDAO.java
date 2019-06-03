/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Evaluation;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class EvaluationDAO extends DAO<Evaluation> {
  public EvaluationDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Evaluation obj) {
    return false;
  }

  @Override
  public boolean delete(Evaluation obj) {
    return false;
  }
  
  @Override
  public boolean update(Evaluation obj) {
    return false;
  }
  
@Override
  public Evaluation find(Integer id) {
    Evaluation evaluation = new Evaluation();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM evaluation WHERE pk_id = " + id);
      if(result.first())
        evaluation = new Evaluation(
          id,
          result.getInt("detail bulletin"),
          result.getDouble("note"),
          result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return evaluation;
  }
} 
  