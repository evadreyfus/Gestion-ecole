/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Discipline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author evadr
 */
public class DisciplineDAO extends DAO<Discipline> {
  public DisciplineDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Discipline obj) {
    return false;
  }

  @Override
  public boolean delete(Discipline obj) {
    return false;
  }
  
  @Override
  public boolean update(Discipline obj) {
    return false;
  }
  @Override
   public Discipline find(Integer id) {
    Discipline discipline = new Discipline();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE pk_id = " + id);
      if(result.first())
        discipline = new Discipline(
          id,
          result.getString("nom"));  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return discipline;
  }
}
