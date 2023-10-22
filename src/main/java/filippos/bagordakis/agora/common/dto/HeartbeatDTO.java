package filippos.bagordakis.agora.common.dto;

import java.util.UUID;

public class HeartbeatDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7655880412224339942L;

	public HeartbeatDTO(UUID uuid) {
		super(uuid);
	}

	public static HeartbeatDTO newInstance() {
		return new HeartbeatDTO(UUID.randomUUID());
	}

}
