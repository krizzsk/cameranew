package com.google.firebase.crashlytics.internal.common;
/* loaded from: classes2.dex */
public class ResponseParser {
    public static final int ResponseActionDiscard = 0;
    public static final int ResponseActionRetry = 1;

    public static int parse(int i2) {
        if (i2 < 200 || i2 > 299) {
            if (i2 < 300 || i2 > 399) {
                if (i2 < 400 || i2 > 499) {
                    if (i2 >= 500) {
                    }
                    return 1;
                }
                return 0;
            }
            return 1;
        }
        return 0;
    }
}
