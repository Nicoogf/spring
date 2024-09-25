package com.palindromo.palindromo.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Contolador para verificar palindromo
 */

@RestController
public class VerifyPalindromoController {

    /**
     * EndPoint para verificar palindromo
     * @param palabra la palabra a verificar
     * @return mensaje indicando si es un palindromo
     */

    @GetMapping("/validar/{palabra}")
    public String Palindrome (@PathVariable  String palabra){
        if( isPalindrome(palabra)  ) {
            return "La palabra " + palabra + "es palindromo" ;
        }else{
            return "La palabra " + palabra + "no es palindromo" ;
        }
    }


    /**
     * Metodo para verificar
     * @param palabra
     * @return un true o false si cumple la condicion
     */
    private boolean isPalindrome(@PathVariable String palabra){
        int length = palabra.length() ;
        for( int i = 0 ; i < length/2 ; i++ ) {
            if( palabra.charAt(i) != palabra.charAt(length - i - 1) ) {
                return false ;
            }
        }
        return true ;
    }
}
