/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Filme;

import Negocios.Conexao;
import Negocios.ErroInternoException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dacio
 */
public class FilmeDAO {
    
     private CallableStatement cs;
     private Connection connection;
     private PreparedStatement stmt;
     private ResultSet tupla;
     private java.util.List<Filme> ListaDeFilmes= new ArrayList<Filme>();
   
     
     public FilmeDAO(){
        this.connection = Conexao.ConexaoObter();
    }
     
       public void InsereFilme(Filme filme)throws ErroInternoException{
        CallableStatement cs = null;
        
        
        String sql = "{call INSERE_FILME (SEQ_FILME.NEXTVAL , ? , ? , ? , ? )}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setString(1, filme.getNome());
            cs.setString(2, filme.getGenero());
            cs.setLong(3, filme.getAno());
            cs.setString(4, filme.getDiretor());
            cs.executeQuery();
            
        }catch(SQLException e){
            throw new ErroInternoException(e);
        }finally{
            try{
                cs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
       }
       
       
        public void AtualizaFilme(Filme filme){
        CallableStatement cs = null;
        
        
        String sql = "{call UPDATEFILME (? , ? , ? , ? , ? , ?)}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setLong(1, filme.getCodigo());
            cs.setString(2, filme.getNome());
            cs.setString(3, filme.getGenero());
            cs.setLong(4, filme.getAno());
            cs.setDouble(5, filme.getPontuacao());
            cs.setString(6, filme.getDiretor());
            cs.executeQuery();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                cs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
       }
        
        
         public boolean DeletaFilme(Filme filme){
        
           this.connection = Conexao.ConexaoObter();
        
        
        try{
            
            this.connection.createStatement();
            
            this.stmt = connection.prepareStatement("DELETE FROM FILME WHERE CODIGO=?");
            
            this.stmt.setLong(1, filme.getCodigo());
            
            
            this.stmt.execute();
            this.stmt.close();
            this.connection.close();
            
            return true;
        }catch(Exception e){
            
            System.out.println("ERRO: " +e.toString());
            
            return false;
        }
    }
         
      public java.util.List<Filme> ListarFilme(){
            this.connection = Conexao.ConexaoObter();
        
        try {
            this.connection.createStatement();
            this.stmt = connection.prepareStatement("SELECT * FROM FILME");
            this.ListaDeFilmes.clear();
           
            this.tupla = stmt.executeQuery();
            while(this.tupla.next())
            {
                Filme filme = new Filme();
                filme.setCodigo(this.tupla.getInt("CODIGO"));
                filme.setNome(this.tupla.getString("NOME"));
                filme.setGenero(this.tupla.getString("GENERO"));
                filme.setAno(this.tupla.getInt("ANO"));
                filme.setDiretor(this.tupla.getString("DIRETOR"));
                this.ListaDeFilmes.add(filme);
                
                
            }
            this.tupla.close();
            this.stmt.close();
            
            if(this.ListaDeFilmes.size()>0)
            return this.ListaDeFilmes;
                
            else
                return null;
        }
        catch(SQLException e){
            System.out.println("Erro: "+e.toString());
            return null;
        }
         
    }
         
}
