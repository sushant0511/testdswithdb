import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CallDbwithDS {

	public static void main(String[] args) {
		
		List<Facebook> list=new ArrayList<>();
		
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/1122", "root", "root");
		Statement statement=connection.createStatement(); // select 
		ResultSet set=statement.executeQuery("SELECT * FROM facebook");
		while(set.next())
		{
			Facebook facebook=new Facebook();
			facebook.setName(set.getString(2));
			list.add(facebook);
			//System.out.println(set.getInt(1)+"  "+set.getString(2)+"  "+set.getFloat(3));
		}
		
		for(Facebook fb:list)
		{
			System.out.println(fb.getName());
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
