package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.common.network.HttpRequest;
/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {
    public final y a;
    public final aa b;

    c(y yVar, aa aaVar) {
        this.a = yVar;
        this.b = aaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.j().d() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.bytedance.sdk.a.b.aa r3, com.bytedance.sdk.a.b.y r4) {
        /*
            int r0 = r3.c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L5a
            com.bytedance.sdk.a.b.d r0 = r3.j()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            com.bytedance.sdk.a.b.d r0 = r3.j()
            boolean r0 = r0.e()
            if (r0 != 0) goto L5a
            com.bytedance.sdk.a.b.d r0 = r3.j()
            boolean r0 = r0.d()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.bytedance.sdk.a.b.d r3 = r3.j()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.a.b.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.a.c.a(com.bytedance.sdk.a.b.aa, com.bytedance.sdk.a.b.y):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes.dex */
    public static class a {
        final long a;
        final y b;
        final aa c;

        /* renamed from: d  reason: collision with root package name */
        private Date f863d;

        /* renamed from: e  reason: collision with root package name */
        private String f864e;

        /* renamed from: f  reason: collision with root package name */
        private Date f865f;

        /* renamed from: g  reason: collision with root package name */
        private String f866g;

        /* renamed from: h  reason: collision with root package name */
        private Date f867h;

        /* renamed from: i  reason: collision with root package name */
        private long f868i;

        /* renamed from: j  reason: collision with root package name */
        private long f869j;

        /* renamed from: k  reason: collision with root package name */
        private String f870k;

        /* renamed from: l  reason: collision with root package name */
        private int f871l;

        public a(long j2, y yVar, aa aaVar) {
            this.f871l = -1;
            this.a = j2;
            this.b = yVar;
            this.c = aaVar;
            if (aaVar != null) {
                this.f868i = aaVar.k();
                this.f869j = aaVar.l();
                r f2 = aaVar.f();
                int a = f2.a();
                for (int i2 = 0; i2 < a; i2++) {
                    String a2 = f2.a(i2);
                    String b = f2.b(i2);
                    if (HttpRequest.HEADER_DATE.equalsIgnoreCase(a2)) {
                        this.f863d = com.bytedance.sdk.a.b.a.c.d.a(b);
                        this.f864e = b;
                    } else if (HttpRequest.HEADER_EXPIRES.equalsIgnoreCase(a2)) {
                        this.f867h = com.bytedance.sdk.a.b.a.c.d.a(b);
                    } else if (HttpRequest.HEADER_LAST_MODIFIED.equalsIgnoreCase(a2)) {
                        this.f865f = com.bytedance.sdk.a.b.a.c.d.a(b);
                        this.f866g = b;
                    } else if (HttpRequest.HEADER_ETAG.equalsIgnoreCase(a2)) {
                        this.f870k = b;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f871l = com.bytedance.sdk.a.b.a.c.e.b(b, -1);
                    }
                }
            }
        }

        private c b() {
            if (this.c == null) {
                return new c(this.b, null);
            }
            if (this.b.g() && this.c.e() == null) {
                return new c(this.b, null);
            }
            if (!c.a(this.c, this.b)) {
                return new c(this.b, null);
            }
            com.bytedance.sdk.a.b.d f2 = this.b.f();
            if (!f2.a() && !a(this.b)) {
                com.bytedance.sdk.a.b.d j2 = this.c.j();
                if (j2.j()) {
                    return new c(null, this.c);
                }
                long d2 = d();
                long c = c();
                if (f2.c() != -1) {
                    c = Math.min(c, TimeUnit.SECONDS.toMillis(f2.c()));
                }
                long j3 = 0;
                long millis = f2.h() != -1 ? TimeUnit.SECONDS.toMillis(f2.h()) : 0L;
                if (!j2.f() && f2.g() != -1) {
                    j3 = TimeUnit.SECONDS.toMillis(f2.g());
                }
                if (!j2.a()) {
                    long j4 = millis + d2;
                    if (j4 < j3 + c) {
                        aa.a h2 = this.c.h();
                        if (j4 >= c) {
                            h2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (d2 > AdvTimeUtils.MILLIS_OF_A_DAY && e()) {
                            h2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, h2.a());
                    }
                }
                String str = this.f870k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = HttpRequest.HEADER_IF_NONE_MATCH;
                } else if (this.f865f != null) {
                    str = this.f866g;
                } else if (this.f863d != null) {
                    str = this.f864e;
                } else {
                    return new c(this.b, null);
                }
                r.a b = this.b.c().b();
                com.bytedance.sdk.a.b.a.a.a.a(b, str2, str);
                return new c(this.b.e().a(b.a()).d(), this.c);
            }
            return new c(this.b, null);
        }

        private long c() {
            com.bytedance.sdk.a.b.d j2 = this.c.j();
            if (j2.c() != -1) {
                return TimeUnit.SECONDS.toMillis(j2.c());
            }
            if (this.f867h != null) {
                Date date = this.f863d;
                long time = this.f867h.getTime() - (date != null ? date.getTime() : this.f869j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f865f == null || this.c.a().a().k() != null) {
                return 0L;
            } else {
                Date date2 = this.f863d;
                long time2 = (date2 != null ? date2.getTime() : this.f868i) - this.f865f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private long d() {
            Date date = this.f863d;
            long max = date != null ? Math.max(0L, this.f869j - date.getTime()) : 0L;
            int i2 = this.f871l;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j2 = this.f869j;
            return max + (j2 - this.f868i) + (this.a - j2);
        }

        private boolean e() {
            return this.c.j().c() == -1 && this.f867h == null;
        }

        public c a() {
            c b = b();
            return (b.a == null || !this.b.f().i()) ? b : new c(null, null);
        }

        private static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a(HttpRequest.HEADER_IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
