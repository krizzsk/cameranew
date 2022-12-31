package us.pinguo.camera2020.module;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AfterCaptureModule.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureModule$saveToDb$1 extends Lambda implements l<String, u> {
    final /* synthetic */ boolean $isGotoEdit;
    final /* synthetic */ AfterCaptureModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureModule$saveToDb$1(boolean z, AfterCaptureModule afterCaptureModule) {
        super(1);
        this.$isGotoEdit = z;
        this.this$0 = afterCaptureModule;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(String str) {
        invoke2(str);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        if (this.$isGotoEdit) {
            return;
        }
        if (str == null) {
            this.this$0.u();
        } else {
            this.this$0.w(str);
        }
        l<String, u> j2 = this.this$0.j();
        if (j2 == null) {
            return;
        }
        j2.invoke(str);
    }
}
