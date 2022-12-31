package com.pinguo.camera360.effect.model.entity.type;

import android.text.TextUtils;
import com.google.gson.t.a;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.texture.Texture;
import com.pinguo.lib.GsonUtilKt;
import java.util.List;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* loaded from: classes3.dex */
public class CameraFilter extends Effect {
    public static final String PARAM_KEY_OPACITY = "EffectOpacity";
    private static final String TAG = CameraFilter.class.getSimpleName();

    public CameraFilter(FilterItemTable filterItemTable, FilterParamsTable filterParamsTable) {
        super(filterItemTable, filterParamsTable);
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Object clone() throws CloneNotSupportedException {
        CameraFilter cameraFilter;
        try {
            cameraFilter = (CameraFilter) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            cameraFilter = null;
        }
        return cameraFilter != null ? cameraFilter : new CameraFilter(getItemBean(), getBean(Effect.Version.old));
    }

    public Texture getTexture() {
        Effect.Version version = Effect.Version.old;
        if (TextUtils.isEmpty(getBean(version).getTextureStr())) {
            return null;
        }
        try {
            return (Texture) GsonUtilKt.getCachedGson().k(getBean(version).getTextureStr(), new a<Texture>() { // from class: com.pinguo.camera360.effect.model.entity.type.CameraFilter.1
            }.getType());
        } catch (RuntimeException e2) {
            String str = TAG;
            us.pinguo.common.log.a.g(str, "Construct Texture object with texture string fail! string: " + getBean(Effect.Version.old).getTextureStr(), new Object[0]);
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    public CameraFilter(FilterItemTable filterItemTable, List<FilterParamsTable> list) {
        super(filterItemTable, list);
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Texture getTexture(Effect.Version version) {
        return getTexture();
    }
}
