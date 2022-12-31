package us.pinguo.camera360.shop.data;

import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
/* loaded from: classes2.dex */
public enum FilterType {
    Effect("effect", "ft"),
    Sticker(TapjoyConstants.TJC_PLUGIN_UNITY, "ut"),
    Scene(SharePluginInfo.ISSUE_SCENE, "stp"),
    Combin("combin", "cn"),
    AEffect("aeffect", "ae"),
    Loc("loc", "loc");
    
    private final String subt;
    private final String type;

    FilterType(String str, String str2) {
        this.type = str;
        this.subt = str2;
    }

    public static FilterType getFliterType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        FilterType filterType = Effect;
        if (filterType.getType().equals(str)) {
            return filterType;
        }
        FilterType filterType2 = Sticker;
        if (filterType2.getType().equals(str)) {
            return filterType2;
        }
        FilterType filterType3 = Scene;
        if (filterType3.getType().equals(str)) {
            return filterType3;
        }
        FilterType filterType4 = Combin;
        if (filterType4.getType().equals(str)) {
            return filterType4;
        }
        FilterType filterType5 = AEffect;
        if (filterType5.getType().equals(str)) {
            return filterType5;
        }
        FilterType filterType6 = Loc;
        if (filterType6.getType().equals(str)) {
            return filterType6;
        }
        return null;
    }

    public static FilterType getFliterTypeBySubt(String str) {
        if (TextUtils.isEmpty(str)) {
            return Effect;
        }
        FilterType filterType = Effect;
        if (filterType.getSubt().equals(str)) {
            return filterType;
        }
        FilterType filterType2 = Sticker;
        if (filterType2.getSubt().equals(str)) {
            return filterType2;
        }
        FilterType filterType3 = Scene;
        if (filterType3.getSubt().equals(str)) {
            return filterType3;
        }
        FilterType filterType4 = AEffect;
        if (filterType4.getSubt().equals(str)) {
            return filterType4;
        }
        FilterType filterType5 = Loc;
        return filterType5.getSubt().equals(str) ? filterType5 : Combin;
    }

    public static boolean isValideSubt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Effect.getSubt().equals(str) || Sticker.getSubt().equals(str) || Scene.getSubt().equals(str) || AEffect.getSubt().equals(str) || Combin.getSubt().equals(str) || Loc.getSubt().equals(str);
    }

    public String getSubt() {
        return this.subt;
    }

    public String getType() {
        return this.type;
    }
}
