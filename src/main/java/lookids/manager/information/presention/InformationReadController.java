package lookids.manager.information.presention;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lookids.manager.common.entity.BaseResponse;
import lookids.manager.information.application.InformationService;
import lookids.manager.information.dto.out.InformationResponseDto;
import lookids.manager.information.vo.out.InformationResponseVo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/read/information")
public class InformationReadController {

	private final InformationService informationService;

	@Operation(summary = "InformationList 조회 API", description = "InformationList 조회 API 입니다.", tags = {"information"})
	@GetMapping("/manager")
	public BaseResponse<List<InformationResponseVo>> readInformationList(String managerUuid) {
		List<InformationResponseDto> informationResponseDtoList = informationService.readInformationList(managerUuid);
		return new BaseResponse<>(informationResponseDtoList.stream().map(InformationResponseDto::toVo).toList());
	}

	@Operation(summary = "information 조회 API", description = "information 조회 API 입니다.", tags = {"information"})
	@GetMapping()
	public BaseResponse<InformationResponseVo> readInformation(@RequestParam String feedCode) {
		return new BaseResponse<>(informationService.readInformation(feedCode).toVo());
	}
}
