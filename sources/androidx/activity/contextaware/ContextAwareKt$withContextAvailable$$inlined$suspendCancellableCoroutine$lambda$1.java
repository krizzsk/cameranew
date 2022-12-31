package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Result;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.p;
/* compiled from: ContextAware.kt */
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 implements OnContextAvailableListener {
    final /* synthetic */ p $co;
    final /* synthetic */ l $onContextAvailable$inlined;
    final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(p pVar, ContextAware contextAware, l lVar) {
        this.$co = pVar;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object m41constructorimpl;
        s.h(context, "context");
        p pVar = this.$co;
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(j.a(th));
        }
        pVar.resumeWith(m41constructorimpl);
    }
}
