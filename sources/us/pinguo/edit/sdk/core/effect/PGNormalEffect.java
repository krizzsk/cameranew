package us.pinguo.edit.sdk.core.effect;

import org.json.JSONObject;
import us.pinguo.edit.sdk.core.model.a;
/* loaded from: classes4.dex */
public class PGNormalEffect extends PGFilterEffect {
    @Override // us.pinguo.edit.sdk.core.effect.PGFilterEffect, us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public a buildMakeEft() {
        a aVar = new a();
        aVar.f10083e = "Normal";
        aVar.f10084f = "Normal";
        return aVar;
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGFilterEffect, us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public String buildParamJson() {
        return new JSONObject().toString();
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGFilterEffect, us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public a buildRenderEft() {
        a aVar = new a();
        aVar.f10083e = "Normal";
        aVar.f10084f = "Normal";
        return aVar;
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGFilterEffect, us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public void parseParamJson(String str) {
    }
}
