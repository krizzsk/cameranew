package com.pinguo.camera360.effect.model.entity.type;

import android.text.TextUtils;
import com.google.gson.t.a;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.texture.Texture;
import com.pinguo.lib.GsonUtilKt;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* loaded from: classes3.dex */
public class Frame extends Effect {
    public static final String PARAM_KEY_OPACITY = "opacity";
    public static final String PARAM_KEY_TEXTURE_ANGLE = "textureAngle";
    private static final String TAG = Frame.class.getSimpleName();

    public Frame(FilterItemTable filterItemTable, FilterParamsTable filterParamsTable) {
        super(filterItemTable, filterParamsTable);
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Object clone() throws CloneNotSupportedException {
        Frame frame;
        try {
            frame = (Frame) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            frame = null;
        }
        return frame != null ? frame : new Frame(getItemBean(), getBean(Effect.Version.old));
    }

    public Texture getTexture() {
        Effect.Version version = Effect.Version.old;
        if (TextUtils.isEmpty(getBean(version).getTextureStr())) {
            return null;
        }
        try {
            return (Texture) GsonUtilKt.getCachedGson().k(getBean(version).getTextureStr(), new a<Texture>() { // from class: com.pinguo.camera360.effect.model.entity.type.Frame.1
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
