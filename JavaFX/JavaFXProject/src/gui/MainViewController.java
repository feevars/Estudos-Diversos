package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sql.rowset.spi.SyncResolver;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

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
		loadView("/gui/DepartmentList.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
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
	
	private synchronized void loadView(String absoluteName) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
