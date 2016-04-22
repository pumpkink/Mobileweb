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

 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.amap.DefaultMapModel;
import org.primefaces.model.amap.LngLat;
import org.primefaces.model.amap.MapModel;
import org.primefaces.model.amap.Marker;
 
@ManagedBean
public class Markers implements Serializable {
    
    private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LngLat coord1 = new LngLat(116.397,39.907);
        LngLat coord2 = new LngLat(116.397,39.916);
        LngLat coord3 = new LngLat(116.397,39.927);
        
        
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Hier ist ein Punkt in Beijing","konyaalti.png","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        simpleModel.addOverlay(new Marker(coord2, "Hier ist ein Punkt in Beijing","konyaalti.png","http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        simpleModel.addOverlay(new Marker(coord3, "Hier ist ein Punkt in Beijing","AMAP_ANIMATION_BOUNCE"));
        
        
        
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}
