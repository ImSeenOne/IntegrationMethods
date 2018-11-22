/**
 * THIS CLASS IS STRONGLY NEEDY OF exp4j-0.4.8.jar PACKAGE; PAGE OF DOWNLOAD: https://lallafa.objecthunter.net/exp4j/download.html
 */
package integrationmeth.util;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author CRF
 */
public class Util {
    /**
     * 
     * @param a float is the lower limit in the integral
     * @param b float is the higher limit in the integral
     * @param eq is the function inside the integral
     * @return float The result of applying this numerical method
     */
    public static float trapezoidalRule(float a, float b, String eq) {
        float fa = substitute(eq, a);
        float fb = substitute(eq, b);
        
        float result = (b - a) * ((fa + fb)/2);
        
        
        
        return result;
    }
    
    /**
     * 
     * @param x0 float The x0 given value
     * @param x1 float The x1 given value
     * @param x2 float The x2 given value
     * @param a float The 'a' given value
     * @param b float The 'b' given value
     * @param eq String  The string for the equation
     * @return Simpson's 1/3 rule's result
     */
    
    public static float simpsonOneThree(float x0, float x1, float x2, float a, float b, String eq) {
        float h = (b - a) / 2;
        
        float result = (h/3) * ( substitute(eq, x0) + (4 * substitute(eq, x1)) + substitute(eq, x2) );
        
        return result;
    }
    
    /**
     * 
     * @param x0 float The x0 given value
     * @param x1 float The x1 given value
     * @param x2 float The x2 given value
     * @param x3 float The x2 given value
     * @param a float The 'a' given value
     * @param b float The 'b' given value
     * @param eq String  The string for the equation
     * @return Simpson's 1/3 rule's result
     */
    
    public static float simpsonThreeEight(float x0, float x1, float x2, float x3, float a, float b, String eq) {
        float h = (b - a) / 3;
        
        float result = ((3*h)/8) * ( substitute(eq, x0) + (3 * substitute(eq, x1)) + (3 * substitute(eq, x2)) + substitute(eq, x3) );
        
        return result;
    }
    
    /**
     * 
     * @param eq String The equation
     * @param x float The element to substitute
     * @return float The result of substituting x in the equation
     */
    public static float substitute(String eq, float x) {
        Expression calc = new ExpressionBuilder(eq).variable("x").build();
        calc.setVariable("x", x);
        
        float result = (float) calc.evaluate();
        
        return result;
    }
}
