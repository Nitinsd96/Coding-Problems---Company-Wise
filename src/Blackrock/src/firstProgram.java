package Blackrock.src;

import com.sun.tools.javac.Main;

import java.io.*;
import java.nio.*;
import java.text.DecimalFormat;

public class firstProgram {
    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader((reader));

        try{
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            firstProgram.calculateChange(purchasePrice,cash);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void calculateChange(double purchasePrice, double cash){
        String textChange = "";

        double change = cash - purchasePrice;

        if(change < 0){
            System.out.println("ERROR");
        }else if(change == 0){
            System.out.println("ZERO");
        }
        else {
            DecimalFormat df = new DecimalFormat("########.##");
            int intChange = (int) (Double.valueOf(df.format(change)) * 100);

            while (intChange >= 0.01) {
                if (intChange >= 5000) {
                    textChange += "FIFTY POUNDS,";
                    intChange -= 5000;
                } else if (intChange >= 2000) {
                    textChange += "TWENTY POUNDS,";
                    intChange -= 2000;
                } else if (intChange >= 1000) {
                    textChange += "10 POUNDS,";
                    intChange -= 1000;
                } else if (intChange >= 500) {
                    textChange += "FIVE POUNDS,";
                    intChange -= 500;
                } else if (intChange >= 200) {
                    textChange += "TWO POUNDS,";
                    intChange -= 200;
                } else if (intChange >= 100) {
                    textChange += "ONE POUND,";
                    intChange -= 100;
                } else if (intChange >= 50) {
                    textChange += "FIFTY PENCE,";
                    intChange -= 50;
                } else if (intChange >= 20) {
                    textChange += "TWENTY PENCE,";
                    intChange -= 20;
                } else if (intChange >= 10) {
                    textChange += "TEN PENCE,";
                    intChange -= 10;
                } else if (intChange >= 5) {
                    textChange += "FIVE PENCE,";
                    intChange -= 5;
                } else if (intChange >= 2) {
                    textChange += "TWO PENCE,";
                    intChange -= 2;
                } else if (intChange >= 1) {
                    textChange += "ONE PENCE,";
                    intChange -= 1;
                }
            }
            System.out.println(textChange.substring(0, textChange.length() - 1));
        }
    }
}
