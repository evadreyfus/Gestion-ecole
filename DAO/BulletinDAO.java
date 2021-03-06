/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Bulletin;
import java.sql.*;
/**
 *
 * @author evadr
 */
public class BulletinDAO extends DAO<Bulletin> {
  public BulletinDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Bulletin obj) {
    return false;
  }

  @Override
  public boolean delete(Bulletin obj) {
    return false;
  }
  
  @Override
  public boolean update(Bulletin obj) {
    return false;
  }
   public Bulletin find(Integer id) {
    Bulletin bulletin = new Bulletin();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM bulletin WHERE pk_id = " + id);
      if(result.first())
        bulletin = new Bulletin(
          id,
          result.getInt("trimestre"),
          result.getInt("inscription"),
          result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bulletin;
  }
}
