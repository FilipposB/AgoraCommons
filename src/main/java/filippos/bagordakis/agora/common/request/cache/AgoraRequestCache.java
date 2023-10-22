package filippos.bagordakis.agora.common.request.cache;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import filippos.bagordakis.agora.common.dto.AckoledgmentDTO;
import filippos.bagordakis.agora.common.dto.BaseDTO;

public class AgoraRequestCache {

	private final ConcurrentHashMap<UUID, BaseDTO> cache = new ConcurrentHashMap<>();
	private final ScheduledExecutorService evictionService = Executors.newScheduledThreadPool(1);
	private final ConcurrentMap<UUID, ScheduledFuture<?>> evictionTasks = new ConcurrentHashMap<>();
	private final long durationInMillis;
	private final Consumer<BaseDTO> onEvictionFunction;

	public AgoraRequestCache(Duration duration, Consumer<BaseDTO> onEvictionFunction) {
		this.durationInMillis = duration.toMillis();
		this.onEvictionFunction = onEvictionFunction;
	}

	public void put(BaseDTO dto) {
		cache.put(dto.getId(), dto);

		ScheduledFuture<?> evictionTask = evictionService.schedule(() -> {
			BaseDTO removedValue = cache.remove(dto.getId());
			if (removedValue != null) {
				onEvictionFunction.accept(removedValue);
			}
		}, durationInMillis, TimeUnit.MILLISECONDS);

		ScheduledFuture<?> previousTask = evictionTasks.put(dto.getId(), evictionTask);
		if (previousTask != null) {
			previousTask.cancel(false);
		}
	}

	public BaseDTO remove(AckoledgmentDTO acknowledgmentDTO) {
		ScheduledFuture<?> task = evictionTasks.remove(acknowledgmentDTO.getId());
		if (task != null) {
			task.cancel(false);
		}
		return cache.remove(acknowledgmentDTO.getId());
	}
}