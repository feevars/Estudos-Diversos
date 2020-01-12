package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	private Department entity;
	
	@FXML
	private TextField txtId;
	
	@FXML 
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnCancel;
	
	//instancia do departamento
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onBtnSaveAction() {
		System.out.println("OnBtnSaveAction");
	}
	
	@FXML
	public void onBtnCancelAction() {
		System.out.println("OnBtnCancelAction");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		//para o campo Id não aparecer como "null"
		txtId.setText(entity.getId() == null ? "" : String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

}
