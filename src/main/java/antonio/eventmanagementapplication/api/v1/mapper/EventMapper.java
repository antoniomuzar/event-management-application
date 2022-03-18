package antonio.eventmanagementapplication.api.v1.mapper;

import antonio.eventmanagementapplication.api.v1.model.EventDTO;
import antonio.eventmanagementapplication.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDTO eventToEventDTO(Event event);

    Event eventDtoToEvent (EventDTO eventDTO);
}
