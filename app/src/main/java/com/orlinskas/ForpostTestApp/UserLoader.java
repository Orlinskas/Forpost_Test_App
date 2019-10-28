package com.orlinskas.ForpostTestApp;

import com.orlinskas.ForpostTestApp.request.Request;
import com.orlinskas.ForpostTestApp.request.RequestURLGenerator;
import com.orlinskas.ForpostTestApp.request.RequestURLSender;
import com.orlinskas.ForpostTestApp.response.JsonParserToUser;
import com.orlinskas.ForpostTestApp.userData.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UserLoader {
    public ArrayList<User> load() {
        ArrayList<User> users = new ArrayList<>();

        RequestURLGenerator generator = new RequestURLGenerator();
        URL url = generator.generate(new Request());
        RequestURLSender sender = new RequestURLSender();
        String json = null;

        try {
            json = sender.send(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(json != null) {
            JsonParserToUser parser = new JsonParserToUser();
            users = parser.parse(json);
        }

        return users;
    }
}
