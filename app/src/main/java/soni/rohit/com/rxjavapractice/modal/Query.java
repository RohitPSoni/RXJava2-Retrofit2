package soni.rohit.com.rxjavapractice.modal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Query {

    @SerializedName("pages")
    private ArrayList<Pages> pages;

    public ArrayList<Pages> getPages () {
        return pages;
    }

    public void setPages (ArrayList<Pages> pages) {
        this.pages = pages;
    }
}
