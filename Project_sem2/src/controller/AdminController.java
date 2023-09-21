package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import data.AreaData;
import data.BookData;
import data.CategoryData;
import data.CustomerData;
import data.EmployeeData;
import database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AdminController implements Initializable {

	@FXML
	private Button addArea_addBtn;

	@FXML
	private TableColumn<AreaData, Integer> addArea_col_areaID;

	@FXML
	private TableColumn<AreaData, String> addArea_col_areaName;

	@FXML
	private TableColumn<?, ?> addArea_col_areaStatus;

	@FXML
	private Button addArea_deleteBtn;

	@FXML
	private TextField addArea_name;

	@FXML
	private TextField addArea_search;

	@FXML
	private TableView<AreaData> addArea_tableView;

	@FXML
	private Button addArea_updateBtn;

	@FXML
	private Button addBook_addBtn;

	@FXML
	private ComboBox<String> addBook_area;

	@FXML
	private TextField addBook_author;

	@FXML
	private TextField addBook_bookName;

	@FXML
	private Button addBook_btn;

	@FXML
	private ComboBox<String> addBook_category;

	@FXML
	private Button addBook_clearBtn;

	@FXML
	private TableColumn<BookData, String> addBook_col_area;

	@FXML
	private TableColumn<BookData, String> addBook_col_author;

	@FXML
	private TableColumn<BookData, Integer> addBook_col_bookID;

	@FXML
	private TableColumn<BookData, String> addBook_col_bookName;

	@FXML
	private TableColumn<BookData, String> addBook_col_category;

	@FXML
	private TableColumn<BookData, Date> addBook_col_publicationYear;

	@FXML
	private TableColumn<BookData, Integer> addBook_col_quantity;

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
	private TableView<BookData> addBook_tableView;

	@FXML
	private Button addBook_updateBtn;

	@FXML
	private Button addCategory_addBtn;

	@FXML
	private TableColumn<CategoryData, Integer> addCategory_col_categoryID;

	@FXML
	private TableColumn<CategoryData, String> addCategory_col_categoryName;

	@FXML
	private Button addCategory_deleteBtn;

	@FXML
	private TextField addCategory_name;

	@FXML
	private TextField addCategory_search;

	@FXML
	private TableView<CategoryData> addCategory_tableView;

	@FXML
	private Button addCategory_updateBtn;

	@FXML
	private Button addCustomer_addBtn;

	@FXML
	private DatePicker addCustomer_arriveDate;

	@FXML
	private Button addCustomer_clearBtn;

	@FXML
	private TableColumn<CustomerData, Date> addCustomer_col_arriveDate;

	@FXML
	private TableColumn<CustomerData, Integer> addCustomer_col_customerID;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_email;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_fullname;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_gender;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_phone;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_status;

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
	private TableView<CustomerData> addCustomer_tableView;

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
	private TableColumn<EmployeeData, String> addEmployee_col_address;

	@FXML
	private TableColumn<EmployeeData, Date> addEmployee_col_arriveDate;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_email;

	@FXML
	private TableColumn<EmployeeData, Integer> addEmployee_col_employeeID;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_fullname;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_gender;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_phone;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_username;

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
	private TableView<EmployeeData> addEmployee_tableView;

	@FXML
	private Button addEmployee_updateBtn;

	@FXML
	private TextField addEmployee_username;

	@FXML
	private Button area_btn;

	@FXML
	private AnchorPane area_form;

	@FXML
	private Button category_btn;

	@FXML
	private AnchorPane category_form;

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
	private AnchorPane pos_form;

	@FXML
	private Button staticis_btn;

	@FXML
	private Label username;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepare;
	private ResultSet result;

	private Image image;
	private String imagePath;

//---------------------------------------------------------------------------------------------------------
	// CRUD BOOKS

	public void addBookAdd() {
		String sql = "INSERT INTO books (book_name, author_name, publication_year, quantity, book_image, category_id, area_id) VALUES(?,?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			if (addBook_bookName.getText().isEmpty() || addBook_author.getText().isEmpty()
					|| addBook_publicationYear.getText().isEmpty() || addBook_quantity.getText().isEmpty()
					|| addBook_area.getSelectionModel().getSelectedItem() == null
					|| addBook_category.getSelectionModel().getSelectedItem() == null || imagePath == null
					|| imagePath.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all blank fields");
				alert.showAndWait();
			} else {
				String check = "SELECT book_name FROM books WHERE book_name = ?";
				PreparedStatement checkStatement = connect.prepareStatement(check);
				checkStatement.setString(1, addBook_bookName.getText());
				ResultSet result = checkStatement.executeQuery();

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Book name: " + addBook_bookName.getText() + " already exists!");
					alert.showAndWait();
				} else {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setString(1, addBook_bookName.getText());
					prepare.setString(2, addBook_author.getText());
					prepare.setInt(3, Integer.parseInt(addBook_publicationYear.getText()));
					prepare.setString(4, addBook_quantity.getText());
					prepare.setString(5, imagePath);

					// Retrieve the category_id based on the selected category name
					String selectedCategory = (String) addBook_category.getSelectionModel().getSelectedItem();
					int categoryId = getCategoryIdByName(selectedCategory);
					prepare.setInt(6, categoryId);

					String selectedArea = (String) addBook_area.getSelectionModel().getSelectedItem();
					int areaId = getAreaIdByName(selectedArea);
					prepare.setInt(7, areaId);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addBookShowListData();
					addBookReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getCategoryIdByName(String categoryName) {
		try {
			String query = "SELECT id FROM category WHERE category_name = ?";
			prepare = connect.prepareStatement(query);
			prepare.setString(1, categoryName);
			ResultSet resultSet = prepare.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private int getAreaIdByName(String areaName) {
		try {
			String query = "SELECT id FROM area WHERE area_name = ?";
			prepare = connect.prepareStatement(query);
			prepare.setString(1, areaName);
			ResultSet resultSet = prepare.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ObservableList<String> getAreas() {
		ObservableList<String> areas = FXCollections.observableArrayList();

		String sql = "SELECT area_name FROM area";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				areas.add(result.getString("area_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return areas;
	}

	public ObservableList<String> getCategories() {
		ObservableList<String> categories = FXCollections.observableArrayList();

		String sql = "SELECT category_name FROM category";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				categories.add(result.getString("category_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return categories;
	}

	public void addBookUpdate() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			int bookId = bookData.getBookID();

			String sql = "UPDATE books SET book_name = ?, author_name = ?, publication_year = ?, quantity = ?, book_image = ?, category_id = ?, area_id = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String bookName = addBook_bookName.getText().trim();
				String authorName = addBook_author.getText().trim();
				int publicationYear = Integer.parseInt(addBook_publicationYear.getText());
				String quantity = addBook_quantity.getText().trim();
				String bookImage = imagePath;
				int categoryId = getCategoryIdByName((String) addBook_category.getSelectionModel().getSelectedItem());
				int areaId = getAreaIdByName((String) addBook_area.getSelectionModel().getSelectedItem());

				if (bookName.isEmpty() && authorName.isEmpty() && quantity.isEmpty() && bookImage.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all blank fields");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE the book?");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						PreparedStatement prepare = connect.prepareStatement(sql);
						prepare.setString(1, bookName);
						prepare.setString(2, authorName);
						prepare.setInt(3, publicationYear);
						prepare.setString(4, quantity);
						prepare.setString(5, bookImage);
						prepare.setInt(6, categoryId);
						prepare.setInt(7, areaId);
						prepare.setInt(8, bookId);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addBookShowListData();
						addBookReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book to update.");
			alert.showAndWait();
		}
	}

	public void addBookDelete() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			int bookId = bookData.getBookID();

			String sql = "DELETE FROM books WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, bookId);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this book?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Book deleted successfully!");
					alert.showAndWait();

					addBookShowListData();
					addBookReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book to delete.");
			alert.showAndWait();
		}
	}

	public void addBookReset() {
		addBook_bookName.setText("");
		addBook_author.setText("");
		addBook_publicationYear.setText("");
		addBook_quantity.setText("");
		addBook_area.getSelectionModel().clearSelection();
		addBook_category.getSelectionModel().clearSelection();
		addBook_image.setImage(null);
		imagePath = "";

	}

	public void addBookInsertImage() {
		FileChooser open = new FileChooser();
		File file = open.showOpenDialog(addBook_form.getScene().getWindow());

		if (file != null) {
			imagePath = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addBook_image.setImage(image);

		}
	}

	public void addBookSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addBook_search.getText();

		FilteredList<BookData> filter = new FilteredList<>(addBookList, e -> true);

		filter.setPredicate(bookData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(bookData.getBookID()).toLowerCase().contains(searchKey)
					|| bookData.getBookName().toLowerCase().contains(searchKey)
					|| bookData.getAuthorName().toLowerCase().contains(searchKey)
					|| bookData.getPublicationYear().toLowerCase().contains(searchKey)
					|| Integer.toString(bookData.getQuantity()).toLowerCase().contains(searchKey)
					|| bookData.getCategoryName().toLowerCase().contains(searchKey)
					|| bookData.getAreaName().toLowerCase().contains(searchKey);
		});

		SortedList<BookData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addBook_tableView.comparatorProperty());

		addBook_tableView.setItems(sortList);
	}

	public ObservableList<BookData> addBookListData() {

		ObservableList<BookData> listData = FXCollections.observableArrayList();
		String sql = "SELECT books.*, category.category_name, area.area_name FROM books INNER JOIN category ON books.category_id = category.id INNER JOIN area ON books.area_id = area.id";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			BookData bookData;

			while (result.next()) {
				bookData = new BookData(result.getInt("id"), result.getString("book_name"),
						result.getString("author_name"), result.getString("publication_year"),
						result.getInt("quantity"), result.getString("book_image"), result.getInt("category_id"),
						result.getInt("area_id"), result.getString("category_name"), result.getString("area_name"));
				listData.add(bookData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	private ObservableList<BookData> addBookList;

	public void addBookShowListData() {
		addBookList = addBookListData();

		addBook_col_bookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
		addBook_col_bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
		addBook_col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		addBook_col_publicationYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
		addBook_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		addBook_col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		addBook_col_area.setCellValueFactory(new PropertyValueFactory<>("areaName"));

		addBook_tableView.setItems(addBookList);

	}

	public void addBookSelect() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			addBook_bookName.setText(String.valueOf(bookData.getBookName()));
			addBook_author.setText(String.valueOf(bookData.getAuthorName()));
			addBook_publicationYear.setText(String.valueOf(bookData.getPublicationYear()));
			addBook_quantity.setText(String.valueOf(bookData.getQuantity()));

			String uri = "file:" + bookData.getBookImage();
			image = new Image(uri, 101, 127, false, true);
			addBook_image.setImage(image);

			addBook_area.getSelectionModel().select(bookData.getAreaName());
			addBook_category.getSelectionModel().select(bookData.getCategoryName());
		}
	}

//---------------------------------------------------------------------------------------------
	// CRUD EMPLOYEES
	public void addEmployeeAdd() {
		String sql = "INSERT INTO users (fullname, username, email, phone_number, password_hash, gender, user_image, address, arrive_date) VALUES(?,?,?,?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String fullname = addEmployee_fullname.getText().trim();
			String username = addEmployee_username.getText().trim();
			String email = addEmployee_email.getText().trim();
			String phone = addEmployee_phone.getText().trim();
			String passwordHash = addEmployee_password.getText().trim();
			String gender = (String) addEmployee_gender.getSelectionModel().getSelectedItem();
			String userImage = imagePath;
			String address = addEmployee_address.getText().trim();
			LocalDate arriveDate = addEmployee_arriveDate.getValue();

			if (fullname.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || passwordHash.isEmpty()
					|| gender == null || userImage == null || address == null || arriveDate == null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all fields");
				alert.showAndWait();
			} else {
				if (!isValidEmail(email)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid email format");
					alert.showAndWait();
				} else if (!isValidPhoneNumber(phone)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid phone number format");
					alert.showAndWait();
				} else {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setString(1, fullname);
					prepare.setString(2, username);
					prepare.setString(3, email);
					prepare.setString(4, phone);
					prepare.setString(5, passwordHash);
					prepare.setString(6, gender);
					prepare.setString(7, userImage);
					prepare.setString(8, address);
					prepare.setDate(9, java.sql.Date.valueOf(arriveDate));

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEmployeeUpdate() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			int employeeId = employeeData.getEmployeeID();

			String sql = "UPDATE users SET fullname = ?, username = ?, email = ?, phone_number = ?, password_hash = ?, gender = ?, user_image = ?, address = ?, arrive_date = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String fullname = addEmployee_fullname.getText().trim();
				String username = addEmployee_username.getText().trim();
				String email = addEmployee_email.getText().trim();
				String phone = addEmployee_phone.getText().trim();
				String passwordHash = addEmployee_password.getText().trim();
				String gender = (String) addEmployee_gender.getSelectionModel().getSelectedItem();
				String userImage = imagePath;
				String address = addEmployee_address.getText().trim();
				LocalDate arriveDate = addEmployee_arriveDate.getValue();

				if (fullname.isEmpty() && email.isEmpty() && phone.isEmpty() && passwordHash.isEmpty() && gender == null
						&& userImage == null && address == null && arriveDate == null) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all fields");
					alert.showAndWait();
				} else {
					if (!isValidEmail(email)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid email format");
						alert.showAndWait();
					} else if (!isValidPhoneNumber(phone)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid phone number format");
						alert.showAndWait();
					} else {
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Message");
						alert.setHeaderText(null);
						alert.setContentText("Are you sure you want to UPDATE the employee?");
						Optional<ButtonType> option = alert.showAndWait();

						if (option.get() == ButtonType.OK) {
							PreparedStatement prepare = connect.prepareStatement(sql);
							prepare.setString(1, fullname);
							prepare.setString(2, username);
							prepare.setString(3, email);
							prepare.setString(4, phone);
							prepare.setString(5, passwordHash);
							prepare.setString(6, gender);
							prepare.setString(7, userImage);
							prepare.setString(8, address);
							prepare.setDate(9, java.sql.Date.valueOf(arriveDate));
							prepare.setInt(10, employeeId);

							prepare.executeUpdate();

							alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Message");
							alert.setHeaderText(null);
							alert.setContentText("Successfully Updated!");
							alert.showAndWait();

							addEmployeeShowListData();
							addEmployeeReset();
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select an employee to update.");
			alert.showAndWait();
		}
	}

	public void addEmployeeDelete() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			int employeeId = employeeData.getEmployeeID();

			String sql = "DELETE FROM users WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE the employee?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setInt(1, employeeId);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Deleted!");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select an employee to delete.");
			alert.showAndWait();
		}
	}

	public void addEmployeeReset() {
		addEmployee_fullname.setText("");
		addEmployee_username.setText("");
		addEmployee_email.setText("");
		addEmployee_phone.setText("");
		addEmployee_password.setText("");
		addEmployee_gender.getSelectionModel().clearSelection();
		addEmployee_address.setText("");
		addEmployee_arriveDate.setPromptText("");
		addEmployee_image.setImage(null);
		imagePath = "";
	}

	public void addEmployeeGenderList() {
		List<String> listGender = new ArrayList<>();

		for (String data : genderList) {
			listGender.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listGender);
		addEmployee_gender.setItems(listData1);
	}

	public void addEmployeeInsertImage() {
		FileChooser open = new FileChooser();
		File file = open.showOpenDialog(addEmployee_form.getScene().getWindow());

		if (file != null) {
			imagePath = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addEmployee_image.setImage(image);

		}
	}

	public void addEmployeeSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addEmployee_search.getText();

		FilteredList<EmployeeData> filter = new FilteredList<>(addEmployeeList, e -> true);

		filter.setPredicate(employeeData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(employeeData.getEmployeeID()).toLowerCase().contains(searchKey)
					|| employeeData.getUserName().toLowerCase().contains(searchKey)
					|| employeeData.getFullName().toLowerCase().contains(searchKey)
					|| employeeData.getPhoneNumber().toLowerCase().contains(searchKey)
					|| employeeData.getEmail().toLowerCase().contains(searchKey)
					|| employeeData.getGender().toLowerCase().contains(searchKey)
					|| employeeData.getAddress().toLowerCase().contains(searchKey)
					|| employeeData.getArriveDate().toString().toLowerCase().contains(searchKey);
		});

		SortedList<EmployeeData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());

		addEmployee_tableView.setItems(sortList);
	}

	public ObservableList<EmployeeData> addEmployeeListData() {

		ObservableList<EmployeeData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM users";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			EmployeeData employeeData;

			while (result.next()) {
				employeeData = new EmployeeData(result.getInt("id"), result.getString("fullname"),
						result.getString("username"), result.getString("email"), result.getString("phone_number"),
						result.getString("password_hash"), result.getString("gender"), result.getString("user_image"),
						result.getString("address"), result.getDate("arrive_date"));
				listData.add(employeeData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	private ObservableList<EmployeeData> addEmployeeList;

	public void addEmployeeShowListData() {
		addEmployeeList = addEmployeeListData();

		addEmployee_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
		addEmployee_col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
		addEmployee_col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		addEmployee_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		addEmployee_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		addEmployee_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addEmployee_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
		addEmployee_col_arriveDate.setCellValueFactory(new PropertyValueFactory<>("arriveDate"));

		addEmployee_tableView.setItems(addEmployeeList);

	}

	public void addEmployeeSelect() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			addEmployee_username.setText(String.valueOf(employeeData.getUserName()));
			addEmployee_password.setText(String.valueOf(employeeData.getPassword()));
			addEmployee_fullname.setText(String.valueOf(employeeData.getFullName()));
			addEmployee_phone.setText(String.valueOf(employeeData.getPhoneNumber()));
			addEmployee_email.setText(String.valueOf(employeeData.getEmail()));
			addEmployee_gender.setPromptText(employeeData.getGender());
			addEmployee_arriveDate.setPromptText(employeeData.getArriveDate().toString());
			addEmployee_address.setText(String.valueOf(employeeData.getAddress()));

			String uri = "file:" + employeeData.getEmployeeImage();
			image = new Image(uri, 101, 127, false, true);
			addEmployee_image.setImage(image);
		}
	}

//---------------------------------------------------------------------------------------------	

//	// CRUD CUSTOMERS

	public void addCustomerAdd() {

		Date date = new Date(0);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		String sql = "INSERT INTO customer (fullname, email, gender, phone_number, arrive_date, status) VALUES(?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String fullname = addCustomer_fullname.getText().trim();
			String email = addCustomer_email.getText().trim();
			String gender = (String) addCustomer_gender.getSelectionModel().getSelectedItem();
			String phone = addCustomer_phone.getText().trim();
			LocalDate arriveDate = addCustomer_arriveDate.getValue();
			String status = (String) addCustomer_status.getSelectionModel().getSelectedItem();

			if (fullname.isEmpty() || email.isEmpty() || gender == null || phone.isEmpty() || arriveDate == null
					|| status == null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all fields");
				alert.showAndWait();
			} else {
				if (!isValidEmail(email)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid email format");
					alert.showAndWait();
				} else if (!isValidPhoneNumber(phone)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid phone number format");
					alert.showAndWait();
				} else {
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, fullname);
					prepare.setString(2, email);
					prepare.setString(3, gender);
					prepare.setString(4, phone);
					prepare.setDate(5, java.sql.Date.valueOf(arriveDate));
					prepare.setString(6, status);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addCustomerShowListData();
					addCustomerReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
		return email.matches(emailRegex);
	}

	private boolean isValidPhoneNumber(String phone) {
		String phoneRegex = "^[0-9]{10}$";
		return phone.matches(phoneRegex);
	}

	public void addCustomerUpdate() {
		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();

		if (customerData != null) {
			int customerID = customerData.getCustomerID();

			String sql = "UPDATE customer SET fullname = ?, email = ?, gender = ?, phone_number = ?, arrive_date = ?, status = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String fullname = addCustomer_fullname.getText().trim();
				String email = addCustomer_email.getText().trim();
				String gender = (String) addCustomer_gender.getSelectionModel().getSelectedItem();
				String phone = addCustomer_phone.getText().trim();
				LocalDate arriveDate = addCustomer_arriveDate.getValue();
				String status = (String) addCustomer_status.getSelectionModel().getSelectedItem();

				if (fullname.isEmpty() && email.isEmpty() && gender == null && phone.isEmpty() && arriveDate == null
						&& status == null) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all blank fields");
					alert.showAndWait();
				} else {
					if (!isValidEmail(email)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid email format");
						alert.showAndWait();
					} else if (!isValidPhoneNumber(phone)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid phone number format");
						alert.showAndWait();
					} else {
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Message");
						alert.setHeaderText(null);
						alert.setContentText("Are you sure you want to UPDATE customer");
						Optional<ButtonType> option = alert.showAndWait();

						if (option.get() == ButtonType.OK) {
							prepare = connect.prepareStatement(sql);
							prepare.setString(1, fullname);
							prepare.setString(2, email);
							prepare.setString(3, gender);
							prepare.setString(4, phone);
							prepare.setDate(5, java.sql.Date.valueOf(arriveDate));
							prepare.setString(6, status);
							prepare.setInt(7, customerID);

							prepare.executeUpdate();

							alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Message");
							alert.setHeaderText(null);
							alert.setContentText("Successfully Updated!");
							alert.showAndWait();

							addCustomerShowListData();
							addCustomerReset();
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a customer to update.");
			alert.showAndWait();
		}
	}

	public void addCustomerDelete() {
		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();

		if (customerData != null) {
			int customerID = customerData.getCustomerID();

			String sql = "DELETE FROM customer WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, customerID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this customer?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Customer deleted successfully!");
					alert.showAndWait();

					addCustomerShowListData();
					addCustomerReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a customer to delete.");
			alert.showAndWait();
		}
	}

	public void addCustomerReset() {
		addCustomer_fullname.setText("");
		addCustomer_phone.setText("");
		addCustomer_email.setText("");
		addCustomer_arriveDate.setPromptText("");
		addCustomer_gender.getSelectionModel().clearSelection();
		addCustomer_status.getSelectionModel().clearSelection();
	}

	private String[] genderList = { "Male", "Female" };

	public void addCustomerGenderList() {
		List<String> listGender = new ArrayList<>();

		for (String data : genderList) {
			listGender.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listGender);
		addCustomer_gender.setItems(listData1);
	}

	private String[] statusList = { "The customer has returned the book", "The customer has not returned the book" };

	public void addCustomerStatusList() {
		List<String> listStatus = new ArrayList<>();

		for (String data : statusList) {
			listStatus.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listStatus);
		addCustomer_status.setItems(listData1);
	}

	public void addCustomerSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addCustomer_search.getText();

		FilteredList<CustomerData> filter = new FilteredList<>(addCustomerList, e -> true);

		filter.setPredicate(customerData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(customerData.getCustomerID()).toLowerCase().contains(searchKey)
					|| customerData.getFullName().toLowerCase().contains(searchKey)
					|| customerData.getPhoneNumber().toLowerCase().contains(searchKey)
					|| customerData.getEmail().toLowerCase().contains(searchKey)
					|| customerData.getGender().toLowerCase().contains(searchKey)
					|| customerData.getArriveDate().toString().toLowerCase().contains(searchKey)
					|| customerData.getStatus().toLowerCase().contains(searchKey);
		});

		SortedList<CustomerData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addCustomer_tableView.comparatorProperty());
		addCustomer_tableView.setItems(sortList);
	}

	public ObservableList<CustomerData> addCustomerListData() {

		ObservableList<CustomerData> listData1 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM customer";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			CustomerData customerData;

			while (result.next()) {
				customerData = new CustomerData(result.getInt("id"), result.getString("fullname"),
						result.getString("email"), result.getString("gender"), result.getString("phone_number"),
						result.getDate("arrive_date"), result.getString("status"));
				listData1.add(customerData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData1;

	}

	private ObservableList<CustomerData> addCustomerList;

	public void addCustomerShowListData() {
		addCustomerList = addCustomerListData();

		addCustomer_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		addCustomer_col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		addCustomer_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		addCustomer_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		addCustomer_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addCustomer_col_arriveDate.setCellValueFactory(new PropertyValueFactory<>("arriveDate"));
		addCustomer_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

		addCustomer_tableView.setItems(addCustomerList);
	}

	public void addCustomerSelect() {

		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();
		if (customerData != null) {
			addCustomer_fullname.setText(customerData.getFullName());
			addCustomer_phone.setText(customerData.getPhoneNumber());
			addCustomer_email.setText(customerData.getEmail());
			addCustomer_gender.setPromptText(customerData.getGender());
			addCustomer_arriveDate.setPromptText(customerData.getArriveDate().toString());
			addCustomer_status.setPromptText(customerData.getStatus());
		}

	}

//----------------------------------------------------------------------------------------------------
	// CRUD AREA

	public void addAreaAdd() {

		String sql = "INSERT INTO area (area_name) VALUES(?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String areaname = addArea_name.getText().trim();

			if (areaname.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill area name");
				alert.showAndWait();
			} else {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, areaname);

				prepare.executeUpdate();

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully Added!");
				alert.showAndWait();

				addAreaShowListData();
				addAreaReset();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAreaUpdate() {
		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();

		if (areaData != null) {
			int areaID = areaData.getAreaID();

			String sql = "UPDATE area SET area_name = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String areaname = addArea_name.getText().trim();

				if (areaname.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill area name");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE area");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, areaname);
						prepare.setInt(2, areaID);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addAreaShowListData();
						addAreaReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a area to update.");
			alert.showAndWait();
		}

	}

	public void addAreaDelete() {
		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();

		if (areaData != null) {
			int areaID = areaData.getAreaID();

			String sql = "DELETE FROM area WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, areaID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this area?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Area deleted successfully!");
					alert.showAndWait();

					addAreaShowListData();
					addAreaReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a area to delete.");
			alert.showAndWait();
		}
	}

	public void addAreaReset() {
		addArea_name.setText("");
	}

	public void addAreaSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addArea_search.getText();

		FilteredList<AreaData> filter2 = new FilteredList<>(addAreaList, e -> true);

		filter2.setPredicate(areaData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(areaData.getAreaID()).toLowerCase().contains(searchKey)
					|| areaData.getAreaName().toLowerCase().contains(searchKey);

		});

		SortedList<AreaData> sortList2 = new SortedList<>(filter2);
		sortList2.comparatorProperty().bind(addArea_tableView.comparatorProperty());
		addArea_tableView.setItems(sortList2);
	}

	public ObservableList<AreaData> addAreaListData() {

		ObservableList<AreaData> listData2 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM area";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			AreaData areaData;

			while (result.next()) {
				areaData = new AreaData(result.getInt("id"), result.getString("area_name"));
				listData2.add(areaData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData2;

	}

	private ObservableList<AreaData> addAreaList;

	public void addAreaShowListData() {
		addAreaList = addAreaListData();

		addArea_col_areaID.setCellValueFactory(new PropertyValueFactory<>("areaID"));
		addArea_col_areaName.setCellValueFactory(new PropertyValueFactory<>("areaName"));

		addArea_tableView.setItems(addAreaList);
	}

	public void addAreaSelect() {

		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();
		if (areaData != null) {
			addArea_name.setText(areaData.getAreaName());
		}

	}

	// ----------------------------------------------------------------------------------------------------
	// CRUD CATEGORY

	public void addCategoryAdd() {

		String sql = "INSERT INTO category (category_name) VALUES(?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String categoryname = addCategory_name.getText().trim();

			if (categoryname.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill category name");
				alert.showAndWait();
			} else {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, categoryname);

				prepare.executeUpdate();

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully Added!");
				alert.showAndWait();

				addCategoryShowListData();
				addCategoryReset();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCategoryUpdate() {
		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();

		if (categoryData != null) {
			int categoryID = categoryData.getCategoryID();

			String sql = "UPDATE category SET category_name = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String categoryname = addCategory_name.getText().trim();

				if (categoryname.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill category name");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE category");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, categoryname);
						prepare.setInt(2, categoryID);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addCategoryShowListData();
						addCategoryReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a category to update.");
			alert.showAndWait();
		}

	}

	public void addCategoryDelete() {
		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();

		if (categoryData != null) {
			int categoryID = categoryData.getCategoryID();

			String sql = "DELETE FROM category WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, categoryID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this category?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Category deleted successfully!");
					alert.showAndWait();

					addCategoryShowListData();
					addCategoryReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a category to delete.");
			alert.showAndWait();
		}
	}

	public void addCategoryReset() {
		addCategory_name.setText("");
	}

	public void addCategorySearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addCategory_search.getText();

		FilteredList<CategoryData> filter3 = new FilteredList<>(addCategoryList, e -> true);

		filter3.setPredicate(categoryData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(categoryData.getCategoryID()).toLowerCase().contains(searchKey)
					|| categoryData.getCategoryName().toLowerCase().contains(searchKey);

		});

		SortedList<CategoryData> sortList3 = new SortedList<>(filter3);
		sortList3.comparatorProperty().bind(addCategory_tableView.comparatorProperty());
		addCategory_tableView.setItems(sortList3);
	}

	public ObservableList<CategoryData> addCategoryListData() {

		ObservableList<CategoryData> listData3 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM category";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			CategoryData categoryData;

			while (result.next()) {
				categoryData = new CategoryData(result.getInt("id"), result.getString("category_name"));
				listData3.add(categoryData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData3;

	}

	private ObservableList<CategoryData> addCategoryList;

	public void addCategoryShowListData() {
		addCategoryList = addCategoryListData();

		addCategory_col_categoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
		addCategory_col_categoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

		addCategory_tableView.setItems(addCategoryList);
	}

	public void addCategorySelect() {

		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();
		if (categoryData != null) {
			addCategory_name.setText(categoryData.getCategoryName());
		}

	}
//------------------------------------------------------------------------------------------------------

	// LOGOUT

	@FXML
	private void Logout(ActionEvent event) throws IOException {
		Alert alert;
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to logout?");
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == ButtonType.OK) {
			Scene scene = logout.getScene();
			Stage stage = (Stage) scene.getWindow();
			stage.close();

			Parent root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));

			Scene newScene = new Scene(root);

			stage.setScene(newScene);
			stage.setTitle("Library Management");
			stage.show();
		}
	}

