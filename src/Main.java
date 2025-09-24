import config.DB;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try(var connection = DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}