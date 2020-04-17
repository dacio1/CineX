/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import Negocios.Conexao;
import Negocios.ErroInternoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import teste.CriaExcel;

/**
 *
 * @author Denys Raphael
 */
public class UsuarioDAO {
    private CallableStatement cs;
    private Connection connection;
     private PreparedStatement stmt;
    private ResultSet tupla;
    private java.util.List<Usuario> ListaDeUsuarios= new ArrayList<Usuario>();
   
     
     public UsuarioDAO(){
        this.connection = Conexao.ConexaoObter();
     }
        public void InsereUsuario(Usuario usuario)throws ErroInternoException{
        CallableStatement cs = null;
        
        String sql = "{call INSERE_USUARIO (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ? , ?)}";
        try{
            cs = this.connection.prepareCall(sql);
            cs.setString(1, usuario.getCpf());
            cs.setString(2, usuario.getNome());
            cs.setString(3, usuario.getEmail());
            cs.setInt(4 , usuario.getAcesso());
            cs.setString(5, usuario.getSenha());
            
            
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
        
     public void AtualizaUsuario(Usuario usuario)throws ErroInternoException{
        CallableStatement cs = null;
        
        
        String sql = "{call UPDATE_USUARIO (? , ? , ? , ? , ? , ?)}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setInt(1, usuario.getCodigo());
            cs.setString(2, usuario.getCpf());
            cs.setString(3, usuario.getNome());
            cs.setString(4, usuario.getEmail());
            cs.setInt(5, usuario.getAcesso());
            cs.setString(6, usuario.getSenha());
            
           
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
     
      public boolean DeletaUsuario(Usuario usuario){
        
           this.connection = Conexao.ConexaoObter();
        
        
        try{
            
            this.connection.createStatement();
            
            this.stmt = connection.prepareStatement("DELETE FROM USUARIO WHERE CODIGO_USUARIO=?");
            
            
            this.stmt.setInt(1, usuario.getCodigo());
            
            
            this.stmt.execute();
            this.stmt.close();
            this.connection.close();
            
            return true;
        }catch(Exception e){
            
            System.out.println("ERRO: " +e.toString());
            
            return false;
        }
    }
     
     
     public java.util.List<Usuario> ListarUsuarios() throws FileNotFoundException, IOException{
            this.connection = Conexao.ConexaoObter();
        
        try {
            this.connection.createStatement();
            this.stmt = connection.prepareStatement("SELECT * FROM USUARIO");
            this.ListaDeUsuarios.clear();
           
            this.tupla = stmt.executeQuery();
            while(this.tupla.next())
            {
                Usuario usuario = new Usuario();
                usuario.setCodigo(this.tupla.getInt("CODIGO_USUARIO"));
                usuario.setCpf(this.tupla.getString("CPF"));
                usuario.setNome(this.tupla.getString("NOME_USUARIO"));
                usuario.setEmail(this.tupla.getString("EMAIL"));
                usuario.setAcesso(this.tupla.getInt("ACESSO"));
                usuario.setSenha(this.tupla.getString("SENHA"));
                this.ListaDeUsuarios.add(usuario);
                
                
            }
            
                 int rownum = 0;
                 HSSFWorkbook workbook = new HSSFWorkbook();
                 HSSFSheet sheetUsuario = workbook.createSheet("Usuario");
                for (Usuario usuario : ListaDeUsuarios) {
                   Row row = sheetUsuario.createRow(rownum++);
                   int cellnum = 0;
                   Cell cellNome = row.createCell(cellnum++);
                   cellNome.setCellValue(usuario.getCodigo());
                   Cell cellRa = row.createCell(cellnum++);
                   cellRa.setCellValue(usuario.getCpf());
                   Cell cellNota1 = row.createCell(cellnum++);
                   cellNota1.setCellValue(usuario.getNome());
                   Cell cellNota2 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuario.getEmail());
                   Cell cellNota3 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuario.getAcesso());
                   Cell cellNota4 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuario.getSenha());
                   //this.ListaDeUsuarios.add(usuario);
               }
                
              final String fileName = "novo.xls";
        FileOutputStream out = new FileOutputStream(new File(CriaExcel.fileName));
                   workbook.write(out);
                   out.close();
                   //System.out.println("Arquivo Excel criado com sucesso!");
            this.tupla.close();
            this.stmt.close();
            
            if(this.ListaDeUsuarios.size()>0)
            return this.ListaDeUsuarios;
                
            else
                return null;
        }
        catch(SQLException e){
            System.out.println("Erro: "+e.toString());
            return null;
        }
         
    }
}
