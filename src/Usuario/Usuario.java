/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

/**
 *
 * @author Dacio
 */
public class Usuario {
    
    private String cpf,nome,senha,email;
    private int codigo,acesso;

    
    private static class UsuarioLogado {
        private final static Usuario instancia = new Usuario();
    }
    
    public static Usuario getInstancia() {
        return UsuarioLogado.instancia;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
   public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
    
    public Usuario(String cpf,String nome,String email,int acesso, String senha){
        
        
        this.cpf = cpf;
        this.nome = nome;
        
        this.email = email;
        
        this.acesso = acesso;
        this.senha = senha;
    }
    
    public Usuario(){
        
    }
    
    public String toString (){
        
        String resultado = "Usuario" +this.cpf +"\n";
        resultado = resultado + "Nome" + this.nome + "\n";
        
        
        return resultado;
    }
}
