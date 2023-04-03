import connection.Datasource;
import connection.Drivermanager;
import model.Istad_Teacher;
import view.View;

import java.sql.*;
import java.util.*;

public class MainApplication {
    private static final Set<Istad_Teacher> list = new HashSet<>();
    private static Datasource datasource = new Datasource();
    public static void main(String[] args) throws SQLException {
        View view = new View();
        Scanner scanner = new Scanner(System.in);
        Drivermanager drivermanager = new Drivermanager();
        datasource = new Datasource();
        //
        String name;
        Integer age,id,choice = 0,newId=0;

        view.view();
        System.out.print(">> Choose: ");
        //
        try{
            choice = Integer.parseInt(scanner.nextLine());
        }catch (Exception exception) {
            System.out.println(">>> Number only!!!<<< ");
        }
        switch (choice){
            case 1->{
                System.out.print(">> Insert name to column teacher_name: ");
                name = scanner.nextLine();
                System.out.print(">> Insert age to column teacher_age: ");
                age = scanner.nextInt();
                System.out.print(">> Insert ID to column teacher_id: ");
                id = scanner.nextInt();
                newId = id;
                Istad_Teacher istadTeacher = new Istad_Teacher(name,age,id);
                insert(istadTeacher);
            }
            case 2->{
                viewAllData();
            }
            case 3->{;
                System.out.print(">> Insert ID to Update: ");
                id = scanner.nextInt();
                updateById(id);
            }
            case 4->{
                System.out.print(">> Insert ID to delete: ");
                Integer id1 = scanner.nextInt();
                deleteById(id1);
            }
            case 5->{
                System.out.print(">> Insert ID to select: ");
                Integer id2 = scanner.nextInt();
                selectById(id2);
            }
            case 6->{
                System.out.print(">> Insert name to select: ");
                name = scanner.nextLine();
                selectByName(name);
            }
            default -> {
                System.out.println(">> Out of choice!!!");
            }
        }
        System.out.println(">> Run the program again to get updated operation or work again <<".toUpperCase());
        System.exit(0);
    }
    //1. insert
    private static void insert(Istad_Teacher istadTeacher){
        try(Connection connection = datasource.datasource().getConnection()){
            //Insert
            String insert = "INSERT INTO istad_teacher (teacher_name, teacher_age, teacher_id) values(?,?,?)";
            PreparedStatement statement = connection.prepareCall(insert);
            statement.setString(1, istadTeacher.teacher_name());
            statement.setInt(2, istadTeacher.teacher_age());
            statement.setInt(3, istadTeacher.teacher_id());
            int resultSet = statement.executeUpdate();
            if(resultSet>0){
                System.out.println(resultSet +" row affected!!!");
                System.out.println(">> Inserted successfully <<".toUpperCase());
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    //2. View All Data
    private static void viewAllData(){
        //Drive manager
//        Datasource
        try(Connection connection = datasource.datasource().getConnection()){
            //1. Create SQL Statement
            String select = "SELECT *FROM istad_teacher";
            PreparedStatement statement = connection.prepareCall(select);
            //2. Execute SQL Statement
            ResultSet resultSet = statement.executeQuery();
            //3. Process result with ResultSet
            //
            while (resultSet.next()){
                String name = resultSet.getString("teacher_name");
                Integer age = resultSet.getInt("teacher_age");
                Integer id = resultSet.getInt("teacher_id");
                list.add(new Istad_Teacher(name,age, id));
            }
            System.out.println("==========================================================");
            list.forEach(System.out::println);
            System.out.println("==========================================================");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    //3. update by ID
    private static void updateById(Integer id){
        try(Connection connection = datasource.datasource().getConnection()){
            System.out.print("Insert name: ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("Insert age: ");
            Integer age = new Scanner(System.in).nextInt();
            //Update
            String update = "UPDATE istad_teacher set teacher_name = ?, teacher_age = ? where teacher_id = ?";
            PreparedStatement statement = connection.prepareCall(update);
            statement.setString(1,name);
            statement.setInt(2,age);
            statement.setInt(3,id);
            int resultUpdate = statement.executeUpdate();
            System.out.println(resultUpdate +" row affected!!!");
            if(resultUpdate>0){
                System.out.println(">> Updated successfully <<".toUpperCase());
            }else {
                System.out.println(">> Doesn't exist for the ID ".toUpperCase()  + id + " <<");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }
    //4. delete by ID
    private static void deleteById(Integer id){
        try(Connection connection = datasource.datasource().getConnection()) {
            String delete = "Delete from istad_teacher where teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareCall(delete);
            preparedStatement.setInt(1,id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet + " row affected!!!");
            if(resultSet>0){
                System.out.println(">> Deleted data by ID Successfully <<".toUpperCase());
            }else {
                System.out.println(">> Doesn't exist for the ID ".toUpperCase() + id + " <<");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    //5. Select by id
    public static void selectById(Integer id){
        try(Connection connection = datasource.datasource().getConnection()) {
            String selectById = "SELECT *from istad_teacher where teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareCall(selectById);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            //output
            while (resultSet.next()){
                String name = resultSet.getString("teacher_name");
                Integer age = resultSet.getInt("teacher_age");
                list.add(new Istad_Teacher(name,age, id));
            }
            System.out.println("==========================================================");
            list.forEach(System.out::println);
            System.out.println("==========================================================");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    //6. select by Name
    public static void selectByName(String name){
        try(Connection connection = datasource.datasource().getConnection()) {
            String selectName = "SELECT *FROM istad_teacher WHERE teacher_name = ?";
            PreparedStatement preparedStatement = connection.prepareCall(selectName);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("teacher_id");
                Integer age = resultSet.getInt("teacher_age");
                list.add(new Istad_Teacher(name,age, id));
            }
            System.out.println("==========================================================");
            list.forEach(System.out::println);
            System.out.println("==========================================================");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}