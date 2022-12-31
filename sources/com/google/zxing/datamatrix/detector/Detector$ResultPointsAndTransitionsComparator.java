package com.google.zxing.datamatrix.detector;

import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
final class Detector$ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
    private Detector$ResultPointsAndTransitionsComparator() {
    }

    @Override // java.util.Comparator
    public int compare(b bVar, b bVar2) {
        return bVar.a() - bVar2.a();
    }
}
