package kotlin.random;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: Random.kt */
/* loaded from: classes3.dex */
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = kotlin.internal.b.a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes3.dex */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Random.kt */
        /* loaded from: classes3.dex */
        private static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(o oVar) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i2) {
            return Random.defaultRandom.nextBits(i2);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            s.h(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i2) {
            return Random.defaultRandom.nextBytes(i2);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2) {
            return Random.defaultRandom.nextDouble(d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i2) {
            return Random.defaultRandom.nextInt(i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2) {
            return Random.defaultRandom.nextLong(j2);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i2, int i3) {
            s.h(array, "array");
            return Random.defaultRandom.nextBytes(array, i2, i3);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2, double d3) {
            return Random.defaultRandom.nextDouble(d2, d3);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i2, int i3) {
            return Random.defaultRandom.nextInt(i2, i3);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2, long j3) {
            return Random.defaultRandom.nextLong(j2, j3);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return random.nextBytes(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i2);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public byte[] nextBytes(byte[] array, int i2, int i3) {
        s.h(array, "array");
        if (!(new kotlin.z.d(0, array.length).f(i2) && new kotlin.z.d(0, array.length).f(i3))) {
            throw new IllegalArgumentException(("fromIndex (" + i2 + ") or toIndex (" + i3 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i2 <= i3) {
            int i4 = (i3 - i2) / 4;
            for (int i5 = 0; i5 < i4; i5++) {
                int nextInt = nextInt();
                array[i2] = (byte) nextInt;
                array[i2 + 1] = (byte) (nextInt >>> 8);
                array[i2 + 2] = (byte) (nextInt >>> 16);
                array[i2 + 3] = (byte) (nextInt >>> 24);
                i2 += 4;
            }
            int i6 = i3 - i2;
            int nextBits = nextBits(i6 * 8);
            for (int i7 = 0; i7 < i6; i7++) {
                array[i2 + i7] = (byte) (nextBits >>> (i7 * 8));
            }
            return array;
        }
        throw new IllegalArgumentException(("fromIndex (" + i2 + ") must be not greater than toIndex (" + i3 + ").").toString());
    }

    public double nextDouble() {
        return c.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public abstract int nextInt();

    public int nextInt(int i2) {
        return nextInt(0, i2);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d2) {
        return nextDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, d2);
    }

    public int nextInt(int i2, int i3) {
        int nextInt;
        int i4;
        int i5;
        int nextInt2;
        boolean z;
        d.c(i2, i3);
        int i6 = i3 - i2;
        if (i6 > 0 || i6 == Integer.MIN_VALUE) {
            if (((-i6) & i6) == i6) {
                i5 = nextBits(d.e(i6));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i4 = nextInt % i6;
                } while ((nextInt - i4) + (i6 - 1) < 0);
                i5 = i4;
            }
            return i2 + i5;
        }
        do {
            nextInt2 = nextInt();
            z = false;
            if (i2 <= nextInt2 && nextInt2 < i3) {
                z = true;
                continue;
            }
        } while (!z);
        return nextInt2;
    }

    public long nextLong(long j2) {
        return nextLong(0L, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.d.b(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L3e
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L45
        L3e:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L45:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L4f
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L4f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public long nextLong(long j2, long j3) {
        long nextLong;
        boolean z;
        long nextLong2;
        long j4;
        long j5;
        int nextInt;
        d.d(j2, j3);
        long j6 = j3 - j2;
        if (j6 <= 0) {
            do {
                nextLong = nextLong();
                z = false;
                if (j2 <= nextLong && nextLong < j3) {
                    z = true;
                    continue;
                }
            } while (!z);
            return nextLong;
        }
        if (((-j6) & j6) == j6) {
            int i2 = (int) j6;
            int i3 = (int) (j6 >>> 32);
            if (i2 != 0) {
                nextInt = nextBits(d.e(i2));
            } else if (i3 == 1) {
                nextInt = nextInt();
            } else {
                j5 = (nextBits(d.e(i3)) << 32) + (nextInt() & 4294967295L);
            }
            j5 = nextInt & 4294967295L;
        } else {
            do {
                nextLong2 = nextLong() >>> 1;
                j4 = nextLong2 % j6;
            } while ((nextLong2 - j4) + (j6 - 1) < 0);
            j5 = j4;
        }
        return j2 + j5;
    }

    public byte[] nextBytes(byte[] array) {
        s.h(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int i2) {
        return nextBytes(new byte[i2]);
    }
}
