package soni.rohit.com.rxjavapractice.modal;

import com.google.gson.annotations.SerializedName;

public class Thumbnail {

    @SerializedName("height")
    private String height;

    @SerializedName("source")
    private String source;

    @SerializedName("width")
    private String width;

    public String getHeight () {
        return height;
    }

    public void setHeight (String height) {
        this.height = height;
    }

    public String getSource () {
        return source;
    }

    public void setSource (String source) {
        this.source = source;
    }

    public String getWidth () {
        return width;
    }

    public void setWidth (String width) {
        this.width = width;
    }
}