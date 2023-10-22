package filippos.bagordakis.agora.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestDTO extends BaseDTO {

	private static final long serialVersionUID = 7103375498124675739L;

	private List<String> targets;
	private String jsonData;

	private RequestDTO(Builder builder) {
		super(builder.id);
		this.targets = builder.targets;
		this.jsonData = builder.jsonData;
	}

	@Override
	public String toString() {
		return "RequestDTO [jsonData=" + jsonData + ", ID=" + getId() + "]";
	}

	public List<String> getTarget() {
		return targets;
	}

	public static class Builder {
		private UUID id;
		private List<String> targets = new ArrayList<String>();
		private String jsonData;

		public Builder(UUID id, String jsonData) {
			this.id = id;
		}

		public Builder target(List<String> targets) {
			this.targets = targets;
			return this;
		}

		public Builder addTarget(String target) {
			targets.add(target);
			return this;
		}

		public RequestDTO build() {
			return new RequestDTO(this);
		}
	}

	// Getters, Setters and other methods can be added here

}
