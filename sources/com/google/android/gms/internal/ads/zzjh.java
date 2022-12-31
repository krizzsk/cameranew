package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzjh implements zzij {
    private ByteBuffer zzalj;
    private ByteBuffer zzamk;
    private boolean zzaml;
    private int zzamg = -1;
    private int zzaho = -1;
    private int zzake = 0;

    public zzjh() {
        ByteBuffer byteBuffer = zzij.zzajc;
        this.zzamk = byteBuffer;
        this.zzalj = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void flush() {
        this.zzalj = zzij.zzajc;
        this.zzaml = false;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean isActive() {
        int i2 = this.zzake;
        return (i2 == 0 || i2 == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void reset() {
        flush();
        this.zzamk = zzij.zzajc;
        this.zzamg = -1;
        this.zzaho = -1;
        this.zzake = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzb(int i2, int i3, int i4) throws zzii {
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            throw new zzii(i2, i3, i4);
        }
        if (this.zzamg == i2 && this.zzaho == i3 && this.zzake == i4) {
            return false;
        }
        this.zzamg = i2;
        this.zzaho = i3;
        this.zzake = i4;
        if (i4 == 2) {
            this.zzamk = zzij.zzajc;
            return true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzfe() {
        return this.zzaml && this.zzalj == zzij.zzajc;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final int zzfj() {
        return this.zzaho;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final int zzfk() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void zzfl() {
        this.zzaml = true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzalj;
        this.zzalj = zzij.zzajc;
        return byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzn(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzake
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L20
            if (r3 == r6) goto L21
            if (r3 != r4) goto L1a
            int r2 = r2 / 2
            goto L23
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L20:
            int r2 = r2 / r6
        L21:
            int r2 = r2 << 1
        L23:
            java.nio.ByteBuffer r3 = r7.zzamk
            int r3 = r3.capacity()
            if (r3 >= r2) goto L3a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zzamk = r2
            goto L3f
        L3a:
            java.nio.ByteBuffer r2 = r7.zzamk
            r2.clear()
        L3f:
            int r2 = r7.zzake
            if (r2 == r5) goto L81
            if (r2 == r6) goto L68
            if (r2 != r4) goto L62
        L47:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamk
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamk
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L47
        L62:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L68:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamk
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamk
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L68
        L81:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamk
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamk
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L81
        L9c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zzamk
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zzamk
            r7.zzalj = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjh.zzn(java.nio.ByteBuffer):void");
    }
}
