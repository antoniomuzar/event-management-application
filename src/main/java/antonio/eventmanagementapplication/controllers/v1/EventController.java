package antonio.eventmanagementapplication.controllers.v1;
import antonio.eventmanagementapplication.api.v1.model.*;
import antonio.eventmanagementapplication.services.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(EventController.BASE_URL)
public class EventController {

    public static final String BASE_URL = "/api/v1/events";

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @ApiOperation("List of Events")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EventListDTO getListOfEvents(){
        return new EventListDTO(eventService.getAllEvents());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public EventDTO getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDTO createNewEvent(@RequestBody EventDTO eventDTO){
        return eventService.createNewEvent(eventDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public EventDTO updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        return eventService.saveEventByDTO(id, eventDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public EventDTO patchEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        return eventService.patchEvent(id, eventDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        eventService.deleteEventById(id);
    }
}