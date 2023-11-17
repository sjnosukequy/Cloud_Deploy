package val.shop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://dpg-ckstajmljlhc73elibn0-a.singapore-postgres.render.com:5432/donhang","admin","fOpcIaD7djih4LWhYLE24d1WvZLKBcHe");
            System.out.print("connected");
        }
        return connection;
    }
}
