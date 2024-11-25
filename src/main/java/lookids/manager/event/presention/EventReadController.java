package lookids.manager.event.presention;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lookids.manager.common.entity.BaseResponse;
import lookids.manager.event.application.EventService;
import lookids.manager.event.dto.out.EventResponseDto;
import lookids.manager.event.vo.out.EventResponseVo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/read/event")
public class EventReadController {

	private final EventService eventService;

	@Operation(summary = "진행 중인 event 리스트 조회 API", description = "진행 중인 event 리스트 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/going")
	public BaseResponse<List<EventResponseVo>> readGoingEventList() {
		List<EventResponseDto> readGoingEventList = eventService.readGoingEventList();
		return new BaseResponse<>(readGoingEventList.stream().map(EventResponseDto::toVo).toList());
	}
	@Operation(summary = "마감된 event 리스트 조회 API", description = "마감된 event 리스트 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/expired")
	public BaseResponse<List<EventResponseVo>> readExpiredEventList() {
		List<EventResponseDto> readExpiredEventList = eventService.readExpiredEventList();
		return new BaseResponse<>(readExpiredEventList.stream().map(EventResponseDto::toVo).toList());
	}

	@Operation(summary = "event detail 조회 API", description = "event detail 조회 API 입니다.", tags = {"Event"})
	@GetMapping("/detail")
	public BaseResponse<EventResponseVo> readEvent(@RequestParam String eventCode) {
		return new BaseResponse<>(eventService.readEvent(eventCode).toVo());
	}
}
