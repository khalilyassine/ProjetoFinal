package mvc.model;


import java.io.*;
import java.sql.*;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;


public class UsuarioDAO {


    private Connection connection = null;
	
    public UsuarioDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost/meus_dados", "root", "190314");
        } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    }


    public void adiciona (Usuario usuario) throws IOException {
    	/* Rotina para salvar o arquivo no servidor
    	if (!filePart.isEmpty()) {
    	    String fileName = filePart.getOriginalFilename();
           File uploads = new File("/tmp");
       	    File file = new File(uploads, fileName);
       	    try (InputStream input = filePart.getInputStream()) {
       	        Files.copy(input, file.toPath());
       	    }
    	}
    	*/
        try {
            String sql = "INSERT INTO usuario (login, senha, foto) values(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,usuario.getLogin());
            stmt.setString(2,usuario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {e.printStackTrace();}
    }


    public boolean existeUsuario(Usuario usuario) {
        boolean existe = false;
    	try {	
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM usuario WHERE Login=? AND senha=? LIMIT 1");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
        	if(rs.getInt(1) != 0) {existe=true;}
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {
        	System.out.println("alo");
        	System.out.println(e);}
        return existe;
    }
    
    
    }
