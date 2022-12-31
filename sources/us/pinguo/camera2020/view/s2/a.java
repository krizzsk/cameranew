package us.pinguo.camera2020.view.s2;

import androidx.databinding.ObservableBoolean;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.info.CameraFrame;
/* compiled from: FrameItemCell.kt */
/* loaded from: classes3.dex */
public final class a {
    private ObservableBoolean a;
    private final CameraFrame b;

    public a(ObservableBoolean selected, CameraFrame frameRatio) {
        s.h(selected, "selected");
        s.h(frameRatio, "frameRatio");
        this.a = selected;
        this.b = frameRatio;
    }

    public final CameraFrame a() {
        return this.b;
    }

    public final ObservableBoolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return s.c(this.a, aVar.a) && this.b == aVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FrameItem(selected=" + this.a + ", frameRatio=" + this.b + ')';
    }
}
