package com.elgo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("0");
        list.add("50");
        FormFactory form = new FormFactory();
        form.getForme("cercle", list);
    }
}
