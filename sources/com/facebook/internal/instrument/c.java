package com.facebook.internal.instrument;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.f;
import com.facebook.internal.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: InstrumentUtility.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InstrumentUtility.java */
    /* loaded from: classes.dex */
    public static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.matches(String.format("^%s[0-9]+.json$", "analysis_log_"));
        }
    }

    /* compiled from: InstrumentUtility.java */
    /* loaded from: classes.dex */
    static class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.matches(String.format("^(%s|%s|%s)[0-9]+.json$", "crash_log_", "shield_log_", "thread_check_log_"));
        }
    }

    public static boolean a(@Nullable String str) {
        File c = c();
        if (c == null || str == null) {
            return false;
        }
        return new File(c, str).delete();
    }

    @Nullable
    public static String b(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return th.getCause().toString();
    }

    @Nullable
    public static File c() {
        File file = new File(f.f().getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @Nullable
    public static String d(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static boolean e(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().startsWith("com.facebook")) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static File[] f() {
        File c = c();
        if (c == null) {
            return new File[0];
        }
        File[] listFiles = c.listFiles(new a());
        return listFiles != null ? listFiles : new File[0];
    }

    public static File[] g() {
        File c = c();
        if (c == null) {
            return new File[0];
        }
        File[] listFiles = c.listFiles(new b());
        return listFiles != null ? listFiles : new File[0];
    }

    @Nullable
    public static JSONObject h(@Nullable String str, boolean z) {
        File c = c();
        if (c != null && str != null) {
            try {
                return new JSONObject(x.i0(new FileInputStream(new File(c, str))));
            } catch (Exception unused) {
                if (z) {
                    a(str);
                }
            }
        }
        return null;
    }

    public static void i(String str, JSONArray jSONArray, GraphRequest.e eVar) {
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            GraphRequest.K(null, String.format("%s/instruments", f.g()), jSONObject, eVar).i();
        } catch (JSONException unused) {
        }
    }

    public static void j(@Nullable String str, @Nullable String str2) {
        File c = c();
        if (c == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(c, str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
