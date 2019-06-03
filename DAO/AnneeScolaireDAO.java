package DAO;
import modele.AnneeScolaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author evadr
 */
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {
  public AnneeScolaireDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(AnneeScolaire obj) {
    return false;
  }

  @Override
  public boolean delete(AnneeScolaire obj) {
    return false;
  }
  
  @Override
  public boolean update(AnneeScolaire obj) {
    return false;
  }
  
   public AnneeScolaire find(Integer id) {
    AnneeScolaire anneeScolaire = new AnneeScolaire();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anneeScolaire WHERE pk_id = " + id);
      if(result.first())
        anneeScolaire = new AnneeScolaire(id);  
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return anneeScolaire;
  }
}
