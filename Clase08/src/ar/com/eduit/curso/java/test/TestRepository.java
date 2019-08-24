package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.connectors.Connector;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.repositories.jdbc.CursoRepository;
import java.sql.Connection;
public class TestRepository {
    public static void main(String[] args) {
        Connection conn=Connector.getConnection();
        I_CursoRepository cr=new CursoRepository(conn);
        Curso curso=new Curso("HTML","Carlos Ríos",Dia.lunes,Turno.noche);
        cr.save(curso);
        System.out.println(curso);
        
        cr.getAll().forEach(System.out::println);
        
        
    }
}