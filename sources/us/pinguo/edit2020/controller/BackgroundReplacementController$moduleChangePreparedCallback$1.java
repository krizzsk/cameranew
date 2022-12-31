package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.BackgroundReplacementController$moduleChangePreparedCallback$1;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.u3dengine.edit.EditModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$moduleChangePreparedCallback$1 extends Lambda implements kotlin.jvm.b.l<EditModel, kotlin.u> {
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementController.kt */
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$moduleChangePreparedCallback$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
        final /* synthetic */ BackgroundReplacementController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BackgroundReplacementController backgroundReplacementController) {
            super(1);
            this.this$0 = backgroundReplacementController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invoke$lambda-0  reason: not valid java name */
        public static final void m83invoke$lambda0(BackgroundReplacementController this$0, boolean z) {
            us.pinguo.edit2020.adapter.u uVar;
            TopSnackBar topSnackBar;
            us.pinguo.edit2020.view.c0 c0Var;
            TopSnackBar topSnackBar2;
            kotlin.jvm.internal.s.h(this$0, "this$0");
            BackgroundReplacementController.U0(this$0, false, false, 2, null);
            uVar = this$0.u;
            uVar.l(0);
            us.pinguo.edit2020.bean.f fVar = this$0.c.G().get(0);
            kotlin.jvm.internal.s.g(fVar, "module.autoMattingFunctions[0]");
            this$0.A0(0, fVar, false);
            if (z) {
                return;
            }
            topSnackBar = this$0.f10288i;
            topSnackBar.d(R.string.str_try_manual_matting);
            c0Var = this$0.f10289j;
            c0Var.s(us.pinguo.common.widget.i.a.a(10));
            topSnackBar2 = this$0.f10288i;
            topSnackBar2.setDismissListener(new BackgroundReplacementController$moduleChangePreparedCallback$1$2$1$1(this$0));
            this$0.q = Boolean.TRUE;
            this$0.z0();
            us.pinguo.foundation.statistics.h.b.Y("bg_uto_failed", "show");
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(final boolean z) {
            final BackgroundReplacementController backgroundReplacementController = this.this$0;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.a0
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundReplacementController$moduleChangePreparedCallback$1.AnonymousClass2.m83invoke$lambda0(BackgroundReplacementController.this, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$moduleChangePreparedCallback$1(BackgroundReplacementController backgroundReplacementController) {
        super(1);
        this.this$0 = backgroundReplacementController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m82invoke$lambda0(BackgroundReplacementController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BackgroundReplacementController.U0(this$0, true, false, 2, null);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(EditModel editModel) {
        invoke2(editModel);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EditModel model) {
        kotlin.jvm.internal.s.h(model, "model");
        if (model == EditModel.MagicBackground) {
            final BackgroundReplacementController backgroundReplacementController = this.this$0;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.b0
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundReplacementController$moduleChangePreparedCallback$1.m82invoke$lambda0(BackgroundReplacementController.this);
                }
            });
            this.this$0.c.b0(new AnonymousClass2(this.this$0));
        }
    }
}
