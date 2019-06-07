/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

 */
 package controleur;

/*
 * 
 * Librairies importées
 */
import java.sql.*;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion  {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
   
    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
 
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        
        
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("cc");
        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;
        
        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        
        
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRset() {
        return rset;
    }

    public void setRset(ResultSet rset) {
        this.rset = rset;
    }

 
    
    
   
  
}