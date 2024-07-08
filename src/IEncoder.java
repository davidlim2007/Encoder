import java.util.List;

public interface IEncoder {
    String encode(List input) throws Exception;
    String decode(List input) throws Exception;
}
