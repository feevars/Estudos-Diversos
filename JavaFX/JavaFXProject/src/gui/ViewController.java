package gui;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
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
	private Label labelSaldoDeposito;
	
	@FXML
	private Button btDeposito;
	
	@FXML
	private ComboBox<Account> comboBoxAccount;
	
	private ObservableList<Account> obsList;

	private double saldoContaCorrente;
	private double saldoPoupanca;

	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			double deposito = Double.parseDouble(txtDeposito.getText());

			saldo += deposito;
			labelSaldo.setText(String.format("%.2f", saldo));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), 
					AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtDeposito);
		Constraints.setTextFieldMaxLength(txtDeposito, 10);
		
		List<Account> list = new Arraylist<>();
		
	}
}
