package com.pinguo.camera360.effect.model.entity.type;

import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.texture.Texture;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.common.log.a;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* compiled from: UnityFilter.kt */
/* loaded from: classes3.dex */
public final class UnityFilter extends Effect {
    private final String filterPath;
    private final String realFilterId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityFilter(String realFilterId, String filterPath, FilterItemTable item, FilterParamsTable effect) {
        super(item, effect);
        s.h(realFilterId, "realFilterId");
        s.h(filterPath, "filterPath");
        s.h(item, "item");
        s.h(effect, "effect");
        this.realFilterId = realFilterId;
        this.filterPath = filterPath;
    }

    public final String getFilterPath() {
        return this.filterPath;
    }

    public final String getRealFilterId() {
        return this.realFilterId;
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Texture getTexture(Effect.Version version) {
        RuntimeException e2;
        Texture texture;
        s.h(version, "version");
        FilterParamsTable effectBean = getEffectBean(version);
        if (TextUtils.isEmpty(effectBean.getTextureStr())) {
            return null;
        }
        try {
            texture = (Texture) GsonUtilKt.getCachedGson().j(effectBean.getTextureStr(), Texture.class);
            if (texture != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(t.b(getPackageMd5(), this.realFilterId));
                    sb.append(this.filterPath);
                    String str = File.separator;
                    sb.append((Object) str);
                    sb.append(TextUtils.isEmpty(effectBean.getVersionDir()) ? "" : s.q(effectBean.getVersionDir(), str));
                    texture.textureDir = sb.toString();
                } catch (RuntimeException e3) {
                    e2 = e3;
                    a.e(s.q("Construct Texture object with texture string fail! string: ", effectBean.getTextureStr()), new Object[0]);
                    a.f(e2);
                    return texture;
                }
            }
        } catch (RuntimeException e4) {
            e2 = e4;
            texture = null;
        }
        return texture;
    }
}
