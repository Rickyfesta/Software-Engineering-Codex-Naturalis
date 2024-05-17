package Model.Cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CardJSON {
    @JsonProperty("ID")
    private String ID;
    @JsonProperty("CARDTYPE")
    private String CARDTYPE;
    @JsonProperty("SYMBOL")
    private String SYMBOL;
    @JsonProperty("POINTS")
    private String POINTS;
    @JsonProperty("TOPSYMBOL")
    private String TOPSYMBOL;
    @JsonProperty("LEFTSYMBOL")
    private String LEFTSYMBOL;
    @JsonProperty("RIGHTSYMBOL")
    private String RIGHTSYMBOL;
    @JsonProperty("BOTTOMSYMBOL")
    private String BOTTOMSYMBOL;
    @JsonProperty("COLOUR")
    private String COLOUR;
    @JsonProperty("REQUIRED")
    private List<String> REQUIRED;
    // Getters and setters for each field
    public String getID() {
        return ID;
    }

    public List<String> getREQUIRED() {
        return REQUIRED;
    }

    public void setREQUIRED(List<String> REQUIRED) {
        this.REQUIRED = REQUIRED;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }
    public String getSYMBOL() {
        return SYMBOL;
    }

    public String getCARDTYPE() {
        return CARDTYPE;
    }

    public void setCARDTYPE(String CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }

    public String getTOPSYMBOL() {
        return TOPSYMBOL;
    }

    public void setTOPSYMBOL(String TOPSYMBOL) {
        this.TOPSYMBOL = TOPSYMBOL;
    }

    public String getLEFTSYMBOL() {
        return LEFTSYMBOL;
    }

    public void setLEFTSYMBOL(String LEFTSYMBOL) {
        this.LEFTSYMBOL = LEFTSYMBOL;
    }

    public String getRIGHTSYMBOL() {
        return RIGHTSYMBOL;
    }

    public void setRIGHTSYMBOL(String RIGHTSYMBOL) {
        this.RIGHTSYMBOL = RIGHTSYMBOL;
    }

    public String getBOTTOMSYMBOL() {
        return BOTTOMSYMBOL;
    }

    public void setBOTTOMSYMBOL(String BOTTOMSYMBOL) {
        this.BOTTOMSYMBOL = BOTTOMSYMBOL;
    }

    public String getPOINTS() {
        return POINTS;
    }

    public void setPOINTS(String POINTS) {
        this.POINTS = POINTS;
    }

    public String getCOLOUR() {
        return COLOUR;
    }

    public void setCOLOUR(String COLOUR) {
        this.COLOUR = COLOUR;
    }
}