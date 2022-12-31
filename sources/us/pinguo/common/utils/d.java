package us.pinguo.common.utils;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ColorUiUtil.java */
/* loaded from: classes4.dex */
public class d {
    public static void a(View view, Resources.Theme theme) {
        int i2 = 0;
        if (view instanceof us.pinguo.common.widget.f) {
            ((us.pinguo.common.widget.f) view).setTheme(theme);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                while (i2 < childCount) {
                    a(viewGroup.getChildAt(i2), theme);
                    i2++;
                }
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            while (i2 < childCount2) {
                a(viewGroup2.getChildAt(i2), theme);
                i2++;
            }
        }
    }
}
