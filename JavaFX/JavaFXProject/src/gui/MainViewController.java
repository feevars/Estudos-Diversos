package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import model.entities.Account;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("OnMenuItemSellerAction");
	}
	
	@FXML
	public void OnMenuItemDepartmentAction() {
		System.out.println("OnMenuItemDepartmentAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("OnMenuItemAboutAction");
	}
	
	/*
	@FXML
	public void onButtonDepositAction() {
		try {
			Locale.setDefault(Locale.US);
			double deposito = Double.parseDouble(txtDeposito.getText());

			if (comboBoxAccountType.equals("Poupança")) {
				saldoPoupanca += deposito;
			} else {
				saldoCorrente += deposito;
			}
			
			labelSaldoCorrente.setText(String.format("%.2f", saldoCorrente));
			labelSaldoPoupanca.setText(String.format("%.2f", saldoPoupanca));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), 
					AlertType.ERROR);
		}
	}
	*/

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		/*
		Constraints.setTextFieldDouble(txtDeposito);
		Constraints.setTextFieldMaxLength(txtDeposito, 10);
		
		List<Account> list = new ArrayList<>();
		list.add(new Account("Poupança"));
		list.add(new Account("Conta Corrente"));
		
		obsList = FXCollections.observableArrayList(list);
		comboBoxAccountType.setItems(obsList);
	*/}
}
