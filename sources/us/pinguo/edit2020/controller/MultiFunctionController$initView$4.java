package us.pinguo.edit2020.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.SkinToneAdjustView;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiFunctionController.kt */
/* loaded from: classes4.dex */
public final class MultiFunctionController$initView$4 extends Lambda implements kotlin.jvm.b.q<Integer, Integer, us.pinguo.edit2020.bean.i, kotlin.u> {
    final /* synthetic */ MultiFunctionController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiFunctionController$initView$4(MultiFunctionController multiFunctionController) {
        super(3);
        this.this$0 = multiFunctionController;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, Integer num2, us.pinguo.edit2020.bean.i iVar) {
        invoke(num.intValue(), num2.intValue(), iVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, int i3, us.pinguo.edit2020.bean.i function) {
        int s;
        CenterLayoutManager centerLayoutManager;
        SkinToneAdjustView skinToneAdjustView;
        String[] strArr;
        int s2;
        String[] strArr2;
        SkinToneAdjustView skinToneAdjustView2;
        kotlin.jvm.internal.s.h(function, "function");
        int i4 = i2 - 1;
        if (i4 >= 0) {
            strArr2 = this.this$0.f10409e;
            if (strArr2 == null) {
                kotlin.jvm.internal.s.z("toggleSwitchArrays");
                throw null;
            }
            skinToneAdjustView2 = this.this$0.f10415k;
            if (skinToneAdjustView2 == null) {
                kotlin.jvm.internal.s.z("skinToneAdjustView");
                throw null;
            }
            strArr2[i4] = skinToneAdjustView2.g();
        }
        this.this$0.f10408d = i3;
        s = this.this$0.s();
        if (s >= 0) {
            skinToneAdjustView = this.this$0.f10415k;
            if (skinToneAdjustView == null) {
                kotlin.jvm.internal.s.z("skinToneAdjustView");
                throw null;
            }
            strArr = this.this$0.f10409e;
            if (strArr != null) {
                s2 = this.this$0.s();
                skinToneAdjustView.q(strArr[s2]);
                function = this.this$0.r();
            } else {
                kotlin.jvm.internal.s.z("toggleSwitchArrays");
                throw null;
            }
        }
        this.this$0.t(i3, function);
        centerLayoutManager = this.this$0.f10410f;
        if (centerLayoutManager == null) {
            kotlin.jvm.internal.s.z("centerLayoutManager");
            throw null;
        }
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        centerLayoutManager.b(b, i3, 100.0f);
    }
}
