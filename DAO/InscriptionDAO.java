/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Inscription;
import java.sql.*;
/**
 *
 * @author evadr
 */

public class InscriptionDAO extends DAO<Inscription> {
  public InscriptionDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Inscription obj) {
    return false;
  }

  @Override
  public boolean delete(Inscription obj) {
    return false;
  }
  
  @Override
  public boolean update(Inscription obj) {
    return false;
  }
  
@Override
  public Inscription find(Integer id) {
    Inscription inscription = new Inscription();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE pk_id = " + id);
      if(result.first())
        inscription = new Inscription(
          id,
          result.getInt("classe"),
          result.getInt("personne"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inscription;
  }
} 
  