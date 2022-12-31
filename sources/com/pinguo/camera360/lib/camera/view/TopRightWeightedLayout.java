package com.pinguo.camera360.lib.camera.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class TopRightWeightedLayout extends LinearLayout {
    public TopRightWeightedLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i2) {
        boolean z = getOrientation() == 0;
        boolean z2 = 1 == i2;
        if (z2 && !z) {
            b(0);
            setOrientation(0);
            c();
            requestLayout();
        } else if (z2 || !z) {
        } else {
            b(1);
            setOrientation(1);
            c();
            requestLayout();
        }
    }

    private void b(int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int i4 = layoutParams.gravity;
            if (i2 == 1) {
                if ((i4 & 3) != 0) {
                    i4 = (i4 & (-4)) | 80;
                }
            } else if ((i4 & 80) != 0) {
                i4 = (i4 & (-81)) | 3;
            }
            if (i2 == 1) {
                if ((i4 & 5) != 0) {
                    i4 = (i4 & (-6)) | 48;
                }
            } else if ((i4 & 48) != 0) {
                i4 = (i4 & (-49)) | 5;
            }
            if ((i4 & 17) != 17) {
                if (i2 == 1) {
                    if ((i4 & 16) != 0) {
                        i4 = (i4 & (-17)) | 1;
                    }
                } else if ((i4 & 1) != 0) {
                    i4 = (i4 & (-2)) | 16;
                }
            }
            layoutParams.gravity = i4;
            int paddingLeft = childAt.getPaddingLeft();
            int paddingTop = childAt.getPaddingTop();
            childAt.setPadding(childAt.getPaddingBottom(), childAt.getPaddingRight(), paddingTop, paddingLeft);
        }
    }

    private void c() {
        ArrayList<View> arrayList = new ArrayList();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            arrayList.add(getChildAt(childCount));
        }
        for (View view : arrayList) {
            bringChildToFront(view);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(configuration.orientation);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        a(getContext().getResources().getConfiguration().orientation);
    }
}
