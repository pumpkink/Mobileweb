/*
 * Copyright 2015 hou.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package showcase.view.amap;

/**
 *
 * @author hou
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.amap.PointSelectedEvent;
import org.primefaces.event.amap.StateChangedEvent;
import org.primefaces.model.amap.LngLat;
import org.primefaces.model.amap.Bounds;
 
@ManagedBean
public class EventViews implements Serializable {
     
    public void onStateChange(StateChangedEvent event) {
        Bounds bounds = event.getBounds();
        int zoomLevel = event.getZooms();
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom Level", String.valueOf(zoomLevel)));
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Center", event.getCenter().toString()));
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "NorthEast", bounds.getNorthEast().toString()));
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "SouthWest", bounds.getSouthWest().toString()));
    }
      
    public void onPointSelect(PointSelectedEvent event) {
        LngLat lnglat = event.getLngLat();
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Coordinate:", "Lng:" + lnglat.getLng() + ", Lat:" + lnglat.getLat()));
    }
      
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
