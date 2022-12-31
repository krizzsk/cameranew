package us.pinguo.common.widget.banner2;

import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
final class BaseBannerAdapter$ItemHelper$setImageResource$1 extends Lambda implements l<View, u> {
    final /* synthetic */ int $resId;
    final /* synthetic */ int $viewId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBannerAdapter$ItemHelper$setImageResource$1(int i2, int i3) {
        super(1);
        this.$resId = i2;
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
        if (it instanceof ImageView) {
            ((ImageView) it).setImageResource(this.$resId);
            return;
        }
        String resourceEntryName = it.getResources().getResourceEntryName(this.$viewId);
        throw new ClassCastException("id: R.id." + ((Object) resourceEntryName) + " are not ImageView");
    }
}
