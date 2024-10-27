package lookids.manager.information.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.manager.common.entity.BaseEntity;
import lookids.manager.information.dto.in.InformationRequestDto;

import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Information extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String managerUuid;

	@Column(nullable = false)
	private String feedCode;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private List<String> mediaUrls;

	public void update(InformationRequestDto informationRequestDto) {
		this.title = informationRequestDto.getTitle();
		this.content = informationRequestDto.getContent();
		this.mediaUrls = informationRequestDto.getMediaUrls();
	}
}
