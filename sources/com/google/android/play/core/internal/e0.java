package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
final class e0 implements x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 c() {
        return new z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(ClassLoader classLoader) {
        return t0.a(classLoader, "pathList", Object.class).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(ClassLoader classLoader, File file, File file2, boolean z, c0 c0Var, String str, b0 b0Var) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object d2 = d(classLoader);
        s0 o = t0.o(d2, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) o.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : asList) {
            arrayList2.add((File) t0.a(obj, str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (!z && !b0Var.a(d2, file2, file)) {
            String valueOf = String.valueOf(file2.getPath());
            Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
            return false;
        }
        o.c(Arrays.asList(c0Var.a(d2, new ArrayList<>(Collections.singleton(file2)), file, arrayList)));
        if (arrayList.isEmpty()) {
            return true;
        }
        bo boVar = new bo("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            IOException iOException = arrayList.get(i2);
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
            j1.a(boVar, iOException);
        }
        t0.o(d2, "dexElementsSuppressedExceptions", IOException.class).c(arrayList);
        throw boVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 f() {
        return new a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(ClassLoader classLoader, Set<File> set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file : set) {
            String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
            Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
            hashSet.add(file.getParentFile());
        }
        s0 o = t0.o(d(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[]) o.a()));
        synchronized (com.google.android.play.core.splitinstall.c0.class) {
            int size = hashSet.size();
            StringBuilder sb = new StringBuilder(30);
            sb.append("Adding directories ");
            sb.append(size);
            Log.d("Splitcompat", sb.toString());
            o.e(hashSet);
        }
    }

    @Override // com.google.android.play.core.internal.x
    public final void a(ClassLoader classLoader, Set<File> set) {
        g(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.x
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return e(classLoader, file, file2, z, c(), "zip", f());
    }
}
