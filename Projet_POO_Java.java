/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_poo_java;

import DAO.*;
import modele.*;
import controleur.Connexion;
import java.sql.*;

/**
 *
 * @author xavier.barras
 */
public class Projet_POO_Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Connexion connex= new Connexion("ecole","root","");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Non");
        }catch(ClassNotFoundException f){
            
        }
        System.out.println("ddd");
        //BulletinDAO test=new BulletinDAO(connex);
        
    }
    
}
