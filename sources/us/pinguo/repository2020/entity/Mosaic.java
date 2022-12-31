package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Mosaic.kt */
/* loaded from: classes6.dex */
public final class Mosaic extends PaintMaterial implements NoProguard {
    public Mosaic() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ Mosaic(String str, String str2, String str3, Long l2, Long l3, Integer num, String str4, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : l2, (i2 & 16) != 0 ? null : l3, (i2 & 32) != 0 ? 0 : num, (i2 & 64) != 0 ? null : str4);
    }

    public Mosaic(String str, String str2, String str3, Long l2, Long l3, Integer num, String str4) {
        super(str, str2, str3, l2, l3, num, str4);
    }
}
