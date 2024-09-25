package CursoSpringBoot.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWordRestController {

    @GetMapping({"/hello" , "/hola" , "/hw"})
    public String HelloWord(){
        System.out.println("Impresion de consola");
        return "Hello word" ;
    }
}
