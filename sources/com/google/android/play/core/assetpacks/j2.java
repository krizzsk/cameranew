package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/* loaded from: classes2.dex */
public final class j2 {
    private static f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized f a(Context context) {
        f fVar;
        synchronized (j2.class) {
            if (a == null) {
                x0 x0Var = new x0(null);
                x0Var.b(new n(com.google.android.play.core.splitcompat.q.a(context)));
                a = x0Var.a();
            }
            fVar = a;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File file : list) {
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        com.google.android.play.core.internal.j1.a(th, th2);
                    }
                    throw th;
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(messageDigest.digest(), 11);
    }

    public static boolean c(int i2) {
        return i2 == 1 || i2 == 7 || i2 == 2 || i2 == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(int i2, int i3) {
        if (i2 == 5) {
            if (i3 != 5) {
                return true;
            }
            i2 = 5;
        }
        if (i2 != 6 || i3 == 6 || i3 == 5) {
            if (i2 != 4 || i3 == 4) {
                if (i2 == 3 && (i3 == 2 || i3 == 7 || i3 == 1 || i3 == 8)) {
                    return true;
                }
                if (i2 == 2) {
                    return i3 == 1 || i3 == 8;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long e(byte[] bArr, int i2) {
        return ((g(bArr, i2 + 2) << 16) | g(bArr, i2)) & 4294967295L;
    }

    public static boolean f(int i2) {
        return i2 == 5 || i2 == 6 || i2 == 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | (bArr[i2] & Draft_75.END_OF_FRAME);
    }

    public static boolean h(int i2) {
        return i2 == 2 || i2 == 7 || i2 == 3;
    }
}
