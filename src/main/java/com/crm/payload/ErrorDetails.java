package com.crm.payload;

import java.util.Date;

public class ErrorDetails {

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getWebRequest() {
        return webRequest;
    }

    public ErrorDetails(Date date, String message, String webRequest) {
        this.date = date;
        this.message = message;
        this.webRequest = webRequest;
    }

    private String message;
    private String webRequest;


}
