package lookids.manager.information.application;

import lombok.RequiredArgsConstructor;
import lookids.manager.common.entity.BaseResponseStatus;
import lookids.manager.common.exception.BaseException;
import lookids.manager.information.domain.Information;
import lookids.manager.information.dto.in.InformationRequestDto;
import lookids.manager.information.dto.out.InformationResponseDto;
import lookids.manager.information.infrastructure.InformationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

	private final InformationRepository informationRepository;

	@Override
	public void createInformation(InformationRequestDto informationRequestDto) {
		informationRepository.save(informationRequestDto.toEntity());
	}

	@Override
	public InformationResponseDto readInformation(String feedCode) {
		return InformationResponseDto.toDto(informationRepository.findByFeedCode(feedCode)
				.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FEED)));
	}

	@Override
	public List<InformationResponseDto> readInformationList(String managerUuid) {
		List<Information> InformationList = informationRepository.findByManagerUuid(managerUuid);
		return InformationList.stream().map(InformationResponseDto::toDto).toList();
	}

	@Override
	public void updateInformation(InformationRequestDto informationRequestDto) {
		Information information = informationRepository.findByFeedCode(informationRequestDto.getFeedCode())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FEED));
		information.update(informationRequestDto);
		informationRepository.save(information);
	}

	@Transactional
	@Override
	public void deleteInformation(String feedCode) {
		Information information = informationRepository.findByFeedCode(feedCode)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FEED));
		informationRepository.deleteByFeedCode(feedCode);
	}
}
