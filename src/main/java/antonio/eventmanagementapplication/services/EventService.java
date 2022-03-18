package antonio.eventmanagementapplication.services;

import antonio.eventmanagementapplication.api.v1.model.EventDTO;
import antonio.eventmanagementapplication.api.v1.model.UserDTO;
import antonio.eventmanagementapplication.domain.User;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    EventDTO createNewEvent(EventDTO eventDTO);

    EventDTO saveEventByDTO(Long id, EventDTO eventDTO);

    EventDTO patchEvent(Long id , EventDTO eventDTO);

    void deleteEventById(Long id);
    
}
