package us.pinguo.camera2020.view;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.repository2020.entity.StyleMakeup;
/* compiled from: CameraBeautyController.kt */
/* loaded from: classes3.dex */
final class CameraBeautyController$onStyleMakeupItemClick$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ CameraBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBeautyController$onStyleMakeupItemClick$1(CameraBeautyController cameraBeautyController, StyleMakeup styleMakeup) {
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
