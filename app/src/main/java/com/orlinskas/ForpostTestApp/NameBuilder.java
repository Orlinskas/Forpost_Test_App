package com.orlinskas.ForpostTestApp;

import com.orlinskas.ForpostTestApp.userData.Name;
import com.orlinskas.ForpostTestApp.userData.User;

public class NameBuilder {
    public static String buildFullName(User user) {
        StringBuilder builder = new StringBuilder();
        Name name = user.getName();
        builder.append(name.getTitle())
                .append(" ")
                .append(name.getFirst())
                .append(" ")
                .append(name.getLast());

        return builder.toString();
    }
}
