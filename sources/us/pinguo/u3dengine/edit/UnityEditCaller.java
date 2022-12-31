package us.pinguo.u3dengine.edit;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.growingio.android.sdk.collection.Constants;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.lib.GsonUtilKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.c0;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.b;
import us.pinguo.common.log.a;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.u3dengine.PgUnityPlayer;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.MagicBgItem;
import us.pinguo.u3dengine.api.MakeupMaterial;
import us.pinguo.u3dengine.api.SoftSkinParam;
import us.pinguo.u3dengine.api.StaticStickerItem;
import us.pinguo.util.d;
/* compiled from: UnityEditCaller.kt */
/* loaded from: classes6.dex */
public final class UnityEditCaller {
    private static final String ENGINE_MESSAGE_RECEIVER = "PGEditEngine";
    public static final UnityEditCaller INSTANCE = new UnityEditCaller();

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Adjustment {
        public static final Adjustment INSTANCE = new Adjustment();

        private Adjustment() {
        }

        public static final void setAdjustValue(AdjustRenderData adjustRenderData) {
            s.h(adjustRenderData, "adjustRenderData");
            try {
                String s = GsonUtilKt.getCachedGson().s(adjustRenderData);
                PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAdjustFilterValue", s);
                d.d("SetAdjustFilterValue");
                a.c(s.q("SetAdjustFilterValue:", s), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public static final void setIsAdjustPreviewMode(boolean z) {
            String str = z ? "1" : "0";
            try {
                PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetFilterPreviewMode", str);
                d.d("SetFilterPreviewMode");
                a.c(s.q("SetAdjustPreviewMode:", str), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class AutoBeauty {
        public static final AutoBeauty INSTANCE = new AutoBeauty();

        private AutoBeauty() {
        }

        public static final void setAutoDeformationValue(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoDeformationValue", String.valueOf(f2));
            d.d("SetAutoDeformationValue");
            a.c(s.q("setAutoDeformationValue:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setAutoFixedMakeupValue(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoFixedMakeupValue", String.valueOf(f2));
            d.d("SetAutoFixedMakeupValue");
            a.c(s.q("setAutoFixedMakeupValue:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setAutoSoftSkinValue(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoSoftSkinValue", String.valueOf(f2));
            d.d("SetAutoSoftSkinValue");
            a.c(s.q("setAutoSoftSkinValue:", Float.valueOf(f2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class AutoDeformation {
        public static final AutoDeformation INSTANCE = new AutoDeformation();

        private AutoDeformation() {
        }

        public static final void setAutoDeformationFaceIndex(int i2) {
            a.c(s.q("setAutoDeformationFaceIndex:", Integer.valueOf(i2)), new Object[0]);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoDeformationFaceIndex", String.valueOf(i2));
            d.d("SetAutoDeformationFaceIndex");
        }

        public static final void setAutoDeformationParam(DeformationParam... params) {
            CharSequence h0;
            s.h(params, "params");
            StringBuilder sb = new StringBuilder();
            int length = params.length;
            int i2 = 0;
            while (i2 < length) {
                DeformationParam deformationParam = params[i2];
                i2++;
                sb.append(deformationParam.getKey() + ',' + deformationParam.getValue() + '|');
            }
            h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
            a.c("setDeformation: '" + ((Object) h0) + '\'', new Object[0]);
            if (h0.length() > 0) {
                PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoDeformationParam", h0.toString());
                d.d("SetAutoDeformationParam");
                a.c(s.q("SetAutoDeformationParam:", h0), new Object[0]);
            }
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class BackgroundBlur {
        public static final BackgroundBlur INSTANCE = new BackgroundBlur();

        /* compiled from: UnityEditCaller.kt */
        /* loaded from: classes6.dex */
        public enum Customize {
            Default,
            Size,
            Corrosion,
            Swirly,
            Radial,
            Highlight,
            Vivid,
            Halo
        }

        /* compiled from: UnityEditCaller.kt */
        /* loaded from: classes6.dex */
        public enum Shape {
            Default,
            Creamy,
            Soft,
            Reflex,
            Bilinear,
            ShapeTexture
        }

        private BackgroundBlur() {
        }

        public static final void cleanBokehCachedShapeTexture() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CleanBokehCachedShapeTexture", "");
            d.d("CleanBokehCachedShapeTexture");
            a.c("CleanBokehCachedShapeTexture", new Object[0]);
        }

        public static final void hideBokehUnmarkedArea(boolean z) {
            String str = z ? "1" : "0";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "HideBokehUnmarkedArea", str);
            d.d("HideBokehUnmarkedArea");
            a.c(s.q("HideBokehUnmarkedArea:", str), new Object[0]);
        }

        public static final void inverseBokehMask() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "InverseBokehMask", "");
            d.d("InverseBokehMask");
            a.c("InverseBokehMask", new Object[0]);
        }

        public static final void renderBokehEffect() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RenderBokehEffect", "");
            d.d("RenderBokehEffect");
            a.c("RenderBokehEffect", new Object[0]);
        }

        public static final void requestBokehIconTextureWithCurrentBokehValue() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestBokehIconTextureWithCurrentBokehValue", "");
            d.d("RequestBokehIconTextureWithCurrentBokehValue");
            a.c("RequestBokehIconTextureWithCurrentBokehValue", new Object[0]);
        }

        public static final void resetBokehMask(String maskPath) {
            s.h(maskPath, "maskPath");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetBrushMask", maskPath);
            d.d("ResetBrushMask");
            a.c(s.q("ResetBokehMask:", maskPath), new Object[0]);
        }

        public static final void setBokehAdjustmentAdjustValue(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            StringBuilder sb = new StringBuilder();
            String str7 = "";
            if (f2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Customize.Size.ordinal());
                sb2.append(',');
                sb2.append(f2);
                sb2.append('|');
                str = sb2.toString();
            } else {
                str = "";
            }
            sb.append(str);
            if (f3 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Customize.Corrosion.ordinal());
                sb3.append(',');
                sb3.append(f3);
                sb3.append('|');
                str2 = sb3.toString();
            } else {
                str2 = "";
            }
            sb.append(str2);
            if (f4 != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(Customize.Swirly.ordinal());
                sb4.append(',');
                sb4.append(f4);
                sb4.append('|');
                str3 = sb4.toString();
            } else {
                str3 = "";
            }
            sb.append(str3);
            if (f5 != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Customize.Radial.ordinal());
                sb5.append(',');
                sb5.append(f5);
                sb5.append('|');
                str4 = sb5.toString();
            } else {
                str4 = "";
            }
            sb.append(str4);
            if (f6 != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(Customize.Highlight.ordinal());
                sb6.append(',');
                sb6.append(f6);
                sb6.append('|');
                str5 = sb6.toString();
            } else {
                str5 = "";
            }
            sb.append(str5);
            if (f7 != null) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(Customize.Vivid.ordinal());
                sb7.append(',');
                sb7.append(f7);
                sb7.append('|');
                str6 = sb7.toString();
            } else {
                str6 = "";
            }
            sb.append(str6);
            if (f8 != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(Customize.Halo.ordinal());
                sb8.append(',');
                sb8.append(f8);
                str7 = sb8.toString();
            }
            sb.append(str7);
            String sb9 = sb.toString();
            s.g(sb9, "stringBuilder.toString()");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehAdjustmentAdjustValue", sb9);
            d.d("SetBokehAdjustmentAdjustValue");
            a.c(s.q("SetBokehAdjustmentAdjustValue:", sb9), new Object[0]);
        }

        public static /* synthetic */ void setBokehAdjustmentAdjustValue$default(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = null;
            }
            if ((i2 & 2) != 0) {
                f3 = null;
            }
            if ((i2 & 4) != 0) {
                f4 = null;
            }
            if ((i2 & 8) != 0) {
                f5 = null;
            }
            if ((i2 & 16) != 0) {
                f6 = null;
            }
            if ((i2 & 32) != 0) {
                f7 = null;
            }
            if ((i2 & 64) != 0) {
                f8 = null;
            }
            setBokehAdjustmentAdjustValue(f2, f3, f4, f5, f6, f7, f8);
        }

        public static final void setBokehBrushEffectIsApplied(boolean z) {
            String str = z ? "1" : "0";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehBrushEffectIsApplied", str);
            d.d("SetBokehBrushEffectIsApplied");
            a.c(s.q("SetBokehBrushEffectIsApplied:", str), new Object[0]);
        }

        public static final void setBokehFocusPoint(float f2, float f3) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehFocusPoint", sb2);
            d.d("SetBokehFocusPoint");
            a.c(s.q("SetBokehFocusPoint:", sb2), new Object[0]);
        }

        public static final void setBokehMaskFile(String maskFilePath) {
            s.h(maskFilePath, "maskFilePath");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehMaskFile", maskFilePath);
            d.d("SetBokehMaskFile");
            a.c(s.q("SetBokehMaskFile:", maskFilePath), new Object[0]);
        }

        public static final void setBokehShapeAdjustmentAdjustValue(@FloatRange(from = 0.0d, to = 1.0d) Float f2, @FloatRange(from = 0.0d, to = 1.0d) Float f3, @FloatRange(from = 0.0d, to = 1.0d) Float f4, @FloatRange(from = 0.0d, to = 1.0d) Float f5, String str) {
            String str2;
            String str3;
            String str4;
            String str5;
            StringBuilder sb = new StringBuilder();
            if (f2 != null) {
                str2 = "1," + f2 + '|';
            } else {
                str2 = "";
            }
            sb.append(str2);
            if (f3 != null) {
                str3 = "2," + f3 + '|';
            } else {
                str3 = "";
            }
            sb.append(str3);
            if (f4 != null) {
                str4 = "3," + f4 + '|';
            } else {
                str4 = "";
            }
            sb.append(str4);
            if (f5 != null) {
                str5 = "4," + f5 + '|';
            } else {
                str5 = "";
            }
            sb.append(str5);
            sb.append(str != null ? s.q("5,", str) : "");
            String sb2 = sb.toString();
            s.g(sb2, "stringBuilder.toString()");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehShapeAdjustmentAdjustValue", sb2);
            d.d("SetBokehShapeAdjustmentAdjustValue");
            a.c(s.q("SetBokehShapeAdjustmentAdjustValue:", sb2), new Object[0]);
        }

        public static /* synthetic */ void setBokehShapeAdjustmentAdjustValue$default(Float f2, Float f3, Float f4, Float f5, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = null;
            }
            if ((i2 & 2) != 0) {
                f3 = null;
            }
            if ((i2 & 4) != 0) {
                f4 = null;
            }
            if ((i2 & 8) != 0) {
                f5 = null;
            }
            if ((i2 & 16) != 0) {
                str = null;
            }
            setBokehShapeAdjustmentAdjustValue(f2, f3, f4, f5, str);
        }

        public final void setBokehEffectQuality(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBokehEffectQuality", String.valueOf(f2));
            d.d("SetBokehEffectQuality");
            a.c(s.q("SetBokehEffectQuality:", Float.valueOf(f2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Blur {
        public static final Blur INSTANCE = new Blur();

        private Blur() {
        }

        public static final void updateBlurBaseInfos(int i2, @FloatRange(from = -180.0d, to = 180.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8, float f9, float f10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            sb.append(',');
            sb.append(f6);
            sb.append(',');
            sb.append(f7);
            sb.append(',');
            sb.append(f8);
            sb.append(',');
            sb.append(f9);
            sb.append(',');
            sb.append(f10);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateBlurBaseInfos", sb2);
            d.d("UpdateBlurBaseInfos");
            a.c(s.q("UpdateBlurBaseInfos:", sb2), new Object[0]);
        }

        public static final void updateBlurRange(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateBlurRange", valueOf);
            d.d("UpdateBlurRange");
            a.c(s.q("UpdateBlurRange:", valueOf), new Object[0]);
        }

        public static final void updateBlurStrength(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateBlurStrength", valueOf);
            d.d("UpdateBlurStrength");
            a.c(s.q("UpdateBlurStrength:", valueOf), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class BodyBeautify {
        public static final BodyBeautify INSTANCE = new BodyBeautify();

        private BodyBeautify() {
        }

        public final void mergeCurrentBodyBeatifyEffect() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "MergeCurrentBodyBeatifyEffect", "");
            d.d("MergeCurrentBodyBeatifyEffect");
            a.c("MergeCurrentBodyBeatifyEffect", new Object[0]);
        }

        public final void requestBodyBeatifyEffectStatus() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestBodyBeatifyEffectStatus", "");
            d.d("RequestBodyBeatifyEffectStatus");
            a.c("RequestBodyBeatifyEffectStatus", new Object[0]);
        }

        public final void setBodyBeautifyEffectIsApplied(int i2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBodyBeautifyEffectIsApplied", String.valueOf(i2));
            d.d("SetBodyBeautifyEffectIsApplied");
            a.c(s.q("SetBodyBeautifyEffectIsApplied:", Integer.valueOf(i2)), new Object[0]);
        }

        public final void setCurrentBodyBeautifyMode(String value) {
            s.h(value, "value");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCurrentBodyBeautifyMode", value);
            d.d("SetCurrentBodyBeautifyMode");
            a.c(s.q("setCurrentBodyBeautifyMode:", value), new Object[0]);
        }

        public final void updateBodyBeautifyTool(float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append('|');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            sb.append('|');
            sb.append(f6);
            sb.append('|');
            sb.append(f7);
            sb.append('|');
            sb.append(i2);
            sb.append('|');
            sb.append(i3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateBodyBeautifyTool", sb2);
            d.d("UpdateBodyBeautifyTool");
            a.c(s.q("UpdateBodyBeautifyTool:", sb2), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Brush {
        public static final Brush INSTANCE = new Brush();

        private Brush() {
        }

        public static final void resetBrushMask() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetBrushMask", "");
            d.d("ResetBrushMask");
            a.c("ResetBrushMask", new Object[0]);
        }

        public static final void reverseBrushMask() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "InverseBrushMask", "");
            d.d("InverseBrushMask");
            a.c("InverseBrushMask", new Object[0]);
        }

        public static final void setBrushColor(@ColorInt int i2) {
            String argbColorInt2RgbaString = UnityEditCaller.argbColorInt2RgbaString(i2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushColor", argbColorInt2RgbaString);
            d.d("SetBrushColor");
            a.c(s.q("setBrushColor:", argbColorInt2RgbaString), new Object[0]);
        }

        public static final void setBrushEffectIntensity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushEffectIntensity", valueOf);
            d.d("SetBrushEffectIntensity");
            a.c(s.q("SetBrushEffectIntensity:", valueOf), new Object[0]);
        }

        public static final void setBrushSize(BasicBrushMode brushMode, float f2) {
            s.h(brushMode, "brushMode");
            StringBuilder sb = new StringBuilder();
            sb.append(brushMode.getType());
            sb.append(',');
            sb.append(f2);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushSize", sb2);
            d.d("SetBrushSize");
            a.c(s.q("SetBrushSize:", sb2), new Object[0]);
        }

        public static final void setCurrentBrushMode(BasicBrushMode brushMode) {
            s.h(brushMode, "brushMode");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCurrentBrushMode", String.valueOf(brushMode.getType()));
            d.d("SetCurrentBrushMode");
            a.c(s.q("SetCurrentBrushMode:", brushMode.name()), new Object[0]);
        }

        public static final void tryGetRecordedVIPStatus() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "TryGetRecordedVIPStatus", "");
            d.d("TryGetRecordedVIPStatus");
            a.c("TryGetRecordedVIPStatus", new Object[0]);
        }

        public final void setBrushMaskHighlightColor(@ColorInt int i2, @ColorInt int i3) {
            String str = UnityEditCaller.argbColorInt2RgbaString(i2) + ',' + UnityEditCaller.argbColorInt2RgbaString(i3);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushMaskHighlightColor", str);
            d.d("SetBrushMaskHighlightColor");
            a.c(s.q("SetBrushMaskHighlightColor:", str), new Object[0]);
        }

        public final void setSoftSkinMaskViewOpacity(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSoftSkinMaskViewOpacity", String.valueOf(f2));
            d.d("SetSoftSkinMaskViewOpacity");
            a.c(s.q("SetSoftSkinMaskViewOpacity:", Float.valueOf(f2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Common {
        public static final Common INSTANCE = new Common();

        private Common() {
        }

        public static final void canvasAnimationTo(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
            s.h(normalizedFocusPoint, "normalizedFocusPoint");
            s.h(normalizedOffset, "normalizedOffset");
            String str = normalizedFocusPoint.x + ',' + normalizedFocusPoint.y + ',' + f2 + ',' + normalizedOffset.x + ',' + normalizedOffset.y + ',' + (i2 / 1000.0f) + ",14";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CanvasAnimationTo", str);
            d.d("CanvasAnimationTo");
            a.c(s.q("CanvasAnimationTo:", str), new Object[0]);
        }

        public static final void changedToEditComponent(EditModel editModel) {
            s.h(editModel, "editModel");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ChangedToEditComponentAndroid", String.valueOf(editModel.getKey()));
            d.d("ChangedToEditComponentAndroid");
            a.c(s.q("changedToEditComponent:", editModel.name()), new Object[0]);
        }

        public static final void cleanUp() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CleanUpAndroid", "");
            d.d("CleanUpAndroid");
            a.e("CleanUpAndroid", new Object[0]);
        }

        public static final void moveNext() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "MoveNext", "");
            d.d("MoveNext");
            a.c("MoveNext", new Object[0]);
        }

        public static final void movePrevious() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "MovePrevious", "");
            d.d("MovePrevious");
            a.c("MovePrevious", new Object[0]);
        }

        public static final void requestFinalRenderedTexture(String savePath) {
            s.h(savePath, "savePath");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestFinalRenderedTextureAndroid", savePath);
            d.d("RequestFinalRenderedTextureAndroid");
            a.c(s.q("RequestFinalRenderedTextureAndroid:", savePath), new Object[0]);
        }

        public static final void setEditCanvasInfo(float f2, float f3, @ColorInt int i2) {
            String str = f3 + ',' + f2 + ',' + UnityEditCaller.argbColorInt2RgbaString(i2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditCanvasInfo", String.valueOf(str));
            d.d("SetEditCanvasInfo");
            a.c(s.q("SetEditCanvasInfo:", str), new Object[0]);
        }

        public static final void setEditHistoryFromPath(String path, Size textureSize, Integer num) {
            s.h(path, "path");
            s.h(textureSize, "textureSize");
            StringBuilder sb = new StringBuilder();
            sb.append("0,");
            sb.append(textureSize.getWidth());
            sb.append(',');
            sb.append(textureSize.getHeight());
            sb.append(',');
            sb.append(path);
            sb.append(num != null ? s.q(",", num) : "");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditHistoryTextureAndroid", sb2);
            d.d("SetEditHistoryTextureAndroid");
            a.c(s.q("SetEditHistoryTextureAndroid:", sb2), new Object[0]);
        }

        public static final void setEditSourceFromPath(String path, Size textureSize, int i2, Integer num) {
            s.h(path, "path");
            s.h(textureSize, "textureSize");
            StringBuilder sb = new StringBuilder();
            sb.append("0,");
            sb.append(textureSize.getWidth());
            sb.append(',');
            sb.append(textureSize.getHeight());
            sb.append(',');
            sb.append(path);
            sb.append(',');
            sb.append(i2);
            sb.append(num != null ? s.q(",", num) : "");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditMainSourceTextureAndroid", sb2);
            d.d("SetEditMainSourceTextureAndroid");
            a.c(s.q("SetEditMainSourceTextureAndroid:", sb2), new Object[0]);
        }

        public static /* synthetic */ void setEditSourceFromPath$default(String str, Size size, int i2, Integer num, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            setEditSourceFromPath(str, size, i2, num);
        }

        public static final void showOriginalTexture(boolean z) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ShowOriginalTexture", z ? "1" : "0");
            d.d("ShowOriginalTexture");
            a.c(s.q("showOriginalTexture:", Boolean.valueOf(z)), new Object[0]);
        }

        public static final void viewPortAnimationTo(int i2, int i3, int i4) {
            String str = i2 + ',' + i3 + ",1.0," + (i4 / 1000.0f) + ",14";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ViewPortAnimationTo", str);
            d.d("ViewPortAnimationTo");
            a.c(s.q("viewPortAnimationTo:", str), new Object[0]);
        }

        public final void addSoftSkinStepWithParamUpdate() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "AddSoftSkinStepWithParamUpdate", "");
            d.d("AddSoftSkinStepWithParamUpdate");
            a.c("addSoftSkinStepWithParamUpdate", new Object[0]);
        }

        public final void enableCanvasSinglePointMove(boolean z) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "LockCanvas", String.valueOf(!z ? 1 : 0));
            d.d("LockCanvas");
            a.c("enableCanvasSinglePointMove", new Object[0]);
        }

        public final void requestMagnifierTexture(Size previewSize, SizeF viewportSize) {
            s.h(previewSize, "previewSize");
            s.h(viewportSize, "viewportSize");
            StringBuilder sb = new StringBuilder();
            sb.append(previewSize.getWidth());
            sb.append(',');
            sb.append(previewSize.getHeight());
            sb.append(',');
            sb.append(viewportSize.getWidth());
            sb.append(',');
            sb.append(viewportSize.getHeight());
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestMagnifierTexture", sb2);
            d.d("RequestMagnifierTexture");
            a.c(s.q("requestMagnifierTexture:", sb2), new Object[0]);
        }

        public final void setDebugMode(boolean z) {
            String str = z ? "1" : "0";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetDebugMode", str);
            d.d("SetDebugMode");
            a.c(s.q("SetDebugMode:", str), new Object[0]);
        }

        public final void setMagnifierPosition(float f2, float f3) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagnifierRenderCameraFocusPoint", sb2);
            d.d("UpdateMagnifierRenderCameraFocusPoint");
            a.c(s.q("UpdateMagnifierRenderCameraFocusPoint:", sb2), new Object[0]);
        }

        public final void setMagnifierRenderUpdateMode(int i2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMagnifierRenderUpdateMode", String.valueOf(i2));
            d.d("SetMagnifierRenderUpdateMode");
            a.c(s.q("SetMagnifierRenderUpdateMode:", Integer.valueOf(i2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Crop {
        public static final Crop INSTANCE = new Crop();

        private Crop() {
        }

        public static final void flipX() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "FlipX", "");
            d.d("FlipX");
            a.c("FlipX", new Object[0]);
        }

        public static final void flipY() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "FlipY", "");
            d.d("FlipY");
            a.c("FlipX", new Object[0]);
        }

        public static final void resetAllCrop(float f2, float f3, float f4, float f5) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetAllToDefault", sb2);
            d.d("ResetAllToDefault");
            a.c(s.q("ResetAllToDefault:", sb2), new Object[0]);
        }

        public static final void resetCropFrame() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetFrameToDefault", "");
            d.d("ResetFrameToDefault");
            a.c("ResetFrameToDefault", new Object[0]);
        }

        public static final void setCropFrame(float f2, float f3, float f4, float f5, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            sb.append(',');
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetClipFrame", sb2);
            d.d("SetClipFrame");
            a.c(s.q("setCropFrame:", sb2), new Object[0]);
        }

        public static /* synthetic */ void setCropFrame$default(float f2, float f3, float f4, float f5, boolean z, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                z = true;
            }
            setCropFrame(f2, f3, f4, f5, z);
        }

        public static final void setPerspectiveX(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCorrectX", String.valueOf(f2));
            d.d("SetCorrectX");
            a.c(s.q("SetCorrectX:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setPerspectiveY(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCorrectY", String.valueOf(f2));
            d.d("SetCorrectY");
            a.c(s.q("SetCorrectY:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setScaleX(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetScaleX", String.valueOf(f2));
            d.d("SetScaleX");
            a.c(s.q("SetScaleX:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setScaleY(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetScaleY", String.valueOf(f2));
            d.d("SetScaleY");
            a.c(s.q("SetScaleY:", Float.valueOf(f2)), new Object[0]);
        }

        public final void rotateCCW90(float f2, float f3, float f4, float f5) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "Rotate90", sb2);
            d.d("Rotate90");
            a.c(s.q("Rotate90:", sb2), new Object[0]);
        }

        public final void rotateCW90(float f2, float f3, float f4, float f5) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "Rotate270", sb2);
            d.d("Rotate270");
            a.c(s.q("Rotate270:", sb2), new Object[0]);
        }

        public final void setGassViewOpacity(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetGassViewOpacity", String.valueOf(f2));
            d.d("SetGassViewOpacity");
            a.c(s.q("SetGassViewOpacity:", Float.valueOf(f2)), new Object[0]);
        }

        public final void setRotation(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetRotationValue", String.valueOf(-f2));
            d.d("SetRotationValue");
            a.c(s.q("SetRotationValue:", Float.valueOf(f2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Facial3d {
        public static final Facial3d INSTANCE = new Facial3d();

        private Facial3d() {
        }

        public static final void forceRenderOneFrame() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ForceRenderOneFrame", "");
            d.d("ForceRenderOneFrame");
            a.c("ForceRenderOneFrame", new Object[0]);
        }

        public static final void resetStereorectifyStrength() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetStereorectifyStrength", "");
            d.d("ResetStereorectifyStrength");
            a.c("ResetStereorectifyStrength", new Object[0]);
        }

        public static final void setStereorectifyStrength(String param) {
            s.h(param, "param");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetStereorectifyStrength", param);
            d.d("SetStereorectifyStrength");
            a.c(s.q("SetStereorectifyStrength:", param), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Filter {
        public static final Filter INSTANCE = new Filter();

        /* compiled from: UnityEditCaller.kt */
        /* loaded from: classes6.dex */
        public enum FilterType {
            Local,
            Path,
            Texture,
            None
        }

        /* compiled from: UnityEditCaller.kt */
        /* loaded from: classes6.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FilterType.values().length];
                iArr[FilterType.Path.ordinal()] = 1;
                iArr[FilterType.Local.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Filter() {
        }

        public static final void getEditFilterTransformObject(float f2, float f3, float f4, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(i2);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "GetEditFilterTransformObject", sb2);
            d.d("GetEditFilterTransformObject");
            a.c(s.q("GetEditFilterTransformObject:", sb2), new Object[0]);
        }

        public static final void setEditFilterFlipMode(boolean z) {
            String str = z ? "1" : "0";
            a.c(s.q("SetEditFilterFlipMode:", str), new Object[0]);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditFilterFlipMode", str);
            d.d("SetEditFilterFlipMode");
        }

        public static final void setEditFilterInfo(FilterType type, String path) {
            String q;
            s.h(type, "type");
            s.h(path, "path");
            if (type == FilterType.Path && TextUtils.isEmpty(path)) {
                a.e("path should not be empty when set path type filter!", new Object[0]);
                return;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i2 == 1) {
                q = s.q(path, ",1");
            } else if (i2 != 2) {
                String lowerCase = type.toString().toLowerCase(Locale.ROOT);
                s.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                q = s.q(lowerCase, ",1");
            } else {
                String lowerCase2 = type.toString().toLowerCase(Locale.ROOT);
                s.g(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                q = s.q(lowerCase2, ",0");
            }
            a.c(s.q("DoFilterRendering:", q), new Object[0]);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "DoFilterRendering", q);
            d.d("DoFilterRendering");
        }

        public static /* synthetic */ void setEditFilterInfo$default(FilterType filterType, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = "";
            }
            setEditFilterInfo(filterType, str);
        }

        public static final void setEditFilterObjectTransformData(String uid, float f2, float f3, float f4, float f5, float f6) {
            s.h(uid, "uid");
            String str = uid + ',' + f2 + ',' + f3 + ',' + f4 + ',' + f5 + ',' + f6;
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditFilterObjectTransformData", str);
            d.d("SetEditFilterObjectTransformData");
            a.c(s.q("SetEditFilterObjectTransformData:", str), new Object[0]);
        }

        public static final void setEditFilterOpacity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditFilterOpacity", valueOf);
            d.d("SetEditFilterOpacity");
            a.c(s.q("SetEditFilterOpacity:", valueOf), new Object[0]);
        }

        public static final void setFilterTemplateIntensity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetFilterTemplateIntensity", valueOf);
            d.d("SetFilterTemplateIntensity");
            a.c(s.q("SetFilterTemplateIntensity:", valueOf), new Object[0]);
        }

        public static final void setIsFilterPreviewMode(boolean z) {
            String str = z ? "1" : "0";
            try {
                PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetFilterPreviewMode", str);
                d.d("SetFilterPreviewMode");
                a.c(s.q("SetFilterPreviewMode:", str), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public static final void updateEditFilter(int i2, int i3, int i4, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(i3);
            sb.append(',');
            sb.append(i4);
            sb.append(',');
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            a.c(s.q("UpdateEditFilter:", sb2), new Object[0]);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateEditFilter", sb2);
            d.d("UpdateEditFilter");
        }

        public final void requestCurrentFilterTexture() {
            a.c("RequestCurrentFilterTexture", new Object[0]);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestCurrentFilterTexture", "");
            d.d("RequestCurrentFilterTexture");
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Makeup {
        public static final Makeup INSTANCE = new Makeup();

        private Makeup() {
        }

        public static final void cancelSelfDefMakeup(int i2, int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(i3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CancelCustomMakeup", sb2);
            d.d("CancelCustomMakeup");
            a.c(s.q("CancelCustomMakeup:", sb2), new Object[0]);
        }

        public static final void cancelStyleMakeup(int i2) {
            String valueOf = String.valueOf(i2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CancelStyleMakeup", valueOf);
            d.d("CancelStyleMakeup");
            a.c(s.q("CancelStyleMakeup:", valueOf), new Object[0]);
        }

        public static final void renderEditStyleMakeup(int i2, List<MakeupMaterial> theme, float f2) {
            s.h(theme, "theme");
            if (!theme.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append(';');
                String sb2 = sb.toString();
                int i3 = 0;
                for (Object obj : theme) {
                    int i4 = i3 + 1;
                    if (i3 >= 0) {
                        MakeupMaterial makeupMaterial = (MakeupMaterial) obj;
                        if (f2 >= 0.0f) {
                            makeupMaterial.setValue(f2);
                        }
                        sb2 = s.q(sb2, makeupMaterial.toUnityParam$u3dengine_release());
                        if (i3 != theme.size() - 1) {
                            sb2 = s.q(sb2, Effect.DIVIDER);
                        }
                        i3 = i4;
                    } else {
                        kotlin.collections.s.n();
                        throw null;
                    }
                }
                a.c("RenderingEditStyleMakeup: '" + sb2 + '\'', new Object[0]);
                PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RenderingEditStyleMakeup", sb2);
                d.d("RenderingEditStyleMakeup");
                return;
            }
            a.c("RenderingEditStyleMakeup empty param", new Object[0]);
        }

        public static final void setEditCustomMakeup(int i2, MakeupMaterial makeupMaterial, Float f2) {
            s.h(makeupMaterial, "makeupMaterial");
            if (f2 != null) {
                makeupMaterial.setValue(f2.floatValue());
            }
            String str = i2 + ';' + makeupMaterial.toUnityParam$u3dengine_release();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditCustomMakeup", str);
            d.d("SetEditCustomMakeup");
            a.c(s.q("SetEditCustomMakeup:", str), new Object[0]);
        }

        public static /* synthetic */ void setEditCustomMakeup$default(int i2, MakeupMaterial makeupMaterial, Float f2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                f2 = null;
            }
            setEditCustomMakeup(i2, makeupMaterial, f2);
        }

        public static final void setEditMakeupFilter(String filterPath, float f2, float f3, int i2, boolean z) {
            s.h(filterPath, "filterPath");
            String str = filterPath + ',' + f2 + ',' + f3 + ',' + i2 + ',' + (z ? 1 : 0);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditMakeupFilter", str);
            d.d("SetEditMakeupFilter");
            a.c(s.q("SetEditMakeupFilter:", str), new Object[0]);
        }

        public static final void setMakeupBaseInfo(int i2, float f2, float f3, float f4, float f5) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMakeupBaseInfo", sb2);
            d.d("SetMakeupBaseInfo");
            a.c(s.q("SetMakeupBaseInfo:", sb2), new Object[0]);
        }

        public static final void setSelfDefMakeupColor(int i2, String colorHex, int i3) {
            s.h(colorHex, "colorHex");
            String str = i2 + ",#" + colorHex + ',' + i3;
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCustomMakeupColorWithHex", str);
            d.d("SetCustomMakeupColorWithHex");
            a.c(s.q("SetCustomMakeupColorWithHex:", str), new Object[0]);
        }

        public static final void setSelfDefMakeupTexture(int i2, String texturePath, int i3) {
            s.h(texturePath, "texturePath");
            String str = i2 + ',' + texturePath + ',' + i3;
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCustomMakeupColorWithTex", str);
            d.d("SetCustomMakeupColorWithTex");
            a.c(s.q("SetCustomMakeupColorWithTex:", str), new Object[0]);
        }

        public static final void setSelfDefMakeupValue(int i2, int i3, float f2, float f3, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(i3);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCustomMakeupStrengthWithSlide", sb2);
            d.d("SetCustomMakeupStrengthWithSlide");
            a.c(s.q("SetCustomMakeupStrengthWithSlide:", sb2), new Object[0]);
        }

        public static final void setStyleMakeupFilterValue(float f2, float f3, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMakeupFilterStrengthWithSlide", sb2);
            d.d("SetMakeupFilterStrengthWithSlide");
            a.c(s.q("SetMakeupFilterStrengthWithSlide:", sb2), new Object[0]);
        }

        public static final void setStyleMakeupValue(int i2, float f2, float f3, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetStyleMakeupStrengthWithSlide", sb2);
            d.d("SetStyleMakeupStrengthWithSlide");
            a.c(s.q("SetStyleMakeupStrengthWithSlide:", sb2), new Object[0]);
        }

        public static final void updateMakeupFaceMeshVertices(int i2, int i3, PointF pointF) {
            s.h(pointF, "pointF");
            float f2 = pointF.x;
            float f3 = pointF.y;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(i3);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMakeupFaceMeshVertices", sb2);
            d.d("UpdateMakeupFaceMeshVertices");
            a.c(s.q("UpdateMakeupFaceMeshVertices:", sb2), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class ManualDeformation {
        public static final ManualDeformation INSTANCE = new ManualDeformation();

        private ManualDeformation() {
        }

        public static final void forwardTransform(PointF point, PointF toPoint, @FloatRange(from = 0.0d, to = 1.0d) float f2, float f3, boolean z) {
            s.h(point, "point");
            s.h(toPoint, "toPoint");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(toPoint.x);
            sb.append(',');
            sb.append(toPoint.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ForwardTransform", sb2);
            d.d("ForwardTransform");
            a.c(s.q("ForwardTransform:", sb2), new Object[0]);
        }

        public static /* synthetic */ void forwardTransform$default(PointF pointF, PointF pointF2, float f2, float f3, boolean z, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                z = false;
            }
            forwardTransform(pointF, pointF2, f2, f3, z);
        }

        public static final void forwardTransformContiguous(PointF point, PointF toPoint, float f2, float f3, boolean z) {
            s.h(point, "point");
            s.h(toPoint, "toPoint");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(toPoint.x);
            sb.append(',');
            sb.append(toPoint.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ForwardTransformContiguous", sb2);
            d.d("ForwardTransformContiguous");
            a.c(s.q("ForwardTransformContiguous:", sb2), new Object[0]);
        }

        public static /* synthetic */ void forwardTransformContiguous$default(PointF pointF, PointF pointF2, float f2, float f3, boolean z, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                z = false;
            }
            forwardTransformContiguous(pointF, pointF2, f2, f3, z);
        }

        public static final void resetTransform(float f2, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ResetTransform", sb2);
            d.d("ResetTransform");
            a.c(s.q("ResetTransform:", sb2), new Object[0]);
        }

        public static final void restoreTransform(PointF point, float f2, float f3, boolean z) {
            s.h(point, "point");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RestoreTransform", sb2);
            d.d("RestoreTransform");
            a.c(s.q("RestoreTransform:", sb2), new Object[0]);
        }

        public static /* synthetic */ void restoreTransform$default(PointF pointF, float f2, float f3, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                z = false;
            }
            restoreTransform(pointF, f2, f3, z);
        }

        public static final void restoreTransformNew(PointF point, float f2, float f3, boolean z) {
            s.h(point, "point");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RestoreTransformNew", sb2);
            d.d("RestoreTransformNew");
            a.c(s.q("RestoreTransformNew:", sb2), new Object[0]);
        }

        public static /* synthetic */ void restoreTransformNew$default(PointF pointF, float f2, float f3, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                z = false;
            }
            restoreTransformNew(pointF, f2, f3, z);
        }

        public static final void rotateTransform(PointF point, float f2, float f3, boolean z) {
            s.h(point, "point");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RotateTransform", sb2);
            d.d("RotateTransform");
            a.c(s.q("RotateTransform:", sb2), new Object[0]);
        }

        public static /* synthetic */ void rotateTransform$default(PointF pointF, float f2, float f3, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                z = false;
            }
            rotateTransform(pointF, f2, f3, z);
        }

        public static final void scaleTransform(PointF point, float f2, float f3, boolean z, boolean z2) {
            s.h(point, "point");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(z ? "1" : TaskDetailBasePresenter.SCENE_LIST);
            sb.append(',');
            sb.append(z2 ? "1" : "0");
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "ScaleTransform", sb2);
            d.d("ScaleTransform");
            a.c(s.q("ScaleTransform:", sb2), new Object[0]);
        }

        public static /* synthetic */ void scaleTransform$default(PointF pointF, float f2, float f3, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                z2 = false;
            }
            scaleTransform(pointF, f2, f3, z, z2);
        }

        public static final void tryGetManualDeformationProtectMaskStatus() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "TryGetManualDeformationProtectMaskStatus", "");
            d.d("TryGetManualDeformationProtectMaskStatus");
            a.c("TryGetManualDeformationProtectMaskStatus", new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class Mosaic {
        public static final Mosaic INSTANCE = new Mosaic();

        private Mosaic() {
        }

        public static final void setBrush(BrushBuilder brush) {
            s.h(brush, "brush");
            String build = brush.build();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrush", build);
            d.d("SetBrush");
            a.c(s.q("SetBrush:", build), new Object[0]);
        }

        public static final void setClassicMosaicGridSize(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetClassicMosaicGridSize", valueOf);
            d.d("SetClassicMosaicGridSize");
            a.c(s.q("SetClassicMosaicGridSize:", valueOf), new Object[0]);
        }

        public static final void setMosaicEffectOpacity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMosaicEffectOpacity", valueOf);
            d.d("SetMosaicEffectOpacity");
            a.c(s.q("SetMosaicEffectOpacity:", valueOf), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class RemoveSpot {
        public static final RemoveSpot INSTANCE = new RemoveSpot();

        /* compiled from: UnityEditCaller.kt */
        /* loaded from: classes6.dex */
        public enum BrushMode {
            BRUSH("0"),
            ERASE("1");
            
            private final String value;

            BrushMode(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        private RemoveSpot() {
        }

        public static final void requestGetBrushMaskTexture() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "GetBrushMaskTexture", "");
            d.d("GetBrushMaskTexture");
            a.c("GetBrushMaskTexture", new Object[0]);
        }

        public static final void requestGetCurrentBrushTexture() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "GetCurrentBrushTexture", "");
            d.d("GetCurrentBrushTexture");
            a.c("GetCurrentBrushTexture", new Object[0]);
        }

        public static final void restoreToDefault() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RestoreToDefault", "");
            d.d("RestoreToDefault");
            a.c("RestoreToDefault", new Object[0]);
        }

        public static final void setBrushGassIntensity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushGassIntensity", String.valueOf(f2));
            d.d("SetBrushGassIntensity");
            a.c(s.q("SetBrushGassIntensity:", Float.valueOf(f2)), new Object[0]);
        }

        public static final void setBrushSize(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String q = s.q("1,", Float.valueOf(f2));
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetBrushSize", q);
            d.d("SetBrushSize");
            a.c(s.q("SetBrushSize:", q), new Object[0]);
        }

        public static final void setMinBrushView(int i2, float f2, float f3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMinBrushView", sb2);
            d.d("SetMinBrushView");
            a.c(s.q("SetMinBrushView:", sb2), new Object[0]);
        }

        public static final void setSpotRemoveMode(BrushMode mode) {
            s.h(mode, "mode");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSpotRemoveMode", mode.getValue());
            d.d("SetSpotRemoveMode");
            a.c(s.q("SetSpotRemoveMode:", mode.getValue()), new Object[0]);
        }

        public static final void setTotalMaskViewOpacity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetTotalMaskViewOpacity", String.valueOf(f2));
            d.d("SetTotalMaskViewOpacity");
            a.c(s.q("SetTotalMaskViewOpacity:", Float.valueOf(f2)), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class SkinColor {
        public static final SkinColor INSTANCE = new SkinColor();

        private SkinColor() {
        }

        public static final void setSkinColor(String skinColor) {
            s.h(skinColor, "skinColor");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSkinLutByText", skinColor);
            d.d("SetSkinLutByText");
            a.c(s.q("SetSkinLutByText:", skinColor), new Object[0]);
        }

        public static final void setSkinColorOpacity(float f2) {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSkinLutOpacity", String.valueOf(f2));
            d.d("SetSkinLutOpacity");
            a.c(s.q("SetSkinLutOpacity:", Float.valueOf(f2)), new Object[0]);
        }

        public static /* synthetic */ void setSkinColorOpacity$default(float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = 0.0f;
            }
            setSkinColorOpacity(f2);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class SkyChange {
        public static final SkyChange INSTANCE = new SkyChange();

        private SkyChange() {
        }

        public static /* synthetic */ void setSkyChangeParameter$default(SkyChange skyChange, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = null;
            }
            if ((i2 & 2) != 0) {
                f3 = null;
            }
            if ((i2 & 4) != 0) {
                f4 = null;
            }
            if ((i2 & 8) != 0) {
                f5 = null;
            }
            if ((i2 & 16) != 0) {
                f6 = null;
            }
            if ((i2 & 32) != 0) {
                f7 = null;
            }
            if ((i2 & 64) != 0) {
                f8 = null;
            }
            if ((i2 & 128) != 0) {
                num = null;
            }
            if ((i2 & 256) != 0) {
                f9 = null;
            }
            if ((i2 & 512) != 0) {
                z = false;
            }
            skyChange.setSkyChangeParameter(f2, f3, f4, f5, f6, f7, f8, num, f9, z);
        }

        public final void cleanSkyChangeRenderAssets() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CleanSkyChangeRenderAssets", "");
            d.d("CleanSkyChangeRenderAssets");
            a.c(s.q("CleanSkyChangeRenderAssets:", ""), new Object[0]);
        }

        public final void setAutoSH(String shPath) {
            s.h(shPath, "shPath");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetAutoSHTexture", shPath);
            d.d("SetAutoSHTexture");
            a.c(s.q("SetAutoSHTexture:", shPath), new Object[0]);
        }

        public final void setSkyChangeMask(String maskPath) {
            s.h(maskPath, "maskPath");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSkyChangeMaskTexture", maskPath);
            d.d("SetSkyChangeMaskTexture");
            a.c(s.q("SetSkyChangeMaskTexture:", maskPath), new Object[0]);
        }

        public final void setSkyChangeParameter(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9, boolean z) {
            String J;
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(TaskDetailBasePresenter.SCENE_LIST);
                StringBuilder sb = new StringBuilder();
                sb.append(f2);
                sb.append(',');
                sb.append(f3);
                sb.append(',');
                sb.append(f4);
                sb.append(',');
                sb.append(f5);
                sb.append(',');
                sb.append(f6);
                sb.append(',');
                sb.append(f7);
                sb.append(',');
                sb.append(f8);
                sb.append(',');
                sb.append(num);
                sb.append(',');
                sb.append(f9);
                arrayList.add(sb.toString());
            } else {
                if (f2 != null) {
                    arrayList.add(s.q("0|", f2));
                }
                if (f3 != null) {
                    arrayList.add(s.q("1|", f3));
                }
                if (f4 != null) {
                    arrayList.add(s.q("2|", f4));
                }
                if (f5 != null) {
                    arrayList.add(s.q("3|", f5));
                }
                if (f6 != null) {
                    arrayList.add(s.q("4|", f6));
                }
                if (f7 != null) {
                    arrayList.add(s.q("5|", f7));
                }
                if (f8 != null) {
                    arrayList.add(s.q("6|", f8));
                }
                if (num != null) {
                    arrayList.add(s.q("7|", num));
                }
                if (f9 != null) {
                    arrayList.add(s.q("8|", f9));
                }
            }
            J = c0.J(arrayList, Effect.DIVIDER, null, null, 0, null, null, 62, null);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetSkyChangeParameter", J);
            d.d("SetSkyChangeParameter");
            a.c(s.q("SetSkyChangeParameter:", J), new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class SoftSkin {
        public static final SoftSkin INSTANCE = new SoftSkin();

        private SoftSkin() {
        }

        public static final void setEditSoftSkinParam(SoftSkinParam softSkinParam, int i2, boolean z, boolean z2) {
            s.h(softSkinParam, "softSkinParam");
            StringBuilder sb = new StringBuilder();
            sb.append(softSkinParam.getKey());
            sb.append(',');
            sb.append(softSkinParam.getValue());
            sb.append(',');
            sb.append(z ? 1 : 0);
            sb.append(',');
            if (!z2) {
                i2 = -1;
            }
            sb.append(i2);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetEditSoftSkinParam", sb2);
            d.d("SetEditSoftSkinParam");
            a.c(s.q("setEditSoftSkinParam:", sb2), new Object[0]);
        }

        public static /* synthetic */ void setEditSoftSkinParam$default(SoftSkinParam softSkinParam, int i2, boolean z, boolean z2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            setEditSoftSkinParam(softSkinParam, i2, z, z2);
        }

        public static final void setRefreshSkinManaulMode(String mode) {
            s.h(mode, "mode");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCurrentManualSoftMode", mode);
            d.d("SetCurrentManualSoftMode");
            a.c(s.q("SetCurrentManualSoftMode:", mode), new Object[0]);
        }

        public static final void setRefreshSkinManaulOpacity(String key, float f2) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetCurrentManualSoftOpacity", key + ',' + f2);
            d.d("SetCurrentManualSoftOpacity");
            a.c("SetCurrentManualSoftOpacity:" + key + ',' + f2, new Object[0]);
        }
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class StaticSticker {
        public static final StaticSticker INSTANCE = new StaticSticker();

        private StaticSticker() {
        }

        public static final void copyCurrentStaticSticker(StaticStickerItem item) {
            s.h(item, "item");
            String staticStickerItem = item.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CopyCurrentStaticSticker", staticStickerItem);
            d.d("CopyCurrentStaticSticker");
            a.c(s.q("CopyCurrentStaticSticker:", staticStickerItem), new Object[0]);
        }

        public static final void currentStaticStickerLayerMoveDown() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CurrentStaticStickerLayerMoveDown", "");
            d.d("CurrentStaticStickerLayerMoveDown");
            a.c("CurrentStaticStickerLayerMoveDown", new Object[0]);
        }

        public static final void currentStaticStickerLayerMoveToTop() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CurrentStaticStickerLayerMoveToTop", "");
            d.d("CurrentStaticStickerLayerMoveToTop");
            a.c("CurrentStaticStickerLayerMoveToTop", new Object[0]);
        }

        public static final void currentStaticStickerLayerMoveUp() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CurrentStaticStickerLayerMoveUp", "");
            d.d("CurrentStaticStickerLayerMoveUp");
            a.c("CurrentStaticStickerLayerMoveUp", new Object[0]);
        }

        public static final void deleteCurrentStaticSticker() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "DeleteCurrentStaticSticker", "");
            d.d("DeleteCurrentStaticSticker");
            a.c("DeleteCurrentStaticSticker", new Object[0]);
        }

        public static final void deleteStaticStickerWithKey(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "DeleteStaticStickerWithKey", key);
            d.d("DeleteStaticStickerWithKey");
            a.c("DeleteStaticStickerWithKey", new Object[0]);
        }

        public static final void newStaticSticker(StaticStickerItem item) {
            s.h(item, "item");
            String staticStickerItem = item.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "NewStaticSticker", staticStickerItem);
            d.d("NewStaticSticker");
            a.c(s.q("NewStaticSticker:", staticStickerItem), new Object[0]);
        }

        public static final void requestStaticStickerLayerStatusWithKey(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestStaticStickerLayerStatusWithKey", key);
            d.d("RequestStaticStickerLayerStatusWithKey");
            a.c(s.q("RequestStaticStickerLayerStatusWithKey:", key), new Object[0]);
        }

        public static final void selectStaticStickerWithKey(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SelectStaticStickerWithKey", key);
            d.d("SelectStaticStickerWithKey");
            a.c(s.q("SelectStaticStickerWithKey:", key), new Object[0]);
        }

        public static final void selectStaticStickerWithPoint(float f2, float f3) {
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SelectStaticStickerWithPoint", sb.toString());
            d.d("SelectStaticStickerWithPoint");
            a.c("SelectStaticStickerWithPoint:" + f2 + ',' + f3, new Object[0]);
        }

        public static final void staticStickerLayerMoveDown(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "StaticStickerLayerMoveDown", key);
            d.d("StaticStickerLayerMoveDown");
            a.c(s.q("StaticStickerLayerMoveDown:", key), new Object[0]);
        }

        public static final void staticStickerLayerMoveToBottom(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "StaticStickerLayerMoveToBottom", key);
            d.d("StaticStickerLayerMoveToBottom");
            a.c(s.q("StaticStickerLayerMoveToBottom:", key), new Object[0]);
        }

