/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Enseignant;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class EnseignantDAO extends DAO<Enseignant> {
  public EnseignantDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Enseignant obj) {
    return false;
  }

  @Override
  public boolean delete(Enseignant obj) {
    return false;
  }
  
  @Override
  public boolean update(Enseignant obj) {
    return false;
  }
  
@Override
  public Enseignant find(Integer id) {
    Enseignant enseignant = new Enseignant();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE pk_id = " + id);
      if(result.first())
        enseignant = new Enseignant(
          id,
          result.getString("nom"),
          result.getString("prenom"),
          result.getInt("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
}