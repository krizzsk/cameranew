package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzih {
    private static final int[] zzaiw = {1, 2, 3, 6};
    private static final int[] zzaix = {48000, 44100, 32000};
    private static final int[] zzaiy = {24000, 22050, 16000};
    private static final int[] zzaiz = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaja = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, VideoEdit2Activity.MIN_SCALED_SIZE};
    private static final int[] zzajb = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzht zza(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        int i2 = zzaix[(zzpnVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i3 = zzaiz[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i3++;
        }
        return zzht.zza(str, "audio/ac3", null, -1, -1, i3, i2, null, zzjoVar, 0, str2);
    }

    public static zzht zzb(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        zzpnVar.zzbj(2);
        int i2 = zzaix[(zzpnVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i3 = zzaiz[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i3++;
        }
        return zzht.zza(str, "audio/eac3", null, -1, -1, i3, i2, null, zzjoVar, 0, str2);
    }

    public static int zzfi() {
        return 1536;
    }

    public static int zzm(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? zzaiw[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
