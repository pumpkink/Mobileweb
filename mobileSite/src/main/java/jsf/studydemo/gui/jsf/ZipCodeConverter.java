package jsf.studydemo.gui.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.IntegerConverter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;

@FacesConverter(value = ZipCodeConverter.CONVERTER_ID)
public class ZipCodeConverter extends IntegerConverter implements Serializable {
    private static final long serialVersionUID = 7058986733877680578L;

    public static final String CONVERTER_ID = "jsf.studydemo.ZipCode";

    public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) throws ConverterException {
		
		if (value != null && value.length() > 0) {
			int pos = value.indexOf('-');
			for (int i = 0; i < pos; i++) {
				if (!Character.isLetter(value.charAt(i))) {
					throw new ConverterException("Zip code invalid.");
				}
			}
			if (pos > -1 && pos < value.length() - 1) {
				return super.getAsObject(ctx, component, value.substring(pos + 1));
			}
		}
		return super.getAsObject(ctx, component, value);
	}
}
