package com.withos.currencyChange;

import com.withos.currencyChange.logic.GetValue;
import com.withos.currencyChange.xmlparse.XMLParse;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        XMLParse parser = new XMLParse();
        parser.createList();
        GetValue getValue = new GetValue();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println(df.format(getValue.getValue()));
    }
}
