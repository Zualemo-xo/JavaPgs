import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class JAVA_DA3 extends Application{
	
	@Override
	public void start(Stage primaryStage)
	{
		Label l1=new Label("Name");
		Label l2=new Label("Date");
		Label l3=new Label("Vaccinated or not");
		Label l4=new Label("Phone number");
		Label l5=new Label("Place");

        TextField tf1=new TextField();  
        TextField tf2=new TextField(); 
        TextField tf3=new TextField(); 
        TextField tf4=new TextField(); 
        TextField tf5=new TextField(); 

        
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        btn1.setText("Create");
        btn2.setText("Registration");
        btn3.setText("Update");
        btn4.setText("Report");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.addRow(0,l1,tf1);
        grid.addRow(1,l2,tf2);
        grid.addRow(2,l3,tf3);
        grid.addRow(3,l4,tf4);
        grid.addRow(4,l5,tf5);

        grid.add(btn1,0,6);
        grid.add(btn2,1,6);
        grid.add(btn3,2,6);
        grid.add(btn4,3,6);

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle(" COWIN APPLICATION");
        primaryStage.setScene(scene);
        primaryStage.show();
        

        //Create Table
        btn1.setOnAction(new EventHandler<ActionEvent>() 
        {  
            @Override
             public void handle(ActionEvent event) {
		          Connection conn = null;
		    Statement stmt = null;
		    try{
		       Class.forName("com.mysql.jdbc.Driver");
		       System.out.println("Connecting to a selected database...");
		       conn = DriverManager.getConnection("jdbc:mysql://localhost/STUDENTS", "root", "root");
		       System.out.println("Connected database successfully...");
		       
		       System.out.println("Creating table in given database...");
		       stmt = conn.createStatement();
		       
		       
		       String sql = "CREATE TABLE cowin(name VARCHAR(50),date VARCHAR(50),vaccinated VARCHAR(50),phno INTEGER,place VARCHAR(50))"; 
		       stmt.executeUpdate(sql);
		       System.out.println("succeefully created");
		
		
		
		         }    
		    catch(SQLException se){
		       //Handle errors for JDBC
		       se.printStackTrace();
		    }  catch(Exception e){
		       //Handle errors for Class.forName
		       e.printStackTrace();
		    } finally{
		       //finally block used to close resources
		       try{
		          if(stmt!=null)
		             conn.close();
		       }  catch(SQLException se){
		       } // do nothing
		       try {
		          if(conn!=null)
		             conn.close();
		       }  catch(SQLException se){
		          se.printStackTrace();
		       } //end finally try
		    } //end try
		             }   
		 });
        
        //Insert records
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    
                    Connection conn = null;
                    Statement stmt = null;
                    
                    
                    try {
                        //STEP 2: Register JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(qq.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                      
                    
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/STUDENTS", "root", "root");
                    System.out.println("Connected database successfully...");
                    
                    //STEP 4: Execute a query
                    stmt = conn.createStatement();
                    System.out.println(tf1.getText()+tf2.getText()+tf3.getText()+tf4.getText()+tf5.getText());
                    String sql = "INSERT INTO COWIN VALUES ( '"+tf1.getText()+"' , '"+tf2.getText()+"' , '"+tf3.getText()+"',"+Integer.parseInt(tf4.getText()) +" , '"+tf5.getText()+"')";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(qq.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
      
        //update
        btn3.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                	
                    //newWindow.close();
                    try {
                        
                        Connection conn = null;
                        Statement stmt = null;
                        
                        
                        try {
                            //STEP 2: Register JDBC driver
                            Class.forName("com.mysql.jdbc.Driver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(qq.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                          
                        
                        System.out.println("Connecting to a selected database...");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/STUDENTS", "root", "root");
                        System.out.println("Connected database successfully...");
                        String name="'"+tf1.getText()+"'";
                        String vac="'"+tf3.getText()+"'";
                        String dat="'"+tf2.getText()+"'";
                        //STEP 4: Execute a query
                        stmt = conn.createStatement();
                        //System.out.println(tf1.getText()+tf2.getText()+tf3.getText()+tf4.getText()+tf5.getText());
                        //String sql = "INSERT INTO phone VALUES ( '"+tf1.getText()+"' , '"+tf2.getText()+"' , "+ "STR_TO_DATE('"+tf3.getText()+"', '%d/%m/%Y') ,"+Integer.parseInt(tf4.getText()) +" ,  "+ "STR_TO_DATE('"+tf5.getText()+"', '%d/%m/%Y'))";
                        String sql="update COWIN set vaccinated= "+vac+",date="+dat+" where name ="+name;
                        System.out.println(sql);
                        stmt.executeUpdate(sql);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(qq.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                
            }
            });

        //display all records BASED on vacc on not
        btn4.setOnAction(new EventHandler<ActionEvent>() {  
            @Override
             public void handle(ActionEvent event) {
          Connection conn = null;
			    Statement stmt = null;
			    //VAC
			    try{
			       //STEP 2: Register JDBC driver
			       Class.forName("com.mysql.jdbc.Driver");
			       System.out.println("Connecting to a selected database...");
			       conn = DriverManager.getConnection("jdbc:mysql://localhost/STUDENTS", "root", "root");
			       System.out.println("Connected database successfully...");
			       stmt = conn.createStatement();
                   String dat="'"+tf2.getText()+"'";

			 String sql1 = "SELECT * FROM COWIN where vaccinated='yes' and date= "+dat; 
			       ResultSet rs = stmt.executeQuery(sql1);
			       //STEP 5: Extract data from result set
			       System.out.println("VACCINATED:...");

			       while(rs.next()){
			          //Retrieve by column name
			          
			          
			          String phno = rs.getString("phno");
			          String name = rs.getString("name");
			          String date = rs.getString("date");
			          String vaccinated  = rs.getString("vaccinated");
			          String place = rs.getString("place");
			          //Display values
			          System.out.print("\n Name: " + name);

			          System.out.print(", Date: " + date);
			          System.out.print(", Vaccinated: " + vaccinated);

			          System.out.print(",Phone no: " + phno);

			          System.out.print(", Place: " + place);

			       }
			          System.out.println();
			          System.out.println();



			
			         }    catch(SQLException se){
			       //Handle errors for JDBC
			       se.printStackTrace();
			    }  catch(Exception e){
			       //Handle errors for Class.forName
			       e.printStackTrace();
			    } finally{
			       //finally block used to close resources
			       try{
			          if(stmt!=null)
			             conn.close();
			       }  catch(SQLException se){
			       } // do nothing
			       try {
			          if(conn!=null)
			             conn.close();
			       }  catch(SQLException se){
			          se.printStackTrace();
			       } //end finally try
			    } //end try
			    
			    
			    
			    
			    //NOT VAC
			    try{
				       //STEP 2: Register JDBC driver
				       Class.forName("com.mysql.jdbc.Driver");
				       conn = DriverManager.getConnection("jdbc:mysql://localhost/STUDENTS", "root", "root");
				       stmt = conn.createStatement();
	                   String dat="'"+tf2.getText()+"'";

						 String sql2 = "SELECT * FROM COWIN where vaccinated='no' and date= "+dat; 
					       ResultSet rs = stmt.executeQuery(sql2);
					       //STEP 5: Extract data from result set
					       System.out.println("NOT VACCINATED:...");

					       while(rs.next()){
					          //Retrieve by column name
					          
					          
						          String phno = rs.getString("phno");
						          String name = rs.getString("name");
						          String date = rs.getString("date");
						          String vaccinated  = rs.getString("vaccinated");
						          String place = rs.getString("place");
						          //Display values
						          System.out.print("\n Name: " + name);

						          System.out.print(", Date: " + date);
						          System.out.print(", Vaccinated: " + vaccinated);

						          System.out.print(",Phone no: " + phno);

						          System.out.print(", Place: " + place);

					       }
					          System.out.println();

				       
				          System.out.println();

				
				         }    catch(SQLException se){
				       //Handle errors for JDBC
				       se.printStackTrace();
				    }  catch(Exception e){
				       //Handle errors for Class.forName
				       e.printStackTrace();
				    } finally{
				       //finally block used to close resources
				       try{
				          if(stmt!=null)
				             conn.close();
				       }  catch(SQLException se){
				       } // do nothing
				       try {
				          if(conn!=null)
				             conn.close();
				       }  catch(SQLException se){
				          se.printStackTrace();
				       } //end finally try
				    } //end try
			    
			    
             }   
    }); 
        
        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      launch(args);     

	}

}
