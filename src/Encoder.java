import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Encoder {
    private List<Character> alphabet;

    public Encoder(String sAlphabet)
    {
        alphabet = sAlphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public String encode(String plainText, char offset) throws Exception
    {
        if (!alphabet.contains(offset))
        {
            throw new Exception("Invalid offset " + offset + " not found in Alphabet. Unable to encode.");
        }

        int offsetIndex = alphabet.indexOf(offset);
        StringBuilder sb = new StringBuilder();
        sb.append(offset);

        char[] plainTextChars = plainText.toCharArray();

        for (char c : plainTextChars)
        {
            int alphabetIndex = alphabet.indexOf(c);

            if (alphabetIndex == -1)
            {
                sb.append(c);
                continue;
            }

            int newIndex = ((alphabetIndex - offsetIndex) % alphabet.size());
            sb.append(alphabet.get(newIndex));
        }

        return sb.toString();
    }

    public String decode(String encodedText) throws Exception
    {
        if (!alphabet.contains(encodedText.charAt(0)))
        {
            throw new Exception("Invalid offset " + encodedText.charAt(0) + " not found in Alphabet. Unable to decode.");
        }

        int offsetIndex = alphabet.indexOf(encodedText.charAt(0));
        StringBuilder sb = new StringBuilder();
        char[] encodedChars = encodedText.toCharArray();

        for (int i = 1; i < encodedChars.length; i++)
        {
            char c = encodedChars[i];
            int encodedIndex = alphabet.indexOf(c);

            if (encodedIndex == -1)
            {
                sb.append(c);
                continue;
            }

            int newIndex = ((encodedIndex + offsetIndex) % alphabet.size());
            sb.append(alphabet.get(newIndex));
        }

        return sb.toString();
    }
}
