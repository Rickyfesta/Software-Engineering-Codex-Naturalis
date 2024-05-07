package Model.Cards;

public class CardJSON {
    private String ID;
    private String RESOURCE;
    private String CARDTYPE;
    private boolean TOP;
    private boolean LEFT;
    private boolean RIGHT;
    private boolean BOTTOM;
    private String POINTS;
    private String TOPSYMBOL;
    private String LEFTSYMBOL;
    private String BOTTOMSYMBOL;
    private String RIGHTSYMBOL;
    private String COLOUR;
    private String REQUIRED;



    // Getters and setters for each field
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getRESOURCE() {
        return RESOURCE;
    }

    public void setRESOURCE(String RESOURCE) {
        this.RESOURCE = RESOURCE;
    }

    public String getCARDTYPE() {
        return CARDTYPE;
    }

    public void setCARDTYPE(String CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }

    public boolean getTOP() {
        return TOP;
    }

    // Setter for a boolean
    public void setTOP(boolean TOP) {
        this.TOP = TOP;
    }

    public boolean getRIGHT() {
        return RIGHT;
    }

    // Setter for a boolean
    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public boolean getLEFT() {
        return LEFT;
    }

    // Setter for a boolean
    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public boolean getBOTTOM() {
        return BOTTOM;
    }

    // Setter for a boolean
    public void setBOTTOM(boolean BOTTOM) {
        this.BOTTOM = BOTTOM;
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

    public String getREQUIRED() {
        return REQUIRED;
    }

    public void setREQUIRED(String REQUIRED) {
        this.REQUIRED = REQUIRED;
    }
}