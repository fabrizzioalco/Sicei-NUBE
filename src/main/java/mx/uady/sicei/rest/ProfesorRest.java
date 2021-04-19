package mx.uady.sicei.rest;

import java.util.LinkedList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.sicei.model.Profesor;
import mx.uady.sicei.service.ProfessorService;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class ProfesorRest {

    @Autowired
    private ProfessorService profesorService;

    @GetMapping("/profesors") // Verbo GET, URL: uady.mx/api/alumnos
    public ResponseEntity<List<Profesor>> getProfesors() {
        return ResponseEntity.ok().body(profesorService.getProfesors());
    }

    @PostMapping("/profesors") // ? /alumnos/crear
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor profesorCreado = profesorService.crearProfesor(profesor);
        return ResponseEntity.ok().body(profesorCreado);
    }

    // Path Paramater
    @PutMapping("/profesors/{matricula}") // PUT /alumnos/1001930
    public ResponseEntity<Profesor> editarProfesor(@PathVariable String matricula, @RequestBody Profesor profesor) {
        return ResponseEntity.ok().body(profesorService.updateProfessor(matricula, profesor));
    }

    // Path Paramater
    @GetMapping("/profesors/{matricula}") // GET /alumnos/1001930
    public ResponseEntity<List<Profesor>> obtenerProfesor(@PathVariable String matricula) {
        return ResponseEntity.ok().body(profesorService.searchProfessorById(matricula));
    }

    // Path Paramater
    @DeleteMapping("/profesors/{matricula}") // DELETE /alumnos/1001930
    public ResponseEntity<Void> eliminarProfesor(@PathVariable String matricula) {
        return ResponseEntity.ok().body(profesorService.deleteProfessor(matricula));
    }


}