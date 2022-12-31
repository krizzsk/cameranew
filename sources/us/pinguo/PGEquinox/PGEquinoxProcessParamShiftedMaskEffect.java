package us.pinguo.PGEquinox;
/* loaded from: classes3.dex */
public class PGEquinoxProcessParamShiftedMaskEffect extends PGEquinoxProcessParam {
    public static final String BINARY = "BINARY";
    public static final String PURE = "PURE";
    public static int SHIFTED_MASK_EFFECT_REFINE_MASK_TYPE_BINARY = 1;
    public static int SHIFTED_MASK_EFFECT_REFINE_MASK_TYPE_DEFAULT = 0;
    public static final int SHIFTED_MASK_EFFECT_TRANSFORM_MIRROR = 2;
    public static final int SHIFTED_MASK_EFFECT_TRANSFORM_RESIZE = 1;
    public static final int SHIFTED_MASK_EFFECT_TRANSFORM_SHIFT = 0;
    public static int SHIFTED_MASK_EFFECT_TYPE_BLEND = 0;
    public static int SHIFTED_MASK_EFFECT_TYPE_PURE = 1;
    public int[] color;
    public float[] shiftCoord;
    public int eEffectType = 1;
    public int eCoordType = 1;
    public boolean bColor = true;
    public int eMaskRefineType = 1;
    public boolean bMaskBoundraySmooth = true;
    public int eTransformType = 1;
    public float fGaussianBlurR = -1.0f;
}
