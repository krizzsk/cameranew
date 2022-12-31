package us.pinguo.camera2020.module.beauty;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.StyleMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBeautyModule.kt */
/* loaded from: classes3.dex */
public final class CameraBeautyModule$flingStyleMakeup$1 extends Lambda implements l<Boolean, u> {
    final /* synthetic */ Boolean $left;
    final /* synthetic */ StyleMakeup $nextSelectedStyleMakeup;
    final /* synthetic */ int $restCount;
    final /* synthetic */ CameraBeautyModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBeautyModule$flingStyleMakeup$1(Boolean bool, int i2, CameraBeautyModule cameraBeautyModule, StyleMakeup styleMakeup) {
        super(1);
        this.$left = bool;
        this.$restCount = i2;
        this.this$0 = cameraBeautyModule;
        this.$nextSelectedStyleMakeup = styleMakeup;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return u.a;
    }

    public final void invoke(boolean z) {
        int i2;
        if (!z) {
            Boolean bool = this.$left;
            if (bool == null || (i2 = this.$restCount) <= 0) {
                return;
            }
            this.this$0.s(bool, i2 - 1);
        } else if (s.c(this.this$0.C().getValue(), this.$nextSelectedStyleMakeup)) {
        } else {
            this.this$0.C().setValue(this.$nextSelectedStyleMakeup);
        }
    }
}
