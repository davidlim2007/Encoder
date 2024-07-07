public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./");;

        try
        {
            String strOriginal = "HELLO WORLD";
            System.out.println("Original : " + strOriginal);

            String strEncoded = encoder.encode(strOriginal, 'F');
            System.out.println("Encoded : " + strEncoded);

            String strDecoded = encoder.decode(strEncoded);
            System.out.println("Decoded : " + strDecoded);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}