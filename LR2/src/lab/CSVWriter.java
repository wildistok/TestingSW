package lab;

import lab.*;
import lab.logarithms.Ln;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class CSVWriter {
    public void setAppend(boolean append) {
        this.append = append;
    }

    boolean append = false;
    public AbstructFunction getFunction() {
        return function;
    }

    public void setFunction(AbstructFunction function) {
        this.function = function;
    }

    private AbstructFunction function;
    public static final String SEPARATOR = ";";


    public CSVWriter(AbstructFunction function){
        this.function = function;
    }

    public void write(double from, double to, double step){
        try (FileWriter writer = new FileWriter(getFilename(), append)) {
            for (double x = from; x < to; x += step) {
                System.out.println(function.calculate(x));
                double value = function.calc(x);
                writer.append(String.format(Locale.US, "%f%s%f\n", x, SEPARATOR, value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename(){
        String fnName = this.function.getClass().getSimpleName();
        if( fnName.isEmpty() ){
            fnName = "fn";
        }
        return fnName + "-data.csv";
    }
}