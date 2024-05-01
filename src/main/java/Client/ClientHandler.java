package Client;

//implements runnable so that the instances will be executed by a separate thread
public abstract class ClientHandler{

    private final Client client = Client.getInstance();


    public abstract void waitin();
}
