package us.pinguo.edit2020.controller;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$requestBokehIconTextureWithCurrentBokehValue$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$requestBokehIconTextureWithCurrentBokehValue$1(BackgroundBlurController backgroundBlurController) {
        super(0);
        this.this$0 = backgroundBlurController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m80invoke$lambda0(BackgroundBlurController this$0) {
        us.pinguo.edit2020.adapter.t tVar;
        View view;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.m0();
        tVar = this$0.f10279i;
        tVar.i(this$0.c.C());
        view = this$0.f10278h;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(R.id.rvBackgroundBlur)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final BackgroundBlurController backgroundBlurController = this.this$0;
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.r
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundBlurController$requestBokehIconTextureWithCurrentBokehValue$1.m80invoke$lambda0(BackgroundBlurController.this);
            }
        });
    }
}
