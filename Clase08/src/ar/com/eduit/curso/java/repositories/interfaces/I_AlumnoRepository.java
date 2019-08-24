package ar.com.eduit.curso.java.repositories.interfaces;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;
public interface I_AlumnoRepository {
    void save(Alumno alumno);
    void remove(Alumno alumno);
    void update(Alumno alumno);
    Alumno getById(int id);
    List<Alumno>getAll();
    List<Alumno>getLikeApellido(String apellido);
    List<Alumno>getLikeApellidoAndNombre(String apellido,String nombre);
    List<Alumno>getLikeCurso(Curso curso);
}