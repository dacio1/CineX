/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ator;

import Negocios.ErroInternoException;
import java.sql.SQLException;

/**
 *
 * @author Dacio
 */
public class AtorControllerAntiga {
    
    
     public  void salvar(int codigo, String nome, String nacionalidade, double pontuacao)throws SQLException{
        //throws SQLException{
        
        Ator ator = new Ator();
        AtorDAO atd = new AtorDAO();
        
        ator.setCodigo(codigo);
        ator.setNome(nome);
        ator.setNacionalidade(nacionalidade);
        ator.setPontuacao(pontuacao);
     
       
        
    }
     
  
}
