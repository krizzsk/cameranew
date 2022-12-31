package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbx {
    private static List<MediaCodecInfo> b;
    private static Map<String, List<Map<String, Object>>> a = new HashMap();
    private static final Object c = new Object();

    @TargetApi(21)
    private static Integer[] a(Range<Integer> range) {
        return new Integer[]{range.getLower(), range.getUpper()};
    }

    @TargetApi(16)
    public static List<Map<String, Object>> zzep(String str) {
        ArrayList arrayList;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        Object obj = c;
        synchronized (obj) {
            if (a.containsKey(str)) {
                return a.get(str);
            }
            try {
                synchronized (obj) {
                    if (b == null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else {
                            int codecCount = MediaCodecList.getCodecCount();
                            b = new ArrayList(codecCount);
                            for (int i2 = 0; i2 < codecCount; i2++) {
                                b.add(MediaCodecList.getCodecInfoAt(i2));
                            }
                        }
                    }
                    arrayList = new ArrayList();
                    for (MediaCodecInfo mediaCodecInfo : b) {
                        if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("codecName", mediaCodecInfo.getName());
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            ArrayList arrayList2 = new ArrayList();
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            }
                            hashMap.put("profileLevels", arrayList2);
                            int i3 = Build.VERSION.SDK_INT;
                            if (i3 >= 21) {
                                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                hashMap.put("bitRatesBps", a(videoCapabilities.getBitrateRange()));
                                hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                                hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                                hashMap.put("frameRates", a(videoCapabilities.getSupportedFrameRates()));
                                hashMap.put("widths", a(videoCapabilities.getSupportedWidths()));
                                hashMap.put("heights", a(videoCapabilities.getSupportedHeights()));
                            }
                            if (i3 >= 23) {
                                hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                            }
                            arrayList.add(hashMap);
                        }
                    }
                    a.put(str, arrayList);
                }
                return arrayList;
            } catch (LinkageError | RuntimeException e2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", e2.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(hashMap2);
                a.put(str, arrayList3);
                return arrayList3;
            }
        }
    }
}
