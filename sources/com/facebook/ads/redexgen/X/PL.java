package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class PL {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02 = {"Y0rICHp14ARSNu9MlXOQlrQKpJ7V2hwf", "9bmfgm9m8nITbmWk0ICcMAG3MrS", "cwEc0HiI6y8ZhWJ4MUGuUSsWKgKIPOUb", "CeguwAwwe", "1UN8Pz5pD", "KG5kSs2s3o8nfvSCZiVMOrQyfdZTA2DP", "BO8EwxINC4bfwl9QwPIiUjcYWt5Jq71N", "VnsxrIf3KddrD6MinhDJfsdqz9CBs5tu"};

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            A02[5] = "V4DWKv2CalsHghC0GoFw5ZQ5aRA0odCa";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 71);
            i5++;
        }
    }

    public static void A03() {
        A01 = new byte[]{-1, 36, 46, 43, 39, 28, 52, 8, 32, 47, 45, 36, 30, 46, -37, 36, 46, -37, 41, 48, 39, 39, -23, 9, 28, 42, 38, 44, 41, 26, 28, 42, -41, 32, 42, -41, 37, 44, 35, 35, -27, -65, -54, -43, -46, -51, -54, -35, -46, -40, -41, -119, -49, -54, -46, -43, -50, -51, -105, -34, -32, -35};
    }

    static {
        A03();
        A00 = true;
    }

    @Nullable
    public static BitmapDrawable A00(XT xt, @Nullable String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null && (!A00 || A05(xt, decodeByteArray))) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = xt.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A04(xt, A02(0, 23, 116));
                    }
                } else {
                    A04(xt, A02(23, 18, 112));
                }
                return bitmapDrawable;
            }
            return null;
        } catch (Throwable th) {
            xt.A06().A8q(A02(59, 3, 42), C06808m.A1h, new C06818n(th));
            return null;
        }
    }

    @Nullable
    public static PM A01(XT xt, @Nullable String str) {
        BitmapDrawable A002;
        try {
            if (TextUtils.isEmpty(str) || (A002 = A00(xt, str)) == null) {
                return null;
            }
            PM pm = new PM(xt);
            if (Build.VERSION.SDK_INT >= 16) {
                pm.setBackground(A002);
            } else {
                pm.setBackgroundDrawable(A002);
            }
            pm.setClickable(false);
            pm.setFocusable(false);
            return pm;
        } catch (Throwable th) {
            xt.A06().A8q(A02(59, 3, 42), C06808m.A1h, new C06818n(th));
            return null;
        }
    }

    public static void A04(XT xt, String str) {
        xt.A06().A8q(A02(59, 3, 42), C06808m.A1h, new C06818n(str));
    }

    @VisibleForTesting
    public static boolean A05(XT xt, Bitmap bitmap) {
        int i2 = 0;
        while (true) {
            int width = bitmap.getWidth();
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            A02[2] = "44dBdHmZhYYzc5DiIB6SXSnn6xfqMO61";
            if (i2 < width) {
                for (int i3 = 0; i3 < bitmap.getHeight(); i3++) {
                    if (Color.alpha(bitmap.getPixel(i2, i3)) / 255.0f > 0.03f) {
                        A04(xt, A02(41, 18, 34));
                        return false;
                    }
                }
                i2++;
            } else {
                return true;
            }
        }
    }
}
