package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.connectors.Connector;
import java.sql.Connection;
import java.sql.Statement;
public class TestConnector {
    public static void main(String[] args) throws Exception{
        Connection conn=Connector.getConnection();
        Statement st=conn.createStatement();
        String query="insert into cursos (titulo,profesor,dia,turno) values "
                + "('PHP','Carlos Ríos','lunes','tarde')";
        st.execute(query);
        
        Connector
                .getConnection()
                .createStatement()
                .execute(
                    "insert into cursos (titulo,profesor,dia,turno) values "
                    + "('Java','Carlos Ríos','jueves','noche')"
                );
        
    }
}