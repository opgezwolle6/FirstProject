package ru.startandroid.firstproject;

import android.app.Application;

import ru.startandroid.firstproject.utils.Preferences;

public class App extends Application {

    public static App instance;

    private Preferences preferences;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferences = new Preferences(this);
    }

    public Preferences getPreferences() {
        return preferences;
    }

}