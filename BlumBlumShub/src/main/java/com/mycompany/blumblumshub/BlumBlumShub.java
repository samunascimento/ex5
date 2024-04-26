package com.mycompany.blumblumshub;
import java.math.BigInteger;

/**
 *
 * @author Samuel
 */
public class BlumBlumShub {
    private BigInteger seed;
    private BigInteger p;
    private BigInteger q;
    private BigInteger m;

    public BlumBlumShub(BigInteger seed, BigInteger p, BigInteger q) {
        this.seed = seed;
        this.p = p;
        this.q = q;
        this.m = p.multiply(q);
    }

    private byte generateRandomBit() {
        seed = seed.modPow(BigInteger.valueOf(2), m);
        return seed.testBit(0) ? (byte) 1 : (byte) 0;
    }

    public int generateNextRandomNumber() {
        int nextRandomNumber = seed.modPow(BigInteger.valueOf(2), m).intValue();
        seed = BigInteger.valueOf(nextRandomNumber);
        return nextRandomNumber;
    }

    public int generateNextRandomNumber(int min, int max) {
        int range = max - min + 1;
        return min + Math.abs(generateNextRandomNumber()) % range;
    }

    public int[] generateRandomSequence(int n, int min, int max) {
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = generateNextRandomNumber(min, max);
        }
        return sequence;
    }

    public static void main(String[] args) {
        BigInteger p = new BigInteger("10007");
        BigInteger q = new BigInteger("15991");
        BigInteger seed = new BigInteger("6367859");

        BlumBlumShub generator = new BlumBlumShub(seed, p, q);

        int[] randomNumbers = generator.generateRandomSequence(10, 1, 100);
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
    }
}


/* VALORES :

p = 1007
q = 15991
s = 6367859
*/

