/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Enseignement;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class EnseignementDAO extends DAO<Enseignement> {
  public EnseignementDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Enseignement obj) {
       try {
        this.connect.getStmt().executeUpdate("INSERT INTO enseignement(classe,discipline,personne)"
                + " VALUES (" + obj.getFk_classe()+ "," + obj.getFk_discipline()+ "," + obj.getFk_Personne()+ ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Enseignement obj) {
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM enseignement WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Enseignement obj) {
      try{
    
        this.connect.getStmt().executeUpdate("UPDATE enseignement"
                + " SET"
                + " classe = " + obj.getFk_classe()
                + ", discipline = " + obj.getFk_discipline()
                + ", personne = " + obj.getFk_Personne()
                + " WHERE id = " +obj.getPk_id()+"");
          
    }catch(SQLException e){
        e.printStackTrace();
    }  
    return false;
  }
  

  public Enseignement find(Integer classe,Integer discipline, Integer personne) {
    Enseignement enseignement = new Enseignement();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT e.id,e.classe,e.discipline,e.personne"
              + " FROM enseignement e "
              + "INNER JOIN classe c ON c.id= " + classe + ""
              + "INNER JOIN discipline d ON d.id = " + discipline + ""
              + "INNER JOIN personne p ON p.id = " + personne + "");
      
      if(result.first())
        enseignement = new Enseignement(
          result.getInt("id"),
          result.getInt("classe"),
          result.getInt("discipline"),
          result.getInt("personne"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignement;
  }
}