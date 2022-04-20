package com.example.cms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
//import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class HelloController extends Movie {
    @FXML
    private Button cancelButton ;
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField moviename;
    @FXML
    private TextField time;
    @FXML
    private TextField itemidfield;
    @FXML
    private TextField pricefield;
    @FXML
    private TextField qntyfield;
    @FXML
    private TextField employeeField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField Email;
    @FXML
    private TextField UserName;
    @FXML
    private TextField passwordField;
    @FXML
    private Label messageDisplay;
    @FXML
    private Label messageDisplay2;
    @FXML
    private Label messageDisplay3;
    @FXML
    private Label messageDisplay4;
    @FXML
    private Label messageDisplay5;
    @FXML
    private Button totalSalaryButton;
    @FXML
    private Button backButton;
    @FXML
    private Button backButton2;
    @FXML
    private Button createbutton;
    @FXML
    private Button continueButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button showtotalButton;
    @FXML
    private Button showtotalButton2;
    @FXML
    private Button Exit;
    @FXML
    private Button Register;
    int totality =0;
    Movie i1 = new Movie();


    /*
        @FXML
        private Label welcomeText;
    */
    @FXML
    protected void onHelloButtonClick() {
        // welcomeText.setText("LOGIN SUCCESS");
    }

    @FXML
    public void cancelButtonExit(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

        //       Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();
    }

    @FXML
    public void loginButton(ActionEvent event) throws IOException, SQLException {

        sqlConnection connection = new sqlConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "'";
        // create a Statement from the connection
        Statement statement = connectDB.createStatement();

        // insert the data
       // statement.executeUpdate("INSERT INTO user_account (firstname, lastname, username, password) " + "VALUES ('pammad', 'pameed', 'hh', '1234')");
        try {
           // Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            if (username.getText().isBlank() == false && password.getText().isBlank() == false)
            {
                while (queryResult.next())
                {
                    if (queryResult.getInt(1) == 1) {
                        messageDisplay.setText("CONGRATULATIONS");
                        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                        Stage stage = new Stage();
                        stage.setTitle("Cinema Management System");
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        messageDisplay.setText("WRONG USERNAME or PASSWORD");
                    }
                }
                //  messageDisplay.setText("YOU ARE TRYING TO LOG IN");
            } else {
                messageDisplay.setText("Please enter Login details!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }



/*
            while(queryResult.next())
            {
                if (queryResult.getInt(1) == 1)
                {
                    messageDisplay.setText("CONGRATULATIONS");
                } else {
                    messageDisplay.setText("WRONG USERNAME or PASSWORD");
                }
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }*//*
        if(username.getText().isBlank() == false && password.getText().isBlank() == false)
        {
        while(queryResult.next())
            {
                if (queryResult.getInt(1) == 1)
                {
                    messageDisplay.setText("CONGRATULATIONS");
                     FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
           Stage stage = new Stage();
           stage.setTitle("Cost Management System");
           stage.setScene(scene);
           stage.show();
                } else {
                    messageDisplay.setText("WRONG USERNAME or PASSWORD");
                }
            }
          //  messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        }
        else
        {
            messageDisplay.setText("Please enter Login details!");
        }*/


    @FXML
    public void registerButton(ActionEvent event) throws IOException, SQLException {

        String firstN = firstName.getText();
        String lastN = lastName.getText();
        String userN = UserName.getText();
        String passwordF = passwordField.getText();

        sqlConnection connection = new sqlConnection();
        Connection connectDB = connection.getConnection();


       // String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "'";
        // create a Statement from the connection

        Statement statement = connectDB.createStatement();
        String qurey ="INSERT INTO user_account ( firstname, lastname, username, password) " + "VALUES ( ?, ?, ?, ?)";
        // insert the data

//        statement.
//                statement.executeUpdate(qurey);


        PreparedStatement statement1 =connectDB.prepareStatement(qurey);
        statement1.setString(1,firstN);
        statement1.setString(2,lastN);
        statement1.setString(3,userN);
        statement1.setString(4,passwordF);
            int rowInserted =statement1.executeUpdate();

            if(rowInserted>1)
                System.out.println("inserted");


        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void loginRegister(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    public void backButtonAction(ActionEvent event) throws IOException {
            //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Cinema Management System");
            stage.setScene(scene);
            stage.show();

        }


    @FXML
    public void nextButtonAction(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");

    }


    @FXML
    public void continue4Action(ActionEvent event) throws IOException {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tax.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showTotalSalary(ActionEvent event) throws IOException {


    }

    @FXML
    public void createButtonAction(ActionEvent event) throws IOException, SQLException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        boolean check = true;
        int budget = 0;
        String projectName;
        projectName=moviename.getText();
     //   System.out.println(projectName);
        sqlConnection connection = new sqlConnection();
        Connection connectDB = connection.getConnection();

        //String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "'";
        // create a Statement from the connection
        Statement statement = connectDB.createStatement();

        // insert the data
        //statement.executeUpdate("INSERT INTO project " + "VALUES (1,'cons1',100000)");
        File file = new File("newFile.txt");
        try {
            FileWriter myWriter = new FileWriter("newFile.txt");
            myWriter.write(projectName);
            myWriter.write("  b");
            myWriter.write(budget);
            myWriter.close();
            System.out.println("\nSuccessfully wrote to the file.");
            boolean createFile = file.createNewFile();
            if (createFile) {
                System.out.println("New File created");
            }else {
                System.out.println("This File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    if(check==true)
         {
             ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Cinema Management System");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void backButtonAction2(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void backButtonAction3(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();

    }

    public void continueButtonAction2(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void continueButtonAction(ActionEvent event) throws IOException {
        //messageDisplay.setText("YOU ARE TRYING TO LOG IN");
        //messageDisplay.setText("Your total expense will be: " + totality);
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cinema Management System");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void showTotalButtonAction(ActionEvent event) throws IOException {


    }

    @FXML
    public void showTotalButtonAction1(ActionEvent event) throws IOException {

    }

/*
    @FXML
    public void continueButton(ActionEvent event) throws IOException {
        if(projectName.getText().isBlank() == false && password.getText().isBlank() == false)
        {
            messageDisplay.setText("YOU ARE TRYING TO LOG IN");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Cost Management System");
            stage.setScene(scene);
            stage.show();

        }
        else
        {
            messageDisplay.setText("Please enter Login details!");
        }
    }*/
}
