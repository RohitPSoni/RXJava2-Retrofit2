package soni.rohit.com.rxjavapractice.modal;

import com.google.gson.annotations.SerializedName;

public class Pages {

    @SerializedName("index")
    private String index;

    @SerializedName("title")
    private String title;

    @SerializedName("ns")
    private String ns;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("terms")
    private Terms terms;

    @SerializedName("pageid")
    private String pageid;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }
}
