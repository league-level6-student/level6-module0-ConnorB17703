package _02_cat_facts_API.data_transfer_objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;


    @Generated("jsonschema2pojo")
    public class CatWrapper {

    @SerializedName("data")
    @Expose
    private List<String> data;

    public List<String> getData() {
    return data;
    }

    public void setData(List<String> data) {
    this.data = data;
    }

    }
    

