/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Filme;

/**
 *
 * @author Dacio
 */
public class Filme {
    
    private int codigo,ano;
    private String nome,genero,diretor;
    private double pontuacao;
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
      public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
      public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome ;
    }
    
     public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    
     public Filme(String nome,String genero,int ano,String diretor){
    
         
         this.nome = nome;
         this.genero = genero;
         this.ano = ano;
         this.diretor = diretor;
         
 }
     //contrutor
     public Filme(){
         
     }
}
