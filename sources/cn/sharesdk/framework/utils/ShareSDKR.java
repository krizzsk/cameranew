package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mob.tools.log.NLog;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
/* loaded from: classes.dex */
public class ShareSDKR {
    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_COLOR, str);
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, TapjoyAuctionFlags.AUCTION_ID, str);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, "layout", str);
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        int i2 = 0;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return 0;
            }
            i2 = context.getResources().getIdentifier(str2, str, packageName);
            if (i2 <= 0) {
                i2 = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (i2 <= 0) {
                Resources resources = context.getResources();
                i2 = resources.getIdentifier("ssdk_" + str2, str, packageName);
                if (i2 <= 0) {
                    Resources resources2 = context.getResources();
                    i2 = resources2.getIdentifier("ssdk_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (i2 <= 0) {
                Resources resources3 = context.getResources();
                i2 = resources3.getIdentifier("ssdk_oks_" + str2, str, packageName);
                if (i2 <= 0) {
                    Resources resources4 = context.getResources();
                    i2 = resources4.getIdentifier("ssdk_oks_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (i2 <= 0) {
                NLog b = SSDKLog.b();
                b.w("failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return i2;
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_STRING, str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, TJAdUnitConstants.String.STYLE, str);
    }
}
