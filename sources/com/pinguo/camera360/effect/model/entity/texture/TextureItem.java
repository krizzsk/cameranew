package com.pinguo.camera360.effect.model.entity.texture;
/* loaded from: classes3.dex */
public class TextureItem {
    public static int ROTATE_DISABLE_LUT = 1;
    public static int ROTATE_DISABLE_NORMAL = 2;
    public static int ROTATE_ENABLE = 0;
    private static final String TAG = "TextureItem";
    public int index;
    public int type = Type.NORMAL.value;
    public String name = "";
    public int enableRotation = ROTATE_ENABLE;

    /* loaded from: classes3.dex */
    public enum Type {
        NORMAL(1);
        
        private int value;

        Type(int i2) {
            this.value = 0;
            this.value = i2;
        }

        public int value() {
            return this.value;
        }
    }
}
