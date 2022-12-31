package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
/* compiled from: DirectorySoSource.java */
/* loaded from: classes.dex */
public class c extends k {
    protected final File a;
    protected final int b;

    public c(File file, int i2) {
        this.a = file;
        this.b = i2;
    }

    private static String[] c(File file) throws IOException {
        boolean z = SoLoader.a;
        if (z) {
            Api18TraceUtils.a("SoLoader.getElfDependencies[", file.getName(), "]");
        }
        try {
            String[] a = MinElf.a(file);
            if (z) {
                Api18TraceUtils.b();
            }
            return a;
        } catch (Throwable th) {
            if (SoLoader.a) {
                Api18TraceUtils.b();
            }
            throw th;
        }
    }

    private static void d(File file, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] c = c(file);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(c));
        for (String str : c) {
            if (!str.startsWith("/")) {
                SoLoader.j(str, i2 | 1, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.k
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return e(str, i2, this.a, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        }
        Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
        if ((i2 & 1) != 0 && (this.b & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.b & 1) != 0) {
            d(file2, i2, threadPolicy);
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            SoLoader.b.a(file2.getAbsolutePath(), i2);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (e2.getMessage().contains("bad ELF magic")) {
                Log.d("SoLoader", "Corrupted lib file detected");
                return 3;
            }
            throw e2;
        }
    }

    @Override // com.facebook.soloader.k
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.a.getCanonicalPath());
        } catch (IOException unused) {
            name = this.a.getName();
        }
        return getClass().getName() + "[root = " + name + " flags = " + this.b + ']';
    }
}
