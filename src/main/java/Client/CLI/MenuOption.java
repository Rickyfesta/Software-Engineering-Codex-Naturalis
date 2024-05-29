package Client.CLI;
/**
 * Option for the CLI menu
 */


//TODO: TO BE REVISED
public class MenuOption {

    private static String title = "\n" +
            "░█████╗░░█████╗░██████╗░███████╗██╗░░██╗\n" +
            "██╔══██╗██╔══██╗██╔══██╗██╔════╝╚██╗██╔╝\n" +
            "██║░░╚═╝██║░░██║██║░░██║█████╗░░░╚███╔╝░\n" +
            "██║░░██╗██║░░██║██║░░██║██╔══╝░░░██╔██╗░\n" +
            "╚█████╔╝╚█████╔╝██████╔╝███████╗██╔╝╚██╗\n" +
            "░╚════╝░░╚════╝░╚═════╝░╚══════╝╚═╝░░╚═╝\n" +
            "\n" +
            "███╗░░██╗░█████╗░████████╗██╗░░░██╗██████╗░░█████╗░██╗░░░░░██╗░██████╗\n" +
            "████╗░██║██╔══██╗╚══██╔══╝██║░░░██║██╔══██╗██╔══██╗██║░░░░░██║██╔════╝\n" +
            "██╔██╗██║███████║░░░██║░░░██║░░░██║██████╔╝███████║██║░░░░░██║╚█████╗░\n" +
            "██║╚████║██╔══██║░░░██║░░░██║░░░██║██╔══██╗██╔══██║██║░░░░░██║░╚═══██╗\n" +
            "██║░╚███║██║░░██║░░░██║░░░╚██████╔╝██║░░██║██║░░██║███████╗██║██████╔╝\n" +
            "╚═╝░░╚══╝╚═╝░░╚═╝░░░╚═╝░░░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝╚═╝╚═════╝░";
    private final Runnable action;
    private static String startGame = "\n" +
            "░█▀▀▀█ ▀▀█▀▀ █▀▀█ █▀▀█ ▀▀█▀▀ 　 █▀▀▀ █▀▀█ █▀▄▀█ █▀▀ \n" +
            "─▀▀▀▄▄ ──█── █▄▄█ █▄▄▀ ──█── 　 █─▀█ █▄▄█ █─▀─█ █▀▀ \n" +
            "░█▄▄▄█ ──▀── ▀──▀ ▀─▀▀ ──▀── 　 ▀▀▀▀ ▀──▀ ▀───▀ ▀▀▀";

    private static String quit = "\n" +
            "░█▀▀█ █──█ ─▀─ ▀▀█▀▀ \n" +
            "░█─░█ █──█ ▀█▀ ──█── \n" +
            "─▀▀█▄ ─▀▀▀ ▀▀▀ ──▀──";

    /**
     * Constructor for a CLI option
     * @param title Name of the option
     * @param action Code called by the option, if selected
     */
    /**@ requires title != null;
      @ requires action != null;
      @ ensures this.title.equals(title);
      @ ensures this.action == action;
      */
    public MenuOption(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    /**
     * Gets the title attribute
     * @return Returns title value
     */
    /**@ ensures \result != null;
      */
    public static String getTitle() {
        return title;
    }
    /**o@ ensures \result != null;
      */
    public static String getStart() {
        return startGame;
    }
    /**@ ensures \result != null;
      */
    public static String getQuit() {
        return quit;
    }

    /**
     * Gets the action attribute
     * @return Returns action value
     */
    /**@ ensures \result != null;
      */
    public Runnable getAction() {
        return action;
    }
}