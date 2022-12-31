package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.Map;
/* compiled from: ClickListener.java */
/* loaded from: classes.dex */
public class b extends c {
    protected Context c;

    /* renamed from: d  reason: collision with root package name */
    protected final h f1503d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f1504e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f1505f;

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<View> f1506g;

    /* renamed from: h  reason: collision with root package name */
    protected WeakReference<View> f1507h;

    /* renamed from: i  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.d.d f1508i;

    /* renamed from: j  reason: collision with root package name */
    protected a f1509j;

    /* renamed from: k  reason: collision with root package name */
    protected TTNativeAd f1510k;

    /* renamed from: l  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.c f1511l;
    protected boolean m = false;
    protected d.a.a.a.a.a.b n;
    protected Map<String, Object> o;
    protected TTNativeExpressAd p;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;

    /* compiled from: ClickListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view, int i2);
    }

    public b(@NonNull Context context, @NonNull h hVar, @NonNull String str, int i2) {
        this.c = context;
        this.f1503d = hVar;
        this.f1504e = str;
        this.f1505f = i2;
    }

    public void a(d.a.a.a.a.a.b bVar) {
        this.n = bVar;
    }

    public void b(View view) {
        this.f1507h = new WeakReference<>(view);
    }

    public void d(boolean z) {
        this.m = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.q = aVar;
    }

    public void a(TTNativeAd tTNativeAd) {
        this.f1510k = tTNativeAd;
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        this.p = tTNativeExpressAd;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        this.f1511l = cVar;
    }

    public void a(a aVar) {
        this.f1509j = aVar;
    }

    public void a(View view) {
        this.f1506g = new WeakReference<>(view);
    }

    public void a(Map<String, Object> map) {
        this.o = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        h hVar;
        if (a(1)) {
            return;
        }
        if (this.c == null) {
            this.c = o.a();
        }
        if (this.c == null) {
            return;
        }
        long j2 = this.v;
        long j3 = this.w;
        WeakReference<View> weakReference = this.f1506g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f1507h;
        this.f1508i = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get());
        a aVar = this.f1509j;
        if (aVar != null) {
            aVar.a(view, -1);
        }
        boolean r = this.f1503d.r();
        boolean a2 = x.a(this.c, this.f1503d, this.f1505f, this.f1510k, this.p, r ? this.f1504e : ab.a(this.f1505f), this.n, r);
        if (a2 || (hVar = this.f1503d) == null || hVar.L() == null || this.f1503d.L().c() != 2) {
            if (!a2 && TextUtils.isEmpty(this.f1503d.A()) && "embeded_ad".equals(this.f1504e)) {
                d.a.a.a.a.a.c.a(this.c, this.f1503d, this.f1504e).a();
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.f1503d, this.f1508i, this.f1504e, a2, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.sdk.openadsdk.core.d.d a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2) {
        return new d.a().d(i2).c(i3).b(i4).a(i5).b(j2).a(j3).b(ac.a(view)).a(ac.a(view2)).c(ac.c(view)).d(ac.c(view2)).e(this.x).f(this.y).g(this.z).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i2) {
        if (this.q != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.f1507h;
            if (weakReference != null) {
                iArr = ac.a(weakReference.get());
                iArr2 = ac.c(this.f1507h.get());
            }
            this.q.a(i2, new f.a().d(this.r).c(this.s).b(this.t).a(this.u).b(this.v).a(this.w).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
            return true;
        }
        return false;
    }
}
