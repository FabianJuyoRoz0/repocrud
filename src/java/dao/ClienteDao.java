package dao;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClienteDao {    
    JdbcTemplate jdbcTemplate;
    ConectarDB con = new ConectarDB();
    
    public List consultarCliente(){
        List datos = new ArrayList();
        try{
         this.jdbcTemplate = new JdbcTemplate(con.conectar());           
        String sql = "select * from cliente";        
        datos = this.jdbcTemplate.queryForList(sql);
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }
        return datos;
    }
    public List consultarClienteById(int id){
        List cli = new ArrayList();
        try{
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        String sql = "select * from cliente where id = ? ";
        cli = this.jdbcTemplate.queryForList(sql,id);
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       

        return cli;
    }
    public List consultarClienteByNombre(String nombre){
        List cli = new ArrayList();
        try{
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        String sql = "select * from cliente where nombre like '%" + nombre + "%' ";
        cli = this.jdbcTemplate.queryForList(sql);
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
       return cli;
    }
  
    public List consultarClienteBySalario(double salario){
        List cli = new ArrayList();
        try{
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        String sql = "select * from cliente where salario = ?";
        cli = this.jdbcTemplate.queryForList(sql, salario);
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        return cli;
    }
    
    public List telefonosCliente ( String telefono){
        List tele = new ArrayList();
        try{
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        String sql = "select * from cliente where telefono like '%" + telefono + "%'";
        tele = this.jdbcTemplate.queryForList(sql);        
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        } 
        return tele;
    }
}
