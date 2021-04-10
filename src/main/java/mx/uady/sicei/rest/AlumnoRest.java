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

import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.service.AlumnoService;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos") // Verbo GET, URL: uady.mx/api/alumnos
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    @PostMapping("/alumnos") // ? /alumnos/crear
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        return ResponseEntity.ok().body(alumnoCreado);
    }

    // Path Paramater
    @PutMapping("/alumnos/{matricula}") // PUT /alumnos/1001930
    public ResponseEntity<Alumno> editarAlumno(@PathVariable String matricula, @RequestBody Alumno alumno) {
        return ResponseEntity.ok().body(alumnoService.updateStudent(matricula, alumno));
    }

    // Path Paramater
    @GetMapping("/alumnos/{matricula}") // GET /alumnos/1001930
    public ResponseEntity<List<Alumno>> obtenerAlumno(@PathVariable String matricula) {
        return ResponseEntity.ok().body(alumnoService.searchStudentById(matricula));
    }

    // Path Paramater
    @DeleteMapping("/alumnos/{matricula}") // DELETE /alumnos/1001930
    public ResponseEntity<Void> eliminarAlumno(@PathVariable String matricula) {
        return ResponseEntity.ok().body(alumnoService.deleteStudent(matricula));
    }


}