        public static final void staticStickerLayerMoveToTop(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "StaticStickerLayerMoveToTop", key);
            d.d("StaticStickerLayerMoveToTop");
            a.c(s.q("StaticStickerLayerMoveToTop:", key), new Object[0]);
        }

        public static final void staticStickerLayerMoveUp(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "StaticStickerLayerMoveUp", key);
            d.d("StaticStickerLayerMoveUp");
            a.c(s.q("StaticStickerLayerMoveUp:", key), new Object[0]);
        }

        public static final void unSelectCurrentStaticSticker() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UnSelectCurrentStaticSticker", "");
            d.d("UnSelectCurrentStaticSticker");
            a.c("UnSelectCurrentStaticSticker", new Object[0]);
        }

        public static final void updateCurrentStaticSticker(StaticStickerItem item) {
            s.h(item, "item");
            String staticStickerItem = item.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateCurrentStaicSticker", staticStickerItem);
            d.d("UpdateCurrentStaicSticker");
            a.c(s.q("UpdateCurrentStaicSticker:", staticStickerItem), new Object[0]);
        }
    }

    private UnityEditCaller() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String argbColorInt2RgbaString(@ColorInt int i2) {
        int alpha = Color.alpha(i2);
        b.a(16);
        String num = Integer.toString(alpha, 16);
        s.g(num, "toString(this, checkRadix(radix))");
        int red = Color.red(i2);
        b.a(16);
        String num2 = Integer.toString(red, 16);
        s.g(num2, "toString(this, checkRadix(radix))");
        int green = Color.green(i2);
        b.a(16);
        String num3 = Integer.toString(green, 16);
        s.g(num3, "toString(this, checkRadix(radix))");
        int blue = Color.blue(i2);
        b.a(16);
        String num4 = Integer.toString(blue, 16);
        s.g(num4, "toString(this, checkRadix(radix))");
        if (num.length() == 1) {
            num = s.q("0", num);
        }
        if (num2.length() == 1) {
            num2 = s.q("0", num2);
        }
        if (num3.length() == 1) {
            num3 = s.q("0", num3);
        }
        if (num4.length() == 1) {
            num4 = s.q("0", num4);
        }
        return Constants.ID_PREFIX + num2 + num3 + num4 + num;
    }

    /* compiled from: UnityEditCaller.kt */
    /* loaded from: classes6.dex */
    public static final class MagicBG {
        public static final MagicBG INSTANCE = new MagicBG();
        private static final double maxStrokeSize = Resources.getSystem().getDisplayMetrics().density * 10.0d;
        private static final double maxStrokeOffset = Resources.getSystem().getDisplayMetrics().density * 20.0d;
        private static final double maxStrokeOuter = Resources.getSystem().getDisplayMetrics().density * 20.0d;

        private MagicBG() {
        }

        public static final void CurrentMagicBackgroundItemLayerMoveToCurrentItemTypeLayersTop() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CurrentMagicBackgroundItemLayerMoveToCurrentItemTypeLayersTop", "");
            d.d("CurrentMagicBackgroundItemLayerMoveToCurrentItemTypeLayersTop");
            a.c("CurrentMagicBackgroundItemLayerMoveToCurrentItemTypeLayersTop", new Object[0]);
        }

        public static final void copyItem(MagicBgItem item) {
            s.h(item, "item");
            String param = item.toParam();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "CopyCurrentMagicBackgroundItem", item.toParam());
            d.d("CopyCurrentMagicBackgroundItem");
            a.c(s.q("CopyCurrentMagicBackgroundItem:", param), new Object[0]);
        }

        public static final void deleteCurrentItem() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "DeleteCurrentMagicBackgroundItem", "");
            d.d("DeleteCurrentMagicBackgroundItem");
            a.c("DeleteCurrentMagicBackgroundItem", new Object[0]);
        }

        public static final void deleteItem(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "DeleteMagicBackgroundItemWithKey", key);
            d.d("DeleteMagicBackgroundItemWithKey");
            a.c(s.q("DeleteMagicBackgroundItemWithKey:", key), new Object[0]);
        }

        public static final void hideUnmarkedArea(boolean z) {
            String str = z ? "1" : "0";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "HideMagicBackgroundUnmarkedArea", str);
            d.d("HideMagicBackgroundUnmarkedArea");
            a.c(s.q("HideMagicBackgroundUnmarkedArea:", str), new Object[0]);
        }

        public static final void init() {
            StringBuilder sb = new StringBuilder();
            sb.append(maxStrokeSize);
            sb.append(',');
            sb.append(maxStrokeOffset);
            sb.append(',');
            sb.append(maxStrokeOuter);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "InitializedMagicbackgroundInfo", sb2);
            d.d("InitializedMagicbackgroundInfo");
            a.c(s.q("InitializedMagicbackgroundInfo:", sb2), new Object[0]);
        }

        public static final void newItem(MagicBgItem item) {
            s.h(item, "item");
            String param = item.toParam();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "NewMagicBackgroundItem", item.toParam());
            d.d("NewMagicBackgroundItem");
            a.c(s.q("NewMagicBackgroundItem:", param), new Object[0]);
        }

        public static final void prepareMattingMaskImage(String path, int i2, int i3, String maskPath, int i4, int i5) {
            s.h(path, "path");
            s.h(maskPath, "maskPath");
            String str = ',' + path + ',' + i2 + ',' + i3 + ',' + maskPath + ',' + i4 + ',' + i5;
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "PrepareMagicBackgroundMattingMaskImage", str);
            d.d("PrepareMagicBackgroundMattingMaskImage");
            a.c(s.q("PrepareMagicBackgroundMattingMaskImage:", str), new Object[0]);
        }

        public static final void requestCurrentBrushMaskStatus() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RequestMagicBackgroundBrushMaskStatus", "");
            d.d("RequestMagicBackgroundBrushMaskStatus");
            a.c("RequestMagicBackgroundBrushMaskStatus", new Object[0]);
        }

        public static final void selectItem(String key) {
            s.h(key, "key");
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SelectMagicBackgroundItemWithKey", key);
            d.d("SelectMagicBackgroundItemWithKey");
            a.c(s.q("SelectMagicBackgroundItemWithKey:", key), new Object[0]);
        }

        public static final void setBackgroundBrushIntensity(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            String valueOf = String.valueOf(f2);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMagicBackgroundBrushGaussBlurIntensity", valueOf);
            d.d("SetMagicBackgroundBrushGaussBlurIntensity");
            a.c(s.q("SetMagicBackgroundBrushGaussBlurIntensity:", valueOf), new Object[0]);
        }

        public static final void setCurrentBrushEffectApplied(boolean z) {
            String str = z ? "1" : "0";
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SetMagicBackgroundBrushEffectIsApplied", str);
            d.d("SetMagicBackgroundBrushEffectIsApplied");
            a.c(s.q("SetMagicBackgroundBrushEffectIsApplied:", str), new Object[0]);
        }

        public static final void switchItem(List<String> deleteItemKeys, List<MagicBgItem> list) {
            s.h(deleteItemKeys, "deleteItemKeys");
            StringBuilder sb = new StringBuilder();
            for (String str : deleteItemKeys) {
                sb.append(s.q(str, ","));
            }
            StringsKt__StringsKt.J0(sb, ',');
            sb.append("&");
            if (list != null) {
                for (MagicBgItem magicBgItem : list) {
                    sb.append(magicBgItem.toParam());
                    sb.append("&");
                }
            }
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "RemoveAndNewMagicBackgroundItem", sb.toString());
            d.d("RemoveAndNewMagicBackgroundItem");
            a.c(s.q("RemoveAndNewMagicBackgroundItem:", sb), new Object[0]);
        }

        public static final void unSelectCurrentItem() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UnSelectCurrentMagicBackgroundItem", "");
            d.d("UnSelectCurrentMagicBackgroundItem");
            a.c("UnSelectCurrentMagicBackgroundItem", new Object[0]);
        }

        public static final void updateCanvasSize(int i2, int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(',');
            sb.append(i3);
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundCanvasSize", sb.toString());
            d.d("UpdateMagicBackgroundCanvasSize");
            a.c("UpdateMagicBackgroundCanvasSize:" + i2 + ',' + i3, new Object[0]);
        }

        public static final void updateItemPosition(String key, PointF pointF, PointF pointF2, Integer num) {
            s.h(key, "key");
            String positionParam = new MagicBgItem(null, key, null, pointF, pointF2, num, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 4194245, null).toPositionParam();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundItemWithKey", positionParam);
            d.d("UpdateMagicBackgroundItemWithKey");
            a.c(s.q("UpdateMagicBackgroundItemWithKey:", positionParam), new Object[0]);
        }

        public static /* synthetic */ void updateItemPosition$default(String str, PointF pointF, PointF pointF2, Integer num, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                pointF = null;
            }
            if ((i2 & 4) != 0) {
                pointF2 = null;
            }
            if ((i2 & 8) != 0) {
                num = null;
            }
            updateItemPosition(str, pointF, pointF2, num);
        }

        public static final void updateItemSideEffect(MagicBgItem item) {
            s.h(item, "item");
            String paramWithoutPosition = item.toParamWithoutPosition();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundItemSideEffectWithKey", paramWithoutPosition);
            d.d("UpdateMagicBackgroundItemSideEffectWithKey");
            a.c(s.q("UpdateMagicBackgroundItemSideEffectWithKey:", paramWithoutPosition), new Object[0]);
        }

        public final void clearFilterAndHue() {
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundEffectValue", "1=0.0|2=0.0");
            d.d("UpdateMagicBackgroundEffectValue");
            a.c(s.q("UpdateMagicBackgroundEffectValue:", "1=0.0|2=0.0"), new Object[0]);
        }

        public final void setEffectInfo(String filter1Path, String filter2Path, int i2, int i3, int i4, int i5, int i6) {
            s.h(filter1Path, "filter1Path");
            s.h(filter2Path, "filter2Path");
            String str = filter1Path + ',' + filter2Path + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + i6;
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundEffectInfo", str);
            d.d("UpdateMagicBackgroundEffectInfo");
            a.c(s.q("UpdateMagicBackgroundEffectInfo:", str), new Object[0]);
        }

        public final void setFilterValue(float f2) {
            String q = s.q("1=", Float.valueOf(f2));
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundEffectValue", q);
            d.d("UpdateMagicBackgroundEffectValue");
            a.c(s.q("UpdateMagicBackgroundEffectValue:", q), new Object[0]);
        }

        public final void setHueValue(float f2) {
            String q = s.q("2=", Float.valueOf(f2));
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "UpdateMagicBackgroundEffectValue", q);
            d.d("UpdateMagicBackgroundEffectValue");
            a.c(s.q("UpdateMagicBackgroundEffectValue:", q), new Object[0]);
        }

        public static final void selectItem(PointF point) {
            s.h(point, "point");
            StringBuilder sb = new StringBuilder();
            sb.append(point.x);
            sb.append(',');
            sb.append(point.y);
            String sb2 = sb.toString();
            PgUnityPlayer.a(UnityEditCaller.ENGINE_MESSAGE_RECEIVER, "SelectMagicBackgroundItemWithPoint", sb2);
            d.d("SelectMagicBackgroundItemWithPoint");
            a.c(s.q("SelectMagicBackgroundItemWithPoint:", sb2), new Object[0]);
        }
    }
}
