package com.bytedance.sdk.open.aweme.utils;

import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static void a(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !a(i2)) {
            return;
        }
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    public static String[] a(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    return (String[]) new HashSet(new ArrayList(Arrays.asList(strArr))).toArray(new String[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return strArr;
    }
}
