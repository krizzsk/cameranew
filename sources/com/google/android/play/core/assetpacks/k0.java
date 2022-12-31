package com.google.android.play.core.assetpacks;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k0 {
    private static final com.google.android.play.core.internal.j c = new com.google.android.play.core.internal.j("AssetPackStorage");

    /* renamed from: d  reason: collision with root package name */
    private static final long f4753d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f4754e;
    private final Context a;
    private final t2 b;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        f4753d = timeUnit.toMillis(14L);
        f4754e = timeUnit.toMillis(28L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(Context context, t2 t2Var) {
        this.a = context;
        this.b = t2Var;
    }

    private final File E(String str) {
        return new File(J(), str);
    }

    private final File F(String str, int i2, long j2) {
        return new File(n(str, i2, j2), "merge.tmp");
    }

    private final List<File> G() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        try {
        } catch (IOException e2) {
            c.e("Could not process directory while scanning installed packs. %s", e2);
        }
        if (J().exists() && J().listFiles() != null) {
            for (File file : J().listFiles()) {
                if (!file.getCanonicalPath().equals(H().getCanonicalPath())) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    private final File H() {
        return new File(J(), "_tmp");
    }

    private final File I(String str, int i2, long j2) {
        return new File(new File(new File(H(), str), String.valueOf(i2)), String.valueOf(j2));
    }

    private final File J() {
        return new File(this.a.getFilesDir(), "assetpacks");
    }

    private final File a(String str, int i2) {
        return new File(E(str), String.valueOf(i2));
    }

    private static void e(File file) {
        File[] listFiles;
        if (file.listFiles() == null || file.listFiles().length <= 1) {
            return;
        }
        long i2 = i(file);
        for (File file2 : file.listFiles()) {
            if (!file2.getName().equals(String.valueOf(i2)) && !file2.getName().equals("stale.tmp")) {
                r(file2);
            }
        }
    }

    private static long i(File file) {
        File[] listFiles;
        if (file.exists()) {
            ArrayList arrayList = new ArrayList();
            try {
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().equals("stale.tmp")) {
                        arrayList.add(Long.valueOf(file2.getName()));
                    }
                }
            } catch (NumberFormatException e2) {
                c.d(e2, "Corrupt asset pack directories.", new Object[0]);
            }
            if (arrayList.isEmpty()) {
                return -1L;
            }
            Collections.sort(arrayList);
            return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
        }
        return -1L;
    }

    private static boolean r(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File file2 : listFiles) {
                z &= r(file2);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long A(String str) {
        return i(a(str, w(str)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File B(String str, int i2, long j2, String str2) {
        return new File(x(str, i2, j2), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C() {
        r(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(String str, int i2, long j2) {
        if (I(str, i2, j2).exists()) {
            r(I(str, i2, j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File b(String str, int i2, long j2) {
        return new File(a(str, i2), String.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File c(String str, int i2, long j2, String str2) {
        return new File(new File(new File(I(str, i2, j2), "_slices"), "_unverified"), str2);
    }

    final Map<String, a> d() {
        HashMap hashMap = new HashMap();
        try {
            for (File file : G()) {
                a j2 = j(file.getName());
                if (j2 != null) {
                    hashMap.put(file.getName(), j2);
                }
            }
        } catch (IOException e2) {
            c.e("Could not process directory while scanning installed packs: %s", e2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(String str, int i2, long j2, int i3) throws IOException {
        File F = F(str, i2, j2);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i3));
        F.getParentFile().mkdirs();
        F.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(F);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(List<String> list) {
        int a = this.b.a();
        List<File> G = G();
        int size = G.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = G.get(i2);
            if (!list.contains(file.getName()) && i(file) != a) {
                r(file);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(String str) {
        return p(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final a j(String str) throws IOException {
        String p = p(str);
        if (p == null) {
            return null;
        }
        File file = new File(p, "assets");
        if (file.isDirectory()) {
            return a.b(p, file.getCanonicalPath());
        }
        c.e("Failed to find assets directory: %s", file);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File k(String str, int i2, long j2) {
        return new File(b(str, i2, j2), "_metadata");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File l(String str, int i2, long j2, String str2) {
        return new File(new File(new File(I(str, i2, j2), "_slices"), "_verified"), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, Long> m() {
        HashMap hashMap = new HashMap();
        for (String str : d().keySet()) {
            hashMap.put(str, Long.valueOf(A(str)));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File n(String str, int i2, long j2) {
        return new File(I(str, i2, j2), "_packs");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File o(String str, int i2, long j2, String str2) {
        return new File(B(str, i2, j2, str2), "checkpoint.dat");
    }

    @Nullable
    final String p(String str) throws IOException {
        int length;
        File file = new File(J(), str);
        if (!file.exists()) {
            c.c("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.b.a()));
        if (!file2.exists()) {
            c.c("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            c.c("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        } else if (length > 1) {
            c.e("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        } else {
            return listFiles[0].getCanonicalPath();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() {
        List<File> G = G();
        int size = G.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = G.get(i2);
            if (file.listFiles() != null) {
                e(file);
                long i3 = i(file);
                if (this.b.a() != i3) {
                    try {
                        new File(new File(file, String.valueOf(i3)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        c.e("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File file2 : file.listFiles()) {
                    e(file2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int s(String str, int i2, long j2) throws IOException {
        File F = F(str, i2, j2);
        if (F.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(F);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("numberOfMerges") != null) {
                    try {
                        return Integer.parseInt(properties.getProperty("numberOfMerges"));
                    } catch (NumberFormatException e2) {
                        throw new bv("Merge checkpoint file corrupt.", e2);
                    }
                }
                throw new bv("Merge checkpoint file corrupt.");
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    com.google.android.play.core.internal.j1.a(th, th2);
                }
                throw th;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File t(String str, int i2, long j2, String str2) {
        return new File(B(str, i2, j2, str2), "checkpoint_ext.dat");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u() {
        File[] listFiles;
        List<File> G = G();
        int size = G.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = G.get(i2);
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > f4754e) {
                        r(file2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v(String str) {
        if (E(str).exists()) {
            return r(E(str));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int w(String str) {
        return (int) i(E(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File x(String str, int i2, long j2) {
        return new File(new File(I(str, i2, j2), "_slices"), "_metadata");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File y(String str, int i2, long j2, String str2) {
        return new File(B(str, i2, j2, str2), "slice.zip");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z() {
        File[] listFiles;
        if (H().exists()) {
            for (File file : H().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f4753d) {
                    r(file);
                } else {
                    e(file);
                }
            }
        }
    }
}
