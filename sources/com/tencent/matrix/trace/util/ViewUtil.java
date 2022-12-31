package com.tencent.matrix.trace.util;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class ViewUtil {

    /* loaded from: classes3.dex */
    public static class ViewInfo {
        public int mViewCount = 0;
        public int mViewDeep = 0;
        public String mActivityName = "";

        public String toString() {
            return "ViewCount:" + this.mViewCount + ",ViewDeep:" + this.mViewDeep + ",mActivityName:" + this.mActivityName;
        }
    }

    public static ViewInfo dumpViewInfo(View view) {
        ViewInfo viewInfo = new ViewInfo();
        traversalViewTree(viewInfo, 0, view);
        return viewInfo;
    }

    private static void traversalViewTree(ViewInfo viewInfo, int i2, View view) {
        ViewGroup viewGroup;
        int childCount;
        if (view == null) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 > viewInfo.mViewDeep) {
            viewInfo.mViewDeep = i3;
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt == null || childAt.getVisibility() != 8) {
                    viewInfo.mViewCount++;
                    traversalViewTree(viewInfo, i3, childAt);
                }
            }
        }
    }
}
