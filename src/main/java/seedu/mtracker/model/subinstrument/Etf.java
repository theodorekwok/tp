package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "E";
    protected static final String TYPE_INSTRUMENT = "Etf";
    private static final String RETURNS_HEADER = "Past Returns: ";

    public Etf(String name, double currentPrice, String sentiment, double pastReturns, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturns = pastReturns;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getReturns() {
        if (pastReturns == -101.0) {
            return EMPTY_STRING;
        }
        return String.valueOf(pastReturns);
    }

    public String getReturnsForFileFormat() {
        return String.valueOf(pastReturns);
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(ETF_ICON)
                + " " + getName()
                + TextUi.SEMICOLON_SEP + getCurrentPrice()
                + TextUi.SEMICOLON_SEP + getSentiment();
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getReturnsForFileFormat()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + System.lineSeparator() + RETURNS_HEADER + getReturns()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
