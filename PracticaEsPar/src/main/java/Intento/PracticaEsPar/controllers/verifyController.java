package Intento.PracticaEsPar.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class verifyController {

    @GetMapping("/espar/{numeroPorParametro}")
    public String EsPar ( @PathVariable String numeroPorParametro ) {
        if (verifyNumber(numeroPorParametro)) {
            return "El numero " + numeroPorParametro + "es par" ;
        }
        return "El numero " + numeroPorParametro + "es impar" ;
    }


    private boolean verifyNumber (@PathVariable String numeroPorParametro) {
        int numberConverted = Integer.parseInt(numeroPorParametro);
        return numberConverted % 2 == 0;
    }
}

