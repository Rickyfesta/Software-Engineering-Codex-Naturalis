package Controller;

import Model.Cards.CardJSON;

import java.util.List;

public class FakeCardJSON extends CardJSON {
    private String points;
    private List<String> required;
    private String symbol;
    private String leftSymbol;
    private String rightSymbol;
    private String topSymbol;
    private String bottomSymbol;

    public void setPoints(String points) {
        this.points = points;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setLeftSymbol(String leftSymbol) {
        this.leftSymbol = leftSymbol;
    }

    public void setRightSymbol(String rightSymbol) {
        this.rightSymbol = rightSymbol;
    }

    public void setTopSymbol(String topSymbol) {
        this.topSymbol = topSymbol;
    }

    public void setBottomSymbol(String bottomSymbol) {
        this.bottomSymbol = bottomSymbol;
    }

    @Override
    public String getPOINTS() {
        return points;
    }

    @Override
    public List<String> getREQUIRED() {
        return required;
    }

    @Override
    public String getSYMBOL() {
        return symbol;
    }

    @Override
    public String getLEFTSYMBOL() {
        return leftSymbol;
    }

    @Override
    public String getRIGHTSYMBOL() {
        return rightSymbol;
    }

    @Override
    public String getTOPSYMBOL() {
        return topSymbol;
    }

    @Override
    public String getBOTTOMSYMBOL() {
        return bottomSymbol;
    }
}

