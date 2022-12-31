package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.PointF;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.u3dengine.edit.BasicBrushMode;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$manualSkinErasingAdjustEnable$1 extends Lambda implements kotlin.jvm.b.l<Integer, kotlin.u> {
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$manualSkinErasingAdjustEnable$1(EditBottomTabBeautyController editBottomTabBeautyController) {
        super(1);
        this.this$0 = editBottomTabBeautyController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
        invoke(num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2) {
        this.this$0.f10326e.A0(i2);
        this.this$0.f10326e.n0(BasicBrushMode.Brush, this.this$0.f10326e.K().get(i2).floatValue());
        ConstraintLayout constraintLayout = this.this$0.b;
        int i3 = R.id.handShapeView;
        ((ShapeDirectionView) constraintLayout.findViewById(i3)).setIndicatorSize(this.this$0.f10326e.O());
        ((MagnifierView) ((MagnifierLayout) this.this$0.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView)).setSize(this.this$0.f10326e.O());
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        ((ShapeDirectionView) this.this$0.b.findViewById(i3)).m(new PointF(us.pinguo.util.h.i(b) / 2.0f, ((ShapeDirectionView) this.this$0.b.findViewById(i3)).getHeight() / 2.0f));
    }
}
