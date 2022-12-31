package us.pinguo.common.filter;

import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraFilterModule.kt */
/* loaded from: classes4.dex */
public final class CameraFilterModule$initSkyChange$1 extends Lambda implements r<String, Boolean, String, Integer, u> {
    final /* synthetic */ l<Boolean, u> $callback;
    final /* synthetic */ CameraFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CameraFilterModule$initSkyChange$1(CameraFilterModule cameraFilterModule, l<? super Boolean, u> lVar) {
        super(4);
        this.this$0 = cameraFilterModule;
        this.$callback = lVar;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ u invoke(String str, Boolean bool, String str2, Integer num) {
        invoke(str, bool.booleanValue(), str2, num.intValue());
        return u.a;
    }

    public final void invoke(String noName_0, boolean z, String maskFilePath, int i2) {
        s.h(noName_0, "$noName_0");
        s.h(maskFilePath, "maskFilePath");
        if (z) {
            this.this$0.k0(maskFilePath);
        }
        this.$callback.invoke(Boolean.valueOf(z));
    }
}
