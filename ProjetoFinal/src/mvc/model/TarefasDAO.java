package mvc.model;


import java.sql.*;
import java.util.*;


public class TarefasDAO {


    private Connection connection = null;
	
    public TarefasDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost/meus_dados", "root", "190314");
        } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    }


    public void adicionaDescricao(Tarefa tarefa) {
        try {
            String sql = "INSERT INTO Tarefa (usuario,descricao) values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getUsuario());
            stmt.setString(2,tarefa.getDescricao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {e.printStackTrace();}
    }


	
    public List<Tarefa> getLista() {
    	
    	   List<Tarefa> tarefas = new ArrayList<Tarefa>();
           try {	
               PreparedStatement stmt = connection.
   					prepareStatement("SELECT * FROM Tarefa");
               ResultSet rs = stmt.executeQuery();
               while (rs.next()) {
                   Tarefa tarefa = new Tarefa();
                   tarefa.setId(rs.getLong("id"));
                   tarefa.setUsuario(rs.getString("usuario"));
                   tarefa.setDescricao(rs.getString("descricao"));
                   tarefas.add(tarefa);
               }
               rs.close();
               stmt.close();
           } catch(SQLException e) {System.out.println(e);}
           return tarefas;
       }



       public void close() {
           try { connection.close();}
           catch (SQLException e) {e.printStackTrace();}		
       }


   }