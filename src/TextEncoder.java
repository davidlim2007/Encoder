import java.util.List;
import java.util.stream.Collectors;

public class TextEncoder implements IEncoder {
    private List<Character> alphabet;

    public TextEncoder(String sAlphabet)
    {
        alphabet = sAlphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public String encode(List input) throws Exception
    {
        if (input.size() < 2)
        {
            throw new Exception("Unable to encode due to insufficient arguments.");
        }

        if (((String)input.get(1)).length() != 1)
        {
            throw new Exception("Unable to encode. Offset [" + input.get(1) + "] exceeds required length of 1.");
        }

        String plainText = (String) input.get(0);
        char offset = ((String) input.get(1)).charAt(0);

        if (!alphabet.contains(offset))
        {
            throw new Exception("Invalid offset [" + offset + "] not found in Alphabet. Unable to encode.");
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

            int newIndex = alphabetIndex - offsetIndex;

            if (newIndex < 0)
            {
                newIndex += alphabet.size();
            }

            sb.append(alphabet.get(newIndex));
        }

        return sb.toString();
    }

    public String decode(List input) throws Exception
    {
        if (input.size() == 0)
        {
            throw new Exception("Unable to decode due to insufficient arguments.");
        }

        String encodedText = (String) input.get(0);

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
