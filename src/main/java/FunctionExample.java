import java.security.CryptoPrimitive;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {
    public static void main(String[] args) {
        List<CryptoPrimitive> cryptoPrimitives = new ArrayList<>();
        List<CryptoPrimitive> filtered = filter(cryptoPrimitives, cc -> cc == CryptoPrimitive.BLOCK_CIPHER);

        calculatePayment(filtered, cc -> cc.getPrice());
    }

    private static int calculatePayment(List<CryptoPrimitive> filtered, Function<CryptoPrimitive, Integer> f) {
        int total = 0;
        for (CryptoPrimitive cryptoPrimitive : filtered) {
            total += f.apply(cryptoPrimitive);
        }
        return total;
    }

    private static List<CryptoPrimitive> filter (List < CryptoPrimitive > cryptoPrimitives,
                                                 Predicate < CryptoPrimitive > filter){
        List<CryptoPrimitive> filtered = new ArrayList<>();
        for (CryptoPrimitive cryptoPrimitive : cryptoPrimitives) {
            if (filter.test(cryptoPrimitive)) {
                filtered.add(cryptoPrimitive);
            }
        }
        return filtered;
    }


}

