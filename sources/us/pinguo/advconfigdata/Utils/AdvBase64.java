package us.pinguo.advconfigdata.Utils;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: classes3.dex */
public class AdvBase64 {
    private static final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] decodingTable = new byte[128];

    static {
        for (int i2 = 0; i2 < 128; i2++) {
            decodingTable[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            decodingTable[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            decodingTable[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            decodingTable[i5] = (byte) ((i5 - 48) + 52);
        }
        byte[] bArr = decodingTable;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] decode(byte[] bArr) {
        byte[] bArr2;
        byte[] discardNonBase64Bytes = discardNonBase64Bytes(bArr);
        if (discardNonBase64Bytes[discardNonBase64Bytes.length - 2] == 61) {
            bArr2 = new byte[(((discardNonBase64Bytes.length / 4) - 1) * 3) + 1];
        } else if (discardNonBase64Bytes[discardNonBase64Bytes.length - 1] == 61) {
            bArr2 = new byte[(((discardNonBase64Bytes.length / 4) - 1) * 3) + 2];
        } else {
            bArr2 = new byte[(discardNonBase64Bytes.length / 4) * 3];
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < discardNonBase64Bytes.length - 4) {
            byte[] bArr3 = decodingTable;
            byte b = bArr3[discardNonBase64Bytes[i2]];
            byte b2 = bArr3[discardNonBase64Bytes[i2 + 1]];
            byte b3 = bArr3[discardNonBase64Bytes[i2 + 2]];
            byte b4 = bArr3[discardNonBase64Bytes[i2 + 3]];
            bArr2[i3] = (byte) ((b << 2) | (b2 >> 4));
            bArr2[i3 + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            bArr2[i3 + 2] = (byte) (b4 | (b3 << 6));
            i2 += 4;
            i3 += 3;
        }
        if (discardNonBase64Bytes[discardNonBase64Bytes.length - 2] == 61) {
            byte[] bArr4 = decodingTable;
            byte b5 = bArr4[discardNonBase64Bytes[discardNonBase64Bytes.length - 4]];
            bArr2[bArr2.length - 1] = (byte) ((bArr4[discardNonBase64Bytes[discardNonBase64Bytes.length - 3]] >> 4) | (b5 << 2));
        } else if (discardNonBase64Bytes[discardNonBase64Bytes.length - 1] == 61) {
            byte[] bArr5 = decodingTable;
            byte b6 = bArr5[discardNonBase64Bytes[discardNonBase64Bytes.length - 4]];
            byte b7 = bArr5[discardNonBase64Bytes[discardNonBase64Bytes.length - 3]];
            byte b8 = bArr5[discardNonBase64Bytes[discardNonBase64Bytes.length - 2]];
            bArr2[bArr2.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr2[bArr2.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
        } else {
            byte[] bArr6 = decodingTable;
            byte b9 = bArr6[discardNonBase64Bytes[discardNonBase64Bytes.length - 4]];
            byte b10 = bArr6[discardNonBase64Bytes[discardNonBase64Bytes.length - 3]];
            byte b11 = bArr6[discardNonBase64Bytes[discardNonBase64Bytes.length - 2]];
            byte b12 = bArr6[discardNonBase64Bytes[discardNonBase64Bytes.length - 1]];
            bArr2[bArr2.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr2[bArr2.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr2[bArr2.length - 1] = (byte) (b12 | (b11 << 6));
        }
        return bArr2;
    }

    private static byte[] discardNonBase64Bytes(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (isValidBase64Byte(bArr[i3])) {
                bArr2[i2] = bArr[i3];
                i2++;
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    private static String discardNonBase64Chars(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (isValidBase64Byte((byte) str.charAt(i2))) {
                stringBuffer.append(str.charAt(i2));
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] encode(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length % 3;
        if (length == 0) {
            bArr2 = new byte[(bArr.length * 4) / 3];
        } else {
            bArr2 = new byte[((bArr.length / 3) + 1) * 4];
        }
        int length2 = bArr.length - length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            int i4 = bArr[i2] & Draft_75.END_OF_FRAME;
            int i5 = bArr[i2 + 1] & Draft_75.END_OF_FRAME;
            int i6 = bArr[i2 + 2] & Draft_75.END_OF_FRAME;
            byte[] bArr3 = encodingTable;
            bArr2[i3] = bArr3[(i4 >>> 2) & 63];
            bArr2[i3 + 1] = bArr3[((i4 << 4) | (i5 >>> 4)) & 63];
            bArr2[i3 + 2] = bArr3[((i5 << 2) | (i6 >>> 6)) & 63];
            bArr2[i3 + 3] = bArr3[i6 & 63];
            i2 += 3;
            i3 += 4;
        }
        if (length == 1) {
            int i7 = bArr[bArr.length - 1] & Draft_75.END_OF_FRAME;
            byte[] bArr4 = encodingTable;
            bArr2[bArr2.length - 4] = bArr4[(i7 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr4[(i7 << 4) & 63];
            bArr2[bArr2.length - 2] = 61;
            bArr2[bArr2.length - 1] = 61;
        } else if (length == 2) {
            int i8 = bArr[bArr.length - 2] & Draft_75.END_OF_FRAME;
            int i9 = bArr[bArr.length - 1] & Draft_75.END_OF_FRAME;
            byte[] bArr5 = encodingTable;
            bArr2[bArr2.length - 4] = bArr5[(i8 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr5[((i8 << 4) | (i9 >>> 4)) & 63];
            bArr2[bArr2.length - 2] = bArr5[(i9 << 2) & 63];
            bArr2[bArr2.length - 1] = 61;
        }
        return bArr2;
    }

    private static boolean isValidBase64Byte(byte b) {
        if (b == 61) {
            return true;
        }
        return b >= 0 && b < 128 && decodingTable[b] != -1;
    }

    public static byte[] decode(String str) {
        byte[] bArr;
        String discardNonBase64Chars = discardNonBase64Chars(str);
        if (discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 2) == '=') {
            bArr = new byte[(((discardNonBase64Chars.length() / 4) - 1) * 3) + 1];
        } else if (discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 1) == '=') {
            bArr = new byte[(((discardNonBase64Chars.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(discardNonBase64Chars.length() / 4) * 3];
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < discardNonBase64Chars.length() - 4) {
            byte[] bArr2 = decodingTable;
            byte b = bArr2[discardNonBase64Chars.charAt(i2)];
            byte b2 = bArr2[discardNonBase64Chars.charAt(i2 + 1)];
            byte b3 = bArr2[discardNonBase64Chars.charAt(i2 + 2)];
            byte b4 = bArr2[discardNonBase64Chars.charAt(i2 + 3)];
            bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
            bArr[i3 + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            bArr[i3 + 2] = (byte) (b4 | (b3 << 6));
            i2 += 4;
            i3 += 3;
        }
        if (discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 2) == '=') {
            byte[] bArr3 = decodingTable;
            byte b5 = bArr3[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 4)];
            bArr[bArr.length - 1] = (byte) ((bArr3[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 3)] >> 4) | (b5 << 2));
        } else if (discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 1) == '=') {
            byte[] bArr4 = decodingTable;
            byte b6 = bArr4[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 4)];
            byte b7 = bArr4[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 3)];
            byte b8 = bArr4[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
        } else {
            byte[] bArr5 = decodingTable;
            byte b9 = bArr5[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 4)];
            byte b10 = bArr5[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 3)];
            byte b11 = bArr5[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 2)];
            byte b12 = bArr5[discardNonBase64Chars.charAt(discardNonBase64Chars.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
        }
        return bArr;
    }
}
