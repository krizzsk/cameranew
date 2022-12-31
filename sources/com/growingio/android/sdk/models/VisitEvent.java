package com.growingio.android.sdk.models;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.GInternal;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VisitEvent extends VPAEvent {
    public static final String FULL_TYPE_NAME = "visit";
    public static final String TYPE_NAME = "vst";
    private static JSONObject visitObject;
    private String googleId;
    private boolean useCachedObject;

    private VisitEvent(long j2) {
        super(j2);
        this.useCachedObject = false;
        this.googleId = null;
    }

    public static VisitEvent getCachedVisitEvent() {
        if (visitObject == null) {
            return null;
        }
        VisitEvent visitEvent = new VisitEvent(System.currentTimeMillis());
        visitEvent.useCachedObject = true;
        return visitEvent;
    }

    private static boolean isPhone(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }

    public static VisitEvent makeVisitEvent() {
        return new VisitEvent(System.currentTimeMillis());
    }

    private void patchChannel(JSONObject jSONObject) {
        try {
            jSONObject.put("ch", getConfig().getChannel());
        } catch (Exception e2) {
            LogUtil.d(VPAEvent.TAG, "patch Channel error ", e2);
        }
    }

    private void patchGoogleId() {
        String str = this.googleId;
        if (str != null) {
            try {
                visitObject.put("gaid", str);
            } catch (JSONException e2) {
                LogUtil.e(VPAEvent.TAG, e2.getMessage(), e2);
            }
        }
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public void backgroundWorker() {
        super.backgroundWorker();
        this.googleId = CoreInitialize.deviceUUIDFactory().getGoogleAdId();
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getFullType() {
        return FULL_TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        JSONObject jSONObject;
        if (this.useCachedObject && (jSONObject = visitObject) != null) {
            patchLocation(jSONObject);
            patchChannel(visitObject);
            patchAndroidId(visitObject);
            patchIMEI(visitObject);
            patchGoogleId();
            return visitObject;
        }
        JSONObject commonProperty = getCommonProperty();
        visitObject = commonProperty;
        try {
            patchLocation(commonProperty);
            patchIMEI(visitObject);
            patchAndroidId(visitObject);
            visitObject.put("l", Locale.getDefault().toString());
            visitObject.put("ch", getConfig().getChannel());
            Context globalContext = getAPPState().getGlobalContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = ((WindowManager) globalContext.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            visitObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SH, displayMetrics.heightPixels);
            visitObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SW, displayMetrics.widthPixels);
            JSONObject jSONObject2 = visitObject;
            String str = Build.BRAND;
            String str2 = NetworkUtil.NETWORK_UNKNOWN;
            if (str == null) {
                str = NetworkUtil.NETWORK_UNKNOWN;
            }
            jSONObject2.put("db", str);
            JSONObject jSONObject3 = visitObject;
            String str3 = Build.MODEL;
            if (str3 == null) {
                str3 = NetworkUtil.NETWORK_UNKNOWN;
            }
            jSONObject3.put("dm", str3);
            visitObject.put("ph", isPhone(globalContext) ? 1 : 0);
            visitObject.put("os", Constants.PLATFORM_ANDROID);
            JSONObject jSONObject4 = visitObject;
            String str4 = Build.VERSION.RELEASE;
            if (str4 != null) {
                str2 = str4;
            }
            jSONObject4.put("osv", str2);
            PackageManager packageManager = globalContext.getPackageManager();
            visitObject.put("cv", packageManager.getPackageInfo(globalContext.getPackageName(), 0).versionName);
            visitObject.put("av", GConfig.GROWING_VERSION);
            visitObject.put("sn", packageManager.getApplicationLabel(globalContext.getApplicationInfo()));
            visitObject.put("v", GConfig.sGrowingScheme);
            visitObject.put("fv", GInternal.getInstance().getFeaturesVersionJson());
            patchGoogleId();
        } catch (PackageManager.NameNotFoundException e2) {
            LogUtil.d(VPAEvent.TAG, "get PackageInfo error", e2);
        } catch (JSONException e3) {
            LogUtil.d(VPAEvent.TAG, "generation the Visit Event error", e3);
        }
        return visitObject;
    }
}
