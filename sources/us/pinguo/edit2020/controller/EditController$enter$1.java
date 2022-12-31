package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.RectF;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditController.kt */
/* loaded from: classes4.dex */
public final class EditController$enter$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.model.editgoto.b $editGoto;
    final /* synthetic */ EditController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditController$enter$1(EditController editController, us.pinguo.edit2020.model.editgoto.b bVar) {
        super(0);
        this.this$0 = editController;
        this.$editGoto = bVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        i3 i3Var;
        us.pinguo.edit2020.view.c0 c0Var;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        i3 i3Var2;
        i3 i3Var3;
        kotlin.jvm.b.p pVar;
        i3 i3Var4;
        float f2;
        float f3;
        kotlin.jvm.b.p pVar2;
        i3 i3Var5;
        i3Var = this.this$0.f10351l;
        if (i3Var instanceof e3) {
            EditController editController = this.this$0;
            i3Var5 = editController.f10351l;
            Objects.requireNonNull(i3Var5, "null cannot be cast to non-null type us.pinguo.edit2020.controller.IGestureConsumer");
            editController.f10347h = (e3) i3Var5;
        }
        c0Var = this.this$0.c;
        c0Var.H(false);
        viewGroup = this.this$0.f10343d;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.flContainerSubItems);
        frameLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(frameLayout, 4);
        viewGroup2 = this.this$0.f10343d;
        TextView textView = (TextView) viewGroup2.findViewById(R.id.txtSave);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        i3Var2 = this.this$0.f10351l;
        if (i3Var2 != null) {
            i3Var2.u(this.$editGoto);
        }
        Size s = this.this$0.b.k().s();
        i3Var3 = this.this$0.f10351l;
        if (!(i3Var3 instanceof CropController) || s == null) {
            pVar = this.this$0.f10345f;
            pVar.invoke(null, null);
            return;
        }
        i3Var4 = this.this$0.f10351l;
        Objects.requireNonNull(i3Var4, "null cannot be cast to non-null type us.pinguo.edit2020.controller.CropController");
        RectF Z = ((CropController) i3Var4).Z();
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        int i2 = us.pinguo.util.h.i(b);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        int g2 = us.pinguo.util.h.g(b2);
        int height = s.getHeight() / s.getWidth();
        if (height < g2 / i2) {
            f2 = Z.right;
            f3 = Z.left;
        } else {
            f2 = Z.bottom;
            f3 = Z.top;
        }
        float f4 = f2 - f3;
        pVar2 = this.this$0.f10345f;
        pVar2.invoke(Float.valueOf(f4), Float.valueOf(f4));
    }
}
