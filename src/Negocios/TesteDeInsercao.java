/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocios;

import Ator.Ator;
import Ator.AtorDAO;
import Filme.Filme;
import Filme.FilmeDAO;
import Usuario.Usuario;
import Usuario.UsuarioDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dacio
 */
public class TesteDeInsercao {
    
    //public static void main(String[] args) throws ErroInternoException{
      // UsuarioDAO UD = new UsuarioDAO();
       
        //UD.InsereUsuario(new Usuario(3 , "109.998.090-98" , "Livya Menezes", "livya@gmail.com" , 1 , "65"));
      //  UD.DeletaUsuario(new Usuario(4, "" , "" , "" ,1 , ""));
        //int ano =2001;
        //for(int i=19;i<25;i++){
        //FilmeDAO FD = new FilmeDAO();
        //FD.InsereFilme(new Filme(26, "Matematica dp Diabo" , "Drama" , 1999 ,  "Sofia Verga"));
        
        //}
        
     
        //FD.DeletaFilme(new Filme(57, "Machete" , "Acao" , 2010 , 9.6 , "Robert Rodriguez"));
        //FD.AtualizaFilme(new Filme(57, "Machete" , "Acao" , 2010 , 9.6 , "Robert Rodriguez"));
        
       //AtorDAO AD = new AtorDAO();
       //AD.AvaliaAtor(new Ator(2, 458 , 7.8));
       //System.out.println("Realização efetuada com sucesso no banco de dados");
        //AD.InsereAtor(new Ator(2000,"Anna Mulvoy Ten" , "Londres"));
        
        //AD.AtualizaAtor(new Ator(1 , "Peter Galagher" , "Canada" ));
        //AD.DeletaAtor(new Ator(4 , "" , "" , 9));
        //AD.AvaliaAtor(new Ator (1 , 10));
        
                  //System.out.println("Realização efetuada com sucesso no banco de dados");
        
        /*AtorDAO AD = new AtorDAO();
       
        RandomAtor RA = new RandomAtor();
        
        List<Ator> atores = RA.randomAtor();
        
        int id_u = 1;
        
        for (Ator temp : atores) {
            
            System.out.println(temp);
            try {
                AD.InsereAtor(temp);
                
                System.out.println("Cadastrado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("TOTAL: " + atores.size());
        */
        /*
        FilmeDAO FD = new FilmeDAO();
        RandomFil RF = new RandomFil();
        
        List<Filme> filmes = RF.randomFil();
        
        
        int id_u = 1;
        
        for (Filme temp : filmes) {
            
            System.out.println(temp);
            try {
                FD.InsereFilme(temp);
               
                
                
                System.out.println("Cadastrado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        
    //------------------------Chamando para o excel-----------------------//
         //   public static void main(String[] args) {  
        //try {  
         //   AtorDAO mysqlToXls = new AtorDAO();  
	  //          mysqlToXls.generateXls("Inventário", "Inventário9.xls");  
	 //           mysqlToXls.close();  
        //} catch (Exception e) {  
	  //          e.printStackTrace();  
	 //       }  
	 //   }
   // }

  /*public static void main(String[] args) {  
        try {  
            AtorDAO mysqlToXls = new AtorDAO();  
	            mysqlToXls.generateXls2("Inventário", "Inventário10.xls");  
	            mysqlToXls.close();  
        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }
    }*/
    
    public static void main(String[] args) {  
        try {  
            AtorDAO mysqlToXls = new AtorDAO();  
	            mysqlToXls.generateXls3("Inventário", "Inventário12.xls");  
	            mysqlToXls.close();  
        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }
}
    

    
    
//}
