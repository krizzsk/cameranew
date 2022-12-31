package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.f0;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f8803f;

    /* renamed from: g  reason: collision with root package name */
    private static final CoroutineDispatcher f8804g;

    static {
        int a;
        int d2;
        a aVar = new a();
        f8803f = aVar;
        a = kotlin.z.j.a(64, d0.a());
        d2 = f0.d("kotlinx.coroutines.io.parallelism", a, 0, 0, 12, null);
        f8804g = new d(aVar, d2, "Dispatchers.IO", 1);
    }

    private a() {
        super(0, 0, null, 7, null);
    }

    public final CoroutineDispatcher Q() {
        return f8804g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
