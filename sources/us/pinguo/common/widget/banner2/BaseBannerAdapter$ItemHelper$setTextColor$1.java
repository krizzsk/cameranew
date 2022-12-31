package us.pinguo.common.widget.banner2;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
final class BaseBannerAdapter$ItemHelper$setTextColor$1 extends Lambda implements l<View, u> {
    final /* synthetic */ int $color;
    final /* synthetic */ int $viewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBannerAdapter$ItemHelper$setTextColor$1(int i2, int i3) {
        super(1);
        this.$color = i2;
        this.$viewId = i3;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(View view) {
        invoke2(view);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        s.h(it, "it");
        if (it instanceof TextView) {
            ((TextView) it).setTextColor(this.$color);
            return;
        }
        String resourceEntryName = it.getResources().getResourceEntryName(this.$viewId);
        throw new ClassCastException("id: R.id." + ((Object) resourceEntryName) + " are not TextView");
    }
}
