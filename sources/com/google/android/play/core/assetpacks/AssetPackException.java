package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
public class AssetPackException extends com.google.android.play.core.tasks.j {
    private final int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetPackException(int i2) {
        super(String.format("Asset Pack Download Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.assetpacks.o3.a.a(i2)));
        if (i2 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
        this.a = i2;
    }

    @Override // com.google.android.play.core.tasks.j
    public int getErrorCode() {
        return this.a;
    }
}
