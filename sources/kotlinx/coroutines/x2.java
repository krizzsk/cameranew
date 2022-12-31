package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public final class x2<U, T extends U> extends kotlinx.coroutines.internal.y<T> implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public final long f8848d;

    public x2(long j2, Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.f8848d = j2;
    }

    @Override // kotlinx.coroutines.c, kotlinx.coroutines.c2
    public String r0() {
        return super.r0() + "(timeMillis=" + this.f8848d + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        P(TimeoutKt.a(this.f8848d, this));
    }
}
