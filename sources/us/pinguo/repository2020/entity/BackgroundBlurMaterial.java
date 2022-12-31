package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public class BackgroundBlurMaterial extends Material implements NoProguard {
    public static final Companion Companion = new Companion(null);
    public static final int ERASER_OR_PEN_DEFAULT_VALUE = 40;
    private final String sid;

    /* compiled from: Blur.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public BackgroundBlurMaterial() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ BackgroundBlurMaterial(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num, String str5, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : l3, (i2 & 64) != 0 ? 0 : num, (i2 & 128) == 0 ? str5 : null);
    }

    public final String getSid() {
        return this.sid;
    }

    public BackgroundBlurMaterial(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num, String str5) {
        super(str, str4, str3, str5, l2, l3, num);
        this.sid = str2;
    }
}
