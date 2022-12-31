package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class Code128Writer extends m {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int f(CharSequence charSequence, int i2, int i3) {
        CType g2;
        CType g3;
        char charAt;
        CType g4 = g(charSequence, i2);
        CType cType = CType.ONE_DIGIT;
        if (g4 == cType) {
            return 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (g4 == cType2) {
            return (i2 >= charSequence.length() || ((charAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || charAt >= '`'))) ? 100 : 101;
        } else if (i3 == 99) {
            return 99;
        } else {
            if (i3 == 100) {
                CType cType3 = CType.FNC_1;
                if (g4 == cType3 || (g2 = g(charSequence, i2 + 2)) == cType2 || g2 == cType) {
                    return 100;
                }
                if (g2 == cType3) {
                    return g(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i4 = i2 + 4;
                while (true) {
                    g3 = g(charSequence, i4);
                    if (g3 != CType.TWO_DIGITS) {
                        break;
                    }
                    i4 += 2;
                }
                return g3 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (g4 == CType.FNC_1) {
                g4 = g(charSequence, i2 + 1);
            }
            return g4 == CType.TWO_DIGITS ? 99 : 100;
        }
    }

    private static CType g(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                        break;
                    default:
                        if (charAt <= 127) {
                            break;
                        } else {
                            throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (true) {
                int i8 = 103;
                if (i4 < length) {
                    int f2 = f(str, i4, i6);
                    int i9 = 100;
                    if (f2 == i6) {
                        switch (str.charAt(i4)) {
                            case 241:
                                i9 = 102;
                                break;
                            case 242:
                                i9 = 97;
                                break;
                            case 243:
                                i9 = 96;
                                break;
                            case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                                if (i6 == 101) {
                                    i9 = 101;
                                    break;
                                }
                                break;
                            default:
                                if (i6 != 100) {
                                    if (i6 == 101) {
                                        i9 = str.charAt(i4) - ' ';
                                        if (i9 < 0) {
                                            i9 += 96;
                                            break;
                                        }
                                    } else {
                                        i9 = Integer.parseInt(str.substring(i4, i4 + 2));
                                        i4++;
                                        break;
                                    }
                                } else {
                                    i9 = str.charAt(i4) - ' ';
                                    break;
                                }
                                break;
                        }
                        i4++;
                    } else {
                        if (i6 != 0) {
                            i8 = f2;
                        } else if (f2 == 100) {
                            i8 = 104;
                        } else if (f2 != 101) {
                            i8 = 105;
                        }
                        i9 = i8;
                        i6 = f2;
                    }
                    arrayList.add(c.a[i9]);
                    i5 += i9 * i7;
                    if (i4 != 0) {
                        i7++;
                    }
                } else {
                    int[][] iArr = c.a;
                    arrayList.add(iArr[i5 % 103]);
                    arrayList.add(iArr[106]);
                    int i10 = 0;
                    for (int[] iArr2 : arrayList) {
                        for (int i11 : iArr2) {
                            i10 += i11;
                        }
                    }
                    boolean[] zArr = new boolean[i10];
                    for (int[] iArr3 : arrayList) {
                        i2 += m.b(zArr, i2, iArr3, true);
                    }
                    return zArr;
                }
            }
        } else {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
    }
}
