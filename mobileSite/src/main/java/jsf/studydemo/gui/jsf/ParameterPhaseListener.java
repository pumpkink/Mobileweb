/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.studydemo.gui.jsf;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author hou
 */
public class ParameterPhaseListener implements PhaseListener{
    static Log log = LogFactory.getLog(
            ParameterPhaseListener.class
            );
    
    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> map = fc.getExternalContext().getRequestParameterMap();
            for(String key : map.keySet()){
                StringBuilder param = new StringBuilder();
                param.append("Parameter: ");
                param.append(key);
                param.append(" = ");
                param.append(map.get(key));
                log.debug(param.toString());               
            }
    }

    @Override
    public PhaseId getPhaseId() {
       return PhaseId.APPLY_REQUEST_VALUES;
    }
    
}
