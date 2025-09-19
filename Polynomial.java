public class Polynomial {
    private double[] coefficients;

    public Polynomial() {
        this.coefficients = new double[]{0};
    }
    
    public Polynomial(double[] coefficients) {
        this.coefficients = new double[coefficients.length]; // array-copy
        
        for (int i = 0; i < coefficients.length; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }
    
    public Polynomial add(Polynomial other) {
        int maxLen = Math.max(this.coefficients.length, other.coefficients.length);
        
        double[] sum = new double[maxLen];

        for (int i = 0; i < maxLen; i++) {
            double a = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            double b = (i < other.coefficients.length) ? other.coefficients[i] : 0;
                
            // Ternary operator:
            // x = c ? a : b means the following:
            // x will be set to a if c is TRUE, but b if c is FALSE
            // Basically:
            // define x
            // if c {x=a} else {x=b}
            
            sum[i] = a + b;
        }
        
        return new Polynomial(sum);
    }
    
    public double evaluate(double x) {
        double result = 0;
        
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        
        return result;
    }
    
    public boolean hasRoot(double x) {
        return Math.abs(this.evaluate(x)) < 1e-9;
    }
}
