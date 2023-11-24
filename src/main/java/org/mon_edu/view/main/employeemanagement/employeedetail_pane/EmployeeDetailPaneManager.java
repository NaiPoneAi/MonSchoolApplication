package org.mon_edu.view.main.employeemanagement.employeedetail_pane;

import javafx.scene.control.Alert;
import org.mon_edu.model.Employee;
import org.mon_edu.service.employeeservice.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmployeeDetailPaneManager
{
    @Autowired
    EmployeeDetailPane employeeDetailPane;

    @Autowired
    private EmployeeServiceImpl employeeService;

    public void clearFields()
    {
        employeeDetailPane.userId.setText(null);
        employeeDetailPane.firstName.clear();
        employeeDetailPane.lastName.clear();
        employeeDetailPane.dob.getEditor().clear();
        employeeDetailPane.rbMale.setSelected(true);
        employeeDetailPane.rbFemale.setSelected(false);
        employeeDetailPane.cbRole.getSelectionModel().clearSelection();
        employeeDetailPane.email.clear();
        employeeDetailPane.password.clear();
    }

    public void saveUser()
    {
        if (validate("First Name", employeeDetailPane.firstName.getText(), "[a-zA-Z]+") &&
                validate("Last Name", employeeDetailPane.lastName.getText(), "[a-zA-Z]+") &&
                emptyValidation("DOB", employeeDetailPane.dob.getEditor().getText().isEmpty()) &&
                emptyValidation("Role", employeeDetailPane.getRole() == null))
        {

            if (employeeDetailPane.userId.getText() == null || employeeDetailPane.userId.getText() == "")
            {
                if (validate("Email", employeeDetailPane.getEmail(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+") &&
                        emptyValidation("Password", employeeDetailPane.getPassword().isEmpty()))
                {

                    Employee employee = new Employee();
                    employee.setFirstName(employeeDetailPane.getFirstName());
                    employee.setLastName(employeeDetailPane.getLastName());
                    employee.setDob(employeeDetailPane.getDob());
                    employee.setGender(employeeDetailPane.getGender());
                    employee.setRole(employeeDetailPane.getRole());
                    employee.setEmail(employeeDetailPane.getEmail());
                    employee.setPassword(employeeDetailPane.getPassword());

                    Employee newEmployee = employeeService.save(employee);

                    saveAlert(newEmployee);
                }

            } else
            {
                Employee employee = employeeService.findById(Long.parseLong(employeeDetailPane.userId.getText()));
                employee.setFirstName(employeeDetailPane.getFirstName());
                employee.setLastName(employeeDetailPane.getLastName());
                employee.setDob(employeeDetailPane.getDob());
                employee.setGender(employeeDetailPane.getGender());
                employee.setRole(employeeDetailPane.getRole());
                Employee updatedEmployee = employeeService.update(employee);
                updateAlert(updatedEmployee);
            }

            clearFields();
        }
    }

    public void refreshUserPane(Employee user)
    {
        employeeDetailPane.userId.setText(Long.toString(user.getId()));
        employeeDetailPane.firstName.setText(user.getFirstName());
        employeeDetailPane.lastName.setText(user.getLastName());
        employeeDetailPane.dob.setValue(user.getDob());
        employeeDetailPane.cbRole.getSelectionModel().select(user.getRole());

        if (user.getGender().equals("Male"))
            employeeDetailPane.rbMale.setSelected(true);
        else
            employeeDetailPane.rbFemale.setSelected(true);
    }

    /*
     * Validations
     */
    boolean validate(String field, String value, String pattern)
    {
        if (!value.isEmpty())
        {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value))
            {
                return true;
            } else
            {
                validationAlert(field, false);
                return false;
            }
        } else
        {
            validationAlert(field, true);
            return false;
        }
    }

    private boolean emptyValidation(String field, boolean empty)
    {
        if (!empty)
        {
            return true;
        } else
        {
            validationAlert(field, true);
            return false;
        }
    }

    private void validationAlert(String field, boolean empty)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        if (field.equals("Role")) alert.setContentText("Please Select " + field);
        else
        {
            if (empty) alert.setContentText("Please Enter " + field);
            else alert.setContentText("Please Enter Valid " + field);
        }
        alert.showAndWait();
    }

    private void saveAlert(Employee employee)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The user " + employee.getFirstName() + " " + employee.getLastName() + " has been created and \n" + employeeDetailPane.getGenderTitle(employee.getGender()) + " id is " + employee.getId() + ".");
        alert.showAndWait();
    }

    private void updateAlert(Employee employee)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The user " + employee.getFirstName() + " " + employee.getLastName() + " has been updated.");
        alert.showAndWait();
    }
}