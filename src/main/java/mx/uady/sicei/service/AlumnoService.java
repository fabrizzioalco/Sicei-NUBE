package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import mx.uady.sicei.model.Alumno;

@Service
public class AlumnoService {

    private List<Alumno> alumnos = new LinkedList<>();

    {
        alumnos.add(new Alumno("100001940", "Eduardo Rodriguez"));
        alumnos.add(new Alumno("100001941", "Eduardo"));
        alumnos.add(new Alumno("100001941", "Eduardo"));
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno crearAlumno(Alumno alumno) {
        if (alumnos.indexOf(alumno) != -1) {
            alumnos.add(alumno);
            return alumno;
        } else {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }

    public List<Alumno> searchStudentById(String studentId) {
        // Predicate to filter the values and get the one with the same studentId.
        List<Alumno> students = alumnos.stream().filter(student -> student.getMatricula().equals(studentId))
                .collect(Collectors.toList());
        if (students.size() > 0) {
            return students;
        } else {
            throw new Error();
        }
    }

    public Alumno updateStudent(String studentId, Alumno alumno) {
        // Using searchStudentById to search for the specific and asign the value as
        // Alumno.
        Alumno student = searchStudentById(studentId).get(0);
        int index = alumnos.indexOf(student);
        if (alumno.getMatricula() != null)
            alumnos.set(index, alumno);
        return alumnos.get(index);
    }

    public Void deleteStudent(String studentId) {
        Alumno student = searchStudentById(studentId).get(0);
        int index = alumnos.indexOf(student);
        alumnos.remove(index);
        return null;
    }

}