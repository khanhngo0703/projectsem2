package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AdminController implements Initializable {

	@FXML
    private Button addArea_addBtn;

    @FXML
    private TableColumn<?, ?> addArea_col_areaID;

    @FXML
    private TableColumn<?, ?> addArea_col_areaName;

    @FXML
    private TableColumn<?, ?> addArea_col_areaStatus;

    @FXML
    private Button addArea_deleteBtn;

    @FXML
    private TextField addArea_name;

    @FXML
    private TableView<?> addArea_tableView;

    @FXML
    private Button addArea_updateBtn;

    @FXML
    private Button addBook_addBtn;

    @FXML
    private ComboBox<?> addBook_area;

    @FXML
    private TextField addBook_author;

    @FXML
    private TextField addBook_bookName;

    @FXML
    private Button addBook_btn;

    @FXML
    private ComboBox<?> addBook_category;

    @FXML
    private Button addBook_clearBtn;

    @FXML
    private TableColumn<?, ?> addBook_col_area;

    @FXML
    private TableColumn<?, ?> addBook_col_author;

    @FXML
    private TableColumn<?, ?> addBook_col_bookID;

    @FXML
    private TableColumn<?, ?> addBook_col_bookName;

    @FXML
    private TableColumn<?, ?> addBook_col_category;

    @FXML
    private TableColumn<?, ?> addBook_col_publicationYear;

    @FXML
    private TableColumn<?, ?> addBook_col_quantity;

    @FXML
    private Button addBook_deleteBtn;

    @FXML
    private AnchorPane addBook_form;

    @FXML
    private ImageView addBook_image;

    @FXML
    private Button addBook_importBtn;

    @FXML
    private TextField addBook_publicationYear;

    @FXML
    private TextField addBook_quantity;

    @FXML
    private TextField addBook_search;

    @FXML
    private TableView<?> addBook_tableView;

    @FXML
    private Button addBook_updateBtn;

    @FXML
    private Button addCustomer_addBtn;

    @FXML
    private DatePicker addCustomer_arriveDate;

    @FXML
    private Spinner<?> addCustomer_arriveHour;

    @FXML
    private Button addCustomer_clearBtn;

    @FXML
    private TableColumn<?, ?> addCustomer_col_arriveDate;

    @FXML
    private TableColumn<?, ?> addCustomer_col_arriveHour;

    @FXML
    private TableColumn<?, ?> addCustomer_col_customerID;

    @FXML
    private TableColumn<?, ?> addCustomer_col_email;

    @FXML
    private TableColumn<?, ?> addCustomer_col_fullname;

    @FXML
    private TableColumn<?, ?> addCustomer_col_gender;

    @FXML
    private TableColumn<?, ?> addCustomer_col_phone;

    @FXML
    private TableColumn<?, ?> addCustomer_col_status;

    @FXML
    private Button addCustomer_deleteBtn;

    @FXML
    private TextField addCustomer_email;

    @FXML
    private AnchorPane addCustomer_form;

    @FXML
    private TextField addCustomer_fullname;

    @FXML
    private ComboBox<?> addCustomer_gender;

    @FXML
    private TextField addCustomer_phone;

    @FXML
    private TextField addCustomer_search;

    @FXML
    private ComboBox<?> addCustomer_status;

    @FXML
    private TableView<?> addCustomer_tableView;

    @FXML
    private Button addCustomer_updateBtn;

    @FXML
    private Button addEmployee_addBtn;

    @FXML
    private TextField addEmployee_address;

    @FXML
    private DatePicker addEmployee_arriveDate;

    @FXML
    private Button addEmployee_btn;

    @FXML
    private Button addEmployee_clearBtn;

    @FXML
    private TableColumn<?, ?> addEmployee_col_address;

    @FXML
    private TableColumn<?, ?> addEmployee_col_arriveDate;

    @FXML
    private TableColumn<?, ?> addEmployee_col_email;

    @FXML
    private TableColumn<?, ?> addEmployee_col_employeeID;

    @FXML
    private TableColumn<?, ?> addEmployee_col_gender;

    @FXML
    private TableColumn<?, ?> addEmployee_col_phone;

    @FXML
    private TableColumn<?, ?> addEmployee_col_username;

    @FXML
    private Button addEmployee_deleteBtn;

    @FXML
    private TextField addEmployee_email;

    @FXML
    private AnchorPane addEmployee_form;

    @FXML
    private TextField addEmployee_fullname;

    @FXML
    private ComboBox<?> addEmployee_gender;

    @FXML
    private ImageView addEmployee_image;

    @FXML
    private Button addEmployee_import;

    @FXML
    private PasswordField addEmployee_password;

    @FXML
    private TextField addEmployee_phone;

    @FXML
    private TextField addEmployee_search;

    @FXML
    private TableView<?> addEmployee_tableView;

    @FXML
    private Button addEmployee_updateBtn;

    @FXML
    private TextField addEmployee_username;

    @FXML
    private Button area_btn;

    @FXML
    private AnchorPane area_form;

    @FXML
    private Button customers_btn;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Button logout;

    @FXML
    private Button pos_btn;

    @FXML
    private Button statistics_btn;

    @FXML
    private Label username;


    
    public void switchForm(ActionEvent event) {
    	if(event.getSource() == home_btn) {
    		home_form.setVisible(true);
    		addBook_form.setVisible(false); 
    		addEmployee_form.setVisible(false);
    		area_form.setVisible(false);
    		addCustomer_form.setVisible(false); 
    		
    		home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
    		addBook_btn.setStyle("-fx-background-color: transparent");
    		addEmployee_btn.setStyle("-fx-background-color: transparent");
    		area_btn.setStyle("-fx-background-color: transparent");
    		customers_btn.setStyle("-fx-background-color: transparent");
    		
    	}else if(event.getSource() == addBook_btn) {
    		home_form.setVisible(false);
    		addBook_form.setVisible(true);  
    		addEmployee_form.setVisible(false);
    		area_form.setVisible(false);
    		addCustomer_form.setVisible(false); 
    		
    		addBook_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
    		home_btn.setStyle("-fx-background-color: transparent");
    		addEmployee_btn.setStyle("-fx-background-color: transparent");
    		area_btn.setStyle("-fx-background-color: transparent");
    		customers_btn.setStyle("-fx-background-color: transparent");
    		
    	}else if(event.getSource() == addEmployee_btn) {
    		home_form.setVisible(false);
    		addBook_form.setVisible(false);  
    		addEmployee_form.setVisible(true);
    		area_form.setVisible(false);
    		addCustomer_form.setVisible(false); 
    		
    		addEmployee_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
    		home_btn.setStyle("-fx-background-color: transparent");
    		addBook_btn.setStyle("-fx-background-color: transparent");
    		area_btn.setStyle("-fx-background-color: transparent");
    		customers_btn.setStyle("-fx-background-color: transparent");
    		
    	}else if(event.getSource() == area_btn) {
    		home_form.setVisible(false);
    		addBook_form.setVisible(false);  
    		addEmployee_form.setVisible(false);
    		area_form.setVisible(true);
    		addCustomer_form.setVisible(false); 
    		
    		addEmployee_btn.setStyle("-fx-background-color: transparent");
    		home_btn.setStyle("-fx-background-color: transparent");
    		addBook_btn.setStyle("-fx-background-color: transparent");
    		area_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
    		customers_btn.setStyle("-fx-background-color: transparent");
    		
    	}else if(event.getSource() == customers_btn) {
    		home_form.setVisible(false);
    		addBook_form.setVisible(false);  
    		addEmployee_form.setVisible(false);
    		area_form.setVisible(false);
    		addCustomer_form.setVisible(true); 
    		
    		addEmployee_btn.setStyle("-fx-background-color: transparent");
    		home_btn.setStyle("-fx-background-color: transparent");
    		addBook_btn.setStyle("-fx-background-color: transparent");
    		area_btn.setStyle("-fx-background-color: transparent");
    		customers_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
