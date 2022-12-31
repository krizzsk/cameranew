package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbp {
    public static int zza(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long j2 = byteBuffer.getInt();
        return j2 < 0 ? j2 + IjkMediaMeta.AV_CH_WIDE_RIGHT : j2;
    }

    public static int zzg(ByteBuffer byteBuffer) {
        return (zza(byteBuffer.get()) << 8) + 0 + zza(byteBuffer.get());
    }

    public static long zzh(ByteBuffer byteBuffer) {
        long zzf = (zzf(byteBuffer) << 32) + 0;
        if (zzf >= 0) {
            return zzf + zzf(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double zzi(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((((0 | ((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & Draft_75.END_OF_FRAME)) / 65536.0d;
    }

    public static double zzj(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((((0 | ((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | (bArr[3] & Draft_75.END_OF_FRAME)) / 1.073741824E9d;
    }

    public static String zzk(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
