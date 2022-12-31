package us.pinguo.admobvista.StaticsAdv;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PlacementIdManager {
    private static PlacementIdManager mPlacementIdManager;
    private HashMap<String, String> mMobvistaMap = new HashMap<>();
    private HashMap<String, String> mFacebookMap = new HashMap<>();
    private HashMap<String, String> mGoogleMap = new HashMap<>();
    private HashMap<String, String> mYeamobiMap = new HashMap<>();

    private PlacementIdManager() {
    }

    public static PlacementIdManager getInstance() {
        if (mPlacementIdManager == null) {
            mPlacementIdManager = new PlacementIdManager();
        }
        return mPlacementIdManager;
    }

    public String getAdmobPlacementId(String str) {
        return this.mGoogleMap.get(str);
    }

    public String getFacebookPlacementId(String str) {
        return this.mFacebookMap.get(str);
    }

    public String getMVPlacementId(String str) {
        return this.mMobvistaMap.get(str);
    }

    public String getYeamobiPlacementId(String str) {
        return this.mYeamobiMap.get(str);
    }

    public void setMVPlacementId(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMobvistaMap.put(str, str2);
        this.mFacebookMap.put(str, str3);
        this.mGoogleMap.put(str, str4);
    }

    public void setYeamobiPlacementId(String str, String str2) {
        this.mYeamobiMap.put(str, str2);
    }
}
