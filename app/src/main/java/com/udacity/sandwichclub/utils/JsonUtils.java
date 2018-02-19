package com.udacity.sandwichclub.utils;

import android.util.Log;

import org.json.*;
import com.udacity.sandwichclub.model.Sandwich;
import java.util.*;
public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {



        JSONObject sandwichDetail = new JSONObject(json);


        String mainName = sandwichDetail.getJSONObject("name").getString("mainName");
        List<String> alsoKnownAs = new ArrayList<String>();

        JSONArray alsoKnownAsJson = sandwichDetail.getJSONObject("name").getJSONArray("alsoKnownAs");

        for (int i = 0; i < alsoKnownAsJson.length(); i++) {
            alsoKnownAs.add(alsoKnownAsJson.getString(i));
        }


        String placeOfOrigin = sandwichDetail.getString("placeOfOrigin");
        String description = sandwichDetail.getString("description");
        String image = sandwichDetail.getString("image");

        List<String> ingredients = new ArrayList<String>();

        JSONArray ingredientJson = sandwichDetail.getJSONArray("ingredients");

        for (int i = 0; i < ingredientJson.length(); i++) {
            ingredients.add(ingredientJson.getString(i));
        }



        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin,description,image, ingredients);


        return sandwich;
    }
}
