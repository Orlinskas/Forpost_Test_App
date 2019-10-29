package com.orlinskas.ForpostTestApp.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orlinskas.ForpostTestApp.ImageLoaderTask;
import com.orlinskas.ForpostTestApp.NameBuilder;
import com.orlinskas.ForpostTestApp.R;
import com.orlinskas.ForpostTestApp.userData.User;

import org.parceler.Parcels;

public class UserFragment extends Fragment implements WebImageLoadable {
    private static final String PARCEL_COUNT = "count";
    private final String PARCEL_USER = "user";
    public User user;
    private ImageView avatar;
    public int countFragment;
    private UserFragmentActions action;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        if(savedInstanceState != null) {
            user = Parcels.unwrap(savedInstanceState.getParcelable(PARCEL_USER));
            countFragment = savedInstanceState.getInt(PARCEL_COUNT);
        }
        avatar = view.findViewById(R.id.user_row_fragment_iv);
        loadImageFromWeb(user.getPicture().getLarge());

        RelativeLayout relativeLayout = view.findViewById(R.id.user_row_fragment_rl);
        TextView fullName = view.findViewById(R.id.user_row_fragment_tv_full_name);
        TextView number = view.findViewById(R.id.user_row_fragment_tv_number);

        fullName.setText(NameBuilder.buildFullName(user));
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

    private void loadImageFromWeb(String url) {
        ImageLoaderTask load = new ImageLoaderTask();
        load.setWebImageLoadable(this);
        load.execute(url);
    }

    @Override
    public void onImageUploaded(Bitmap bitmap) {
        avatar.setImageBitmap(bitmap);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        action = (UserFragmentActions) context;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCEL_USER, Parcels.wrap(user));
        outState.putInt(PARCEL_COUNT, countFragment);
    }

}
