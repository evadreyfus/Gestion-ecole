/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Niveau;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class NiveauDAO extends DAO<Niveau> {
  public NiveauDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Niveau obj) {
    return false;
  }

  @Override
  public boolean delete(Niveau obj) {
    return false;
  }
  
  @Override
  public boolean update(Niveau obj) {
    return false;
  }
  
@Override
  public Niveau find(Integer id) {
    Niveau niveau = new Niveau();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE pk_id = " + id);
      if(result.first())
        niveau = new Niveau(
          id,
          result.getString("note"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return niveau;
  }
} 
  
