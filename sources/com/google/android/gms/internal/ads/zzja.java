package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzja implements zzij {
    private int zzaho;
    private ByteBuffer zzalj;
    private int zzamg;
    private int[] zzamh;
    private boolean zzami;
    private int[] zzamj;
    private ByteBuffer zzamk;
    private boolean zzaml;

    public zzja() {
        ByteBuffer byteBuffer = zzij.zzajc;
        this.zzamk = byteBuffer;
        this.zzalj = byteBuffer;
        this.zzaho = -1;
        this.zzamg = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void flush() {
        this.zzalj = zzij.zzajc;
        this.zzaml = false;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean isActive() {
        return this.zzami;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void reset() {
        flush();
        this.zzamk = zzij.zzajc;
        this.zzaho = -1;
        this.zzamg = -1;
        this.zzamj = null;
        this.zzami = false;
    }

    public final void zzb(int[] iArr) {
        this.zzamh = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzfe() {
        return this.zzaml && this.zzalj == zzij.zzajc;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final int zzfj() {
        int[] iArr = this.zzamj;
        return iArr == null ? this.zzaho : iArr.length;
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

    @Override // com.google.android.gms.internal.ads.zzij
    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzaho * 2)) * this.zzamj.length) << 1;
        if (this.zzamk.capacity() < length) {
            this.zzamk = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzamk.clear();
        }
        while (position < limit) {
            for (int i2 : this.zzamj) {
                this.zzamk.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.zzaho << 1;
        }
        byteBuffer.position(limit);
        this.zzamk.flip();
        this.zzalj = this.zzamk;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzb(int i2, int i3, int i4) throws zzii {
        boolean z = !Arrays.equals(this.zzamh, this.zzamj);
        int[] iArr = this.zzamh;
        this.zzamj = iArr;
        if (iArr == null) {
            this.zzami = false;
            return z;
        } else if (i4 == 2) {
            if (!z && this.zzamg == i2 && this.zzaho == i3) {
                return false;
            }
            this.zzamg = i2;
            this.zzaho = i3;
            this.zzami = i3 != iArr.length;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.zzamj;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 < i3) {
                    this.zzami = (i6 != i5) | this.zzami;
                    i5++;
                } else {
                    throw new zzii(i2, i3, i4);
                }
            }
        } else {
            throw new zzii(i2, i3, i4);
        }
    }
}
