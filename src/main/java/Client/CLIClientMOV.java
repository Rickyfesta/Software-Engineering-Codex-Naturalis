package Client;

public class CLIClientMOV extends ClientHandler {
    private final Client client = Client.getInstance();

    @Override
    public void waitin() {
        System.out.println("Start");
    }

    public CLIClientMOV() {
    }
}
