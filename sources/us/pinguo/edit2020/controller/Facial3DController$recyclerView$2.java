package us.pinguo.edit2020.controller;

import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Facial3DController.kt */
/* loaded from: classes4.dex */
public final class Facial3DController$recyclerView$2 extends Lambda implements kotlin.jvm.b.a<RecyclerView> {
    final /* synthetic */ Facial3DController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Facial3DController$recyclerView$2(Facial3DController facial3DController) {
        super(0);
        this.this$0 = facial3DController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final RecyclerView invoke() {
        FrameLayout frameLayout;
        frameLayout = this.this$0.b;
        return new RecyclerView(frameLayout.getContext());
    }
}
