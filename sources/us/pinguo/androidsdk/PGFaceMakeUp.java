package us.pinguo.androidsdk;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes3.dex */
public class PGFaceMakeUp {
    private long _make_up_pinter;

    /* loaded from: classes3.dex */
    public static class PGMakeUpPoint {
        public int x;
        public int y;

        public PGMakeUpPoint() {
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int i2) {
            this.x = i2;
        }

        public void setXY(int i2, int i3) {
            this.x = i2;
            this.y = i3;
        }

        public void setY(int i2) {
            this.y = i2;
        }

        public String toString() {
            return this.x + "," + this.y;
        }

        public PGMakeUpPoint(int i2, int i3) {
            setXY(i2, i3);
        }
    }

    public void cleanAction() {
    }

    public void cleanFaceAnce(Bitmap bitmap) {
    }

    public void cleanFaceAnce(String str, String str2, int i2) {
    }

    public void destroyMakeUp() {
        cleanAction();
    }

    public void drawMakeUp(Bitmap bitmap) {
    }

    public void drawMakeUp(String str, String str2, int i2) {
    }

    public void drawMakeUpWithCleanAnce(String str, String str2, int i2) {
    }

    public void initFaceMakeUp(List<PGMakeUpPoint> list, List<PGMakeUpPoint> list2, List<PGMakeUpPoint> list3) {
        int i2 = list.get(0).x;
        int i3 = list.get(0).y;
        int i4 = list.get(1).x;
        int i5 = list.get(1).y;
        int i6 = list.get(2).x;
        int i7 = list.get(2).y;
        int i8 = list.get(3).x;
        int i9 = list.get(3).y;
        int i10 = list.get(4).x;
        int i11 = list.get(4).y;
        int i12 = list.get(5).x;
        int i13 = list.get(5).y;
        int i14 = list.get(6).x;
        int i15 = list.get(6).y;
        int i16 = list.get(7).x;
        int i17 = list.get(7).y;
        int i18 = list2.get(0).x;
        int i19 = list2.get(0).y;
        int i20 = list2.get(1).x;
        int i21 = list2.get(1).y;
        int i22 = list2.get(2).x;
        int i23 = list2.get(2).y;
        int i24 = list2.get(3).x;
        int i25 = list2.get(3).y;
        int i26 = list2.get(4).x;
        int i27 = list2.get(4).y;
        int i28 = list2.get(5).x;
        int i29 = list2.get(5).y;
        int i30 = list2.get(6).x;
        int i31 = list2.get(6).y;
        int i32 = list2.get(7).x;
        int i33 = list2.get(7).y;
        int i34 = list3.get(0).x;
        int i35 = list3.get(0).y;
        int i36 = list3.get(1).x;
        int i37 = list3.get(1).y;
        int i38 = list3.get(2).x;
        int i39 = list3.get(2).y;
        int i40 = list3.get(3).x;
        int i41 = list3.get(3).y;
        int i42 = list3.get(4).x;
        int i43 = list3.get(4).y;
        int i44 = list3.get(5).x;
        int i45 = list3.get(5).y;
        int i46 = list3.get(6).x;
        int i47 = list3.get(6).y;
        int i48 = list3.get(7).x;
        int i49 = list3.get(7).y;
        int i50 = list3.get(8).x;
        int i51 = list3.get(8).y;
        int i52 = list3.get(9).x;
        int i53 = list3.get(9).y;
        int i54 = list3.get(10).x;
        int i55 = list3.get(10).y;
        int i56 = list3.get(11).x;
        int i57 = list3.get(11).x;
    }

    public void setAncePosition(int i2, int i3, int i4) {
    }

    public void setBeautifulPupil(int i2, int i3, int i4, float f2, boolean z, float f3) {
    }

    public void setBigEye(float f2) {
    }

    public void setBlackEye(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4, PGMakeUpPoint pGMakeUpPoint5, PGMakeUpPoint pGMakeUpPoint6, float f2) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
        int i10 = pGMakeUpPoint5.x;
        int i11 = pGMakeUpPoint5.y;
        int i12 = pGMakeUpPoint6.x;
        int i13 = pGMakeUpPoint6.y;
    }

    public void setEyeDownLash(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
    }

    public void setEyeDownLine(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
    }

    public void setEyeShadow(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4, PGMakeUpPoint pGMakeUpPoint5, PGMakeUpPoint pGMakeUpPoint6, PGMakeUpPoint pGMakeUpPoint7) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
        int i10 = pGMakeUpPoint5.x;
        int i11 = pGMakeUpPoint5.y;
        int i12 = pGMakeUpPoint6.x;
        int i13 = pGMakeUpPoint6.y;
        int i14 = pGMakeUpPoint7.x;
        int i15 = pGMakeUpPoint7.y;
    }

    public void setEyeUpLash(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
    }

    public void setEyeUpLine(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
    }

    public void setFaceBlush(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4, PGMakeUpPoint pGMakeUpPoint5, PGMakeUpPoint pGMakeUpPoint6) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
        int i10 = pGMakeUpPoint5.x;
        int i11 = pGMakeUpPoint5.y;
        int i12 = pGMakeUpPoint6.x;
        int i13 = pGMakeUpPoint6.y;
    }

    public void setLipstickWithTooth(int i2, int i3, int i4, float f2, boolean z, float f3) {
    }

    public void setNoseLightShadow(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4, PGMakeUpPoint pGMakeUpPoint5, PGMakeUpPoint pGMakeUpPoint6, float f2) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
        int i10 = pGMakeUpPoint5.x;
        int i11 = pGMakeUpPoint5.y;
        int i12 = pGMakeUpPoint6.x;
        int i13 = pGMakeUpPoint6.y;
    }

    public void setNoseShadow(String str, PGMakeUpPoint pGMakeUpPoint, PGMakeUpPoint pGMakeUpPoint2, PGMakeUpPoint pGMakeUpPoint3, PGMakeUpPoint pGMakeUpPoint4, PGMakeUpPoint pGMakeUpPoint5, PGMakeUpPoint pGMakeUpPoint6, float f2) {
        int i2 = pGMakeUpPoint.x;
        int i3 = pGMakeUpPoint.y;
        int i4 = pGMakeUpPoint2.x;
        int i5 = pGMakeUpPoint2.y;
        int i6 = pGMakeUpPoint3.x;
        int i7 = pGMakeUpPoint3.y;
        int i8 = pGMakeUpPoint4.x;
        int i9 = pGMakeUpPoint4.y;
        int i10 = pGMakeUpPoint5.x;
        int i11 = pGMakeUpPoint5.y;
        int i12 = pGMakeUpPoint6.x;
        int i13 = pGMakeUpPoint6.y;
    }
}
