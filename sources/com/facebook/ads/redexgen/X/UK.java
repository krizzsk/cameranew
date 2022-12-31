package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class UK implements I0 {
    public static byte[] A02;
    public static String[] A03 = {"", "E0qfI7DZu8nkzGv3MH4nJgqlD44FCDGV", "PylumRpOhcOqV8SE", "Pn3Or3lb8D1PR4hBSIJHER", "QrYBpEt5fxgmrBLneQSlInRulpYQYEG6", "kBYBv8gRMrLmplmIT6dDUsqqwhnWF3zw", "1HLCV5Ojolr5GVwArEzJLOO78iGdJHxw", "UyANx1"};
    public static final UK A04;
    public int A00;
    public final Map<String, byte[]> A01;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[7].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A03[3] = "rKK8X5tVBBDKhSudhE31wx";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 62);
            if (A03[2].length() != 16) {
                String[] strArr2 = A03;
                strArr2[7] = "FSEtti";
                strArr2[0] = "";
                i5 += 0;
            } else {
                String[] strArr3 = A03;
                strArr3[5] = "3tkzovd4FYEmOrd3uFeQsH7k2lQqNCGR";
                strArr3[4] = "QPp8yxf18vRmRgJoVMCalcriT9AA2Yst";
                i5++;
            }
        }
    }

    public static void A03() {
        byte[] bArr = {-121, -84, -76, -97, -86, -89, -94, 94, -76, -97, -86, -77, -93, 94, -79, -89, -72, -93, 120, 94, 11, 31, 28, -41, 42, 32, 49, 28, -41, 38, 29, -41, -36, 42, -41, -33, -36, 27, -32, -41, 32, 42, -41, 30, 41, 28, 24, 43, 28, 41, -41, 43, 31, 24, 37, -41, 36, 24, 47, 32, 36, 44, 36, -41, 24, 35, 35, 38, 46, 28, 27, -15, -41, -36, 27, -31, -32, -46, -71, -60};
        if (A03[3].length() != 22) {
            throw new RuntimeException();
        }
        A03[1] = "Wq4xFI36yK0vrvDqIYZkxKx0C2M1IMKh";
        A02 = bArr;
    }

    static {
        A03();
        A04 = new UK(Collections.emptyMap());
    }

    public UK(Map<String, byte[]> map) {
        Map<String, byte[]> metadata = Collections.unmodifiableMap(map);
        this.A01 = metadata;
    }

    public static UK A00(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < readInt; i2++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (A03[6].charAt(12) != 'G') {
                throw new RuntimeException();
            }
            A03[3] = "zQpUPHnv7TxzcbRfe6tZ6j";
            if (readInt2 < 0 || readInt2 > 10485760) {
                throw new IOException(A01(0, 20, 0) + readInt2);
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            hashMap.put(readUTF, bArr);
        }
        return new UK(hashMap);
    }

    public static Map<String, byte[]> A02(Map<String, byte[]> map, I2 i2) {
        HashMap hashMap = new HashMap(map);
        A04(hashMap, i2.A04());
        A05(hashMap, i2.A05());
        return hashMap;
    }

    public static void A04(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.remove(list.get(i2));
        }
    }

    public static void A05(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (String str : map.keySet()) {
            Object value = map.get(str);
            byte[] A07 = A07(value);
            if (A07.length <= 10485760) {
                hashMap.put(str, A07);
            } else {
                Object value2 = Integer.valueOf(A07.length);
                throw new IllegalArgumentException(String.format(A01(20, 55, 121), str, value2, 10485760));
            }
        }
    }

    private boolean A06(Map<String, byte[]> map) {
        Map<String, byte[]> otherMetadata = this.A01;
        if (otherMetadata.size() != map.size()) {
            return false;
        }
        Map<String, byte[]> otherMetadata2 = this.A01;
        for (Map.Entry<String, byte[]> entry : otherMetadata2.entrySet()) {
            byte[] value = entry.getValue();
            byte[] otherValue = map.get(entry.getKey());
            if (!Arrays.equals(value, otherValue)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] A07(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(A01(75, 5, 78)));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final UK A08(I2 i2) {
        Map<String, byte[]> A022 = A02(this.A01, i2);
        if (A06(A022)) {
            return this;
        }
        return new UK(A022);
    }

    public final void A09(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A01.size());
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.facebook.ads.redexgen.X.I0
    public final long A5U(String str, long j2) {
        if (this.A01.containsKey(str)) {
            return ByteBuffer.wrap(this.A01.get(str)).getLong();
        }
        return j2;
    }

    @Override // com.facebook.ads.redexgen.X.I0
    public final String A5W(String str, String str2) {
        if (this.A01.containsKey(str)) {
            return new String(this.A01.get(str), Charset.forName(A01(75, 5, 78)));
        }
        return str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A06(((UK) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i2 = 0;
            Iterator<Map.Entry<String, byte[]>> it = this.A01.entrySet().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                String[] strArr = A03;
                if (strArr[7].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                A03[3] = "oFmiTb5ocNjXgy8itQp3Jt";
                if (hasNext) {
                    Map.Entry<String, byte[]> next = it.next();
                    i2 += next.getKey().hashCode() ^ Arrays.hashCode(next.getValue());
                } else {
                    this.A00 = i2;
                    break;
                }
            }
        }
        return this.A00;
    }
}
