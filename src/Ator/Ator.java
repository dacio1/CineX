/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ator;

import javax.swing.text.html.parser.Entity;

/**
 *
 * @author Livya Menezes
 */

public class Ator {
    
    private int codigo, codigoatualizar, codigoExcluir;
    private String nome,nacionalidade;
    private double pontuacao;
    private int codigoUsuario;

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
      public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getCodigoatualizar() {
        return codigoatualizar;
    }

    public void setCodigoatualizar(int codigoatualizar) {
        this.codigoatualizar = codigoatualizar;
    }

    public int getCodigoExcluir() {
        return codigoExcluir;
    }

    public void setCodigoExcluir(int codigoExcluir) {
        this.codigoExcluir = codigoExcluir;
    }
   
    public Ator(String nome ,String nacionalidade){
    
         this.nome = nome;
         this.nacionalidade = nacionalidade;
         
    }
     //Construtor 
     public Ator(){
         
     }
     
   

    public Ator(int codigoUsuario, int codigo , double pontuacao) {
       
       
        this.codigoUsuario = codigoUsuario;
        
         this.codigo = codigo;
        
         this.pontuacao = pontuacao;
    }
      
     
    
    
}
