package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBackgroundBlurModule.kt */
/* loaded from: classes4.dex */
public final class EditBackgroundBlurModule$initBackgroundBlur$1 extends Lambda implements q<String, Boolean, String, u> {
    final /* synthetic */ l<Boolean, u> $callback;
    final /* synthetic */ EditBackgroundBlurModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditBackgroundBlurModule$initBackgroundBlur$1(EditBackgroundBlurModule editBackgroundBlurModule, l<? super Boolean, u> lVar) {
        super(3);
        this.this$0 = editBackgroundBlurModule;
        this.$callback = lVar;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(String str, Boolean bool, String str2) {
        invoke(str, bool.booleanValue(), str2);
        return u.a;
    }

    public final void invoke(String noName_0, boolean z, String maskFilePath) {
        s.h(noName_0, "$noName_0");
        s.h(maskFilePath, "maskFilePath");
        if (z) {
            this.this$0.y0(true);
        }
        this.this$0.o0(maskFilePath);
        this.this$0.n = maskFilePath;
        this.$callback.invoke(Boolean.valueOf(z));
    }
}
