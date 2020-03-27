package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import entidades.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ControladorVacinas implements Initializable {

	private Pessoa pessoa = new Pessoa();

	@FXML
	private Button btnMostrarVacinas;

	@FXML
	private CheckBox cbVHB1;

	@FXML
	private CheckBox cbVHB2;

	@FXML
	private CheckBox cbVHB3;

	@FXML
	private CheckBox cbHib1;

	@FXML
	private CheckBox cbHib2;

	@FXML
	private CheckBox cbHib3;

	@FXML
	private CheckBox cbHib4;

	@FXML
	private CheckBox cbDTPa1;

	@FXML
	private CheckBox cbDTPa2;

	@FXML
	private CheckBox cbDTPa3;

	@FXML
	private CheckBox cbDTPa4;

	@FXML
	private CheckBox cbDTPa5;

	@FXML
	private CheckBox cbVIP1;

	@FXML
	private CheckBox cbVIP2;

	@FXML
	private CheckBox cbVIP3;

	@FXML
	private CheckBox cbVIP4;

	@FXML
	private CheckBox cbVIP5;

	@FXML
	private CheckBox cbPn13_1;

	@FXML
	private CheckBox cbPn13_2;

	@FXML
	private CheckBox cbPn13_3;

	@FXML
	private CheckBox cbMenC;

	@FXML
	private CheckBox cbVASPR1;

	@FXML
	private CheckBox cbVASPR2;

	@FXML
	private CheckBox cbHPV;

	@FXML
	private CheckBox cbTdpa25;

	@FXML
	private CheckBox cbTdpa45;

	@FXML
	private CheckBox cbTd10;

	@FXML
	private CheckBox cbTd25;

	@FXML
	private CheckBox cbTd45;

	@FXML
	private CheckBox cbTd65;

	@FXML
	private CheckBox cbTd10_10;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblIdade;

	@FXML
	private Label lblSexo;

	@FXML
	private ListView<String> lvDados;

	@FXML
	private GridPane gpDados;

	@FXML
	private Button btnVoltar;

	@FXML
	public void onbtnMostrarVacinasAction() {
		lvDados.setVisible(true);
		gpDados.setVisible(true);
		atualizarLabel(pessoa.getNome(), pessoa.getIdade(), pessoa.getSexo());
		;
		if (pessoa.getIdade() >= 0) {
			cbVHB1.setSelected(true);
		}
		if (pessoa.getIdade() >= 2 && pessoa.getIdade() < 4) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
		}
		if (pessoa.getIdade() >= 4 && pessoa.getIdade() < 6) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
		}
		if (pessoa.getIdade() >= 6 && pessoa.getIdade() < 12) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
		}
		if (pessoa.getIdade() >= 12 && pessoa.getIdade() < 18) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
		}
		if (pessoa.getIdade() >= 18 && pessoa.getIdade() < 60) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
		}
		if (pessoa.getIdade() >= 60 && pessoa.getIdade() < 120) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
			cbDTPa5.setSelected(true);
			cbVIP5.setSelected(true);
			cbVASPR2.setSelected(true);
		}
		if (pessoa.getIdade() >= 120 && pessoa.getIdade() < 300) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
			cbDTPa5.setSelected(true);
			cbVIP5.setSelected(true);
			cbVASPR2.setSelected(true);
			if (pessoa.getSexo().equals("Feminino")) {
				cbHPV.setSelected(true);
			}
			cbTd10.setSelected(true);
		}
		if (pessoa.getIdade() >= 300 && pessoa.getIdade() < 540) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
			cbDTPa5.setSelected(true);
			cbVIP5.setSelected(true);
			cbVASPR2.setSelected(true);
			if (pessoa.getSexo().equals("Feminino")) {
				cbHPV.setSelected(true);
				if (pessoa.isEngravidou()) {
					cbTdpa25.setSelected(true);
				}
			}
			cbTd10.setSelected(true);
			cbTd25.setSelected(true);
		}
		if (pessoa.getIdade() >= 540 && pessoa.getIdade() < 780) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
			cbDTPa5.setSelected(true);
			cbVIP5.setSelected(true);
			cbVASPR2.setSelected(true);
			if (pessoa.getSexo().equals("Feminino")) {
				cbHPV.setSelected(true);
				if (pessoa.isEngravidou()) {
					cbTdpa25.setSelected(true);
					cbTdpa45.setSelected(true);
				}
			}
			cbTd10.setSelected(true);
			cbTd25.setSelected(true);
			cbTd45.setSelected(true);
		}
		if (pessoa.getIdade() >= 780) {
			cbVHB1.setSelected(true);
			cbVHB2.setSelected(true);
			cbHib1.setSelected(true);
			cbDTPa1.setSelected(true);
			cbVIP1.setSelected(true);
			cbPn13_1.setSelected(true);
			cbHib2.setSelected(true);
			cbDTPa2.setSelected(true);
			cbVIP2.setSelected(true);
			cbPn13_2.setSelected(true);
			cbVHB3.setSelected(true);
			cbHib3.setSelected(true);
			cbDTPa3.setSelected(true);
			cbVIP3.setSelected(true);
			cbPn13_3.setSelected(true);
			cbMenC.setSelected(true);
			cbVASPR1.setSelected(true);
			cbHib4.setSelected(true);
			cbDTPa4.setSelected(true);
			cbVIP4.setSelected(true);
			cbDTPa5.setSelected(true);
			cbVIP5.setSelected(true);
			cbVASPR2.setSelected(true);
			if (pessoa.getSexo().equals("Feminino")) {
				cbHPV.setSelected(true);
				if (pessoa.isEngravidou()) {
					cbTdpa25.setSelected(true);
					cbTdpa45.setSelected(true);
				}
			}
			cbTd10.setSelected(true);
			cbTd25.setSelected(true);
			cbTd45.setSelected(true);
			cbTd65.setSelected(true);
			cbTd10_10.setSelected(true);
		}
	}

	public void atualizarNome(String nome) {
		this.pessoa.setNome(nome);
	}

	public void atualizarIdade(Integer idade) {
		this.pessoa.setIdade(idade);
	}

	public void atualizarSexo(String sexo) {
		this.pessoa.setSexo(sexo);
	}

	public void atualizarEngravidou(boolean engravidou) {
		this.pessoa.setEngravidou(engravidou);
	}

	private void atualizarLabel(String nome, Integer idade, String sexo) {
		lblNome.setText(nome.toUpperCase().strip());
		Integer inteiro = (int) (idade / 12);
		if (idade < 12) {
			if (idade == 1) {
				lblIdade.setText(idade.toString() + " mês");
			} else
				lblIdade.setText(idade.toString() + " meses");
		} else {
			if (idade >= 12 && idade < 24) {
				lblIdade.setText(inteiro.toString() + " ano");
			} else
				lblIdade.setText(inteiro.toString() + " anos");
		}
		lblSexo.setText(sexo);
	}

	public void onbtnVoltarAction() {
		loadView("/gui/MainView.fxml", x -> {});
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
