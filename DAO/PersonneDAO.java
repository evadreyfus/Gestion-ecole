/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Personne;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class PersonneDAO extends DAO<Personne> {
  public PersonneDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Personne obj) {
    return false;
  }

  @Override
  public boolean delete(Personne obj) {
    return false;
  }
  
  @Override
  public boolean update(Personne obj) {
    return false;
  }
  
@Override
  public Personne find(Integer id) {
    Personne personne = new Personne();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE pk_id = " + id);
      if(result.first())
        personne = new Personne(
          id,
          result.getString("nom"),
          result.getString("prenom"),
          result.getInt("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personne;
  }
} 
  
