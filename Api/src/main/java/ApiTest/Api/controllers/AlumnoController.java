package ApiTest.Api.controllers;
import ApiTest.Api.domain.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    public List<Alumno> planillaDeAlumnos = new ArrayList<>(Arrays.asList(
            new Alumno( 1 ,"Nicolas Falabella" ,"nicolas@gmail.com" ,28 ,"Programacion"),
            new Alumno( 2 ,"Eduardo Gonzales" ,"eduardo@gmail.com" ,27 ,"Programacion"),
            new Alumno( 3 ,"Sebastian Hernandez" ,"sebastian@gmail.com" ,29 ,"Backend"),
            new Alumno( 4 ,"Javier Romero" ,"javier@gmail.com" ,26 ,"Frontend")
    ));

    @GetMapping
    public List<Alumno> getAlumnos () {
        return planillaDeAlumnos;
    }

    @GetMapping("/{email}")
    public Alumno getAlumnoByEmail(@PathVariable String email){
        for( Alumno alumnoEncontrado : planillaDeAlumnos) {
            if( alumnoEncontrado.getEmail().equalsIgnoreCase(email) ){
                return alumnoEncontrado;
            }
        }
        return null ;
    }

    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno nuevoAlumno) {
        planillaDeAlumnos.add(nuevoAlumno) ;
        return nuevoAlumno ;
    }

    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumnoEditado ){
        for ( Alumno alumnoEncontrado :  planillaDeAlumnos) {
            if( alumnoEncontrado.getId() == alumnoEditado.getId()){
                alumnoEncontrado.setNombre(alumnoEditado.getNombre());
                alumnoEncontrado.setEmail(alumnoEditado.getEmail());
                alumnoEncontrado.setCurso(alumnoEditado.getCurso());
                alumnoEncontrado.setEdad(alumnoEditado.getEdad());
                return alumnoEncontrado ;
            }
        }
        return null ;
    }

    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumnoEditadoParcial) {
        for( Alumno alumnoEncontrado : planillaDeAlumnos) {
            if( alumnoEncontrado.getId() == alumnoEditadoParcial.getId()){
                if( alumnoEditadoParcial.getNombre() != null) {
                    alumnoEncontrado.setNombre(alumnoEditadoParcial.getNombre());
                }
                if( alumnoEditadoParcial.getCurso() != null){
                    alumnoEncontrado.setCurso(alumnoEditadoParcial.getCurso());
                }
                if(alumnoEditadoParcial.getEmail() != null){
                    alumnoEncontrado.setEmail(alumnoEditadoParcial.getEmail());
                }
                if(alumnoEditadoParcial.getEdad() > 0){
                    alumnoEncontrado.setEdad(alumnoEditadoParcial.getEdad());
                }
                return alumnoEncontrado ;
            }
        }
        return null ;
    }

    @DeleteMapping("/{id}")
    public String deleteAlumno(@PathVariable int id) {
        for ( Alumno alumnoAEliminar : planillaDeAlumnos ) {
            if( alumnoAEliminar.getId() == id) {
                planillaDeAlumnos.remove(alumnoAEliminar) ;
                return "Alumno eliminado exitosamente" ;
            }
        }
        return "no se encontro alumno" ;
    }
}
