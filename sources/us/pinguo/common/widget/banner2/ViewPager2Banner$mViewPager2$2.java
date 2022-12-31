package us.pinguo.common.widget.banner2;

import android.content.Context;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Lambda;
/* compiled from: ViewPager2Banner.kt */
/* loaded from: classes4.dex */
final class ViewPager2Banner$mViewPager2$2 extends Lambda implements kotlin.jvm.b.a<ViewPager2> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Banner$mViewPager2$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewPager2 invoke() {
        return new ViewPager2(this.$context);
    }
}
