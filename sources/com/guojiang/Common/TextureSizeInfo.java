package com.guojiang.Common;
/* loaded from: classes2.dex */
public class TextureSizeInfo {
    public int mHeight;
    public int mWidth;

    public TextureSizeInfo(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public boolean isEquals(TextureSizeInfo textureSizeInfo) {
        return textureSizeInfo != null && this.mWidth == textureSizeInfo.mWidth && this.mHeight == textureSizeInfo.mHeight;
    }
}
