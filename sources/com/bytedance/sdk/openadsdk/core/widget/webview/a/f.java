package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* compiled from: Version.java */
/* loaded from: classes.dex */
public class f {
    private static k a;

    public static void a() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(b.f(), "temp_pkg_info.json");
                Long valueOf = Long.valueOf(file.length());
                if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        k a2 = k.a(new JSONObject(new String(bArr, "utf-8")));
                        if (a2 != null) {
                            a = a2;
                            o.b("Version", "old version read success: " + a.b());
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            o.c("Version", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                } else {
                    o.b("Version", "version pkg json file does not exist");
                }
            } catch (IOException unused2) {
                return;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
        if (fileInputStream2 != null) {
            fileInputStream2.close();
        }
    }

    public static synchronized k b() {
        k kVar;
        synchronized (f.class) {
            kVar = a;
        }
        return kVar;
    }

    public static void c() {
        k kVar = a;
        if (kVar == null) {
            o.b("Version", "version save error1");
            return;
        }
        String f2 = kVar.f();
        if (TextUtils.isEmpty(f2)) {
            o.b("Version", "version save error2");
            return;
        }
        File file = new File(b.f(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(f2.getBytes("utf-8"));
                    if (file.exists()) {
                        file.delete();
                    }
                    file2.renameTo(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        o.c("Version", "version save error3", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void d() {
        k b = b();
        if (b == null) {
            return;
        }
        File f2 = b.f();
        try {
            new File(f2, "temp_pkg_info.json").delete();
        } catch (Throwable unused) {
        }
        if (b.d() != null) {
            for (k.a aVar : b.d()) {
                try {
                    new File(f2, h.a(aVar.a())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
        a = null;
    }

    public static boolean b(String str) {
        if (b() != null && !TextUtils.isEmpty(b().b())) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String b = b().b();
            String[] split = str.split("\\.");
            String[] split2 = b.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int length = split[i2].length() - split2[i2].length();
                if (length != 0) {
                    return length > 0;
                }
                int compareTo = split[i2].compareTo(split2[i2]);
                if (compareTo > 0) {
                    return true;
                }
                if (compareTo < 0) {
                    return false;
                }
                if (i2 == min - 1) {
                    return split.length > split2.length;
                }
            }
            return false;
        }
        return true;
    }

    public static synchronized void a(k kVar) {
        synchronized (f.class) {
            if (kVar != null) {
                if (kVar.e()) {
                    a = kVar;
                }
            }
        }
    }

    public static k.a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().d() != null && b().e()) {
            for (k.a aVar : b().d()) {
                if (aVar.a() != null && aVar.a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
