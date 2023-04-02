package pao.application;

import pao.model.artworks.Artist;
import pao.model.artworks.Artwork;
import pao.model.artworks.enums.Materials;
import pao.model.events.Course;
import pao.model.events.CreativeWorkshop;
import pao.model.events.Person;
import pao.model.events.enums.FormatType;
import pao.model.events.enums.MaterialsCreativeWorkshop;
import pao.model.exhibitions.PermanentExhibition;
import pao.model.exhibitions.TemporaryExhibition;
import pao.model.floorplan.Room;
import pao.model.floorplan.Section;
import pao.model.floorplan.enums.SectionsType;
import pao.services.impl.artworks.ArtistInterfaceImplementation;
import pao.services.impl.artworks.ArtworkInterfaceImplementation;
import pao.services.impl.events.EventCourseInterfaceImplementation;
import pao.services.impl.events.EventWorkshopInterfaceImplementation;
import pao.services.impl.exhibitions.PermanentExhibitionInterfaceImplementation;
import pao.services.impl.exhibitions.TemporaryExhibitionInterfaceImplementation;
import pao.services.impl.floorplan.RoomInterfaceImplementation;
import pao.services.impl.floorplan.SectionInterfaceImplementation;
import pao.services.interfaces.artworks.ArtistInterface;
import pao.services.interfaces.artworks.ArtworkInterface;
import pao.services.interfaces.events.EventInterface;
import pao.services.interfaces.exhibitions.ExhibitionInterface;
import pao.services.interfaces.floorplan.RoomInterface;
import pao.services.interfaces.floorplan.SectionInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.System.exit;

public class Gallery {
    private static Gallery INSTANCE;
    //artwork services
    private final ArtistInterface artistService = new ArtistInterfaceImplementation();
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

    public static Gallery getInstance() {
        return (INSTANCE == null ? new Gallery() : INSTANCE);
    }

