package ru.startandroid.firstproject;

import android.os.Bundle;
import ru.startandroid.firstproject.utils.Preferences;

public class MainActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // добавление фрагмента с кнопкой Далее
        FragmentMainNext fragmentMainNext = new FragmentMainNext();
        openFragment(FRAGMENT_CONTAINER_MAIN,fragmentMainNext);
        // фрагмент добавлен в мейн

    }

    public void clearLoginAndPassword(){
        Preferences preferences = App.instance.getPreferences();
        preferences.clearLogin();
        preferences.clearPassword();
    }

}

