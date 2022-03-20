package antonio.eventmanagementapplication.bootstrap;
import antonio.eventmanagementapplication.domain.Event;
import antonio.eventmanagementapplication.domain.Meeting;
import antonio.eventmanagementapplication.domain.User;
import antonio.eventmanagementapplication.repositories.EventRepository;
import antonio.eventmanagementapplication.repositories.MeetingRepository;
import antonio.eventmanagementapplication.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Boostrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final MeetingRepository meetingRepository;


    public Boostrap(UserRepository userRepository, EventRepository eventRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.meetingRepository = meetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData (){

            User user1 = new User();
            user1.setId(1L);
            user1.setFirstName("Sarah");
            user1.setLastName("McDonald");
            user1.setCompany("OS-Tech");
            user1.setUserEmail("sarah.mcdonald@ostech.com");
            user1.setUserUrl("api/v1/users/1");

            userRepository.save(user1);

            User user2 = new User();
            user2.setId(2L);
            user2.setFirstName("Sam");
            user2.setLastName("Catsby");
            user2.setCompany("Strings");
            user2.setUserEmail("sam.catsby@strings.com");
            user2.setUserUrl("api/v1/users/2");
            userRepository.save(user2);

            User user3 = new User();
            user3.setId(3L);
            user3.setFirstName("Dora");
            user3.setLastName("Mitchel");
            user3.setCompany("Solootions");
            user3.setUserEmail("dora.mitchel@solootions.com");
            user3.setUserUrl("api/v1/users/3");

            userRepository.save(user3);



            User user4 = new User();
            user4.setId(4L);
            user4.setFirstName("Jack");
            user4.setLastName("Getback");
            user4.setCompany("The Fellowship");
            user4.setUserEmail("jack.getback@fellowship.com");
            user4.setUserUrl("api/v1/users/4");

            userRepository.save(user4);


            User user5 = new User();
            user5.setId(5L);
            user5.setFirstName("Jonah");
            user5.setLastName("Zant");
            user5.setCompany("Micro_Meecro");
            user5.setUserEmail("jonah-zant@micmeec.com");
            user5.setUserUrl("api/v1/users/5");

            userRepository.save(user5);


            User user6 = new User();
            user6.setId(6L);
            user6.setFirstName("Jessica");
            user6.setLastName("Schwarz");
            user6.setCompany("Boring IT company");
            user6.setUserEmail("jessica-schwarz@boringit.com");
            user6.setUserUrl("api/v1/users/6");

            userRepository.save(user6);

            User user7 = new User();
            user7.setId(7L);
            user7.setFirstName("Goran");
            user7.setLastName("Maric");
            user7.setCompany("W.R.Developing");
            user7.setUserEmail("goran.maric@wrdeveloping.com");
            user7.setUserUrl("api/v1/users/7");
            userRepository.save(user7);

            User user8 = new User();
            user8.setId(8L);
            user8.setFirstName("Maja");
            user8.setLastName("Babic");
            user8.setCompany("GrApple");
            user8.setUserEmail("maja.babic@grapple.com");
            user8.setUserUrl("api/v1/users/8");

            userRepository.save(user8);

            User user9 = new User();
            user9.setId(9L);
            user9.setFirstName("Helena");
            user9.setLastName("Kovac");
            user9.setCompany("Adria Development");
            user9.setUserEmail("helena.kovac@adriadevelopment.com");
            user9.setUserUrl("api/v1/users/9");
            userRepository.save(user9);

            User user10 = new User();
            user10.setId(10L);
            user10.setFirstName("Jakov");
            user10.setLastName("Herceg");
            user10.setCompany("Pointers");
            user10.setUserEmail("jakov.herceg@pointers.com");
            user10.setUserUrl("api/v1/users/10");

            userRepository.save(user10);

             Meeting ecoMeeting= new Meeting();
             ecoMeeting.setName("Croatian nature");
             ecoMeeting.setDescription("Preserving the croatian nature");
             ecoMeeting.setTime("12.00pm");
             ecoMeeting.getMeetingAtendee().add(user7);
             ecoMeeting.getMeetingAtendee().add(user8);
             ecoMeeting.getMeetingAtendee().add(user9);

             meetingRepository.save(ecoMeeting);

             Meeting sightseeingMeeting = new Meeting();
             sightseeingMeeting.setName("Burj Khalifa sightseing");
             sightseeingMeeting.setDescription("Arrangements about visiting Burj Khalifa");
             sightseeingMeeting.setTime("05.00pm");
             sightseeingMeeting.getMeetingAtendee().add(user3);
        sightseeingMeeting.getMeetingAtendee().add(user4);
        sightseeingMeeting.getMeetingAtendee().add(user1);

             meetingRepository.save(sightseeingMeeting);



            Event ecoWorldConference = new Event();
            ecoWorldConference.setName("Eco World Conference");
            ecoWorldConference.setDescription("World conference about protecting and preserving nature");
            ecoWorldConference.setDate("23-04-2022");
            ecoWorldConference.setLocation("Paris");
            ecoWorldConference.setId(1l);
            ecoWorldConference.getUsers().add(user6);
            ecoWorldConference.getUsers().add(user2);
            ecoWorldConference.getUsers().add(user3);
            ecoWorldConference.getUsers().add(user8);
            ecoWorldConference.getMeetings().add(ecoMeeting);

            eventRepository.save(ecoWorldConference);


            Event cyberSecurityConvention = new Event();
            cyberSecurityConvention.setName("Cyber Security Convention");
            cyberSecurityConvention.setDescription("Leading world experts in cyber security field discuss cyber security");
            cyberSecurityConvention.setDate("15-6-2022");
            cyberSecurityConvention.setLocation("Los Angeles");
            cyberSecurityConvention.setId(2L);
            cyberSecurityConvention.getUsers().add(user4);
            cyberSecurityConvention.getUsers().add(user3);
            cyberSecurityConvention.getUsers().add(user6);
            cyberSecurityConvention.getUsers().add(user2);


            eventRepository.save(cyberSecurityConvention);


            Event dubaiDeveloperExpo = new Event();
            dubaiDeveloperExpo.setName("Dubai Developer Expo");
            dubaiDeveloperExpo.setDescription("Developers from all around the world coming to Dubai to present their products.");
            dubaiDeveloperExpo.setDate("07-10-2022");
            dubaiDeveloperExpo.setLocation("Dubai");
            dubaiDeveloperExpo.setId(3L);
            dubaiDeveloperExpo.getUsers().add(user9);
            dubaiDeveloperExpo.getUsers().add(user8);
            dubaiDeveloperExpo.getUsers().add(user7);
            dubaiDeveloperExpo.getUsers().add(user2);
            dubaiDeveloperExpo.getUsers().add(user1);


            eventRepository.save(dubaiDeveloperExpo);


            Event worldTelecommunicationCongress = new Event();
            worldTelecommunicationCongress.setName("World Telecommunication Congress");
            worldTelecommunicationCongress.setDescription("Discuss about latest telecommunication technologies and ensuring " +
                    "their efficiency and widespread public usefulness and availability.");
            worldTelecommunicationCongress.setDate("28-12-2022");
            worldTelecommunicationCongress.setLocation("Shanghai");
            worldTelecommunicationCongress.setId(4L);
            worldTelecommunicationCongress.getUsers().add(user10);
            worldTelecommunicationCongress.getUsers().add(user5);
            worldTelecommunicationCongress.getUsers().add(user3);
            worldTelecommunicationCongress.getUsers().add(user1);
            worldTelecommunicationCongress.getUsers().add(user4);
            worldTelecommunicationCongress.getUsers().add(user2);


            eventRepository.save(worldTelecommunicationCongress);

        System.out.println("Loaded Users, Events and Meetings loaded");

        }
    }


