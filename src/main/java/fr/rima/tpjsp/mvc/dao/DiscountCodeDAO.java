package fr.rima.tpjsp.mvc.dao;


import fr.rima.tpjsp.mvc.model.DiscountCodeEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
/**
 *
 * @author marie
 */
public class DiscountCodeDAO {
    protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DiscountCodeDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 *
	 * @return le nombre d'enregistrements dans la table CUSTOMER
	 * @throws DAOException
	 */
	public List<DiscountCodeEntity> showAllCode() throws DAOException {
            List rep = new ArrayList();
            String sql = "SELECT DISCOUNT_CODE, RATE FROM DISCOUNT_CODE";

            try (   Connection connection = myDataSource.getConnection(); 
                    Statement stmt = connection.createStatement(); 
                    ResultSet rs = stmt.executeQuery(sql) 
            ) {
                    while (rs.next()) { 
                        DiscountCodeEntity dc = new DiscountCodeEntity(rs.getString("DISCOUNT_CODE"), rs.getFloat("RATE"));
                        rep.add(dc);
                    }
            } catch (SQLException ex) {
                    Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }

            return rep;
        }
        
        public int addCode(String key, Float taux) throws DAOException{
            
            String sql = "INSERT INTO DISCOUNT_CODE (DISCOUNT_CODE, RATE ) VALUES (?,?)  ";
            
            try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                stmt.setString(1,key);
                stmt.setFloat(2, taux);
			
		return stmt.executeUpdate();

            }  
            catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }
            
        }
}
