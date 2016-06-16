package Converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("componentScopedConverter")
public class ComponentScopedConverter extends ScopedObjectConverter {

	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> getObjectCache(FacesContext context, UIComponent component) {
		Object cache = component.getAttributes().get(OBJECT_CACHE);
		if (cache != null && cache instanceof Map) {
			return (Map<String, Object>) cache;
		} else {
			Map<String, Object> objectCache = new HashMap<String, Object>();
			component.getAttributes().put(OBJECT_CACHE, objectCache);
			return objectCache;
		}
	}
}
