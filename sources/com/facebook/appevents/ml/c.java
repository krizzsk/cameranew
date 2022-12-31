package com.facebook.appevents.ml;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.f;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.File;
import java.nio.charset.Charset;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class c {
    @Nullable
    public static File a() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            File file = new File(f.f().getFilesDir(), "facebook_ml/");
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    static String b(String str) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return TextUtils.join(" ", str.trim().split("\\s+"));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] c(String str, int i2) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            int[] iArr = new int[i2];
            byte[] bytes = b(str).getBytes(Charset.forName("UTF-8"));
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 < bytes.length) {
                    iArr[i3] = bytes[i3] & Draft_75.END_OF_FRAME;
                } else {
                    iArr[i3] = 0;
                }
            }
            return iArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }
}
