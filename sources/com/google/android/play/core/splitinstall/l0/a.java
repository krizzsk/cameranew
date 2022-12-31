package com.google.android.play.core.splitinstall.l0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.bx;
import com.google.android.play.core.internal.y;
import com.google.android.play.core.splitcompat.q;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.splitinstall.w;
import com.google.android.play.core.splitinstall.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class a implements com.google.android.play.core.splitinstall.a {
    private static final long m = TimeUnit.SECONDS.toMillis(1);
    public static final /* synthetic */ int n = 0;
    private final Handler a;
    private final Context b;
    private final p c;

    /* renamed from: d  reason: collision with root package name */
    private final bx f4887d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.core.internal.i<com.google.android.play.core.splitinstall.d> f4888e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f4889f;

    /* renamed from: g  reason: collision with root package name */
    private final w f4890g;

    /* renamed from: h  reason: collision with root package name */
    private final File f4891h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<com.google.android.play.core.splitinstall.d> f4892i;

    /* renamed from: j  reason: collision with root package name */
    private final Set<String> f4893j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<String> f4894k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicBoolean f4895l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, @Nullable File file, p pVar) {
        Executor c = q.c();
        bx bxVar = new bx(context);
        b bVar = b.a;
        this.a = new Handler(Looper.getMainLooper());
        this.f4892i = new AtomicReference<>();
        this.f4893j = Collections.synchronizedSet(new HashSet());
        this.f4894k = Collections.synchronizedSet(new HashSet());
        this.f4895l = new AtomicBoolean(false);
        this.b = context;
        this.f4891h = file;
        this.c = pVar;
        this.f4889f = c;
        this.f4887d = bxVar;
        this.f4888e = new com.google.android.play.core.internal.i<>();
        this.f4890g = l.a;
    }

    @Nullable
    private final synchronized com.google.android.play.core.splitinstall.d d(j jVar) {
        com.google.android.play.core.splitinstall.d u = u();
        com.google.android.play.core.splitinstall.d a = jVar.a(u);
        if (this.f4892i.compareAndSet(u, a)) {
            return a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ com.google.android.play.core.splitinstall.d e(Integer num, int i2, int i3, Long l2, Long l3, List list, List list2, com.google.android.play.core.splitinstall.d dVar) {
        com.google.android.play.core.splitinstall.d f2 = dVar == null ? com.google.android.play.core.splitinstall.d.f(0, 0, 0, 0L, 0L, new ArrayList(), new ArrayList()) : dVar;
        return com.google.android.play.core.splitinstall.d.f(num == null ? f2.l() : num.intValue(), i2, i3, l2 == null ? f2.d() : l2.longValue(), l3 == null ? f2.n() : l3.longValue(), list == null ? f2.j() : list, list2 == null ? f2.i() : list2);
    }

    private static String f(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        this.f4890g.a().a(list, new i(this, list2, list3, j2, z, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(int i2) {
        return q(6, i2, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(final int i2, final int i3, @Nullable final Long l2, @Nullable final Long l3, @Nullable final List<String> list, @Nullable final Integer num, @Nullable final List<String> list2) {
        com.google.android.play.core.splitinstall.d d2 = d(new j(num, i2, i3, l2, l3, list, list2) { // from class: com.google.android.play.core.splitinstall.l0.c
            private final Integer a;
            private final int b;
            private final int c;

            /* renamed from: d  reason: collision with root package name */
            private final Long f4896d;

            /* renamed from: e  reason: collision with root package name */
            private final Long f4897e;

            /* renamed from: f  reason: collision with root package name */
            private final List f4898f;

            /* renamed from: g  reason: collision with root package name */
            private final List f4899g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = num;
                this.b = i2;
                this.c = i3;
                this.f4896d = l2;
                this.f4897e = l3;
                this.f4898f = list;
                this.f4899g = list2;
            }

            @Override // com.google.android.play.core.splitinstall.l0.j
            public final com.google.android.play.core.splitinstall.d a(com.google.android.play.core.splitinstall.d dVar) {
                return a.e(this.a, this.b, this.c, this.f4896d, this.f4897e, this.f4898f, this.f4899g, dVar);
            }
        });
        if (d2 != null) {
            t(d2);
            return true;
        }
        return false;
    }

    static final /* synthetic */ void s() {
        SystemClock.sleep(m);
    }

    private final void t(final com.google.android.play.core.splitinstall.d dVar) {
        this.a.post(new Runnable(this, dVar) { // from class: com.google.android.play.core.splitinstall.l0.f
            private final a a;
            private final com.google.android.play.core.splitinstall.d b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(this.b);
            }
        });
    }

    @Nullable
    private final com.google.android.play.core.splitinstall.d u() {
        return this.f4892i.get();
    }

    private final z v() {
        z e2 = this.c.e();
        if (e2 != null) {
            return e2;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0133, code lost:
        if (r0.contains(r6) == false) goto L50;
     */
    @Override // com.google.android.play.core.splitinstall.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.play.core.tasks.d<java.lang.Integer> a(final com.google.android.play.core.splitinstall.c r22) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.l0.a.a(com.google.android.play.core.splitinstall.c):com.google.android.play.core.tasks.d");
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final Set<String> b() {
        return new HashSet(this.f4893j);
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void c(com.google.android.play.core.splitinstall.e eVar) {
        this.f4888e.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(final long j2, final List list, final List list2, final List list3) {
        long j3 = j2 / 3;
        long j4 = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            j4 = Math.min(j2, j4 + j3);
            q(2, 0, Long.valueOf(j4), Long.valueOf(j2), null, null, null);
            s();
            com.google.android.play.core.splitinstall.d u = u();
            if (u.m() == 9 || u.m() == 7 || u.m() == 6) {
                return;
            }
        }
        this.f4889f.execute(new Runnable(this, list, list2, list3, j2) { // from class: com.google.android.play.core.splitinstall.l0.h
            private final a a;
            private final List b;
            private final List c;

            /* renamed from: d  reason: collision with root package name */
            private final List f4902d;

            /* renamed from: e  reason: collision with root package name */
            private final long f4903e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = list;
                this.c = list2;
                this.f4902d = list3;
                this.f4903e = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(this.b, this.c, this.f4902d, this.f4903e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(com.google.android.play.core.splitinstall.d dVar) {
        this.f4888e.b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m(List list, final List list2) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = (File) list.get(i2);
            String b = y.b(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.b.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", f(b));
            intent.putExtra("split_id", b);
            arrayList.add(intent);
            arrayList2.add(f(y.b(file)));
        }
        com.google.android.play.core.splitinstall.d u = u();
        if (u == null) {
            return;
        }
        final long n2 = u.n();
        this.f4889f.execute(new Runnable(this, n2, arrayList, arrayList2, list2) { // from class: com.google.android.play.core.splitinstall.l0.g
            private final a a;
            private final long b;
            private final List c;

            /* renamed from: d  reason: collision with root package name */
            private final List f4900d;

            /* renamed from: e  reason: collision with root package name */
            private final List f4901e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = n2;
                this.c = arrayList;
                this.f4900d = arrayList2;
                this.f4901e = list2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(this.b, this.c, this.f4900d, this.f4901e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void n(List list, List list2, List list3, long j2) {
        if (this.f4895l.get()) {
            p(-6);
        } else {
            o(list, list2, list3, j2, false);
        }
    }
}
