/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.DetailBulletin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author evadr
 */
public class DetailBulletinDAO extends DAO<DetailBulletin> {
  public DetailBulletinDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(DetailBulletin obj) {
    return false;
  }

  @Override
  public boolean delete(DetailBulletin obj) {
    return false;
  }
  
  @Override
  public boolean update(DetailBulletin obj) {
    return false;
  }
   public DetailBulletin find(Integer id) {
    DetailBulletin detailbulletin = new DetailBulletin();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin WHERE pk_id = " + id);
      if(result.first())
        detailbulletin = new DetailBulletin(
          id,
          result.getInt("bulletin"),
          result.getInt("enseignement"),
          result.getString("appreciation"));  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return detailbulletin;
  }
}
