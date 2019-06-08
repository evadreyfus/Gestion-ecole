/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Trimestre;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class TrimestreDAO extends DAO<Trimestre> {
  public TrimestreDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Trimestre obj) {
         try {
        this.connect.getStmt().executeUpdate("INSERT INTO trimestre(numero,debut,fin,anneescolaire)"
                + " VALUES (" + obj.getNumero()+ "," + obj.getDebut()+ "," + obj.getFin()+ "," + obj.getFk_AnneScolaire_id() + ")");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Trimestre obj) {
      try{
     
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM personne WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }
    return false;
  }
  
  @Override
  public boolean update(Trimestre obj) {
    try{
    
        this.connect.getStmt().executeUpdate("UPDATE trimestre"
                + "SET"
                + " numero = " + obj.getNumero()
                + ", debut = " + obj.getDebut()
                + ", fin = " + obj.getFin()
                + ", anneescolaire = " + obj.getFk_AnneScolaire_id()
                + " WHERE id = " +obj.getPk_id() + "");
          
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }
  

  public Trimestre find(Integer numero, Integer anneescolaire) {
    Trimestre trimestre = new Trimestre();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT t.id,t.numero,t.debut,t.fin,t.anneescolaire "
                + " FROM trimestre t"
                + " INNER JOIN ON anneescolaire a ON anneescolaire.id = " + anneescolaire + " "
                + " WHERE numero = " + numero);
      if(result.first())
        trimestre = new Trimestre(
          result.getInt("id"),
          result.getInt("numero"),
          result.getInt("debut"),
          result.getInt("fin"),
          result.getInt("annee scolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trimestre;
  }
} 