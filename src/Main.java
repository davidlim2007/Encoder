import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2)
        {
            System.out.println("Insufficient arguments. Required: <alphabet> <offset>.");
            System.exit(-1);
        }

        IEncoder encoder = new TextEncoder(args[0]);;

        try
        {
            System.out.println("Please enter the text you want to encode/decode.");
            String strOriginal = new Scanner(System.in).nextLine();

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