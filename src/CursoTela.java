import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CursoTela extends Application{
  
    private TextField txtId;
	private TextField txtNome;
	private TextField txtCodCurso;
	private TextField txtNomeCoordenador;
	private TextField txtQtdAlunos;
	
	private CursoControl control = new CursoControl();

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane painel = new GridPane();
		painel.setHgap(15);
        painel.setVgap(15);

        Scene scn = new Scene(painel, 430, 250);

		
		 Label lblNome = new Label("Nome do curso:");
		 txtNome = new TextField();
         txtNome.setPrefWidth(200);
		 painel.add(lblNome, 1, 1);
		 painel.add(txtNome, 2, 1);
		 
		 Label lblId = new Label("Id do Curso:");
		 txtId = new TextField();
		 painel.add(lblId, 1, 2);
		 painel.add(txtId, 2, 2);
		 
		 Label lblCodCurso = new Label("Código do Curso:");
		 txtCodCurso = new TextField();
		 painel.add(lblCodCurso, 1, 3);
		 painel.add(txtCodCurso, 2, 3);
		 
		 Label lblNomeCoordenador = new Label("Nome do Coordenador do Curso:");
		 txtNomeCoordenador = new TextField();
		 painel.add(lblNomeCoordenador, 1, 4);
		 painel.add(txtNomeCoordenador, 2, 4);
		 
		 Label lblQtdAlunos = new Label("Quantidade de Alunos:");
		 txtQtdAlunos = new TextField();
		 painel.add(lblQtdAlunos, 1, 5);
		 painel.add(txtQtdAlunos, 2, 5);
		 
		 Button btnSalvar = new Button("Salvar");
		 painel.add(btnSalvar, 1, 6);
	     Button btnPesquisar = new Button("Pesquisar");
	     painel.add(btnPesquisar, 2, 6);
	     
	     Bindings.bindBidirectional(control.idProperty(), txtId.textProperty());
	     Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
	     Bindings.bindBidirectional(control.codCursoProperty(), txtCodCurso.textProperty());
	     Bindings.bindBidirectional(control.nomeCoordenadorProperty(), txtNomeCoordenador.textProperty());
	     Bindings.bindBidirectional(control.qtdAlunosProperty(), txtQtdAlunos.textProperty());
	     
	     btnSalvar.setOnMouseClicked( 
	             e-> { 
	                 control.salvarCurso();
	             }
	         );

	         btnPesquisar.setOnMousePressed(
	             e -> { 
	                 control.procurar();
	             }
	         );
		 
		 primaryStage.setScene(scn);
		 primaryStage.setTitle("Gestão de Cursos");
		 primaryStage.show();
		 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
    
}
