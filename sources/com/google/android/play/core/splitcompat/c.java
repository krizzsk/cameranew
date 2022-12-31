package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public final class c {
    private final long a;
    private final Context b;
    private File c;

    public c(Context context) throws PackageManager.NameNotFoundException {
        this.b = context;
        this.a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    private static File b(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static void k(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                k(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    private static void m(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("File input must be directory when it exists.");
            }
            return;
        }
        file.mkdirs();
        if (file.isDirectory()) {
            return;
        }
        String valueOf = String.valueOf(file.getAbsolutePath());
        throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
    }

    private final File q() throws IOException {
        File file = new File(s(), "verified-splits");
        m(file);
        return file;
    }

    private final File s() throws IOException {
        File file = new File(u(), Long.toString(this.a));
        m(file);
        return file;
    }

    private final File t(String str) throws IOException {
        File b = b(w(), str);
        m(b);
        return b;
    }

    private final File u() throws IOException {
        if (this.c == null) {
            Context context = this.b;
            if (context == null) {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
            this.c = context.getFilesDir();
        }
        File file = new File(this.c, "splitcompat");
        m(file);
        return file;
    }

    private static String v(String str) {
        return String.valueOf(str).concat(".apk");
    }

    private final File w() throws IOException {
        File file = new File(s(), "native-libraries");
        m(file);
        return file;
    }

    public final File a(File file) throws IOException {
        return b(q(), file.getName());
    }

    public final File c(String str) throws IOException {
        return b(i(), v(str));
    }

    public final File d(String str, String str2) throws IOException {
        return b(t(str), str2);
    }

    public final void e() throws IOException {
        File u = u();
        String[] list = u.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.a))) {
                    File file = new File(u, str);
                    String valueOf = String.valueOf(file);
                    long j2 = this.a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j2);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    k(file);
                }
            }
        }
    }

    public final File f() throws IOException {
        return new File(s(), "lock.tmp");
    }

    public final File g(String str) throws IOException {
        return b(q(), v(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(File file) throws IOException {
        y.d(file.getParentFile().getParentFile().equals(w()), "File to remove is not a native library");
        k(file);
    }

    public final File i() throws IOException {
        File file = new File(s(), "unverified-splits");
        m(file);
        return file;
    }

    public final File j(String str) throws IOException {
        File file = new File(s(), "dex");
        m(file);
        File b = b(file, str);
        m(b);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<r> l() throws IOException {
        String name;
        File q = q();
        HashSet hashSet = new HashSet();
        File[] listFiles = q.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    hashSet.add(new r(file, file.getName().substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(String str) throws IOException {
        k(t(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> o() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = w().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<File> p(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = t(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(String str) throws IOException {
        k(g(str));
    }
}
