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
    @JsonProperty("ASCII")
    private List<String> ASCII;

    public CardJSON (){

    }

    // Getters and setters for each field
    /**@ ensures \result != null; */
    public String getID() {
        return ID;
    }
    /**@ ensures \result != null; */
    public List<String> getREQUIRED() {
        return REQUIRED;
    }
    /**@ requires REQUIRED != null;
     @ ensures this.REQUIRED == REQUIRED;
     @*/
    public void setREQUIRED(List<String> REQUIRED) {
        this.REQUIRED = REQUIRED;
    }
    /**@ requires ID != null;
      @ ensures this.ID == ID;
      */
    public void setID(String ID) {
        this.ID = ID;
    }
    /**@ requires SYMBOL != null;
      @ ensures this.SYMBOL == SYMBOL;
      */
    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }
    /**@ ensures \result != null; */
    public String getSYMBOL() {
        return SYMBOL;
    }
    /**@ ensures \result != null; */
    public String getCARDTYPE() {
        return CARDTYPE;
    }
    /**@ requires CARDTYPE != null;
          @ ensures this.CARDTYPE == CARDTYPE;
          */
    public void setCARDTYPE(String CARDTYPE) {
        this.CARDTYPE = CARDTYPE;
    }
    /**@ ensures \result != null; */
    public String getTOPSYMBOL() {
        return TOPSYMBOL;
    }
    /**@ requires TOPSYMBOL != null;
         @ ensures this.TOPS_SYMBOL == TOPSYMBOL;
         */
    public void setTOPSYMBOL(String TOPSYMBOL) {
        this.TOPSYMBOL = TOPSYMBOL;
    }
    /**@ ensures \result != null; */
    public String getLEFTSYMBOL() {
        return LEFTSYMBOL;
    }
    /**@ requires LEFTSYMBOL != null;
         @ ensures this.LEFTSYMBOL == LEFTSYMBOL;
         */
    public void setLEFTSYMBOL(String LEFTSYMBOL) {
        this.LEFTSYMBOL = LEFTSYMBOL;
    }
    /**@ ensures \result != null; */
    public String getRIGHTSYMBOL() {
        return RIGHTSYMBOL;
    }
    /**@ requires RIGHTSYMBOL != null;
          @ ensures this.RIGHTSYMBOL == RIGHTSYMBOL;
          */
    public void setRIGHTSYMBOL(String RIGHTSYMBOL) {
        this.RIGHTSYMBOL = RIGHTSYMBOL;
    }
    /**@ ensures \result != null; */
    public String getBOTTOMSYMBOL() {
        return BOTTOMSYMBOL;
    }
    /**@ requires BOTTOMSYMBOL != null;
          @ ensures this.BOTTOMSYMBOL == BOTTOMSYMBOL;
          */
    public void setBOTTOMSYMBOL(String BOTTOMSYMBOL) {
        this.BOTTOMSYMBOL = BOTTOMSYMBOL;
    }
    /**@ ensures \result != null; */
    public String getPOINTS() {
        return POINTS;
    }
    /**@ requires POINTS != null;
         @ ensures this.POINTS == POINTS;
         */
    public void setPOINTS(String POINTS) {
        this.POINTS = POINTS;
    }
    /**@ ensures \result != null; */
    public String getCOLOUR() {
        return COLOUR;
    }
    /**@ ensures \result != null; */
    public List<String> getASCII() {
        return ASCII;
    }
    /**@ requires ASCII != null;
         @ ensures this.ASCII == ASCII;
         */
    public void setASCII(List<String> ASCII) {
        this.ASCII = ASCII;
    }
    /**@ requires COLOUR != null;
         @ ensures this.COLOUR == COLOUR;
         */
    public void setCOLOUR(String COLOUR) {
        this.COLOUR = COLOUR;
    }
}