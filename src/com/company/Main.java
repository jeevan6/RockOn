package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TextReader textReader = new TextReader();
        ArrayList<DataEntry> DeList = null ;
        try {
            DeList = textReader.readFile("C:/Users/sony/IdeaProjects/RockOn/src/com/company/Files/US.txt");
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
        DatabaseManager Dm=new DatabaseManager();
        Dm.connect();
        Dm.CreateCollection("GeoNamesData");
        System.out.println(DeList.size());
        Dm.addData(DeList);
        SearchBox box = new SearchBox(Dm.getDb());
        box.Search("City","ington");


    }
}
