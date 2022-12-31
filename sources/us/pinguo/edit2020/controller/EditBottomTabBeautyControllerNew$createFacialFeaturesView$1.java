package us.pinguo.edit2020.controller;

import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyControllerNew.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyControllerNew$createFacialFeaturesView$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.r, kotlin.u> {
    final /* synthetic */ Ref$ObjectRef<View> $facialFeaturesView;
    final /* synthetic */ EditBottomTabBeautyControllerNew this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyControllerNew$createFacialFeaturesView$1(EditBottomTabBeautyControllerNew editBottomTabBeautyControllerNew, Ref$ObjectRef<View> ref$ObjectRef) {
        super(2);
        this.this$0 = editBottomTabBeautyControllerNew;
        this.$facialFeaturesView = ref$ObjectRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.r rVar) {
        invoke(num.intValue(), rVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.r data) {
        kotlin.jvm.b.l lVar;
        int i3;
        kotlin.jvm.internal.s.h(data, "data");
        if (kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, data.f())) {
            String[] z = this.this$0.f10335e.z();
            i3 = this.this$0.u;
            String str = z[i3];
            ArrayList<us.pinguo.edit2020.bean.r> Q = this.this$0.f10335e.Q(str);
            if (us.pinguo.edit2020.utils.d.d(Q)) {
                kotlin.jvm.internal.s.e(Q);
                EditBottomTabBeautyControllerNew editBottomTabBeautyControllerNew = this.this$0;
                for (us.pinguo.edit2020.bean.r rVar : Q) {
                    rVar.g().setCurrentValue(rVar.g().getDefaultValue());
                    editBottomTabBeautyControllerNew.f10335e.p().setValue(rVar.g());
                    editBottomTabBeautyControllerNew.Z(rVar.g().getDefaultValue());
                }
                ArrayList<us.pinguo.edit2020.bean.r> x = this.this$0.f10335e.x(str);
                kotlin.jvm.internal.s.e(x);
                ((BeautyAdjustFacialFeaturesView) this.$facialFeaturesView.element).j(x, this.this$0.v);
                return;
            }
            return;
        }
        this.this$0.v = i2;
        this.this$0.f10335e.p().setValue(data.g());
        lVar = this.this$0.f10339i;
        if (lVar == null) {
            return;
        }
        lVar.invoke(data);
    }
}
