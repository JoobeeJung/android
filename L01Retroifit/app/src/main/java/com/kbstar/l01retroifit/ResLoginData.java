package com.kbstar.l01retroifit;

import com.google.gson.annotations.Expose;

public class ResLoginData {

    //object에 해당하는 값이 null => json 필드 자동 생략
    @Expose
    String token;

    @Override
    public String toString() {
        return "ResLoginData{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }
}
