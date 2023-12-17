import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class test {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/testJDBC";
        String pass="root";
        String username="root";
        Connection con=DriverManager.getConnection(url,username,pass) ;
        Statement statement=con.createStatement();
        ResultSet resultSet=null;

        Scanner sc=new Scanner(System.in);
        int option;
        String sql;
        do{
            System.out.println("1 : insert data");
            System.out.println("2 : display data");
            System.out.println("3 : update data");
            System.out.println("4 : delete data");
            System.out.println("5 : search data");
            System.out.println("6 : count data");
            System.out.println("7 : order by desc ");
            System.out.println("8 : display data starts with a");
            System.out.println("9 : break");

            option=sc.nextInt();

            switch (option){

                case 1:
                    System.out.println("enter id");
                    int id= sc.nextInt();

                    System.out.println("enter name");
                    String name= sc.next();

                    System.out.println("enter degree");
                    String degree= sc.next();

                    sql="insert into learner(id,name,degree) values("+id+",'"+name+"','"+degree+"')";
                    statement.executeUpdate(sql);
                    System.out.println("record entered succesfully");
                    break;

                case 2:
                    resultSet= statement.executeQuery("select * from learner");
                    while(resultSet.next()){
                        System.out.println("Learner ID : "+resultSet.getInt(1));
                        System.out.println("Learner Name : "+resultSet.getString(2));
                        System.out.println("Learner Degree : "+resultSet.getString(3));
                        System.out.println("_________________________________________________________________");
                    }
                    break;

                case 3:
                    System.out.println("Enter the useid whose data u want to update");
                    System.out.println("enter id");
                    int id1= sc.nextInt();

                    System.out.println("enter name");
                    String name1= sc.next();

                    System.out.println("enter degree");
                    String degree1= sc.next();

                    sql="update learner set name='"+name1+"',degree='"+degree1+"'";
                    statement.executeUpdate(sql);

                break;

                case 4:
                    System.out.println("Enter userrid u want to delete");
                    id= sc.nextInt();
                    sql="delete from learner where id='"+id+"'";
                    statement.executeUpdate(sql);
                    System.out.println("data succesfully deleted");
                    break;

                case 5:
                    System.out.println("enter userid u want to search");
                    id= sc.nextInt();
                    sql="select * from learner where id='"+id+"'";
                    resultSet = statement.executeQuery(sql);
                    resultSet.next();

                    System.out.println("ID :"+resultSet.getInt(1));
                    System.out.println("Name : "+resultSet.getString(2));
                    System.out.println("Degree : "+resultSet.getString(3));
                    System.out.println("____________________________________________________________");

                    break;

                case 6:
                    sql="select count(*) from learner";
                    resultSet=statement.executeQuery(sql);
                    resultSet.next();
                    System.out.println("Count : "+resultSet.getInt(1));
                    break;

                case 7:
                    sql="select * from learner order by id asc";
                    resultSet=statement.executeQuery(sql);
                   while( resultSet.next()) {
                       System.out.println("ID : " + resultSet.getInt(1));
                       System.out.println("Name : " + resultSet.getString(2));
                       System.out.println("Degree : " + resultSet.getString(3));
                       System.out.println("_______________________________________________________");
                   }
                    break;

                case 8:
                    sql="select * from learner where name like 'R%'";
                    resultSet=statement.executeQuery(sql);
                    while(resultSet.next()){
                        System.out.println("ID : " + resultSet.getInt(1));
                        System.out.println("Name : " + resultSet.getString(2));
                        System.out.println("Degree : " + resultSet.getString(3));
                        System.out.println("_______________________________________________________");
                    }
                    break;

                case 9:
                    System.exit(0);
                    break;
            }

        }
        while(option!=9);
        statement.close();
        con.close();
    }
}
