package us.pinguo.picker.image.gallery;

import android.app.Application;
import java.util.TimeZone;
/* compiled from: AbstractAlbum.java */
/* loaded from: classes5.dex */
public abstract class a extends o {

    /* renamed from: e  reason: collision with root package name */
    protected final Application f11685e;

    static {
        TimeZone.getDefault().getRawOffset();
    }

    public a(Application application, Path path, long j2) {
        super(path, j2);
        this.f11685e = application;
    }
}
