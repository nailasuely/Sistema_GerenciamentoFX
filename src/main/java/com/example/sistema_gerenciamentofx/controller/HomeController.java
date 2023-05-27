package com.example.sistema_gerenciamentofx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button btnManageClients;

    @FXML
    private Button btnManageOrders;

    @FXML
    private Button btnManageReports;

    @FXML
    private Button btnManageTec;

    @FXML
    private Button btnManagerStock;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnSignout;

    @FXML
    private VBox pnItems;

    @FXML
    private Pane pnlManageOrders;

    @FXML
    private Pane pnlManageStock;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ISSO AQUI É APENAS PARA FINS DE TESTE
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/com/example/sistema_gerenciamentofx/element-view.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #fffafa");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void handleClicks(ActionEvent event) {
            if (event.getSource() == btnManagerStock) {
                pnlManageStock.setStyle("-fx-background-color : #8228D1");
                pnlManageStock.toFront();
            }
            if (event.getSource() == btnManageOrders) {
                pnlManageOrders.setStyle("-fx-background-color : #8228D1");
                pnlManageOrders.toFront();
            }
            if (event.getSource() == btnOverview) {
                pnlOverview.setStyle("-fx-background-color : #fffafa");
                pnlOverview.toFront();
            }
            if(event.getSource() == btnManageClients)
            {
                pnlOrders.setStyle("-fx-background-color : #fffafa");
                pnlOrders.toFront();
            }
    }

    @FXML
    void showLoginStage(ActionEvent event){
        try {
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sistema_gerenciamentofx/login-view.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            Scene scene = new Scene(root);
            loginStage.setResizable(false);
            loginStage.setScene(scene);
            loginStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
}