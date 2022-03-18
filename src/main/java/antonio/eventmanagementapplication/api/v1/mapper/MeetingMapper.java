package antonio.eventmanagementapplication.api.v1.mapper;

import antonio.eventmanagementapplication.api.v1.model.MeetingDTO;
import antonio.eventmanagementapplication.domain.Meeting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeetingMapper {

    MeetingMapper INSTANCE = Mappers.getMapper(MeetingMapper.class);

    MeetingDTO meetingToMeetingDTO(Meeting meeting);

    Meeting meetingDtoToMeeting(MeetingDTO meetingDTO);
}
