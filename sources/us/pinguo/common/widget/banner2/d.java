package us.pinguo.common.widget.banner2;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BannerSupport.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final void a(ViewPager2Banner viewPager2Banner, l<? super c, u> config) {
        s.h(viewPager2Banner, "<this>");
        s.h(config, "config");
        c cVar = new c();
        config.invoke(cVar);
        viewPager2Banner.setOrientation(cVar.d());
        viewPager2Banner.setInterval(cVar.c());
        RecyclerView.Adapter<?> a = cVar.a();
        if (a != null) {
            viewPager2Banner.setAdapter(a);
        }
        ViewPager2.PageTransformer e2 = cVar.e();
        if (e2 != null) {
            viewPager2Banner.setPageTransformer(e2);
        }
        RecyclerView.ItemDecoration b = cVar.b();
        if (b == null) {
            return;
        }
        viewPager2Banner.h(b);
    }
}
