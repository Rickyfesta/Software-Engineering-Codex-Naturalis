package Model.Cards;

public class CardJSON {
    private String ID;
    private String RESOURCE;
    private static String CARDTYPE;
    private static String POINTS;
    private String TOPSYMBOL;
    private String LEFTSYMBOL;
    private String BOTTOMSYMBOL;
    private String RIGHTSYMBOL;
    private static String SYMBOL;
    private String COLOUR;
    private String REQUIRED;



    // Getters and setters for each field
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }
    public static String getSYMBOL() {
        return SYMBOL;
    }

    public String getRESOURCE() {
        return RESOURCE;
    }

    public void setRESOURCE(String RESOURCE) {
        this.RESOURCE = RESOURCE;
    }

    public static String getCARDTYPE() {
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

    public static String getPOINTS() {
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

    public String getREQUIRED() {
        return REQUIRED;
    }

    public void setREQUIRED(String REQUIRED) {
        this.REQUIRED = REQUIRED;
    }
}