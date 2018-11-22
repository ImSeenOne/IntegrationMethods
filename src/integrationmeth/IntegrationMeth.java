/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationmeth;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import integrationmeth.util.Util;

/**
 *
 * @author CRF
 */
public class IntegrationMeth extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("visual/main/Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        
        boolean exit = true;
        Scanner scan = new Scanner(System.in);
        
        while(exit) {
            System.out.println("¿Qué método quiere utilizar?\n\n1. Trapecio\n2. Simpson 1/3\n3. Simpson 3/8");
            int op = scan.nextInt();
            
            switch(op) {
                case 1:
                    scan.nextLine();
                    System.out.print("\n\tInserte la ecuación: ");
                    String eq = scan.nextLine();
                    
                    System.out.print("\ta: ");
                    float a = scan.nextFloat();
                    
                    System.out.print("\tb: ");
                    float b = scan.nextFloat();
                    
                    float result = Util.trapezoidalRule(a, b, eq);
                    
                    System.out.println("result: " + result);
                    break;
                default:
                    System.out.println("Inserte una opción correcta");
                    break;
            }
        }
    }
    
}
