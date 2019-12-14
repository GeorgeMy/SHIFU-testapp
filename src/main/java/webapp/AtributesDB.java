package webapp;

import java.sql.*;
import java.util.ArrayList;

public class AtributesDB {
    
    private static String url = "jdbc:mysql://localhost/appdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "admin";
    

    public static ArrayList<Atribute> select(){
        ArrayList<Atribute> atributes = new ArrayList<Atribute>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM atributes");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int El = resultSet.getInt(3);
                    Atribute atribute = new Atribute(id, name,El);
                    atributes.add(atribute);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return atributes;
      
    }
    
    public static ArrayList<Atribute> selectByObjectId(int Id)
    {
        Atribute atribute = null;
        ArrayList<Atribute> atributes = new ArrayList<Atribute>();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password))
            {
                try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM atributes WHERE El = ?")){
                    preparedStatement.setInt(1, Id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int elem = resultSet.getInt(3);
                        atribute = new Atribute(id,name, elem);
                        atributes.add(atribute);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return atributes;
    }
    public static Atribute selectById(int Id)
    {
       Atribute atribute = new Atribute();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password))
            {
                try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM atributes WHERE Id = ?")){
                    preparedStatement.setInt(1, Id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int elem = resultSet.getInt(3);
                        atribute = new Atribute(id,name, elem);
                        
                        preparedStatement.executeQuery();
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return atribute;
    }
    
    public static int insert(Atribute atribute)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO atributes values (?, ?, ?)")){
                    preparedStatement.setInt(1, atribute.getId());
                    preparedStatement.setString(2, atribute.getName());
                    preparedStatement.setInt(3, atribute.getEl());
                    
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        return 0;
    }
    
    public static int delete(String name){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM atributes WHERE name = ?")){
                    preparedStatement.setString(1,name);
                    
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    return 0;
    }
    
        public static int delete(int id){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM atributes WHERE El = ?")){
                    preparedStatement.setInt(1,id);
                    
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    return 0;
    }
        
    public static int update(Atribute atribute){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(url,username,password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement("UPDATE atributes SET name = ? WHERE Id = ?"))
                {
                    preparedStatement.setString(1, atribute.getName());
                    preparedStatement.setInt(2, atribute.getId());
                    return preparedStatement.executeUpdate();
                }
            
            }
        }
        catch(Exception ex){
            System.out.print(ex);
        }
        return 0;
    }
}
