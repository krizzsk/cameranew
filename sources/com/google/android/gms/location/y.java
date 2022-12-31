package com.google.android.gms.location;

import java.util.Comparator;
/* loaded from: classes2.dex */
final class y implements Comparator<DetectedActivity> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        DetectedActivity detectedActivity3 = detectedActivity;
        DetectedActivity detectedActivity4 = detectedActivity2;
        int compareTo = Integer.valueOf(detectedActivity4.Q()).compareTo(Integer.valueOf(detectedActivity3.Q()));
        return compareTo == 0 ? Integer.valueOf(detectedActivity3.R()).compareTo(Integer.valueOf(detectedActivity4.R())) : compareTo;
    }
}
