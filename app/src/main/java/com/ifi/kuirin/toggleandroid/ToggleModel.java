package com.ifi.kuirin.toggleandroid;

/**
 * Created by KuiRin on 9/11/2017 AD.
 */

public class ToggleModel {

    public ToggleModel(int type, boolean isChecked, String title) {
        this.type = type;
        this.isChecked = isChecked;
        this.title = title;
    }

    int type;

    boolean isChecked;

    String title;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
