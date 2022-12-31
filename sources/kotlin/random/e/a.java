package kotlin.random.e;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.s;
/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes3.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.a
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        s.g(current, "current()");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d2) {
        return ThreadLocalRandom.current().nextDouble(d2);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i2, int i3) {
        return ThreadLocalRandom.current().nextInt(i2, i3);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j2) {
        return ThreadLocalRandom.current().nextLong(j2);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j2, long j3) {
        return ThreadLocalRandom.current().nextLong(j2, j3);
    }
}
