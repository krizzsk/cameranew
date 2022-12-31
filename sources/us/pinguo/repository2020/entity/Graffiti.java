package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Graffiti.kt */
/* loaded from: classes6.dex */
public final class Graffiti extends PaintMaterial implements NoProguard {
    public /* synthetic */ Graffiti(String str, String str2, String str3, Long l2, Long l3, Integer num, String str4, int i2, o oVar) {
        this(str, str2, str3, l2, l3, (i2 & 32) != 0 ? 0 : num, str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Graffiti(String str, String str2, String str3, Long l2, Long l3, Integer num, String down_url) {
        super(str, str2, str3, l2, l3, num, down_url);
        s.h(down_url, "down_url");
    }
}
