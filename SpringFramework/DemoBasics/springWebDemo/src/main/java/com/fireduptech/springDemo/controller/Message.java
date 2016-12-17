/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fireduptech.springDemo.controller;

/**
 *
 * @author richardmccarthy
 */
public class Message {
 
    private String messageValue;

    /* This will break it as @ModelAttribute used in testController uses
       a default constructor by Spring behind the scenes, so if you have a 
       constructor like this you need to also explicityly define a default one.
    public Message ( String messageValue ) {
        this.messageValue = messageValue;
    }*/
    
    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    public static String sayHello(String message) {
        return "Hello " + message +"!";
    }
}


