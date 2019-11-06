
import fr.rima.tpjsp.mvc.dao.DAOException;
import fr.rima.tpjsp.mvc.dao.DiscountCodeDAO;
import fr.rima.tpjsp.mvc.data.DataSourceFactory;
import java.sql.SQLException;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marie
 */
public class DAOtest {
    private DiscountCodeDAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	

	@Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new DiscountCodeDAO(myDataSource);
	}
        
        /**
	 * Test of AddCode method, of class DiscountCodeDAO.
	 * @throws fr.rima.tpjsp.mvc.dao.DAOException
	 */
	@Test
	public void testAddCode() throws DAOException {
		assertEquals(1, myDAO.addCode("é", 1.4F));
	}
        /**
	 * Test of AddCode method, of class DiscountCodeDAO.
	 * @throws fr.rima.tpjsp.mvc.dao.DAOException
	 */
	@Test (expected = Exception.class)
	public void testAddBadCode() throws DAOException {
		assertEquals(0, myDAO.addCode("é", 1.4F));
	}
        /**
	 * Test of AddCode method, of class DiscountCodeDAO.
	 * @throws fr.rima.tpjsp.mvc.dao.DAOException
	 */
	@Test 
	public void testDeleteCode() throws DAOException {
		assertEquals(1, myDAO.deleteCode("é"));
	}
        
}
