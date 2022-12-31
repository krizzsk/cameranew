package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.jvm.internal.Lambda;
/* compiled from: Produce.kt */
/* loaded from: classes3.dex */
final class ProduceKt$awaitClose$4$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ kotlinx.coroutines.p<kotlin.u> $cont;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProduceKt$awaitClose$4$1(kotlinx.coroutines.p<? super kotlin.u> pVar) {
        super(1);
        this.$cont = pVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        kotlinx.coroutines.p<kotlin.u> pVar = this.$cont;
        kotlin.u uVar = kotlin.u.a;
        Result.a aVar = Result.Companion;
        pVar.resumeWith(Result.m41constructorimpl(uVar));
    }
}
