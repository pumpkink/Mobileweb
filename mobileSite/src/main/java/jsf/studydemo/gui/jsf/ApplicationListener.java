/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.studydemo.gui.jsf;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.Application;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
/**
 *
 * @author hou
 */
public class ApplicationListener implements SystemEventListener{
    static Log log = LogFactory.getLog(ApplicationListener.class);
    

    @Override
    public void processEvent(SystemEvent event) {
        if(event instanceof PostConstructApplicationEvent){
            log.debug("Application startup");
        }else if(event instanceof PreDestroyApplicationEvent){
            log.debug("Application shutdown");
        }
        
    }

    @Override
    public boolean isListenerForSource(Object source) {
       return source instanceof Application;
    }
    
}
