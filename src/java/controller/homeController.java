package controller;

import dao.ClienteDao;
import dao.ConectarDB;
import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import models.Cliente;
import models.ClienteValidation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    private JdbcTemplate jdbcTemplate;
    ClienteValidation cliValidar;
    public homeController() {
        this.cliValidar = new ClienteValidation();
        ConectarDB con = new ConectarDB();
        try{
            this.jdbcTemplate = new JdbcTemplate(con.conectar());
        }catch(ConnectException exc){
            JOptionPane.showMessageDialog( null, "Error al conectar SQL " + exc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
        catch(SQLException sqlexc){
            JOptionPane.showMessageDialog( null, "Error en SQL " + sqlexc.getMessage(), "", JOptionPane.WARNING_MESSAGE);
        }       
    }
    
    @RequestMapping(value="formCliente.htm", method=RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        Cliente cliente = new Cliente();        
        mav.addObject("cliente",cliente);
        mav.setViewName("views/formCliente");
        return mav;
    }
    
    @RequestMapping(value="formCliente.htm", method=RequestMethod.POST)
    public ModelAndView mostrarCliente(){
        ModelAndView mav = new ModelAndView() ;
        ClienteDao cli = new ClienteDao();
        List datos = cli.consultarCliente();
        mav.addObject("cliente",datos);
        mav.setViewName("views/mostrarCliente");
        return mav;
    }

    

    @RequestMapping(value="agregarCliente.htm", method=RequestMethod.GET)
    public ModelAndView cargarCliente(){
        ModelAndView mav = new ModelAndView();
         mav.addObject("cliente", new Cliente());
        mav.setViewName("views/agregarCliente");
        return mav;
    }

    @RequestMapping(value="agregarCliente.htm", method=RequestMethod.POST)
    public ModelAndView agregarCliente( 
            @ModelAttribute ("cliente") Cliente cli,
            BindingResult result,
            SessionStatus status
            )
    {
        this.cliValidar.validate(cli, result);
        if(result.hasErrors()){
            ModelAndView mov = new ModelAndView();        
            mov.addObject("cliente", new Cliente());
            mov.setViewName("views/agregarCliente");
            return mov;
        }else{
            ModelAndView mav = new ModelAndView();            
            String sql = "insert into cliente (nombre,direccion,correo,telefono,salario) values (?,?,?,?,?) ";
            this.jdbcTemplate.update(sql,
                    cli.getNombre(), cli.getDireccion(), cli.getCorreo(), 
                    cli.getTelefono(), cli.getSalario());
            mav.setViewName("redirect:/formCliente.htm");
            return mav;
        }
    }

    @RequestMapping(value="actCliente.htm", method=RequestMethod.GET)
    public ModelAndView actCliente(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        
        Cliente cli = this.cargarClientesbyId(id);
        
        mav.addObject("cliente", new Cliente(id, cli.getNombre(),
        cli.getDireccion(), cli.getCorreo(), cli.getTelefono(), cli.getSalario()));
        mav.setViewName("views/actCliente");
        return mav;
    }

       @RequestMapping(value="actCliente.htm", method=RequestMethod.POST)
    public ModelAndView actCliente( 
            @ModelAttribute ("cliente") Cliente cli,
            BindingResult result,
            SessionStatus status
    ){
         this.cliValidar.validate(cli, result);
        if(result.hasErrors()){
            ModelAndView mov = new ModelAndView();        
            mov.addObject("cliente", new Cliente());
            mov.setViewName("views/actCliente");
            return mov;
        }else{
            ModelAndView mav = new ModelAndView();
            String sql = "update cliente set nombre = ?, direccion = ? , correo = ? ,"
                    + "telefono = ? , salario = ? where id = ? ";
            this.jdbcTemplate.update(
                    sql,cli.getNombre(), cli.getDireccion(), cli.getCorreo(), 
                        cli.getTelefono(), cli.getSalario(), cli.getId());
            mav.setViewName("redirect:/formCliente.htm");
            return mav;
        }
    }

    @RequestMapping("borrarCliente.htm")
    public ModelAndView borrarCliente(HttpServletRequest request ){
     ModelAndView mav = new ModelAndView();
     int id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from cliente where id = ? ";
        this.jdbcTemplate.update(sql,id);
        mav.setViewName("redirect:/formCliente.htm");
        return mav;
    }

    public Cliente cargarClientesbyId(int id){
        final Cliente cli = new Cliente( );
        String sql = "select * from cliente where id =  " + id ; 
        
        return (Cliente) jdbcTemplate.query(sql, new ResultSetExtractor<Cliente>()
        {
            public Cliente extractData (ResultSet rs ) throws SQLException, DataAccessException{
                if(rs.next()){
                    cli.setId(rs.getInt("id"));
                    cli.setNombre(rs.getString("nombre"));
                    cli.setDireccion(rs.getString("direccion"));
                    cli.setCorreo(rs.getString("correo"));
                    cli.setTelefono(rs.getString("telefono"));
                    cli.setSalario(rs.getInt("salario"));
                }
                return cli;
            }         
        });
    }
}
