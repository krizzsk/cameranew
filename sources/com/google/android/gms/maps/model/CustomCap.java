package com.google.android.gms.maps.model;
/* loaded from: classes2.dex */
public final class CustomCap extends Cap {
    public final a bitmapDescriptor;
    public final float refWidth;

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        String valueOf = String.valueOf(this.bitmapDescriptor);
        float f2 = this.refWidth;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 55);
        sb.append("[CustomCap: bitmapDescriptor=");
        sb.append(valueOf);
        sb.append(" refWidth=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
