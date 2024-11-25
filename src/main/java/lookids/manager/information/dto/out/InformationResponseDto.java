package lookids.manager.information.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.information.domain.Information;
import lookids.manager.information.vo.out.InformationResponseVo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformationResponseDto {

	private String title;
	private String content;
	private List<String> mediaUrlList;
	private LocalDateTime createdAt;

	public static InformationResponseDto toDto(Information information) {
		return InformationResponseDto.builder()
				.title(information.getTitle())
				.content(information.getContent())
				.mediaUrlList(information.getMediaUrlList())
				.createdAt(information.getCreatedAt())
				.build();
	}

	public InformationResponseVo toVo() {
		return InformationResponseVo.builder()
				.title(title)
				.content(content)
				.mediaUrlList(mediaUrlList)
				.createdAt(createdAt)
				.build();
	}

}
