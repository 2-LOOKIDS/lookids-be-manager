package lookids.manager.policy.vo.out;

import java.time.LocalDateTime;

import org.w3c.dom.Text;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponseVo {

	private String policyName;
	private String content;

}
