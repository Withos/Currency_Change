package com.withos.currencyChange.logic;

import com.withos.currencyChange.entities.Currencies;
import com.withos.currencyChange.entities.Currency;

public class Convert {
    private double value;

    public Convert(String code1, String code2, double value1){
        Currency curr1 = Currencies.getInstance().getCurrByCode(code1);
        Currency curr2 = Currencies.getInstance().getCurrByCode(code2);
        this.value = (value1*curr1.getAvgExchRate()*curr2.getMultiplier())/(curr1.getMultiplier()*curr2.getAvgExchRate());
    }

    public double getResult(){
        return this.value;
    }
}
