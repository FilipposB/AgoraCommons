package filippos.bagordakis.agora.common.helper;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import filippos.bagordakis.agora.common.dto.RequestDTO;

public class AgoraHelper {

	public static final ObjectMapper objectMapper = getObjectMapper();

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}

	public static RequestDTO objectToRequestDTO(Object object) throws JsonProcessingException {
		return objectToBaseDTO(UUID.randomUUID(), object);
	}

	public static RequestDTO objectToBaseDTO(UUID id, Object object) throws JsonProcessingException {
		if (null == object) {
			throw new NullPointerException("Object cannot be null");
		}
		String json = objectMapper.writeValueAsString(object);
		return new RequestDTO.Builder(id, json).build();
	}

}
