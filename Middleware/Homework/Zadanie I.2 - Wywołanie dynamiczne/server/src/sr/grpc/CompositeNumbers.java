package sr.grpc;

public class CompositeNumbers {

    CompositeNumbers() {
        throw new IllegalStateException("Utility class");
    }
    public static boolean isComposite(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
