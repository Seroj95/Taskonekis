package com.example.myapplication4;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

public class SettingFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
addPreferencesFromResource(R.xml.timer_preferences);
        SharedPreferences sharedPreferences=getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen=getPreferenceScreen();
        int count =preferenceScreen.getPreferenceCount();
        for (int i=0;i<count;i++){
            Preference preference=preferenceScreen.getPreference(i);
            if (!(preference instanceof CheckBoxPreference)){
                String value=sharedPreferences.getString(preference.getKey(),"");
                setPreferanceLabel(preference,value);
            }
        }
    }
    private  void setPreferanceLabel(Preference preferance,String value){
        if (preferance instanceof ListPreference){
            ListPreference listPreference=(ListPreference)preferance;
            int index=listPreference.findIndexOfValue(value);
            if (index>=0){
                listPreference.setSummary(listPreference.getEntry());

            }
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference =findPreference(key);
        if (!(preference instanceof CheckBoxPreference)){
            String value=sharedPreferences.getString(preference.getKey(), "");
            setPreferanceLabel(preference,value);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
