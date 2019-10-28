package com.orlinskas.ForpostTestApp.response;

import com.google.gson.Gson;
import com.orlinskas.ForpostTestApp.userData.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class JsonParserToUser {
    ArrayList<User> parse(String json) {
        ArrayList<User> users = new ArrayList<>();

        try {
            JSONObject fullJson = new JSONObject(json);
            JSONArray usersList = fullJson.getJSONArray("results");

            for(int i = 0; i < usersList.length(); i++){
                Gson gson = new Gson();
                User user = gson.fromJson(usersList.getJSONObject(i).toString(), User.class);
                users.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return users;
    }
}
