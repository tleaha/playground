package com.tleaha.myapplication.data;

/**
 * Created by tleaha on 12/11/2558.
 */

import android.util.Log;

import com.squareup.okhttp.*;

public class AppService {

    /*PUBLIC VARIABLE*/
    public static final String DOMAIN  = "megazy.com";

    /*PRIVATE VARIABLE*/
    private String TAG="AppService";
    private static final String BASE_URL = "http://clip."+DOMAIN+"/clipcard/";
    private  static final String ACCESS_KEY = "a0815599800";
    private final OkHttpClient client = new OkHttpClient();

    public AppService()
    {

    }

    public ResponseBody GetClipInfo(int lastVersion)
    {
        ResponseBody result=null;
        try
        {
            Request req=new Request.Builder()
                    .url(BASE_URL+"GetGroupIndexV2")
                    .build();

            Response resp=client.newCall(req).execute();

            if(resp.isSuccessful())
            {
                result = resp.body();
            }else
            {
                Log.w(TAG,"RESPONSE CODE : "+resp.code());
            }
        }catch (Exception ex)
        {
            //Log.e(TAG,ex.toString());
        }

        return result;
    }


}
