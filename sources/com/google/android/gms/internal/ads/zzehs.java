package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzehs implements zzeaq {
    private final zzehq zzijg;
    private final zzehq zzijh;

    public zzehs(byte[] bArr) throws InvalidKeyException {
        this.zzijg = zze(bArr, 1);
        this.zzijh = zze(bArr, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.zzijg.zzbfp()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.zzijg.zzbfp() + 16);
            if (allocate.remaining() >= bArr.length + this.zzijg.zzbfp() + 16) {
                int position = allocate.position();
                this.zzijg.zza(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zzijg.zzbfp()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.zzijh.zzf(bArr3, 0).get(bArr4);
                int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i2 = remaining % 16;
                int i3 = (i2 == 0 ? remaining : (remaining + 16) - i2) + length;
                ByteBuffer order = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length);
                order.put(allocate);
                order.position(i3);
                order.putLong(bArr2.length);
                order.putLong(remaining);
                byte[] zze = zzein.zze(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(zze);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    abstract zzehq zze(byte[] bArr, int i2) throws InvalidKeyException;
}
