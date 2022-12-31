package com.google.android.play.core.install;

import com.google.android.play.core.tasks.j;
/* loaded from: classes2.dex */
public class InstallException extends j {
    private final int a;

    public InstallException(int i2) {
        super(String.format("Install Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.install.b.a.a(i2)));
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
