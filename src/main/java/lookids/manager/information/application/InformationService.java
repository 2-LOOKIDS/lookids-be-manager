package lookids.manager.information.application;

import lookids.manager.information.dto.in.InformationRequestDto;
import lookids.manager.information.dto.out.InformationResponseDto;

import java.util.List;

public interface InformationService {

	void createInformation(InformationRequestDto informationRequestDto);
	InformationResponseDto readInformation(String feedCode);
	List<InformationResponseDto> readInformationList(String managerUuid);
	void updateInformation(InformationRequestDto informationRequestDto);
	void deleteInformation(String feedCode);


}
