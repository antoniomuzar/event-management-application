package antonio.eventmanagementapplication.services;

import antonio.eventmanagementapplication.api.v1.model.MeetingDTO;

import java.util.List;

public interface MeetingService {

    List<MeetingDTO>getAllMeetings();

    MeetingDTO getMeetingById(Long id);

    MeetingDTO createNewMeeting(MeetingDTO meetingDTO);

    MeetingDTO saveMeetingByDTO(Long id , MeetingDTO meetingDTO);

    MeetingDTO patchMeeting(Long id , MeetingDTO meetingDTO);

    void deleteMeetingById(Long id);
}
