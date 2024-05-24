package Controller;

import Model.Cards.CardJSON;
import Model.Cards.RandomCardFile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class GameBoard {


    @FXML
    private ImageView CenterDown1;

    @FXML
    private ImageView CenterDown10;

    @FXML
    private ImageView CenterDown11;

    @FXML
    private ImageView CenterDown12;

    @FXML
    private ImageView CenterDown13;

    @FXML
    private ImageView CenterDown14;

    @FXML
    private ImageView CenterDown15;

    @FXML
    private ImageView CenterDown16;

    @FXML
    private ImageView CenterDown17;

    @FXML
    private ImageView CenterDown18;

    @FXML
    private ImageView CenterDown19;

    @FXML
    private ImageView CenterDown2;

    @FXML
    private ImageView CenterDown20;

    @FXML
    private ImageView CenterDown21;

    @FXML
    private ImageView CenterDown22;

    @FXML
    private ImageView CenterDown23;

    @FXML
    private ImageView CenterDown24;

    @FXML
    private ImageView CenterDown25;

    @FXML
    private ImageView CenterDown26;

    @FXML
    private ImageView CenterDown27;

    @FXML
    private ImageView CenterDown28;

    @FXML
    private ImageView CenterDown29;

    @FXML
    private ImageView CenterDown3;

    @FXML
    private ImageView CenterDown30;

    @FXML
    private ImageView CenterDown31;

    @FXML
    private ImageView CenterDown32;

    @FXML
    private ImageView CenterDown33;

    @FXML
    private ImageView CenterDown34;

    @FXML
    private ImageView CenterDown35;

    @FXML
    private ImageView CenterDown36;

    @FXML
    private ImageView CenterDown37;

    @FXML
    private ImageView CenterDown38;

    @FXML
    private ImageView CenterDown39;

    @FXML
    private ImageView CenterDown4;

    @FXML
    private ImageView CenterDown40;

    @FXML
    private ImageView CenterDown41;

    @FXML
    private ImageView CenterDown42;

    @FXML
    private ImageView CenterDown43;

    @FXML
    private ImageView CenterDown44;

    @FXML
    private ImageView CenterDown45;

    @FXML
    private ImageView CenterDown46;

    @FXML
    private ImageView CenterDown47;

    @FXML
    private ImageView CenterDown48;

    @FXML
    private ImageView CenterDown49;

    @FXML
    private ImageView CenterDown5;

    @FXML
    private ImageView CenterDown50;

    @FXML
    private ImageView CenterDown51;

    @FXML
    private ImageView CenterDown52;

    @FXML
    private ImageView CenterDown53;

    @FXML
    private ImageView CenterDown54;

    @FXML
    private ImageView CenterDown55;

    @FXML
    private ImageView CenterDown6;

    @FXML
    private ImageView CenterDown7;

    @FXML
    private ImageView CenterDown8;

    @FXML
    private ImageView CenterDown9;

    @FXML
    private ImageView CenterLeft1;

    @FXML
    private ImageView CenterLeft10;

    @FXML
    private ImageView CenterLeft11;

    @FXML
    private ImageView CenterLeft12;

    @FXML
    private ImageView CenterLeft13;

    @FXML
    private ImageView CenterLeft14;

    @FXML
    private ImageView CenterLeft15;

    @FXML
    private ImageView CenterLeft16;

    @FXML
    private ImageView CenterLeft17;

    @FXML
    private ImageView CenterLeft18;

    @FXML
    private ImageView CenterLeft19;

    @FXML
    private ImageView CenterLeft2;

    @FXML
    private ImageView CenterLeft20;

    @FXML
    private ImageView CenterLeft21;

    @FXML
    private ImageView CenterLeft22;

    @FXML
    private ImageView CenterLeft23;

    @FXML
    private ImageView CenterLeft24;

    @FXML
    private ImageView CenterLeft25;

    @FXML
    private ImageView CenterLeft26;

    @FXML
    private ImageView CenterLeft27;

    @FXML
    private ImageView CenterLeft28;

    @FXML
    private ImageView CenterLeft29;

    @FXML
    private ImageView CenterLeft3;

    @FXML
    private ImageView CenterLeft30;

    @FXML
    private ImageView CenterLeft31;

    @FXML
    private ImageView CenterLeft32;

    @FXML
    private ImageView CenterLeft33;

    @FXML
    private ImageView CenterLeft34;

    @FXML
    private ImageView CenterLeft35;

    @FXML
    private ImageView CenterLeft36;

    @FXML
    private ImageView CenterLeft37;

    @FXML
    private ImageView CenterLeft38;

    @FXML
    private ImageView CenterLeft39;

    @FXML
    private ImageView CenterLeft4;

    @FXML
    private ImageView CenterLeft40;

    @FXML
    private ImageView CenterLeft41;

    @FXML
    private ImageView CenterLeft42;

    @FXML
    private ImageView CenterLeft43;

    @FXML
    private ImageView CenterLeft44;

    @FXML
    private ImageView CenterLeft45;

    @FXML
    private ImageView CenterLeft46;

    @FXML
    private ImageView CenterLeft47;

    @FXML
    private ImageView CenterLeft48;

    @FXML
    private ImageView CenterLeft49;

    @FXML
    private ImageView CenterLeft5;

    @FXML
    private ImageView CenterLeft50;

    @FXML
    private ImageView CenterLeft51;

    @FXML
    private ImageView CenterLeft52;

    @FXML
    private ImageView CenterLeft53;

    @FXML
    private ImageView CenterLeft54;

    @FXML
    private ImageView CenterLeft55;

    @FXML
    private ImageView CenterLeft6;

    @FXML
    private ImageView CenterLeft7;

    @FXML
    private ImageView CenterLeft8;

    @FXML
    private ImageView CenterLeft9;

    @FXML
    private ImageView CenterRight1;

    @FXML
    private ImageView CenterRight10;

    @FXML
    private ImageView CenterRight11;

    @FXML
    private ImageView CenterRight12;

    @FXML
    private ImageView CenterRight13;

    @FXML
    private ImageView CenterRight14;

    @FXML
    private ImageView CenterRight15;

    @FXML
    private ImageView CenterRight16;

    @FXML
    private ImageView CenterRight17;

    @FXML
    private ImageView CenterRight18;

    @FXML
    private ImageView CenterRight19;

    @FXML
    private ImageView CenterRight2;

    @FXML
    private ImageView CenterRight20;

    @FXML
    private ImageView CenterRight21;

    @FXML
    private ImageView CenterRight22;

    @FXML
    private ImageView CenterRight23;

    @FXML
    private ImageView CenterRight24;

    @FXML
    private ImageView CenterRight25;

    @FXML
    private ImageView CenterRight26;

    @FXML
    private ImageView CenterRight27;

    @FXML
    private ImageView CenterRight28;

    @FXML
    private ImageView CenterRight29;

    @FXML
    private ImageView CenterRight3;

    @FXML
    private ImageView CenterRight30;

    @FXML
    private ImageView CenterRight31;

    @FXML
    private ImageView CenterRight32;

    @FXML
    private ImageView CenterRight33;

    @FXML
    private ImageView CenterRight34;

    @FXML
    private ImageView CenterRight35;

    @FXML
    private ImageView CenterRight36;

    @FXML
    private ImageView CenterRight37;

    @FXML
    private ImageView CenterRight38;

    @FXML
    private ImageView CenterRight39;

    @FXML
    private ImageView CenterRight4;

    @FXML
    private ImageView CenterRight40;

    @FXML
    private ImageView CenterRight41;

    @FXML
    private ImageView CenterRight42;

    @FXML
    private ImageView CenterRight43;

    @FXML
    private ImageView CenterRight44;

    @FXML
    private ImageView CenterRight45;

    @FXML
    private ImageView CenterRight46;

    @FXML
    private ImageView CenterRight47;

    @FXML
    private ImageView CenterRight48;

    @FXML
    private ImageView CenterRight49;

    @FXML
    private ImageView CenterRight5;

    @FXML
    private ImageView CenterRight50;

    @FXML
    private ImageView CenterRight51;

    @FXML
    private ImageView CenterRight52;

    @FXML
    private ImageView CenterRight53;

    @FXML
    private ImageView CenterRight54;

    @FXML
    private ImageView CenterRight55;

    @FXML
    private ImageView CenterRight6;

    @FXML
    private ImageView CenterRight7;

    @FXML
    private ImageView CenterRight8;

    @FXML
    private ImageView CenterRight9;

    @FXML
    private ImageView CenterUp1;

    @FXML
    private ImageView CenterUp10;

    @FXML
    private ImageView CenterUp11;

    @FXML
    private ImageView CenterUp12;

    @FXML
    private ImageView CenterUp13;

    @FXML
    private ImageView CenterUp14;

    @FXML
    private ImageView CenterUp15;

    @FXML
    private ImageView CenterUp16;

    @FXML
    private ImageView CenterUp17;

    @FXML
    private ImageView CenterUp18;

    @FXML
    private ImageView CenterUp19;

    @FXML
    private ImageView CenterUp2;

    @FXML
    private ImageView CenterUp20;

    @FXML
    private ImageView CenterUp21;

    @FXML
    private ImageView CenterUp22;

    @FXML
    private ImageView CenterUp23;

    @FXML
    private ImageView CenterUp24;

    @FXML
    private ImageView CenterUp25;

    @FXML
    private ImageView CenterUp26;

    @FXML
    private ImageView CenterUp27;

    @FXML
    private ImageView CenterUp28;

    @FXML
    private ImageView CenterUp29;

    @FXML
    private ImageView CenterUp3;

    @FXML
    private ImageView CenterUp30;

    @FXML
    private ImageView CenterUp31;

    @FXML
    private ImageView CenterUp32;

    @FXML
    private ImageView CenterUp33;

    @FXML
    private ImageView CenterUp34;

    @FXML
    private ImageView CenterUp35;

    @FXML
    private ImageView CenterUp36;

    @FXML
    private ImageView CenterUp37;

    @FXML
    private ImageView CenterUp38;

    @FXML
    private ImageView CenterUp39;

    @FXML
    private ImageView CenterUp4;

    @FXML
    private ImageView CenterUp40;

    @FXML
    private ImageView CenterUp41;

    @FXML
    private ImageView CenterUp42;

    @FXML
    private ImageView CenterUp43;

    @FXML
    private ImageView CenterUp44;

    @FXML
    private ImageView CenterUp45;

    @FXML
    private ImageView CenterUp46;

    @FXML
    private ImageView CenterUp47;

    @FXML
    private ImageView CenterUp48;

    @FXML
    private ImageView CenterUp49;

    @FXML
    private ImageView CenterUp5;

    @FXML
    private ImageView CenterUp50;

    @FXML
    private ImageView CenterUp51;

    @FXML
    private ImageView CenterUp52;

    @FXML
    private ImageView CenterUp53;

    @FXML
    private ImageView CenterUp54;

    @FXML
    private ImageView CenterUp55;

    @FXML
    private ImageView CenterUp6;

    @FXML
    private ImageView CenterUp7;

    @FXML
    private ImageView CenterUp8;

    @FXML
    private ImageView CenterUp9;

    @FXML
    private ImageView CommonObj;

    @FXML
    private ImageView Down1;

    @FXML
    private ImageView Down10;

    @FXML
    private ImageView Down11;

    @FXML
    private ImageView Down12;

    @FXML
    private ImageView Down13;

    @FXML
    private ImageView Down14;

    @FXML
    private ImageView Down15;

    @FXML
    private ImageView Down16;

    @FXML
    private ImageView Down17;

    @FXML
    private ImageView Down18;

    @FXML
    private ImageView Down19;

    @FXML
    private ImageView Down2;

    @FXML
    private ImageView Down20;

    @FXML
    private ImageView Down21;

    @FXML
    private ImageView Down22;

    @FXML
    private ImageView Down23;

    @FXML
    private ImageView Down24;

    @FXML
    private ImageView Down25;

    @FXML
    private ImageView Down26;

    @FXML
    private ImageView Down27;

    @FXML
    private ImageView Down28;

    @FXML
    private ImageView Down29;

    @FXML
    private ImageView Down3;

    @FXML
    private ImageView Down30;

    @FXML
    private ImageView Down31;

    @FXML
    private ImageView Down32;

    @FXML
    private ImageView Down33;

    @FXML
    private ImageView Down34;

    @FXML
    private ImageView Down35;

    @FXML
    private ImageView Down36;

    @FXML
    private ImageView Down37;

    @FXML
    private ImageView Down38;

    @FXML
    private ImageView Down39;

    @FXML
    private ImageView Down4;

    @FXML
    private ImageView Down40;

    @FXML
    private ImageView Down5;

    @FXML
    private ImageView Down6;

    @FXML
    private ImageView Down7;

    @FXML
    private ImageView Down8;

    @FXML
    private ImageView Down9;

    @FXML
    private ImageView GoldDeck;

    @FXML
    private ImageView Left1;

    @FXML
    private ImageView Left10;

    @FXML
    private ImageView Left11;

    @FXML
    private ImageView Left12;

    @FXML
    private ImageView Left13;

    @FXML
    private ImageView Left14;

    @FXML
    private ImageView Left15;

    @FXML
    private ImageView Left16;

    @FXML
    private ImageView Left17;

    @FXML
    private ImageView Left18;

    @FXML
    private ImageView Left19;

    @FXML
    private ImageView Left2;

    @FXML
    private ImageView Left20;

    @FXML
    private ImageView Left21;

    @FXML
    private ImageView Left22;

    @FXML
    private ImageView Left23;

    @FXML
    private ImageView Left24;

    @FXML
    private ImageView Left25;

    @FXML
    private ImageView Left26;

    @FXML
    private ImageView Left27;

    @FXML
    private ImageView Left28;

    @FXML
    private ImageView Left29;

    @FXML
    private ImageView Left3;

    @FXML
    private ImageView Left30;

    @FXML
    private ImageView Left31;

    @FXML
    private ImageView Left32;

    @FXML
    private ImageView Left33;

    @FXML
    private ImageView Left34;

    @FXML
    private ImageView Left35;

    @FXML
    private ImageView Left36;

    @FXML
    private ImageView Left37;

    @FXML
    private ImageView Left38;

    @FXML
    private ImageView Left39;

    @FXML
    private ImageView Left4;

    @FXML
    private ImageView Left40;

    @FXML
    private ImageView Left5;

    @FXML
    private ImageView Left6;

    @FXML
    private ImageView Left7;

    @FXML
    private ImageView Left8;

    @FXML
    private ImageView Left9;

    @FXML
    private ImageView PersonalObj;

    @FXML
    private ImageView ResDeck;

    @FXML
    private ImageView Right1;

    @FXML
    private ImageView Right10;

    @FXML
    private ImageView Right11;

    @FXML
    private ImageView Right12;

    @FXML
    private ImageView Right13;

    @FXML
    private ImageView Right14;

    @FXML
    private ImageView Right15;

    @FXML
    private ImageView Right16;

    @FXML
    private ImageView Right17;

    @FXML
    private ImageView Right18;

    @FXML
    private ImageView Right19;

    @FXML
    private ImageView Right2;

    @FXML
    private ImageView Right20;

    @FXML
    private ImageView Right21;

    @FXML
    private ImageView Right22;

    @FXML
    private ImageView Right23;

    @FXML
    private ImageView Right24;

    @FXML
    private ImageView Right25;

    @FXML
    private ImageView Right26;

    @FXML
    private ImageView Right27;

    @FXML
    private ImageView Right28;

    @FXML
    private ImageView Right29;

    @FXML
    private ImageView Right3;

    @FXML
    private ImageView Right30;

    @FXML
    private ImageView Right31;

    @FXML
    private ImageView Right32;

    @FXML
    private ImageView Right33;

    @FXML
    private ImageView Right34;

    @FXML
    private ImageView Right35;

    @FXML
    private ImageView Right36;

    @FXML
    private ImageView Right37;

    @FXML
    private ImageView Right38;

    @FXML
    private ImageView Right39;

    @FXML
    private ImageView Right4;

    @FXML
    private ImageView Right40;

    @FXML
    private ImageView Right5;

    @FXML
    private ImageView Right6;

    @FXML
    private ImageView Right7;

    @FXML
    private ImageView Right8;

    @FXML
    private ImageView Right9;

    @FXML
    private ImageView StartingCard;

    @FXML
    private ImageView Up1;

    @FXML
    private ImageView Up10;

    @FXML
    private ImageView Up11;

    @FXML
    private ImageView Up12;

    @FXML
    private ImageView Up13;

    @FXML
    private ImageView Up14;

    @FXML
    private ImageView Up15;

    @FXML
    private ImageView Up16;

    @FXML
    private ImageView Up17;

    @FXML
    private ImageView Up18;

    @FXML
    private ImageView Up19;

    @FXML
    private ImageView Up2;

    @FXML
    private ImageView Up20;

    @FXML
    private ImageView Up21;

    @FXML
    private ImageView Up22;

    @FXML
    private ImageView Up23;

    @FXML
    private ImageView Up24;

    @FXML
    private ImageView Up25;

    @FXML
    private ImageView Up26;

    @FXML
    private ImageView Up27;

    @FXML
    private ImageView Up28;

    @FXML
    private ImageView Up29;

    @FXML
    private ImageView Up3;

    @FXML
    private ImageView Up30;

    @FXML
    private ImageView Up31;

    @FXML
    private ImageView Up32;

    @FXML
    private ImageView Up33;

    @FXML
    private ImageView Up34;

    @FXML
    private ImageView Up35;

    @FXML
    private ImageView Up36;

    @FXML
    private ImageView Up37;

    @FXML
    private ImageView Up38;

    @FXML
    private ImageView Up39;

    @FXML
    private ImageView Up4;

    @FXML
    private ImageView Up40;

    @FXML
    private ImageView Up5;

    @FXML
    private ImageView Up6;

    @FXML
    private ImageView Up7;

    @FXML
    private ImageView Up8;

    @FXML
    private ImageView Up9;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView CardHand1;

    @FXML
    private ImageView ResDeck3;

    @FXML
    private ImageView CardHand2;

    @FXML
    private ImageView CardHand3;
    

    @FXML
    private AnchorPane commonBoardDecksContainer;

    @FXML
    private ImageView commonBoardIMG;

    @FXML
    private Text commonGoalText;

    @FXML
    private ImageView handBg;
    @FXML
    private Pane allContainer;
    @FXML
    private AnchorPane handContainer;

    @FXML
    private ImageView objbackground;
    @FXML
    private ImageView GoldDeck1;
    @FXML
    private ImageView GoldDeck2;

    @FXML
    private ImageView ResDeck2;


    @FXML
    private AnchorPane personalBoardContainer;

    @FXML
    private ScrollPane personalBoardScroll;

    @FXML
    private Text personalGoalText;

    @FXML
    private Button showBtn;


    private double scaleValue = 1.0;

    public static String url1 = RandomCardFile.getRandomGXXFileName() ;

    public static String url2 = RandomCardFile.getRandomXXFileName();

    public static String url3 = RandomCardFile.getRandomXXFileName();


    public static String StartUrl = RandomCardFile.getRandomSXXFileName();

    FlippableMaker flippableMaker = new FlippableMaker();

    public static List<ImageView> DecksList;
    public static List<ImageView> imageViewList;

    @FXML
    private ImageView copy;
    public AnchorPane getAnchorPane() {
        return personalBoardContainer;
    }
    @FXML
    public void showBoardandCards(MouseEvent event) {
        if ((event.getButton() == MouseButton.PRIMARY || event.getButton() == MouseButton.SECONDARY)  && commonBoardDecksContainer.getPrefWidth() == 0){ // Only expand if it's collapsed
            commonBoardDecksContainer.setPrefWidth(800.0d);
            //System.out.println("Creating action for right click");
            commonBoardDecksContainer.translateXProperty().set(-1 * 800.0d);
            var keyValue = new KeyValue(commonBoardDecksContainer.translateXProperty(), 0, Interpolator.EASE_IN);
            var keyFrame = new KeyFrame(Duration.millis(900), keyValue);
            showBtn.translateXProperty().set(-1 * 800.0d);
            var keyValueBtn = new KeyValue(showBtn.translateXProperty(), 0, Interpolator.EASE_IN);
            var keyFrameBtn = new KeyFrame(Duration.millis(900), keyValueBtn);
            var timeline = new Timeline(keyFrameBtn, keyFrame);
            timeline.play();
            commonBoardDecksContainer.setLayoutX(0);
            showBtn.setLayoutX(655);
            showBtn.setText("<");
            commonBoardIMG.setVisible(true);
            ResDeck.setVisible(true);
            GoldDeck.setVisible(true);
            commonBoardIMG.setFitWidth(220);
            ResDeck.setFitWidth(215);
            GoldDeck.setFitWidth(215);
            //System.out.println("Right" + commonBoardDecksContainer.getPrefWidth());
        } else if((event.getButton() == MouseButton.PRIMARY || event.getButton() == MouseButton.SECONDARY)  && commonBoardDecksContainer.getPrefWidth() == 800){
            dismissTop();
        }
    }
    private void dismissTop() {
        //System.out.println("Left click detected");
         // Only collapse if it's expanded
            //System.out.println("Creating action for left click");
            commonBoardDecksContainer.translateXProperty().set(0.0d);
            var keyValue = new KeyValue(commonBoardDecksContainer.translateXProperty(), -650, Interpolator.EASE_IN);
            var keyFrame = new KeyFrame(Duration.millis(900), keyValue);
            var timeline = new Timeline(keyFrame);
            timeline.play();
            commonBoardDecksContainer.setLayoutX(-1 * 650);
            showBtn.setLayoutX(0);
            showBtn.setText(">");
            commonBoardIMG.setVisible(false);
            ResDeck.setVisible(false);
            GoldDeck.setVisible(false);
            commonBoardIMG.setFitWidth(0);
            ResDeck.setFitWidth(0);
            GoldDeck.setFitWidth(0);
            personalBoardScroll.setPrefWidth(1400);
            personalBoardContainer.setPrefWidth(4000);
            personalBoardScroll.pannableProperty();
        commonBoardDecksContainer.setPrefWidth(0.0d);
        //System.out.println("Left" + commonBoardDecksContainer.getPrefWidth());
    }
    @FXML
    void initialize() throws IOException {

        DraggableMaker draggableMaker = new DraggableMaker(this);
        CardPicker cardPicker = new CardPicker(this);

        DecksList = Arrays.asList(
                ResDeck, ResDeck2, ResDeck3, GoldDeck, GoldDeck1, GoldDeck2
        );

        imageViewList = Arrays.asList(
                StartingCard ,Right1, Up1, Left1, Down1, Down2, Right2, Up2, Left2, Down3, Down4,
                Down5, Down6, Down7, Down8, Down9, Down10, Down11, Down12, Down13, Down14,
                Down15, Down16, Down17, Down18, Down19, Down20, Down21, Down22, Down23, Down24,
                Down25, Down26, Down27, Down28, Down29, Down30, Down31, Down32, Down33, Down34,
                Down35, Down36, Down37, Down38, Down39, Down40, Right3, Right4, Right5, Right6,
                Right7, Right8, Right9, Right10, Right11, Right12, Right13, Right14, Right15, Right16,
                Right17, Right18, Right19, Right20, Right21, Right22, Right23, Right24, Right25, Right26,
                Right27, Right28, Right29, Right30, Right31, Right32, Right33, Right34, Right35, Right36,
                Right37, Right38, Right39, Right40, Up3, Up4, Up5, Up6, Up7, Up8, Up9, Up10,
                Up11, Up12, Up13, Up14, Up15, Up16, Up17, Up18, Up19, Up20, Up21, Up22,
                Up23, Up24, Up25, Up26, Up27, Up28, Up29, Up30, Up31, Up32, Up33, Up34,
                Up35, Up36, Up37, Up38, Up39, Up40, Left3, Left4, Left5, Left6, Left7,
                Left8, Left9, Left10, Left11, Left12, Left13, Left14, Left15, Left16, Left17,
                Left18, Left19, Left20, Left21, Left22, Left23, Left24, Left25, Left26, Left27,
                Left28, Left29, Left30, Left31, Left32, Left33, Left34, Left35, Left36, Left37,
                Left38, Left39, Left40, CenterDown1, CenterDown2, CenterDown3, CenterDown4, CenterDown5, CenterDown6, CenterDown7,
                CenterDown8, CenterDown9, CenterDown10, CenterDown11, CenterDown12, CenterDown13, CenterDown14, CenterDown15, CenterDown16,
                CenterDown17, CenterDown18, CenterDown19, CenterDown20, CenterDown21, CenterDown22, CenterDown23, CenterDown24, CenterDown25,
                CenterDown26, CenterDown27, CenterDown28, CenterDown29, CenterDown30, CenterDown31, CenterDown32, CenterDown33, CenterDown34,
                CenterDown35, CenterDown36, CenterDown37, CenterDown38, CenterDown39, CenterDown40, CenterRight1, CenterRight2, CenterRight3,
                CenterRight4, CenterRight5, CenterRight6, CenterRight7, CenterRight8, CenterRight9, CenterRight10, CenterRight11, CenterRight12,
                CenterRight13, CenterRight14, CenterRight15, CenterRight16, CenterRight17, CenterRight18, CenterRight19, CenterRight20, CenterRight21,
                CenterRight22, CenterRight23, CenterRight24, CenterRight25, CenterRight26, CenterRight27, CenterRight28, CenterRight29, CenterRight30,
                CenterRight31, CenterRight32, CenterRight33, CenterRight34, CenterRight35, CenterRight36, CenterRight37, CenterRight38, CenterRight39,
                CenterRight40, CenterRight41, CenterRight42, CenterRight43, CenterRight44, CenterRight45, CenterRight46, CenterRight47, CenterRight48,
                CenterRight49, CenterRight50, CenterRight51, CenterRight52, CenterRight53, CenterRight54, CenterRight55, CenterLeft1, CenterLeft2,
                CenterLeft3, CenterLeft4, CenterLeft5, CenterLeft6, CenterLeft7, CenterLeft8, CenterLeft9, CenterLeft10, CenterLeft11, CenterLeft12,
                CenterLeft13, CenterLeft14, CenterLeft15, CenterLeft16, CenterLeft17, CenterLeft18, CenterLeft19, CenterLeft20, CenterLeft21,
                CenterLeft22, CenterLeft23, CenterLeft24, CenterLeft25, CenterLeft26, CenterLeft27, CenterLeft28, CenterLeft29, CenterLeft30,
                CenterLeft31, CenterLeft32, CenterLeft33, CenterLeft34, CenterLeft35, CenterLeft36, CenterLeft37, CenterLeft38, CenterLeft39,
                CenterLeft40, CenterLeft41, CenterLeft42, CenterLeft43, CenterLeft44, CenterLeft45, CenterLeft46, CenterLeft47, CenterLeft48,
                CenterLeft49, CenterLeft50, CenterLeft51, CenterLeft52, CenterLeft53, CenterLeft54, CenterLeft55, CenterUp1, CenterUp2,
                CenterUp3, CenterUp4, CenterUp5, CenterUp6, CenterUp7, CenterUp8, CenterUp9, CenterUp10, CenterUp11, CenterUp12,
                CenterUp13, CenterUp14, CenterUp15, CenterUp16, CenterUp17, CenterUp18, CenterUp19, CenterUp20, CenterUp21, CenterUp22,
                CenterUp23, CenterUp24, CenterUp25, CenterUp26, CenterUp27, CenterUp28, CenterUp29, CenterUp30, CenterUp31, CenterUp32,
                CenterUp33, CenterUp34, CenterUp35, CenterUp36, CenterUp37, CenterUp38, CenterUp39, CenterUp40
        );

        //TODO VISUALIZE RESOURCES THAT I HAVE
        //TODO optimize useless operations
        commonBoardDecksContainer.setPrefWidth(0.0d);
        commonBoardIMG.setVisible(false);
        ResDeck.setVisible(false);
        GoldDeck.setVisible(false);
        // Handle scroll events on the ScrollPane
        /* personalBoardScroll.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.isControlDown()) {
                double deltaY = event.getDeltaY();
                final double zoomFactor = 1.4; // Consider adjusting this value
                final double minScale = 0.5; // Adjust minimum scale as needed
                final double maxScale = 2.0; // Maximum scale

                // Capture the current viewport dimensions
                double scrollHValue = personalBoardScroll.getHvalue();
                double scrollVValue = personalBoardScroll.getVvalue();
                double viewportWidth = personalBoardScroll.getViewportBounds().getWidth();
                double viewportHeight = personalBoardScroll.getViewportBounds().getHeight();
                double contentWidth = personalBoardScroll.getContent().getBoundsInLocal().getWidth();
                double contentHeight = personalBoardScroll.getContent().getBoundsInLocal().getHeight();
                double viewportCenterX = (scrollHValue * (contentWidth - viewportWidth)) + viewportWidth / 2;
                double viewportCenterY = (scrollVValue * (contentHeight - viewportHeight)) + viewportHeight / 2;

                if (deltaY < 0) {
                    scaleValue /= zoomFactor;
                } else {
                    scaleValue *= zoomFactor;
                }

                // Limit the zoom level
                scaleValue = Math.min(maxScale, Math.max(minScale, scaleValue));

                // Apply the scale transformation to the content
                personalBoardScroll.getContent().setScaleX(scaleValue);
                personalBoardScroll.getContent().setScaleY(scaleValue);

                // Adjust scroll values to keep the zoom centered
                contentWidth = personalBoardScroll.getContent().getBoundsInLocal().getWidth();
                contentHeight = personalBoardScroll.getContent().getBoundsInLocal().getHeight();
                double newScrollHValue = (viewportCenterX - viewportWidth / 2) / (contentWidth - viewportWidth);
                double newScrollVValue = (viewportCenterY - viewportHeight / 2) / (contentHeight - viewportHeight);

                personalBoardScroll.setHvalue(newScrollHValue);
                personalBoardScroll.setVvalue(newScrollVValue);

                event.consume();
            }
        });

         */


        // Set CommonBoard into the placeholder
        //System.out.println("/cards/cardsimg/" + RandomCardFile.getRandomGXXFileName());
        //System.out.println(CardHand1);
        CardHand1.setImage(new Image("/" + url1));
        CardHand2.setImage(new Image("/" + url2));
        CardHand3.setImage(new Image("/" + url3));
        //System.out.println(Down1);
        //Left1.setImage(new Image("/" + url3));
        //System.out.println(url1);

        //deserialize all the cards
        ObjectMapper boardMapper = new ObjectMapper();
        boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //System.out.println(StartUrl);
        //System.out.println(boardMapper.readValue(new File("src/main/resources/json/" + url1.replace("jpg", "json")), CardJSON.class));
        CardJSON startingCard = boardMapper.readValue(new File("src/main/resources/json/" + StartUrl.replace("jpg", "json")), CardJSON.class);
        //initialize the personal board
        BoardManager.initializeBoard(startingCard);

        CardJSON Card1 = boardMapper.readValue(new File("src/main/resources/json/" + url1.replace("jpg", "json")), CardJSON.class);
        CardJSON Card2 = boardMapper.readValue(new File("src/main/resources/json/" + url2.replace("jpg", "json")), CardJSON.class);
        CardJSON Card3 = boardMapper.readValue(new File("src/main/resources/json/" + url3.replace("jpg", "json")), CardJSON.class);

        //Here i make draggable all the cards inside my hand to make them placeable
        draggableMaker.makeDraggable(CardHand1, personalBoardScroll, 508, 650, Card1, copy, personalBoardContainer, StartUrl, imageViewList);
        draggableMaker.makeDraggable(CardHand2, personalBoardScroll, 801, 650, Card2, copy, personalBoardContainer, StartUrl, imageViewList);
        draggableMaker.makeDraggable(CardHand3, personalBoardScroll, 1064, 650, Card3, copy, personalBoardContainer, StartUrl, imageViewList);
        draggableMaker.setInitialCardPosition(StartingCard, StartingCard.localToParent(0,0));
        draggableMaker.setStartingCorners(StartingCard.localToParent(0,0), StartingCard.localToParent(0,0).subtract(-88, -46), StartingCard.localToParent(0,0).subtract(88, -46) , StartingCard.localToParent(0,0).subtract(-88, 46) , StartingCard.localToParent(0,0).subtract(88, 46) );

    //Flip the cards
        CardHand1.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url1.replace("jpg", "json")), CardJSON.class);
                    //System.out.println(card.getID());
                    //System.out.println(card.getCOLOUR());
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    //System.out.println(cardType);
                    flippableMaker.flipCard(CardHand1, cardColor, cardType, url1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        CardHand2.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url2.replace("jpg", "json")), CardJSON.class);
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    flippableMaker.flipCard(CardHand2, cardColor, cardType, url2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        CardHand3.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url3.replace("jpg", "json")), CardJSON.class);
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    flippableMaker.flipCard(CardHand3, cardColor, cardType, url3);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        CommonObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        GoldDeck.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        GoldDeck1.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        GoldDeck2.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        PersonalObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        ResDeck.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        ResDeck2.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        ResDeck3.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        StartingCard.setImage(new Image("/" + StartUrl));

        //Make the cards pickable from deck
        cardPicker.makePickable(ResDeck, DecksList);
        cardPicker.makePickable(ResDeck2, DecksList);
        cardPicker.makePickable(ResDeck3, DecksList);
        cardPicker.makePickable(GoldDeck, DecksList);
        cardPicker.makePickable(GoldDeck1, DecksList);
        cardPicker.makePickable(GoldDeck2, DecksList);


        assert CardHand1 != null : "fx:id=\"CardHand1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand2 != null : "fx:id=\"CardHand2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand3 != null : "fx:id=\"CardHand3\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CommonObj != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Down1 != null : "fx:id=\"Down1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck != null : "fx:id=\"GoldDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck1 != null : "fx:id=\"GoldDeck1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck2 != null : "fx:id=\"GoldDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Left1 != null : "fx:id=\"Left1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert PersonalObj != null : "fx:id=\"PersonalObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck != null : "fx:id=\"ResDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck2 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck3 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Right1 != null : "fx:id=\"Right1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert StartingCard != null : "fx:id=\"StartingCard\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Up1 != null : "fx:id=\"Up1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert allContainer != null : "fx:id=\"allContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonBoardDecksContainer != null : "fx:id=\"commonBoardDecksContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonBoardIMG != null : "fx:id=\"commonBoardIMG\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonGoalText != null : "fx:id=\"commonGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handBg != null : "fx:id=\"handBg\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handContainer != null : "fx:id=\"handContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert objbackground != null : "fx:id=\"objbackground\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardContainer != null : "fx:id=\"personalBoardContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardScroll != null : "fx:id=\"personalBoardScroll\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalGoalText != null : "fx:id=\"personalGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }
}
