/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fireduptech.springDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;

/**
 *
 * @author richardmccarthy
 */
@Controller
public class testController {
    
    /*
    @RequestMapping("message")
    public String displayMessage() {
        return "messageView";
    }*/
    
    
    @RequestMapping(value = "message/{name}", method = RequestMethod.GET)
    public String displayMessage( @PathVariable String name, Model model ) {
        
        model.addAttribute("displayMessage", name );    
        return "messageView";
    }

    
    /**
     * Reusing the messageView here to populate the 'displayMessage'
     * variable in the view with the POST value.
     * @return 
     */
    @RequestMapping(method=RequestMethod.POST)
    public String onSubmit( @ModelAttribute("formMessageValue")Message message,
            BindingResult result,
            Model model ) {
            
        if ( result.hasErrors() ) {
            return "error";
        }
        
        model.addAttribute( "displayMessage", message.getMessageValue() );    
        return "messageView";
    }


    @RequestMapping(value = "writeMessagePage", method = RequestMethod.GET)
    public String displayWriteMessagePage(Model model) {
        
        model.addAttribute("formMessageValue", new Message());
        return "postMessageView";
    }
    
}
