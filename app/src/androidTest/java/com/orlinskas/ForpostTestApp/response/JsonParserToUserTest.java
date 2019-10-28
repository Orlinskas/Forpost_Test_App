package com.orlinskas.ForpostTestApp.response;

import android.support.test.runner.AndroidJUnit4;

import com.orlinskas.ForpostTestApp.userData.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class JsonParserToUserTest {
    private String json;

    @Before
    public void setUp() {
        json = "{\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"gender\": \"female\",\n" +
                "      \"name\": {\n" +
                "        \"title\": \"Ms\",\n" +
                "        \"first\": \"Gwendolyn\",\n" +
                "        \"last\": \"Perkins\"\n" +
                "      },\n" +
                "      \"location\": {\n" +
                "        \"street\": {\n" +
                "          \"number\": 128,\n" +
                "          \"name\": \"Thornridge Cir\"\n" +
                "        },\n" +
                "        \"city\": \"York\",\n" +
                "        \"state\": \"Georgia\",\n" +
                "        \"country\": \"United States\",\n" +
                "        \"postcode\": 47304,\n" +
                "        \"coordinates\": {\n" +
                "          \"latitude\": \"87.1596\",\n" +
                "          \"longitude\": \"166.6004\"\n" +
                "        },\n" +
                "        \"timezone\": {\n" +
                "          \"offset\": \"+3:00\",\n" +
                "          \"description\": \"Baghdad, Riyadh, Moscow, St. Petersburg\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"email\": \"gwendolyn.perkins@example.com\",\n" +
                "      \"login\": {\n" +
                "        \"uuid\": \"6be90df2-6adf-4f9d-aa0f-649895a7e0ff\",\n" +
                "        \"username\": \"whitegorilla373\",\n" +
                "        \"password\": \"212121\",\n" +
                "        \"salt\": \"O197L1hO\",\n" +
                "        \"md5\": \"8914da30c5c70b6666b38dd55651205d\",\n" +
                "        \"sha1\": \"4db78468f8c5fd2bd08d96ee0cf4c6e7b5241e98\",\n" +
                "        \"sha256\": \"c03a10b112c975d4f3a21c1d0e0bb528d0e420f07b910f05f16000bfa7ea7508\"\n" +
                "      },\n" +
                "      \"dob\": {\n" +
                "        \"date\": \"1978-04-24T06:07:07.032Z\",\n" +
                "        \"age\": 41\n" +
                "      },\n" +
                "      \"registered\": {\n" +
                "        \"date\": \"2012-01-18T06:10:30.123Z\",\n" +
                "        \"age\": 7\n" +
                "      },\n" +
                "      \"phone\": \"(364)-909-9585\",\n" +
                "      \"cell\": \"(398)-910-0927\",\n" +
                "      \"id\": {\n" +
                "        \"name\": \"SSN\",\n" +
                "        \"value\": \"122-72-2882\"\n" +
                "      },\n" +
                "      \"picture\": {\n" +
                "        \"large\": \"https://randomuser.me/api/portraits/women/57.jpg\",\n" +
                "        \"medium\": \"https://randomuser.me/api/portraits/med/women/57.jpg\",\n" +
                "        \"thumbnail\": \"https://randomuser.me/api/portraits/thumb/women/57.jpg\"\n" +
                "      },\n" +
                "      \"nat\": \"US\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"info\": {\n" +
                "    \"seed\": \"771834541834b524\",\n" +
                "    \"results\": 1,\n" +
                "    \"page\": 1,\n" +
                "    \"version\": \"1.3\"\n" +
                "  }\n" +
                "}";
    }

    @Test
    public void parse() {
        ArrayList<User> users;
        JsonParserToUser parser = new JsonParserToUser();
        users = parser.parse(json);
        assertEquals(1, users.size());
    }
}