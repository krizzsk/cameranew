package us.pinguo.common.network.encrypt;
/* loaded from: classes4.dex */
public class Xor {
    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = i3 % length;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i4]);
            i2++;
            i3 = i4 + 1;
        }
        return bArr;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = i3 % length;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i4]);
            i2++;
            i3 = i4 + 1;
        }
        return bArr;
    }
}
