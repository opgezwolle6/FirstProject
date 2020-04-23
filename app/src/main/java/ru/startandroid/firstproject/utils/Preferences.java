package ru.startandroid.firstproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static final String FILE_NAME = "system";

    private SharedPreferences preferences;

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveLogin(String login) {
        preferences.edit()
                .putString(Key.LOGIN.name(), login)
                .apply();
    }

    public String getLogin() {
        return preferences.getString(Key.LOGIN.name(), "");
    }

    public void clearLogin() {
        preferences.edit()
                .remove(Key.LOGIN.name())
                .apply();
    }

    public void savePassword(String password) {
        preferences.edit()
                .putString(Key.PASSWORD.name(), password)
                .apply();
    }

    public String getPassword() {
        return preferences.getString(Key.PASSWORD.name(), "");
    }

    public void clearPassword() {
        preferences.edit()
                .remove(Key.PASSWORD.name())
                .apply();
    }



    private enum Key {
        LOGIN,
        PASSWORD
    }

}