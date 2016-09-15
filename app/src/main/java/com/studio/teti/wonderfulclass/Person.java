package com.studio.teti.wonderfulclass;

/**
 * Created by msipc on 31/08/2016.
 */

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String name;
    private int mark;
    private int image;

    public Person(){
        /*Blank default constructor essential for Firebase*/
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public int getImage() {
        return image;
    }

    public void setMark(int mark) { this.mark = mark; }
    public int getMark() {
        return mark;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("image", image);
        return result;
    }
}
