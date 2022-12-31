package pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
/* compiled from: InputSource.java */
/* loaded from: classes3.dex */
public abstract class f {

    /* compiled from: InputSource.java */
    /* loaded from: classes3.dex */
    public static final class b extends f {
        private final AssetManager a;
        private final String b;

        public b(@NonNull AssetManager assetManager, @NonNull String str) {
            super();
            this.a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.f
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openFd(this.b));
        }
    }

    /* compiled from: InputSource.java */
    /* loaded from: classes3.dex */
    public static class c extends f {
        private final Resources a;
        private final int b;

        public c(@NonNull Resources resources, @DrawableRes @RawRes int i2) {
            super();
            this.a = resources;
            this.b = i2;
        }

        @Override // pl.droidsonroids.gif.f
        GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openRawResourceFd(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle a() throws IOException;

    private f() {
    }
}
