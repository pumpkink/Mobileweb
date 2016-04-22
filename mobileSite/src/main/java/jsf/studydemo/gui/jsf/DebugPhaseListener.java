/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.studydemo.gui.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author hou
 */
public class DebugPhaseListener  implements PhaseListener{
    static Log log = LogFactory.getLog(DebugPhaseListener.class);

    @Override
    public void afterPhase(PhaseEvent event) {
        log.debug("Now after phase: " + event.getPhaseId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        log.debug("Now before phase: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
