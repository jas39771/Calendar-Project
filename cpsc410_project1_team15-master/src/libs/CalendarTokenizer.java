package libs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarTokenizer implements Tokenizer {

    public static Tokenizer createCalendarTokenizer(String filename, List<String> fixedLiteralsList)
    {
        return new CalendarTokenizer(filename, fixedLiteralsList);
    }
    private static final String RESERVEDWORD = "_";
    private String userInput;
    private List<String> fixedLiterals;
    private String[] tokens;
    private int currentToken = 0;

    private CalendarTokenizer(String filename, List<String> LiteralsList){
        fixedLiterals = LiteralsList;
        try {
            userInput = Files.readString(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        tokenizeCalendar();
    }

    private void tokenizeCalendar(){
        String tokenizedProgram = userInput.replace("\n", "");

        for(String s : fixedLiterals) {
            tokenizedProgram = tokenizedProgram.replace(s, RESERVEDWORD + s + RESERVEDWORD);
        }

        tokenizedProgram = tokenizedProgram.replace(RESERVEDWORD+RESERVEDWORD,RESERVEDWORD);

        if(tokenizedProgram.length() > 0 && tokenizedProgram.startsWith(RESERVEDWORD)) {
            tokenizedProgram = tokenizedProgram.substring(RESERVEDWORD.length());
        }

        tokens = tokenizedProgram.split(RESERVEDWORD);
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }

        List<String> finaltokens = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("")) {
                finaltokens.add(tokens[i]);

            }
        }
        tokens = finaltokens.toArray(new String[0]);
        System.out.println(Arrays.asList(tokens));
    }

    private String checkNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
        }
        else
            token="NONE_LEFT";
        return token;
    }

    @Override
    public String getNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
            currentToken++;
        }
        else
            token="_NULL_";
        return token;
    }

    @Override
    public boolean checkToken(String regexp){
        String s = checkNext();
        return (s.matches(regexp));
    }

    @Override
    public String getAndCheck(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) {
            throw new RuntimeException("WRONG TOKEN");
        }
        return s;
    }

    @Override
    public boolean moreTokens(){
        return currentToken<tokens.length;
    }

}
