package us.pinguo.blockbuster;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.e;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Random;
import us.pinguo.PGEquinox.DDTMakeUpAction;
import us.pinguo.PGEquinox.MakeUpMaterial;
import us.pinguo.PGEquinox.PGEquinoxEngine;
import us.pinguo.PGEquinox.PGEquinoxProcessParam;
import us.pinguo.PGEquinox.PGEquinoxProcessParamBoundrayLight;
import us.pinguo.PGEquinox.PGEquinoxProcessParamColorShading;
import us.pinguo.PGEquinox.PGEquinoxProcessParamExpandBoundray;
import us.pinguo.PGEquinox.PGEquinoxProcessParamFilter;
import us.pinguo.PGEquinox.PGEquinoxProcessParamHairDrawing;
import us.pinguo.PGEquinox.PGEquinoxProcessParamHandleAlpha;
import us.pinguo.PGEquinox.PGEquinoxProcessParamMakeUp;
import us.pinguo.PGEquinox.PGEquinoxProcessParamMix;
import us.pinguo.PGEquinox.PGEquinoxProcessParamOneKeyBeautify;
import us.pinguo.PGEquinox.PGEquinoxProcessParamReplaceAlpha;
import us.pinguo.PGEquinox.PGEquinoxProcessParamShiftedMaskEffect;
import us.pinguo.PGEquinox.PGGLContextManager;
import us.pinguo.PGEquinox.hairParam_t;
import us.pinguo.blockbuster.lib.domain.Input;
import us.pinguo.blockbuster.lib.domain.Material;
import us.pinguo.blockbuster.lib.domain.Node;
import us.pinguo.blockbuster.lib.domain.Output;
import us.pinguo.blockbuster.lib.domain.struct.AutoBeautyStruct;
import us.pinguo.blockbuster.lib.domain.struct.BoundrayLightStruct;
import us.pinguo.blockbuster.lib.domain.struct.ColorShadingStruct;
import us.pinguo.blockbuster.lib.domain.struct.EdgeStruct;
import us.pinguo.blockbuster.lib.domain.struct.HandleAlphaStruct;
import us.pinguo.blockbuster.lib.domain.struct.ReplaceAlphaStruct;
import us.pinguo.blockbuster.lib.domain.struct.Struct;
import us.pinguo.blockbuster.lib.domain.struct.filter.FilterStruct;
import us.pinguo.blockbuster.lib.domain.struct.filter.Texture;
import us.pinguo.blockbuster.lib.domain.struct.filter.TextureItem;
import us.pinguo.blockbuster.lib.domain.struct.hair.HairParam;
import us.pinguo.blockbuster.lib.domain.struct.hair.HairStruct;
import us.pinguo.blockbuster.lib.domain.struct.makeup.ActionItem;
import us.pinguo.blockbuster.lib.domain.struct.makeup.MakeupMaterial;
import us.pinguo.blockbuster.lib.domain.struct.makeup.MakeupStruct;
import us.pinguo.blockbuster.lib.domain.struct.mix.MixStruct;
import us.pinguo.blockbuster.lib.domain.struct.mix.MixTexture;
import us.pinguo.blockbuster.lib.domain.struct.shiftedmaskeffect.ShiftedMaskEffectStruct;
import us.pinguo.common.log.a;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.util.k;
/* loaded from: classes3.dex */
public class BlockBuster {
    private static final boolean DEBUG_MIDDLE_RESULT = false;
    public static final int INVALID = 1073741823;
    private static final boolean IS_JSON_ENCRYPT = true;
    public static final int MakeResultType_ERROR = 1;
    public static final int MakeResultType_SUCCESS = 0;
    public static final int MakeResultType_USERCANCLE = 2;
    private static final int RETURN_CODE_FINISH = Integer.MAX_VALUE;
    private static final String TAG = "BlockBuster";
    public static final boolean USING_DNN_SDK = false;
    private static Random random = new Random();
    public Object input;
    private PGEquinoxEngine mEquinoxEngine;
    private PGGLContextManager mGlContext;
    private String mTmpPath;
    public String materialFolder;
    public Object output;
    public Param param;
    private volatile boolean stopMake;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Bitmap inputBitmap;
        private String inputPath;
        private String materialFolder;
        private Bitmap outputBitmap;
        private String outputPath;
        private Param param;

        public BlockBuster build() {
            BlockBuster blockBuster = new BlockBuster();
            Object obj = this.inputPath;
            if (obj == null) {
                obj = this.inputBitmap;
            }
            blockBuster.input = obj;
            Object obj2 = this.outputPath;
            if (obj2 == null) {
                obj2 = this.outputBitmap;
            }
            blockBuster.output = obj2;
            blockBuster.materialFolder = this.materialFolder;
            blockBuster.param = this.param;
            return blockBuster;
        }

        public Builder input(String str) {
            this.inputPath = str;
            return this;
        }

        public Builder materialFolder(String str) {
            this.materialFolder = str;
            return this;
        }

        public Builder output(String str) {
            this.outputPath = str;
            return this;
        }

        public Builder param(Param param) {
            this.param = param;
            return this;
        }

        public Builder input(Bitmap bitmap) {
            this.inputBitmap = bitmap;
            return this;
        }

