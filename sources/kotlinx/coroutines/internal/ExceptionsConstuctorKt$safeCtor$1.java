package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.jvm.internal.Lambda;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements kotlin.jvm.b.l<Throwable, Throwable> {
    final /* synthetic */ kotlin.jvm.b.l<Throwable, Throwable> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstuctorKt$safeCtor$1(kotlin.jvm.b.l<? super Throwable, ? extends Throwable> lVar) {
        super(1);
        this.$block = lVar;
    }

    @Override // kotlin.jvm.b.l
    public final Throwable invoke(Throwable th) {
        Object m41constructorimpl;
        kotlin.jvm.b.l<Throwable, Throwable> lVar = this.$block;
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(lVar.invoke(th));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th2));
        }
        if (Result.m47isFailureimpl(m41constructorimpl)) {
            m41constructorimpl = null;
        }
        return (Throwable) m41constructorimpl;
    }
}
