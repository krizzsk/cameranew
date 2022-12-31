package us.pinguo.common.widget.banner2;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
/* compiled from: BannerSupport.kt */
/* loaded from: classes4.dex */
public final class c {
    private long a = 3000;
    private RecyclerView.Adapter<?> b;
    private RecyclerView.ItemDecoration c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager2.PageTransformer f10009d;

    /* renamed from: e  reason: collision with root package name */
    private int f10010e;

    public final RecyclerView.Adapter<?> a() {
        return this.b;
    }

    public final RecyclerView.ItemDecoration b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public final int d() {
        return this.f10010e;
    }

    public final ViewPager2.PageTransformer e() {
        return this.f10009d;
    }

    public final void f(RecyclerView.Adapter<?> adapter) {
        this.b = adapter;
    }

    public final void g(RecyclerView.ItemDecoration itemDecoration) {
        this.c = itemDecoration;
    }

    public final void h(long j2) {
        this.a = j2;
    }
}
