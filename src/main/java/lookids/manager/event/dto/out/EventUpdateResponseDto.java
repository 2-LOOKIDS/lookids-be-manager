package lookids.manager.event.dto.out;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventUpdateResponseDto {

	private String thumbnail;
	private String eventName;
	private String content;
	private String description;
	private LocalDateTime expiredAt;

}
