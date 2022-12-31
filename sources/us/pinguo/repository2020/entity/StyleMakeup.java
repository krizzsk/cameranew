package us.pinguo.repository2020.entity;

import com.pinguo.camera360.abtest.Plan;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StyleMakeup.kt */
/* loaded from: classes6.dex */
public final class StyleMakeup extends Material implements NoProguard {
    public static final int CAMERA_FILTER_DEFAULT_VALUE = 60;
    public static final int CAMERA_SKIN_WHITE_DEFAULT_VALUE = 0;
    public static final int CAMERA_STYLEMAKEUP_DEFAULT_VALUE = 80;
    public static final Companion Companion = new Companion(null);
    public static final int EDIT_FILTER_DEFAULT_VALUE = 50;
    public static final int EDIT_SKIN_WHITE_DEFAULT_VALUE = 0;
    public static final int EDIT_STYLEMAKEUP_DEFAULT_VALUE = 80;
    private transient Integer[] editFilterCurrentValues;
    private transient Integer[] editFilterLastValues;
    private transient Integer[] editMakeupCurrentValues;
    private transient Integer[] editMakeupLastValues;
    private transient Integer filterCurrentValue;
    private transient Integer filterDefaultValue;
    private transient Integer filterLayer;
    private final String hex;
    private Plan icon_ab;
    private transient Integer isRenderFilter;
    private transient Integer makeupCurrentValue;
    private transient Integer makeupDefaultValue;
    private transient Integer skinWhiteDefaultValue;
    private final Integer tagContent;
    private final Long tagOffTime;
    private final Long tagOnTime;

    /* compiled from: StyleMakeup.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public /* synthetic */ StyleMakeup(String str, String str2, String str3, Long l2, Long l3, Integer num, Integer num2, Long l4, Long l5, int i2, o oVar) {
        this(str, str2, str3, l2, l3, (i2 & 32) != 0 ? 0 : num, (i2 & 64) != 0 ? 0 : num2, (i2 & 128) != 0 ? 0L : l4, (i2 & 256) != 0 ? 0L : l5);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof StyleMakeup)) {
            if (this == obj || s.c(getPid(), ((StyleMakeup) obj).getPid())) {
                return true;
            }
            return super.equals(obj);
        }
        return false;
    }

    public final Integer[] getEditFilterCurrentValues() {
        return this.editFilterCurrentValues;
    }

    public final Integer[] getEditFilterLastValues() {
        return this.editFilterLastValues;
    }

    public final Integer[] getEditMakeupCurrentValues() {
        return this.editMakeupCurrentValues;
    }

    public final Integer[] getEditMakeupLastValues() {
        return this.editMakeupLastValues;
    }

    public final Integer getFilterCurrentValue() {
        return this.filterCurrentValue;
    }

    public final Integer getFilterDefaultValue() {
        return this.filterDefaultValue;
    }

    public final Integer getFilterLayer() {
        return this.filterLayer;
    }

    public final String getHex() {
        boolean C;
        String v;
        String str = this.hex;
        boolean z = str == null || str.length() == 0;
        String str2 = Material.HEX_TRANSPARENT;
        if (z) {
            v = this.editMakeupCurrentValues == null ? Material.HEX_TRANSPARENT : Material.HEX_DEFAULT;
        } else {
            C = StringsKt__StringsKt.C(this.hex, "#", false, 2, null);
            v = C ? t.v(this.hex, "#", "", false, 4, null) : this.hex;
        }
        try {
            android.graphics.Color.parseColor(s.q("#", v));
            return v;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.editMakeupCurrentValues != null) {
                str2 = Material.HEX_DEFAULT;
            }
            return str2;
        }
    }

    public final Plan getIcon_ab() {
        return this.icon_ab;
    }

    public final Integer getMakeupCurrentValue() {
        return this.makeupCurrentValue;
    }

    public final Integer getMakeupDefaultValue() {
        return this.makeupDefaultValue;
    }

    public final Integer getSkinWhiteDefaultValue() {
        return this.skinWhiteDefaultValue;
    }

    public final Integer getTagContent() {
        return this.tagContent;
    }

    public final Long getTagOffTime() {
        return this.tagOffTime;
    }

    public final Long getTagOnTime() {
        return this.tagOnTime;
    }

    public final boolean isFreeLabelVisible() {
        Integer num = this.tagContent;
        int ordinal = OperationLabel.LABEL_FREE.ordinal();
        if (num != null && num.intValue() == ordinal) {
            Long l2 = this.tagOnTime;
            long longValue = l2 == null ? 0L : l2.longValue();
            Long l3 = this.tagOffTime;
            long longValue2 = l3 != null ? l3.longValue() : 0L;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (longValue <= currentTimeMillis && currentTimeMillis <= longValue2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHotLabelVisible() {
        Integer num = this.tagContent;
        int ordinal = OperationLabel.LABEL_HOT.ordinal();
        if (num != null && num.intValue() == ordinal) {
            Long l2 = this.tagOnTime;
            long longValue = l2 == null ? 0L : l2.longValue();
            Long l3 = this.tagOffTime;
            long longValue2 = l3 != null ? l3.longValue() : 0L;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (longValue <= currentTimeMillis && currentTimeMillis <= longValue2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNewLabelVisible() {
        Integer num = this.tagContent;
        int ordinal = OperationLabel.LABEL_NEW.ordinal();
        if (num != null && num.intValue() == ordinal) {
            Long l2 = this.tagOnTime;
            long longValue = l2 == null ? 0L : l2.longValue();
            Long l3 = this.tagOffTime;
            long longValue2 = l3 != null ? l3.longValue() : 0L;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (longValue <= currentTimeMillis && currentTimeMillis <= longValue2) {
                return true;
            }
        }
        return false;
    }

    public final Integer isRenderFilter() {
        return this.isRenderFilter;
    }

    public final boolean isVipLabelVisible() {
        Integer vip = getVip();
        return (vip == null || vip.intValue() != 1 || isFreeLabelVisible()) ? false : true;
    }

    public final void setEditFilterCurrentValues(Integer[] numArr) {
        this.editFilterCurrentValues = numArr;
    }

    public final void setEditFilterLastValues(Integer[] numArr) {
        this.editFilterLastValues = numArr;
    }

    public final void setEditMakeupCurrentValues(Integer[] numArr) {
        this.editMakeupCurrentValues = numArr;
    }

    public final void setEditMakeupLastValues(Integer[] numArr) {
        this.editMakeupLastValues = numArr;
    }

    public final void setFilterCurrentValue(Integer num) {
        this.filterCurrentValue = num;
    }

    public final void setFilterDefaultValue(Integer num) {
        this.filterDefaultValue = num;
    }

    public final void setFilterLayer(Integer num) {
        this.filterLayer = num;
    }

    public final void setIcon_ab(Plan plan) {
        this.icon_ab = plan;
    }

    public final void setMakeupCurrentValue(Integer num) {
        this.makeupCurrentValue = num;
    }

    public final void setMakeupDefaultValue(Integer num) {
        this.makeupDefaultValue = num;
    }

    public final void setRenderFilter(Integer num) {
        this.isRenderFilter = num;
    }

    public final void setSkinWhiteDefaultValue(Integer num) {
        this.skinWhiteDefaultValue = num;
    }

    public StyleMakeup(String str, String str2, String str3, Long l2, Long l3, Integer num, Integer num2, Long l4, Long l5) {
        super(str, str2, str3, null, l2, l3, num);
        this.tagContent = num2;
        this.tagOnTime = l4;
        this.tagOffTime = l5;
    }
}
