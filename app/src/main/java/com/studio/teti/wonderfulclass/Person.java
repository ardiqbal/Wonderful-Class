package com.studio.teti.wonderfulclass;

/**
 * Created by msipc on 31/08/2016.
 */

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String name;
    private String email;
    private String phone;
    private int age;

    public Person(){
        /*Blank default constructor essential for Firebase*/
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("email", email);
        result.put("phone", phone);
        result.put("age", age);
        return result;
    }
}
