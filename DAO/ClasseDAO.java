/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author evadr
 */
public class ClasseDAO extends DAO<Classe> {
  public ClasseDAO (Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Classe obj) {
    return false;
  }

  @Override
  public boolean delete(Classe obj) {
    return false;
  }
  
  @Override
  public boolean update(Classe obj) {
    return false;
  }
   public Classe find(Integer id) {
    Classe classe = new Classe();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE pk_id = " + id);
      if(result.first())
        classe = new Classe(
          id,
          result.getString("nom"),
          result.getInt("ecole"),
          result.getInt("Niveau"),
          result.getInt("Annee Scolaire"));  
       
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
  }
}

