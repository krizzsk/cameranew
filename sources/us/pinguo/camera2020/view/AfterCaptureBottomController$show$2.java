package us.pinguo.camera2020.view;

import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import us.pinguo.ad.RewardVipAdController;
import us.pinguo.camera2020.widget.ShutterButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AfterCaptureBottomController.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureBottomController$show$2 extends Lambda implements kotlin.jvm.b.l<View, kotlin.u> {
    final /* synthetic */ AfterCaptureBottomController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AfterCaptureBottomController.kt */
    /* renamed from: us.pinguo.camera2020.view.AfterCaptureBottomController$show$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        final /* synthetic */ AfterCaptureBottomController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AfterCaptureBottomController afterCaptureBottomController) {
            super(0);
            this.this$0 = afterCaptureBottomController;
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.a.A(true);
            this.this$0.a.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureBottomController$show$2(AfterCaptureBottomController afterCaptureBottomController) {
        super(1);
        this.this$0 = afterCaptureBottomController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(View view) {
        invoke2(view);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        ShutterButton shutterButton;
        RewardVipAdController rewardVipAdController;
        RewardVipAdController rewardVipAdController2;
        kotlin.jvm.internal.s.h(it, "it");
        if (this.this$0.u() && !us.pinguo.foundation.utils.j.a(1000L)) {
            kotlin.jvm.b.a<kotlin.u> r = this.this$0.r();
            if (r != null) {
                r.invoke();
            }
            boolean z = true;
            if (us.pinguo.repository2020.abtest.i.a.b()) {
                if ((!us.pinguo.camera2020.i.a.a.f() || us.pinguo.vip.proxy.b.b(us.pinguo.vip.proxy.b.a, false, 1, null) || this.this$0.a.g()) ? false : false) {
                    rewardVipAdController = this.this$0.f9267d;
                    if (rewardVipAdController != null) {
                        rewardVipAdController.g(new AnonymousClass1(this.this$0));
                    }
                    rewardVipAdController2 = this.this$0.f9267d;
                    if (rewardVipAdController2 == null) {
                        return;
                    }
                    rewardVipAdController2.h();
                    return;
                }
            } else {
                kotlin.jvm.b.a<ArrayList<String>> o = this.this$0.o();
                ArrayList<String> invoke = o != null ? o.invoke() : null;
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("camera_stat_attr_subscription", invoke);
                us.pinguo.camera2020.i.a aVar = us.pinguo.camera2020.i.a.a;
                shutterButton = this.this$0.f9268e;
                if (aVar.g(shutterButton.getContext(), bundle)) {
                    if (invoke == null) {
                        return;
                    }
                    us.pinguo.foundation.statistics.h.b.p(invoke.get(0), "preview_share", invoke.get(1), invoke.get(2), invoke.get(3), invoke.get(4), invoke.get(5), invoke.get(6), invoke.get(7));
                    return;
                }
            }
            this.this$0.a.K();
        }
    }
}
