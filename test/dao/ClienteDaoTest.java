
package dao;

import models.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author osben
 */
public class ClienteDaoTest {
    
    public ClienteDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarClienteById method, of class ClienteDao.
     */
    //-----------------------------------------------------------------------
    @org.junit.Test
    public void testConsultarClienteById() {
        
        System.out.println("consultarClienteById");
        int id = 5;
        ClienteDao instance = new ClienteDao();
        List cli = new ArrayList();
        cli = instance.consultarClienteById(id);
        List expResult = cli;
        List result = instance.consultarClienteById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  /*---------------------------------------------------------------------------  
    /**
     * Test of consultarClienteByNombre method, of class ClienteDao.
     */
    @org.junit.Test
    public void testConsultarClienteByNombre() {
        System.out.println("consultarClienteByNombre");
        String nombre = "p";
        ClienteDao instance = new ClienteDao();
        List<Cliente> cli = new ArrayList<Cliente>();
        cli = instance.consultarClienteByNombre(nombre);
        List expResult = cli;
        List result = instance.consultarClienteByNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    /**
     * Test of consultarClienteBySalario method, of class ClienteDao.
     */
    @org.junit.Test
    public void testConsultarClienteBySalario() {
        System.out.println("consultarClienteBySalario");
        int salario = 456789;
        ClienteDao instance = new ClienteDao();
//        creamos la clase cliente
        Cliente cliente = new Cliente();
        List<Cliente> cli = new ArrayList<Cliente>();
        cli = instance.consultarClienteBySalario(salario);
        List expResult = cli;
        List result = instance.consultarClienteBySalario(salario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultarCliente method, of class ClienteDao.
     */
    @Test
    public void testConsultarCliente() {
        System.out.println("consultarCliente");
        ClienteDao instance = new ClienteDao();
        List expResult = instance.consultarCliente();
        List result = instance.consultarCliente();
        assertEquals("SE observa el resultado: ",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
