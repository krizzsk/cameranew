package us.pinguo.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
/* compiled from: PGWebFileUtil.java */
/* loaded from: classes6.dex */
public class b {
    public static final boolean a;

    /* compiled from: PGWebFileUtil.java */
    /* loaded from: classes6.dex */
    static class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PGWebFileUtil.java */
    /* renamed from: us.pinguo.webview.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0463b implements FileFilter {
        C0463b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Math.abs(System.currentTimeMillis() - file.lastModified()) > 3600000;
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        new a().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        String j2 = j();
        if (TextUtils.isEmpty(j2)) {
            return;
        }
        for (File file : new File(j2).listFiles(new C0463b())) {
            file.delete();
        }
    }

    @TargetApi(8)
    private static File d(Context context) {
        File externalStorageDirectory;
        File externalCacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (Build.VERSION.SDK_INT < 8 || (externalCacheDir = context.getExternalCacheDir()) == null || !externalCacheDir.exists()) {
                String str = "/Android/data/" + context.getPackageName() + "/cache/";
                if (Environment.getExternalStorageDirectory() == null) {
                    return null;
                }
                return new File(externalStorageDirectory.getAbsolutePath() + str);
            }
            return externalCacheDir;
        }
        return null;
    }

    public static File e(String str) {
        String g2 = g(str);
        if (TextUtils.isEmpty(g2)) {
            return null;
        }
        return new File(g2);
    }

    public static String f(String str) {
        String j2 = j();
        if (j2 == null) {
            return null;
        }
        return j2 + File.separator + str;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String j2 = j();
        if (TextUtils.isEmpty(j2)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (c.b().equals(parse.getAuthority())) {
            return j2 + File.separator + parse.getPath();
        }
        return null;
    }

    public static String h(File file) {
        if (a) {
            return c.d() + file.getName();
        }
        return c.c() + file.getName();
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(new File(str));
    }

    public static String j() {
        File d2;
        if (d(c.a()) == null) {
            return null;
        }
        String str = d2.getAbsolutePath() + File.separator + "web";
        File file = new File(str);
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            return str;
        }
        return null;
    }
}
