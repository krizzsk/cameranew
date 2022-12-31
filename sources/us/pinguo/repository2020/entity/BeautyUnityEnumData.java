package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.Facial3dType;
import us.pinguo.u3dengine.api.MakeupType;
import us.pinguo.u3dengine.api.SoftSkinParam;
/* compiled from: BeautyUnityEnumData.kt */
/* loaded from: classes6.dex */
public final class BeautyUnityEnumData implements NoProguard {
    private DeformationParam deformationParam;
    private Facial3dType facial3d;
    private MakeupType makeupType;
    private SoftSkinParam softSkinParam;

    public BeautyUnityEnumData() {
        this(null, null, null, null, 15, null);
    }

    public BeautyUnityEnumData(SoftSkinParam softSkinParam, DeformationParam deformationParam, MakeupType makeupType, Facial3dType facial3dType) {
        this.softSkinParam = softSkinParam;
        this.deformationParam = deformationParam;
        this.makeupType = makeupType;
        this.facial3d = facial3dType;
    }

    public static /* synthetic */ BeautyUnityEnumData copy$default(BeautyUnityEnumData beautyUnityEnumData, SoftSkinParam softSkinParam, DeformationParam deformationParam, MakeupType makeupType, Facial3dType facial3dType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            softSkinParam = beautyUnityEnumData.softSkinParam;
        }
        if ((i2 & 2) != 0) {
            deformationParam = beautyUnityEnumData.deformationParam;
        }
        if ((i2 & 4) != 0) {
            makeupType = beautyUnityEnumData.makeupType;
        }
        if ((i2 & 8) != 0) {
            facial3dType = beautyUnityEnumData.facial3d;
        }
        return beautyUnityEnumData.copy(softSkinParam, deformationParam, makeupType, facial3dType);
    }

    public final SoftSkinParam component1() {
        return this.softSkinParam;
    }

    public final DeformationParam component2() {
        return this.deformationParam;
    }

    public final MakeupType component3() {
        return this.makeupType;
    }

    public final Facial3dType component4() {
        return this.facial3d;
    }

    public final BeautyUnityEnumData copy(SoftSkinParam softSkinParam, DeformationParam deformationParam, MakeupType makeupType, Facial3dType facial3dType) {
        return new BeautyUnityEnumData(softSkinParam, deformationParam, makeupType, facial3dType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BeautyUnityEnumData) {
            BeautyUnityEnumData beautyUnityEnumData = (BeautyUnityEnumData) obj;
            return this.softSkinParam == beautyUnityEnumData.softSkinParam && this.deformationParam == beautyUnityEnumData.deformationParam && this.makeupType == beautyUnityEnumData.makeupType && this.facial3d == beautyUnityEnumData.facial3d;
        }
        return false;
    }

    public final DeformationParam getDeformationParam() {
        return this.deformationParam;
    }

    public final Facial3dType getFacial3d() {
        return this.facial3d;
    }

    public final MakeupType getMakeupType() {
        return this.makeupType;
    }

    public final SoftSkinParam getSoftSkinParam() {
        return this.softSkinParam;
    }

    public int hashCode() {
        SoftSkinParam softSkinParam = this.softSkinParam;
        int hashCode = (softSkinParam == null ? 0 : softSkinParam.hashCode()) * 31;
        DeformationParam deformationParam = this.deformationParam;
        int hashCode2 = (hashCode + (deformationParam == null ? 0 : deformationParam.hashCode())) * 31;
        MakeupType makeupType = this.makeupType;
        int hashCode3 = (hashCode2 + (makeupType == null ? 0 : makeupType.hashCode())) * 31;
        Facial3dType facial3dType = this.facial3d;
        return hashCode3 + (facial3dType != null ? facial3dType.hashCode() : 0);
    }

    public final void setDeformationParam(DeformationParam deformationParam) {
        this.deformationParam = deformationParam;
    }

    public final void setFacial3d(Facial3dType facial3dType) {
        this.facial3d = facial3dType;
    }

    public final void setMakeupType(MakeupType makeupType) {
        this.makeupType = makeupType;
    }

    public final void setSoftSkinParam(SoftSkinParam softSkinParam) {
        this.softSkinParam = softSkinParam;
    }

    public String toString() {
        return "BeautyUnityEnumData(softSkinParam=" + this.softSkinParam + ", deformationParam=" + this.deformationParam + ", makeupType=" + this.makeupType + ", facial3d=" + this.facial3d + ')';
    }

    public /* synthetic */ BeautyUnityEnumData(SoftSkinParam softSkinParam, DeformationParam deformationParam, MakeupType makeupType, Facial3dType facial3dType, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : softSkinParam, (i2 & 2) != 0 ? null : deformationParam, (i2 & 4) != 0 ? null : makeupType, (i2 & 8) != 0 ? null : facial3dType);
    }
}
