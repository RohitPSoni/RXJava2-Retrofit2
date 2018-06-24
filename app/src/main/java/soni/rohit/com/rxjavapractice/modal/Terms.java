package soni.rohit.com.rxjavapractice.modal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Terms {
    @SerializedName("description")
    private ArrayList<String> description;

    public ArrayList<String> getDescription () {
        return description;
    }

    public void setDescription (ArrayList<String> description) {
        this.description = description;
    }
}
