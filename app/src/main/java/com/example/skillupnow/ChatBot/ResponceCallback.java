package com.example.skillupnow.ChatBot;

public interface ResponceCallback {
    void onResponse (String response);
    void onError (String thowable);
}
