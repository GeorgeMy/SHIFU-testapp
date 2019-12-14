package webapp;

import java.sql.*;
import java.util.ArrayList;

public class ObjectsDB {
    
    private static String url = "jdbc:mysql://localhost/appdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "admin";
    
    public static ArrayList<Object> select(){
        ArrayList<Object> objects = new ArrayList<Object>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM objects");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Object object = new Object(id, name);
                    objects.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return objects;
      
    }
    
    public static Object selectOne(int Id)
    {
        Object object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password))
            {
                try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM objects WHERE Id = ?")){
                    preparedStatement.setInt(1, Id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        
                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        object = new Object(prodId, name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    
    public static int update(Object object){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("UPDATE objects SET name = ? WHERE Id = ?"))
                {
                    preparedStatement.setString(1, object.getName());
                    preparedStatement.setInt(2, object.getId());
                
                    return preparedStatement.executeUpdate();
                }
            
            }
        }
        catch(Exception ex){
            System.out.print(ex);
        }
        return 0;
    }
    
    public static int insert(Object object)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO objects values (?, ?)")){
                    preparedStatement.setInt(1, object.getId());
                    preparedStatement.setString(2, object.getName());
                    
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return 0;
    }
    
    public static int delete(int Id)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password))
            {
                try(PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM objects WHERE Id = ?"))
                {
                    preparedStatement.setInt(1, Id);
                    
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
        return 0;
    }
    
}
