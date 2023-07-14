import java.util.*;

class GDSE_Marks {
    public static String[][]studentDetails= {{"",""}};
    public static int[][]studentMarks= new int[studentDetails.length][2];
    public static void addNewStudent(){
            Scanner Input=new Scanner(System.in);
            String[][] temp = new String[studentDetails.length+1][2];
            int [][] tempMarks=new int[temp.length][2];
            for(int i=0; i<studentDetails.length; i++){
                temp[i][0] =studentDetails[0][0]!=""?studentDetails[i][0]:"";
                temp[i][1] =studentDetails[0][1]!=""?studentDetails[i][1]:"";
                tempMarks[i][0]=studentMarks[i][0];
                tempMarks[i][1]=studentMarks[i][1];
            }
            boolean answer =true;//for check ID number
            while(answer){
                System.out.print("\nEnter Student ID   :");
                String id=Input.nextLine();
                for (int j=0; j<studentDetails.length;j++){
                    if (studentDetails[j][0].equals(id)){
                        answer=true;
                        System.out.println("The Student ID already exists");
                        break;
                    }
                    else{
                        answer=false;
                    }//id verification
                }
                if (studentDetails[0][0]==""){
                    studentDetails[0][0]=id;//start id initialize
                }
                else{
                    temp[studentDetails.length][0]=id;//After first input string initialize to temp array
                }
            
            }
            System.out.print("Enter Student Name :");
            String name =Input.nextLine();
            if (studentDetails[0][1]==""){
                studentDetails[0][1]=name;//first input name initialize
                System.out.println(studentDetails[0][1]);
            }
            else{
                temp[studentDetails.length][1]=name;//After first input string initialize to temp array
                tempMarks[studentDetails.length][0]=tempMarks[studentDetails.length][0]=0;
                studentDetails=temp;//student details array get new details
                studentMarks=tempMarks;
            }
        }
        

