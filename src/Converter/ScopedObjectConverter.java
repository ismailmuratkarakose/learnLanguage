package Converter;

import java.util.Map;
import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public abstract class ScopedObjectConverter implements Converter {
	public static final String OBJECT_CACHE = "SCOPED_OBJECT_CACHE";

	abstract protected Map<String, Object> getObjectCache(FacesContext context,
			UIComponent component);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Object returnObject = getObjectCache(context, component).get(value);
		return returnObject;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		String returnString = null;
		Map<String, Object> objectCache = getObjectCache(context, component);
		// search cacheMap to see if this has already been converted.
		for (Map.Entry<String, Object> cacheEntry : objectCache.entrySet()) {
			Object cachedObject = cacheEntry.getValue();
			if (cachedObject == null)
				continue;
			if (value.equals(cachedObject) || value == cachedObject) {
				returnString = cacheEntry.getKey();
			}
		}
		if (returnString == null) {
			returnString = UUID.randomUUID().toString();
			objectCache.put(returnString, value);
		}
		return returnString;
	}

}
