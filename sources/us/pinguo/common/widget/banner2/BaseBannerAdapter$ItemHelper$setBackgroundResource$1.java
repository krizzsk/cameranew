package us.pinguo.common.widget.banner2;

import android.view.View;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
final class BaseBannerAdapter$ItemHelper$setBackgroundResource$1 extends Lambda implements l<View, u> {
    final /* synthetic */ int $resId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBannerAdapter$ItemHelper$setBackgroundResource$1(int i2) {
        super(1);
        this.$resId = i2;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(View view) {
        invoke2(view);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        s.h(it, "it");
        it.setBackgroundResource(this.$resId);
    }
}
