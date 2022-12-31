package com.pinguo.camera360.effect.model.entity.texture;

import java.util.List;
/* loaded from: classes3.dex */
public class Texture {
    private static final String TAG = "Texture";
    public List<TextureItem> items;
    public int rule;
    public String textureDir = "";

    /* loaded from: classes3.dex */
    public enum Rule {
        NONE(0),
        FIRST(1),
        RANDOM(2);
        
        private int value;

        Rule(int i2) {
            this.value = 0;
            this.value = i2;
        }

        public int value() {
            return this.value;
        }
    }

    public static boolean isLegal(Texture texture) {
        String str;
        List<TextureItem> list;
        return (texture == null || (str = texture.textureDir) == null || "".equals(str) || (list = texture.items) == null || list.size() == 0) ? false : true;
    }

    public boolean hasLutTexture() {
        List<TextureItem> list = this.items;
        if (list == null) {
            return false;
        }
        for (TextureItem textureItem : list) {
            if (textureItem.enableRotation == TextureItem.ROTATE_DISABLE_LUT) {
                return true;
            }
        }
        return false;
    }
}
