package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.s;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes.dex */
public final class d {
    static final c[] a;
    static final Map<com.bytedance.sdk.a.a.f, Integer> b;

    /* compiled from: Hpack.java */
    /* loaded from: classes.dex */
    static final class a {
        c[] a;
        int b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        int f953d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c> f954e;

        /* renamed from: f  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.e f955f;

        /* renamed from: g  reason: collision with root package name */
        private final int f956g;

        /* renamed from: h  reason: collision with root package name */
        private int f957h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i2, s sVar) {
            this(i2, i2, sVar);
        }

        private int a(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.a.length;
                while (true) {
                    length--;
                    i3 = this.b;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.a;
                    i2 -= cVarArr[length].f952i;
                    this.f953d -= cVarArr[length].f952i;
                    this.c--;
                    i4++;
                }
                c[] cVarArr2 = this.a;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i4, this.c);
                this.b += i4;
            }
            return i4;
        }

        private int c(int i2) {
            return this.b + 1 + i2;
        }

        private void d() {
            int i2 = this.f957h;
            int i3 = this.f953d;
            if (i2 < i3) {
                if (i2 == 0) {
                    e();
                } else {
                    a(i3 - i2);
                }
            }
        }

        private void e() {
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.f953d = 0;
        }

        private void f() throws IOException {
            this.f954e.add(new c(d.a(c()), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(c()), c()));
        }

        private int h() throws IOException {
            return this.f955f.h() & Draft_75.END_OF_FRAME;
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.f954e);
            this.f954e.clear();
            return arrayList;
        }

        a(int i2, int i3, s sVar) {
            this.f954e = new ArrayList();
            c[] cVarArr = new c[8];
            this.a = cVarArr;
            this.b = cVarArr.length - 1;
            this.c = 0;
            this.f953d = 0;
            this.f956g = i2;
            this.f957h = i3;
            this.f955f = com.bytedance.sdk.a.a.l.a(sVar);
        }

        com.bytedance.sdk.a.a.f c() throws IOException {
            int h2 = h();
            boolean z = (h2 & 128) == 128;
            int a = a(h2, 127);
            if (z) {
                return com.bytedance.sdk.a.a.f.a(k.a().a(this.f955f.g(a)));
            }
            return this.f955f.c(a);
        }

        private void b(int i2) throws IOException {
            if (g(i2)) {
                this.f954e.add(d.a[i2]);
                return;
            }
            int c = c(i2 - d.a.length);
            if (c >= 0) {
                c[] cVarArr = this.a;
                if (c <= cVarArr.length - 1) {
                    this.f954e.add(cVarArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void d(int i2) throws IOException {
            this.f954e.add(new c(f(i2), c()));
        }

        private com.bytedance.sdk.a.a.f f(int i2) {
            if (g(i2)) {
                return d.a[i2].f950g;
            }
            return this.a[c(i2 - d.a.length)].f950g;
        }

        private boolean g(int i2) {
            return i2 >= 0 && i2 <= d.a.length - 1;
        }

        private void e(int i2) throws IOException {
            a(-1, new c(f(i2), c()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.f955f.e()) {
                int h2 = this.f955f.h() & Draft_75.END_OF_FRAME;
                if (h2 == 128) {
                    throw new IOException("index == 0");
                }
                if ((h2 & 128) == 128) {
                    b(a(h2, 127) - 1);
                } else if (h2 == 64) {
                    g();
                } else if ((h2 & 64) == 64) {
                    e(a(h2, 63) - 1);
                } else if ((h2 & 32) == 32) {
                    int a = a(h2, 31);
                    this.f957h = a;
                    if (a >= 0 && a <= this.f956g) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f957h);
                    }
                } else if (h2 != 16 && h2 != 0) {
                    d(a(h2, 15) - 1);
                } else {
                    f();
                }
            }
        }

        private void a(int i2, c cVar) {
            this.f954e.add(cVar);
            int i3 = cVar.f952i;
            if (i2 != -1) {
                i3 -= this.a[c(i2)].f952i;
            }
            int i4 = this.f957h;
            if (i3 > i4) {
                e();
                return;
            }
            int a = a((this.f953d + i3) - i4);
            if (i2 == -1) {
                int i5 = this.c + 1;
                c[] cVarArr = this.a;
                if (i5 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.b = this.a.length - 1;
                    this.a = cVarArr2;
                }
                int i6 = this.b;
                this.b = i6 - 1;
                this.a[i6] = cVar;
                this.c++;
            } else {
                this.a[i2 + c(i2) + a] = cVar;
            }
            this.f953d += i3;
        }

        int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int h2 = h();
                if ((h2 & 128) == 0) {
                    return i3 + (h2 << i5);
                }
                i3 += (h2 & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* loaded from: classes.dex */
    static final class b {
        int a;
        int b;
        c[] c;

        /* renamed from: d  reason: collision with root package name */
        int f958d;

        /* renamed from: e  reason: collision with root package name */
        int f959e;

        /* renamed from: f  reason: collision with root package name */
        int f960f;

        /* renamed from: g  reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f961g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f962h;

        /* renamed from: i  reason: collision with root package name */
        private int f963i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f964j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.f958d = this.c.length - 1;
            this.f959e = 0;
            this.f960f = 0;
        }

        private int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i3 = this.f958d;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.c;
                    i2 -= cVarArr[length].f952i;
                    this.f960f -= cVarArr[length].f952i;
                    this.f959e--;
                    i4++;
                }
                c[] cVarArr2 = this.c;
                System.arraycopy(cVarArr2, i3 + 1, cVarArr2, i3 + 1 + i4, this.f959e);
                c[] cVarArr3 = this.c;
                int i5 = this.f958d;
                Arrays.fill(cVarArr3, i5 + 1, i5 + 1 + i4, (Object) null);
                this.f958d += i4;
            }
            return i4;
        }

        b(int i2, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.f963i = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.c = cVarArr;
            this.f958d = cVarArr.length - 1;
            this.f959e = 0;
            this.f960f = 0;
            this.a = i2;
            this.b = i2;
            this.f962h = z;
            this.f961g = cVar;
        }

        private void a(c cVar) {
            int i2 = cVar.f952i;
            int i3 = this.b;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.f960f + i2) - i3);
            int i4 = this.f959e + 1;
            c[] cVarArr = this.c;
            if (i4 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f958d = this.c.length - 1;
                this.c = cVarArr2;
            }
            int i5 = this.f958d;
            this.f958d = i5 - 1;
            this.c[i5] = cVar;
            this.f959e++;
            this.f960f += i2;
        }

        private void b() {
            int i2 = this.b;
            int i3 = this.f960f;
            if (i2 < i3) {
                if (i2 == 0) {
                    a();
                } else {
                    b(i3 - i2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i2;
            int i3;
            if (this.f964j) {
                int i4 = this.f963i;
                if (i4 < this.b) {
                    a(i4, 31, 32);
                }
                this.f964j = false;
                this.f963i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = list.get(i5);
                com.bytedance.sdk.a.a.f f2 = cVar.f950g.f();
                com.bytedance.sdk.a.a.f fVar = cVar.f951h;
                Integer num = d.b.get(f2);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        c[] cVarArr = d.a;
                        if (com.bytedance.sdk.a.b.a.c.a(cVarArr[i2 - 1].f951h, fVar)) {
                            i3 = i2;
                        } else if (com.bytedance.sdk.a.b.a.c.a(cVarArr[i2].f951h, fVar)) {
                            i3 = i2;
                            i2++;
                        }
                    }
                    i3 = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                if (i2 == -1) {
                    int i6 = this.f958d + 1;
                    int length = this.c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.c[i6].f950g, f2)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.c[i6].f951h, fVar)) {
                                i2 = d.a.length + (i6 - this.f958d);
                                break;
                            } else if (i3 == -1) {
                                i3 = (i6 - this.f958d) + d.a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else if (i3 == -1) {
                    this.f961g.i(64);
                    a(f2);
                    a(fVar);
                    a(cVar);
                } else if (f2.a(c.a) && !c.f949f.equals(f2)) {
                    a(i3, 15, 0);
                    a(fVar);
                } else {
                    a(i3, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f961g.i(i2 | i4);
                return;
            }
            this.f961g.i(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f961g.i(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f961g.i(i5);
        }

        void a(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.f962h && k.a().a(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.a().a(fVar, cVar);
                com.bytedance.sdk.a.a.f n = cVar.n();
                a(n.g(), 127, 128);
                this.f961g.a(n);
                return;
            }
            a(fVar.g(), 127, 0);
            this.f961g.a(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i2) {
            this.a = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.b;
            if (i3 == min) {
                return;
            }
            if (min < i3) {
                this.f963i = Math.min(this.f963i, min);
            }
            this.f964j = true;
            this.b = min;
            b();
        }
    }

    static {
        com.bytedance.sdk.a.a.f fVar = c.c;
        com.bytedance.sdk.a.a.f fVar2 = c.f947d;
        com.bytedance.sdk.a.a.f fVar3 = c.f948e;
        com.bytedance.sdk.a.a.f fVar4 = c.b;
        a = new c[]{new c(c.f949f, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, "/"), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c(AdvPrefUtil.COOKIE, ""), new c("date", ""), new c(BigAlbumStore.PhotoColumns.ETAG, ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(FirebaseAnalytics.Param.LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        b = a();
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i2 = 0;
        while (true) {
            c[] cVarArr = a;
            if (i2 < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i2].f950g)) {
                    linkedHashMap.put(cVarArr[i2].f950g, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static com.bytedance.sdk.a.a.f a(com.bytedance.sdk.a.a.f fVar) throws IOException {
        int g2 = fVar.g();
        for (int i2 = 0; i2 < g2; i2++) {
            byte a2 = fVar.a(i2);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
