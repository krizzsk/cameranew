package com.pinguo.camera360.effect.model.entity;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.gson.t.a;
import com.pinguo.camera360.effect.model.entity.param.Param;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
import com.pinguo.camera360.effect.model.entity.texture.Texture;
import com.pinguo.camera360.effect.model.entity.texture.TextureItem;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.g;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.camera360.shop.h;
import us.pinguo.foundation.utils.f0;
import us.pinguo.processor.d;
import us.pinguo.processor.f;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.entity.SkinParam;
import us.pinguo.repository2020.entity.SkinParamExtra;
/* loaded from: classes3.dex */
public class Effect extends g implements Comparable<Effect>, Cloneable {
    public static final String DIVIDER = "|";
    public static final String EFFECT_FILTER_AUTO_KEY = "C360_auto";
    public static final String EFFECT_FILTER_DEFAULT_KEY = "C360_Skin_Red";
    public static final String EFFECT_FILTER_NONE_KEY = "C360_None";
    public static final String EFFECT_OPACITY = "EffectOpacity";
    public static final int EFFECT_OPACITY_DEF = 100;
    public static final int EFFECT_OPACITY_MAX = 100;
    public static final int EFFECT_OPACITY_MIN = 0;
    public static final float EFFECT_OPACITY_STEP = 1.0f;
    public static final String EFFECT_SELFIE_FILTER_DEFAULT_KEY = "C360_Skin_Other_Red";
    public static final String PREFIX = "Effect=";
    private Pair<FilterParamsTable, List<FilterParamsTable>> effectBeanPair;
    private Param param;
    private Map<Pair<String, String>, ParamItem> paramMap;
    private SkinParam skinParam;
    private static final SkinParam defaultSkinParam = new SkinParam(0, 0.2f, 0.1f, 0.0f, new SkinParamExtra(0.0f, 0.0f, false));
    private static final String TAG = Effect.class.getSimpleName();

    /* loaded from: classes3.dex */
    public enum Type {
        Filter,
        CameraFilter,
        Lighting,
        Frame
    }

    /* loaded from: classes3.dex */
    public enum Version {
        old,
        latest
    }

    public Effect(FilterItemTable filterItemTable, FilterParamsTable filterParamsTable) {
        super(filterItemTable);
        this.param = null;
        this.paramMap = null;
        this.effectBeanPair = null;
        this.skinParam = null;
        this.effectBeanPair = new Pair<>(filterParamsTable, null);
        if (TextUtils.isEmpty(filterParamsTable.getOnlineParam()) || !TextUtils.isEmpty(((FilterParamsTable) this.effectBeanPair.first).getGpuCmd())) {
            return;
        }
        ((FilterParamsTable) this.effectBeanPair.first).setGpuCmd("Effect=Normal");
    }

    private Map<Pair<String, String>, ParamItem> buildParamMap(Param param) {
        if (param != null && param.items != null) {
            Map<Pair<String, String>, ParamItem> map = this.paramMap;
            if (map == null) {
                this.paramMap = new HashMap();
            } else {
                map.clear();
            }
            for (List<ParamItem> list : param.items.values()) {
                for (ParamItem paramItem : list) {
                    this.paramMap.put(new Pair<>(paramItem.key, getKey()), paramItem);
                }
            }
            return this.paramMap;
        }
        HashMap hashMap = new HashMap();
        this.paramMap = hashMap;
        return hashMap;
    }

    public void buildParamByParamStr(Version version) {
        Param loadFromJsonStr = Param.loadFromJsonStr(getEffectBean(version).getParamStr());
        this.param = loadFromJsonStr;
        if (loadFromJsonStr == null) {
            this.param = new Param();
        }
        buildParamMap(this.param);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        Effect effect;
        try {
            effect = (Effect) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            effect = null;
        }
        return effect != null ? effect : new Effect(getItemBean(), (FilterParamsTable) this.effectBeanPair.first);
    }

