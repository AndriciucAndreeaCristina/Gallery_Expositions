package pao.application;

import lombok.SneakyThrows;
import pao.config.DatabaseConfiguration;
import pao.exceptions.CustomNoDataException;
import pao.model.abstracts.Artist;
import pao.model.artworks.Artwork;
import pao.model.artworks.enums.Materials;
import pao.model.events.Course;
import pao.model.events.CreativeWorkshop;
import pao.model.exhibitions.Exhibition;
import pao.model.exhibitions.TemporaryExhibition;
import pao.model.floorplan.Room;
import pao.model.floorplan.enums.SectionsType;
import pao.services.impl.artworks.ArtworkInterfaceImplementation;
import pao.services.impl.events.EventCourseInterfaceImplementation;
import pao.services.impl.events.EventWorkshopInterfaceImplementation;
import pao.services.impl.exhibitions.PermanentExhibitionInterfaceImplementation;
import pao.services.impl.exhibitions.TemporaryExhibitionInterfaceImplementation;
import pao.services.impl.floorplan.RoomInterfaceImplementation;
import pao.services.impl.floorplan.SectionInterfaceImplementation;
import pao.services.impl.repositories.ArtistRepositoryImpl;
import pao.services.interfaces.artworks.ArtworkInterface;
import pao.services.interfaces.events.EventInterface;
import pao.services.interfaces.exhibitions.ExhibitionInterface;
import pao.services.interfaces.floorplan.RoomInterface;
import pao.services.interfaces.floorplan.SectionInterface;
import pao.services.interfaces.repositories.ArtistRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Gallery {
    private static Gallery INSTANCE;
    private static final Logger logger = Logger.getLogger("Gallery");
    private static final Connection connection;

    static {
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //artwork services
    //private final ArtistInterface artistService = new ArtistInterfaceImplementation();
    private final ArtistRepository artistRepository = new ArtistRepositoryImpl();
    private final ArtworkInterface artworkService = new ArtworkInterfaceImplementation();

    //event services
    private final EventInterface courseService = new EventCourseInterfaceImplementation();
    private final EventInterface workshopService = new EventWorkshopInterfaceImplementation();

    //exhibition services
    private final ExhibitionInterface permanentExhibitionService = new PermanentExhibitionInterfaceImplementation();
    private final ExhibitionInterface temporaryExhibitionService = new TemporaryExhibitionInterfaceImplementation();

    //floorplan services
    private final RoomInterface roomService = new RoomInterfaceImplementation();
    private final SectionInterface sectionService = new SectionInterfaceImplementation();

    public static Gallery getInstance() throws SQLException {
        return (INSTANCE == null ? new Gallery() : INSTANCE);
    }

    private Gallery() throws SQLException {}

    @SneakyThrows
    public void intro(Scanner scanner) {

        String intro = """
                                    
                                    
                          ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ███╗   ██╗ ██████╗ ██╗   ██╗ █████╗      █████╗ ██████╗ ████████╗ ██╗
                          ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ████╗  ██║██╔═══██╗██║   ██║██╔══██╗    ██╔══██╗██╔══██╗╚══██╔══╝ ██║
                          ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║    ██╔██╗ ██║██║   ██║██║   ██║███████║    ███████║██████╔╝   ██║    ██║
                          ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║    ██║╚██╗██║██║   ██║╚██╗ ██╔╝██╔══██║    ██╔══██║██╔══██╗   ██║    ╚═╝
                          ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ██║ ╚████║╚██████╔╝ ╚████╔╝ ██║  ██║    ██║  ██║██║  ██║   ██║    ██╗
                           ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝     ╚═╝  ╚═══╝ ╚═════╝   ╚═══╝  ╚═╝  ╚═╝    ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═╝
                                                                                                                                                                                                                                               \s
                                
                ℕ𝕠𝕧𝕒𝔸𝕣𝕥 𝕚𝕤 𝕒𝕟 𝕚𝕟𝕕𝕖𝕡𝕖𝕟𝕕𝕖𝕟𝕥 𝕒𝕣𝕥 𝕘𝕒𝕝𝕝𝕖𝕣𝕪 𝕤𝕙𝕠𝕨𝕔𝕒𝕤𝕚𝕟𝕘 𝕝𝕖𝕒𝕕𝕚𝕟𝕘-𝕖𝕕𝕘𝕖 𝕔𝕠𝕟𝕥𝕖𝕞𝕡𝕠𝕣𝕒𝕣𝕪 𝕒𝕣𝕥, 𝕒𝕚𝕞𝕚𝕟𝕘 𝕥𝕠 𝕤𝕥𝕚𝕞𝕦𝕝𝕒𝕥𝕖 𝕕𝕚𝕒𝕝𝕠𝕘𝕦𝕖 𝕒𝕟𝕕 𝕖𝕩𝕔𝕙𝕒𝕟𝕘𝕖 𝕓𝕖𝕥𝕨𝕖𝕖𝕟 𝕥𝕙𝕖 𝔼𝕒𝕤𝕥𝕖𝕣𝕟 𝔼𝕦𝕣𝕠𝕡𝕖𝕒𝕟 𝕒𝕣𝕥 𝕤𝕔𝕖𝕟𝕖 𝕒𝕟𝕕 𝕥𝕙𝕖 𝕚𝕟𝕥𝕖𝕣𝕟𝕒𝕥𝕚𝕠𝕟𝕒𝕝 𝕔𝕠𝕞𝕞𝕦𝕟𝕚𝕥𝕪.
                                
                """;
        System.out.println(intro);

        Integer role = roleUsage(scanner);  //function returns 1 if the user is manager, 2 if it's not a manager, and 0 in the end, indicating an unhandled case

        if (role == 1) {
            managerFunctionalities(scanner);
        }

        else if (role == 2) {
            userFunctionalities(scanner);
        }

        else if (role == 0) {
            System.out.println("Something went wrong! Please try again!");
            exit(0);
        }
        connection.close();

    }

    private Integer roleUsage(Scanner scanner) {
        // we want to have a menu from which to choose a role
        System.out.println("How do you want to use the application? \n");
        System.out.println("        1 - Manager");
        System.out.println("        2 - User");
        System.out.print("Your choice: ");

        Integer choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("To log in as a manager, enter your password: ");
            System.out.println("Password: ");
            String pass = scanner.next().toString().strip();

            if (!"admin".equals(pass)) {
                System.out.println("Sorry, you have the wrong credentials! \n");
                System.out.println("You are logged in as a User!");
                return 2;
            }

            else {
                System.out.println("You are logged in as a Manager!");
                return 1;
            }
        }
        else if (choice == 2) {
            System.out.println("You are logged in as a User!");
            return 2;
        }

        else {
            System.out.println("Sorry, you have entered am invalid option. Please exit and try again.");
            exit(0);
        }
        return 0;
    }

    private void managerFunctionalities(Scanner scanner) throws Exception {
        System.out.println("What action would you like to perform?");
        System.out.println("        1 - Add an artist");
        System.out.println("        2 - Add an artwork");
        System.out.println("        3 - Modify an event");
        System.out.println("        4 - Add an exhibition");

        Integer choice = scanner.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("You have chosen an invalid option. Please try again!");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
            switch (choice) {
                case 1: {
                    // add an artist
                    Artist artist;
                    System.out.println("Enter all the fields: ");
                    String firstName, lastName, description;
                    Integer year, month, day, movement;
                    System.out.println("First Name: ");
                    firstName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Last Name: ");
                    lastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Description: ");
                    description = scanner.next();
                    scanner.nextLine();
                    System.out.println("Birthdate (year month day): ");
                    year = scanner.nextInt();
                    month = scanner.nextInt();
                    day = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movement: ");
                    System.out.println("    1 - COMPUTER_ART");
                    System.out.println("    2 - GRAFFITI_ART");
                    System.out.println("    3 - HYPERREALISM");
                    System.out.println("    4 - INSTALLATION_ART");
                    System.out.println("    5 - MINIMALISM");
                    System.out.println("    6 - PERFORMANCE_ART");
                    System.out.println("    7 - POP_ART");
                    System.out.println("    8 - POSTMODERNISM");
                    System.out.println("    9 - TRANSAVANTGARDE");
                    System.out.println("    10 - VIDEO_INSTALLATION");

                    movement = scanner.nextInt();
                    scanner.nextLine();

                    artist = Artist.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .firstName(firstName)
                            .lastName(lastName)
                            .birthDate(LocalDate.of(year, month, day))
                            .description(description)
                            .movement(SectionsType.values()[movement-1])
                            .build();
                    artistRepository.addArtist(artist);
                    //System.out.println(artistRepository.getAllArtistsFromList());
                    break;
                }
                case 2: {
                    //add an artwork
                    Artwork artwork;
                    Artist creator;
                    String title, description, firstName, lastName;
                    Integer year, typeId;

                    System.out.println("Enter all the fields: ");
                    System.out.println("Creator(FirstName): ");
                    firstName = scanner.next();
                    scanner.nextLine();
                    creator = artistRepository.getArtistByFirstName(firstName).orElse(null);
                    System.out.println("Title: ");
                    title = scanner.next();
                    scanner.nextLine();
                    System.out.println("Description: ");
                    description = scanner.next();
                    scanner.nextLine();
                    System.out.print("Year of Creation: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Materials (number in range 1-31): ");
                    typeId = scanner.nextInt();
                    scanner.nextLine();

                    artwork = Artwork.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .creator(creator)
                            .title(title)
                            .yearOfCreation(year)
                            .description(description)
                            .material(Materials.values()[typeId-1])
                            .build();
                    artworkService.addArtwork(artwork);
                    //System.out.println(artworkService.getArtworkByTitle(title));
                    break;
                }
                case 3: {
                    //modify an event
                    System.out.println("Choose the event to be modified: ");
                    List<Course> courses = (List<Course>) courseService.getAllEventsFromList();
                    System.out.println("    Courses: ");
                    Integer counter = 1;
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println( counter + " - " + courses.get(i));
                        counter += 1;
                    }
                    List<CreativeWorkshop> workshops = (List<CreativeWorkshop>) workshopService.getAllEventsFromList();
                    System.out.println("    Creative workshops: ");
                    for (int i = 0; i < workshops.size(); i++) {
                        System.out.print(counter + " - " + workshops.get(i));
                        counter += 1;
                    }
                    System.out.println("Work in progress...");
                    System.out.println("Try something else meanwhile!");
//                    Integer choice2 = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.println("What attribute would you like to modify?");
//                    System.out.println("        1 - Title");
//                    System.out.println("        2 - Price");
//                    Integer choice3 = scanner.nextInt();
//                    scanner.nextLine();
//                    if (choice2 <= courses.size()) {
//                        //modify a course
//                        Course course = courses.get(choice2-1);
//                        if (choice3.equals(1)) {
//                            System.out.println("Enter the new title: ");
//                            String title = scanner.next();
//                            scanner.nextLine();
//                            course.setTitle(title);
//                            courseService.modifyEventById(course.getId(), course);
//                            System.out.println("Successful modification!");
//                        }
//                        else if (choice3.equals(2)) {
//                            System.out.println("Enter the new price: ");
//                            Float price = scanner.nextFloat();
//                            scanner.nextLine();
//                            course.setPrice(price);
//                            courseService.modifyEventById(course.getId(), course);
//                            System.out.println("Successful modification!");
//                        }
//                        else {
//                            System.out.println("Invalid option!");
//                            exit(0);
//                        }
//                    }
//                    else {
//                        //modify a creative workshop
//                        CreativeWorkshop workshop = workshops.get(choice2 - courses.size()-1);
//                        if (choice3.equals(1)) {
//                            System.out.println("Enter the new title: ");
//                            String title = scanner.next();
//                            scanner.nextLine();
//                            workshop.setTitle(title);
//                            workshopService.modifyEventById(workshop.getId(), workshop);
//                            System.out.println("Successful modification!");
//                        }
//                        else if (choice3.equals(2)) {
//                            System.out.println("Enter the new price: ");
//                            Float price = scanner.nextFloat();
//                            scanner.nextLine();
//                            workshop.setPrice(price);
//                            workshopService.modifyEventById(workshop.getId(), workshop);
//                            System.out.println("Successful modification!");
//                        }
//                        else {
//                            System.out.println("Invalid option!");
//                            exit(0);
//                        }
//                    }
                    break;
                }
                case 4: {
                    //add an exhibition
                    String title, description;
                    List<Artwork> artworkList = new ArrayList<>();
                    Artwork artwork;
                    List<Artwork> existentArtworks = artworkService.getAllArtworksFromSet().stream().toList();
                    System.out.println("Title: ");
                    title = scanner.next();
                    scanner.nextLine();
                    System.out.println("Description: ");
                    description = scanner.next();
                    scanner.nextLine();
                    System.out.println("Choose one from the available artworks: ");
                    for (int i = 0; i < existentArtworks.size(); i++)
                    {
                        System.out.println("\t" + (i+1) + " - " + existentArtworks.get(i).getTitle().toString());
                    }
                    Integer choice4 = scanner.nextInt();
                    scanner.nextLine();
                    artworkList.add(existentArtworks.get(choice4-1));
                    Room room = roomService.getRoomsByFloor(0).get(7);
                    TemporaryExhibition tempExp = TemporaryExhibition.builder()
                            .id(UUID.randomUUID())
                            .title(title)
                            .description(description)
                            .artworksList(artworkList)
                            .startDate(LocalDate.now())
                            .endDate(LocalDate.now())
                            .room(room)
                            .build();
                    temporaryExhibitionService.addExhibition(tempExp);
                    System.out.println("Successful operartion!");
                    break;
                }
                default: {
                    System.out.println("Invalid option!");
                    exit(0);
                }
        }
        System.out.println("If you want to perform another action, rerun the program");
    }

    private void userFunctionalities(Scanner scanner) {
        System.out.println("What action would you like to perform?");
        System.out.println("        1 - Register for a course");
        System.out.println("        2 - Register for a creative workshop");
        System.out.println("        3 - Register for a temporary exhibition");

        Integer choice = scanner.nextInt();
        scanner.nextLine();
        List<Object> eventsToAttend = new ArrayList<>();
        switch (choice) {
            case 1: {
                try {
                    List<Course> courses = (List<Course>) courseService.getAllEventsFromList();
                    System.out.println("Choose a course: ");
                    System.out.println("    Courses: ");
                    if (courses.size() == 0) {
                        throw new CustomNoDataException("No data found!");
                    }
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + " - " + courses.get(i));
                    }
                    Integer choice2 = scanner.nextInt();
                    scanner.nextLine();
                    eventsToAttend.add(courses.get(choice2 - 1));
                    break;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    break;
                } catch (CustomNoDataException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            case 2 : {
                try {
                    List<CreativeWorkshop> workshops = (List<CreativeWorkshop>) workshopService.getAllEventsFromList();
                    System.out.println("    Creative workshops: ");
                    if (workshops.size() == 0)
                        throw new CustomNoDataException("No data found!");
                    for (int i = 0; i < workshops.size(); i++) {
                        System.out.print((i + 1) + " - " + workshops.get(i));
                    }
                    Integer choice2 = scanner.nextInt();
                    scanner.nextLine();
                    eventsToAttend.add(workshops.get(choice2 - 1));
                    break;
                } catch (InputMismatchException e) {
                e.printStackTrace();
                } catch (CustomNoDataException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            case 3 : {
                try {
                List<? extends Exhibition> tempExpAll = temporaryExhibitionService.getAllExhibitionsFromList().stream().toList();
                System.out.println("    Temporary Exhibitions");
                if (tempExpAll.size() == 0)
                    throw new CustomNoDataException("No data found!");
                for (int i = 0; i < tempExpAll.size(); i++) {
                    System.out.println((i+1) + " - " +tempExpAll.get(i).getTitle());
                }
                Integer choice2 = scanner.nextInt();
                scanner.nextLine();
                eventsToAttend.add(tempExpAll.get(choice2-1));
                break;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    break;
                } catch (CustomNoDataException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            default: {
                System.out.println("Invalid option!");
                exit(0);
                break;
            }
        }
        System.out.println("You have chosen to attend to the following events: ");
        for (int i = 0; i < eventsToAttend.size(); i++) {
            System.out.println(eventsToAttend.get(i));
        }
    }
}
