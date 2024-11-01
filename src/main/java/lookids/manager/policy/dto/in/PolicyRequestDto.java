package lookids.manager.policy.dto.in;

import org.w3c.dom.Text;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.policy.domain.Policy;
import lookids.manager.policy.vo.in.PolicyRequestVo;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyRequestDto {

	private String policyName;
	private String content;

	public Policy toEntity(String policyCode) {
		return Policy.builder()
			.policyCode(policyCode)
			.policyName(policyName)
			.content(content)
			.build();
	}

	public static PolicyRequestDto toDto(PolicyRequestVo policyRequestVo) {
		return PolicyRequestDto.builder()
			.policyName(policyRequestVo.getPolicyName())
			.content(policyRequestVo.getContent())
			.build();
	}
}
