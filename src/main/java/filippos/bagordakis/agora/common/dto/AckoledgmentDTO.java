package filippos.bagordakis.agora.common.dto;

import java.util.UUID;

public class AckoledgmentDTO  extends BaseDTO  {

	private static final long serialVersionUID = -5342738410119871537L;
	
	public Throwable error;

	public AckoledgmentDTO(UUID id) {
		super(id);
	}
	
	public AckoledgmentDTO(UUID id, Throwable e) {
		super(id);
		this.error = e;
	}

	public void setError(Throwable e) {
		this.error = e;
	}

}
