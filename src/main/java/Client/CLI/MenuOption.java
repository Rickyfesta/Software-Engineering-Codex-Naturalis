package Client.CLI;
/**
 * Option for the CLI menu
 */


//TODO: TO BE REVISED
class MenuOption {

    private static String title = null;
    private final Runnable action;

    /**
     * Constructor for a CLI option
     * @param title Name of the option
     * @param action Code called by the option, if selected
     */
    public MenuOption(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    /**
     * Gets the title attribute
     * @return Returns title value
     */
    public static String getTitle() {
        return title;
    }

    /**
     * Gets the action attribute
     * @return Returns action value
     */
    public Runnable getAction() {
        return action;
    }
}