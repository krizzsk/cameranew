package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: BaseProducerContext.java */
/* loaded from: classes.dex */
public class d implements o0 {
    public static final Set<String> n = ImmutableSet.of((Object[]) new String[]{TapjoyAuctionFlags.AUCTION_ID, "uri_source"});
    private final ImageRequest a;
    private final String b;
    @Nullable
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final q0 f2884d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f2885e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageRequest.RequestLevel f2886f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, Object> f2887g;
    @GuardedBy("this")

    /* renamed from: h  reason: collision with root package name */
    private boolean f2888h;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    private Priority f2889i;
    @GuardedBy("this")

    /* renamed from: j  reason: collision with root package name */
    private boolean f2890j;
    @GuardedBy("this")

    /* renamed from: k  reason: collision with root package name */
    private boolean f2891k;
    @GuardedBy("this")

    /* renamed from: l  reason: collision with root package name */
    private final List<p0> f2892l;
    private final com.facebook.imagepipeline.core.j m;

    public d(ImageRequest imageRequest, String str, q0 q0Var, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, com.facebook.imagepipeline.core.j jVar) {
        this(imageRequest, str, null, q0Var, obj, requestLevel, z, z2, priority, jVar);
    }

    public static void p(@Nullable List<p0> list) {
        if (list == null) {
            return;
        }
        for (p0 p0Var : list) {
            p0Var.b();
        }
    }

    public static void q(@Nullable List<p0> list) {
        if (list == null) {
            return;
        }
        for (p0 p0Var : list) {
            p0Var.a();
        }
    }

    public static void r(@Nullable List<p0> list) {
        if (list == null) {
            return;
        }
        for (p0 p0Var : list) {
            p0Var.d();
        }
    }

    public static void s(@Nullable List<p0> list) {
        if (list == null) {
            return;
        }
        for (p0 p0Var : list) {
            p0Var.c();
        }
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public Object a() {
        return this.f2885e;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void b(String str, @Nullable Object obj) {
        if (n.contains(str)) {
            return;
        }
        this.f2887g.put(str, obj);
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void c(p0 p0Var) {
        boolean z;
        synchronized (this) {
            this.f2892l.add(p0Var);
            z = this.f2891k;
        }
        if (z) {
            p0Var.b();
        }
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public com.facebook.imagepipeline.core.j d() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void e(@Nullable String str, @Nullable String str2) {
        this.f2887g.put(FirebaseAnalytics.Param.ORIGIN, str);
        this.f2887g.put("origin_sub", str2);
    }

    @Override // com.facebook.imagepipeline.producers.o0
    @Nullable
    public String f() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void g(@Nullable String str) {
        e(str, IADStatisticBase.VARCHAR_DEFALUT_VALUE);
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public Map<String, Object> getExtras() {
        return this.f2887g;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public String getId() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public synchronized Priority getPriority() {
        return this.f2889i;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public q0 h() {
        return this.f2884d;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public synchronized boolean i() {
        return this.f2890j;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public ImageRequest j() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void k(EncodedImageOrigin encodedImageOrigin) {
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public void l(@Nullable Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public synchronized boolean m() {
        return this.f2888h;
    }

    @Override // com.facebook.imagepipeline.producers.o0
    @Nullable
    public <T> T n(String str) {
        return (T) this.f2887g.get(str);
    }

    @Override // com.facebook.imagepipeline.producers.o0
    public ImageRequest.RequestLevel o() {
        return this.f2886f;
    }

    public void t() {
        p(u());
    }

    @Nullable
    public synchronized List<p0> u() {
        if (this.f2891k) {
            return null;
        }
        this.f2891k = true;
        return new ArrayList(this.f2892l);
    }

    @Nullable
    public synchronized List<p0> v(boolean z) {
        if (z == this.f2890j) {
            return null;
        }
        this.f2890j = z;
        return new ArrayList(this.f2892l);
    }

    @Nullable
    public synchronized List<p0> w(boolean z) {
        if (z == this.f2888h) {
            return null;
        }
        this.f2888h = z;
        return new ArrayList(this.f2892l);
    }

    @Nullable
    public synchronized List<p0> x(Priority priority) {
        if (priority == this.f2889i) {
            return null;
        }
        this.f2889i = priority;
        return new ArrayList(this.f2892l);
    }

    public d(ImageRequest imageRequest, String str, @Nullable String str2, q0 q0Var, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, com.facebook.imagepipeline.core.j jVar) {
        EncodedImageOrigin encodedImageOrigin = EncodedImageOrigin.NOT_SET;
        this.a = imageRequest;
        this.b = str;
        HashMap hashMap = new HashMap();
        this.f2887g = hashMap;
        hashMap.put(TapjoyAuctionFlags.AUCTION_ID, str);
        hashMap.put("uri_source", imageRequest == null ? "null-request" : imageRequest.s());
        this.c = str2;
        this.f2884d = q0Var;
        this.f2885e = obj;
        this.f2886f = requestLevel;
        this.f2888h = z;
        this.f2889i = priority;
        this.f2890j = z2;
        this.f2891k = false;
        this.f2892l = new ArrayList();
        this.m = jVar;
    }
}
