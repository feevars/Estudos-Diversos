package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
	private TextField txtDeposito;

	@FXML
	private Label labelSaldo;

	@FXML
	private Button btDeposito;

	@FXML
	private Button btTest;

	private double saldo;

	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			double deposito = Double.parseDouble(txtDeposito.getText());

			saldo += deposito;
			labelSaldo.setText(String.format("%.2f", saldo));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
}
