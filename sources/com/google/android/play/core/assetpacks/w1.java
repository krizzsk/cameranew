package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w1 {

    /* renamed from: g  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4818g = new com.google.android.play.core.internal.j("ExtractorSessionStoreView");
    private final k0 a;
    private final com.google.android.play.core.internal.k1<x3> b;
    private final f1 c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<Executor> f4819d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, t1> f4820e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f4821f = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(k0 k0Var, com.google.android.play.core.internal.k1<x3> k1Var, f1 f1Var, com.google.android.play.core.internal.k1<Executor> k1Var2) {
        this.a = k0Var;
        this.b = k1Var;
        this.c = f1Var;
        this.f4819d = k1Var2;
    }

    private final <T> T a(v1<T> v1Var) {
        try {
            c();
            return v1Var.a();
        } finally {
            h();
        }
    }

    private final Map<String, t1> q(final List<String> list) {
        return (Map) a(new v1(this, list) { // from class: com.google.android.play.core.assetpacks.m1
            private final w1 a;
            private final List b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = list;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                return this.a.n(this.b);
            }
        });
    }

    private final t1 s(int i2) {
        Map<Integer, t1> map = this.f4820e;
        Integer valueOf = Integer.valueOf(i2);
        t1 t1Var = map.get(valueOf);
        if (t1Var != null) {
            return t1Var;
        }
        throw new bv(String.format("Could not find session %d while trying to get it", valueOf), i2);
    }

    private static String t(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            throw new bv("Session without pack received.");
        }
        return stringArrayList.get(0);
    }

    private static <T> List<T> u(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, Integer> b(final List<String> list) {
        return (Map) a(new v1(this, list) { // from class: com.google.android.play.core.assetpacks.p1
            private final w1 a;
            private final List b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = list;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                return this.a.g(this.b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.f4821f.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(final int i2) {
        a(new v1(this, i2) { // from class: com.google.android.play.core.assetpacks.o1
            private final w1 a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = i2;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                this.a.o(this.b);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(final String str, final int i2, final long j2) {
        a(new v1(this, str, i2, j2) { // from class: com.google.android.play.core.assetpacks.l1
            private final w1 a;
            private final String b;
            private final int c;

            /* renamed from: d  reason: collision with root package name */
            private final long f4766d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = str;
                this.c = i2;
                this.f4766d = j2;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                this.a.j(this.b, this.c, this.f4766d);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(final Bundle bundle) {
        return ((Boolean) a(new v1(this, bundle) { // from class: com.google.android.play.core.assetpacks.j1
            private final w1 a;
            private final Bundle b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundle;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                return this.a.p(this.b);
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map g(List list) {
        int i2;
        Map<String, t1> q = q(list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            final t1 t1Var = q.get(str);
            if (t1Var == null) {
                i2 = 8;
            } else {
                if (j2.c(t1Var.c.c)) {
                    try {
                        t1Var.c.c = 6;
                        this.f4819d.a().execute(new Runnable(this, t1Var) { // from class: com.google.android.play.core.assetpacks.q1
                            private final w1 a;
                            private final t1 b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.a = this;
                                this.b = t1Var;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d(this.b.a);
                            }
                        });
                        this.c.b(str);
                    } catch (bv unused) {
                        f4818g.f("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(t1Var.a), str);
                    }
                }
                i2 = t1Var.c.c;
            }
            hashMap.put(str, Integer.valueOf(i2));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        this.f4821f.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(int i2) {
        s(i2).c.c = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(String str, int i2, long j2) {
        t1 t1Var = q(Arrays.asList(str)).get(str);
        if (t1Var == null || j2.f(t1Var.c.c)) {
            f4818g.e(String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        this.a.D(str, i2, j2);
        t1Var.c.c = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(final Bundle bundle) {
        return ((Boolean) a(new v1(this, bundle) { // from class: com.google.android.play.core.assetpacks.k1
            private final w1 a;
            private final Bundle b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundle;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                return this.a.l(this.b);
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean l(Bundle bundle) {
        int i2 = bundle.getInt(TapjoyConstants.TJC_SESSION_ID);
        if (i2 == 0) {
            return Boolean.TRUE;
        }
        Map<Integer, t1> map = this.f4820e;
        Integer valueOf = Integer.valueOf(i2);
        if (map.containsKey(valueOf)) {
            t1 t1Var = this.f4820e.get(valueOf);
            if (t1Var.c.c == 6) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(!j2.d(t1Var.c.c, bundle.getInt(com.google.android.play.core.internal.p1.f("status", t(bundle)))));
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, t1> m() {
        return this.f4820e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map n(List list) {
        HashMap hashMap = new HashMap();
        for (t1 t1Var : this.f4820e.values()) {
            String str = t1Var.c.a;
            if (list.contains(str)) {
                t1 t1Var2 = (t1) hashMap.get(str);
                if ((t1Var2 == null ? -1 : t1Var2.a) < t1Var.a) {
                    hashMap.put(str, t1Var);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void o(int i2) {
        t1 s = s(i2);
        if (!j2.f(s.c.c)) {
            throw new bv(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i2)), i2);
        }
        k0 k0Var = this.a;
        s1 s1Var = s.c;
        k0Var.D(s1Var.a, s.b, s1Var.b);
        s1 s1Var2 = s.c;
        int i3 = s1Var2.c;
        if (i3 == 5 || i3 == 6) {
            this.a.v(s1Var2.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean p(Bundle bundle) {
        u1 u1Var;
        int i2 = bundle.getInt(TapjoyConstants.TJC_SESSION_ID);
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        Map<Integer, t1> map = this.f4820e;
        Integer valueOf = Integer.valueOf(i2);
        boolean z = false;
        if (map.containsKey(valueOf)) {
            t1 s = s(i2);
            int i3 = bundle.getInt(com.google.android.play.core.internal.p1.f("status", s.c.a));
            if (j2.d(s.c.c, i3)) {
                f4818g.c("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(s.c.c));
                s1 s1Var = s.c;
                String str = s1Var.a;
                int i4 = s1Var.c;
                if (i4 == 4) {
                    this.b.a().a(i2, str);
                } else if (i4 == 5) {
                    this.b.a().a(i2);
                } else if (i4 == 6) {
                    this.b.a().a(Arrays.asList(str));
                }
            } else {
                s.c.c = i3;
                if (j2.f(i3)) {
                    d(i2);
                    this.c.b(s.c.a);
                } else {
                    List<u1> list = s.c.f4800e;
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        u1 u1Var2 = list.get(i5);
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(com.google.android.play.core.internal.p1.g("chunk_intents", s.c.a, u1Var2.a));
                        if (parcelableArrayList != null) {
                            for (int i6 = 0; i6 < parcelableArrayList.size(); i6++) {
                                if (parcelableArrayList.get(i6) != null && ((Intent) parcelableArrayList.get(i6)).getData() != null) {
                                    u1Var2.f4805d.get(i6).a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String t = t(bundle);
            long j2 = bundle.getLong(com.google.android.play.core.internal.p1.f("pack_version", t));
            int i7 = bundle.getInt(com.google.android.play.core.internal.p1.f("status", t));
            long j3 = bundle.getLong(com.google.android.play.core.internal.p1.f("total_bytes_to_download", t));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(com.google.android.play.core.internal.p1.f("slice_ids", t));
            ArrayList arrayList = new ArrayList();
            Iterator it = u(stringArrayList).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(com.google.android.play.core.internal.p1.g("chunk_intents", t, str2));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : u(parcelableArrayList2)) {
                    Iterator it2 = it;
                    if (intent != null) {
                        z = true;
                    }
                    arrayList2.add(new r1(z));
                    it = it2;
                    z = false;
                }
                Iterator it3 = it;
                String string = bundle.getString(com.google.android.play.core.internal.p1.g("uncompressed_hash_sha256", t, str2));
                long j4 = bundle.getLong(com.google.android.play.core.internal.p1.g("uncompressed_size", t, str2));
                int i8 = bundle.getInt(com.google.android.play.core.internal.p1.g("patch_format", t, str2), 0);
                if (i8 != 0) {
                    u1Var = new u1(str2, string, j4, arrayList2, 0, i8);
                    z = false;
                } else {
                    z = false;
                    u1Var = new u1(str2, string, j4, arrayList2, bundle.getInt(com.google.android.play.core.internal.p1.g("compression_format", t, str2), 0), 0);
                }
                arrayList.add(u1Var);
                it = it3;
            }
            this.f4820e.put(Integer.valueOf(i2), new t1(i2, bundle.getInt("app_version_code"), new s1(t, j2, i7, j3, arrayList)));
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(final int i2) {
        a(new v1(this, i2) { // from class: com.google.android.play.core.assetpacks.n1
            private final w1 a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = i2;
            }

            @Override // com.google.android.play.core.assetpacks.v1
            public final Object a() {
                this.a.i(this.b);
                return null;
            }
        });
    }
}
