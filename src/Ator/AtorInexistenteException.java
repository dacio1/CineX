/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ator;

/**
 *
 * @author Dacio
 */
public class AtorInexistenteException extends Exception {
    
     public AtorInexistenteException(String message) {
        super(message);
    }

    public AtorInexistenteException(Throwable cause) {
        super(cause);
    }
    
}
