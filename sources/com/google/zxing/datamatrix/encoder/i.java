package com.google.zxing.datamatrix.encoder;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.growingio.android.sdk.monitor.BuildConfig;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: ErrorCorrection.java */
/* loaded from: classes2.dex */
public final class i {
    private static final int[] a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 9, 233, 71, 168, 2, 188, 160, 153, BuildConfig.VERSION_CODE, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 154, 36, 73, 127, 213, 136, 248, BaseBlurEffect.ROTATION_180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] c = new int[256];

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f5014d = new int[255];

    static {
        int i2 = 1;
        for (int i3 = 0; i3 < 255; i3++) {
            f5014d[i3] = i2;
            c[i2] = i3;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= 301;
            }
        }
    }

    private static String a(CharSequence charSequence, int i2) {
        return b(charSequence, 0, charSequence.length(), i2);
    }

    private static String b(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = a;
            if (i5 >= iArr.length) {
                i5 = -1;
                break;
            } else if (iArr[i5] == i4) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            int[] iArr2 = b[i5];
            char[] cArr = new char[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                cArr[i6] = 0;
            }
            for (int i7 = i2; i7 < i2 + i3; i7++) {
                int i8 = i4 - 1;
                int charAt = cArr[i8] ^ charSequence.charAt(i7);
                while (i8 > 0) {
                    if (charAt != 0 && iArr2[i8] != 0) {
                        char c2 = cArr[i8 - 1];
                        int[] iArr3 = f5014d;
                        int[] iArr4 = c;
                        cArr[i8] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i8]]) % 255]);
                    } else {
                        cArr[i8] = cArr[i8 - 1];
                    }
                    i8--;
                }
                if (charAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = f5014d;
                    int[] iArr6 = c;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i4];
            for (int i9 = 0; i9 < i4; i9++) {
                cArr2[i9] = cArr[(i4 - i9) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i4)));
    }

    public static String c(String str, k kVar) {
        if (str.length() == kVar.a()) {
            StringBuilder sb = new StringBuilder(kVar.a() + kVar.c());
            sb.append(str);
            int f2 = kVar.f();
            if (f2 == 1) {
                sb.append(a(str, kVar.c()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[f2];
                int[] iArr2 = new int[f2];
                int[] iArr3 = new int[f2];
                int i2 = 0;
                while (i2 < f2) {
                    int i3 = i2 + 1;
                    iArr[i2] = kVar.b(i3);
                    iArr2[i2] = kVar.d(i3);
                    iArr3[i2] = 0;
                    if (i2 > 0) {
                        iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                    }
                    i2 = i3;
                }
                for (int i4 = 0; i4 < f2; i4++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i4]);
                    for (int i5 = i4; i5 < kVar.a(); i5 += f2) {
                        sb2.append(str.charAt(i5));
                    }
                    String a2 = a(sb2.toString(), iArr2[i4]);
                    int i6 = i4;
                    int i7 = 0;
                    while (i6 < iArr2[i4] * f2) {
                        sb.setCharAt(kVar.a() + i6, a2.charAt(i7));
                        i6 += f2;
                        i7++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }
}
