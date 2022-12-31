package kotlin.z;

import java.util.NoSuchElementException;
import kotlin.collections.i0;
/* compiled from: ProgressionIterators.kt */
/* loaded from: classes3.dex */
public final class f extends i0 {
    private final long a;
    private final long b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private long f8693d;

    public f(long j2, long j3, long j4) {
        this.a = j4;
        this.b = j3;
        boolean z = true;
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 <= 0 ? i3 < 0 : i3 > 0) {
            z = false;
        }
        this.c = z;
        this.f8693d = z ? j2 : j3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.i0
    public long nextLong() {
        long j2 = this.f8693d;
        if (j2 == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f8693d = this.a + j2;
        }
        return j2;
    }
}