    public FilterParamsTable getBean(Version version) {
        return getEffectBean(version);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterParamsTable getEffectBean(Version version) {
        Object obj;
        Pair<FilterParamsTable, List<FilterParamsTable>> pair = this.effectBeanPair;
        Object obj2 = pair.first;
        if (obj2 != null) {
            return (FilterParamsTable) obj2;
        }
        if (((List) pair.second).isEmpty()) {
            return new FilterParamsTable();
        }
        if (version == Version.old) {
            obj = ((List) this.effectBeanPair.second).get(0);
        } else {
            Object obj3 = this.effectBeanPair.second;
            obj = ((List) obj3).get(((List) obj3).size() - 1);
        }
        return (FilterParamsTable) obj;
    }

    @Override // us.pinguo.camera360.shop.data.g
    public String getFilterKey() {
        return getKey();
    }

    public String getGpuCmd(Version version) {
        return getEffectBean(version).getGpuCmd();
    }

    public String[] getGpuCmds(Version version) {
        FilterParamsTable effectBean = getEffectBean(version);
        if (effectBean.getGpuCmd().isEmpty()) {
            return new String[0];
        }
        String[] a = f0.a(effectBean.getGpuCmd(), "\\$");
        for (int i2 = 0; i2 < a.length; i2++) {
            a[i2] = f0.c(a[i2]);
        }
        return a;
    }

    public String getKey() {
        return getEffectBean(Version.old).getKey();
    }

    public String getOnLineParam(Version version) {
        FilterParamsTable effectBean;
        if (getFliterType() == FilterType.Effect && (effectBean = getEffectBean(version)) != null) {
            return effectBean.getOnlineParam();
        }
        return null;
    }

    public String getOnLineParamOfLoc() {
        FilterParamsTable effectBean;
        if (getFliterType() != FilterType.Loc || (effectBean = getEffectBean(Version.latest)) == null) {
            return null;
        }
        return effectBean.getOnlineParam();
    }

    public String getPackKey() {
        return getPackageId();
    }

    public Param getParam(Version version, boolean z) {
        if (z || this.param == null || this.paramMap == null) {
            buildParamByParamStr(version);
        }
        return this.param;
    }

    public ParamItem getParamItem(Version version, String str, String str2) {
        if (this.paramMap == null) {
            buildParamByParamStr(version);
        }
        return this.paramMap.get(new Pair(str, str2));
    }

    public String getPreCmd(Version version) {
        return getEffectBean(version).getPreCmd();
    }

    public String[] getPreCmds(Version version) {
        FilterParamsTable effectBean = getEffectBean(version);
        if (effectBean.getPreCmd().isEmpty()) {
            return new String[0];
        }
        String[] a = f0.a(effectBean.getPreCmd(), "\\$");
        for (int i2 = 0; i2 < a.length; i2++) {
            a[i2] = f0.c(a[i2]);
        }
        return a;
    }

    @NonNull
    public SkinParam getSkinParam(Version version) {
        FilterParamsTable effectBean = getEffectBean(version);
        if (effectBean.getSkinParamObject() == null) {
            if (!TextUtils.isEmpty(effectBean.getSkinParam())) {
                effectBean.setSkinParamObject((SkinParam) GsonUtilKt.getCachedGson().j(effectBean.getSkinParam(), SkinParam.class));
            } else {
                effectBean.setSkinParamObject(defaultSkinParam);
            }
        }
        return effectBean.getSkinParamObject();
    }

    public Texture getTexture(Version version) {
        RuntimeException e2;
        Texture texture;
        String str;
        FilterParamsTable effectBean = getEffectBean(version);
        if (TextUtils.isEmpty(effectBean.getTextureStr())) {
            return null;
        }
        try {
            texture = (Texture) GsonUtilKt.getCachedGson().k(effectBean.getTextureStr(), new a<Texture>() { // from class: com.pinguo.camera360.effect.model.entity.Effect.1
            }.getType());
            if (texture != null) {
                try {
                    String c = t.c(getPackageMd5());
                    if (h.a.a().containsKey(effectBean.getId())) {
                        File file = new File(c);
                        if (!file.isDirectory() || !file.exists()) {
                            c = "assets://builtin_data/filters/" + effectBean.getPackageId() + File.separator;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    sb.append(getFilterId());
                    String str2 = File.separator;
                    sb.append(str2);
                    if (TextUtils.isEmpty(effectBean.getVersionDir())) {
                        str = "";
                    } else {
                        str = effectBean.getVersionDir() + str2;
                    }
                    sb.append(str);
                    texture.textureDir = sb.toString();
                } catch (RuntimeException e3) {
                    e2 = e3;
                    us.pinguo.common.log.a.g(TAG, "Construct Texture object with texture string fail! string: " + effectBean.getTextureStr(), new Object[0]);
                    us.pinguo.common.log.a.f(e2);
                    return texture;
                }
            }
        } catch (RuntimeException e4) {
            e2 = e4;
            texture = null;
        }
        return texture;
    }

    public String getTextureStr(Version version) {
        return getEffectBean(version).getTextureStr();
    }

    @Deprecated
    public String getTypeKey() {
        return "";
    }

    public boolean haveGPUCmd(Version version) {
        FilterParamsTable effectBean = getEffectBean(version);
        return (effectBean.getGpuCmd() == null || "".equals(effectBean.getGpuCmd())) ? false : true;
    }

    public boolean havePreCmd(Version version) {
        FilterParamsTable effectBean = getEffectBean(version);
        return (effectBean.getPreCmd() == null || "".equals(effectBean.getPreCmd())) ? false : true;
    }

    public boolean isOnLineEffect(Version version) {
        return getFliterType() == FilterType.Effect && !TextUtils.isEmpty(getOnLineParam(version));
    }

    public d toMakeInfo() {
        List<TextureItem> list;
        String key = getKey();
        Version version = Version.latest;
        String gpuCmd = getGpuCmd(version);
        ArrayList arrayList = new ArrayList();
        Texture texture = getTexture(version);
        if (texture != null && (list = texture.items) != null) {
            String str = texture.textureDir;
            for (TextureItem textureItem : list) {
                int i2 = textureItem.index;
                arrayList.add(new f(i2, str + textureItem.name, textureItem.enableRotation, null));
            }
        }
        return new d(key, gpuCmd, arrayList, false);
    }

    @Override // us.pinguo.camera360.shop.data.g
    public String toString() {
        return getFilterId();
    }

    @Override // java.lang.Comparable
    public int compareTo(Effect effect) {
        return effect.getIndexInPackage() - getIndexInPackage() < 0 ? 1 : -1;
    }

    public Effect(FilterItemTable filterItemTable, List<FilterParamsTable> list) {
        super(filterItemTable);
        this.param = null;
        this.paramMap = null;
        this.effectBeanPair = null;
        this.skinParam = null;
        this.effectBeanPair = new Pair<>(null, list);
    }
}
