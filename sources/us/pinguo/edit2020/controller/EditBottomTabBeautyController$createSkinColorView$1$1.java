package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.menuview.BeautySkinColorView;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.repository2020.entity.BeautyEditData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$createSkinColorView$1$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.bean.m0, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.view.c0 $opLayout;
    final /* synthetic */ BeautySkinColorView $this_with;
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$createSkinColorView$1$1(us.pinguo.edit2020.view.c0 c0Var, BeautySkinColorView beautySkinColorView, EditBottomTabBeautyController editBottomTabBeautyController) {
        super(1);
        this.$opLayout = c0Var;
        this.$this_with = beautySkinColorView;
        this.this$0 = editBottomTabBeautyController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.bean.m0 m0Var) {
        invoke2(m0Var);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.edit2020.bean.m0 function) {
        kotlin.jvm.b.l lVar;
        kotlin.jvm.internal.s.h(function, "function");
        if (kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, function.f())) {
            this.$opLayout.x(false);
            this.$this_with.setAllSkinColorValue(0);
            BeautyEditData value = this.this$0.f10326e.p().getValue();
            if (value != null && this.this$0.f10326e.U(value.getBeautyKey())) {
                value.setCurrentValue(0);
                this.this$0.f10326e.p().setValue(value);
            }
        } else {
            if (!this.$opLayout.l()) {
                this.$opLayout.x(true);
            }
            this.this$0.f10326e.p().setValue(function.g());
            lVar = this.this$0.G;
            if (lVar != null) {
                lVar.invoke(function);
            }
        }
        us.pinguo.foundation.statistics.h.b.u0("fuse", function.g().getBeautyKey(), "click");
    }
}
