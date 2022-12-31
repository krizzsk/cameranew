package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjp extends zzji {
    public long zzaol;
    public ByteBuffer zzdr;
    public final zzjl zzaok = new zzjl();
    private final int zzaom = 0;

    public zzjp(int i2) {
    }

    private final ByteBuffer zzae(int i2) {
        ByteBuffer byteBuffer = this.zzdr;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i2);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzji
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzdr;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzab(1073741824);
    }

    public final void zzad(int i2) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzdr;
        if (byteBuffer == null) {
            this.zzdr = zzae(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzdr.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            return;
        }
        ByteBuffer zzae = zzae(i3);
        if (position > 0) {
            this.zzdr.position(0);
            this.zzdr.limit(position);
            zzae.put(this.zzdr);
        }
        this.zzdr = zzae;
    }
}
