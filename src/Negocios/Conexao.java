/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocios;

import java.sql.*;

/**
 *
 * @author Dacio
 */
public class Conexao {
    
     public static Connection ConexaoObter(){
        
        Connection conexao = null;
         
        try{
           Class.forName("oracle.jdbc.OracleDriver");
           
           conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","DACIO","123");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
         return conexao;
    }
    
}
