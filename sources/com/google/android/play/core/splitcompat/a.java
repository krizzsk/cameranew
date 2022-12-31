package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.play.core.internal.bo;
import com.google.android.play.core.internal.j1;
import com.google.android.play.core.internal.v;
import com.google.android.play.core.internal.w;
import com.google.android.play.core.internal.x;
import com.google.android.play.core.internal.y;
import com.google.android.play.core.splitinstall.g0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<a> f4871d = new AtomicReference<>(null);
    private final c a;
    private final Set<String> b = new HashSet();
    private final b c;

    private a(Context context) {
        try {
            c cVar = new c(context);
            this.a = cVar;
            this.c = new b(cVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new bo(e2);
        }
    }

    public static boolean b() {
        return f4871d.get() != null;
    }

    public static boolean c(Context context) {
        return d(context, true);
    }

    private static boolean d(Context context, boolean z) {
        if (g()) {
            return false;
        }
        AtomicReference<a> atomicReference = f4871d;
        boolean compareAndSet = atomicReference.compareAndSet(null, new a(context));
        a aVar = atomicReference.get();
        if (compareAndSet) {
            com.google.android.play.core.splitinstall.l lVar = com.google.android.play.core.splitinstall.l.a;
            Executor c = q.c();
            c cVar = aVar.a;
            lVar.a(new v(context, c, new w(context, cVar, new y(), null), cVar, new q()));
            g0.b(new m(aVar));
            q.c().execute(new n(context));
        }
        try {
            aVar.f(context, z);
            return true;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            return false;
        }
    }

    private final synchronized void f(Context context, boolean z) throws IOException {
        ZipFile zipFile;
        if (z) {
            this.a.e();
        } else {
            q.c().execute(new o(this));
        }
        String packageName = context.getPackageName();
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
            List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
            Set<r> l2 = this.a.l();
            HashSet hashSet = new HashSet();
            Iterator<r> it = l2.iterator();
            while (it.hasNext()) {
                String b = it.next().b();
                if (arrayList.contains(b)) {
                    if (z) {
                        this.a.r(b);
                    } else {
                        hashSet.add(b);
                    }
                    it.remove();
                }
            }
            if (!hashSet.isEmpty()) {
                q.c().execute(new p(this, hashSet));
            }
            HashSet hashSet2 = new HashSet();
            for (r rVar : l2) {
                String b2 = rVar.b();
                if (!com.google.android.play.core.splitinstall.p.d(b2)) {
                    hashSet2.add(b2);
                }
            }
            for (String str : arrayList) {
                if (!com.google.android.play.core.splitinstall.p.d(str)) {
                    hashSet2.add(str);
                }
            }
            HashSet<r> hashSet3 = new HashSet(l2.size());
            for (r rVar2 : l2) {
                if (!com.google.android.play.core.splitinstall.p.b(rVar2.b())) {
                    String b3 = rVar2.b();
                    if (hashSet2.contains(com.google.android.play.core.splitinstall.p.b(b3) ? "" : b3.split("\\.config\\.", 2)[0])) {
                    }
                }
                hashSet3.add(rVar2);
            }
            l lVar = new l(this.a);
            x a = y.a();
            ClassLoader classLoader = context.getClassLoader();
            if (z) {
                a.a(classLoader, lVar.a());
            } else {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    Set<File> c = lVar.c((r) it2.next());
                    if (c == null) {
                        it2.remove();
                    } else {
                        a.a(classLoader, c);
                    }
                }
            }
            HashSet hashSet4 = new HashSet();
            for (r rVar3 : hashSet3) {
                try {
                    zipFile = new ZipFile(rVar3.a());
                } catch (IOException e2) {
                    e = e2;
                    zipFile = null;
                }
                try {
                    ZipEntry entry = zipFile.getEntry("classes.dex");
                    zipFile.close();
                    if (entry != null && !a.b(classLoader, this.a.j(rVar3.b()), rVar3.a(), z)) {
                        String valueOf = String.valueOf(rVar3.a());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                        sb.append("split was not installed ");
                        sb.append(valueOf);
                        Log.w("SplitCompat", sb.toString());
                    }
                    hashSet4.add(rVar3.a());
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
            b.b(context, hashSet4);
            HashSet hashSet5 = new HashSet();
            for (r rVar4 : hashSet3) {
                if (hashSet4.contains(rVar4.a())) {
                    String b4 = rVar4.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 30);
                    sb2.append("Split '");
                    sb2.append(b4);
                    sb2.append("' installation emulated");
                    Log.d("SplitCompat", sb2.toString());
                    hashSet5.add(rVar4.b());
                } else {
                    String b5 = rVar4.b();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(b5).length() + 35);
                    sb3.append("Split '");
                    sb3.append(b5);
                    sb3.append("' installation not emulated.");
                    Log.d("SplitCompat", sb3.toString());
                }
            }
            synchronized (this.b) {
                this.b.addAll(hashSet5);
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e5);
        }
    }

    private static boolean g() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> h() {
        HashSet hashSet;
        synchronized (this.b) {
            hashSet = new HashSet(this.b);
        }
        return hashSet;
    }

    public static boolean i(@NonNull Context context) {
        return d(context, false);
    }

    public static boolean j(@NonNull Context context) {
        if (g()) {
            return false;
        }
        a aVar = f4871d.get();
        if (aVar != null) {
            return aVar.c.a(context, aVar.h());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
