package us.pinguo.edit2020.controller;

import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$ivToggleMarkedArea$2 extends Lambda implements kotlin.jvm.b.a<AppCompatImageView> {
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$ivToggleMarkedArea$2(BackgroundReplacementController backgroundReplacementController) {
        super(0);
        this.this$0 = backgroundReplacementController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final AppCompatImageView invoke() {
        FrameLayout frameLayout;
        frameLayout = this.this$0.f10284e;
        AppCompatImageView appCompatImageView = new AppCompatImageView(frameLayout.getContext());
        int a = us.pinguo.common.widget.i.a.a(4);
        appCompatImageView.setImageResource(R.drawable.ic_toggle_marked_area_on);
        appCompatImageView.setPadding(a, a, a, a);
        return appCompatImageView;
    }
}
