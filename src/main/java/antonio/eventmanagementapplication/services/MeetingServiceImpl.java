package antonio.eventmanagementapplication.services;


import antonio.eventmanagementapplication.api.v1.mapper.MeetingMapper;
import antonio.eventmanagementapplication.api.v1.model.MeetingDTO;
import antonio.eventmanagementapplication.controllers.v1.MeetingController;
import antonio.eventmanagementapplication.domain.Meeting;
import antonio.eventmanagementapplication.repositories.MeetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService{

    private final MeetingMapper meetingMapper;

    private final MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingMapper meetingMapper, MeetingRepository meetingRepository) {
        this.meetingMapper = meetingMapper;
        this.meetingRepository=meetingRepository;

    }


    @Override
    public List<MeetingDTO> getAllMeetings() {
        return meetingRepository
                .findAll()
                .stream()
                .map(meeting ->{
                        MeetingDTO meetingDTO =meetingMapper.meetingToMeetingDTO(meeting);
                        meetingDTO.setMeetingUrl(getMeetingUrl(meeting.getId()));

                        return meetingDTO;
                })
            .collect(Collectors.toList());
    }

    @Override
    public MeetingDTO getMeetingById(Long id) {
        return meetingRepository.findById(id)
                .map(meetingMapper::meetingToMeetingDTO)
                .map(meetingDTO ->{
                    meetingDTO.setMeetingUrl(getMeetingUrl(id));
                    return meetingDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MeetingDTO createNewMeeting(MeetingDTO meetingDTO) {
        return saveAndReturnDTO(meetingMapper.meetingDtoToMeeting(meetingDTO));
    }


    private MeetingDTO saveAndReturnDTO (Meeting meeting){

        Meeting savedMeeting= meetingRepository.save(meeting);

        MeetingDTO returnDto=meetingMapper.meetingToMeetingDTO(savedMeeting);

        returnDto.setMeetingUrl(getMeetingUrl(savedMeeting.getId()));

        return returnDto;
    }

    @Override
    public MeetingDTO saveMeetingByDTO(Long id, MeetingDTO meetingDTO) {

        Meeting meeting= meetingMapper.meetingDtoToMeeting(meetingDTO);
        meeting.setId(id);

        return saveAndReturnDTO(meeting);
    }


    @Override
    public MeetingDTO patchMeeting(Long id, MeetingDTO meetingDTO) {
        return meetingRepository.findById(id).map(meeting -> {

            if(meetingDTO.getName() != null){
                meeting.setName(meetingDTO.getName());
            }

            if(meetingDTO.getDescription() != null){
                meeting.setDescription(meetingDTO.getDescription());
            }

            MeetingDTO returnDto = meetingMapper.meetingToMeetingDTO(meetingRepository.save(meeting));

            returnDto.setMeetingUrl(getMeetingUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    private String getMeetingUrl(Long id){
        return MeetingController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteMeetingById(Long id) {

    }
}
