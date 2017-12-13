package com.example.user.praktikum7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Setiyo on 29 Nov 2017.
 */

public class AmbilGambar extends AsyncTask<String,Void,Bitmap> {

    interface Listener{
        void onLoadImage(Bitmap bitmap);
    }
    Listener mListener;
    public AmbilGambar(Listener listener){
        mListener=listener;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url=new URL(params[0]);
            URLConnection urlConnection=url.openConnection();
            Bitmap bp= BitmapFactory.decodeStream(urlConnection.getInputStream());
            return bp;
        } catch (Exception e) {
            Log.e("Error URL", e.getMessage());
        }
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap){
        if (bitmap != null){
            mListener.onLoadImage(bitmap);
        }
    }

}
