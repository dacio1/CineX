/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

  import java.io.File;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.util.ArrayList;
  import java.util.List;
   
  import org.apache.poi.hssf.usermodel.HSSFSheet;
  import org.apache.poi.hssf.usermodel.HSSFWorkbook;
  import org.apache.poi.ss.usermodel.Cell;
  import org.apache.poi.ss.usermodel.Row;

  import Usuario.Usuario;
  import Usuario.UsuarioDAO;
   
  public class CriaExcel {
         
         public static final String fileName = "novo.xls";
   
         public static void main(String[] args) throws IOException {
   
             UsuarioDAO UD = new UsuarioDAO();
             Usuario usuario = new Usuario();
               HSSFWorkbook workbook = new HSSFWorkbook();
               HSSFSheet sheetUsuario = workbook.createSheet("Usuario");
                
               List<Usuario> listaUsuario = new ArrayList<Usuario>();
               /*listaAlunos.add(new Aluno("Eduardo", "9876525", 7, 8, 0, false));
               listaAlunos.add(new Aluno("Luiz", "1234466", 5, 8, 0, false));
               listaAlunos.add(new Aluno("Bruna", "6545657", 7, 6, 0, false));
               listaAlunos.add(new Aluno("Carlos", "3456558", 10, 3, 0, false));
               listaAlunos.add(new Aluno("Sonia", "6544546", 7, 8, 0, false));
               listaAlunos.add(new Aluno("Brianda", "3234535", 6, 5, 0, false));
               listaAlunos.add(new Aluno("Pedro", "4234524", 7, 5, 0, false));
               listaAlunos.add(new Aluno("Julio", "5434513", 7, 2, 0, false));
               listaAlunos.add(new Aluno("Henrique", "6543452", 7, 8, 0, false));
               listaAlunos.add(new Aluno("Fernando", "4345651", 5, 8, 0, false)); 
               listaAlunos.add(new Aluno("Vitor", "4332341", 7, 9, 0, false));    */
              //listaUsuario.add(new Usuario(UD.ListarUsuarios()));
                
               int rownum = 0;
               
               for (Usuario usuari : listaUsuario) {
                   
                   Row row = sheetUsuario.createRow(rownum++);
                   int cellnum = 0;
                   Cell cellNome = row.createCell(cellnum++);
                   cellNome.setCellValue(usuari.getCodigo());
                   Cell cellRa = row.createCell(cellnum++);
                   cellRa.setCellValue(usuari.getCpf());
                   Cell cellNota1 = row.createCell(cellnum++);
                   cellNota1.setCellValue(usuari.getNome());
                   Cell cellNota2 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuari.getEmail());
                   Cell cellNota3 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuari.getAcesso());
                   Cell cellNota4 = row.createCell(cellnum++);
                   cellNota2.setCellValue(usuari.getSenha());
               }
                
               try {
                   FileOutputStream out = 
                           new FileOutputStream(new File(CriaExcel.fileName));
                   workbook.write(out);
                   out.close();
                   System.out.println("Arquivo Excel criado com sucesso!");
                    
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
                      System.out.println("Arquivo não encontrado!");
               } catch (IOException e) {
                   e.printStackTrace();
                      System.out.println("Erro na edição do arquivo!");
               }
   
         }
   
  }

