package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes2.dex */
final class c {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.google.zxing.common.d a(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        com.google.zxing.common.c cVar = new com.google.zxing.common.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            try {
                if (cVar.a() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(cVar.b(4));
                }
                Mode mode2 = forBits;
                int[] iArr = a.a;
                switch (iArr[mode2.ordinal()]) {
                    case 5:
                        mode = mode2;
                        break;
                    case 6:
                    case 7:
                        mode = mode2;
                        z = true;
                        break;
                    case 8:
                        if (cVar.a() >= 16) {
                            int b = cVar.b(8);
                            i4 = cVar.b(8);
                            i3 = b;
                            mode = mode2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 9:
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(g(cVar));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                        mode = mode2;
                        break;
                    case 10:
                        int b2 = cVar.b(4);
                        int b3 = cVar.b(mode2.getCharacterCountBits(gVar));
                        if (b2 == i2) {
                            d(cVar, sb, b3);
                        }
                        mode = mode2;
                        break;
                    default:
                        int b4 = cVar.b(mode2.getCharacterCountBits(gVar));
                        int i5 = iArr[mode2.ordinal()];
                        if (i5 == i2) {
                            mode = mode2;
                            f(cVar, sb, b4);
                            break;
                        } else if (i5 == 2) {
                            mode = mode2;
                            b(cVar, sb, b4, z);
                            break;
                        } else if (i5 == 3) {
                            mode = mode2;
                            c(cVar, sb, b4, characterSetECI, arrayList, map);
                            break;
                        } else if (i5 == 4) {
                            e(cVar, sb, b4);
                            mode = mode2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                }
                if (mode == Mode.TERMINATOR) {
                    return new com.google.zxing.common.d(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i3, i4);
                }
                i2 = 1;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb, int i2, boolean z) throws FormatException {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int b = cVar.b(11);
                sb.append(h(b / 45));
                sb.append(h(b % 45));
                i2 -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(h(cVar.b(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(com.google.zxing.common.c cVar, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String name;
        if ((i2 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.b(8);
            }
            if (characterSetECI == null) {
                name = j.a(bArr, map);
            } else {
                name = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int b = cVar.b(13);
                int i4 = (b % 96) | ((b / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void e(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int b = cVar.b(13);
                int i4 = (b % 192) | ((b / 192) << 8);
                int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void f(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (cVar.a() >= 10) {
                int b = cVar.b(10);
                if (b < 1000) {
                    sb.append(h(b / 100));
                    sb.append(h((b / 10) % 10));
                    sb.append(h(b % 10));
                    i2 -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i2 == 2) {
            if (cVar.a() >= 7) {
                int b2 = cVar.b(7);
                if (b2 < 100) {
                    sb.append(h(b2 / 10));
                    sb.append(h(b2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i2 == 1) {
            if (cVar.a() >= 4) {
                int b3 = cVar.b(4);
                if (b3 < 10) {
                    sb.append(h(b3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int g(com.google.zxing.common.c cVar) throws FormatException {
        int b = cVar.b(8);
        if ((b & 128) == 0) {
            return b & 127;
        }
        if ((b & 192) == 128) {
            return cVar.b(8) | ((b & 63) << 8);
        }
        if ((b & 224) == 192) {
            return cVar.b(16) | ((b & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i2) throws FormatException {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }
}
