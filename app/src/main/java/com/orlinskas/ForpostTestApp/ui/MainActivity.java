package com.orlinskas.ForpostTestApp.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.orlinskas.ForpostTestApp.R;
import com.orlinskas.ForpostTestApp.Settings;
import com.orlinskas.ForpostTestApp.UserLoader;
import com.orlinskas.ForpostTestApp.userData.User;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserRowFragmentActions {
    private ArrayList<User> users;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.activity_main_pb);
        new LoadUsersTask().execute();
    }

    @SuppressLint("StaticFieldLeak")
    class LoadUsersTask extends AsyncTask<Void, Void, ArrayList<User>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<User> doInBackground(Void... voids) {
            UserLoader userLoader = new UserLoader();
            return userLoader.load();
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            if(users.size() > 0) {
                MainActivity.this.users = users;
                showUsers();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Failed to load users", Toast.LENGTH_LONG);
                toast.show();
            }
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void showUsers() {
        FragmentManager fm = getSupportFragmentManager();

        for (User user : users){
            Fragment fragment = fm.findFragmentById(R.id.activity_main_ll_user_container);
            if (fragment == null) {
                fragment = new UserRowFragment();
                ((UserRowFragment) fragment).user = user;
                ((UserRowFragment) fragment).countFragment = users.indexOf(user);
                fm.beginTransaction()
                        .add(R.id.activity_main_ll_user_container, fragment)
                        .commit();
            }
        }
    }

    @Override
    public void openUser(User user) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Settings.PARCELABLE_USER, Parcels.wrap(user));
        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
