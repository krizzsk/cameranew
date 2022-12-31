package com.google.android.play.core.splitinstall;
/* loaded from: classes2.dex */
public class SplitInstallException extends com.google.android.play.core.tasks.j {
    private final int a;

    public SplitInstallException(int i2) {
        super(String.format("Split Install Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.splitinstall.e0.a.a(i2)));
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
