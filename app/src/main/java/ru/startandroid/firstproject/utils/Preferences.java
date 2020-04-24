package ru.startandroid.firstproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static final String FILE_NAME = "system";

    private SharedPreferences preferences;

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }


    // логин
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

    // пароль
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


    // имя
    public void saveFirstName(String firstName) {
        preferences.edit()
                .putString(Key.FIRST_NAME.name(), firstName)
                .apply();
    }

    public String getFirstName() {
        return preferences.getString(Key.FIRST_NAME.name(), "");
    }

    public void clearFirstName() {
        preferences.edit()
                .remove(Key.FIRST_NAME.name())
                .apply();
    }


    // фамилия
    public void saveSecondName(String secondName) {
        preferences.edit()
                .putString(Key.SECOND_NAME.name(), secondName)
                .apply();
    }

    public String getSecondName() {
        return preferences.getString(Key.SECOND_NAME.name(), "");
    }

    public void clearSecondName() {
        preferences.edit()
                .remove(Key.SECOND_NAME.name())
                .apply();
    }


    private enum Key {
        LOGIN,
        PASSWORD,
        FIRST_NAME,
        SECOND_NAME
    }

}
