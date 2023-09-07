package com.nickinnovates;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Debugger.on = true;
        String[] testLines = new String[] {
                "# heading line",
                "  * asterisk line",
                "    * asterisk line"
        };

        // Range of indentation levels
        int maximumIndentationLevel = 0, minimumIndentationLevel = 0;
        // Is there an actual known minimum (or maximum respectively)?
        boolean minimumIndentationLevelIsAltered = false,
                maximumIndentationLevelIsAltered = false;

        HashMap<ReadingLine, Integer> indentationLevelMap = new HashMap<>();
        // Load hashmap
        ReadingLine readingLineToLoad;
        int currentIndentationLevel;
        for(String testLine : testLines) {
            readingLineToLoad = new ReadingLine(testLine);
            currentIndentationLevel = readingLineToLoad.getIndentationLevel();
            indentationLevelMap.put(readingLineToLoad, currentIndentationLevel);
            /* Set the maximum indentation level
             if the current level exceeds the known maximum
             */
            if(currentIndentationLevel > maximumIndentationLevel) {
                maximumIndentationLevel = currentIndentationLevel;
                /*
                or if the maximum indentation level hasn't been changed and the
                current level is higher than the maximum.
                */
            } else if(currentIndentationLevel != 0 && maximumIndentationLevel == 0
                    && !maximumIndentationLevelIsAltered) {
                maximumIndentationLevel = currentIndentationLevel;
            }
            /* Set the minimum indentation level
             if the current level proceeds the known minimum
             */
            if(currentIndentationLevel < minimumIndentationLevel) {
                minimumIndentationLevel = currentIndentationLevel;
                minimumIndentationLevelIsAltered = true;
                /*
                or if the minimum indentation level hasn't been changed and the
                current level is lower than the minimum.
                */
            } else if(currentIndentationLevel != 0 && minimumIndentationLevel == 0
                    && !minimumIndentationLevelIsAltered) {
                minimumIndentationLevel = currentIndentationLevel;
            }
        }
        //todo complete the coding of this

        List<String> indexesInOrder = new ArrayList<>();
        int currentIndex = 0;
        for(Integer indentationLevel : indentationLevelMap.values()) {
            if(indentationLevel == 0)
            currentIndex++;
        }

        String orderedIndexesByIndentationLevel = String.join(",",);

    }
}