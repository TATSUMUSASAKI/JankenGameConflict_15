//JankenView .java
package janken;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JankenView extends Application {

  private Label cpuLabel;
 private Label humanLabel;
 private Label resultLabel;

 private Label  scoreLabel;

 private Button guButton;
 private Button cyokiButton;
 private Button paButton;

 private JankenController jc;//じゃんけん制御オブジェクト変数

  @Override
 public void start(Stage stage) throws Exception {
   stage.setTitle("じゃんけんゲーム");
   stage.setWidth(450);
   stage.setHeight(300);

  myLayout(stage);

   stage.show();

 //じゃんけん制御クラスのインスタンス
 jc = new JankenController(cpuLabel, humanLabel, resultLabel,scoreLabel);
 //イベント処理
 guButton.setOnAction(event -> jc.putOutRockHand());
 cyokiButton.setOnAction(evet -> jc.putOutScissorsHand());
 paButton.setOnAction(evet -> jc.putOutPaperHand());
 }


 //画面に表示するGUI部品の基本的な設定
 private void myLayout(Stage stage) {
  Font font = new Font("MS ゴシック", 20);

  guButton = new Button("グー");
  guButton.setPrefSize(100, 20);
  guButton.setFont(font);

  cyokiButton = new Button("チョキ");
  cyokiButton.setPrefSize(100, 20);
  cyokiButton.setFont(font);

  paButton = new Button("パー");
  paButton.setPrefSize(100, 20);
  paButton.setFont(font);

  cpuLabel = new Label("コンピュータの手:-");
  cpuLabel.setFont(font);
  humanLabel = new Label("あなたの手:-");
  humanLabel.setFont(font);
  resultLabel = new Label("じゃんけん結果:-");
  resultLabel.setFont(font);



  //HBox:水平方向に配置レイアウト
  HBox hbox = new HBox();
  //hboxの配置位置
  hbox.setAlignment(Pos.CENTER);

  //HBOXと周囲のコントロールとの隙間
  hbox.setPadding(new Insets(10, 10, 10, 10));
  //hboxに配置するコントロールの隙間
  hbox.setSpacing(10);
  //hboxにコントロールを設
  hbox.getChildren().addAll(guButton, cyokiButton, paButton);

  //VBox：垂直方向に配置するレイアウト
  VBox vbox = new VBox();
  //vboxの配置位置
  vbox.setAlignment(Pos.CENTER);
  //vboxに配置するコントロールの隙間
  vbox.setSpacing(8);
  //vboxにコントロールを設置
  vbox.getChildren().addAll(cpuLabel, humanLabel, resultLabel, hbox);

   scoreLabel = new Label("");
  scoreLabel.setFont(font);
  vbox.getChildren().add(scoreLabel);

  Scene scene = new Scene(vbox);
  stage.setScene(scene);
}

public static void main(String[] args) {
  launch();
 }

}