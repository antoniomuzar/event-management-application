package antonio.eventmanagementapplication.services;

import antonio.eventmanagementapplication.api.v1.mapper.EventMapper;
import antonio.eventmanagementapplication.api.v1.mapper.MeetingMapper;
import antonio.eventmanagementapplication.api.v1.mapper.UserMapper;
import antonio.eventmanagementapplication.api.v1.model.EventDTO;
import antonio.eventmanagementapplication.controllers.v1.EventController;
import antonio.eventmanagementapplication.repositories.EventRepository;
import antonio.eventmanagementapplication.domain.Event;
import antonio.eventmanagementapplication.repositories.MeetingRepository;
import antonio.eventmanagementapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final MeetingMapper meetingMapper;
    private final MeetingRepository meetingRepository;

    public EventServiceImpl(EventMapper eventMapper, EventRepository eventRepository, UserMapper userMapper, UserRepository userRepository, MeetingMapper meetingMapper, MeetingRepository meetingRepository) {
        this.eventMapper = eventMapper;
        this.eventRepository = eventRepository;
        this.userMapper = userMapper;
        this.userRepository=userRepository;
        this.meetingMapper = meetingMapper;
        this.meetingRepository = meetingRepository;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(event ->{
                    EventDTO eventDTO= eventMapper.eventToEventDTO(event);
                    eventDTO.setEventUrl(getEventUrl(event.getId()));
                    return eventDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::eventToEventDTO)
                .map(eventDTO ->{
                    eventDTO.setEventUrl(getEventUrl(id));
                    return eventDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public EventDTO createNewEvent(EventDTO eventDTO) {
        return saveAndReturnDTO(eventMapper.eventDtoToEvent(eventDTO));
    }


    private EventDTO saveAndReturnDTO(Event event) {
        Event savedEvent = eventRepository.save(event);

        EventDTO returnDto=eventMapper.eventToEventDTO(savedEvent);

        returnDto.setEventUrl(getEventUrl(savedEvent.getId()));

        return returnDto;
    }

    @Override
    public EventDTO saveEventByDTO(Long id, EventDTO eventDTO) {

        Event event= eventMapper.eventDtoToEvent(eventDTO);
        event.setId(id);

        return saveAndReturnDTO(event);
    }


    @Override
    public EventDTO patchEvent(Long id, EventDTO eventDTO) {
        return eventRepository.findById(id).map(event -> {

            if(eventDTO.getName() != null){
                event.setName(eventDTO.getName());
            }

            if(eventDTO.getDescription() != null){
                event.setDescription(eventDTO.getDescription());
            }
            if(eventDTO.getDate() != null){
                event.setDate(eventDTO.getDate());
            }

            EventDTO returnDto = eventMapper.eventToEventDTO(eventRepository.save(event));

            returnDto.setEventUrl(getEventUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    private String getEventUrl(Long id){
        return EventController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);

    }


}
