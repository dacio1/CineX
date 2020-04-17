/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocios;


import Ator.Ator;
import Usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dacio
 */
public class RelatoriosDAO {
    
    private Connection connection;
     private PreparedStatement stmt;
    private ResultSet tupla;
    private java.util.List<Ator> ListaDeAtores= new ArrayList<Ator>();
    
    private double pontuacao;
    private String nome;
    
    public RelatoriosDAO(double pontuacao , String nome){
        this.pontuacao = pontuacao;
        this.nome = nome;
    }
    
     public RelatoriosDAO(){
         
         this.connection = Conexao.ConexaoObter();
        
    }
     
      public java.util.List<Ator> ListarAtores(){
            this.connection = Conexao.ConexaoObter();
        
        try {
            this.connection.createStatement();
            this.stmt = connection.prepareStatement("SELECT AVG(PONTUACAO),"
                    + "ATO.NOME "
                    + "FROM ATOR ATO ,USUARIO_A_ATOR UA "
                    + "WHERE  ATO.CODIGO = UA.COD_ATOR group by ATO.NOME;");
            this.ListaDeAtores.clear();
           
            this.tupla = stmt.executeQuery();
            while(this.tupla.next())
            {
                Ator ator = new Ator();
                ator.setPontuacao(this.tupla.getDouble("PONTUACAO"));
                
                ator.setNome(this.tupla.getString("NOME"));
                
                this.ListaDeAtores.add(ator);
                
            }
            this.tupla.close();
            this.stmt.close();
            
            if(this.ListaDeAtores.size()>0)
            return this.ListaDeAtores;
                
            else
                return null;
        }
        catch(SQLException e){
            System.out.println("Erro: "+e.toString());
            return null;
        }
         
    }
}
