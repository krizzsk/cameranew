package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public final class BackgroundBlurShape extends BackgroundBlurMaterial implements NoProguard {
    private transient String shapeTexture;

    public BackgroundBlurShape() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ BackgroundBlurShape(String str, String str2, String str3, String str4, Integer num, Long l2, Long l3, Integer num2, Integer num3, Integer num4, String str5, String str6, Float f2, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : l2, (i2 & 64) != 0 ? null : l3, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? null : num3, (i2 & 512) != 0 ? 0 : num4, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? null : str6, (i2 & 4096) == 0 ? f2 : null);
    }

    public final String getShapeTexture() {
        return this.shapeTexture;
    }

    public final void setShapeTexture(String str) {
        this.shapeTexture = str;
    }

    public BackgroundBlurShape(String str, String str2, String str3, String str4, Integer num, Long l2, Long l3, Integer num2, Integer num3, Integer num4, String str5, String str6, Float f2) {
        super(str, str2, str3, str4, l2, l3, num4, str5);
    }
}
