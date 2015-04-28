import java.util.ArrayList;
import java.util.List;


public class RecordSet {
	
	public String resultSet;
	public DataTable table;
	
	public RecordSet(String resultSet, DataTable table){
		this.resultSet = resultSet;
		this.table = table;
	}
	
	public DataTable getTable(){
		return this.table;
	}
	
	@Override
	public String toString(){
		String result = "Record Set: \n";
		result = result + "Table: \n";
		List<DataColumn> columns = getTable().getColumns();
		List<DataRow> rows = getTable().getRows();
		result = result + "\tColumns: \n";
		for (String col : columns.get(0).getColumnEntries()){
			result = result + "\t\tColumn name: " + col + "\n";
		}
		result = result + "\tRows: \n";
		for (String row : rows.get(0).getRowEntries()){
			result = result + "\t\tRow name: " + row + "\n";
		}
		return result;
	}
	
	// represents the table in the database
	public static class DataTable{
		
		private List<DataColumn> columns;
		private List<DataRow> rows;
		private String resultSet;
		
		public DataTable(String resultSet){
			this.resultSet = resultSet;
			populateTable(resultSet);
		}
		
		public List<DataColumn> getColumns(){
			return this.columns;
		}
		
		public List<DataRow> getRows(){
			return this.rows;
		}
		
		public String getName(){
			return this.resultSet;
		}
		
		// mock out populating table data
		public void populateTable(String resultSet){
			this.columns = new ArrayList<DataColumn>();
			this.rows = new ArrayList<DataRow>();
			this.columns.add(new DataColumn("Column 1"));
			this.rows.add(new DataRow("Row 1"));
			this.columns.get(0).getColumnEntries().add("Column Entry 1");
			this.rows.get(0).getRowEntries().add("Row Entry 1");
		}
		
		
		
	}
	
	// represents a row in a database table
	public static class DataRow{
		private List<String> rowEntries;
		private String rowName;
		
		public DataRow(String name){
			this.rowName = name;
			this.rowEntries = new ArrayList<String>();
		}
		
		public List<String> getRowEntries(){
			return this.rowEntries;
			
		}
	}
	
	// represents a column in a database
	public static class DataColumn{
		private String columnName;
		private List<String> columnEntries;
		
		public DataColumn(String name){
			this.columnName = name;
			this.columnEntries = new ArrayList<String>();
		}
		
		public List<String> getColumnEntries(){
			return this.columnEntries;
		}
	}
	
	// mock database connection
	public static void makeDBConnection(){
		System.out.println("Making database connection...");
	}
	
	// mock make query to database
	public static String makeQuery(String query){
		System.out.println("Making query: " + query + " ...");
		return "test result set";
	}
	
	public static void main(String[] args){
		
		makeDBConnection();
		String resultSet = makeQuery("Select * from users");
		DataTable table = new DataTable(resultSet);
		RecordSet recordSet = new RecordSet(resultSet, table);
		System.out.println(recordSet);
		
		
		
	}

}
