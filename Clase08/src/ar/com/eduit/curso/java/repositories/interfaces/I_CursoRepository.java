package ar.com.eduit.curso.java.repositories.interfaces;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;
public interface I_CursoRepository {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    Curso getById(int id);
    Curso getByAlumno(Alumno alumno);
    List<Curso>getAll();
    List<Curso>getByTitulo(String titulo);
    List<Curso>getLikeTitulo(String titulo);
    List<Curso>getLikeProfesor(String profesor);
}