package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.o;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public enum SoftSkinParam {
    SOFT_SKIN("softskin", 0.0f, 2, null),
    SKIN_WHITE("skinwhite", 0.0f, 2, null),
    WHITE_TOOTH("whitetooth", 0.0f, 2, null),
    SHARPEN("shapen", 0.0f, 2, null),
    SMOOTH("smooth", 0.0f, 2, null),
    YU_WEI_WEN("yuweiwen", 0.0f, 2, null),
    YAN_DAI("yandai", 0.0f, 2, null),
    FA_LING_WEN("falingwen", 0.0f, 2, null),
    CHUN_WEN("chunwen", 0.0f, 2, null),
    HEI_YAN_QUAN("heiyanquan", 0.0f, 2, null),
    LIANG_YAN("liangyan", 0.0f, 2, null),
    SHUANG_XIA_BA("shuangxiaba", 0.0f, 2, null),
    YUN_FU("yunfu", 0.0f, 2, null),
    MO_PI("mopi", 0.0f, 2, null),
    JI_LI("jili", 0.0f, 2, null),
    QU_BAN("quban", 0.0f, 2, null),
    FU_SE("pifusewen", 0.0f, 2, null),
    HONG_XUE_SI("hongxuesi", 0.0f, 2, null),
    QU_HUANG("fuse", 0.0f, 2, null),
    GAO_GUANG("gaoguang", 0.0f, 2, null),
    YIN_YING("yinying", 0.0f, 2, null),
    BAI_YA("baiya", 0.0f, 2, null),
    YOU_GUANG("youguang", 0.0f, 2, null),
    MEI_BAI("meibai", 0.0f, 2, null),
    QI_SE("qise", 0.0f, 2, null),
    TI_LIANG("tiliang", 0.0f, 2, null),
    JIA_SHEN("jiashen", 0.0f, 2, null),
    QU_ZHOU_WEN("quzhouwen", 0.0f, 2, null),
    QU_DOU("qudou", 0.0f, 2, null),
    QU_HEITOU("quheitou", 0.0f, 2, null),
    YA_GUANG("yaguang", 0.0f, 2, null),
    ZENG_SE("zengse", 0.0f, 2, null),
    XI_JIE("jiegoutuchu", 0.0f, 2, null),
    LIANG_BAI("liangbai", 0.0f, 2, null),
    FU_SE_MEI_BAI("xiangyabai", 0.0f, 2, null),
    ZI_RAN_BAI("ziran", 0.0f, 2, null),
    FEN_BAI("fennen", 0.0f, 2, null),
    GU_TONG("gutong", 0.0f, 2, null),
    QIAO_KE_LI("heimei", 0.0f, 2, null);
    
    private final String key;
    private float value;

    SoftSkinParam(String str, float f2) {
        this.key = str;
        this.value = f2;
    }

    public final String getKey() {
        return this.key;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f2) {
        this.value = f2;
    }

    /* synthetic */ SoftSkinParam(String str, float f2, int i2, o oVar) {
        this(str, (i2 & 2) != 0 ? 0.0f : f2);
    }
}
