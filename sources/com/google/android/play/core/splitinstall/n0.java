package com.google.android.play.core.splitinstall;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n0 implements a {
    private final av a;
    private final k0 b;
    private final p c;

    /* renamed from: d  reason: collision with root package name */
    private final q f4907d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f4908e = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(av avVar, k0 k0Var, p pVar, q qVar) {
        this.a = avVar;
        this.b = k0Var;
        this.c = pVar;
        this.f4907d = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> f(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale locale : list) {
            if (Build.VERSION.SDK_INT >= 21) {
                arrayList.add(locale.toLanguageTag());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r2.containsAll(r3) != false) goto L19;
     */
    @Override // com.google.android.play.core.splitinstall.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.play.core.tasks.d<java.lang.Integer> a(com.google.android.play.core.splitinstall.c r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.a()
            boolean r0 = r0.isEmpty()
            r1 = 21
            if (r0 != 0) goto L1c
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L11
            goto L1c
        L11:
            com.google.android.play.core.splitinstall.SplitInstallException r6 = new com.google.android.play.core.splitinstall.SplitInstallException
            r0 = -5
            r6.<init>(r0)
            com.google.android.play.core.tasks.d r6 = com.google.android.play.core.tasks.f.a(r6)
            return r6
        L1c:
            java.util.List r0 = r6.a()
            com.google.android.play.core.splitinstall.p r2 = r5.c
            java.util.Set r2 = r2.c()
            if (r2 != 0) goto L29
            goto L4c
        L29:
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L32:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L46
            java.lang.Object r4 = r0.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r4 = r4.getLanguage()
            r3.add(r4)
            goto L32
        L46:
            boolean r0 = r2.containsAll(r3)
            if (r0 == 0) goto L82
        L4c:
            java.util.List r0 = r6.b()
            java.util.Set r2 = r5.b()
            boolean r0 = r2.containsAll(r0)
            if (r0 == 0) goto L82
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L6e
            java.util.List r0 = r6.b()
            com.google.android.play.core.splitinstall.q r1 = r5.f4907d
            java.util.Set r1 = r1.a()
            boolean r0 = java.util.Collections.disjoint(r0, r1)
            if (r0 == 0) goto L82
        L6e:
            android.os.Handler r0 = r5.f4908e
            com.google.android.play.core.splitinstall.m0 r1 = new com.google.android.play.core.splitinstall.m0
            r1.<init>(r5, r6)
            r0.post(r1)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.google.android.play.core.tasks.d r6 = com.google.android.play.core.tasks.f.b(r6)
            return r6
        L82:
            com.google.android.play.core.splitinstall.av r0 = r5.a
            java.util.List r1 = r6.b()
            java.util.List r6 = r6.a()
            java.util.List r6 = f(r6)
            com.google.android.play.core.tasks.d r6 = r0.a(r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.n0.a(com.google.android.play.core.splitinstall.c):com.google.android.play.core.tasks.d");
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final Set<String> b() {
        return this.c.a();
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final synchronized void c(e eVar) {
        this.b.b(eVar);
    }
}
