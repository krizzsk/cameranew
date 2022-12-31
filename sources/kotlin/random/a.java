package kotlin.random;

import kotlin.jvm.internal.s;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public abstract class a extends Random {
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public int nextBits(int i2) {
        return d.g(getImpl().nextInt(), i2);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // kotlin.random.Random
    public byte[] nextBytes(byte[] array) {
        s.h(array, "array");
        getImpl().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i2) {
        return getImpl().nextInt(i2);
    }
}
