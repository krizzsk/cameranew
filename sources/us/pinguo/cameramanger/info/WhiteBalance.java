package us.pinguo.cameramanger.info;

import kotlin.NoWhenBranchMatchedException;
/* compiled from: CameraEnum.kt */
/* loaded from: classes4.dex */
public enum WhiteBalance {
    AUTO,
    INCANDESCENT,
    FLUORESCENT,
    WARM_FLUORESCENT,
    DAYLIGHT,
    CLOUDY_DAYLIGHT,
    TWILIGHT,
    SHADE;

    /* compiled from: CameraEnum.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WhiteBalance.values().length];
            iArr[WhiteBalance.AUTO.ordinal()] = 1;
            iArr[WhiteBalance.INCANDESCENT.ordinal()] = 2;
            iArr[WhiteBalance.FLUORESCENT.ordinal()] = 3;
            iArr[WhiteBalance.WARM_FLUORESCENT.ordinal()] = 4;
            iArr[WhiteBalance.DAYLIGHT.ordinal()] = 5;
            iArr[WhiteBalance.CLOUDY_DAYLIGHT.ordinal()] = 6;
            iArr[WhiteBalance.TWILIGHT.ordinal()] = 7;
            iArr[WhiteBalance.SHADE.ordinal()] = 8;
            a = iArr;
        }
    }

    public final String toCamera1Param$camera_manager_release() {
        switch (a.a[ordinal()]) {
            case 1:
                return "auto";
            case 2:
                return "incandescent";
            case 3:
                return "fluorescent";
            case 4:
                return "warm-fluorescent";
            case 5:
                return "daylight";
            case 6:
                return "cloudy-daylight";
            case 7:
                return "twilight";
            case 8:
                return "shade";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
