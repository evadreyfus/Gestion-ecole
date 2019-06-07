/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Bulletin;
import java.sql.*;
import controleur.Connexion;

/**
 *
 * @author evadr
 */
public class BulletinDAO extends DAO<Bulletin> {
  public BulletinDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Bulletin obj){
    try {
        this.connect.getStmt().executeUpdate("INSERT INTO bulletin (trimestre,inscription,appreciation) "
                + "VALUES (" + obj.getFk_trimestre() + "," + obj.getFk_inscription() + "," + obj.getAppreciation() + ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Bulletin obj) {
      try{
          
        this.connect.getStmt().executeUpdate("DELETE FROM bulletin WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Bulletin obj) {
     
    try{
    
        this.connect.getStmt().executeUpdate("UPDATE bulletin "
                + "SET trimestre = " + obj.getFk_trimestre() + ",inscription = " + obj.getFk_inscription() + ",appreciation = " + obj.getAppreciation() 
                + "WHERE id = " + obj.getPk_id());
    }catch(SQLException e){
        e.printStackTrace();
    }  
      
    return false;
  }
  
  @Override
   public Bulletin find(Integer id) {
    Bulletin bulletin = new Bulletin();
    
    try {
        ResultSet result= this.connect.getStmt().executeQuery("SELECT * FROM bulletin WHERE id = " + id);
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