package com.withos.currencyChange.logic;

import com.withos.currencyChange.entities.Currencies;

import java.util.Scanner;

public class GetValue {
    private String firstCode;
    private String secondCode;
    private double firstValue;
    private Scanner sc;

    public GetValue(){
        this.sc = new Scanner(System.in);
    }

    public Double getValue(){
        while (true) {
            try {
                System.out.println("Podaj kod waluty zrodlowej: ");
                this.firstCode = this.sc.nextLine().trim().toUpperCase();
                if (Currencies.getInstance().getCurrByCode(this.firstCode) == null)
                {
                    throw new IllegalArgumentException("Bledny kod waluty");
                }
                System.out.println("Podaj ilosc waluty zrodlowej: ");
                this.firstValue = Double.parseDouble(this.sc.nextLine());
                if (this.firstValue < 0)
                {
                    throw new IllegalArgumentException("Ilosc waluty musi byc wieksza od zera");
                }
                System.out.println("Podaj kod waluty docelowej: ");
                this.secondCode = this.sc.nextLine().trim().toUpperCase();
                Convert convert = new Convert(this.firstCode, this.secondCode, this.firstValue);
                if (Currencies.getInstance().getCurrByCode(this.firstCode) == null)
                {
                    throw new IllegalArgumentException("Bledny kod waluty");
                }
                return convert.getResult();
            }
            catch(NumberFormatException e){
                System.out.println("Ilosc waluty musi byc liczba");
                continue;
            }
            catch(IllegalArgumentException e){
               System.out.println(e.getMessage());
            }
        }
    }
}
