import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SimpleSql
{
  public static void main(String argv[]) throws Exception 
  {
  	java.sql.Connection conn = null;
    	java.sql.Statement stmt = null;
    	ResultSet rs = null;
    	try 
	{
      		// ============== Get a database connection ==================
      		Context ctx = null;
      		
      		// Put connection properties in to a hashtable.
		Hashtable<String,String> ht = new Hashtable<String,String>();
      		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
      		ht.put(Context.PROVIDER_URL, "t3://localhost:8001");

      		// Get a context for the JNDI lookup
      		ctx = new InitialContext(ht);

      		// Look up the data source
      		javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("DS1");

      		//Get a database connection from the data source
     		conn = ds.getConnection();
     		conn.setAutoCommit(true);
      		System.out.println("Making connection...\n");

      		// ============== Execute SQL statements ======================
		stmt = conn.createStatement();
      		try 
		{
        			stmt.execute("SELECT 1 FROM DUAL");
        			System.out.println("DUAL TABLE HAS BEEN ACCESSED");
      		} 
      		catch (SQLException e) 
		{
        			System.out.println("There is some issue with accessing DUAL table");
				e.printStackTrace();
      		}
    	} 
	catch (Exception e) 
	{
      		System.out.println("Exception was thrown: " + e.getMessage());
    	} 
	finally 
	{
	  // ========== Close JDBC objects, including the connection =======	
      		try 
		{
        			if (stmt != null) 
			{
          				stmt.close();
          				stmt = null;
       			}
      		} 
		catch (SQLException e) 
		{
        			throw e;
      		} 
		finally 
		{
        			try
			{
          				if (conn != null) 
				{
            				conn.close();
            				conn = null;
          				}
        			} 
			catch (SQLException e) 
			{
          				throw e;
        			}
      		}
    	 }
  }
}

/*

C:\Users\HP>javac -classpath "%classpath%;E:\SWARUP\Program Files\Java\jdk1.6.0_
20\bin\wlfullclient.jar" "E:\SWARUP\Program Files\Java\jdk1.6.0_20\bin\SimpleSql
.java"

C:\Users\HP>java -classpath "%classpath%;E:\SWARUP\Program Files\Java\jdk1.6.0_2
0\bin\wlfullclient.jar;E:\SWARUP\Program Files\Java\jdk1.6.0_20\bin\jdbc-oracle.
jar" SimpleSql
Making connection...

DUAL TABLE HAS BEEN ACCESSED
*/
