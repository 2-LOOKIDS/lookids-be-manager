package lookids.manager.policy.presention;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lookids.manager.common.entity.BaseResponse;
import lookids.manager.common.entity.BaseResponseStatus;
import lookids.manager.policy.application.PolicyService;
import lookids.manager.policy.dto.in.PolicyRequestDto;
import lookids.manager.policy.vo.in.PolicyRequestVo;
import lookids.manager.policy.vo.out.PolicyResponseVo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/policy")
public class PolicyController {

	private final PolicyService policyService;

	@Operation(summary = "policy 등록 API", description = "policy 등록 API 입니다.", tags = {"policy"})
	@PostMapping
	public BaseResponse<Void> createPolicy(@RequestBody PolicyRequestVo policyRequestVo) {
		policyService.createPolicy(PolicyRequestDto.toDto(policyRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "policy 조회 API", description = "policy 조회 API 입니다.", tags = {"policy"})
	@GetMapping()
	public BaseResponse<PolicyResponseVo> readPolicy(@RequestParam String policyCode) {
		return new BaseResponse<>(policyService.readPolicy(policyCode).toVo());
	}
}
