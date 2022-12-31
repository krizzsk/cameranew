package us.pinguo.edit2020.controller;

import android.graphics.Color;
import kotlin.jvm.internal.Lambda;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.ui.widget.StickySeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$createSkinRefreshView$2 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.bean.n0, kotlin.u> {
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$createSkinRefreshView$2(EditBottomTabBeautyController editBottomTabBeautyController) {
        super(1);
        this.this$0 = editBottomTabBeautyController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.bean.n0 n0Var) {
        invoke2(n0Var);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.edit2020.bean.n0 it) {
        String str;
        String str2;
        String str3;
        kotlin.jvm.b.l lVar;
        kotlin.jvm.b.l lVar2;
        kotlin.jvm.b.l lVar3;
        String str4;
        kotlin.jvm.internal.s.h(it, "it");
        if (kotlin.jvm.internal.s.c(it.f(), "quban")) {
            this.this$0.c.G();
        } else {
            this.this$0.c.z(false);
            if (!this.this$0.c.l()) {
                this.this$0.c.x(true);
            }
        }
        str = this.this$0.z;
        if (kotlin.jvm.internal.s.c(str, it.f())) {
            this.this$0.c.y(StickySeekBar.DefaultDotStyle.NONE);
            us.pinguo.edit2020.view.c0 c0Var = this.this$0.c;
            str4 = this.this$0.L;
            c0Var.B(Color.parseColor(str4));
            this.this$0.E1(it);
            return;
        }
        String f2 = it.f();
        str2 = this.this$0.y;
        if (kotlin.jvm.internal.s.c(f2, str2)) {
            this.this$0.o1();
            this.this$0.f10326e.p().setValue(it.g());
            lVar3 = this.this$0.G;
            if (lVar3 != null) {
                lVar3.invoke(it);
            }
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            BeautyEditData value = this.this$0.f10326e.p().getValue();
            iVar.u0(value != null ? value.getBeautyKey() : null, "", "click");
            return;
        }
        if (!this.this$0.f10326e.S()) {
            if (it.g().getNeedFace()) {
                this.this$0.D1();
                lVar2 = this.this$0.G;
                if (lVar2 != null) {
                    lVar2.invoke(it);
                }
                us.pinguo.foundation.statistics.i iVar2 = us.pinguo.foundation.statistics.h.b;
                BeautyEditData value2 = this.this$0.f10326e.p().getValue();
                iVar2.u0(value2 != null ? value2.getBeautyKey() : null, "", "click");
                return;
            }
            this.this$0.L0(!kotlin.jvm.internal.s.c(it.g().getBeautyKey(), "quban"));
        }
        this.this$0.c.y(StickySeekBar.DefaultDotStyle.CIRCLE);
        us.pinguo.edit2020.view.c0 c0Var2 = this.this$0.c;
        str3 = this.this$0.L;
        c0Var2.B(Color.parseColor(str3));
        this.this$0.f10326e.p().setValue(it.g());
        lVar = this.this$0.G;
        if (lVar != null) {
            lVar.invoke(it);
        }
        us.pinguo.foundation.statistics.i iVar3 = us.pinguo.foundation.statistics.h.b;
        BeautyEditData value3 = this.this$0.f10326e.p().getValue();
        iVar3.u0(value3 != null ? value3.getBeautyKey() : null, "", "click");
    }
}
