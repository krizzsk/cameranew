package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BeautyParam.kt */
/* loaded from: classes6.dex */
public final class BeautyParam implements NoProguard {
    private BeautyValue[] shapes;
    private BeautyValue[] skins;

    public BeautyParam(BeautyValue[] beautyValueArr, BeautyValue[] beautyValueArr2) {
        this.skins = beautyValueArr;
        this.shapes = beautyValueArr2;
    }

    public static /* synthetic */ BeautyParam copy$default(BeautyParam beautyParam, BeautyValue[] beautyValueArr, BeautyValue[] beautyValueArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            beautyValueArr = beautyParam.skins;
        }
        if ((i2 & 2) != 0) {
            beautyValueArr2 = beautyParam.shapes;
        }
        return beautyParam.copy(beautyValueArr, beautyValueArr2);
    }

    public final BeautyValue[] component1() {
        return this.skins;
    }

    public final BeautyValue[] component2() {
        return this.shapes;
    }

    public final BeautyParam copy(BeautyValue[] beautyValueArr, BeautyValue[] beautyValueArr2) {
        return new BeautyParam(beautyValueArr, beautyValueArr2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BeautyParam) {
            BeautyParam beautyParam = (BeautyParam) obj;
            return s.c(this.skins, beautyParam.skins) && s.c(this.shapes, beautyParam.shapes);
        }
        return false;
    }

    public final BeautyValue[] getShapes() {
        return this.shapes;
    }

    public final BeautyValue[] getSkins() {
        return this.skins;
    }

    public int hashCode() {
        BeautyValue[] beautyValueArr = this.skins;
        int hashCode = (beautyValueArr == null ? 0 : Arrays.hashCode(beautyValueArr)) * 31;
        BeautyValue[] beautyValueArr2 = this.shapes;
        return hashCode + (beautyValueArr2 != null ? Arrays.hashCode(beautyValueArr2) : 0);
    }

    public final void setShapes(BeautyValue[] beautyValueArr) {
        this.shapes = beautyValueArr;
    }

    public final void setSkins(BeautyValue[] beautyValueArr) {
        this.skins = beautyValueArr;
    }

    public String toString() {
        return "BeautyParam(skins=" + Arrays.toString(this.skins) + ", shapes=" + Arrays.toString(this.shapes) + ')';
    }
}
