/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Enseignement;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class EnseignementDAO extends DAO<Enseignement> {
  public EnseignementDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Enseignement obj) {
    return false;
  }

  @Override
  public boolean delete(Enseignement obj) {
    return false;
  }
  
  @Override
  public boolean update(Enseignement obj) {
    return false;
  }
  
@Override
  public Enseignement find(Integer id) {
    Enseignement enseignement = new Enseignement();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignement WHERE pk_id = " + id);
      if(result.first())
        enseignement = new Enseignement(
          id,
          result.getInt("classe"),
          result.getInt("discipline"),
          result.getInt("personne"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignement;
  }
}