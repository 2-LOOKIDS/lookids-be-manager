package lookids.manager.event.application;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lookids.manager.common.entity.BaseResponseStatus;
import lookids.manager.common.exception.BaseException;
import lookids.manager.event.domain.Event;
import lookids.manager.event.dto.in.EventRequestDto;
import lookids.manager.event.dto.out.EventResponseDto;
import lookids.manager.event.infrastructure.EventRepository;
import lookids.manager.event.vo.out.EventResponseVo;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

	private final EventRepository eventRepository;

	@Override
	public void createEvent(EventRequestDto eventRequestDto) {
		eventRepository.save(eventRequestDto.toEntity());
	}

	@Override
	public EventResponseDto readEvent(String eventCode) {
		return EventResponseDto.toDto(eventRepository.findByEventCode(eventCode)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FEED)));
	}

	@Override
	public List<EventResponseDto> readGoingEventList() {
		LocalDateTime currentTime = LocalDateTime.now();
		return eventRepository.findByExpiredAtAfter(currentTime).stream()
			.map(EventResponseDto::toDto)
			.toList();
	}

	@Override
	public List<EventResponseDto> readExpiredEventList() {
		LocalDateTime currentTime = LocalDateTime.now();
		return eventRepository.findByExpiredAtBefore(currentTime).stream()
			.map(EventResponseDto::toDto)
			.toList();
	}

	@Override
	public void updateEvent(EventRequestDto eventRequestDto) {
		Event event = eventRepository.findByEventCode(eventRequestDto.getEventCode())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
		event.update(eventRequestDto);
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(String eventCode) {
		Event event = eventRepository.findByEventCode(eventCode)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FEED));
		eventRepository.deleteByEventCode(eventCode);
	}

}
