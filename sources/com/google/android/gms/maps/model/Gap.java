package com.google.android.gms.maps.model;
/* loaded from: classes2.dex */
public final class Gap extends PatternItem {
    public final float length;

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f2 = this.length;
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Gap: length=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
