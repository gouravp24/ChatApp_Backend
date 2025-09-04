package com.chat.entity;

import java.time.LocalDateTime;


public class Message {
    private String sender;
    private  String content;
    private LocalDateTime timespam;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timespam= LocalDateTime.now();
    }

    public Message(String sender, String content, LocalDateTime timespam) {
        this.sender = sender;
        this.content = content;
        this.timespam = timespam;
    }

    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimespam() {
        return timespam;
    }

    public void setTimespam(LocalDateTime timespam) {
        this.timespam = timespam;
    }
}
