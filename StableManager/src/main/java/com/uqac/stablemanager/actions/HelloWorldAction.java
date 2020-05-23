package com.uqac.stablemanager.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.uqac.stablemanager.entities.MessageStore;
import org.springframework.security.access.prepost.PreAuthorize;


public class HelloWorldAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    /**
     * The model class that stores the message
     * to display in the view.
     */
    private MessageStore messageStore;

    /*
     * Creates the MessageStore model object and
     * returns success.  The MessageStore model
     * object will be available to the view.
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @PreAuthorize("hasRole('PERM_READ_FORUMS')")
    public String execute() {
        messageStore = new MessageStore() ;
        System.out.println("SALUT");
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
