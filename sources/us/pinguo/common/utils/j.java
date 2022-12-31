package us.pinguo.common.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import us.pinguo.util.v;
/* compiled from: ViewAttributeUtil.java */
/* loaded from: classes4.dex */
public class j {
    public static void a(us.pinguo.common.widget.f fVar, Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{i2});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (fVar != null) {
            fVar.getView().setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
    }

    public static void b(us.pinguo.common.widget.f fVar, Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{i2});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (fVar != null && (fVar instanceof ImageView)) {
            ((ImageView) fVar.getView()).setImageDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
    }

    public static void c(us.pinguo.common.widget.f fVar, Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{i2});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        if (fVar != null && (fVar instanceof TextView) && colorStateList != null) {
            ((TextView) fVar.getView()).setTextColor(colorStateList);
        }
        obtainStyledAttributes.recycle();
    }

    public static int d(AttributeSet attributeSet, int i2) {
        String attributeValue;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if (attributeSet.getAttributeNameResource(i3) == i2 && (attributeValue = attributeSet.getAttributeValue(i3)) != null && attributeValue.startsWith("?")) {
                String substring = attributeValue.substring(1, attributeValue.length());
                try {
                    return Integer.valueOf(substring).intValue();
                } catch (NumberFormatException unused) {
                    Context a = v.a();
                    return a.getResources().getIdentifier(substring.substring(5), "attr", a.getPackageName());
                }
            }
        }
        return -1;
    }

    public static int e(AttributeSet attributeSet) {
        return d(attributeSet, 16842964);
    }

    public static int f(AttributeSet attributeSet) {
        return d(attributeSet, 16843033);
    }

    public static int g(AttributeSet attributeSet) {
        return d(attributeSet, 16842904);
    }
}
