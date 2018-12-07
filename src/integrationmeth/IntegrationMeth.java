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
        String eq;
        float a;
        float b;
        float result;
        
        while(exit) {
            System.out.println("¿Qué método quiere utilizar?\n\n1. Trapecio\n2. Simpson 1/3\n3. Simpson 3/8");
            int op = scan.nextInt();
            scan.nextLine();
            
            switch(op) {
                case 1:
                    System.out.print("\n\t\t1. Por tabulación\n\t\t2. Por expresión \n\t\tOpción: ");
                    int opti = scan.nextInt();
                    
                    scan.nextLine();
                    
                    switch(opti) {
                        
                        case 1:
                            System.out.print("Inserte a, b, f(a), f(b): ");
                            String[] tab = scan.nextLine().split(",");
                            
                            float[] resultTab = new float[4];
                            
                            for (int i = 0; i < tab.length; i++) {
                                resultTab[i] = Float.parseFloat(tab[i]);
                            }
                            
                            float resTrap = Util.trapezoidalRule(resultTab[0], resultTab[1], resultTab[2], resultTab[3]);
                            
                            System.out.println("result: " + resTrap);
                            break;
                        
                        case 2:
                            System.out.print("\n\t\tInserte la ecuación: ");
                            eq = scan.nextLine();

                            System.out.print("\ta: ");
                            a = scan.nextFloat();

                            System.out.print("\tb: ");
                            b = scan.nextFloat();

                            result = Util.trapezoidalRule(a, b, eq);

                            System.out.println("result: " + result);
                            break;
                    }
                    break;
                    
                case 2:
                    System.out.print("\n\t\t1. Por tabulación\n\t\t2. Por expresión\n\t\tOpción: ");
                    
                    int opc = scan.nextInt();
                    
                    scan.nextLine();
                    switch(opc) {
                        case 1:
                            System.out.print("\t\t\tInserte los valores separado por comas (x0,x1,x2,f(x0),f(x1),f(x2)): ");
                            String valSOT = scan.nextLine();
                            
                            String[] values =  valSOT.split(",");
                            
                            float[] parsedValues = new float[6];
                            
                            for (int i = 0; i < values.length; i++) {
                                parsedValues[i] = Float.parseFloat(values[i]);
                            }
                            
                            float resSOT = Util.simpsonOneThree(parsedValues[0], parsedValues[1], parsedValues[2], parsedValues[3], parsedValues[4], parsedValues[5]);
                            
                            System.out.println("\n\t\tresult: " + resSOT);
                            
                            break;
                        case 2:
                            
                            System.out.print("\t\t\tInserte la ecuación a evaluar: ");
                            eq = scan.nextLine();
                            
                            scan.nextLine();
                            scan.nextLine();
                            
                            System.out.print("\t\t\tInserte los valores 'x' separados por comas (x0,x1,x2): ");
                            String valSOTE = scan.nextLine();
                            
                            String[] valuesE = valSOTE.split(",");
                            
                            float[] parsedValuesE = new float[3];
                            
                            for (int i = 0; i < valuesE.length; i++) {
                                parsedValuesE[i] = Float.parseFloat(valuesE[i]);
                            }
                            
                            result = Util.simpsonOneThree(parsedValuesE[0], parsedValuesE[1], parsedValuesE[2], eq);
                            System.out.println("result: " + result);
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 3:
                    System.out.print("\n\t\t1. Por tabulación\n\t\t2. Por expresión\n\t\tOpción: ");
                    int opt = scan.nextInt();
                    
                    scan.nextLine();
                    switch(opt) {
                        case 1:
                            System.out.print("\t\t\tInserte los valores separado por comas (x0,x1,x2,x3,f(x0),f(x1),f(x2),f(x3)): ");
                            String valSTE = scan.nextLine();
                            
                            String[] values =  valSTE.split(",");
                            
                            float[] parsedValues = new float[8];
                            
                            for (int i = 0; i < values.length; i++) {
                                parsedValues[i] = Float.parseFloat(values[i]);
                            }
                            
                            float resSTE = Util.simpsonThreeEight(parsedValues[0], parsedValues[1], parsedValues[2], parsedValues[3], parsedValues[4], parsedValues[5],parsedValues[6],parsedValues[7]);
                            
                            System.out.println("\n\t\tresult: " + resSTE);
                            
                            break;
                        case 2:
                            System.out.print("\t\t\tInserte la ecuación a evaluar: ");
                            eq = scan.nextLine();
                            
                            System.out.print("\t\t\tInserte los valores 'x' separados por comas (x0,x1,x2,x3): ");
                            String valSTEE = scan.nextLine();
                            
                            String[] valuesE = valSTEE.split(",");
                            
                            float[] parsedValuesE = new float[4];
                            
                            for (int i = 0; i < valuesE.length; i++) {
                                parsedValuesE[i] = Float.parseFloat(valuesE[i]);
                            }
                            
                            result = Util.simpsonThreeEight(parsedValuesE[0], parsedValuesE[1], parsedValuesE[2], parsedValuesE[3], eq);
                            System.out.println("result: " + result);
                            break;
                        default:
                            break;
                    }
                    break;
                    
                default:
                    System.out.println("Inserte una opción correcta");
                    break;
            }
        }
    }
    
}
