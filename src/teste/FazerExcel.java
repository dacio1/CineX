/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Usuario.Usuario;
import Usuario.UsuarioDAO;
/**
 *
 * @author Dacio
 */
public class FazerExcel {
    
    public static void main(String[] args)throws Throwable{
        UsuarioDAO UD = new UsuarioDAO();
        FileOutputStream saida = new FileOutputStream("teste2.xls");
      
        Workbook wb = new HSSFWorkbook();
        
        
        Sheet s = wb.createSheet();
        
        Row r = null;
        
        Cell c = null;
        
        
        r = s.createRow(0);
        
        c = r.createCell(0);
        
        //c.setCellValue();
        
        CellReference cellReference = new CellReference("A1");
        
        Row row = s.getRow(cellReference.getRow());
        
        Cell cell = row.getCell(cellReference.getCol());
        
        System.out.println(cell.getStringCellValue());
        
        
        for(Row rowFor : s){
            for(Cell cellFor : rowFor){
                System.out.println(cell.getStringCellValue());
            }
        }
        
       wb.write(saida);
       
       saida.close();
    }
}
