package ar.com.eduit.curso.java.repositories.jdbc;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CursoRepository implements I_CursoRepository {
    private Connection conn;

    public CursoRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Curso curso) {
        if(curso == null) return;
        //String query="insert into cursos (titulo,profesor,dia,turno) values ("
        //    + "'"+curso.getTitulo()+"','"+curso.getProfesor()+"',"
        //    + "'"+curso.getDia().toString()+"','"+curso.getTurno().toString()+"')";
        
        //Try with resources a partir de jdk 7
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );) {
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia().toString());
            ps.setString(4, curso.getTurno().toString());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) curso.setId(rs.getInt(1));
            //ps.close(); con try with resources se cierra automaticamente.
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Curso curso) {
        if(curso == null) return;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Curso curso) {
        if(curso == null) return;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso getByAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> getAll() {
        List<Curso>lista=new ArrayList();
        try (ResultSet rs=conn.prepareStatement("select * from cursos").executeQuery()){
            while(rs.next()){
                lista.add(
                        new Curso(
                                rs.getInt("id"),
                                rs.getString("titulo"),
                                rs.getString("profesor"),
                                Dia.valueOf(rs.getString("dia")),
                                Turno.valueOf(rs.getString("turno"))
                        )
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    @Override
    public List<Curso> getByTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> getLikeTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> getLikeProfesor(String profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}