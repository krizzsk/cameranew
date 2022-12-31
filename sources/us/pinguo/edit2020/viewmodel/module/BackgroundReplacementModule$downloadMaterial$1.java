package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementModule.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule$downloadMaterial$1 extends Lambda implements q<Boolean, String, String, u> {
    final /* synthetic */ q<Boolean, String, Boolean, u> $resultCallback;
    final /* synthetic */ BackgroundReplacementModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundReplacementModule$downloadMaterial$1(q<? super Boolean, ? super String, ? super Boolean, u> qVar, BackgroundReplacementModule backgroundReplacementModule) {
        super(3);
        this.$resultCallback = qVar;
        this.this$0 = backgroundReplacementModule;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, String str, String str2) {
        invoke(bool.booleanValue(), str, str2);
        return u.a;
    }

    public final void invoke(boolean z, String id, String str) {
        String str2;
        s.h(id, "id");
        q<Boolean, String, Boolean, u> qVar = this.$resultCallback;
        Boolean valueOf = Boolean.valueOf(z);
        str2 = this.this$0.q;
        qVar.invoke(valueOf, id, Boolean.valueOf(s.c(id, str2)));
        this.this$0.q = null;
    }
}
