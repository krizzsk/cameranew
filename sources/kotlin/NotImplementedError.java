package kotlin;
/* compiled from: Standard.kt */
/* loaded from: classes3.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String message) {
        super(message);
        kotlin.jvm.internal.s.h(message, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i2, kotlin.jvm.internal.o oVar) {
        this((i2 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
