package lookids.manager.policy.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.policy.domain.Policy;
import lookids.manager.policy.vo.out.PolicyResponseVo;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponseDto {

	private String policyName;
	private String content;

	public static PolicyResponseDto toDto(Policy policy) {
		return PolicyResponseDto.builder()
			.policyName(policy.getPolicyName())
			.content(policy.getContent())
			.build();
	}

	public PolicyResponseVo toVo() {
		return PolicyResponseVo.builder()
			.policyName(policyName)
			.content(content)
			.build();
	}
}