//-------------------------------------------------------------------------------------------------------

	// Switch form
	public void switchForm(ActionEvent event) {
		if (event.getSource() == home_btn) {
			home_form.setVisible(true);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);

			home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			addBook_btn.setStyle("-fx-background-color: transparent");
			addEmployee_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == addBook_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(true);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);

			addBook_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			home_btn.setStyle("-fx-background-color: transparent");
			addEmployee_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == addEmployee_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(true);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == area_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(true);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == customers_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(true);
			category_form.setVisible(false);
			pos_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == category_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(true);
			pos_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			pos_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == pos_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(true);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addBookShowListData();
		addCustomerShowListData();
		addCustomerGenderList();
		addCustomerStatusList();
		addCustomer_search.setOnKeyTyped(event -> {
			addCustomerSearch(event);
		});

		addAreaShowListData();
		addArea_search.setOnKeyTyped(event -> {
			addAreaSearch(event);
		});

		ObservableList<String> areas = getAreas();
		addBook_area.setItems(areas);

		addCategoryShowListData();
		addCategory_search.setOnKeyTyped(event -> {
			addCategorySearch(event);
		});

		ObservableList<String> categories = getCategories();
		addBook_category.setItems(categories);

		addEmployeeShowListData();
		addEmployeeGenderList();
		addEmployee_search.setOnKeyTyped(event -> {
			addEmployeeSearch(event);
		});

	}

}
