package com.orlinskas.ForpostTestApp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.orlinskas.ForpostTestApp.ui.WebImageLoadable;

import java.io.InputStream;

@SuppressLint("StaticFieldLeak")
public class ImageLoaderTask extends AsyncTask<String, Void, Bitmap> {
    private WebImageLoadable webImageLoadable;

    public void setWebImageLoadable(WebImageLoadable webImageLoadable) {
        this.webImageLoadable = webImageLoadable;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        if(webImageLoadable != null) {
           return loadImageFromWeb(urls[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        webImageLoadable.onImageUploaded(bitmap);
    }

    private Bitmap loadImageFromWeb(String url) {
        Bitmap image = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            image = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}


