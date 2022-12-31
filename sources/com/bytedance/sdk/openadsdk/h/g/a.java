package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Objects;
/* compiled from: FileHelper.java */
/* loaded from: classes.dex */
public class a {
    static Context a;

    public static void a(Context context) {
        Objects.requireNonNull(context);
        a = context;
    }

    public static File b(Context context) {
        return context.getCacheDir();
    }

    public static boolean c() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState)) {
                if (!"mounted_ro".equals(externalStorageState)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return c.a().b();
        }
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static File b() {
        if (c() && d()) {
            File file = new File(a(), "video");
            a(file);
            return file;
        }
        return null;
    }

    @Deprecated
    public static File a() {
        return b(a);
    }

    public static File a(File file, String str) {
        if (c() && d() && !TextUtils.isEmpty(str)) {
            if (file == null) {
                file = a();
            }
            File file2 = new File(file, str);
            a(file2);
            return file2;
        }
        return null;
    }

    public static void a(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
