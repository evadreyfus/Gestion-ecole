package DAO;
import modele.AnneeScolaire;
import java.sql.ResultSet;
import java.sql.*;
import controleur.Connexion;

/**
 *
 * @author evadr
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {
  public AnneeScolaireDAO(Connexion conn) {
    super(conn);
  }

  @Override
  public boolean create(AnneeScolaire obj) {
     try {
        this.connect.getStmt().executeUpdate("INSERT INTO anneescolaire() VALUES ()");
    }catch(SQLException e){
        e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(AnneeScolaire obj) {
    try{
         
        this.connect.getConn().createStatement().executeUpdate("DELETE FROM annescolaire WHERE id = " + obj.getPk_id());
      }catch(SQLException e){
          e.printStackTrace();
      }  
    return false;
  }
  
  @Override
  public boolean update(AnneeScolaire obj) {
     
    return false;
  }
  
  
   public AnneeScolaire find(Integer annee) {
    AnneeScolaire anneeScolaire = new AnneeScolaire();      
      
    try {
      ResultSet result = this.connect.getStmt().executeQuery("SELECT * FROM anneescolaire WHERE annee = " + annee);
      if(result.first())
        anneeScolaire = new AnneeScolaire(
                result.getInt("id"),
                result.getInt("annee")
                
        );  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return anneeScolaire;
  }
}