        public Builder output(Bitmap bitmap) {
            this.outputBitmap = bitmap;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Dst {
        int pDstLeftX;
        int pDstLeftY;
        int pDstRightX;
        int pDstRightY;

        Dst(int i2, int i3, int i4, int i5) {
            this.pDstLeftX = i2;
            this.pDstLeftY = i3;
            this.pDstRightX = i4;
            this.pDstRightY = i5;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MakeResultType {
    }

    private boolean checkCancel(int i2) {
        if (this.stopMake) {
            a.k("取消作图任务,当前步骤：" + i2, new Object[0]);
            return true;
        }
        return false;
    }

    private void clearLastImages() {
        for (int i2 = 0; i2 <= 8; i2++) {
            if (!this.mEquinoxEngine.DeleteInputImage(i2)) {
                a.s("Delete index " + i2 + " failed!", new Object[0]);
            }
        }
    }

    private int[] expand2dimenIntArray(int[][] iArr) {
        int i2 = 0;
        for (int[] iArr2 : iArr) {
            i2 += iArr2.length;
        }
        int[] iArr3 = new int[i2];
        int i3 = 0;
        for (int[] iArr4 : iArr) {
            int length = iArr4.length;
            int i4 = 0;
            while (i4 < length) {
                iArr3[i3] = iArr4[i4];
                i4++;
                i3++;
            }
        }
        return iArr3;
    }

    private int getIntBlendMode(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1956628387:
                if (str.equals("BLEND_HARDLIGHT")) {
                    c = 0;
                    break;
                }
                break;
            case -1770195749:
                if (str.equals("BLEND_GLOW")) {
                    c = 1;
                    break;
                }
                break;
            case -1718234269:
                if (str.equals("BLEND_HARDMIX")) {
                    c = 2;
                    break;
                }
                break;
            case -1329467249:
                if (str.equals("BLEND_REFLECT")) {
                    c = 3;
                    break;
                }
                break;
            case -1188444558:
                if (str.equals("BLEND_MULTIPLY")) {
                    c = 4;
                    break;
                }
                break;
            case -921162829:
                if (str.equals("BLEND_NEGATION")) {
                    c = 5;
                    break;
                }
                break;
            case -745392045:
                if (str.equals("BLEND_SUBSTRACT")) {
                    c = 6;
                    break;
                }
                break;
            case -611298445:
                if (str.equals("BLEND_ADD")) {
                    c = 7;
                    break;
                }
                break;
            case -447031699:
                if (str.equals("BLEND_DARKEN")) {
                    c = '\b';
                    break;
                }
                break;
            case -147809099:
                if (str.equals("BLEND_NORMAL")) {
                    c = '\t';
                    break;
                }
                break;
            case -15753158:
                if (str.equals("BLEND_SCREEN")) {
                    c = '\n';
                    break;
                }
                break;
            case 170991780:
                if (str.equals("BLEND_LINEARDODGE")) {
                    c = 11;
                    break;
                }
                break;
            case 395140898:
                if (str.equals("BLEND_COLORDODGE")) {
                    c = '\f';
                    break;
                }
                break;
            case 410691360:
                if (str.equals("BLEND_EXCLUSION")) {
                    c = '\r';
                    break;
                }
                break;
            case 705429764:
                if (str.equals("BLEND_COLORBURN")) {
                    c = 14;
                    break;
                }
                break;
            case 788946466:
                if (str.equals("BLEND_OVERLAY")) {
                    c = 15;
                    break;
                }
                break;
            case 829355531:
                if (str.equals("BLEND_DIFFERENCE")) {
                    c = 16;
                    break;
                }
                break;
            case 952966064:
                if (str.equals("BLEND_ALPHA")) {
                    c = 17;
                    break;
                }
                break;
            case 958674046:
                if (str.equals("BLEND_SOFTLIGHT")) {
                    c = 18;
                    break;
                }
                break;
            case 1248786415:
                if (str.equals("BLEND_AVERAGE")) {
                    c = 19;
                    break;
                }
                break;
            case 1284492129:
                if (str.equals("BLEND_PHOENIX")) {
                    c = 20;
                    break;
                }
                break;
            case 2029738223:
                if (str.equals("BLEND_PINLIGHT")) {
                    c = 21;
                    break;
                }
                break;
            case 2035727398:
                if (str.equals("BLEND_VIVIDLIGHT")) {
                    c = 22;
                    break;
                }
                break;
            case 2050780689:
                if (str.equals("BLEND_LIGHTEN")) {
                    c = 23;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 14;
            case 1:
                return 22;
            case 2:
                return 20;
            case 3:
                return 21;
            case 4:
                return 4;
            case 5:
                return 9;
            case 6:
                return 7;
            case 7:
                return 6;
            case '\b':
                return 3;
            case '\t':
                return 0;
            case '\n':
                return 10;
            case 11:
                return 17;
            case '\f':
                return 15;
            case '\r':
                return 11;
            case 14:
                return 16;
            case 15:
                return 12;
            case 16:
                return 8;
            case 17:
                return 1;
            case 18:
                return 13;
            case 19:
                return 5;
            case 20:
                return 23;
            case 21:
                return 19;
            case 22:
                return 18;
            case 23:
                return 2;
            default:
                return INVALID;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getIntColorShade(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -195860545:
                if (str.equals("TOP2DOWN")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 613283414:
                if (str.equals("SHUTDOWN")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 723109573:
                if (str.equals("COLOR_SHADING_LEFT2BOTTOM")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
                return -1;
            case 2:
                return 1;
            default:
                return INVALID;
        }
    }

    private Material parse(String str) {
        return (Material) new e().j(str, Material.class);
    }

    private int parseAttachMVPType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1943089714:
                if (str.equals("RIGHT_BOTTOM")) {
                    c = 0;
                    break;
                }
                break;
            case -1792633360:
                if (str.equals("LEFT_MID")) {
                    c = 1;
                    break;
                }
                break;
            case -1787143004:
                if (str.equals("UNKNOW")) {
                    c = 2;
                    break;
                }
                break;
            case -1025888925:
                if (str.equals("LEFT_BOTTOM")) {
                    c = 3;
                    break;
                }
                break;
            case -653421634:
                if (str.equals("RIGHT_UP")) {
                    c = 4;
                    break;
                }
                break;
            case 2715:
                if (str.equals("UP")) {
                    c = 5;
                    break;
                }
                break;
            case 76328:
                if (str.equals("MID")) {
                    c = 6;
                    break;
                }
                break;
            case 148658375:
                if (str.equals("CHANGE_CANVAS")) {
                    c = 7;
                    break;
                }
                break;
            case 773457363:
                if (str.equals("LEFT_UP")) {
                    c = '\b';
                    break;
                }
                break;
            case 1218757989:
                if (str.equals("RIGHT_MID")) {
                    c = '\t';
                    break;
                }
                break;
            case 1965067819:
                if (str.equals("BOTTOM")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 9;
            case 1:
                return 5;
            case 2:
                return 0;
            case 3:
                return 6;
            case 4:
                return 7;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 10;
            case '\b':
                return 4;
            case '\t':
                return 8;
            case '\n':
                return 3;
            default:
                return INVALID;
        }
    }

    private int parseAutoBeautyOptions(String[] strArr) {
        int i2 = 0;
        for (String str : strArr) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2146363452:
                    if (str.equals("SSSO_EYE_BAG_REMOVAL")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1933993253:
                    if (str.equals("SSSO_FLW_REMOVAL")) {
                        c = 1;
                        break;
                    }
                    break;
                case 597804952:
                    if (str.equals("SSSO_BRIGHTEN_EYE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 632665216:
                    if (str.equals("SSSO_THIN_FACE")) {
                        c = 3;
                        break;
                    }
                    break;
                case 961138708:
                    if (str.equals("SSSO_SKIN_SOFTEN_ALL")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1782445487:
                    if (str.equals("SSSO_BIG_EYE")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i2 |= 2;
                    break;
                case 1:
                    i2 |= 1;
                    break;
                case 2:
                    i2 |= 16;
                    break;
                case 3:
                    i2 |= 8;
                    break;
                case 4:
                    i2 |= 69905;
                    break;
                case 5:
                    i2 |= 4;
                    break;
            }
        }
        return i2;
    }

    private int[] parseBlendMode(String[] strArr) {
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            iArr[i3] = getIntBlendMode(strArr[i2]);
            i2++;
            i3++;
        }
        return iArr;
    }

    private int parseBoundaryType(String str) {
        str.hashCode();
        return (str.equals("HARD") || !str.equals("SOFT")) ? 0 : 1;
    }

    private int parseCoordType(String str) {
        str.hashCode();
        return (str.equals("PIXEL") || !str.equals("EYELEN")) ? 0 : 1;
    }

    private int parseEOpType(String str) {
        str.hashCode();
        if (str.equals(HandleAlphaStruct.COPY_0_TO_1)) {
            return 0;
        }
        if (str.equals(HandleAlphaStruct.MULTIPLE)) {
            return 1;
        }
        return INVALID;
    }

    private int parseEShadingDirection(String str) {
        str.hashCode();
        if (str.equals("H")) {
            return 0;
        }
        if (str.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            return 1;
        }
        return INVALID;
    }

    private int parseEShadingType(String str) {
        str.hashCode();
        if (str.equals("ALPHA")) {
            return 1;
        }
        if (str.equals("FULL_IMAGE")) {
            return 0;
        }
        return INVALID;
    }

    private int parseHairStyle(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -377466177:
                if (str.equals("STYLE_LYAERED1")) {
                    c = 0;
                    break;
                }
                break;
            case -377466176:
                if (str.equals("STYLE_LYAERED2")) {
                    c = 1;
                    break;
                }
                break;
            case -377466175:
                if (str.equals("STYLE_LYAERED3")) {
                    c = 2;
                    break;
                }
                break;
            case 298211096:
                if (str.equals("STYLE_ORI")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 0;
            default:
                return INVALID;
        }
    }

    private int[] parseLayerColorShade(String[] strArr) {
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            iArr[i3] = getIntColorShade(strArr[i2]);
            i2++;
            i3++;
        }
        return iArr;
    }

    private String parseMaterialJson(String str) {
        String str2 = null;
        try {
            str2 = k.d(new File(str + File.separator + "indexX.json"));
            return DESEncrypt.decrypt(str2, DESEncrypt.ENCRYPT_PWD);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    private int parseMixEType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1390114096:
                if (str.equals("BACK_MID")) {
                    c = 0;
                    break;
                }
                break;
            case -1123185533:
                if (str.equals("BACK_BOTTOM")) {
                    c = 1;
                    break;
                }
                break;
            case 76743:
                if (str.equals("MVP")) {
                    c = 2;
                    break;
                }
                break;
            case 2030823:
                if (str.equals("BACK")) {
                    c = 3;
                    break;
                }
                break;
            case 370799859:
                if (str.equals("BACK_UP")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
                return 2;
            default:
                return INVALID;
        }
    }

    private int parseMixType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1854360468:
                if (str.equals("SCREEN")) {
                    c = 0;
                    break;
                }
                break;
            case -373305296:
                if (str.equals("OVERLAY")) {
                    c = 1;
                    break;
                }
                break;
            case 2098181:
                if (str.equals("DIFF")) {
                    c = 2;
                    break;
                }
                break;
            case 62372158:
                if (str.equals("ALPHA")) {
                    c = 3;
                    break;
                }
                break;
            case 726227724:
                if (str.equals("SOFTLIGHT")) {
                    c = 4;
                    break;
                }
                break;
            case 888528927:
                if (str.equals("LIGHTEN")) {
                    c = 5;
                    break;
                }
                break;
            case 1436456484:
                if (str.equals("MULTIPLY")) {
                    c = 6;
                    break;
                }
                break;
            case 1608851618:
                if (str.equals("UPDATE_MASK")) {
                    c = 7;
                    break;
                }
                break;
            case 2009328287:
                if (str.equals("DARKEN")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 0;
            case 4:
                return 4;
            case 5:
                return 7;
            case 6:
                return 2;
            case 7:
                return 8;
            case '\b':
                return 3;
            default:
                return INVALID;
        }
    }

    private int parseTransformType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2020581441:
                if (str.equals("MIRROR")) {
                    c = 0;
                    break;
                }
                break;
            case -1881108300:
                if (str.equals("RESIZE")) {
                    c = 1;
                    break;
                }
                break;
            case 78869602:
                if (str.equals("SHIFT")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                return INVALID;
        }
    }

    static Dst position(int i2, int i3, int i4, int i5, float f2, float f3, float f4, float f5, float f6) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0 || i5 <= 0 || f6 <= 0.0f) {
            return null;
        }
        float f7 = f2 - f4;
        float f8 = f3 - f5;
        float sqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
        float max = Math.max(i2, i3) / Math.max(i4, i5);
        float nextInt = max * ((f6 - (random.nextInt() % 10)) / (sqrt * max));
        float f9 = sqrt * nextInt;
        int i6 = (int) (i5 * nextInt);
        float f10 = (f2 + f4) * 0.5f * nextInt;
        float f11 = (f3 + f5) * 0.5f * nextInt;
        float f12 = ((int) (i4 * nextInt)) / 2;
        float f13 = i6 / 2;
        float f14 = ((i3 / 2) + f11) - f13;
        float f15 = (((i2 / 2) + f10) - f12) + (f12 - f10);
        float f16 = (f13 - f11) + f14;
        if (i6 < i3) {
            f16 = f14 + ((i3 - i6) / 2) + 6.0f;
        }
        int i7 = (int) f16;
        float f17 = (int) f15;
        float f18 = f9 / 2.0f;
        return new Dst((int) (f17 - f18), i7, (int) (f17 + f18), i7);
    }

    private int processInput(Input input, Material material) {
        if (input.type.equals("init")) {
            Object obj = this.input;
            if (obj instanceof Bitmap) {
                if (!this.mEquinoxEngine.SetInputImageByBitmap((Bitmap) obj, input.index)) {
                    return INVALID;
                }
            } else if ((obj instanceof String) && !this.mEquinoxEngine.SetInputImageByPath((String) obj, input.index)) {
                return INVALID;
            }
            return input.index;
        } else if (input.type.equals(Input.INPUT_TYPE_TEXTURE)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.materialFolder);
            sb.append(File.separator);
            sb.append(input.name);
            return !this.mEquinoxEngine.SetInputImageByPath(sb.toString(), input.index) ? INVALID : input.index;
        } else {
            if (input.type.equals(Input.INPUT_TYPE_NODE)) {
                for (Node node : material.nodes) {
                    if (node.nodeId == input.index) {
                        if (node.output.equals("file")) {
                            PGEquinoxEngine pGEquinoxEngine = this.mEquinoxEngine;
                            boolean SetInputImageByPath = pGEquinoxEngine.SetInputImageByPath(this.mTmpPath + File.separator + node.output.index + ".png", node.output.index);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SetInputImageByPath isSuc = ");
                            sb2.append(SetInputImageByPath);
                            a.d(TAG, sb2.toString(), new Object[0]);
                        }
                        return node.output.index;
                    }
                }
            }
            return input.type.equals("memory") ? input.index : INVALID;
        }
    }

    private int processOutput(Node node, Output output) {
        if (output.type.equals("file")) {
            PGEquinoxEngine pGEquinoxEngine = this.mEquinoxEngine;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mTmpPath);
            sb.append(File.separator);
            sb.append(output.index);
            sb.append(".png");
            return !pGEquinoxEngine.GetOutput2File(sb.toString(), output.index) ? INVALID : output.index;
        } else if (output.type.equals("memory")) {
            return output.index;
        } else {
            if (output.type.equals(Output.OUTPUT_TYPE_MAKED)) {
                return Integer.MAX_VALUE;
            }
            return INVALID;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamHairDrawing] */
    /* JADX WARN: Type inference failed for: r0v15, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamShiftedMaskEffect] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [us.pinguo.PGEquinox.PGEquinoxProcessParam] */
    /* JADX WARN: Type inference failed for: r3v19, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamReplaceAlpha] */
    /* JADX WARN: Type inference failed for: r3v2, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamFilter] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamExpandBoundray] */
    /* JADX WARN: Type inference failed for: r3v22, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamOneKeyBeautify] */
    /* JADX WARN: Type inference failed for: r3v23, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamColorShading] */
    /* JADX WARN: Type inference failed for: r3v24, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamHandleAlpha] */
    /* JADX WARN: Type inference failed for: r3v3, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamMakeUp] */
    /* JADX WARN: Type inference failed for: r3v4, types: [us.pinguo.PGEquinox.PGEquinoxProcessParamBoundrayLight] */
    private PGEquinoxProcessParam processParam(Struct struct) {
        PGEquinoxProcessParamMix pGEquinoxProcessParamMix;
        int i2 = 0;
        ?? r3 = 0;
        switch (struct.paramType) {
            case 0:
                r3 = new PGEquinoxProcessParamFilter();
                r3.mEffectString = ((FilterStruct) struct).effectString;
                break;
            case 1:
                PGEquinoxProcessParamMix pGEquinoxProcessParamMix2 = new PGEquinoxProcessParamMix();
                MixStruct mixStruct = (MixStruct) struct;
                int parseMixType = parseMixType(mixStruct.mixType);
                if (parseMixType != 1073741823) {
                    pGEquinoxProcessParamMix2.mixType = parseMixType;
                    pGEquinoxProcessParamMix2.srcDesignSize = mixStruct.srcDesignSize;
                    pGEquinoxProcessParamMix2.srcIndex = mixStruct.srcIndex;
                    float f2 = mixStruct.srcOpacity;
                    if (0.0f != f2) {
                        pGEquinoxProcessParamMix2.srcOpacity = f2;
                    }
                    int parseMixEType = parseMixEType(mixStruct.eType);
                    if (parseMixEType != 1073741823) {
                        pGEquinoxProcessParamMix2.eType = parseMixEType;
                        String str = mixStruct.eAttachMVPType;
                        if (str != null) {
                            int parseAttachMVPType = parseAttachMVPType(str);
                            if (parseAttachMVPType == 1073741823) {
                                return null;
                            }
                            pGEquinoxProcessParamMix2.eAttachMVPType = parseAttachMVPType;
                        }
                        pGEquinoxProcessParamMix2.srcPosition = mixStruct.srcPosition;
                        pGEquinoxProcessParamMix2.srcDesignLefteyesPos = mixStruct.srcDesignLefteyesPos;
                        pGEquinoxProcessParamMix2.srcDesignRightsPos = mixStruct.srcDesignRightsPos;
                        pGEquinoxProcessParamMix2.srcFacepp106Index = mixStruct.srcFacepp106Index;
                        pGEquinoxProcessParamMix2.srcIsChangedCanvas = mixStruct.srcIsChangedCanvas;
                        pGEquinoxProcessParamMix = pGEquinoxProcessParamMix2;
                        r3 = pGEquinoxProcessParamMix;
                        break;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            case 2:
                r3 = new PGEquinoxProcessParamMakeUp();
                MakeupStruct makeupStruct = (MakeupStruct) struct;
                r3.actions = new DDTMakeUpAction[makeupStruct.actionItems.size()];
                r3.materials = new MakeUpMaterial[makeupStruct.materials.size()];
                for (int i3 = 0; i3 < makeupStruct.actionItems.size(); i3++) {
                    ActionItem actionItem = makeupStruct.actionItems.get(i3);
                    r3.actions[i3] = new DDTMakeUpAction();
                    DDTMakeUpAction[] dDTMakeUpActionArr = r3.actions;
                    dDTMakeUpActionArr[i3].blendType = actionItem.blendType;
                    dDTMakeUpActionArr[i3].eType = actionItem.eType;
                    dDTMakeUpActionArr[i3].intensity = actionItem.intensity;
                    dDTMakeUpActionArr[i3].performStyle = actionItem.performStyle;
                    dDTMakeUpActionArr[i3].color = string2IntArray(actionItem.color);
                }
                while (i2 < makeupStruct.materials.size()) {
                    MakeupMaterial makeupMaterial = makeupStruct.materials.get(i2);
                    r3.materials[i2] = new MakeUpMaterial();
                    MakeUpMaterial[] makeUpMaterialArr = r3.materials;
                    makeUpMaterialArr[i2].eType = makeupMaterial.eType;
                    makeUpMaterialArr[i2].feature_size = string2IntArray(makeupMaterial.featureSize);
                    r3.materials[i2].features = string2FloatArray(makeupMaterial.features);
                    MakeUpMaterial makeUpMaterial = r3.materials[i2];
                    makeUpMaterial.file_path = this.materialFolder + File.separator + makeupMaterial.pImage;
                    r3.materials[i2].left_top = string2FloatArray(makeupMaterial.ltPos);
                    r3.materials[i2].slot = makeupMaterial.iSlot;
                    i2++;
                }
                break;
            case 3:
                r3 = new PGEquinoxProcessParamBoundrayLight();
                BoundrayLightStruct boundrayLightStruct = (BoundrayLightStruct) struct;
                r3.boundrayLightColor = boundrayLightStruct.boundrayLightColor;
                r3.eBoundrayType = boundrayLightStruct.geteBoundrayType();
                r3.eCoordType = boundrayLightStruct.geteCoordType();
                r3.fGaussianBlurR = boundrayLightStruct.fGaussianBlurR;
                r3.fWidth = boundrayLightStruct.fWidth;
                r3.shiftCoord = boundrayLightStruct.shiftCoord;
                r3.fRatio = boundrayLightStruct.fRatio;
                r3.fHeadRatio = boundrayLightStruct.fHeadRatio;
                r3.fTailRatio = boundrayLightStruct.fTailRatio;
                r3.fEpsilon = boundrayLightStruct.fEpsilon;
                r3.iEpsilonMax = boundrayLightStruct.iEpsilonMax;
                r3.iEpsilonMin = boundrayLightStruct.iEpsilonMin;
                break;
            case 4:
                ?? pGEquinoxProcessParamHairDrawing = new PGEquinoxProcessParamHairDrawing();
                HairStruct hairStruct = (HairStruct) struct;
                int parseHairStyle = parseHairStyle(hairStruct.hStyle);
                if (1073741823 == parseHairStyle) {
                    return null;
                }
                pGEquinoxProcessParamHairDrawing.hStyle = parseHairStyle;
                hairParam_t hairparam_t = new hairParam_t();
                pGEquinoxProcessParamHairDrawing.param = hairparam_t;
                HairParam hairParam = hairStruct.hairParam_t;
                hairparam_t.bSmear = hairParam.bSmear;
                hairparam_t.hStyle = pGEquinoxProcessParamHairDrawing.hStyle;
                hairparam_t.layerBlendAlpha = hairParam.layerBlendAlpha;
                int[] parseBlendMode = parseBlendMode(hairParam.layerBlendMode);
                if (parseBlendMode == null) {
                    return null;
                }
                hairParam_t hairparam_t2 = pGEquinoxProcessParamHairDrawing.param;
                hairparam_t2.layerBlendMode = parseBlendMode;
                hairparam_t2.layerColor = expand2dimenIntArray(hairStruct.hairParam_t.layerColor);
                hairParam_t hairparam_t3 = pGEquinoxProcessParamHairDrawing.param;
                HairParam hairParam2 = hairStruct.hairParam_t;
                hairparam_t3.layerPixelsRatio = hairParam2.layerPixelsRatio;
                hairparam_t3.layerLinesDensity = hairParam2.layerLinesDensity;
                hairparam_t3.layerLineWidth = hairParam2.layerLineWidth;
                hairparam_t3.layerColorUp = expand2dimenIntArray(hairParam2.layerColorUp);
                pGEquinoxProcessParamHairDrawing.param.layerColorDown = expand2dimenIntArray(hairStruct.hairParam_t.layerColorDown);
                while (true) {
                    HairParam hairParam3 = hairStruct.hairParam_t;
                    String[] strArr = hairParam3.layerTemplate;
                    if (i2 >= strArr.length) {
                        hairParam_t hairparam_t4 = pGEquinoxProcessParamHairDrawing.param;
                        hairparam_t4.layerTemplate = strArr;
                        hairparam_t4.layerColorShade = parseLayerColorShade(hairParam3.layerColorShade);
                        hairParam_t hairparam_t5 = pGEquinoxProcessParamHairDrawing.param;
                        HairParam hairParam4 = hairStruct.hairParam_t;
                        hairparam_t5.fHighLightRegionPixelsRatio = hairParam4.fHighLightRegionPixelsRatio;
                        hairparam_t5.eHighLightRegionBlendMode = getIntBlendMode(hairParam4.eHighLightRegionBlendMode);
                        hairParam_t hairparam_t6 = pGEquinoxProcessParamHairDrawing.param;
                        HairParam hairParam5 = hairStruct.hairParam_t;
                        hairparam_t6.fHighLightRegionSmoothR = hairParam5.fHighLightRegionSmoothR;
                        hairparam_t6.fHighLightRegionAlpha = hairParam5.fHighLightRegionAlpha;
                        hairparam_t6.vHighLightColor = hairParam5.vHighLightColor;
                        hairparam_t6.eBlackRegionBlendMode = getIntBlendMode(hairParam5.eBlackRegionBlendMode);
                        hairParam_t hairparam_t7 = pGEquinoxProcessParamHairDrawing.param;
                        HairParam hairParam6 = hairStruct.hairParam_t;
                        hairparam_t7.fBlackRegionSmoothR = hairParam6.fBlackRegionSmoothR;
                        hairparam_t7.fBlackRegionAlpha = hairParam6.fBlackRegionAlpha;
                        hairparam_t7.vBlackColor = hairParam6.vBlackColor;
                        pGEquinoxProcessParamMix = pGEquinoxProcessParamHairDrawing;
                        r3 = pGEquinoxProcessParamMix;
                        break;
                    } else {
                        strArr[i2] = this.materialFolder + File.separator + hairStruct.hairParam_t.layerTemplate[i2];
                        i2++;
                    }
                }
            case 5:
                r3 = new PGEquinoxProcessParamReplaceAlpha();
                ReplaceAlphaStruct replaceAlphaStruct = (ReplaceAlphaStruct) struct;
                r3.bShrink = replaceAlphaStruct.bShrink;
                r3.bSmooth = replaceAlphaStruct.bSmooth;
                r3.iShrinkR = replaceAlphaStruct.iShrinkR;
                r3.iSmoothR = replaceAlphaStruct.iSmoothR;
                break;
            case 6:
                ?? pGEquinoxProcessParamShiftedMaskEffect = new PGEquinoxProcessParamShiftedMaskEffect();
                ShiftedMaskEffectStruct shiftedMaskEffectStruct = (ShiftedMaskEffectStruct) struct;
                if (shiftedMaskEffectStruct.eEffectType.equals(PGEquinoxProcessParamShiftedMaskEffect.PURE)) {
                    pGEquinoxProcessParamShiftedMaskEffect.eEffectType = PGEquinoxProcessParamShiftedMaskEffect.SHIFTED_MASK_EFFECT_TYPE_PURE;
                } else {
                    pGEquinoxProcessParamShiftedMaskEffect.eEffectType = PGEquinoxProcessParamShiftedMaskEffect.SHIFTED_MASK_EFFECT_TYPE_BLEND;
                }
                pGEquinoxProcessParamShiftedMaskEffect.color = shiftedMaskEffectStruct.color;
                int parseCoordType = parseCoordType(shiftedMaskEffectStruct.eCoordType);
                if (parseCoordType != 1073741823) {
                    pGEquinoxProcessParamShiftedMaskEffect.eCoordType = parseCoordType;
                    pGEquinoxProcessParamShiftedMaskEffect.shiftCoord = shiftedMaskEffectStruct.shiftCoord;
                    pGEquinoxProcessParamShiftedMaskEffect.bColor = shiftedMaskEffectStruct.bColor;
                    if (shiftedMaskEffectStruct.eMaskRefineType.equals(PGEquinoxProcessParamShiftedMaskEffect.BINARY)) {
                        pGEquinoxProcessParamShiftedMaskEffect.eMaskRefineType = PGEquinoxProcessParamShiftedMaskEffect.SHIFTED_MASK_EFFECT_REFINE_MASK_TYPE_BINARY;
                    } else {
                        pGEquinoxProcessParamShiftedMaskEffect.eMaskRefineType = PGEquinoxProcessParamShiftedMaskEffect.SHIFTED_MASK_EFFECT_REFINE_MASK_TYPE_DEFAULT;
                    }
                    pGEquinoxProcessParamShiftedMaskEffect.bMaskBoundraySmooth = shiftedMaskEffectStruct.bMaskBoundraySmooth;
                    int parseTransformType = parseTransformType(shiftedMaskEffectStruct.eTransformType);
                    if (parseTransformType != 1073741823) {
                        pGEquinoxProcessParamShiftedMaskEffect.eTransformType = parseTransformType;
                        pGEquinoxProcessParamShiftedMaskEffect.fGaussianBlurR = shiftedMaskEffectStruct.fGaussianBlurR;
                        pGEquinoxProcessParamMix = pGEquinoxProcessParamShiftedMaskEffect;
                        r3 = pGEquinoxProcessParamMix;
                        break;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            case 7:
                r3 = new PGEquinoxProcessParamExpandBoundray();
                EdgeStruct edgeStruct = (EdgeStruct) struct;
                r3.color = edgeStruct.color;
                r3.eBoundrayType = parseBoundaryType(edgeStruct.eBoundrayType);
                r3.eCoordType = parseCoordType(edgeStruct.eCoordType);
                r3.eCoordTypeEpsilon = parseCoordType(edgeStruct.eCoordTypeEpsilon);
                r3.eOpType = edgeStruct.eOpType;
                r3.fAlpha = edgeStruct.fAlpha;
                r3.fEpsilon = edgeStruct.fEpsilon;
                r3.fWidth = edgeStruct.fWidth;
                r3.iEpsilonMax = edgeStruct.iEpsilonMax;
                r3.iEpsilonMin = edgeStruct.iEpsilonMin;
                break;
            case 8:
                r3 = new PGEquinoxProcessParamOneKeyBeautify();
                AutoBeautyStruct autoBeautyStruct = (AutoBeautyStruct) struct;
                r3.bAutoCleanAcne = autoBeautyStruct.bAutoCleanAcne;
                r3.bNeedScreen = autoBeautyStruct.bNeedScreen;
                r3.fFaceDownStrength = autoBeautyStruct.fFaceDownStrength;
                r3.fFaceUpStrength = autoBeautyStruct.fFaceUpStrength;
                r3.fLightStrength = autoBeautyStruct.fLightStrength;
                r3.iBrightStrength = autoBeautyStruct.iBrightStrength;
                r3.iEyeBagStrength = autoBeautyStruct.iEyeBagStrength;
                r3.iFLWStrength = autoBeautyStruct.iFLWStrength;
                r3.iSaveMidResult = 0;
                r3.iSoftenStrength = autoBeautyStruct.iSoftenStrength;
                r3.fBigEyeStrong = autoBeautyStruct.fBigEyeStrong;
                r3.iMaxSpotNum = autoBeautyStruct.iMaxSpotNum;
                r3.eOption = parseAutoBeautyOptions(autoBeautyStruct.eOption);
                r3.leftTop = r1;
                float[] fArr = this.param.faceRect;
                float[] fArr2 = {fArr[0], fArr[1]};
                r3.rightBottom = r1;
                float[] fArr3 = {fArr[2], fArr[3]};
                break;
            case 9:
                r3 = new PGEquinoxProcessParamColorShading();
                ColorShadingStruct colorShadingStruct = (ColorShadingStruct) struct;
                r3.cColor = colorShadingStruct.getCColor();
                r3.fCutPoint = colorShadingStruct.fCutPoint;
                r3.iColorNum = colorShadingStruct.iColorNum;
                r3.eShadingDirection = parseEShadingDirection(colorShadingStruct.eShadingDirection);
                r3.eShadingType = parseEShadingType(colorShadingStruct.eShadingType);
                break;
            case 10:
                r3 = new PGEquinoxProcessParamHandleAlpha();
                r3.eOpType = parseEOpType(((HandleAlphaStruct) struct).eOpType);
                break;
        }
        if (r3 != 0) {
            r3.mProcessType = struct.paramType;
        }
        return r3;
    }

    private int[] processStructMaterial(Struct struct) {
        List<TextureItem> list;
        boolean GetMattingMask;
        int i2 = struct.paramType;
        if (i2 == 0) {
            Texture texture = ((FilterStruct) struct).textures;
            if (texture != null && (list = texture.items) != null) {
                int[] iArr = new int[list.size()];
                for (int i3 = 0; i3 < list.size(); i3++) {
                    TextureItem textureItem = list.get(i3);
                    this.mEquinoxEngine.SetInputImageByPath(this.materialFolder + File.separator + textureItem.name, textureItem.index);
                    iArr[i3] = textureItem.index;
                }
                return iArr;
            }
        } else if (i2 == 1) {
            MixStruct mixStruct = (MixStruct) struct;
            MixTexture mixTexture = mixStruct.texture;
            if (mixTexture != null) {
                int[] iArr2 = new int[1];
                if (mixTexture.type.equals("file")) {
                    boolean SetInputImageByPath = this.mEquinoxEngine.SetInputImageByPath(this.materialFolder + File.separator + mixStruct.texture.name, mixStruct.texture.index);
                    StringBuilder sb = new StringBuilder();
                    sb.append("STRUCT_TYPE_MIX filter type suc = ");
                    sb.append(SetInputImageByPath);
                    a.d(TAG, sb.toString(), new Object[0]);
                    iArr2[0] = mixStruct.texture.index;
                } else if (mixStruct.texture.type.equals("init")) {
                    boolean SetInputImageByPath2 = this.mEquinoxEngine.SetInputImageByPath((String) this.input, mixStruct.texture.index);
                    a.d(TAG, "STRUCT_TYPE_MIX init type suc = " + SetInputImageByPath2, new Object[0]);
                    iArr2[0] = mixStruct.texture.index;
                } else if (mixStruct.texture.type.equals("memory")) {
                    iArr2[0] = mixStruct.texture.index;
                }
                return iArr2;
            }
        } else if (i2 == 5) {
            int[] iArr3 = new int[1];
            ReplaceAlphaStruct replaceAlphaStruct = (ReplaceAlphaStruct) struct;
            if (ReplaceAlphaStruct.HAIR_MASK_TYPE.equals(replaceAlphaStruct.maskType)) {
                GetMattingMask = this.mEquinoxEngine.GetMattingMask(replaceAlphaStruct.toIndex, 1);
            } else if (ReplaceAlphaStruct.PORTRAIT_MASK_TYPE.equals(replaceAlphaStruct.maskType)) {
                GetMattingMask = this.mEquinoxEngine.GetMattingMask(replaceAlphaStruct.toIndex, 2);
            } else {
                GetMattingMask = this.mEquinoxEngine.GetMattingMask(replaceAlphaStruct.toIndex, 2);
            }
            a.d(TAG, "mEquinoxEngine.GetMattingMask = " + GetMattingMask, new Object[0]);
            iArr3[0] = replaceAlphaStruct.toIndex;
            return iArr3;
        }
        return null;
    }

    private float[] string2FloatArray(String str) {
        String[] split = str.split(",");
        float[] fArr = new float[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            fArr[i2] = Float.parseFloat(split[i2]);
        }
        return fArr;
    }

    private int[] string2IntArray(String str) {
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            iArr[i2] = Integer.parseInt(split[i2].trim());
        }
        return iArr;
    }

    public void activeGlEnv() {
        if (this.mGlContext == null) {
            PGGLContextManager pGGLContextManager = new PGGLContextManager();
            this.mGlContext = pGGLContextManager;
            pGGLContextManager.initGLContext(3);
            this.mGlContext.addSurface(null);
            this.mGlContext.activateOurGLContext();
        }
    }

    public void cancelMake(boolean z) {
        this.stopMake = z;
        a.k("cancelMake:" + z, new Object[0]);
    }

    public void destroy() {
        PGEquinoxEngine pGEquinoxEngine = this.mEquinoxEngine;
        if (pGEquinoxEngine == null) {
            return;
        }
        pGEquinoxEngine.PGEquinoxDestroy();
    }

    public boolean init(Context context, String str, String str2, String str3) {
        if (!this.mEquinoxEngine.PGEquinoxInitialise(context, Utils.getShader(context))) {
            a.d(TAG, "PGEquinoxInitialise = false", new Object[0]);
            return false;
        }
        this.mEquinoxEngine.SetAssetsManager(context.getAssets());
        if (!this.mEquinoxEngine.SetModelFiles(str, str2, str3)) {
            a.d(TAG, "SetModelFiles = false", new Object[0]);
            return false;
        }
        this.mTmpPath = context.getFilesDir().getAbsolutePath();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0313, code lost:
        if (checkCancel(10) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0315, code lost:
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0317, code lost:
        r2 = r27.output;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x031b, code lost:
        if ((r2 instanceof android.graphics.Bitmap) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0325, code lost:
        if (r27.mEquinoxEngine.GetOutputBitmap((android.graphics.Bitmap) r2, r1) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0327, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0332, code lost:
        if (r27.mEquinoxEngine.GetOutput2File((java.lang.String) r2, r1) != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0334, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0335, code lost:
        return 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int make() {
        /*
            Method dump skipped, instructions count: 831
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.blockbuster.BlockBuster.make():int");
    }

    public void releaseGlEnv() {
        PGGLContextManager pGGLContextManager = this.mGlContext;
        if (pGGLContextManager != null) {
            pGGLContextManager.releaseGL();
            this.mGlContext = null;
        }
    }

    public boolean segmentation(String str, String str2) {
        boolean exists = new File(str2).exists();
        if (checkCancel(1)) {
            return false;
        }
        if (!this.mEquinoxEngine.ImageMattingSDK((String) this.input, exists ? 1 : 0, VideoEdit2Activity.MIN_SCALED_SIZE)) {
            a.d(TAG, "ImageMattingSDK 1 = false", new Object[0]);
            return false;
        } else if (checkCancel(2)) {
            return false;
        } else {
            if (!this.mEquinoxEngine.GetMattingMask(str, 1)) {
                a.d(TAG, "GetMattingMask 1 = false", new Object[0]);
                return false;
            } else if (checkCancel(3)) {
                return false;
            } else {
                if (exists || this.mEquinoxEngine.GetMattingMask(str2, 2)) {
                    return true;
                }
                a.d(TAG, "GetMattingMask 2 = false", new Object[0]);
                return false;
            }
        }
    }

    private BlockBuster() {
        this.mEquinoxEngine = new PGEquinoxEngine();
    }
}
