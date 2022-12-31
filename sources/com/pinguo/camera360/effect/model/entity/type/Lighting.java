package com.pinguo.camera360.effect.model.entity.type;

import android.text.TextUtils;
import com.google.gson.t.a;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.texture.Texture;
import com.pinguo.lib.GsonUtilKt;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* loaded from: classes3.dex */
public class Lighting extends Effect {
    public static final String PARAM_KEY_OPACITY = "Opacity";
    public static final String PARAM_KEY_TEXTURE_ANGLE = "textureAngle";
    private static final String TAG = Lighting.class.getSimpleName();

    public Lighting(FilterItemTable filterItemTable, FilterParamsTable filterParamsTable) {
        super(filterItemTable, filterParamsTable);
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Object clone() throws CloneNotSupportedException {
        Lighting lighting;
        try {
            lighting = (Lighting) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            lighting = null;
        }
        return lighting != null ? lighting : new Lighting(getItemBean(), getBean(Effect.Version.old));
    }

    public Texture getTexture() {
        Effect.Version version = Effect.Version.old;
        if (TextUtils.isEmpty(getBean(version).getTextureStr())) {
            return null;
        }
        try {
            return (Texture) GsonUtilKt.getCachedGson().k(getBean(version).getTextureStr(), new a<Texture>() { // from class: com.pinguo.camera360.effect.model.entity.type.Lighting.1
            }.getType());
        } catch (RuntimeException e2) {
            String str = TAG;
            us.pinguo.common.log.a.g(str, "Construct Texture object with texture string fail! string: " + getBean(Effect.Version.old).getTextureStr(), new Object[0]);
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Texture getTexture(Effect.Version version) {
        return getTexture();
    }
}
