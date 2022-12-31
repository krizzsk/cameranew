package com.google.zxing.multi.qrcode.detector;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.qrcode.detector.d;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class MultiFinderPatternFinder$ModuleSizeComparator implements Serializable, Comparator<d> {
    private MultiFinderPatternFinder$ModuleSizeComparator() {
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        double i2 = dVar2.i() - dVar.i();
        if (i2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return -1;
        }
        return i2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : 0;
    }
}
