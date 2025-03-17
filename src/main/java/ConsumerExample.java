import java.awt.image.SampleModel;
import java.security.CryptoPrimitive;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {
    public static void main(String[] args) {
        List<CryptoPrimitive> cryptoPrimitives = new ArrayList<>();
        //cryptoPrimitives.stream().filter(cc -> cc == CryptoPrimitive.BLOCK_CIPHER).toList();
        List<CryptoPrimitive> filtered = filter(cryptoPrimitives, cc -> cc == CryptoPrimitive.BLOCK_CIPHER);
        //filtered.forEach(cc -> saveBookMark(cc));
        addBookMark(filtered, cc -> saveBookMark(cc));
    }

    private static void saveBookMark(CryptoPrimitive cc) {
        System.out.println("save " + cc);
    }

    private static void addBookMark(List<CryptoPrimitive> cryptoPrimitives,
                                    Consumer<CryptoPrimitive> consumer) {
        for (CryptoPrimitive cryptoPrimitive : cryptoPrimitives) {
            consumer.accept(cryptoPrimitive);
        }
    }

    private static List<CryptoPrimitive> filter(List<CryptoPrimitive> cryptoPrimitives,
                                 Predicate<CryptoPrimitive> filter) {
        List<CryptoPrimitive> filtered = new ArrayList<>();
        for (CryptoPrimitive cryptoPrimitive : cryptoPrimitives) {
            if (filter.test(cryptoPrimitive)) {
                filtered.add(cryptoPrimitive);
            }
        }
        return filtered;
    }


}
