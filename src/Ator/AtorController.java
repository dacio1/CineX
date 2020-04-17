/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ator;

import Negocios.ErroInternoException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dacio
 */
public class AtorController {
    
    
    public  void salvar(String nome, String nacionalidade)throws SQLException, ErroInternoException{

        Ator ator = new Ator();
        AtorDAO atd = new AtorDAO();
        ator.setNome(nome);
        ator.setNacionalidade(nacionalidade);
        atd.InsereAtor(ator);
        
    }
    
    public void atualizar(int codigoatualizar, String nome, String nacionalidade)throws SQLException, ErroInternoException{
        
        Ator ator = new Ator();
        AtorDAO atd = new AtorDAO();
        ator.setCodigo(codigoatualizar);
        ator.setNome(nome);
        ator.setNacionalidade(nacionalidade);
        atd.AtualizaAtor(ator);
    }
     
    public List<Ator> listar(){
        AtorDAO ator = new AtorDAO();
        return ator.ListarAtores();
    }
    
    public void excluir(int codexcluir){
        Ator ator = new Ator();
        AtorDAO atd = new AtorDAO();
        
        ator.setCodigo(codexcluir);
        atd.DeletaAtor(ator);
    }
}
