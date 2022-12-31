package us.pinguo.edit2020.controller;

import androidx.databinding.ObservableField;
import kotlin.jvm.internal.Lambda;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.manager.MaterialInstallManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraffitiController.kt */
/* loaded from: classes4.dex */
public final class GraffitiController$downloadMaterial$1 extends Lambda implements kotlin.jvm.b.q<Boolean, PaintMaterial, String, kotlin.u> {
    final /* synthetic */ GraffitiController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GraffitiController.kt */
    /* renamed from: us.pinguo.edit2020.controller.GraffitiController$downloadMaterial$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.q<Boolean, PaintMaterial, String, kotlin.u> {
        final /* synthetic */ GraffitiController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GraffitiController graffitiController) {
            super(3);
            this.this$0 = graffitiController;
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, PaintMaterial paintMaterial, String str) {
            invoke(bool.booleanValue(), paintMaterial, str);
            return kotlin.u.a;
        }

        public final void invoke(boolean z, PaintMaterial paintMaterial, String message) {
            boolean m;
            kotlin.jvm.internal.s.h(paintMaterial, "paintMaterial");
            kotlin.jvm.internal.s.h(message, "message");
            if (z) {
                ObservableField<MaterialInstallState> installState = paintMaterial.getInstallState();
                if (installState != null) {
                    installState.set(MaterialInstallState.STATE_INSTALLED);
                }
                GraffitiController graffitiController = this.this$0;
                m = kotlin.collections.n.m(graffitiController.q, paintMaterial.getBrushSourceType());
                graffitiController.a0(paintMaterial, !m);
                return;
            }
            us.pinguo.foundation.utils.k0.a.b(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraffitiController$downloadMaterial$1(GraffitiController graffitiController) {
        super(3);
        this.this$0 = graffitiController;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, PaintMaterial paintMaterial, String str) {
        invoke(bool.booleanValue(), paintMaterial, str);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, PaintMaterial paintMaterial, String message) {
        kotlin.jvm.internal.s.h(paintMaterial, "paintMaterial");
        kotlin.jvm.internal.s.h(message, "message");
        if (z) {
            MaterialInstallManager.a.b(paintMaterial, new AnonymousClass1(this.this$0));
        } else {
            us.pinguo.foundation.utils.k0.a.b(message);
        }
    }
}
