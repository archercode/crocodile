package com.crocodille;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tonnyquintos on 1/2/16.
 */
public class SharedPrefManager {

    public static SharedPrefManager instance;
    public static final String PREFS_NAME = "CROC";


    public static SharedPrefManager getInstance(){
        if(instance == null){
            instance = new SharedPrefManager();
        }
        return instance;
    }

    private SharedPrefManager(){
    }

    public boolean isLoggedIn(Context ctx){
        SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean("is_logged_in",false);
    }

    public void login(Context ctx, boolean isLoggedIn){
        SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("is_logged_in",isLoggedIn);
        editor.commit();
    }
}