    private Gallery() {}

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
        createArtistsAndArtworks();
        createFloorplan();
        createEvents();
        createExhibitions();

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

    }

    private void createArtistsAndArtworks() {
        Artist artist;
        Artwork artwork;
        SortedSet<Artist> artists = new TreeSet<>();

        //Creating artists and artworks
        artist = Artist.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .firstName("Andrei")
                .lastName("Gamart")
                .birthDate(LocalDate.of(1980, 1, 1))
                .description("His paintings, drawings, and graphic works reveal fractures of a world that seems suspended in-between time and space. The major themes populating this tenebrous and sometimes surreal “counter-reality” tackle the relation between memory, matter, innocence and error.")
                .movement(SectionsType.TRANSAVANTGARDE)
                .build();

        artistService.addArtist(artist);

        //works of Andrei Gamart
        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Fog Over the Sea")
                .yearOfCreation(2022)
                .description("")
                .material(Materials.OIL_ON_LINE)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Mirrored Dreams")
                .yearOfCreation(2022)
                .description("")
                .material(Materials.OIL_ON_CANVAS)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("The Waiting")
                .yearOfCreation(2021)
                .description("")
                .material(Materials.OIL_ON_LINEN)
                .build();
        artworkService.addArtwork(artwork);

        artist = Artist.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .firstName("Anna")
                .lastName("Khodorkovskaya ")
                .birthDate(LocalDate.of(1985, 1, 1))
                .description("Using multiple tools of expression, different types of choice, various formal structures and media, the artist proposes a less conventional dialogue: we select the elements of our interest out of what we call common life, we deconstruct them, analyze them and rebuild everything in a personal manner, identified as a work of art.")
                .movement(SectionsType.INSTALLATION_ART)
                .build();

        artistService.addArtist(artist);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Message is Over")
                .yearOfCreation(2019)
                .description("")
                .material(Materials.PLASTER)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Later that day")
                .yearOfCreation(2018)
                .description("")
                .material(Materials.ACRYLIC_ON_GLASS)
                .build();
        artworkService.addArtwork(artwork);

        artist = Artist.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .firstName("Bianca")
                .lastName("Mann")
                .birthDate(LocalDate.of(1991, 1, 1))
                .description("In her works Bianca Mann describes the identity of man, that torn apart by the array of roles imposed by society, by the domestic environment, or simply by inner tensions, becomes a scene where different characters perform different acts while wearing the same mask.")
                .movement(SectionsType.HYPERREALISM)
                .build();
        artistService.addArtist(artist);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Domestic Object")
                .yearOfCreation(2022)
                .description("")
                .material(Materials.BLACK_CERAMIC)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("The Night Is Yours Alone")
                .yearOfCreation(2019)
                .description("")
                .material(Materials.RESIN)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("The Downfall")
                .yearOfCreation(2017)
                .description("")
                .material(Materials.FIBERGLASS)
                .build();
        artworkService.addArtwork(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Face Off")
                .yearOfCreation(2017)
                .description("")
                .material(Materials.BRONZE)
                .build();
        artworkService.addArtwork(artwork);
    }
    private void createFloorplan() {

        for (int floor_no = 0; floor_no < 5; floor_no++) {
            Section section;
            Integer typeId = 0;
            List<Room> roomsPerSection = new ArrayList<>();
            for (int room_no = 0; room_no < 10; room_no++) {
                Room room = Room.builder()
                                .id(UUID.randomUUID())
                                .floor(floor_no)
                                .number(room_no)
                                .build();
                roomService.addRoom(room);
                if (floor_no >= 2) {
                    roomsPerSection.add(room);
                    if (roomsPerSection.size() >= 3) {
                        section = Section.builder()
                                .id(UUID.randomUUID())
                                .rooms(roomsPerSection)
                                .type(SectionsType.values()[typeId % SectionsType.values().length])
                                .build();
                        typeId += 1;
                        sectionService.addSection(section);
                        roomsPerSection.clear();
                    }
                }
            }
        }

        // floors 0, 1 and partially 2 are  reserved for temporary exhibitions and other events



    }

    private void createEvents() {
        Person tutor;
        tutor = Person.builder()
                .id(UUID.randomUUID())
                .firstName("Jo")
                .lastName("Walton")
                .description("")
                .birthDate(LocalDate.of(1975, 1, 1))
                .ocupation("professor")
                .build();

        Course course = Course.builder()
                            .id(UUID.randomUUID())
                            .title("Approaches to art history")
                            .description("Consider different approaches to art history and learn how to look at paintings in the collection through different art historical lenses.")
                            .tutor(tutor)
                            .formatType(FormatType.ONLINE)
                            .price(28f)
                            .dates(Arrays.asList(LocalDate.of(2023, 3, 16), LocalDate.of(2023, 3, 23), LocalDate.of(2023, 3, 30), LocalDate.of(2023, 4, 6)))
                            .weeklyThemes(Map.of(1, "Paitings of George Bellows", 2, "European hegemony ", 3, "Feminist approaches to art history", 4, "Queering art history"))
                            .build();
        courseService.addEvent(course);

        tutor = Person.builder()
                .id(UUID.randomUUID())
                .firstName("Joanna")
                .lastName("Conybeare")
                .description("")
                .birthDate(LocalDate.of(1994, 1, 1))
                .ocupation("artist")
                .build();

        CreativeWorkshop workshop = CreativeWorkshop.builder()
                .id(UUID.randomUUID())
                .title("Express yourself! Like a Post-Impressionist")
                .description("Recreate a portrait using some of the stylistic techniques of the Post-Impressionists, in this fun, creative workshop.")
                .tutor(tutor)
                .formatType(FormatType.IN_PERSON)
                .price(0f)
                .date(LocalDateTime.of(2023, 04, 20, 16, 0))
                .materials(List.of(MaterialsCreativeWorkshop.SKETCHBOOK, MaterialsCreativeWorkshop.PENCIL))
                .build();
        workshopService.addEvent(workshop);
    }
    private void createExhibitions() {
        PermanentExhibition permanentExhibition;
        TemporaryExhibition temporaryExhibition;
        Artist artist;
        Artwork artwork;
        List<Room> roomList0 = roomService.getRoomsByFloor(0);
        List<Room> roomList1 = roomService.getRoomsByFloor(1);

        List<Artwork> artworkList = new ArrayList<>();
        artist = Artist.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .firstName("Roman")
                .lastName("Tolici")
                .birthDate(LocalDate.of(1985, 1, 1))
                .description("Roman Tolici is associated with a photographic realism infused by poetry and a surreal sense of everyday existence. His paintings seem to be details of a monumental story related to the general human questions and anxieties.")
                .movement(SectionsType.HYPERREALISM)
                .build();

        artistService.addArtist(artist);


        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Summer")
                .yearOfCreation(2022)
                .description("")
                .material(Materials.OIL_ON_CANVAS)
                .build();
        artworkService.addArtwork(artwork);
        artworkList.add(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("The Storm")
                .yearOfCreation(2023)
                .description("")
                .material(Materials.OIL_ON_CANVAS)
                .build();
        artworkService.addArtwork(artwork);
        artworkList.add(artwork);

        artwork = Artwork.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .creator(artist)
                .title("Silent Screamer")
                .yearOfCreation(2021)
                .description("")
                .material(Materials.OIL_ON_CANVAS)
                .build();
        artworkService.addArtwork(artwork);

        temporaryExhibition = TemporaryExhibition.builder()
                .id(UUID.randomUUID())
                .title("PURSUIT OF HAPPINESS")
                .description("Happiness is an outdated topic.")
                .artworksList(artworkList)
                .startDate(LocalDate.of(2023, 2, 22))
                .endDate(LocalDate.of(2023, 4, 18))
                .room(roomList0.get(3))
                .build();
        temporaryExhibitionService.addExhibition(temporaryExhibition);

        artworkList.clear();
        artworkList.add(artworkService.getArtworkByTitle("Fog Over the Sea").orElse(null));
        artworkList.add(artworkService.getArtworkByTitle("The Downfall").orElse(null));

        temporaryExhibition = TemporaryExhibition.builder()
                .id(UUID.randomUUID())
                .title("Under Pressure")
                .description("It brings together ten visual and sound artists that consider through their practices narratives of transformation in a time of intensifying mass extinction.")
                .artworksList(artworkList)
                .startDate(LocalDate.of(2021, 9, 15))
                .endDate(LocalDate.of(2021, 10, 15))
                .room(roomList1.get(2))
                .build();

        temporaryExhibitionService.addExhibition(temporaryExhibition);

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

    private void managerFunctionalities(Scanner scanner) {
        System.out.println("What action would you like to perform?");
        System.out.println("        1 - Add an artist");
        System.out.println("        2 - Add an artwork");
        System.out.println("        3 - Add an event");
        System.out.println("        4 - Modify an event");
        System.out.println("        5 - Add an exhibition");

        Integer choice = scanner.nextInt();
        while (choice < 1 || choice > 5) {
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
                    artistService.addArtist(artist);
                    //System.out.println(artistService.getAllArtistsFromList());
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
                    creator = artistService.getArtistByFirstName(firstName).orElse(null);
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
                    //add an event
                    break;
                }
                case 4: {
                    //modify an event
                    break;
                }
                case 5: {
                    //add an exhibition
                    break;
                }
                default: {

                }
        }
    }

    private void userFunctionalities(Scanner scanner) {
            System.out.println("What action would you like to perform?");
        }


}
