package antonio.eventmanagementapplication.controllers.v1;

import antonio.eventmanagementapplication.api.v1.model.*;
import antonio.eventmanagementapplication.services.MeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(MeetingController.BASE_URL)
public class MeetingController {

    public static final String BASE_URL = "/api/v1/meetings";

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }


    @ApiOperation("List of Meetings")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  MeetingListDTO getListOfMeetings(){
        return new MeetingListDTO(meetingService.getAllMeetings());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public MeetingDTO getMeetingById(@PathVariable Long id){
        return meetingService.getMeetingById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeetingDTO createNewMeeting(@RequestBody MeetingDTO meetingDTO){
        return meetingService.createNewMeeting(meetingDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public MeetingDTO updateMeeting(@PathVariable Long id, @RequestBody MeetingDTO meetingDTO){
        return meetingService.saveMeetingByDTO(id, meetingDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public MeetingDTO patchEvent(@PathVariable Long id, @RequestBody MeetingDTO meetingDTO){
        return meetingService.patchMeeting(id, meetingDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteMeeting(@PathVariable Long id){
        meetingService.deleteMeetingById(id);
    }
}