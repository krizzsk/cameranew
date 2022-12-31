package us.pinguo.androidsdk;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class PGPortraitEditorMakeupParam {
    public int EyeModifyDstPosX;
    public int EyeModifyDstPosY;
    public int EyeModifySrcPosX;
    public int EyeModifySrcPosY;
    public FoundationParam Foundation = new FoundationParam();
    public EyeEditParam EyeShadow = new EyeEditParam();
    public EyeEditParam EyeLine = new EyeEditParam();
    public EyeEditParam EyeLash = new EyeEditParam();
    public BlushEditParam Blush = new BlushEditParam();
    public PupilEditParam Pupil = new PupilEditParam();
    public MouthEditorParam Mouth = new MouthEditorParam();

    /* loaded from: classes3.dex */
    public class BlushEditParam {
        public boolean bEnable;
        public float fStrength;
        public int iB;
        public int iG;
        public int iR;
        public Bitmap pMaskTextureData;

        public BlushEditParam() {
        }
    }

    /* loaded from: classes3.dex */
    public class EyeEditParam {
        public boolean bEnable;
        public float fStrength;
        public Bitmap pLeftTextureData;
        public Bitmap pRightTextureData;

        public EyeEditParam() {
        }
    }

    /* loaded from: classes3.dex */
    public class FoundationParam {
        public boolean bEnable;
        public float fStrength;
        public int iColorB;
        public int iColorG;
        public int iColorR;

        public FoundationParam() {
        }
    }

    /* loaded from: classes3.dex */
    public class MouthEditorParam {
        public boolean bEnable;
        public float fStrength;
        public int iB;
        public int iG;
        public int iR;
        public int iType;

        public MouthEditorParam() {
        }
    }

    /* loaded from: classes3.dex */
    public class PupilEditParam {
        public boolean bEnable;
        public boolean bRotateChange;
        public float fStrength;
        public int iBlendType;
        public int iInitialOpcity;
        public int iInnerRadius;
        public int iOutRadius;
        public Bitmap pMaterialImageData;
        public Bitmap pMaterialMaskData;

        public PupilEditParam() {
        }
    }
}
