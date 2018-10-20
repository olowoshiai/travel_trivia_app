package com.example.aisha.intrepidget;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Aisha on 12/8/2017.
 */

public class ListItem {
    private String country;
    private String language;
    private String information;

    //constructor
    public ListItem(){}

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public ListItem(String country, String language, String information) {
        //this.country = country;
        this.setCountry(country);
        //this.language = language;
        this.setLanguage(language);
        //this.information = information;
        this.setInformation(information);
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getInformation() {
        return information;
    }

    public String toString(){
        return (country + "" + language + "" + information);
    }

    public static ArrayList<ListItem> createInformationData
            (String jsonFileName, FourthFragment context) throws JSONException {
        final ArrayList<ListItem> infoList = new ArrayList<>();
        try{
            String jsonString = loadJsonFromAsset (jsonFileName, context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray infos = json.getJSONArray("information");
            //get information objects
            for (int i = 0; i < infos.length(); i++) {
                //what's going on here
                ListItem item = new ListItem();
                String tmp;
                tmp = infos.getJSONObject(i).getString("country");
                item.setCountry(tmp);
                tmp = infos.getJSONObject(i).getString("language");
                item.setLanguage(tmp);
                tmp = infos.getJSONObject(i).getString("currency");
                item.setInformation(tmp);
                infoList.add(item);
            }
        } catch (JSONException e ){
            e.printStackTrace();
        }
        return infoList;
    }

    private static String loadJsonFromAsset(String filename, FourthFragment context){
        String json = null;
        try{
            InputStream is = context.getActivity().getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex){
            ex.printStackTrace(); return null;
        }
        return json;
    }


}
