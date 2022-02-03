package com.example.viewpager2demo.ApiPackage;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class Details {
    public String image;
    public String currentAddress;
    public Object preferredCourse;

    public String getImage() {
        return image;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public Object getPreferredCourse() {
        return preferredCourse;
    }
}
