package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.o;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public enum MakeupFixParam {
    FACE_HIGHLIGHT("facehightlight", 0.0f, 2, null),
    FACE_SHADOW("faceshadowlight", 0.0f, 2, null),
    BLUSHER("faceblusher", 0.0f, 2, null),
    LIP("lip", 0.0f, 2, null),
    EYEBROW("eyebrow", 0.0f, 2, null),
    EYE_SHADOW("eyeshadow", 0.0f, 2, null);
    
    private final String key;
    private float value;

    MakeupFixParam(String str, float f2) {
        this.key = str;
        this.value = f2;
    }

    public final String getKey$u3dengine_release() {
        return this.key;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f2) {
        this.value = f2;
    }

    /* synthetic */ MakeupFixParam(String str, float f2, int i2, o oVar) {
        this(str, (i2 & 2) != 0 ? 0.0f : f2);
    }
}
