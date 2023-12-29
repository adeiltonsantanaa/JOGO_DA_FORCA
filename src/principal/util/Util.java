package principal.util;

public class Util {

    public static String mascararPalavraSecreta(String palavraSecreta) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palavraSecreta.length(); i++) {
            sb.append("_ ");
        }
        return sb.toString();
    }
}
