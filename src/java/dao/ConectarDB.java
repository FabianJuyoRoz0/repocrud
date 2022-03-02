
package dao;

import java.net.ConnectException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConectarDB {
    public DriverManagerDataSource conectar () throws ConnectException, SQLException{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        try{
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/prueba");
        datasource.setUsername("root");
        datasource.setPassword("");
        }catch(Exception e){
           JOptionPane.showMessageDialog( null, "Error al conectar SQL " + e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
         }
        return datasource;
    }
}
