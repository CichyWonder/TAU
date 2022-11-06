import javax.crypto.IllegalBlockSizeException;

public class AreaOfTriangle {
    public double p;

    public double AreaOfTriangle(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException();

        if (a + b > c && b + c > a && a + c > b) {
            p =((a + b + c) / 2);
            return Math.sqrt(p * (p-a) * (p-b) * (p-c));
        } else {
            return 0;
        }

    }
}
