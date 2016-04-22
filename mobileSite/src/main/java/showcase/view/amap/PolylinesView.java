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
import javax.faces.context.FacesContext;
  
import org.primefaces.event.amap.OverlaySelectEvent;
import org.primefaces.model.amap.DefaultMapModel;
import org.primefaces.model.amap.LngLat;
import org.primefaces.model.amap.MapModel;
import org.primefaces.model.amap.Marker;
import org.primefaces.model.amap.Polyline;
  
@ManagedBean
public class PolylinesView implements Serializable {
  
    private MapModel polylineModel;
  
    @PostConstruct
    public void init() {
        polylineModel = new DefaultMapModel();
          
        //Shared coordinates
        LngLat coord1 = new LngLat(116.397, 39.907);
        LngLat coord2 = new LngLat(116.381, 39.807);
        LngLat coord3 = new LngLat(116.339, 39.707);
        LngLat coord4 = new LngLat(116.321, 39.607);
        
        polylineModel.addOverlay(new Marker(coord1, "Hier ist 1. Punkt ","ObjektName","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        polylineModel.addOverlay(new Marker(coord2, "Hier ist 2. Punkt ","ObjektName","http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        polylineModel.addOverlay(new Marker(coord3, "Hier ist 3. Punkt ","ObjektName","http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
        polylineModel.addOverlay(new Marker(coord4, "Hier ist 4. Punkt ","AMAP_ANIMATION_BOUNCE"));
      
        //Polyline
        Polyline polyline = new Polyline();
        polyline.getPaths().add(coord1);
        polyline.getPaths().add(coord2);
        polyline.getPaths().add(coord3);
        polyline.getPaths().add(coord4);
          
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#006600");
        polyline.setStrokeOpacity(0.7);
          
        polylineModel.addOverlay(polyline);
    }
  
    public MapModel getPolylineModel() {
        return polylineModel;
    }
  
    public void onPolylineSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Polyline Selected", null));
    }
}
