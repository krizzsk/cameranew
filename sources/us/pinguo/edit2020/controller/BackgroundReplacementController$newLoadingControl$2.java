package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.loading.BgReplacementLoading;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$newLoadingControl$2 extends Lambda implements kotlin.jvm.b.a<BgReplacementLoading> {
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$newLoadingControl$2(BackgroundReplacementController backgroundReplacementController) {
        super(0);
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.jvm.b.a
    public final BgReplacementLoading invoke() {
        FrameLayout frameLayout;
        frameLayout = this.this$0.f10284e;
        Context context = frameLayout.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        BgReplacementLoading bgReplacementLoading = new BgReplacementLoading((Activity) context);
        bgReplacementLoading.g(this.this$0.b.A());
        return bgReplacementLoading;
    }
}
