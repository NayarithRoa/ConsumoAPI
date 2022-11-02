package com.example.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InfoResponse {
    @SerializedName("data") public List<Post> data;
    @SerializedName("date") public Object date;

}