    public static void addNewStudentWithMarks(){
        addNewStudent();
        Scanner Input=new Scanner(System.in);
        int[][] tempMarks = new int[studentDetails.length][2];
        for(int i=0; i<studentMarks.length; i++){
            tempMarks[i][0] =studentMarks[i][0];
            tempMarks[i][1] =studentMarks[i][1];
        }
        boolean answer =true;
        while(answer){
            System.out.print("\nProgramming Fundamentals Marks  :");
            int pfMarks=Input.nextInt();
            if (pfMarks<0 || pfMarks>100){
                answer=true;
                System.out.println("Invalid marks, please enter correct marks");
                }//check mark in 0-100 range
            else{
                answer=false;
            }//answer false marks in range of 0-100 and stop while loop
            tempMarks[studentMarks.length-1][0]=pfMarks;
        }
        answer=true;
        while(answer){
            System.out.print("\nDatabase Management System Marks  :");
            int dmsMarks=Input.nextInt();
            if (dmsMarks<=0 || dmsMarks>=100){
                answer=true;
                System.out.println("Invalid marks, please enter correct marks");
                }//check mark in 0-100 range
            else{
                answer=false;
            }//answer false marks in range of 0-100 and stop while loop
            tempMarks[studentMarks.length-1][1]=dmsMarks;
        }
        studentMarks=tempMarks;

    }
    public static void addMarks(){
        char command1='y';
        while (command1=='y'||command1=='Y'){
            Scanner Input=new Scanner(System.in);
            System.out.print("Enter Student ID : ");
            String id=Input.nextLine();
            boolean answer1=false;
            int i=0;
            int index=0;
            for (int j=0; j<studentDetails.length;j++){
                if (searchStudent(j,id)){
                    System.out.println("Student Name \t: "+studentDetails[j][1]);
                    if (studentMarks[j][0]>0 && studentMarks[j][1]>0){
                        System.out.println("This student's Mark have been already added.\nIf you want to update the marks, please use [4] Update Marks Option");
                        answer1=false;
                    }
                    else{
                        answer1=true;
                        index=j;
                    }//check values of mark added to the array
                    command1='n';
                    break;   
                }
                else{
                    i++;
                    if(i==studentDetails.length){
                        System.out.print("Invalid Student ID. Do you want to search again ? (Y/n) "); 
                        command1=Input.next().charAt(0);
                        while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                            System.out.print("Wrong Input letter. Invalid Student ID. Do you want to search again ? (Y/n) ");
                            command1=Input.next().charAt(0);
                        }
                        answer1=false;
                    }
                
                }     
            } 
            if(answer1){
                boolean answer =true;//check sub valu in range
                while(answer){
                    System.out.print("\nProgramming Fundamentals Marks  :");
                    int pfMarks=Input.nextInt();
                    if (pfMarks<0 || pfMarks>100){
                        answer=true;
                        System.out.println("Invalid marks, please enter correct marks");
                        }//check mark in 0-100 range
                    else{
                        answer=false;
                    }//answer false marks in range of 0-100 and stop while loop
                    studentMarks[index][0]=pfMarks;
                }
                answer=true;//check sub valu in range
                while(answer){
                    System.out.print("\nDatabase Management System Marks  :");
                    int dmsMarks=Input.nextInt();
                    if (dmsMarks<=0 || dmsMarks>=100){
                        answer=true;
                        System.out.println("Invalid marks, please enter correct marks");
                        }//check mark in 0-100 range
                    else{
                        answer=false;
                    }//answer false marks in range of 0-100 and stop while loop
                    studentMarks[index][1]=dmsMarks;
                }
                System.out.print("Marks have been added.");//confirmed new mark adding
                command1='n';//After add the mark loop is stopped
            }
        }
     
    }
    public static void updateStudentDetails(){
        char command1='y';
        while (command1=='y'||command1=='Y'){
            Scanner Input=new Scanner(System.in);
            System.out.print("Enter Student ID : ");
            String id=Input.nextLine();
            int i=0;
            for (int j=0; j<studentDetails.length;j++){
                if (searchStudent(j,id)){
                    System.out.println("Student Name \t: "+studentDetails[j][1]);
                    System.out.print("Enter the new student name: ");
                    String newName = Input.nextLine();//get new name from scanner input as a string
                    studentDetails[j][1]=newName;//new name initialize
                    command1='n';
                    System.out.println("Student Details has been updated successfully.");
                }//check student id and catch index
                else{
                    i++;
                    if(i==studentDetails.length){
                        System.out.println("Invalid Student ID. Do you want to search again ? (Y/n) "); 
                        command1=Input.next().charAt(0);
                        while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                            System.out.print("Wrong Input letter. Invalid Student ID. Do you want to search again ? (Y/n) ");
                            command1=Input.next().charAt(0);
                        }
                    }
                }//Invalid index and program re looping
            }
        }               
    }
    public static void updateMarks(){
        char command1='y';
        while (command1=='y'||command1=='Y'){
            Scanner Input=new Scanner(System.in);
            System.out.print("Enter Student ID : ");
            String id=Input.nextLine();
            int i=0;
            for (int j=0; j<studentDetails.length;j++){
                if (searchStudent(j,id)){
                    System.out.println("Student Name \t: "+studentDetails[j][1]);
                    System.out.println("\nProgramming Fundamentals Marks \t: "+studentMarks[j][0]);
                    System.out.println("Database Management System Marks : "+studentMarks[j][1]);
                    System.out.print("Enter new Programming Fundamentals Marks\t: ");
                    int newPFMarks = Input.nextInt();//user can input only int value
                    System.out.print("Enter new Database Management System Marks : ");
                    int newDMSMarks = Input.nextInt();//user can input only int value
                    studentMarks[j][0]=newPFMarks;//reInitialize the marks of Programming Fundamentals
                    studentMarks[j][1]=newDMSMarks;//reInitialize the marks of Database Management System
                    command1='n';
                    System.out.println("Marks have been updated successfully.");
                }//check student id and catch index
                else{
                    i++;
                    if(i==studentDetails.length){
                        System.out.println("Invalid Student ID. Do you want to search again ? (Y/n) "); 
                        command1=Input.next().charAt(0);
                        while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                            System.out.print("Wrong Input letter. Invalid Student ID. Do you want to search again ? (Y/n) ");
                            command1=Input.next().charAt(0);
                        }
                    }
                }//Invalid index and program re looping
            }
        }               
    }
    public static void deleteStudent(){
        char command1='y';
        while (command1=='y'||command1=='Y'){
            Scanner Input=new Scanner(System.in);
            System.out.print("Enter Student ID : ");
            String id=Input.nextLine();
            String[][] textStudentDetails=new String[studentDetails.length-1][2];
            int[][] textStudentMarks=new int[studentMarks.length-1][2];
            int i=0;
            for (int j=0; j<studentDetails.length;j++){
                if (searchStudent(j,id)){
                    for (int k=0;k<j;k++){
                        textStudentDetails[k][0]=studentDetails[k][0];
                        textStudentDetails[k][1]=studentDetails[k][1];
                        textStudentMarks[k][0]=studentMarks[k][0];
                        textStudentMarks[k][1]=studentMarks[k][1];
                    }//add data newly create array till delete student index.
                    for (int k=0;k<studentDetails.length-j-1;k++){
                        textStudentDetails[j+k][0]=studentDetails[j+k+1][0];
                        textStudentDetails[j+k][1]=studentDetails[j+k+1][1];
                        textStudentMarks[j+k][0]=studentMarks[j+k+1][0];
                        textStudentMarks[j+k][1]=studentMarks[j+k+1][1];
                    }//addd data newly create array after delete student index.
                    command1='n';
                    studentDetails=textStudentDetails;
                    studentMarks=textStudentMarks;
                    System.out.println("Student has been deleted successfully.");
                }//check student id and catch index
                else{
                    i++;
                    if(i==studentDetails.length){
                        System.out.println("Invalid Student ID. Do you want to search again ? (Y/n) "); 
                        command1=Input.next().charAt(0);
                        while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                            System.out.print("Wrong Input letter. Invalid Student ID. Do you want to search again ? (Y/n) ");
                            command1=Input.next().charAt(0);
                        }
                    }
                }//Invalid index and program re looping
            }
        }              
    }
    public static void printStudentDetails(){
        char command1='y';
        while (command1=='y'||command1=='Y'){
            Scanner Input=new Scanner(System.in);
            System.out.print("Enter Student ID : ");
            String id=Input.nextLine();
            int[]totalMarks=new int[studentMarks.length];
            int i=0;
            int rank[]=new int[totalMarks.length];
            for (int j=0; j<totalMarks.length;j++){
                totalMarks[j]=studentMarks[j][1]+studentMarks[j][0];
            }//sum of marks 
            for (int j=0; j<totalMarks.length;j++){
                int rankNumber=1;
                for(int k=0; k<j;k++){
                    if(totalMarks[j]<totalMarks[k]){
                        rankNumber++;
                    }
                }
                for(int k=j+1; k<totalMarks.length;k++){
                    if(totalMarks[j]<totalMarks[k]){
                        rankNumber++;
                    }
                }
                rank[j]=rankNumber;//rank number get and add array

                if (searchStudent(j,id)){
                    System.out.println("Student Name \t: "+studentDetails[j][1]);
                    if (studentMarks[j][0]>0 && studentMarks[j][1]>0){
                        System.out.println("+---------------------------------------+-----------------+");
                        System.out.println("| Programming Fundamentals Marks\t|\t\t"+studentMarks[j][0]+"|");
                        System.out.println("| Database Management System Marks\t|\t\t"+studentMarks[j][1]+"|");
                        System.out.println("| Total Marks\t\t                |\t        "+totalMarks[j]+"|");
                        System.out.println("| Avg Marks\t\t                |\t      "+((double)totalMarks[j]/2.00)+"|");
                        System.out.println("| Rank\t\t\t                |\t\t"+rank[j]+"|");  
                        System.out.println("+---------------------------------------+-----------------+");
                        command1='n';
                    }//output of student id for including marks value
                    else{
                        System.out.println("Marks yet to be added.");
                        command1='n';
                    }//output of student id for without marks value
                }
                else{
                    i++;
                    if(i==studentDetails.length){
                        System.out.println("Invalid Student ID. Do you want to search again ? (Y/n) "); 
                        command1=Input.next().charAt(0);
                        while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                            System.out.print("Wrong Input letter. Invalid Student ID. Do you want to search again ? (Y/n) ");
                            command1=Input.next().charAt(0);
                        }
                    }
                }//Invalid index and program re looping
            }
        }
    }
    public static void printStudentRanks(){
        int nuMOfRanks=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                nuMOfRanks++;
            }
        }//calculate how many students with marks
        String[][] newStudentDetails=new String[nuMOfRanks][2];
        int[][] newMarks=new int[nuMOfRanks][2];
        int newIndex=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                newStudentDetails[newIndex][0]=studentDetails[a][0];
                newStudentDetails[newIndex][1]=studentDetails[a][1];
                newMarks[newIndex][0]=studentMarks[a][0];
                newMarks[newIndex][1]=studentMarks[a][1];
                newIndex++;
            }
        }//create new arrays for which are with marks

        int[]totalMarks=new int[newMarks.length];
        int rank[]=new int[newMarks.length];
        for (int j=0; j<newMarks.length;j++){
            totalMarks[j]=newMarks[j][1]+newMarks[j][0];
        }//sum of marks 
        for (int j=0; j<totalMarks.length;j++){
            int rankNumber=1;
            for(int k=0; k<j;k++){
                if(totalMarks[j]<totalMarks[k]){
                    rankNumber++;
                }
            }
            for(int k=j+1; k<totalMarks.length;k++){
                if(totalMarks[j]<totalMarks[k]){
                    rankNumber++;
                }
            }
            rank[j]=rankNumber;//rank number get and add array
        }
        int j=0;
        String[][] tempStudentDetails= new String[newStudentDetails.length][2];
        int[] tempTotal=new int[newStudentDetails.length];
        for(int i:rank){
            tempTotal[i-1]=totalMarks[j];
            tempStudentDetails[i-1][0]=newStudentDetails[j][0];
            tempStudentDetails[i-1][1]=newStudentDetails[j][1];
            j++;
        }//re arrange data rank order
        System.out.println("+-------+------+------------------+-----------+---------+");
        System.out.println("| Rank |  ID  |       Name       |  Total Marks  |Avg. Marks|");
        System.out.println("+-------+------+------------------+-----------+---------+");
        for (int k =0;k<newStudentDetails.length;k++){
            System.out.println("|\t"+(k+1)+"| "+tempStudentDetails[k][0]+" |"+tempStudentDetails[k][1]+"\t\t|\t"+tempTotal[k]+"|\t"+((double)tempTotal[k]/2.00)+"|");
        }//output of student rank 
        System.out.println("+-------+------+------------------+-----------+---------+");
    }
    public static void bestiInProgrammingFundamental(){
        int nuMOfRanks=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                nuMOfRanks++;
            }
        }//calculate how many students with marks
        String[][] newStudentDetails=new String[nuMOfRanks][2];
        int[] newPFMarks=new int[nuMOfRanks];
        int[] newDBMSMarks=new int[nuMOfRanks];
        int newIndex=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                newStudentDetails[newIndex][0]=studentDetails[a][0];
                newStudentDetails[newIndex][1]=studentDetails[a][1];
                newPFMarks[newIndex]=studentMarks[a][0];
                newDBMSMarks[newIndex]=studentMarks[a][1];
                newIndex++;
            }
        }//create new arrays for which are with marks
        int rank[]=new int[newPFMarks.length]; 
        for (int j=0; j<newPFMarks.length;j++){
            int rankNumber=1;
            for(int k=0; k<j;k++){
                if(newPFMarks[j]<newPFMarks[k]){
                    rankNumber++;
                }
            }
            for(int k=j+1; k<newPFMarks.length;k++){
                if(newPFMarks[j]<newPFMarks[k]){
                    rankNumber++;
                }
            }
            rank[j]=rankNumber;//rank number get and add array
        }
        int j=0;
        String[][] tempStudentDetails= new String[newStudentDetails.length][2];
        int[] tempPFMarks=new int[newStudentDetails.length];
        int[] tempDBMSMarks=new int[newStudentDetails.length];
        for(int i:rank){
            tempPFMarks[i-1]=newPFMarks[j];
            tempDBMSMarks[i-1]=newDBMSMarks[j];
            tempStudentDetails[i-1][0]=newStudentDetails[j][0];
            tempStudentDetails[i-1][1]=newStudentDetails[j][1];
            j++;
        }//re arrange data rank order
        System.out.println("+-------+------------------+-----------+------------+");
        System.out.println("|   ID  |       Name       |  PF Marks  |DBMS. Marks|");
        System.out.println("+-------+------------------+-----------+------------+");
        for (int k =0;k<newStudentDetails.length;k++){
            System.out.println("| "+tempStudentDetails[k][0]+" |"+tempStudentDetails[k][1]+"\t\t|\t"+tempPFMarks[k]+"\t\t|\t"+tempDBMSMarks[k]+"|");
        }//output of student rank 
        System.out.println("+-------+------------------+-----------+------------+");
    }
    public static void bestInDatabaseManagemnetSystem(){
        int nuMOfRanks=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                nuMOfRanks++;
            }
        }//calculate how many students with marks
        String[][] newStudentDetails=new String[nuMOfRanks][2];
        int[] newPFMarks=new int[nuMOfRanks];
        int[] newDBMSMarks=new int[nuMOfRanks];
        int newIndex=0;
        for (int a=0;a<studentDetails.length;a++){
            if (studentMarks[a][0]>0 && studentMarks[a][1]>0){
                newStudentDetails[newIndex][0]=studentDetails[a][0];
                newStudentDetails[newIndex][1]=studentDetails[a][1];
                newPFMarks[newIndex]=studentMarks[a][0];
                newDBMSMarks[newIndex]=studentMarks[a][1];
                newIndex++;
            }
        }//create new arrays for which are with marks
        int rank[]=new int[newDBMSMarks.length]; 
        for (int j=0; j<newDBMSMarks.length;j++){
            int rankNumber=1;
            for(int k=0; k<j;k++){
                if(newDBMSMarks[j]<newDBMSMarks[k]){
                    rankNumber++;
                }
            }
            for(int k=j+1; k<newDBMSMarks.length;k++){
                if(newDBMSMarks[j]<newDBMSMarks[k]){
                    rankNumber++;
                }
            }
            rank[j]=rankNumber;//rank number get and add array
        }
        int j=0;
        String[][] tempStudentDetails= new String[newStudentDetails.length][2];
        int[] tempPFMarks=new int[newStudentDetails.length];
        int[] tempDBMSMarks=new int[newStudentDetails.length];
        for(int i:rank){
            tempPFMarks[i-1]=newPFMarks[j];
            tempDBMSMarks[i-1]=newDBMSMarks[j];
            tempStudentDetails[i-1][0]=newStudentDetails[j][0];
            tempStudentDetails[i-1][1]=newStudentDetails[j][1];
            j++;
        }//re arrange data rank order
        System.out.println("+-------+------------------+------------+------------+");
        System.out.println("|   ID  |       Name       |DBMS. Marks |PF. Marks   |");
        System.out.println("+-------+------------------+------------+------------+");
        for (int k =0;k<newStudentDetails.length;k++){
            System.out.println("| "+tempStudentDetails[k][0]+" |"+tempStudentDetails[k][1]+"\t\t|\t"+tempDBMSMarks[k]+"|\t"+tempPFMarks[k]+"|");
        }//output of student rank 
        System.out.println("+-------+------------------+-----------+------------+");
    }
    public static boolean searchStudent(int j, String id){
        boolean answer=studentDetails[j][0].equals(id);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("[1] Add New Student \t\t\t[2] Add New Student With Marks");
        System.out.println("[3] Add Marks \t\t\t\t[4] Update Student Deatils");
        System.out.println("[5] Update Marks \t\t\t[6] Delete Student");
        System.out.println("[7] Print Student Details \t\t[8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamental \t[10] Best in Database Managemnet System");
        System.out.print("\nEnter an option to continue > ");
        Scanner Input=new Scanner(System.in);
        int option =Input.nextInt();
        switch(option){
            case 1 : 
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t  ADD NEW STUDENT     \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command1='y';
                while (command1=='y'||command1=='Y'){
                    addNewStudent();
                    System.out.print("Student has been added successfully.Do you want to add a new student (Y/n) ");
                    command1=Input.next().charAt(0);
                    while (command1!='y'&command1!='Y'&command1!='n'&command1!='N'){
                        System.out.print("Wrong Input letter.Do you want to add a new student, Please enter (Y/n) ");
                        command1=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;
            case 2 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t  ADD NEW STUDENT WITH MARKS     \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command2='y';
                while (command2=='y'||command2=='Y'){
                    addNewStudentWithMarks();
                    System.out.print("Student has been added successfully.Do you want to add a new student (Y/n) ");
                    command2=Input.next().charAt(0);
                    while (command2!='y'&command2!='Y'&command2!='n'&command2!='N'){
                        System.out.print("Wrong Input letter.Do you want to add a new student, Please enter (Y/n) ");
                        command2=Input.next().charAt(0);
                    } 
                }
                main(null);
                break; 
            case 3 : 
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t  ADD MARKS     \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command3='y';
                while (command3=='y'||command3=='Y'){
                    addMarks();
                    System.out.print("Do you want to add marks for another student ? (Y/n) ");
                    command3=Input.next().charAt(0);
                    while (command3!='y'&command3!='Y'&command3!='n'&command3!='N'){
                        System.out.print("Wrong Input letter.Do you want to add marks for another student ?, Please enter (Y/n) ");
                        command3=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;
            case 4 : 
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t      UPDATE STUDENT DETAILS  \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command4='y';
                while (command4=='y'||command4=='Y'){
                    updateStudentDetails();
                    System.out.print("Do you want to update another student details? (Y/n) ");
                    command4=Input.next().charAt(0);
                    while (command4!='y'&command4!='Y'&command4!='n'&command4!='N'){
                        System.out.print("Wrong Input letter.Do you want to update another student details?, Please enter (Y/n) ");
                        command4=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;
            case 5 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t  UPDATE MARKS \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command5='y';
                while (command5=='y'||command5=='Y'){
                    updateMarks();
                    System.out.print("Do you want to update marks for another student? (Y/n) ");
                    command5=Input.next().charAt(0);
                    while (command5!='y'&command5!='Y'&command5!='n'&command5!='N'){
                        System.out.print("Wrong Input letter.Do you want to update marks for another student?, Please enter (Y/n) ");
                        command5=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;
            case 6 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t  DELETE STUDENT \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command6='y';
                while (command6=='y'||command6=='Y'){
                    deleteStudent();
                    System.out.print("Do you want to delete another student? (Y/n) ");
                    command6=Input.next().charAt(0);
                    while (command6!='y'&command6!='Y'&command6!='n'&command6!='N'){
                        System.out.print("Wrong Input letter. Do you want to delete another student?, Please enter (Y/n) ");
                        command6=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;
            case 7 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t    PRINT STUDENT DETAILS    \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command7='y';
                while (command7=='y'||command7=='Y'){
                    printStudentDetails();
                    System.out.print("Do you want to search another student details?  (Y/n)");
                    command7=Input.next().charAt(0);
                    while (command7!='y'&command7!='Y'&command7!='n'&command7!='N'){
                        System.out.print("Wrong Input letter. Do you want to search another student details?, Please enter (Y/n) ");
                        command7=Input.next().charAt(0);
                    } 
                }
                main(null);
                break; 
            case 8 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t    PRINT STUDENT RANKS   \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command8='n';
                while (command8=='n'||command8=='N'){
                    printStudentRanks();
                    System.out.print("Do you want to go back to main menu?  (Y/n)");
                    command8=Input.next().charAt(0);
                    while (command8!='y'&command8!='Y'&command8!='n'&command8!='N'){
                        System.out.print("Wrong Input letter. Do you want to go back to main menu?, Please enter (Y/n) ");
                        command8=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;   
            case 9 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t BEST IN PROGRAMMING FUNDAMENTAL \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command9='n';
                while (command9=='n'||command9=='N'){
                    bestiInProgrammingFundamental();
                    System.out.print("Do you want to go back to main menu?  (Y/n)");
                    command9=Input.next().charAt(0);
                    while (command9!='y'&command9!='Y'&command9!='n'&command9!='N'){
                        System.out.print("Wrong Input letter. Do you want to go back to main menu?, Please enter (Y/n) ");
                        command9=Input.next().charAt(0);
                    } 
                }
                main(null);
                break;    
            case 10 :
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t BEST IN DATABASE MANAGEMENT SYSTEM \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                char command10='n';
                while (command10=='n'||command10=='N'){
                    bestInDatabaseManagemnetSystem();
                    System.out.print("Do you want to go back to main menu?  (Y/n)");
                    command10=Input.next().charAt(0);
                    while (command10!='y'&command10!='Y'&command10!='n'&command10!='N'){
                        System.out.print("Wrong Input letter. Do you want to go back to main menu?, Please enter (Y/n) ");
                        command10=Input.next().charAt(0);
                    } 
                }
                main(null);
                break; 
            default :
                System.out.println("Wrong option");
        }
        for (int i=0;i<studentDetails.length;i++){
            System.out.println(studentDetails[i][0]+"\t"+studentDetails[i][1]);
        }
        for (int i=0;i<studentMarks.length;i++){
            System.out.println(studentMarks[i][0]+"\t"+studentMarks[i][1]);
        }
    }

}