package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract long Q();

    public abstract int R();

    public abstract long S();

    public abstract String T();

    public String toString() {
        long Q = Q();
        int R = R();
        long S = S();
        String T = T();
        StringBuilder sb = new StringBuilder(String.valueOf(T).length() + 53);
        sb.append(Q);
        sb.append("\t");
        sb.append(R);
        sb.append("\t");
        sb.append(S);
        sb.append(T);
        return sb.toString();
    }
}
