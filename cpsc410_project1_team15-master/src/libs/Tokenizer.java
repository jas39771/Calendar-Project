package libs;

public interface Tokenizer {

    String getNext();

    boolean checkToken(String regexp);

    String getAndCheck(String regexp);

    boolean moreTokens();
}
