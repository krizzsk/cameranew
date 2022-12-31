package us.pinguo.edit2020.controller;

import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$createFacialFeaturesView$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.r, kotlin.u> {
    final /* synthetic */ Ref$ObjectRef<View> $facialFeaturesView;
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$createFacialFeaturesView$1(EditBottomTabBeautyController editBottomTabBeautyController, Ref$ObjectRef<View> ref$ObjectRef) {
        super(2);
        this.this$0 = editBottomTabBeautyController;
        this.$facialFeaturesView = ref$ObjectRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.r rVar) {
        invoke(num.intValue(), rVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.r data) {
        kotlin.jvm.b.l lVar;
        String I0;
        int i3;
        kotlin.jvm.internal.s.h(data, "data");
        if (kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, data.f())) {
            String[] z = this.this$0.f10326e.z();
            i3 = this.this$0.w;
            String str = z[i3];
            ArrayList<us.pinguo.edit2020.bean.r> Q = this.this$0.f10326e.Q(str);
            if (Q == null) {
                return;
            }
            EditBottomTabBeautyController editBottomTabBeautyController = this.this$0;
            for (us.pinguo.edit2020.bean.r rVar : Q) {
                rVar.g().setCurrentValue(rVar.g().getDefaultValue());
                editBottomTabBeautyController.A0(rVar.g());
                editBottomTabBeautyController.j1(rVar.g().getDefaultValue());
            }
            this.this$0.A0(data.g());
            BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView = (BeautyAdjustFacialFeaturesView) this.$facialFeaturesView.element;
            ArrayList<us.pinguo.edit2020.bean.r> x = this.this$0.f10326e.x(str);
            if (x == null) {
                return;
            }
            beautyAdjustFacialFeaturesView.j(x, this.this$0.u);
            return;
        }
        this.this$0.u = i2;
        this.this$0.f10326e.p().setValue(data.g());
        lVar = this.this$0.G;
        if (lVar != null) {
            lVar.invoke(data);
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        I0 = this.this$0.I0();
        iVar.u(I0, data.f(), "click");
    }
}
