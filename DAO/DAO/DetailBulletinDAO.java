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
import controleur.Connexion;
/**
 *
 * @author evadr
 */
public class DetailBulletinDAO extends DAO<DetailBulletin> {
  public DetailBulletinDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(DetailBulletin obj) {
     
     try{
         this.connect.getStmt().executeUpdate("INSERT INTO detailbulletin(bulletin,enseignement,appreciation)"
                 + "VALUES(" + obj.getFk_bulletin() + "," + obj.getFk_enseignement() + ",'" + obj.getAppreciation() + "')");
     }catch(SQLException e){
         e.printStackTrace();
     }
      
    return false;
  }

  @Override
  public boolean delete(DetailBulletin obj) {
    
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM detailbulletin WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }  
        
    return false;
  }
  
  @Override
  public boolean update(DetailBulletin obj) {
    try{
    
        this.connect.getStmt().executeUpdate("UPDATE detailbulletin"
                + " SET"
                + " bulletin = " + obj.getFk_bulletin()
                + ", enseignement = " + obj.getFk_enseignement()
                + ", appreciation = '" + obj.getAppreciation() 
                + "' WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }  
        
      
    return false;
  }
  
  
   public DetailBulletin find(Integer bulletin, Integer enseignement) {
    DetailBulletin detailbulletin = new DetailBulletin();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT db.id,db.bulletin, db.enseignement,db.appreciation"
              + " FROM detailbulletin db"
              + " INNER JOIN bulletin b ON b.id=" + bulletin + ""
              + " INNER JOIN enseignement e ON e.id= " + enseignement + "");
      
      if(result.first())
        detailbulletin = new DetailBulletin(
          result.getInt("id"),
          result.getInt("bulletin"),
          result.getInt("enseignement"),
          result.getString("appreciation"));  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return detailbulletin;
  }
}