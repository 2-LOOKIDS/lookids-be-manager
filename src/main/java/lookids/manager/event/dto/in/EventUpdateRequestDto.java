package lookids.manager.event.dto.in;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.event.domain.Event;
import lookids.manager.event.vo.in.EventRequestVo;
import lookids.manager.event.vo.in.EventUpdateRequestVo;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventUpdateRequestDto {

	private String eventCode;
	private String thumbnail;
	private String eventName;
	private String content;
	private String description;
	private LocalDateTime expiredAt;

	public static EventUpdateRequestDto toDto(String eventCode, EventUpdateRequestVo eventUpdateRequestVo) {
		return EventUpdateRequestDto.builder()
			.eventCode(eventCode)
			.thumbnail(eventUpdateRequestVo.getThumbnail())
			.eventName(eventUpdateRequestVo.getEventName())
			.content(eventUpdateRequestVo.getContent())
			.description(eventUpdateRequestVo.getDescription())
			.expiredAt(eventUpdateRequestVo.getExpiredAt())
			.build();
	}

	public Event toUpdate(Event event) {
		return Event.builder()
			.id(event.getId())
			.eventCode(event.getEventCode())
			.thumbnail(thumbnail)
			.eventName(eventName)
			.content(content)
			.description(description)
			.expiredAt(expiredAt)
			.build();
	}

}
