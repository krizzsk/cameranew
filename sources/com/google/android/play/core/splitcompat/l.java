package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.j1;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public final class l {
    private static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    public static final /* synthetic */ int c = 0;
    private final c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) throws IOException {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set b(l lVar, Set set, r rVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        lVar.f(rVar, set, new h(hashSet, rVar, zipFile));
        return hashSet;
    }

    private static void e(r rVar, i iVar) throws IOException {
        ZipFile zipFile;
        String[] strArr;
        String format;
        try {
            zipFile = new ZipFile(rVar.a());
        } catch (IOException e2) {
            e = e2;
            zipFile = null;
        }
        try {
            String b2 = rVar.b();
            HashMap hashMap = new HashMap();
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Matcher matcher = b.matcher(nextElement.getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", b2, group2, group));
                    Set set = (Set) hashMap.get(group);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(group, set);
                    }
                    set.add(new k(nextElement, group2));
                }
            }
            HashMap hashMap2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (hashMap.containsKey(str)) {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                    for (k kVar : (Set) hashMap.get(str)) {
                        if (hashMap2.containsKey(kVar.a)) {
                            format = String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", kVar.a, str);
                        } else {
                            hashMap2.put(kVar.a, kVar);
                            format = String.format("NativeLibraryExtractor: using library %s for ABI %s", kVar.a, str);
                        }
                        Log.d("SplitCompat", format);
                    }
                } else {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                }
            }
            iVar.a(zipFile, new HashSet(hashMap2.values()));
            zipFile.close();
        } catch (IOException e3) {
            e = e3;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    j1.a(e, e4);
                }
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(r rVar, Set<k> set, j jVar) throws IOException {
        for (k kVar : set) {
            File d2 = this.a.d(rVar.b(), kVar.a);
            boolean z = false;
            if (d2.exists() && d2.length() == kVar.b.getSize()) {
                z = true;
            }
            jVar.a(kVar, d2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<File> a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<r> l2 = this.a.l();
        for (String str : this.a.o()) {
            Iterator<r> it = l2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equals(str)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str));
                    this.a.n(str);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (r rVar : l2) {
            HashSet hashSet2 = new HashSet();
            e(rVar, new g(this, hashSet2, rVar));
            for (File file : this.a.p(rVar.b())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file.getAbsolutePath(), rVar.b(), rVar.a().getAbsolutePath()));
                    this.a.h(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Set<File> c(r rVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        e(rVar, new f(this, rVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
