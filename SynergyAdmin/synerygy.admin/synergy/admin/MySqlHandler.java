package synergy.admin;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlHandler 
{
	private String server = "";
	private int port = 3306;
	private String username = "";
	private String password = "";
	
	private Connection con = null;
	
	private Boolean isConnected = false;
    
	public MySqlHandler(String server, int port, String user, String pass)
	{
		this.server = server;
		this.port = port;
		this.username = user;
		this.password = pass;
		
		connect();
	}
	
	public ResultSet query(String query) throws SQLException
	{
		if(isConnected)
		{
			Statement s = con.createStatement();
			if(query.contains("SELECT"))
			{
				s.executeQuery(query);
				ResultSet rs = s.getResultSet ();
				return rs;
			}
			else if(query.contains("INSERT"))
			{
				s.execute(query);
				ResultSet rs = s.getResultSet ();
				return rs;
			}
			else if(query.contains("UPDATE"))
			{
				s.executeUpdate(query);
				ResultSet rs = s.getResultSet ();
				return rs;
			}
		}
		return null;
	}
	
	public boolean connect(String server, int port, String username, String password)
	{
		setServer(server);
		setPort(port);
		setUsername(username);
		setPassword(password);
		
		return connect();
	}
	
	public boolean connect()
	{
		try
		{
			String url = "jdbc:mysql://" + server + ":" + String.valueOf(port);
            con = DriverManager.getConnection(url, username, password);
            isConnected = true;
            return true;
        } 
		catch (SQLException ex){
			ex.printStackTrace();
			return false;
        }
	}
	
	public void setServer(String server){
		this.server = server;
	}
	
	public void setPort(int port){
		this.port = port;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getServer(){
		return server;
	}
	
	public int getPort(){
		return port;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
}
