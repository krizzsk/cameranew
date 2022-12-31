package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.g;
import com.facebook.internal.h;
import com.facebook.internal.n;
import com.facebook.internal.s;
import com.facebook.internal.x;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.j;
import com.facebook.share.internal.k;
import com.facebook.share.internal.l;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public final class ShareDialog extends h<ShareContent, com.facebook.share.b> {

    /* renamed from: h  reason: collision with root package name */
    private static final String f3261h = "ShareDialog";

    /* renamed from: i  reason: collision with root package name */
    private static final int f3262i = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();

    /* renamed from: f  reason: collision with root package name */
    private boolean f3263f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3264g;

    /* loaded from: classes.dex */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends h<ShareContent, com.facebook.share.b>.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.a {
            final /* synthetic */ com.facebook.internal.a a;
            final /* synthetic */ ShareContent b;
            final /* synthetic */ boolean c;

            a(b bVar, com.facebook.internal.a aVar, ShareContent shareContent, boolean z) {
                this.a = aVar;
                this.b = shareContent;
                this.c = z;
            }

            @Override // com.facebook.internal.g.a
            public Bundle a() {
                return com.facebook.share.internal.b.e(this.a.b(), this.b, this.c);
            }

            @Override // com.facebook.internal.g.a
            public Bundle getParameters() {
                return com.facebook.share.internal.g.k(this.a.b(), this.b, this.c);
            }
        }

        private b() {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.h.a
        public Object c() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.w(shareContent.getClass());
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(ShareContent shareContent) {
            j.w(shareContent);
            com.facebook.internal.a e2 = ShareDialog.this.e();
            g.i(e2, new a(this, e2, shareContent, ShareDialog.this.A()), ShareDialog.z(shareContent.getClass()));
            return e2;
        }

        /* synthetic */ b(ShareDialog shareDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class c extends h<ShareContent, com.facebook.share.b>.a {
        private c() {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.h.a
        public Object c() {
            return Mode.FEED;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(ShareContent shareContent) {
            Bundle e2;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.B(shareDialog.f(), shareContent, Mode.FEED);
            com.facebook.internal.a e3 = ShareDialog.this.e();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                j.y(shareLinkContent);
                e2 = l.f(shareLinkContent);
            } else {
                e2 = l.e((ShareFeedContent) shareContent);
            }
            g.k(e3, "feed", e2);
            return e3;
        }

        /* synthetic */ c(ShareDialog shareDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class d extends h<ShareContent, com.facebook.share.b>.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.a {
            final /* synthetic */ com.facebook.internal.a a;
            final /* synthetic */ ShareContent b;
            final /* synthetic */ boolean c;

            a(d dVar, com.facebook.internal.a aVar, ShareContent shareContent, boolean z) {
                this.a = aVar;
                this.b = shareContent;
                this.c = z;
            }

            @Override // com.facebook.internal.g.a
            public Bundle a() {
                return com.facebook.share.internal.b.e(this.a.b(), this.b, this.c);
            }

            @Override // com.facebook.internal.g.a
            public Bundle getParameters() {
                return com.facebook.share.internal.g.k(this.a.b(), this.b, this.c);
            }
        }

        private d() {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.h.a
        public Object c() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            boolean z2;
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (z) {
                z2 = true;
            } else {
                z2 = shareContent.h() != null ? g.a(ShareDialogFeature.HASHTAG) : true;
                if ((shareContent instanceof ShareLinkContent) && !x.S(((ShareLinkContent) shareContent).n())) {
                    z2 &= g.a(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            return z2 && ShareDialog.w(shareContent.getClass());
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(ShareContent shareContent) {
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.B(shareDialog.f(), shareContent, Mode.NATIVE);
            j.w(shareContent);
            com.facebook.internal.a e2 = ShareDialog.this.e();
            g.i(e2, new a(this, e2, shareContent, ShareDialog.this.A()), ShareDialog.z(shareContent.getClass()));
            return e2;
        }

        /* synthetic */ d(ShareDialog shareDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class e extends h<ShareContent, com.facebook.share.b>.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.a {
            final /* synthetic */ com.facebook.internal.a a;
            final /* synthetic */ ShareContent b;
            final /* synthetic */ boolean c;

            a(e eVar, com.facebook.internal.a aVar, ShareContent shareContent, boolean z) {
                this.a = aVar;
                this.b = shareContent;
                this.c = z;
            }

            @Override // com.facebook.internal.g.a
            public Bundle a() {
                return com.facebook.share.internal.b.e(this.a.b(), this.b, this.c);
            }

            @Override // com.facebook.internal.g.a
            public Bundle getParameters() {
                return com.facebook.share.internal.g.k(this.a.b(), this.b, this.c);
            }
        }

        private e() {
            super(ShareDialog.this);
        }

        @Override // com.facebook.internal.h.a
        public Object c() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareStoryContent) && ShareDialog.w(shareContent.getClass());
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(ShareContent shareContent) {
            j.x(shareContent);
            com.facebook.internal.a e2 = ShareDialog.this.e();
            g.i(e2, new a(this, e2, shareContent, ShareDialog.this.A()), ShareDialog.z(shareContent.getClass()));
            return e2;
        }

        /* synthetic */ e(ShareDialog shareDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class f extends h<ShareContent, com.facebook.share.b>.a {
        private f() {
            super(ShareDialog.this);
        }

        private SharePhotoContent e(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.b r = new SharePhotoContent.b().r(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < sharePhotoContent.k().size(); i2++) {
                SharePhoto sharePhoto = sharePhotoContent.k().get(i2);
                Bitmap c = sharePhoto.c();
                if (c != null) {
                    s.b d2 = s.d(uuid, c);
                    SharePhoto.b m = new SharePhoto.b().m(sharePhoto);
                    m.q(Uri.parse(d2.g()));
                    m.o(null);
                    sharePhoto = m.i();
                    arrayList2.add(d2);
                }
                arrayList.add(sharePhoto);
            }
            r.s(arrayList);
            s.a(arrayList2);
            return r.q();
        }

        private String g(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return FirebaseAnalytics.Event.SHARE;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        @Override // com.facebook.internal.h.a
        public Object c() {
            return Mode.WEB;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            return shareContent != null && ShareDialog.x(shareContent);
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: f */
        public com.facebook.internal.a b(ShareContent shareContent) {
            Bundle b;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.B(shareDialog.f(), shareContent, Mode.WEB);
            com.facebook.internal.a e2 = ShareDialog.this.e();
            j.y(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                b = l.a((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                b = l.c(e((SharePhotoContent) shareContent, e2.b()));
            } else {
                b = l.b((ShareOpenGraphContent) shareContent);
            }
            g.k(e2, g(shareContent), b);
            return e2;
        }

        /* synthetic */ f(ShareDialog shareDialog, a aVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShareDialog(android.app.Activity r2) {
        /*
            r1 = this;
            int r0 = com.facebook.share.widget.ShareDialog.f3262i
            r1.<init>(r2, r0)
            r2 = 0
            r1.f3263f = r2
            r2 = 1
            r1.f3264g = r2
            com.facebook.share.internal.k.y(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.<init>(android.app.Activity):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Context context, ShareContent shareContent, Mode mode) {
        if (this.f3264g) {
            mode = Mode.AUTOMATIC;
        }
        int i2 = a.a[mode.ordinal()];
        String str = "unknown";
        String str2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : TapjoyConstants.TJC_PLUGIN_NATIVE : "web" : "automatic";
        com.facebook.internal.f z = z(shareContent.getClass());
        if (z == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (z == ShareDialogFeature.PHOTOS) {
            str = "photo";
        } else if (z == ShareDialogFeature.VIDEO) {
            str = "video";
        } else if (z == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str = "open_graph";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString("fb_share_dialog_content_type", str);
        internalAppEventsLogger.j("fb_share_dialog_show", bundle);
    }

    public static boolean v(Class<? extends ShareContent> cls) {
        return y(cls) || w(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Class<? extends ShareContent> cls) {
        com.facebook.internal.f z = z(cls);
        return z != null && g.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(ShareContent shareContent) {
        if (y(shareContent.getClass())) {
            if (shareContent instanceof ShareOpenGraphContent) {
                try {
                    k.C((ShareOpenGraphContent) shareContent);
                    return true;
                } catch (Exception e2) {
                    x.Z(f3261h, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e2);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean y(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.internal.f z(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            return CameraEffectFeature.SHARE_CAMERA_EFFECT;
        }
        if (ShareStoryContent.class.isAssignableFrom(cls)) {
            return ShareStoryFeature.SHARE_STORY_ASSET;
        }
        return null;
    }

    public boolean A() {
        return this.f3263f;
    }

    public void C(ShareContent shareContent, Mode mode) {
        boolean z = mode == Mode.AUTOMATIC;
        this.f3264g = z;
        Mode mode2 = mode;
        if (z) {
            mode2 = h.f3050e;
        }
        l(shareContent, mode2);
    }

    @Override // com.facebook.internal.h
    protected com.facebook.internal.a e() {
        return new com.facebook.internal.a(h());
    }

    @Override // com.facebook.internal.h
    protected List<h<ShareContent, com.facebook.share.b>.a> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this, null));
        arrayList.add(new c(this, null));
        arrayList.add(new f(this, null));
        arrayList.add(new b(this, null));
        arrayList.add(new e(this, null));
        return arrayList;
    }

    @Override // com.facebook.internal.h
    protected void j(CallbackManagerImpl callbackManagerImpl, com.facebook.e<com.facebook.share.b> eVar) {
        k.x(h(), callbackManagerImpl, eVar);
    }

    public boolean u(ShareContent shareContent, Mode mode) {
        Mode mode2 = mode;
        if (mode == Mode.AUTOMATIC) {
            mode2 = h.f3050e;
        }
        return c(shareContent, mode2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(Activity activity, int i2) {
        super(activity, i2);
        this.f3263f = false;
        this.f3264g = true;
        k.y(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(Fragment fragment, int i2) {
        this(new n(fragment), i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(android.app.Fragment fragment, int i2) {
        this(new n(fragment), i2);
    }

    private ShareDialog(n nVar, int i2) {
        super(nVar, i2);
        this.f3263f = false;
        this.f3264g = true;
        k.y(i2);
    }
}
