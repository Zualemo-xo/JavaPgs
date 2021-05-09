import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;
class student
{
	String rno;
	int qno[];
	int marks[];
	int total;
}

public class exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    HashMap<Integer, String> questions = new HashMap<Integer, String>();
	    //predefined questions
	    questions.put(1, "Q1)Java program  using thread to print hello world");
	    questions.put(2, "Q2)Java program  using exception to divide by 0");
	    questions.put(3, "Q3)Java program  using ArrayList to add 3 numbers");
	    questions.put(4, "Q4)Java program  using thread to randomly generate");
	    questions.put(5, "Q5)Java program  using exception to handle generic exception");
	    questions.put(6, "Q6)Java program  using ArrayList for multiplication");
	    questions.put(7, "Q7)Java program  using thread for area calc");
	    questions.put(8, "Q8)Java program  using exception to handle null pointer ");
	    questions.put(9, "Q9)Java program  using ArrayList to divide");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter total number of students:");
		int n=s.nextInt();
	    student st[]=new student[n];
		for(int i=0;i<n;i++)
		{
			st[i]=new student();
			st[i].marks=new int[3];
			System.out.println("Enter register number:");
			String rrno=s.next();
			st[i].rno=rrno;
			int arr[]=new int[3];
			int cnt=0;
			//random 3 questions for each student
			while(i<n)//dunder
			{
		        Random rand = new Random();
		        int qn = rand.nextInt(9);
		        qn+=1;
		        int brk=0;
		        for(int j=0;j<cnt;j++)
		        {
		        	if(qn==arr[j])
		        	{
		        		brk++;
		        	}
		        }
		        if(brk==0)
		        {
		        	arr[cnt++]=qn;
		        	if(cnt==3)
		        		break;
		        	
		        }
			}
			
			st[i].qno=arr;
		}
		System.out.println(questions);
		//Creating answer scripts by each student
		for(int i=0;i<n;i++)
		{
			String fname="E:\\Eclipse\\Data\\JAVA_DA2\\src\\AnswerScript"+st[i].rno+".txt";//unique filename for each student
			System.out.println("Enter answer(Press q to quit that particular answer):");

			 try {
			PrintWriter pw = new PrintWriter(new FileWriter(fname, true)); 
			int cnt=0;
			for(int j=0;j<3;j++)//for each qsn 
			{
				pw.println(st[i].qno[j]);
				System.out.println(	"Enter answer for:"+st[i].qno[j]);
				while(cnt<5)
				{
				String tmp=s.nextLine();
				if(tmp.equals("q"))
				{
					break;
				}
				pw.println(tmp);
				}
			}
			pw.close();
			}
			catch (FileNotFoundException fe) 
	        {              System.out.println("File not found");          } 
			catch (IOException fe) 
		        {              System.out.println("File not found");          }

		 }
		
		
		//Checking answers
		for(int i=0;i<n;i++)
		{
			String fname="E:\\Eclipse\\Data\\JAVA_DA2\\src\\AnswerScript"+st[i].rno+".txt";//open unique filename for each student
			BufferedReader f=null;
			try 
			{
				 f = new BufferedReader(new FileReader(fname));

			}
			catch (FileNotFoundException fe) 
	        {              System.out.println("File not found");          } 
			String line;
			String words[]=new String[50];
 			int cnt_exp=0,cnt_th=0,cnt_al=0,cnt_main=0;
   			int ct=0;

	        try 
	        {
	        	  while((line = f.readLine()) != null)
	        	  {
	        	   //System.out.println(line);
	        		  //line=f.readLine();//get out from qsn line 
	        		  words=line.split(" ");
	        	   //System.out.println(words);

	        	   for (String w : words)
	        	   {
	               	   //System.out.println(" catched:"+w);
	        		   if(Pattern.matches("[1-9]", w))//qn no line
	        		   {
	        			   if(ct==0)
	        			   {
	        				   ct++;
	        			   }
	        			   else if (ct==1)//Chk after 1st qsn ends
	        			   {
	        				   //Inside check what the question wants
	        				   String qq=questions.get(st[i].qno[0]);//get the contents of the question 1 from the hashmap
	    	        		   if(Pattern.matches("(.*)thread(.*)", qq))
	    	        		   {
	    	        			   if(cnt_th>0)
	    	        			   {
	    	        				   st[i].marks[0]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[0]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[0]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	    	        		   if(Pattern.matches("(.*)exception(.*)", qq))
	    	        		   {
	    	        			   if(cnt_exp>0)
	    	        			   {
	    	        				   st[i].marks[0]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[0]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[0]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	    	        		   if(Pattern.matches("(.*)ArrayList(.*)", qq))
	    	        		   {
	    	        			   if(cnt_al>0)
	    	        			   {
	    	        				   st[i].marks[0]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[0]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[0]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	        				   ct++;
	        			   }
	        			   
	        			   
	        			   
	        			   
	        			   else//Chk after 2nd qsn ends
	        			   {
	        				   //Inside check what the question wants
	        				   String qq=questions.get(st[i].qno[1]);//get the contents of the question 2 from the hashmap
	    	        		   if(Pattern.matches("(.*)thread(.*)", qq))
	    	        		   {
	    	        			   if(cnt_th>0)
	    	        			   {
	    	        				   st[i].marks[1]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[1]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[1]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	    	        		   if(Pattern.matches("(.*)exception(.*)", qq))
	    	        		   {
	    	        			   if(cnt_exp>0)
	    	        			   {
	    	        				   st[i].marks[1]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[1]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[1]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	    	        		   if(Pattern.matches("(.*)ArrayList(.*)", qq))
	    	        		   {
	    	        			   if(cnt_al>0)
	    	        			   {
	    	        				   st[i].marks[1]=10;
	    	        			   }
	    	        			   else if(cnt_main>0)
	    	        			   {
	    	        				   st[i].marks[1]=5;
	    	        			   }
	    	        			   else 
	    	        			   {
	    	        				   st[i].marks[1]=0;
	    	        			   }
	    	        			   //reset values to check for next question
	    	   	       				cnt_exp=0;
	    	   	       				cnt_th=0;
	    	   	       				cnt_al=0;
	    	   	       				cnt_main=0;
	    	        		   }
	        				   ct++;
	        			   }
	        		   }
	        		   //Checking inside answer
	        		   if(Pattern.matches("(.*)thread(.*)", w))
	        		   {
	        			   cnt_th++;
	        		   }
	        		   if(Pattern.matches("(.*)exception(.*)", w))
	        		   {
	        			   cnt_exp++;
	        		   }
	        		   if(Pattern.matches("(.*)ArrayList(.*)", w))
	        		   {
	        			   cnt_al++;
	        		   }
	        		   if(Pattern.matches("(.*)public static void main(.*)", line))
	        		   {
	        			   cnt_main++;
	        		   }
	        	   }
	        	  }
	           System.out.println();
	           //Check for question 3,ater the EOF reached
			   String qq=questions.get(st[i].qno[2]);//get the contents of the question 3 from the hashmap
    		   if(Pattern.matches("(.*)thread(.*)", qq))
    		   {
    			   if(cnt_th>0)
    			   {
    				   st[i].marks[2]=10;
    			   }
    			   else if(cnt_main>0)
    			   {
    				   st[i].marks[2]=5;
    			   }
    			   else 
    			   {
    				   st[i].marks[2]=0;
    			   }

    		   }
    		   if(Pattern.matches("(.*)exception(.*)", qq))
    		   {
    			   if(cnt_exp>0)
    			   {
    				   st[i].marks[2]=10;
    			   }
    			   else if(cnt_main>0)
    			   {
    				   st[i].marks[2]=5;
    			   }
    			   else 
    			   {
    				   st[i].marks[2]=0;
    			   }

    		   }
    		   if(Pattern.matches("(.*)ArrayList(.*)", qq))
    		   {
    			   if(cnt_al>0)
    			   {
    				   st[i].marks[2]=10;
    			   }
    			   else if(cnt_main>0)
    			   {
    				   st[i].marks[2]=5;
    			   }
    			   else 
    			   {
    				   st[i].marks[2]=0;
    			   }

    		   }

    		   st[i].total=st[i].marks[0]+st[i].marks[1]+st[i].marks[2];
	        }
	        catch(IOException in)
	        {
	        	System.out.println("IO Exception"); 
	        }
		}
		
		
		
		//Displaying mark list and class average
		int avg=0;
		for(int i=0;i<n;i++)
		{
        	System.out.println("Student rollno:"+st[i].rno); 

        	System.out.println("Mark in Q1:"+st[i].marks[0]); 
        	System.out.println("Mark in Q2:"+st[i].marks[1]); 
        	System.out.println("Mark in Q3:"+st[i].marks[2]); 
        	System.out.println("Total:"+st[i].total); 
        	avg+=st[i].total;
		}
    	System.out.println("Class average:"+(avg/n)); 

		
	}

}
