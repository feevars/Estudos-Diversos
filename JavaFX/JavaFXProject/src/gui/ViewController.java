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
import javafx.scene.control.TextField;
import model.entities.Account;

public class ViewController implements Initializable{

	@FXML
	private TextField txtDeposito;

	@FXML
	private Label labelSaldoPoupanca;

	@FXML
	private Label labelSaldoCorrente;
	
	@FXML
	private Button btDeposito;
	
	@FXML
	private ComboBox<Account> comboBoxAccountType;
	
	private ObservableList<Account> obsList;

	private double saldoCorrente;
	private double saldoPoupanca;
	
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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtDeposito);
		Constraints.setTextFieldMaxLength(txtDeposito, 10);
		
		List<Account> list = new ArrayList<>();
		list.add(new Account("Poupança"));
		list.add(new Account("Conta Corrente"));
		
		obsList = FXCollections.observableArrayList(list);
		comboBoxAccountType.setItems(obsList);
	}
}
