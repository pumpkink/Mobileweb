/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showcase.view.gmap;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.annotation.PostConstruct;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author hou
 */
@ManagedBean
@ViewScoped
public class CarinfoWindowView implements Serializable {
          
    private MapModel advancedModel;
  
    private Marker marker;
  
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Icons and Data
        advancedModel.addOverlay(new Marker(coord1, "Eup是大众首款小型电动车，性能出众。","10","1€/min", "eup.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        advancedModel.addOverlay(new Marker(coord2, "白色的Eup是其最为经典的款型。", "6","1€/min","eup1.png", "http://maps.google.com/mapfiles/ms/micons/green-dot.png"));
        advancedModel.addOverlay(new Marker(coord4, "Lavida","8","3€/min", "lavida.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        advancedModel.addOverlay(new Marker(coord3, "Lavida in Shanghai","5","1.5€/min","lavida1.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
    }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
    
}
