package org.dis.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.sun.codemodel.internal.JForEach;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();

        try {

            ArrayList<GeoIP> listIP = null;
            BufferedReader br = new BufferedReader(new FileReader("LocalizaIP.json"));
            listIP = gson.fromJson(br, new TypeToken<ArrayList<GeoIP>>(){}.getType());

            for (GeoIP elem: listIP) {
                System.out.println(elem.toString());
            }

//            Aquí ya tengo el json leído. Voy a crear un long a partir de una IP y a buscar a qué región pertenece

            String ip_in = "150.245.255.254";

            long ip_in_long = AuxMethods.Dot2LongIP(ip_in);

            System.out.println(ip_in +"=>"+  ip_in_long);

            Boolean found = false;
            GeoIP foundItem = null;
            int j = 0;

            String dataTest = AuxMethods.longToIp((long)2532704255.0);
            System.out.println(dataTest);

            while (!found && j < listIP.size()) {

                GeoIP item = listIP.get(j);
                if (ip_in_long >= item.getIp_from() && ip_in_long <= item.getIp_to()) {
                    found = true;
                    foundItem = item;
                    System.out.println("Found item" + item.toString());
                }
                j++;
            }
            if (foundItem != null) {
                System.out.println(foundItem.toString());
            } else {
                System.out.println ("No info located");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}
