package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import mx.uady.sicei.model.Profesor;

@Service
public class ProfessorService {

    private List<Profesor> profesores = new LinkedList<>();

    {
        profesores.add(new Profesor("Eduardo Rodriguez", "Eduardo.Rodrigues@uady.com"));
        profesores.add(new Profesor("Rodrigo Guerra", "Rodrigo.Guerra@uady.com"));
        profesores.add(new Profesor("Hernar Barrera", "Hernan.Barrera@uady.com"));
    }

    public List<Profesor> getProfesors() {
        return profesores;
    }

    public Profesor crearProfesor(Profesor professor) {
        if (profesores.indexOf(professor) != -1) {
            profesores.add(professor);
            return professor;
        } else {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }

    public List<Profesor> searchProfessorById(String professorId) {
        // Predicate to filter the values and get the one with the same professorId.
        List<Profesor> professors = profesores.stream().filter(professor -> professor.getMatricula().equals(professorId))
                .collect(Collectors.toList());
        if (professors.size() > 0) {
            return professors;
        } else {
            throw new Error();
        }
    }

    public Profesor updateProfessor(String professorId, Profesor professor) {
        // Using searchProfessorById to search for the specific and asign the value as
        // Profesor.
        Profesor profesor = searchProfessorById(professorId).get(0);
        int index = profesores.indexOf(profesor);
        if (professor.getMatricula() != null)
            profesores.set(index, profesor);
        return profesores.get(index);
    }

    public Void deleteProfessor(String professorId) {
        Profesor professor = searchProfessorById(professorId).get(0);
        int index = profesores.indexOf(professor);
        profesores.remove(index);
        return null;
    }

}