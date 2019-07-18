package com.example.data_analysis.service.leak.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Example {


    public enum Gender {

        MALE(0, "男"),
        FEMALE(1, "女");

        Integer code;
        String status;

        Gender(Integer code, String status) {
            this.code = code;
            this.status = status;
        }
    }



    public class User{

        private int age;
        private String name;
        private String email;
        private Gender gender;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }

    //fastjson反序列化漏洞
    public static void main(String[] args) {

        String myJson = "{\"@type\":\"com.example.data_analysis.service.leak.fastjson.Example.User\",\"age\":99,\"name\":\"balabala\",\"email\":\"2333@qq.com\"}";
        JSONObject user = JSON.parseObject(myJson);
        System.out.println("get user Info:"+user.get("name"));

    }





    //fastjson远程代码执行漏洞

}
