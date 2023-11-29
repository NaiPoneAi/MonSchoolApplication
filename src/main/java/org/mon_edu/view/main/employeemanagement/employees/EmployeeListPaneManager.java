package org.mon_edu.view.main.employeemanagement.employees;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.mon_edu.model.Employee;
import org.mon_edu.service.employeeservice.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeListPaneManager {
    @Autowired
    EmployeeListPane employeeListPane;
    @Autowired
    private EmployeeServiceImpl employeeService;
    public void deleteEmployee() {
        List<Employee> employees=employeeListPane.employeeTable.getSelectionModel().getSelectedItems();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selection?");
        Optional<ButtonType> action=alert.showAndWait();

        if (action.get()==ButtonType.OK)employeeService.deleteInBatch(employees);
        loadUserDetails();
    }

    public void loadUserDetails() {
        employeeListPane.employeeList.clear();
        employeeListPane.employeeList.addAll(employeeService.findAll());
        employeeListPane.employeeTable.setItems(employeeListPane.employeeList);
    }
}
