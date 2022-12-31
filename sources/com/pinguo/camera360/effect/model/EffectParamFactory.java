package com.pinguo.camera360.effect.model;

import us.pinguo.common.log.a;
/* loaded from: classes3.dex */
public class EffectParamFactory {
    public static String getSmartSubParamByContext(int i2, int i3) {
        a.d("AutoEffectProcessor", "contextId:" + i2 + ",lightId:" + i3, new Object[0]);
        String str = "C360_EasyCamera_Other_PSN";
        if (i2 == 0) {
            if (i3 != 0) {
                if (i3 == 1) {
                    str = "C360_EasyCamera_Other_PB";
                } else if (i3 == 2 || i3 == 3) {
                    str = "C360_EasyCamera_Other_PL";
                }
            }
            str = "C360_EasyCamera_Other_PN";
        } else if (i2 == 1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    str = "C360_EasyCamera_Other_SB";
                } else if (i3 == 2) {
                    str = "C360_EasyCamera_Other_SE";
                } else if (i3 == 3) {
                    str = "C360_EasyCamera_Other_SL";
                }
            }
            str = "C360_EasyCamera_Other_SN";
        } else if (i2 != 2) {
            str = null;
        } else if (i3 != 0) {
            if (i3 == 1) {
                str = "C360_EasyCamera_Other_PSB";
            } else if (i3 == 2 || i3 == 3) {
                str = "C360_EasyCamera_Other_PSL";
            }
        }
        a.d("AutoEffectProcessor", "the effect is:" + str, new Object[0]);
        return str;
    }

    public static boolean isAutoEffect(String str) {
        return "C360_EasyCamera_Other_PSN".equals(str) || "C360_EasyCamera_Other_PSL".equals(str) || "C360_EasyCamera_Other_PSB".equals(str) || "C360_EasyCamera_Other_SN".equals(str) || "C360_EasyCamera_Other_SB".equals(str) || "C360_EasyCamera_Other_SE".equals(str) || "C360_EasyCamera_Other_SL".equals(str) || "C360_EasyCamera_Other_PN".equals(str) || "C360_EasyCamera_Other_PB".equals(str) || "C360_EasyCamera_Other_PL".equals(str);
    }
}
