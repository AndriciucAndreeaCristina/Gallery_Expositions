package pao.application;

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

public class Gallery {
    private static Gallery INSTANCE;
    //artwork services
    private final ArtistInterface artistService = new ArtistInterfaceImplementation();
    private final ArtworkInterface artworkService = new ArtworkInterfaceImplementation();

    //event services
    private final EventInterface courseService = new EventCourseInterfaceImplementation();
    private final EventInterface workshopService = new EventWorkshopInterfaceImplementation();

    //exhibition services
    private final ExhibitionInterface permanentExhibition = new PermanentExhibitionInterfaceImplementation();
    private final ExhibitionInterface temporaryExhibition = new TemporaryExhibitionInterfaceImplementation();

    //floorplan services
    private final RoomInterface roomService = new RoomInterfaceImplementation();
    private final SectionInterface sectionService = new SectionInterfaceImplementation();

    public static Gallery getInstance() {
        return (INSTANCE == null ? new Gallery() : INSTANCE);
    }

    private Gallery() {}

    public void intro() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
    }
}
