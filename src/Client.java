import java.net.*; 
import java.io.*; 
import java.util.*;
public class Client { 

public static void main(String[] args) throws Exception { 
try { 

	Socket socket = new Socket("localhost",8000); 
	//Socket socket = new Socket("scss.tcd.ie",80);
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); 
	
	System.out.println("Please input the message...");
	Scanner sc= new Scanner(System.in);
	String msg = sc.nextLine();
	
	out.println("GET https://localhost:8000/echo.php?message=" + msg + " HTTP/1.0"); 
	
	//out.println("GET https://www.scss.tcd.ie/~ebarrett/lectures/cs4032/echo.php?message=" + msg + " HTTP/1.0"); 
	out.println(); 
	out.flush(); 
	
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
	
	String inputLine; 
	int count = 0; 
	
	while ((inputLine = in.readLine()) != null) { 
	count++; 
	System.out.println(count); 
	System.out.println(inputLine); 
	} 
	
	in.close(); 
	System.out.println("PRINTING HERE!!!"); 
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	} 
}