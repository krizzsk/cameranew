package com.google.android.gms.maps.model;
/* loaded from: classes2.dex */
public final class Dash extends PatternItem {
    public final float length;

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f2 = this.length;
        StringBuilder sb = new StringBuilder(30);
        sb.append("[Dash: length=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
