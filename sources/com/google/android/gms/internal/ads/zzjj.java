package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjj implements zzij {
    private ByteBuffer zzalj;
    private ByteBuffer zzamk;
    private boolean zzaml;
    private zzjg zzans;
    private ShortBuffer zzant;
    private long zzanu;
    private long zzanv;
    private float zzaib = 1.0f;
    private float zzaic = 1.0f;
    private int zzaho = -1;
    private int zzamg = -1;

    public zzjj() {
        ByteBuffer byteBuffer = zzij.zzajc;
        this.zzamk = byteBuffer;
        this.zzant = byteBuffer.asShortBuffer();
        this.zzalj = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void flush() {
        zzjg zzjgVar = new zzjg(this.zzamg, this.zzaho);
        this.zzans = zzjgVar;
        zzjgVar.setSpeed(this.zzaib);
        this.zzans.zza(this.zzaic);
        this.zzalj = zzij.zzajc;
        this.zzanu = 0L;
        this.zzanv = 0L;
        this.zzaml = false;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean isActive() {
        return Math.abs(this.zzaib - 1.0f) >= 0.01f || Math.abs(this.zzaic - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void reset() {
        this.zzans = null;
        ByteBuffer byteBuffer = zzij.zzajc;
        this.zzamk = byteBuffer;
        this.zzant = byteBuffer.asShortBuffer();
        this.zzalj = byteBuffer;
        this.zzaho = -1;
        this.zzamg = -1;
        this.zzanu = 0L;
        this.zzanv = 0L;
        this.zzaml = false;
    }

    public final float zzb(float f2) {
        float zza = zzpt.zza(f2, 0.1f, 8.0f);
        this.zzaib = zza;
        return zza;
    }

    public final float zzc(float f2) {
        this.zzaic = zzpt.zza(f2, 0.1f, 8.0f);
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzfe() {
        if (this.zzaml) {
            zzjg zzjgVar = this.zzans;
            return zzjgVar == null || zzjgVar.zzgf() == 0;
        }
        return false;
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
        this.zzans.zzfl();
        this.zzaml = true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzalj;
        this.zzalj = zzij.zzajc;
        return byteBuffer;
    }

    public final long zzgk() {
        return this.zzanu;
    }

    public final long zzgl() {
        return this.zzanv;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzanu += remaining;
            this.zzans.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzgf = (this.zzans.zzgf() * this.zzaho) << 1;
        if (zzgf > 0) {
            if (this.zzamk.capacity() < zzgf) {
                ByteBuffer order = ByteBuffer.allocateDirect(zzgf).order(ByteOrder.nativeOrder());
                this.zzamk = order;
                this.zzant = order.asShortBuffer();
            } else {
                this.zzamk.clear();
                this.zzant.clear();
            }
            this.zzans.zzb(this.zzant);
            this.zzanv += zzgf;
            this.zzamk.limit(zzgf);
            this.zzalj = this.zzamk;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzb(int i2, int i3, int i4) throws zzii {
        if (i4 == 2) {
            if (this.zzamg == i2 && this.zzaho == i3) {
                return false;
            }
            this.zzamg = i2;
            this.zzaho = i3;
            return true;
        }
        throw new zzii(i2, i3, i4);
    }
}
