package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzlw {
    private final String mimeType;
    public final String name;
    public final boolean zzalq;
    public final boolean zzbcr;
    public final boolean zzbcs;
    private final MediaCodecInfo.CodecCapabilities zzbct;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzpt.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzlw(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzpg.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzbct = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L2a
            if (r4 == 0) goto L2a
            int r5 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r0 = 19
            if (r5 < r0) goto L25
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L25:
            r5 = 0
        L26:
            if (r5 == 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            r1.zzbcr = r5
            r5 = 21
            if (r4 == 0) goto L44
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r0 < r5) goto L3f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            r1.zzalq = r0
            if (r6 != 0) goto L5e
            if (r4 == 0) goto L5d
            int r6 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r6 < r5) goto L59
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 == 0) goto L5d
            goto L5e
        L5d:
            r2 = 0
        L5e:
            r1.zzbcs = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzlw zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzlw(str, str2, codecCapabilities, z, z2);
    }

    public static zzlw zzay(String str) {
        return new zzlw(str, null, null, false, false);
    }

    private final void zzba(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzpt.zzbkn;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public final boolean zzaw(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbct;
        if (codecCapabilities == null) {
            zzba("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("sampleRate.support, ");
            sb.append(i2);
            zzba(sb.toString());
            return false;
        }
    }

    @TargetApi(21)
    public final boolean zzax(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbct;
        if (codecCapabilities == null) {
            zzba("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() < i2) {
            StringBuilder sb = new StringBuilder(33);
            sb.append("channelCount.support, ");
            sb.append(i2);
            zzba(sb.toString());
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzaz(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.zzaz(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final Point zzd(int i2, int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbct;
        if (codecCapabilities == null) {
            zzba("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzpt.zzf(i2, widthAlignment) * widthAlignment, zzpt.zzf(i3, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzhi() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbct;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public final boolean zza(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbct;
        if (codecCapabilities == null) {
            zzba("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("sizeAndRate.vCaps");
            return false;
        } else if (zza(videoCapabilities, i2, i3, d2)) {
            return true;
        } else {
            if (i2 < i3 && zza(videoCapabilities, i3, i2, d2)) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.rotated, ");
                sb.append(i2);
                sb.append("x");
                sb.append(i3);
                sb.append("x");
                sb.append(d2);
                String sb2 = sb.toString();
                String str = this.name;
                String str2 = this.mimeType;
                String str3 = zzpt.zzbkn;
                StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
                sb3.append("AssumedSupport [");
                sb3.append(sb2);
                sb3.append("] [");
                sb3.append(str);
                sb3.append(", ");
                sb3.append(str2);
                sb3.append("] [");
                sb3.append(str3);
                sb3.append("]");
                Log.d("MediaCodecInfo", sb3.toString());
                return true;
            }
            StringBuilder sb4 = new StringBuilder(69);
            sb4.append("sizeAndRate.support, ");
            sb4.append(i2);
            sb4.append("x");
            sb4.append(i3);
            sb4.append("x");
            sb4.append(d2);
            zzba(sb4.toString());
            return false;
        }
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (d2 != -1.0d && d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
        }
        return videoCapabilities.isSizeSupported(i2, i3);
    }
}
