package servlets;

import java.sql.Timestamp;
import java.util.Date;
 
public class Search 
{
    public static void main( String[] args )
    {
	 java.util.Date date= new java.util.Date();
	 System.out.println(new Timestamp(date.getTime()));
    }
}
