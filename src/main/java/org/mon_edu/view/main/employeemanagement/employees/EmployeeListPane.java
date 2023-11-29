package org.mon_edu.view.main.employeemanagement.employees;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.model.Employee;
import org.mon_edu.model.User;
import org.mon_edu.view.StageManager;
import org.mon_edu.view.login.LoginPane;
import org.mon_edu.view.main.employeemanagement.employeedetail_pane.EmployeeDetailPaneManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class EmployeeListPane implements Initializable {
    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private EmployeeListPaneManager employeeListPaneManager;
    @Autowired
    private EmployeeDetailPaneManager employeeDetailPaneManager;

    final ObservableList<Employee> employeeList= FXCollections.observableArrayList();
    @FXML
    Button btnLogout;
    @FXML
    TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee,Long> colUserId;
    @FXML
    private TableColumn<Employee, String> colFirstName;
    @FXML
    private TableColumn<Employee, String> colLastName;
    @FXML
    private TableColumn<Employee, LocalDate> colDOB;
    @FXML
    private TableColumn<Employee, String> colGender;
    @FXML
    private TableColumn<Employee, String> colRole;
    @FXML
    private TableColumn<Employee, String> colEmail;
    @FXML
    private TableColumn<Employee, Boolean> colEdit;

    @FXML
    private MenuItem deleteUsers;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //set column properties
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEdit.setCellFactory(new TableColumnTableCellCallback());
        employeeListPaneManager.loadUserDetails();
        btnLogout.setOnAction(event -> stageManager.rebuildStage(LoginPane.class));
        deleteUsers.setOnAction(event -> employeeListPaneManager.deleteEmployee());

    }
    private class TableColumnTableCellCallback implements Callback<TableColumn<Employee,Boolean>,TableCell<Employee,Boolean>>{

        @Override
        public TableCell<Employee, Boolean> call(TableColumn<Employee, Boolean> param) {
            return new TableCell<>(){
                final Image imgEdit=new Image(getClass().getResourceAsStream("/images/edit.png"));
                final Button btnEdit=new Button();
                @Override
                public void updateItem(Boolean check,boolean empty){
                    super.updateItem(check,empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }else {
                        btnEdit.setOnAction(e -> employeeDetailPaneManager.refreshUserPane(getTableView().getItems().get(getIndex())));

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv=new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        btnEdit.setGraphic(iv);

                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }
            };
        }
    }
}
