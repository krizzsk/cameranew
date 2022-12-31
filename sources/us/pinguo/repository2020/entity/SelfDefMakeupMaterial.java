package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public class SelfDefMakeupMaterial extends Material implements NoProguard {
    private String hex;

    public /* synthetic */ SelfDefMakeupMaterial(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num, int i2, o oVar) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : str4, l2, l3, num);
    }

    public String getHex() {
        boolean C;
        String str;
        String str2 = this.hex;
        if (str2 == null || str2.length() == 0) {
            str = Material.HEX_DEFAULT;
        } else {
            String str3 = this.hex;
            s.e(str3);
            C = StringsKt__StringsKt.C(str3, "#", false, 2, null);
            if (C) {
                String str4 = this.hex;
                s.e(str4);
                str = t.v(str4, "#", "", false, 4, null);
            } else {
                str = this.hex;
            }
        }
        try {
            android.graphics.Color.parseColor(s.q("#", str));
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return Material.HEX_DEFAULT;
        }
    }

    public void setHex(String str) {
        this.hex = str;
    }

    public SelfDefMakeupMaterial(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num) {
        super(str, str2, str3, str4, l2, l3, num);
    }
}
