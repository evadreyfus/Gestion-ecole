/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.Eleve;
import java.sql.*;
import controleur.Connexion;
/**
 *
 * @author evadr
 */

public class EleveDAO extends DAO<Eleve> {
  public EleveDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(Eleve obj) {
    return false;
  }

  @Override
  public boolean delete(Eleve obj) {
    return false;
  }
  
  @Override
  public boolean update(Eleve obj) {
    return false;
  }
  
  @Override
  public Eleve find(Integer id){
      Eleve eleve =new Eleve();
      return eleve;
  }
  
  
  
  public Eleve find(String nom,String prenom,Integer type) {
    Eleve eleve = new Eleve();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT * FROM eleve WHERE nom = " + nom + ",prenom = " + prenom + ",type = " + type);
      if(result.first())
        eleve = new Eleve(
          result.getInt("id"),
          result.getString("nom"),
          result.getString("prenom"),
          result.getInt("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return eleve;
  }
}