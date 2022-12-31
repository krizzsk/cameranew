package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4 extends Lambda implements kotlin.jvm.b.l<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    @Override // kotlin.jvm.b.l
    public final Throwable invoke(Throwable th) {
        Object m41constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = this.$constructor$inlined.newInstance(new Object[0]);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th2));
        }
        if (newInstance != null) {
            Throwable th3 = (Throwable) newInstance;
            th3.initCause(th);
            m41constructorimpl = Result.m41constructorimpl(th3);
            if (Result.m47isFailureimpl(m41constructorimpl)) {
                m41constructorimpl = null;
            }
            return (Throwable) m41constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
    }
}
