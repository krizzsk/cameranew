package us.pinguo.camera2020.view;

import androidx.databinding.ObservableField;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.StyleMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBeautyController.kt */
/* loaded from: classes3.dex */
public final class CameraBeautyController$downStyleMakeup$1 extends Lambda implements kotlin.jvm.b.q<Boolean, MaterialDetail, String, kotlin.u> {
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ CameraBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraBeautyController.kt */
    /* renamed from: us.pinguo.camera2020.view.CameraBeautyController$downStyleMakeup$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
        final /* synthetic */ StyleMakeup $styleMakeup;
        final /* synthetic */ CameraBeautyController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CameraBeautyController cameraBeautyController, StyleMakeup styleMakeup) {
            super(1);
            this.this$0 = cameraBeautyController;
            this.$styleMakeup = styleMakeup;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(boolean z) {
            CameraBeautyModule cameraBeautyModule;
            if (z) {
                cameraBeautyModule = this.this$0.b;
                cameraBeautyModule.C().setValue(this.$styleMakeup);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBeautyController$downStyleMakeup$1(StyleMakeup styleMakeup, CameraBeautyController cameraBeautyController) {
        super(3);
        this.$styleMakeup = styleMakeup;
        this.this$0 = cameraBeautyController;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, MaterialDetail materialDetail, String str) {
        invoke(bool.booleanValue(), materialDetail, str);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, MaterialDetail materialDetail, String message) {
        StyleMakeup styleMakeup;
        CameraBeautyModule cameraBeautyModule;
        kotlin.jvm.internal.s.h(message, "message");
        if (z) {
            us.pinguo.foundation.statistics.h.b.r0("camera_page", this.$styleMakeup.getPid(), "download_success");
            styleMakeup = this.this$0.t;
            if (kotlin.jvm.internal.s.c(styleMakeup, this.$styleMakeup)) {
                cameraBeautyModule = this.this$0.b;
                StyleMakeup styleMakeup2 = this.$styleMakeup;
                cameraBeautyModule.l0(styleMakeup2, new AnonymousClass1(this.this$0, styleMakeup2));
                return;
            }
            return;
        }
        if (message.length() > 0) {
            us.pinguo.foundation.utils.k0.a.b(message);
        }
        ObservableField<MaterialInstallState> installState = this.$styleMakeup.getInstallState();
        if (installState == null) {
            return;
        }
        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
    }
}
