package kurs.java.fx.example.binding.properties.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import kurs.java.fx.example.binding.properties.model.PersonalViewModel;

public class PersonViewController {

	@FXML
	private TextField nameTextField;
	
	@FXML
	private Label nameOkLabel;
	
	@FXML
	private TextField surnameTextField;
	
	@FXML
	private Label surnameOkLabel;
	
	@FXML
	private TextField yearTextField;
	
	@FXML
	private Label ageLabel;
	
	@FXML
	private CheckBox confirmCheckBox;
	
	@FXML
	private Button logginButton;
	
	private PersonalViewModel personView = new PersonalViewModel();
	
	@FXML
	public void initialize() {
		nameTextField.textProperty().bindBidirectional(personView.getNameProperty());
		surnameTextField.textProperty().bindBidirectional(personView.getSurnameProperty());
		surnameTextField.disableProperty().bind(personView.getDisableSurnameProperty());
		
		StringConverter conventer = new NumberStringConverter();
		yearTextField.textProperty().bindBidirectional(personView.getYearProperty(), conventer);
		
		yearTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("oldValue: " + oldValue);
				System.out.println("newValue: " + newValue);
			}
		});
		
		confirmCheckBox.selectedProperty().bind(personView.getConfirmProperty());
		ageLabel.textProperty().bindBidirectional(personView.getAgeProperty());
		
		nameOkLabel.visibleProperty().bind(personView.getNameOkProperty());
		surnameOkLabel.visibleProperty().bind(personView.getSurnameOkProperty());
		
		logginButton.disableProperty().bind(personView.getDisableButtonProperty());
	}

}