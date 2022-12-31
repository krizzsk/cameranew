package us.pinguo.edit2020.controller;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashMap;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.cropindicator.CropDragView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropController.kt */
/* loaded from: classes4.dex */
public final class CropController$ivAngleRotation$2 extends Lambda implements kotlin.jvm.b.a<ImageView> {
    final /* synthetic */ CropController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropController$ivAngleRotation$2(CropController cropController) {
        super(0);
        this.this$0 = cropController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m86invoke$lambda1(CropController this$0, View view) {
        HashMap hashMap;
        HashMap hashMap2;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CropDragView.i(this$0.f10302e, false, 1, null);
        this$0.X();
        RectF m = this$0.f10302e.m();
        if (this$0.a.u()) {
            this$0.a.A(m.left, m.top, m.right, m.bottom);
        } else {
            this$0.a.B(m.left, m.top, m.right, m.bottom);
        }
        hashMap = this$0.t;
        String str = (String) hashMap.get("rotateHoriz");
        int parseInt = str == null ? -1 : Integer.parseInt(str);
        hashMap2 = this$0.t;
        hashMap2.put("rotateHoriz", String.valueOf(parseInt));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ImageView invoke() {
        ViewGroup viewGroup;
        int a = us.pinguo.common.widget.i.a.a(3);
        viewGroup = this.this$0.c;
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setImageResource(R.drawable.ic_angle_rotation);
        imageView.setBackgroundResource(R.drawable.ripple_common_oval_bg);
        imageView.setPadding(a, a, a, a);
        final CropController cropController = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CropController$ivAngleRotation$2.m86invoke$lambda1(CropController.this, view);
            }
        });
        return imageView;
    }
}
