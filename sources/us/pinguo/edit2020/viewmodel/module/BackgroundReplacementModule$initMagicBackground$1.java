package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementModule.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule$initMagicBackground$1 extends Lambda implements q<String, Boolean, String, u> {
    final /* synthetic */ l<Boolean, u> $callback;
    final /* synthetic */ BackgroundReplacementModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundReplacementModule$initMagicBackground$1(BackgroundReplacementModule backgroundReplacementModule, l<? super Boolean, u> lVar) {
        super(3);
        this.this$0 = backgroundReplacementModule;
        this.$callback = lVar;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(String str, Boolean bool, String str2) {
        invoke(str, bool.booleanValue(), str2);
        return u.a;
    }

    public final void invoke(String srcPathToUnity, boolean z, String maskPath) {
        s.h(srcPathToUnity, "srcPathToUnity");
        s.h(maskPath, "maskPath");
        this.this$0.B0(true);
        this.this$0.h0(srcPathToUnity, z, maskPath, this.$callback, (r12 & 16) != 0 ? false : false);
    }
}
