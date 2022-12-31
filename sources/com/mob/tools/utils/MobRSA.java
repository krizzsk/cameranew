package com.mob.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
/* loaded from: classes3.dex */
public class MobRSA {
    private int keySize;

    public MobRSA(int i2) {
        this.keySize = i2;
    }

    private byte[] decodeBlock(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        return recoveryPaddingBlock(new BigInteger(bArr).modPow(bigInteger, bigInteger2).toByteArray());
    }

    private byte[] encodeBlock(byte[] bArr, int i2, int i3, BigInteger bigInteger, BigInteger bigInteger2, int i4) throws Throwable {
        if (bArr.length != i3 || i2 != 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            bArr = bArr2;
        }
        BigInteger bigInteger3 = new BigInteger(paddingBlock(bArr, i4));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new Throwable("the message must be smaller than the modulue");
    }

    private byte[] paddingBlock(byte[] bArr, int i2) throws Throwable {
        if (bArr.length <= i2 - 1) {
            byte[] bArr2 = new byte[i2];
            bArr2[0] = 1;
            int length = bArr.length;
            bArr2[1] = (byte) (length >> 24);
            bArr2[2] = (byte) (length >> 16);
            bArr2[3] = (byte) (length >> 8);
            bArr2[4] = (byte) length;
            System.arraycopy(bArr, 0, bArr2, i2 - length, length);
            return bArr2;
        }
        throw new Throwable("Message too large");
    }

    private byte[] recoveryPaddingBlock(byte[] bArr) throws Throwable {
        if (bArr[0] == 1) {
            int i2 = ((bArr[1] & 255) << 24) + ((bArr[2] & 255) << 16) + ((bArr[3] & 255) << 8) + (bArr[4] & 255);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, bArr.length - i2, bArr2, 0, i2);
            return bArr2;
        }
        throw new Throwable("Not RSA Block");
    }

    public byte[] decode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (dataInputStream.available() > 0) {
            byte[] bArr2 = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr2);
            byteArrayOutputStream.write(decodeBlock(bArr2, bigInteger, bigInteger2));
        }
        dataInputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] encode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        int i2 = this.keySize / 8;
        int i3 = i2 - 11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i4 = 0;
        while (bArr.length > i4) {
            int min = Math.min(bArr.length - i4, i3);
            byte[] encodeBlock = encodeBlock(bArr, i4, min, bigInteger, bigInteger2, i2);
            dataOutputStream.writeInt(encodeBlock.length);
            dataOutputStream.write(encodeBlock);
            i4 += min;
        }
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public BigInteger[] genKeys() throws Throwable {
        SecureRandom secureRandom = new SecureRandom();
        return genKeys(BigInteger.probablePrime((this.keySize / 2) - 1, secureRandom), BigInteger.probablePrime((this.keySize / 2) - 1, secureRandom), BigInteger.probablePrime(this.keySize / 2, secureRandom));
    }

    public BigInteger[] genKeys(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws Throwable {
        BigInteger bigInteger4 = BigInteger.ONE;
        if (bigInteger3.compareTo(bigInteger4) > 0) {
            BigInteger[] bigIntegerArr = new BigInteger[3];
            BigInteger multiply = bigInteger.multiply(bigInteger2);
            BigInteger add = multiply.subtract(bigInteger).subtract(bigInteger2).add(bigInteger4);
            if (bigInteger3.compareTo(add) < 0) {
                if (add.gcd(bigInteger3).compareTo(bigInteger4) == 0) {
                    BigInteger modInverse = bigInteger3.modInverse(add);
                    bigIntegerArr[0] = bigInteger3;
                    bigIntegerArr[1] = modInverse;
                    bigIntegerArr[2] = multiply;
                    return bigIntegerArr;
                }
                throw new Throwable("e must be coprime with (p-1)*(q-1)");
            }
            throw new Throwable("e must be smaller than (p-1)*(q-1)");
        }
        throw new Throwable("e must be larger than 1");
    }
}
