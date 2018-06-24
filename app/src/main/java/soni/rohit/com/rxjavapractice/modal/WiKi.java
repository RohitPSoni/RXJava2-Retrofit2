package soni.rohit.com.rxjavapractice.modal;

import com.google.gson.annotations.SerializedName;

public class WiKi {

    @SerializedName("query")
    private Query query;

    private String batchcomplete;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    @Override
    public String toString() {
        return "ClassPojo query = " + query;
    }
}
