package calculator;

import java.sql.*;

class DBConnection implements DataAccess {
	boolean loggedOn = false;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	ResultSetMetaData metadata = null;

	private final String USERNAME = ""; // enter your mysql username
	private final String PASSWORD = ""; // enter your mysql password
	private String DATABASE = null;
	private String TABLE = null;
	
	DBConnection() {}	// construct new object

	DBConnection(String dbname, String table_name) throws SQLException {
		this.DATABASE = dbname;
		this.TABLE = table_name;
	}
	
	DBConnection(String dbname) throws SQLException {
		this.DATABASE = dbname;
	}

	// this method should only be used to connect to the database
	// while the disconnect should be used to disconnect when finished
	// to allow other methods can act on the data.
	protected void connect(String dbname) throws SQLException {
		try {
			String url = "jdbc:mysql://localhost/" + dbname;
			con = DriverManager.getConnection(url, this.USERNAME, this.PASSWORD);
			System.out.println("Connection Established Successfully");
		} catch (Exception e) {
			System.out.println("Could not connect to Database");
		} 
	}
	
	public boolean login(String username, String password) {
		if ((username.equals(this.USERNAME)) && (password.equals(this.PASSWORD))) {
			loggedOn = true;
		}		
		return loggedOn;
	}

	public void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public void getTableNames() throws SQLException {
		int numColumns;
		String tableName;
		metadata = rs.getMetaData();
		numColumns = metadata.getColumnCount();
		for (int i = 0; i < numColumns; i++) {
			tableName = metadata.getTableName(i);
			System.out.println(tableName);
		}
	}

	public void printAll(String tableName) throws SQLException {
		// SQL code statements
		st = con.createStatement();
		String sql = "select * from " + tableName;
		rs = st.executeQuery(sql);
		metadata = rs.getMetaData();

		while (rs.next()) {
			int columnCount = metadata.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// still working on it
	@Override
	public void appendRecord(Object o) {
		System.out.println(o.getClass());
	}
}
