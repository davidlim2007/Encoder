import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IEncoder encoder = new TextEncoder(args[0]);;

        try
        {
            String strOriginal = "HELLO WORLD";
            System.out.println("Original : " + strOriginal);

            List encodingInput = new ArrayList<String>();
            encodingInput.add(strOriginal);
            encodingInput.add(args[1]);
            String strEncoded = encoder.encode(encodingInput);
            System.out.println("Encoded : " + strEncoded);

            List decodingInput = new ArrayList<String>();
            decodingInput.add(strEncoded);
            String strDecoded = encoder.decode(decodingInput);
            System.out.println("Decoded : " + strDecoded);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}