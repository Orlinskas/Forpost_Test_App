package com.orlinskas.ForpostTestApp.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.orlinskas.ForpostTestApp.ImageLoaderTask;
import com.orlinskas.ForpostTestApp.NameBuilder;
import com.orlinskas.ForpostTestApp.R;
import com.orlinskas.ForpostTestApp.Settings;
import com.orlinskas.ForpostTestApp.userData.User;
import com.orlinskas.ForpostTestApp.userData.UserDetails;

import org.parceler.Parcels;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements WebImageLoadable {
    private ImageView avatar;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        User user = Parcels.unwrap(getIntent().getParcelableExtra(Settings.PARCELABLE_USER));

        avatar = findViewById(R.id.activity_user_iv_avatar);
        loadImageFromWeb(user.getPicture().getLarge());
        TextView fullName = findViewById(R.id.activity_user_tv_full_name);
        fullName.setText(NameBuilder.buildFullName(user));

        ArrayList<UserDetails> details = new ArrayList<>();
        details.add(new UserDetails("Age", user.getDob().getAge()));
        details.add(new UserDetails("City", user.getLocation().getCity()));
        details.add(new UserDetails("Email", user.getEmail()));
        details.add(new UserDetails("Phone", user.getPhone()));
        details.add(new UserDetails("Nation", user.getNat()));

        ListView listView = findViewById(R.id.activity_user_lv_details);
        ArrayAdapter adapter = new UserDetailsListAdapter(this, R.layout.row_user_details, details);
        listView.setAdapter(adapter);
    }

    private void loadImageFromWeb(String url) {
        ImageLoaderTask load = new ImageLoaderTask();
        load.setWebImageLoadable(this);
        load.execute(url);
    }

    @Override
    public void onImageUploaded(Bitmap bitmap) {
        avatar.setImageBitmap(bitmap);
    }

    private class UserDetailsListAdapter extends ArrayAdapter<UserDetails> {
        ArrayList<UserDetails> details;

        UserDetailsListAdapter(Context context, int textViewResourceId, ArrayList<UserDetails> details) {
            super(context, textViewResourceId, details);
            this.details = details;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.row_user_details, parent, false);
            TextView detailsName = row.findViewById(R.id.row_user_details_tv_detail_name);
            TextView detailsValue = row.findViewById(R.id.row_user_details_tv_detail_value);

            String name = details.get(position).getDetailsName();
            String value = details.get(position).getDetailsValue();

            detailsName.setText(name);
            detailsValue.setText(value);

            return row;
        }
    }
}
