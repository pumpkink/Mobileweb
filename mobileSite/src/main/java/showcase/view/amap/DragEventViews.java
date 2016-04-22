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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
  
import org.primefaces.event.amap.OverlaySelectEvent;
import org.primefaces.event.amap.PointSelectedEvent;
import org.primefaces.event.amap.MarkerDragEvent;
import org.primefaces.model.amap.DefaultMapModel;
import org.primefaces.model.amap.LngLat;
import org.primefaces.model.amap.MapModel;
import org.primefaces.model.amap.Marker;
  
@ManagedBean
@ViewScoped
public class DragEventViews implements Serializable {
    private static final long serialVersionUID = 1L;
      
    private MapModel advancedModel;
  
    private Marker marker;

    
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
       
          
        //Shared coordinates
        LngLat coord1 = new LngLat(116.397, 39.907);
        LngLat coord2 = new LngLat(116.397, 39.908);
                 
        //add Marker Overlay of the Map
        advancedModel.addOverlay(new Marker(coord1, "Hier ist Punkt1", "Beijing.png","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        advancedModel.addOverlay(new Marker(coord2, "Hier ist Punkt2","Beijing.png","http://maps.google.com/mapfiles/ms/micons/green-dot.png"));
            
        for(Marker premarker : advancedModel.getMarkers()) {
            premarker.setDraggable(true);
        }
    }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        this.marker = (Marker)event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Overlay Selected:", "Title:" + marker.getTitle()+ ", Data:"+ marker.getData()));
    }
    
    public void onMarkerDrag(MarkerDragEvent event){
        this.marker = event.getMarker();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "After Dragged:", "Lng:" + marker.getPosition().getLng() + ", Lat:" + marker.getPosition().getLat()));
    }
    
    
    public Marker getMarker() {
        return marker;
    }
        
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
    
}