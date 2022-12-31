package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqb {
    public final List<byte[]> zzahg;
    public final int zzasq;

    private zzqb(List<byte[]> list, int i2) {
        this.zzahg = list;
        this.zzasq = i2;
    }

    public static zzqb zzi(zzpn zzpnVar) throws zzhw {
        try {
            zzpnVar.zzbj(21);
            int readUnsignedByte = zzpnVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpnVar.readUnsignedByte();
            int position = zzpnVar.getPosition();
            int i2 = 0;
            for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                zzpnVar.zzbj(1);
                int readUnsignedShort = zzpnVar.readUnsignedShort();
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzpnVar.readUnsignedShort();
                    i2 += readUnsignedShort2 + 4;
                    zzpnVar.zzbj(readUnsignedShort2);
                }
            }
            zzpnVar.zzbi(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
                zzpnVar.zzbj(1);
                int readUnsignedShort3 = zzpnVar.readUnsignedShort();
                for (int i7 = 0; i7 < readUnsignedShort3; i7++) {
                    int readUnsignedShort4 = zzpnVar.readUnsignedShort();
                    byte[] bArr2 = zzpm.zzbjt;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(zzpnVar.data, zzpnVar.getPosition(), bArr, length, readUnsignedShort4);
                    i5 = length + readUnsignedShort4;
                    zzpnVar.zzbj(readUnsignedShort4);
                }
            }
            return new zzqb(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhw("Error parsing HEVC config", e2);
        }
    }
}
