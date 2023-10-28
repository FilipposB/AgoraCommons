package filippos.bagordakis.agora.common.helper;

import java.util.UUID;

import com.google.gson.Gson;

import filippos.bagordakis.agora.common.dto.RequestDTO;

public class AgoraHelper {

	public static final Gson gson = new Gson();

	public static RequestDTO objectToRequestDTO(Object object, String keyword) {
		return objectToBaseDTO(UUID.randomUUID(), object, keyword);
	}

	public static RequestDTO objectToBaseDTO(UUID id, Object object, String keyword) {
		if (null == object) {
			throw new NullPointerException("Object cannot be null");
		}
		String json = gson.toJson(object);
		return new RequestDTO.Builder(id, json, keyword).build();
	}

	public static Object convert(String json, Class<?> clazz) {
		if (json == null) {
			return null;
		}
		if (clazz == null) {
			return null;
		}
		return gson.fromJson(json, clazz);
	}

}
