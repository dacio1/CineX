/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocios;

import Filme.Filme;
import Filme.FilmeDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ivson
 */
public class RandomFilme {
//     private int getCodigo;
//    
//    
//    public List<Filme> randomFilme(){
//        Random random = new Random();
//        List<String> nome = new ArrayList<String>();
//        List<Filme> filmes = new ArrayList<Filme>();
//        List<String> genero = new ArrayList<String>();
//        List<String> diretor = new ArrayList<String>();
//        Filme filme = new Filme();
//        
//      
//        int a;
//        int codigo=10000;
//        int c=1960;
//        
//        String[] nomes = {"Harry Potter E A Pedra Filosofal", "Harry Potter E A Câmara Secreta", "Harry Potter E O Prisioneiro de Azkaban", "Harry Potter E O Cálice de Fogo", "Harry Potter E A Ordem da Fênix", "Harry Potter E O Enigma do Príncipe",
//        "Cisne Negro", "The Bling Ring", "", "A Rainha", "Durance Vip", "Dezeseis Luas" , "Tom uma historia de vida",
//        "Marley & Eu", "Um Porto Seguro", "Diamante de Sangue", "Meninas Malvadas", "13 é Demais", "Beyoncé - Life Is But A Dream", "Britney, For The Record",
//        "Dreamgirls", "Beyoncé - I Am World Tour", "Beyoncé, I Am... Intimate Performance", "RBD - Que Hay Detrás", "Piper Perabo", "Juntos Pelo Acaso", "Noivas em Guerra", "O Diabo Veste Prada",
//        "Never Say Never", "A Casa do Lago", "O Guarda Costas", "X-Men - Dias de Um Futuro Esquecido", "X-Men - A Última Batalha", "Crepúsculo", "Lua Nova", "Eclipse", "Amanhecer Parte I", "Amanhecer Parte 2", "Percy Jackson E O Ladrão de Raios", "Percy Jackson E O Mar de Monstros",
//        "Cidade de Deus", "Carandiru", "Se Beber, Não Case", "Invasão A Casa Branca", "Anaconda - 1", "Anaconda - 2", "Diário de Uma Princesa"};
//        
//
//        for (int i = 0; i < 10000; i++) {
//            a = 0 + random.nextInt(10);
//
//            if (i % 5 == 0) {
//                nome.add(nomes[a]);
//            }
//        }
//        
//        
//        
//        int id_u = 1;
//        for (int j = 0; j <codigo; j++){
//            filmes.add(new Filme(j+1,null, null, c+1, null));
//            
//            
//             filmes.get(j).setCodigo(j);
//            
//        }
//        
//       
//       
//          for (int i = 0; i < 10000; i++) {
//            a = 0 + random.nextInt(10);
//
//            if (i % 5 == 0) {
//                nome.add(nomes[a]);
//                
//                
//            }
//        }
//        
//        for (int j = 0; j < nome.size(); j++){
//            
//            filmes.get(j).setNome(nome.get(j));
//            
//        }
//        
//        
//    
//    
//    
//        
//        
//        //Genero
//        String[] generos = {"Acao" , "Comedia" , "Drama" , "Romance" , "Terror" , "Suspense" , "Animacao"};
//        
//
//        for (int i = 0; i < 10000; i++) {
//            a = 0 + random.nextInt(10);
//
//            if (i % 5 == 0) {
//                genero.add(generos[a]);
//            }
//        }
//        
//        
//        
//        
//        
//        for (int j = 0; j <codigo; j++){
//            filmes.add(new Filme(j+1,null, null, c+1, null));
//            
//            
//             filmes.get(j).setCodigo(j);
//            
//        }
//        
//       
//       
//          for (int i = 0; i < 10000; i++) {
//            a = 0 + random.nextInt(10);
//
//            if (i % 5 == 0) {
//                genero.add(generos[a]);
//                
//                
//            }
//        }
//        
//        for (int j = 0; j < genero.size(); j++){
//            
//            filmes.get(j).setGenero(genero.get(j));
//}
//    
//     for (int j = 0; j <c; j++){
//            filmes.add(new Filme(j+1,null, null, c+1, null));
//            
//            
//             filmes.get(j).setAno(j);
//            
//        }
//     //Diretor
//        String[] diretores = {"Alea", "Tomas", "Allen", "Altman", "Robert", "Assis Brasil", "Ayrton", "Jorge", "Dacio", "IgorSanca" };
//        
//
//        for (int i = 0; i < 10000; i++) {
//            a = 0 + random.nextInt(10);
//
//            if (i % 5 == 0) {
//                diretor.add(diretores[a]);
//            }
//        }
//     
//        return filmes;
//    }
}
