package filippos.bagordakis.agora.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestDTO extends BaseDTO {

	private static final long serialVersionUID = 7103375498124675739L;

	private final List<String> targets;
	private final String jsonData;
	private final String keyword;

	private RequestDTO(Builder builder) {
		super(builder.id);
		this.targets = builder.targets;
		this.jsonData = builder.jsonData;
		this.keyword = builder.keyword;
	}
	
	

	@Override
	public String toString() {
		return "RequestDTO [targets=" + targets + ", jsonData=" + jsonData + ", keyword=" + keyword + "]";
	}


	public List<String> getTarget() {
		return targets;
	}

	public String getKeyword() {
		return keyword;
	}


	public List<String> getTargets() {
		return targets;
	}

	public String getJsonData() {
		return jsonData;
	}



	public static class Builder {
		private UUID id;
		private List<String> targets = new ArrayList<String>();
		private String jsonData;
		private String keyword;

		public Builder(UUID id, String jsonData, String keyword) {
			this.id = id;
			this.jsonData = jsonData;
			this.keyword = keyword;
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


}
