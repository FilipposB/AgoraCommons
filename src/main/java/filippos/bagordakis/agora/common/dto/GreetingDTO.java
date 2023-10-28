package filippos.bagordakis.agora.common.dto;

import java.util.UUID;

public class GreetingDTO extends BaseDTO {

	private static final long serialVersionUID = -6355873389287758980L;
	private String name;

	public GreetingDTO(UUID id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static GreetingDTO newInstance(String name) {
		return new GreetingDTO(UUID.randomUUID(), name);
	}

}
