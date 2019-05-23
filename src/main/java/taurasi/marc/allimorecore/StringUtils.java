package taurasi.marc.allimorecore;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class StringUtils {
    public static ArrayList<String> WrapLoreString(String string, int charactersPerLine, ChatColor prefixColor){
        ArrayList<String> loreStrings = new ArrayList<>();
        char[] chars = string.toCharArray();
        int charsOnCurrentLine = 0;
        for(int i = 0; i < chars.length; i++){

            if( Character.isWhitespace(chars[i]) && charsOnCurrentLine >= charactersPerLine){
                loreStrings.add(prefixColor + string.substring(i - charsOnCurrentLine, i));
                charsOnCurrentLine = 0;
                continue;
            }
            charsOnCurrentLine ++;
        }
        if(charsOnCurrentLine != 0){
            loreStrings.add(prefixColor + string.substring(string.length()-charsOnCurrentLine));
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
