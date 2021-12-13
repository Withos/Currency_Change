package com.withos.currencyChange.entities;

import java.util.HashMap;
import java.util.Map;

public class Currencies {
    private final Map<String, Currency> currencyList;
    private static Currencies instance = null;

    private Currencies(){
        this.currencyList = new HashMap<>();
    }

    public static Currencies getInstance()
    {
        if (instance == null)
        {
            instance = new Currencies();
        }
        return instance;
    }

    public void addCurrency(Currency curr){
        this.currencyList.put(curr.getCurrCode(), curr);
    }

    public Currency getCurrByCode(String code){
        return this.currencyList.get(code);
    }
}
