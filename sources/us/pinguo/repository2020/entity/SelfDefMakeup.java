package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: SelfDefMakeup.kt */
/* loaded from: classes6.dex */
public final class SelfDefMakeup extends SelfDefMakeupMaterial implements NoProguard {
    public static final Companion Companion = new Companion(null);
    public static final int EDIT_SELFDEFMAKEUP_DEFAULT_VALUE = 80;
    private transient Integer[] editMakeupCurrentValues;
    private transient Integer[] editMakeupLastValues;
    private transient Integer makeupCurrentValue;
    private transient Integer makeupDefaultValue;
    private transient int type;

    /* compiled from: SelfDefMakeup.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public /* synthetic */ SelfDefMakeup(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num, int i2, o oVar) {
        this(str, str2, str3, str4, l2, l3, (i2 & 64) != 0 ? 0 : num);
    }

    public final Integer[] getEditMakeupCurrentValues() {
        return this.editMakeupCurrentValues;
    }

    public final Integer[] getEditMakeupLastValues() {
        return this.editMakeupLastValues;
    }

    public final Integer getMakeupCurrentValue() {
        return this.makeupCurrentValue;
    }

    public final Integer getMakeupDefaultValue() {
        return this.makeupDefaultValue;
    }

    public final int getType() {
        return this.type;
    }

    public final void setEditMakeupCurrentValues(Integer[] numArr) {
        this.editMakeupCurrentValues = numArr;
    }

    public final void setEditMakeupLastValues(Integer[] numArr) {
        this.editMakeupLastValues = numArr;
    }

    public final void setMakeupCurrentValue(Integer num) {
        this.makeupCurrentValue = num;
    }

    public final void setMakeupDefaultValue(Integer num) {
        this.makeupDefaultValue = num;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public SelfDefMakeup(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num) {
        super(str, str2, str3, str4, l2, l3, num);
    }
}
