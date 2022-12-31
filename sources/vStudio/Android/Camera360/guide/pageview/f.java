package vStudio.Android.Camera360.guide.pageview;

import android.net.Uri;
import kotlin.jvm.internal.s;
/* compiled from: GuideModel.kt */
/* loaded from: classes7.dex */
public final class f {
    private Uri a;
    private int b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f12624d;

    public f(Uri guideVideo, int i2, String title, String desc) {
        s.h(guideVideo, "guideVideo");
        s.h(title, "title");
        s.h(desc, "desc");
        this.a = guideVideo;
        this.b = i2;
        this.c = title;
        this.f12624d = desc;
    }

    public final String a() {
        return this.f12624d;
    }

    public final Uri b() {
        return this.a;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return s.c(this.a, fVar.a) && this.b == fVar.b && s.c(this.c, fVar.c) && s.c(this.f12624d, fVar.f12624d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.f12624d.hashCode();
    }

    public String toString() {
        return "PayWallGuideModel(guideVideo=" + this.a + ", guideImg=" + this.b + ", title=" + this.c + ", desc=" + this.f12624d + ')';
    }
}
