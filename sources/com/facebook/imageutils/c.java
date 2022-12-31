package com.facebook.imageutils;

import com.facebook.common.internal.h;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: JfifUtil.java */
/* loaded from: classes.dex */
public class c {
    public static int a(int i2) {
        return e.a(i2);
    }

    public static int b(InputStream inputStream) {
        try {
            int d2 = d(inputStream);
            if (d2 == 0) {
                return 0;
            }
            return e.d(inputStream, d2);
        } catch (IOException unused) {
            return 0;
        }
    }

    private static boolean c(int i2) {
        switch (i2) {
            case 192:
            case 193:
            case 194:
            case 195:
            case 197:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            case 196:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    private static int d(InputStream inputStream) throws IOException {
        int a;
        if (e(inputStream, 225) && (a = d.a(inputStream, 2, false) - 2) > 6) {
            int a2 = d.a(inputStream, 4, false);
            int a3 = d.a(inputStream, 2, false);
            int i2 = (a - 4) - 2;
            if (a2 == 1165519206 && a3 == 0) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean e(InputStream inputStream, int i2) throws IOException {
        h.g(inputStream);
        while (d.a(inputStream, 1, false) == 255) {
            int i3 = 255;
            while (i3 == 255) {
                i3 = d.a(inputStream, 1, false);
            }
            if ((i2 != 192 || !c(i3)) && i3 != i2) {
                if (i3 != 216 && i3 != 1) {
                    if (i3 == 217 || i3 == 218) {
                        break;
                    }
                    inputStream.skip(d.a(inputStream, 2, false) - 2);
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
