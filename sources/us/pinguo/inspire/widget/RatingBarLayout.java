package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import us.pinguo.inspire.model.InspireWork;
/* loaded from: classes9.dex */
public class RatingBarLayout extends LinearLayout {
    public RatingBarLayout(Context context) {
        super(context);
    }

    public static void setRating(RatingBarLayout ratingBarLayout, InspireWork inspireWork) {
        int topValue = InspireWork.getTopValue(inspireWork);
        int i2 = 5;
        if (topValue >= 90) {
            i2 = 1;
        } else if (topValue >= 60) {
            i2 = 2;
        } else if (topValue >= 30) {
            i2 = 3;
        } else if (topValue >= 10) {
            i2 = 4;
        }
        ratingBarLayout.setNumStarts(i2);
    }

    public void setNumStarts(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (i3 <= i2 - 1) {
                getChildAt(i3).setVisibility(0);
            } else {
                getChildAt(i3).setVisibility(8);
            }
        }
    }

    public RatingBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RatingBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
