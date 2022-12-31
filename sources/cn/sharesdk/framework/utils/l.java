package cn.sharesdk.framework.utils;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
/* compiled from: ViewRound.java */
/* loaded from: classes.dex */
public class l {
    public static ShapeDrawable a(float f2, int i2) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = 0.0f + f2;
            fArr2[i3] = f2;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr2));
        shapeDrawable.getPaint().setColor(i2);
        return shapeDrawable;
    }
}
