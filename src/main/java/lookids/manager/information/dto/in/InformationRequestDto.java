package lookids.manager.information.dto.in;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.information.domain.Information;
import lookids.manager.information.vo.in.InformationRequestVo;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformationRequestDto {

	private String managerUuid;
	private String title;
	private String content;
	private List<String> mediaUrlList;

	public Information toEntity() {
		return Information.builder()
			.managerUuid(managerUuid)
			.feedCode(UUID.randomUUID().toString())
			.title(title)
			.mediaUrlList(mediaUrlList)
			.content(content)
			.build();
	}

	public static InformationRequestDto toDto(InformationRequestVo informationRequestVo) {
		return InformationRequestDto.builder()
			.managerUuid(informationRequestVo.getManagerUuid())
			.title(informationRequestVo.getTitle())
			.content(informationRequestVo.getContent())
			.mediaUrlList(informationRequestVo.getMediaUrlList())
			.build();
	}
}
