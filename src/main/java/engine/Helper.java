package engine;

import com.shaft.tools.io.JSONFileManager;
import lombok.Getter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    @Getter
    public enum TimeFormat {
        BASIC_DATE("yyyy-MM-dd"), US_DATE("MM/dd/yyyy"), US_DATE_WITH_TIME("dd-MM-yyyy HH:mm:ss"), FULL_DATE("yyyy-MM-dd HH:mm:ss"), FRIENDLY_FULL_DATE("EEEE, MMM d yyyy, h:mm a"), ISO_INSTANT_DATE("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        private final String format;

        TimeFormat(String format) {
            this.format = format;
        }
    }

    public static String getTimestamp() {
        return " @ " + getTimestamp(TimeFormat.US_DATE_WITH_TIME, 0);
    }

    public static String getTimestamp(TimeFormat timeFormat) {
        return getTimestamp(timeFormat, 0);
    }

    public static String getTimestamp(TimeFormat timeFormat, long plusMinutes) {
        return DateTimeFormatter.ofPattern(timeFormat.getFormat()).withZone(ZoneOffset.UTC).format(Instant.now().plus(plusMinutes, ChronoUnit.MINUTES));
    }


    // Common known patterns
    private static final String[] KNOWN_PATTERNS = {"M/d/yy, h:mm a",              // 8/10/25, 2:30 PM
            "yyyy-MM-dd'T'HH:mm:ss.SSSX",  // 2025-08-10T11:00:00.000Z
            "yyyy-MM-dd'T'HH:mm:ssX",      // 2025-08-10T11:00:00Z
            "yyyy-MM-dd HH:mm:ss",         // 2025-08-10 14:30:00
            "dd/MM/yyyy",                  // 10/08/2025
            "MM/dd/yyyy",                  // 08/10/2025
            "dd-MMM-yyyy",                  // 10-Aug-2025
            "dd MMM yyyy"                   // 10 Aug 2025
    };

    public static String convertDate(String dateStr, String outputPattern) {
        for (String pattern : KNOWN_PATTERNS) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
                TemporalAccessor parsedDate = inputFormatter.parse(dateStr);
                LocalDateTime ldt;
                try {
                    ldt = LocalDateTime.from(parsedDate);
                } catch (Exception e) {
                    ldt = LocalDate.from(parsedDate).atStartOfDay();
                }
                ZonedDateTime zdtUtc = ldt.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern, Locale.ENGLISH).withZone(ZoneOffset.UTC);
                return outputFormatter.format(zdtUtc);
            } catch (DateTimeParseException ignored) {
                // Try next pattern
            }
        }
        throw new IllegalArgumentException("Unrecognized date format: " + dateStr);
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static int getRandomNumberBetweenTwoValues(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }

    public static String getRandomNumberBetweenTwoValuesAsString(int low, int high) {
        return String.valueOf(getRandomNumberBetweenTwoValues(low, high));
    }

    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String getAlphaNumericString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() < length) {
            char ch = (char) (random.nextInt(75) + 48);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String getTextAfterReplace(String text, String target, String replacement) {
        return text.replace(target, replacement);
    }

    public static Map<String, Object> setVariable(Map<String, Object> vars, String key, String value, Class<?> type) {
        if (value != null && !value.isEmpty()) {
            Object val = value;
            if (type == Integer.class) val = Integer.parseInt(value);
            else if (type == Long.class) val = Long.parseLong(value);
            else if (type == Float.class) val = Float.parseFloat(value);
            else if (type == Double.class) val = Double.parseDouble(value);
            else if (type == Boolean.class) val = Boolean.parseBoolean(value);
            vars.put(key, val);
        }
        return vars;
    }

    public static void getData(JSONFileManager jsonData, String objName, String key) {
        jsonData.getTestData(objName + key);
    }

    public static void setVariable(Map<String, Object> vars, String key, String value) {
        setVariable(vars, key, value, String.class);
    }

    //****** Replace methods ******//
    public static String replace(String text, String textNeedsToBeRemoved) {
        try {
            String textAfterReplaced = text.replace(textNeedsToBeRemoved, "");
            CustomReporter.getInstance().logConsole("Replace: [ " + textNeedsToBeRemoved + " ] from [ " + text + "] to Be  [ " + textAfterReplaced + " ]");
            return textAfterReplaced;
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + text + " ] : " + e.getMessage());
            return text;
        }
    }

    public static String replace(String fullText, String textTarget, String textNeedsToBeReplace) {
        try {
            String textAfterReplaced = fullText.replace(textTarget, textNeedsToBeReplace);
            CustomReporter.getInstance().logConsole("Replace: [ " + textTarget + " ] From [" + fullText + "] to be [" + textAfterReplaced + "]");
            return textAfterReplaced;
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + fullText + " ] : " + e.getMessage());
            return fullText;
        }
    }

    //****** ReplaceAll methods ******//
    public static String replaceAll(String text, String textNeedsToBeRemoved, Boolean isPrint) {
        try {
            String textAfterReplaced = text.replaceAll(textNeedsToBeRemoved, "");
            if (isPrint) {
                CustomReporter.getInstance().logConsole("Replace: [ " + textNeedsToBeRemoved + " ] from [ " + text + "] to Be  [ " + textAfterReplaced + " ]");
            }
            return textAfterReplaced;
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + text + " ] : " + e.getMessage());
            return text;
        }
    }

    public static String replaceAll(String text, String textNeedsToBeRemoved) {
        return replaceAll(text, textNeedsToBeRemoved, true);
    }


    public static String replaceAll(String fullText, String textTarget, String textNeedsToBeReplace) {
        try {
            String textAfterReplaced = fullText.replaceAll(textTarget, textNeedsToBeReplace);
            CustomReporter.getInstance().logConsole("Replace: [ " + textTarget + " ] from [ " + fullText + "] to Be [ " + textAfterReplaced + " ]");
            return textAfterReplaced.trim();
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + fullText + " ] : " + e.getMessage());
            return fullText;
        }
    }

    /**
     * This method replaces all special characters and spaces in the given text.
     * It uses a regex to match digits, special characters, and whitespace
     * regex is "[0-9+*.^:;',!?\\n\\t \\u00a0\\s+]" which includes digits, special characters and spaces.
     *
     * @param text  the text to be processed
     * @param print if true, logs the replacement details to the console
     * @return text after removing all special characters and spaces
     */

    public static String removeRegex(String text, Boolean print) {
        try {
            if (text != null) {
                String regex = "[0-9+*.^:;',!?\\n\\t \\u00a0\\s+]";
                String textAfterReplaced = text.replaceAll(regex, "").replaceAll("\\s+", "").trim();
                if (print) {
                    CustomReporter.getInstance().logConsole("Replace All: [ " + regex + " ] from [ " + text + "] to Be [ " + textAfterReplaced + " ]");
                }
                return textAfterReplaced;
            } else {
                return null;
            }
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + text + " ] : " + e.getMessage());
            return text;
        }
    }


    public static String removeRegex(String text) {
        return removeRegex(text, false);
    }

    public static String replaceAllSpaces(String text, Boolean print) {
        try {
            String regex = "[+*.^:;',!?\\n\\t \\u00a0\\s+]";
            String textAfterReplaced = text.replaceAll(regex, "");
            if (print) {
                CustomReporter.getInstance().logConsole("Replace All: [ " + regex + " ] from [ " + text + " ] to Be [ " + textAfterReplaced + " ]");
            }
            return textAfterReplaced.trim();
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + text + " ] : " + e.getMessage());
            return text;
        }
    }

    public static String replaceAllSpaces(String text) {
        return replaceAllSpaces(text, true);
    }


    public static String replaceAllNumbers(String text) {
        try {
            String regex = "[0-9]";
            String textAfterReplaced = text.replaceAll(regex, "");
            CustomReporter.getInstance().logConsole("Replace All: [ " + regex + " ] from [ " + text + "] to Be [ " + textAfterReplaced + " ]");
            return textAfterReplaced.trim();
        } catch (Exception e) {
            CustomReporter.getInstance().logError("Error while replacing text [ " + text + " ] : " + e.getMessage());
            return text;
        }
    }

    public static String extractTextFromLemma(String text) {
        String str;
        str = text.substring(text.indexOf("*"), text.indexOf("*", 11));
        CustomReporter.getInstance().logConsole("Extracted text from lemma is : " + str);
        return str;
    }

    /**
     * Takes two parameters, one is the array of special characters that are needed
     * to be replaced, and the text needed to be updated It converts text with
     * %40%23%24%25%26 ..etc (special characters) to return it with
     * %5C%5C%40%5C%5C%23%5C%5C%24%5C%5C%25%5C%5C%26
     *
     * @param specialCharactersArray an array of the special characters that will be
     *                               escaped
     * @param text                   the string that will have its special
     *                               characters escaped
     * @return updated texts with escaped special characters
     */
    public static String replaceRegex(String[] specialCharactersArray, String text) {
        // @#$%&
        // \\@\\#\\$\\%\\&
        String oldChar;
        for (int i = 0; i < (specialCharactersArray.length); i++) {
            oldChar = specialCharactersArray[i];
            specialCharactersArray[i] = ("\\" + specialCharactersArray[i]);
            text = text.replace(oldChar, specialCharactersArray[i]);
        }
        return text;
    }

    public static String removeSpecialCharacters(String text) {
        StringBuilder cleanString = new StringBuilder();
        if (text != null) {
            for (int i = 0; i < text.toCharArray().length; i++) {
                var character = String.valueOf(text.toCharArray()[i]);
                if (Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE).matcher(character).find()) {
                    cleanString.append("_");
                } else {
                    cleanString.append(character);
                }
            }
        }
        return cleanString.toString();
    }

    /**
     * Returns text after replaces its regular expressions which included in this
     * set []^$.|?*+(){}
     *
     * @param text the string that will have its special characters escaped
     * @return updated text after escaping its regular expressions
     */

    public static String replaceRegex(String text) {
        String[] specialCharactersArray = {"[", "]", "^", "$", ".", "|", "?", "*", "+", "(", ")", "{", "}"};
        return replaceRegex(specialCharactersArray, text);
    }

    public static String convertToSentenceCase(String text) {
        Pattern WORD_FINDER = Pattern.compile("(([A-Z]*[a-z]*)|([A-Z]))");
        Matcher matcher = WORD_FINDER.matcher(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group(0));
        }
        List<String> capitalized = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            if (i == 0) {
                capitalized.add(capitalizeFirst(currentWord));
            } else {
                capitalized.add(currentWord.toLowerCase());
            }
        }
        return String.join(" ", capitalized).trim();
    }

    private static String capitalizeFirst(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static String getTextAfterSplit(String text, String regex) {
        if (text.contains(regex)) {
            String tcIdAlm = text.split(regex)[0];
            CustomReporter.getInstance().logConsole("Test Case ID ALM is : [ " + tcIdAlm + " ]");
            return tcIdAlm;
        } else {
            return text;
        }
    }
}