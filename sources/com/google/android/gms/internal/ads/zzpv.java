package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpv {
    private final int height;
    private final int width;
    public final List<byte[]> zzahg;
    public final int zzasq;
    public final float zzbjy;

    private zzpv(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.zzahg = list;
        this.zzasq = i2;
        this.width = i3;
        this.height = i4;
        this.zzbjy = f2;
    }

    public static zzpv zzg(zzpn zzpnVar) throws zzhw {
        int i2;
        int i3;
        float f2;
        try {
            zzpnVar.zzbj(4);
            int readUnsignedByte = (zzpnVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzpnVar.readUnsignedByte() & 31;
                for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                    arrayList.add(zzh(zzpnVar));
                }
                int readUnsignedByte3 = zzpnVar.readUnsignedByte();
                for (int i5 = 0; i5 < readUnsignedByte3; i5++) {
                    arrayList.add(zzh(zzpnVar));
                }
                if (readUnsignedByte2 > 0) {
                    zzpl zzd = zzpm.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i6 = zzd.width;
                    int i7 = zzd.height;
                    f2 = zzd.zzbjy;
                    i2 = i6;
                    i3 = i7;
                } else {
                    i2 = -1;
                    i3 = -1;
                    f2 = 1.0f;
                }
                return new zzpv(arrayList, readUnsignedByte, i2, i3, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhw("Error parsing AVC config", e2);
        }
    }

    private static byte[] zzh(zzpn zzpnVar) {
        int readUnsignedShort = zzpnVar.readUnsignedShort();
        int position = zzpnVar.getPosition();
        zzpnVar.zzbj(readUnsignedShort);
        return zzpf.zzc(zzpnVar.data, position, readUnsignedShort);
    }
}
