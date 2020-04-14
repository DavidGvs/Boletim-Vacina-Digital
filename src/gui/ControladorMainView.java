package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControladorMainView implements Initializable {

	@FXML
	private TextField txtNome;

	@FXML
	private DatePicker dpIdade;

	@FXML
	private RadioButton rbMasculino;

	@FXML
	private RadioButton rbFeminino;

	@FXML
	private Button btnAvancar;

	@FXML
	private Label lblErro;
	
	@FXML
	private SplitMenuButton smbGravida;
	
	@FXML
	private MenuItem miSim;
	
	@FXML
	private MenuItem miNao;
	
	@FXML
	public void onrbMasculinoSelected() {
		rbFeminino.setSelected(false);
		smbGravida.setVisible(false);
		smbGravida.setText("Já esteve grávida?");
	}

	@FXML
	public void onrbFemininoSelected() {
		rbMasculino.setSelected(false);
		smbGravida.setVisible(true);
		if (!rbFeminino.isSelected()) {
			smbGravida.setVisible(false);
			smbGravida.setText("Já esteve grávida?");
		}
	}
	
	@FXML
	public void onmiSimAction() {
		smbGravida.setText(miSim.getText());
	}
	
	@FXML
	public void onmiNaoAction() {
		smbGravida.setText(miNao.getText());
	}

	@FXML
	public void onbtnAvancarAction() {
		if (txtNome.getText().strip().equals("") || dpIdade.getValue() == null
				|| !rbMasculino.isSelected() && !rbFeminino.isSelected()) {
			lblErro.setVisible(true);
			lblErro.setText("Alguns dados não foram inseridos.\nTente Novamente!");
		} else if (rbFeminino.isSelected() && smbGravida.getText().equals("Já esteve grávida?")) {
			lblErro.setVisible(true);
			lblErro.setText("Indique se já esteve grávida!");
		} else if (dpIdade.getValue().getYear() > LocalDate.now().getYear()){
			lblErro.setVisible(true);
			lblErro.setText("A data está incorreta. \nTente Novamente!");
		} else if (dpIdade.getValue().getYear() == LocalDate.now().getYear() && dpIdade.getValue().getMonth().getValue() > LocalDate.now().getMonth().getValue()) {
			lblErro.setVisible(true);
			lblErro.setText("A data está incorreta. \nTente Novamente!");
		} else if (dpIdade.getValue().getYear() == LocalDate.now().getYear() && dpIdade.getValue().getMonth().getValue() == LocalDate.now().getMonth().getValue() && 
				dpIdade.getValue().getDayOfMonth() > LocalDate.now().getDayOfMonth()) {
			lblErro.setVisible(true);
			lblErro.setText("A data está incorreta. \nTente Novamente!");
		} else {
			lblErro.setVisible(false);
			loadView("/gui/EsquemaVacinal.fxml", (ControladorVacinas controller) -> {
				controller.atualizarNome(txtNome.getText());
				String sexo = null;
				if (rbMasculino.isSelected()) {
					sexo = rbMasculino.getText();
				} else if (rbFeminino.isSelected()) {
					sexo = rbFeminino.getText();
				}
				controller.atualizarSexo(sexo);
				Integer idade = (LocalDate.now().getYear() - dpIdade.getValue().getYear()) * 12;
				if (idade == 0) {
					idade -= (dpIdade.getValue().getMonthValue() - LocalDate.now().getMonthValue());
					if (LocalDate.now().getDayOfMonth() < dpIdade.getValue().getDayOfMonth()) {
						idade -= 1;
					}
				} else if (idade >= 12 && LocalDate.now().getMonthValue() < dpIdade.getValue().getMonthValue()) {
					idade -= (dpIdade.getValue().getMonthValue() - LocalDate.now().getMonthValue());
				} else if (idade >= 12 && LocalDate.now().getMonthValue() == dpIdade.getValue().getMonthValue()
						&& LocalDate.now().getDayOfMonth() < dpIdade.getValue().getDayOfMonth()) {
					idade -= 1;
				}
				controller.atualizarIdade(idade);
				if (smbGravida.getText().equals(miSim.getText())) {
					controller.atualizarEngravidou(true);
				} else {
					controller.atualizarEngravidou(false);
				}
			});
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	public synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			ScrollPane newScrollPane = loader.load();
			Scene mainScene = Main.getScene();
			ScrollPane mainScrollPane = (ScrollPane) mainScene.getRoot();
			AnchorPane mainAnchorPane = (AnchorPane) mainScrollPane.getContent();
			AnchorPane newAnchorPane = (AnchorPane) newScrollPane.getContent();
			mainScrollPane.setPrefHeight(newScrollPane.getPrefHeight());
			mainScrollPane.setPrefWidth(newScrollPane.getPrefWidth());
			mainAnchorPane.setPrefHeight(newAnchorPane.getPrefHeight());
			mainAnchorPane.setPrefWidth(newAnchorPane.getPrefWidth());
			mainScrollPane.setContent(newAnchorPane);
			T controller = loader.getController();
			initializingAction.accept(controller);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
