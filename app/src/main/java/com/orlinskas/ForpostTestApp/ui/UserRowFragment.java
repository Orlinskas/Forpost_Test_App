package com.orlinskas.ForpostTestApp.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orlinskas.ForpostTestApp.R;
import com.orlinskas.ForpostTestApp.userData.Name;
import com.orlinskas.ForpostTestApp.userData.User;

import java.io.InputStream;

public class UserRowFragment extends Fragment {
    private RelativeLayout relativeLayout;
    private ImageView avatar;
    private TextView fullName, number;
    public User user;
    public int countFragment;
    private UserRowFragmentActions action;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_row_fragment, container, false);

        relativeLayout = view.findViewById(R.id.user_row_fragment_rl);
        avatar = view.findViewById(R.id.user_row_fragment_iv);
        fullName = view.findViewById(R.id.user_row_fragment_tv_full_name);
        number = view.findViewById(R.id.user_row_fragment_tv_number);

        loadAvatar(user.getPicture().getLarge());
        fullName.setText(buildFullName());
        number.setText(String.valueOf(countFragment + 1));

        if(countFragment%2 == 0) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorWHITE));
        }
        else {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorLowGREY));
        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.openUser(user);
            }
        });

        return view;
    }

    private void loadAvatar(String medium) {
        new LoadImageTask().execute(medium);
    }

    private String buildFullName() {
        StringBuilder builder = new StringBuilder();
        Name name = user.getName();
        builder.append(name.getTitle())
                .append(" ")
                .append(name.getFirst())
                .append(" ")
                .append(name.getLast());

        return builder.toString();
    }

    @SuppressLint("StaticFieldLeak")
    class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            return loadImageFromWeb(urls[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            UserRowFragment.this.avatar.setImageBitmap(bitmap);
        }
    }

    private Bitmap loadImageFromWeb(String url) {
        Bitmap image = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            image = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return image;
    }
}
