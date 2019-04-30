package es.upm.dit.isst.persistence.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CargarCsv {

	public static void main(String[] args) throws Exception {
		 
        Connection conn = null;
        Statement stmt = null;
 
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/ISST2019", "sa", "sa");
        stmt = conn.createStatement();
 
        stmt.execute("drop table if exists csvdata");
        stmt.execute("create table csvdata (id int primary key, name varchar(100), age int)");
        stmt.execute("insert into csvdata ( id, name, age )     select convert( \"id\",int ), \"name\", convert( \"age\", int)   from CSVREAD( '/home/isst/sample.csv', 'id,name,age', null ) ");
        ResultSet rs = stmt.executeQuery("select * from csvdata");
 
        while (rs.next()) {
            System.out.println("id " + rs.getInt("id") + " name " + rs.getString("name") + " age " + rs.getInt("age") );
        }
        stmt.close();
    }
}
