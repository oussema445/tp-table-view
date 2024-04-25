package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookControlor implements Initializable {
@FXML
private TextField tfLastName;
@FXML
private TextField tfFirstName;
@FXML
private TextField tfEmail;
@FXML
private Button addBtn;
@FXML
private Button exportBtn;
@FXML
private Button importBtn;
@FXML
private Button removeBtn;
@FXML
private Button quitBtn;
@FXML
private TableView<Person> table;
@FXML
private TableColumn<Person, String> emailCol;
@FXML
private TableColumn<Person, String> firstNameCol;
@FXML
private TableColumn<Person, String> lastNameCol;


private DataClass data;

@FXML
void add(ActionEvent event) {
    String nom = tfFirstName.getText();
    String prenom = tfLastName.getText();
    String email = tfEmail.getText();

    if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
        showAlert("Veuillez remplir tous les champs.");
        return; 
    }

    Person newPerson = new Person(nom, prenom, email);
    table.getItems().add(newPerson);

    tfFirstName.clear();
    tfLastName.clear();
    tfEmail.clear();
}






public void delete(ActionEvent event) {
	
	Person selectedPerson=table.getSelectionModel().getSelectedItem();
	
	if (selectedPerson !=null) {
		table.getItems().remove(selectedPerson);
	}
	else {
		Alert alert=new Alert (AlertType.ERROR);
		alert.setTitle("Erreur");
		alert.setHeaderText(null);
		alert.setContentText("selectionner personne!!");
		alert.showAndWait();
	}
}

public void imp(ActionEvent event) {

}
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	
	firstNameCol.setEditable(true);
    lastNameCol.setEditable(true);
    emailCol.setEditable(true);
	
	
	firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
	lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
	emailCol.setCellValueFactory(new PropertyValueFactory("email"));
	data =new DataClass();
	for(Person p:data.importList) {
		
		table.getItems().add(p);
	}
	   for (Person p:data.exportList) {
           System.out.println("Coordonnées exportées : " + p.getFirstName() + " " + p.getLastName() + ", Email : " + p.getEmail());
       }
	
}
public void closeApplication() {
    Platform.exit(); 
}
@FXML
void handleCloseButtonAction(ActionEvent event) {
    closeApplication(); // Appel de la méthode pour fermer l'application
}
private void showAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}


private boolean isValidEmailAddress(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    Pattern pattern = Pattern.compile(emailRegex);
    
    Matcher matcher = pattern.matcher(email);
    
    return matcher.matches();
}

public void addOrUpdateEmail(String email) {
    if (isValidEmailAddress(email)) {
    } else {
        showAlert("Veuillez saisir une adresse e-mail valide.");
    }
}

}