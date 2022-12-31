package us.pinguo.advsdk.utils;

import java.util.Calendar;
/* compiled from: DateUtil.java */
/* loaded from: classes3.dex */
public class g {
    public static boolean a(long j2) {
        if (j2 == 0) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        int[] iArr = {calendar.get(1), calendar.get(2), calendar.get(5)};
        calendar.setTimeInMillis(j2);
        return (iArr[0] == calendar.get(1) && iArr[1] == calendar.get(2) && iArr[2] == calendar.get(5)) ? false : true;
    }
}
