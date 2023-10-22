package filippos.bagordakis.agora.common.dto;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 3939502099149672822L;

	private UUID id;

	public BaseDTO(UUID uuid) {
		this.id = uuid;

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
