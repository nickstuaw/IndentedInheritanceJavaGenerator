package com.nickinnovates;

public class ReadingLine {

    private LineType lineType;

    private int indentationLevel;

    /**
     * Construct the instance before getting the indentation level.
     * The constructor calculates the indentation level automatically.
     * @param rawMarkdownLine
     */
    public ReadingLine(String rawMarkdownLine) {
        Debugger.info("rawMarkdownLine = " + rawMarkdownLine);
        this.lineType = identifyLineType(rawMarkdownLine.stripLeading().charAt(0));
        Debugger.info("lineType = " + this.lineType.name());
        int spacesCounted = countChar(' ', rawMarkdownLine, 0);
        Debugger.info("spacesCounted = " + spacesCounted);
        setIndentationLevel(spacesCounted);
        Debugger.info("indentationLevel = " + indentationLevel);
    }

    private int countChar(char character, String rawSequence, int targetListPosition) {
        int resultantIndex = rawSequence.indexOf(character);
        if (targetListPosition > 0) {
            for(int i = 1; i < targetListPosition; i++) {
                rawSequence = rawSequence.substring(resultantIndex);
            }
        }
        int tally = 0;
        for(char character1 = rawSequence.charAt(tally); character1 == ' '; character1 = rawSequence.charAt(tally)) {
            tally++;
        }
        return tally;
    }

    /**
     * @param spacesCounted how many space characters (' ') are after the identifying char.
     */
    private void setIndentationLevel(int spacesCounted) {
        this.indentationLevel = Integer.divideUnsigned(spacesCounted, 2);
    }

    private LineType identifyLineType(char character) {
        switch (character) {
            case '#':
                return LineType.HEADING;
            case '*':
                return LineType.ASTERISK;
            case '-':
                return LineType.HYPHEN;
            default:
                return LineType.BORING;
        }
    }

    // Getters

    public int getIndentationLevel() {
        return this.indentationLevel;
    }

}
