/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ator;

import Negocios.Conexao;
import Negocios.ErroInternoException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Livya Menezes
 */
public class AtorDAO {
    
    private CallableStatement cs;
    private Connection connection;
     private PreparedStatement stmt;
    private ResultSet tupla;
    private java.util.List<Ator> ListaDeAtores= new ArrayList<Ator>();
   
     
     public AtorDAO(){
        this.connection = Conexao.ConexaoObter();
    }
     
        public void InsereAtor(Ator ator)throws ErroInternoException{
        CallableStatement cs = null;
        
        
        String sql = "{call INSERE_ATOR (SEQ_ATOR.NEXTVAL , ? , ? )}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            
            cs.setString(1, ator.getNome());
            cs.setString(2, ator.getNacionalidade());
            
            
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
        
        
     public void AtualizaAtor(Ator ator)throws ErroInternoException{
        CallableStatement cs = null;
        
        
        String sql = "{call UPDATE_ATOR (? , ? , ? )}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setInt(1, ator.getCodigo());
            cs.setString(2, ator.getNome());
            cs.setString(3, ator.getNacionalidade());
            
           
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
     
     
     
     public boolean DeletaAtor(Ator ator){
        
           this.connection = Conexao.ConexaoObter();
        
        
        try{
           
            this.connection.createStatement();
            
            this.stmt = connection.prepareStatement("DELETE FROM ATOR WHERE CODIGO=?");
            
            
            this.stmt.setInt(1, ator.getCodigo());
            
            
            this.stmt.execute();
            this.stmt.close();
            this.connection.close();
            
            return true;
        }catch(Exception e){
            
            System.out.println("ERRO: " +e.toString());
            
            return false;
        }
    }
     
     
       public void AvaliaAtor(Ator ator)throws ErroInternoException{
        
       
          this.connection= Conexao.ConexaoObter();
        try {
            this.connection.createStatement();
       
          this.stmt = this.connection.prepareStatement("INSERT INTO USUARIO_A_ATOR (COD_USUARIO , COD_ATOR , PONTUACAO) VALUES( ? , ? , ?)");
           
          
            this.stmt.setInt(1, ator.getCodigoUsuario());
            this.stmt.setInt(2 ,ator.getCodigo() );
            this.stmt.setDouble(3 , ator.getPontuacao());
           
            
            
            
           this.stmt.execute();
            this.stmt.close();
            this.connection.close();
            
        } catch (SQLException e) { throw new RuntimeException(e);
        } finally{
            try { stmt.close(); } catch (SQLException e) {e.printStackTrace();}}
       }
       
       
       public Ator buscarAtor(int codigo) throws ErroInternoException{
        try{
            return this.buscarAtor(codigo);
        }
        catch(ErroInternoException eie){
            throw new ErroInternoException(eie);
        }
    }
       
       
        public java.util.List<Ator> ListarAtores(){
            this.connection = Conexao.ConexaoObter();
        
        try {
            this.connection.createStatement();
            this.stmt = connection.prepareStatement("SELECT * FROM ATOR");
            this.ListaDeAtores.clear();
           
            this.tupla = stmt.executeQuery();
            while(this.tupla.next())
            {
                Ator ator = new Ator();
                ator.setCodigo(this.tupla.getInt("CODIGO"));
                ator.setNome(this.tupla.getString("NOME"));
                ator.setNacionalidade(this.tupla.getString("NACIONALIDADE"));
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
        
        /*consulta sobre que atores estao presentes em um filme,de acordo com o seu genero*/
        public void generateXls() {  
	        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
	    }  
	  
	    public void generateXls(String tablename, String filename)  
	            throws SQLException, FileNotFoundException, IOException {  
	  
	        // Criar nova pasta de trabalho Excel e folha  
	        HSSFWorkbook xlsWorkbook = new HSSFWorkbook();  
	        HSSFSheet xlsSheet = xlsWorkbook.createSheet("CineX");  
	        short rowIndex = 1;  
	  
	        // Executar a consulta SQL 
                
	        PreparedStatement stmt =  
	                connection.prepareStatement("SELECT * FROM Ator u INNER JOIN ATOR_FILME af on af.COD_ATOR = u.CODIGO INNER JOIN FILME f on f.CODIGO = af.COD_FILME where f.GENERO = 'Acao'");  
	        ResultSet rs = stmt.executeQuery();  
	  
	        // Obter a lista de nomes de colunas e armazená-los como o primeiro  
	        // linha da planilha.  
	        ResultSetMetaData colInfo = rs.getMetaData();  
	        ArrayList<String> colNames = new ArrayList<String>();  
	        HSSFRow titleRow = xlsSheet.createRow(rowIndex++);  
	  
	        for (int i = 1; i <= colInfo.getColumnCount(); i++) {  
	            colNames.add(colInfo.getColumnName(i));  
	            titleRow.createCell((short) (i - 1)).setCellValue(  
	                    new HSSFRichTextString(colInfo.getColumnName(i)));  
	            xlsSheet.setColumnWidth((short) (i - 1), (short) 4000);  
	        }  
	  
	        // Guarde todos os dados das linhas da tabela de banco de dados  
	        while (rs.next()) {  
	            HSSFRow dataRow = xlsSheet.createRow(rowIndex++);  
	            short colIndex = 0;  
	            for (String colName : colNames) {  
	                dataRow.createCell(colIndex++).setCellValue(  
	                        new HSSFRichTextString(rs.getString(colName)));  
	            }  
	        }  
	  	        //Gravar em disco  
	        xlsWorkbook.write(new FileOutputStream(filename));  
    }  
	     //Fecha a conexão com o banco  
	    public void close() throws SQLException {  
	        connection.close();  
	   
            }  

            
          
            
      public void generateXls2() {  
	        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
	    }  
	  
	    public void generateXls2(String tablename, String filename)  
	            throws SQLException, FileNotFoundException, IOException {  
	  
	        // Criar nova pasta de trabalho Excel e folha  
	        HSSFWorkbook xlsWorkbook = new HSSFWorkbook();  
	        HSSFSheet xlsSheet = xlsWorkbook.createSheet("CineX");  
	        short rowIndex = 1;  
	  
	        // Executar a consulta SQL 
                
	        PreparedStatement stmt =  
	                connection.prepareStatement("SELECT * FROM Ator u INNER JOIN USUARIO_A_ATOR ua on ua.COD_ATOR = u.CODIGO INNER JOIN Usuario us on us.CODIGO_USUARIO = ua.COD_USUARIO");  
	        ResultSet rs = stmt.executeQuery();  
	  
	        // Obter a lista de nomes de colunas e armazená-los como o primeiro  
	        // linha da planilha.  
	        ResultSetMetaData colInfo = rs.getMetaData();  
	        ArrayList<String> colNames = new ArrayList<String>();  
	        HSSFRow titleRow = xlsSheet.createRow(rowIndex++);  
	  
	        for (int i = 1; i <= colInfo.getColumnCount(); i++) {  
	            colNames.add(colInfo.getColumnName(i));  
	            titleRow.createCell((short) (i - 1)).setCellValue(  
	                    new HSSFRichTextString(colInfo.getColumnName(i)));  
	            xlsSheet.setColumnWidth((short) (i - 1), (short) 4000);  
	        }  
	  
	        // Guarde todos os dados das linhas da tabela de banco de dados  
	        while (rs.next()) {  
	            HSSFRow dataRow = xlsSheet.createRow(rowIndex++);  
	            short colIndex = 0;  
	            for (String colName : colNames) {  
	                dataRow.createCell(colIndex++).setCellValue(  
	                        new HSSFRichTextString(rs.getString(colName)));  
	            }  
	        }  
	  	        //Gravar em disco  
	        xlsWorkbook.write(new FileOutputStream(filename));  
    }  
	    // Fecha a conexão com o banco  
	   // public void close() throws SQLException {  
	     //   connection.close();  
	   // }
            
            
       public void generateXls3() {  
	        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
	    }  
	  
	    public void generateXls3(String tablename, String filename)  
	            throws SQLException, FileNotFoundException, IOException {  
	  
	        // Criar nova pasta de trabalho Excel e folha  
	        HSSFWorkbook xlsWorkbook = new HSSFWorkbook();  
	        HSSFSheet xlsSheet = xlsWorkbook.createSheet("CineX");  
	        short rowIndex = 1;  
	  
	        // Executar a consulta SQL 
               
	        PreparedStatement stmt =  
	                connection.prepareStatement("SELECT AVG (PONTUACAO),u.NOME FROM Ator u INNER JOIN USUARIO_A_ATOR ua on ua.COD_ATOR = u.CODIGO group by u.NOME");  
	        ResultSet rs = stmt.executeQuery();  
	  
	        // Obter a lista de nomes de colunas e armazená-los como o primeiro  
	        // linha da planilha.  
	        ResultSetMetaData colInfo = rs.getMetaData();  
	        ArrayList<String> colNames = new ArrayList<String>();  
	        HSSFRow titleRow = xlsSheet.createRow(rowIndex++);  
	  
	        for (int i = 1; i <= colInfo.getColumnCount(); i++) {  
	            colNames.add(colInfo.getColumnName(i));  
	            titleRow.createCell((short) (i - 1)).setCellValue(  
	                    new HSSFRichTextString(colInfo.getColumnName(i)));  
	            xlsSheet.setColumnWidth((short) (i - 1), (short) 4000);  
	        }  
	  
	        // Guarde todos os dados das linhas da tabela de banco de dados  
	        while (rs.next()) {  
	            HSSFRow dataRow = xlsSheet.createRow(rowIndex++);  
	            short colIndex = 0;  
	            for (String colName : colNames) {  
	                dataRow.createCell(colIndex++).setCellValue(  
	                        new HSSFRichTextString(rs.getString(colName)));  
	            }  
	        }  
	  	        //Gravar em disco  
	        xlsWorkbook.write(new FileOutputStream(filename));  
    }  
	    // Fecha a conexão com o banco  
	   // public void close() throws SQLException {  
	     //   connection.close();  
	   // }

	 
}
    

