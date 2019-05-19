package taurasi.marc.allimorecore;

import java.util.ArrayList;

public class StringUtils {
    public static ArrayList<String> WrapLore(String string, int charactersPerLine, String appendString){
        ArrayList<String> loreStrings = new ArrayList<>();
        char[] chars = string.toCharArray();
        int charsOnLine = 0;

        for(int i = 0; i < chars.length; i++){
            if( ((chars.length - i) + charsOnLine <= charactersPerLine) ){
                loreStrings.add(appendString + string.substring(i - charsOnLine));
                break;
            }

            if( (chars[i] == ' ') && (charsOnLine >= charactersPerLine) ){
                loreStrings.add(appendString + string.substring(i - charsOnLine, i));
                charsOnLine = 0;
            }else{
                charsOnLine ++;
            }
        }

        return loreStrings;
    }

    public static String formatEnumString(String string){
        char[] chars = string.toCharArray();
        boolean newWord = true;

        for(int i = 0; i < chars.length; i++){
            if(newWord){
                chars[i] = Character.toUpperCase(chars[i]);
                newWord = false;
                continue;
            }
            if(chars[i] == '_'){
                chars[i] = ' ';
                newWord = true;
                continue;
            }
            chars[i] = Character.toLowerCase(chars[i]);
        }

        return String.copyValueOf(chars);
    }
}
