package com.facebook.soloader;
/* compiled from: NativeLoaderToSoLoaderDelegate.java */
/* loaded from: classes.dex */
public class i implements com.facebook.soloader.n.b {
    @Override // com.facebook.soloader.n.b
    public boolean a(String str, int i2) {
        return SoLoader.i(str, ((i2 & 1) != 0 ? 16 : 0) | 0);
    }
}
