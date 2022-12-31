package us.pinguo.common.widget.banner2;

import android.view.View;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
public final class BaseBannerAdapter$mOnItemChildClickListenerProxy$1 extends Lambda implements q<BaseBannerAdapter<? extends Object>, View, Integer, u> {
    final /* synthetic */ BaseBannerAdapter<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBannerAdapter$mOnItemChildClickListenerProxy$1(BaseBannerAdapter<T> baseBannerAdapter) {
        super(3);
        this.this$0 = baseBannerAdapter;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(BaseBannerAdapter<? extends Object> baseBannerAdapter, View view, Integer num) {
        invoke(baseBannerAdapter, view, num.intValue());
        return u.a;
    }

    public final void invoke(BaseBannerAdapter<? extends Object> adapter, View v, int i2) {
        q qVar;
        q qVar2;
        s.h(adapter, "adapter");
        s.h(v, "v");
        qVar = ((BaseBannerAdapter) this.this$0).f9995g;
        if (qVar != null) {
            qVar2 = ((BaseBannerAdapter) this.this$0).f9995g;
            if (qVar2 != null) {
                qVar2.invoke(adapter, v, Integer.valueOf(i2));
            } else {
                s.z("mOnItemChildClickListener");
                throw null;
            }
        }
    }
}
