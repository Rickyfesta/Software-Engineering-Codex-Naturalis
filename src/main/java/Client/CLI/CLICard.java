package Client.CLI;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CLICard {
    @JsonProperty("ID")
    private String ID;
    @JsonProperty("DESCRIPTION")
    private String DESCRIPTION;
    @JsonProperty("ASCII")
    private List<String> ASCII;

    // Constructors
    public CLICard() {}

    public CLICard(String ID, String DESCRIPTION, List<String> ASCII) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.ASCII = ASCII;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public List<String> getASCII() {
        return ASCII;
    }

    public void setASCII(List<String> ASCII) {
        this.ASCII = ASCII;
    }
}
