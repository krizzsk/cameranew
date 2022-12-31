package com.google.android.play.core.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
final class j0 implements x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 c() {
        return new g0();
    }

    public static void d(ClassLoader classLoader, Set<File> set, i0 i0Var) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file : set) {
            hashSet.add(file.getParentFile());
        }
        Object d2 = e0.d(classLoader);
        s0 a = t0.a(d2, "nativeLibraryDirectories", List.class);
        synchronized (com.google.android.play.core.splitinstall.c0.class) {
            ArrayList arrayList = new ArrayList((Collection) a.a());
            hashSet.removeAll(arrayList);
            arrayList.addAll(hashSet);
            a.b(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Object[] a2 = i0Var.a(d2, new ArrayList(hashSet), arrayList2);
        if (arrayList2.isEmpty()) {
            synchronized (com.google.android.play.core.splitinstall.c0.class) {
                t0.o(d2, "nativeLibraryPathElements", Object.class).e(Arrays.asList(a2));
            }
            return;
        }
        bo boVar = new bo("Error in makePathElements");
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            j1.a(boVar, arrayList2.get(i2));
        }
        throw boVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i0 e() {
        return new h0();
    }

    public static boolean f(ClassLoader classLoader, File file, File file2, boolean z) {
        return e0.e(classLoader, file, file2, z, c(), "zip", e0.f());
    }

    @Override // com.google.android.play.core.internal.x
    public final void a(ClassLoader classLoader, Set<File> set) {
        d(classLoader, set, e());
    }

    @Override // com.google.android.play.core.internal.x
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return f(classLoader, file, file2, z);
    }
}
