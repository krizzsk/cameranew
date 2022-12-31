package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class NativeOnCompleteListener implements a<Object> {
    private final long a;
    private final int b;

    public native void nativeOnComplete(long j2, int i2, @Nullable Object obj, int i3);

    @Override // com.google.android.play.core.tasks.a
    public void onComplete(d<Object> dVar) {
        if (!dVar.h()) {
            int i2 = this.b;
            StringBuilder sb = new StringBuilder(50);
            sb.append("onComplete called for incomplete task: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        } else if (dVar.i()) {
            nativeOnComplete(this.a, this.b, dVar.g(), 0);
        } else {
            Exception f2 = dVar.f();
            if (!(f2 instanceof j)) {
                nativeOnComplete(this.a, this.b, null, -100);
                return;
            }
            int errorCode = ((j) f2).getErrorCode();
            if (errorCode != 0) {
                nativeOnComplete(this.a, this.b, null, errorCode);
                return;
            }
            int i3 = this.b;
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("TaskException has error code 0 on task: ");
            sb2.append(i3);
            throw new IllegalStateException(sb2.toString());
        }
    }
}
