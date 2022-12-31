package com.bytedance.sdk.open.aweme.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes.dex */
public final class ViewUtils {
    private ViewUtils() {
        throw new IllegalStateException("no instance.");
    }

    private static View createStatusBarView(Activity activity, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(i2);
        return view;
    }

    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
    }

    public static void setStatusBarColor(Activity activity, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            activity.getWindow().setStatusBarColor(i2);
        } else if (i3 >= 19) {
            activity.getWindow().addFlags(67108864);
            ((ViewGroup) activity.getWindow().getDecorView()).addView(createStatusBarView(activity, i2));
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            viewGroup2.setFitsSystemWindows(true);
            viewGroup2.setClipToPadding(true);
        }
    }

    public static void setTranslucentStatusBar(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (i2 >= 19) {
                activity.getWindow().addFlags(67108864);
                return;
            }
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
