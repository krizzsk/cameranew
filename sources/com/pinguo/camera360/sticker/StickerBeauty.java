package com.pinguo.camera360.sticker;
/* loaded from: classes3.dex */
public class StickerBeauty {
    public AndroidBeauty Android;

    /* loaded from: classes3.dex */
    public static class AndroidBeauty {
        public MakeupInfo custom;
        public String pid;
        public boolean enable = true;
        public Control control = new Control();
    }

    /* loaded from: classes3.dex */
    public static class Control {
        public String faceType;
        public boolean showFaceShapeSlider2 = true;
        public boolean showFaceBeautySlider2 = true;
        public boolean resetFaceShapeValue2 = false;
        public boolean resetFaceBeautyValue2 = false;
    }

    /* loaded from: classes3.dex */
    public static class MakeupInfo {
        public String folder;
        public String[] makeup;
    }
}
