import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * main class of programme
 * @author colonel_dzik
 */
public class Main extends Application {
    Buffer buf=new Buffer();
    MainThread mt=new MainThread();

    /**
     * main method of javafx app
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FlowPane root = new FlowPane();
            root.setOrientation(Orientation.VERTICAL);
            Scene scene = new Scene(root,200,100);
            primaryStage.setTitle("Main Thread");
            primaryStage.setScene(scene);
            primaryStage.show();
            Button prod=new Button("Create a producer");
            Button cons=new Button("Create a consumer");
            Button state=new Button("Current state");

            prod.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    mt.makeProducer(buf);
                    Stage stage1=new Stage();
                    stage1.initModality(Modality.NONE);
                    StackPane root1 = new StackPane();
                    root1.setAlignment(Pos.CENTER);
                    Scene scene1 = new Scene(root1,200,100);
                    stage1.setTitle("Producer");
                    stage1.setScene(scene1);
                    stage1.show();
                    Button prod1=new Button("produce");
                    prod1.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            if(mt.getProducers()[mt.getCountProd()].Produce()==1){
                                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                                alert.setTitle ("ERROR");
                                alert.setHeaderText(null);
                                alert.setContentText("Буфер полон");
                                alert.showAndWait();
                            }
                        }
                    });
                    root1.getChildren().add(prod1);
                }
            });

            cons.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    mt.makeConsumer(buf);
                    Stage stage2=new Stage();
                    stage2.initModality(Modality.NONE);
                    StackPane root2 = new StackPane();
                    root2.setAlignment(Pos.CENTER);
                    Scene scene2 = new Scene(root2,200,100);
                    stage2.setTitle("Consumer");
                    stage2.setScene(scene2);
                    stage2.show();
                    Button cons2=new Button("consume");
                    cons2.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {

                            if(mt.getConsumers()[mt.getCountCons()].Consume()!=0){
                                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                                alert.setTitle ("ERROR");
                                alert.setHeaderText(null);
                                alert.setContentText("Буфер пуст");
                                alert.showAndWait();
                            }
                        }
                    });

                    root2.getChildren().add(cons2);
                }
            });

            state.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle ("State");
                    alert.setHeaderText(null);
                    alert.setContentText(Integer.toString(buf.getCounter()));
                    alert.showAndWait();
                    }
            });
            root.getChildren().addAll(prod, cons, state);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * method main which launch javafx app
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

