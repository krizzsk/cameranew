package kotlin.random;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
final class KotlinRandom extends java.util.Random {
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes3.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public KotlinRandom(Random impl) {
        s.h(impl, "impl");
        this.impl = impl;
    }

    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i2) {
        return this.impl.nextBits(i2);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bytes) {
        s.h(bytes, "bytes");
        this.impl.nextBytes(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j2) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i2) {
        return this.impl.nextInt(i2);
    }
}
