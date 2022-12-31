package androidx.activity.contextaware;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: ContextAware.kt */
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2 extends Lambda implements l<Throwable, u> {
    final /* synthetic */ ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 $listener;
    final /* synthetic */ l $onContextAvailable$inlined;
    final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, ContextAware contextAware, l lVar) {
        super(1);
        this.$listener = contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_withContextAvailable$inlined.removeOnContextAvailableListener(this.$listener);
    }
}
