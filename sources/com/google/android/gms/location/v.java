package com.google.android.gms.location;

import java.util.Comparator;
/* loaded from: classes2.dex */
final class v implements Comparator<ActivityTransition> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        ActivityTransition activityTransition3 = activityTransition;
        ActivityTransition activityTransition4 = activityTransition2;
        int Q = activityTransition3.Q();
        int Q2 = activityTransition4.Q();
        if (Q != Q2) {
            return Q < Q2 ? -1 : 1;
        }
        int R = activityTransition3.R();
        int R2 = activityTransition4.R();
        if (R == R2) {
            return 0;
        }
        return R < R2 ? -1 : 1;
    }
}
