package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.h;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.core.i;
import com.facebook.imagepipeline.e.e;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ImageRequestBuilder {
    @Nullable
    private e n;
    private int q;
    private Uri a = null;
    private ImageRequest.RequestLevel b = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private d c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.imagepipeline.common.e f3013d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.common.b f3014e = com.facebook.imagepipeline.common.b.a();

    /* renamed from: f  reason: collision with root package name */
    private ImageRequest.CacheChoice f3015f = ImageRequest.CacheChoice.DEFAULT;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3016g = i.F().a();

    /* renamed from: h  reason: collision with root package name */
    private boolean f3017h = false;

    /* renamed from: i  reason: collision with root package name */
    private Priority f3018i = Priority.HIGH;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private a f3019j = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3020k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3021l = true;
    @Nullable
    private Boolean m = null;
    @Nullable
    private com.facebook.imagepipeline.common.a o = null;
    @Nullable
    private Boolean p = null;

    /* loaded from: classes.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    private ImageRequestBuilder() {
    }

    public static ImageRequestBuilder b(ImageRequest imageRequest) {
        ImageRequestBuilder s = s(imageRequest.s());
        s.w(imageRequest.f());
        s.t(imageRequest.c());
        s.u(imageRequest.d());
        s.x(imageRequest.g());
        s.y(imageRequest.h());
        s.z(imageRequest.i());
        s.A(imageRequest.m());
        s.C(imageRequest.l());
        s.D(imageRequest.o());
        s.B(imageRequest.n());
        s.E(imageRequest.q());
        s.F(imageRequest.x());
        s.v(imageRequest.e());
        return s;
    }

    public static ImageRequestBuilder s(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = new ImageRequestBuilder();
        imageRequestBuilder.G(uri);
        return imageRequestBuilder;
    }

    public ImageRequestBuilder A(boolean z) {
        this.f3016g = z;
        return this;
    }

    public ImageRequestBuilder B(@Nullable e eVar) {
        this.n = eVar;
        return this;
    }

    public ImageRequestBuilder C(Priority priority) {
        this.f3018i = priority;
        return this;
    }

    public ImageRequestBuilder D(@Nullable d dVar) {
        this.c = dVar;
        return this;
    }

    public ImageRequestBuilder E(@Nullable com.facebook.imagepipeline.common.e eVar) {
        this.f3013d = eVar;
        return this;
    }

    public ImageRequestBuilder F(@Nullable Boolean bool) {
        this.m = bool;
        return this;
    }

    public ImageRequestBuilder G(Uri uri) {
        h.g(uri);
        this.a = uri;
        return this;
    }

    @Nullable
    public Boolean H() {
        return this.m;
    }

    protected void I() {
        Uri uri = this.a;
        if (uri != null) {
            if (com.facebook.common.util.d.l(uri)) {
                if (this.a.isAbsolute()) {
                    if (!this.a.getPath().isEmpty()) {
                        try {
                            Integer.parseInt(this.a.getPath().substring(1));
                        } catch (NumberFormatException unused) {
                            throw new BuilderException("Resource URI path must be a resource id.");
                        }
                    } else {
                        throw new BuilderException("Resource URI must not be empty");
                    }
                } else {
                    throw new BuilderException("Resource URI path must be absolute.");
                }
            }
            if (com.facebook.common.util.d.g(this.a) && !this.a.isAbsolute()) {
                throw new BuilderException("Asset URI path must be absolute.");
            }
            return;
        }
        throw new BuilderException("Source must be set!");
    }

    public ImageRequest a() {
        I();
        return new ImageRequest(this);
    }

    @Nullable
    public com.facebook.imagepipeline.common.a c() {
        return this.o;
    }

    public ImageRequest.CacheChoice d() {
        return this.f3015f;
    }

    public int e() {
        return this.q;
    }

    public com.facebook.imagepipeline.common.b f() {
        return this.f3014e;
    }

    public ImageRequest.RequestLevel g() {
        return this.b;
    }

    @Nullable
    public a h() {
        return this.f3019j;
    }

    @Nullable
    public e i() {
        return this.n;
    }

    public Priority j() {
        return this.f3018i;
    }

    @Nullable
    public d k() {
        return this.c;
    }

    @Nullable
    public Boolean l() {
        return this.p;
    }

    @Nullable
    public com.facebook.imagepipeline.common.e m() {
        return this.f3013d;
    }

    public Uri n() {
        return this.a;
    }

    public boolean o() {
        return this.f3020k && com.facebook.common.util.d.m(this.a);
    }

    public boolean p() {
        return this.f3017h;
    }

    public boolean q() {
        return this.f3021l;
    }

    public boolean r() {
        return this.f3016g;
    }

    public ImageRequestBuilder t(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.o = aVar;
        return this;
    }

    public ImageRequestBuilder u(ImageRequest.CacheChoice cacheChoice) {
        this.f3015f = cacheChoice;
        return this;
    }

    public ImageRequestBuilder v(int i2) {
        this.q = i2;
        return this;
    }

    public ImageRequestBuilder w(com.facebook.imagepipeline.common.b bVar) {
        this.f3014e = bVar;
        return this;
    }

    public ImageRequestBuilder x(boolean z) {
        this.f3017h = z;
        return this;
    }

    public ImageRequestBuilder y(ImageRequest.RequestLevel requestLevel) {
        this.b = requestLevel;
        return this;
    }

    public ImageRequestBuilder z(@Nullable a aVar) {
        this.f3019j = aVar;
        return this;
    }
}
