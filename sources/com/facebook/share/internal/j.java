package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;
/* compiled from: ShareContentValidation.java */
/* loaded from: classes.dex */
public class j {
    private static c a;
    private static c b;
    private static c c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* loaded from: classes.dex */
    public static class b extends c {
        private b() {
            super();
        }

        @Override // com.facebook.share.internal.j.c
        public void o(ShareStoryContent shareStoryContent) {
            j.S(shareStoryContent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* loaded from: classes.dex */
    public static class c {
        private boolean a;

        private c() {
            this.a = false;
        }

        public boolean a() {
            return this.a;
        }

        public void b(ShareCameraEffectContent shareCameraEffectContent) {
            j.u(shareCameraEffectContent, this);
        }

        public void c(ShareLinkContent shareLinkContent) {
            j.z(shareLinkContent, this);
        }

        public void d(ShareMedia shareMedia) {
            j.B(shareMedia, this);
        }

        public void e(ShareMediaContent shareMediaContent) {
            j.A(shareMediaContent, this);
        }

        public void f(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            j.P(shareMessengerGenericTemplateContent);
        }

        public void g(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            j.Q(shareMessengerMediaTemplateContent);
        }

        public void h(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            j.C(shareMessengerOpenGraphMusicTemplateContent);
        }

        public void i(ShareOpenGraphAction shareOpenGraphAction) {
            j.D(shareOpenGraphAction, this);
        }

        public void j(ShareOpenGraphContent shareOpenGraphContent) {
            this.a = true;
            j.E(shareOpenGraphContent, this);
        }

        public void k(ShareOpenGraphObject shareOpenGraphObject) {
            j.G(shareOpenGraphObject, this);
        }

        public void l(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            j.H(shareOpenGraphValueContainer, this, z);
        }

        public void m(SharePhoto sharePhoto) {
            j.M(sharePhoto, this);
        }

        public void n(SharePhotoContent sharePhotoContent) {
            j.K(sharePhotoContent, this);
        }

        public void o(ShareStoryContent shareStoryContent) {
            j.S(shareStoryContent, this);
        }

        public void p(ShareVideo shareVideo) {
            j.T(shareVideo, this);
        }

        public void q(ShareVideoContent shareVideoContent) {
            j.U(shareVideoContent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* loaded from: classes.dex */
    public static class d extends c {
        private d() {
            super();
        }

        @Override // com.facebook.share.internal.j.c
        public void e(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.j.c
        public void m(SharePhoto sharePhoto) {
            j.N(sharePhoto, this);
        }

        @Override // com.facebook.share.internal.j.c
        public void q(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(ShareMediaContent shareMediaContent, c cVar) {
        List<ShareMedia> k2 = shareMediaContent.k();
        if (k2 != null && !k2.isEmpty()) {
            if (k2.size() <= 6) {
                for (ShareMedia shareMedia : k2) {
                    cVar.d(shareMedia);
                }
                return;
            }
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
        }
        throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
    }

    public static void B(ShareMedia shareMedia, c cVar) {
        if (shareMedia instanceof SharePhoto) {
            cVar.m((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            cVar.p((ShareVideo) shareMedia);
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        if (!x.S(shareMessengerOpenGraphMusicTemplateContent.b())) {
            if (shareMessengerOpenGraphMusicTemplateContent.l() != null) {
                O(shareMessengerOpenGraphMusicTemplateContent.k());
                return;
            }
            throw new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(ShareOpenGraphAction shareOpenGraphAction, c cVar) {
        if (shareOpenGraphAction != null) {
            if (!x.S(shareOpenGraphAction.g())) {
                cVar.l(shareOpenGraphAction, false);
                return;
            }
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(ShareOpenGraphContent shareOpenGraphContent, c cVar) {
        cVar.i(shareOpenGraphContent.k());
        String l2 = shareOpenGraphContent.l();
        if (!x.S(l2)) {
            if (shareOpenGraphContent.k().a(l2) != null) {
                return;
            }
            throw new FacebookException("Property \"" + l2 + "\" was not found on the action. The name of the preview property must match the name of an action property.");
        }
        throw new FacebookException("Must specify a previewPropertyName.");
    }

    private static void F(String str, boolean z) {
        if (z) {
            String[] split = str.split(":");
            if (split.length >= 2) {
                for (String str2 : split) {
                    if (str2.isEmpty()) {
                        throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                    }
                }
                return;
            }
            throw new FacebookException("Open Graph keys must be namespaced: %s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(ShareOpenGraphObject shareOpenGraphObject, c cVar) {
        if (shareOpenGraphObject != null) {
            cVar.l(shareOpenGraphObject, true);
            return;
        }
        throw new FacebookException("Cannot share a null ShareOpenGraphObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(ShareOpenGraphValueContainer shareOpenGraphValueContainer, c cVar, boolean z) {
        for (String str : shareOpenGraphValueContainer.f()) {
            F(str, z);
            Object a2 = shareOpenGraphValueContainer.a(str);
            if (a2 instanceof List) {
                for (Object obj : (List) a2) {
                    if (obj != null) {
                        I(obj, cVar);
                    } else {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                }
                continue;
            } else {
                I(a2, cVar);
            }
        }
    }

    private static void I(Object obj, c cVar) {
        if (obj instanceof ShareOpenGraphObject) {
            cVar.k((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            cVar.m((SharePhoto) obj);
        }
    }

    private static void J(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap c2 = sharePhoto.c();
            Uri g2 = sharePhoto.g();
            if (c2 == null && g2 == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(SharePhotoContent sharePhotoContent, c cVar) {
        List<SharePhoto> k2 = sharePhotoContent.k();
        if (k2 != null && !k2.isEmpty()) {
            if (k2.size() <= 6) {
                for (SharePhoto sharePhoto : k2) {
                    cVar.m(sharePhoto);
                }
                return;
            }
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
        }
        throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
    }

    private static void L(SharePhoto sharePhoto, c cVar) {
        J(sharePhoto);
        Bitmap c2 = sharePhoto.c();
        Uri g2 = sharePhoto.g();
        if (c2 == null && x.U(g2) && !cVar.a()) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(SharePhoto sharePhoto, c cVar) {
        L(sharePhoto, cVar);
        if (sharePhoto.c() == null && x.U(sharePhoto.g())) {
            return;
        }
        y.d(com.facebook.f.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(SharePhoto sharePhoto, c cVar) {
        J(sharePhoto);
    }

    private static void O(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        if (!x.S(shareMessengerActionButton.a())) {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                R((ShareMessengerURLActionButton) shareMessengerActionButton);
                return;
            }
            return;
        }
        throw new FacebookException("Must specify title for ShareMessengerActionButton");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        if (!x.S(shareMessengerGenericTemplateContent.b())) {
            if (shareMessengerGenericTemplateContent.k() != null) {
                if (!x.S(shareMessengerGenericTemplateContent.k().g())) {
                    O(shareMessengerGenericTemplateContent.k().a());
                    return;
                }
                throw new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
            }
            throw new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        if (!x.S(shareMessengerMediaTemplateContent.b())) {
            if (shareMessengerMediaTemplateContent.n() == null && x.S(shareMessengerMediaTemplateContent.k())) {
                throw new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            }
            O(shareMessengerMediaTemplateContent.l());
            return;
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
    }

    private static void R(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.g() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(ShareStoryContent shareStoryContent, c cVar) {
        if (shareStoryContent != null && (shareStoryContent.l() != null || shareStoryContent.n() != null)) {
            if (shareStoryContent.l() != null) {
                cVar.d(shareStoryContent.l());
            }
            if (shareStoryContent.n() != null) {
                cVar.m(shareStoryContent.n());
                return;
            }
            return;
        }
        throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(ShareVideo shareVideo, c cVar) {
        if (shareVideo != null) {
            Uri c2 = shareVideo.c();
            if (c2 != null) {
                if (!x.O(c2) && !x.R(c2)) {
                    throw new FacebookException("ShareVideo must reference a video that is on the device");
                }
                return;
            }
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        throw new FacebookException("Cannot share a null ShareVideo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U(ShareVideoContent shareVideoContent, c cVar) {
        cVar.p(shareVideoContent.n());
        SharePhoto m = shareVideoContent.m();
        if (m != null) {
            cVar.m(m);
        }
    }

    private static c q() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    private static c r() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private static c s() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private static void t(ShareContent shareContent, c cVar) throws FacebookException {
        if (shareContent != null) {
            if (shareContent instanceof ShareLinkContent) {
                cVar.c((ShareLinkContent) shareContent);
                return;
            } else if (shareContent instanceof SharePhotoContent) {
                cVar.n((SharePhotoContent) shareContent);
                return;
            } else if (shareContent instanceof ShareVideoContent) {
                cVar.q((ShareVideoContent) shareContent);
                return;
            } else if (shareContent instanceof ShareOpenGraphContent) {
                cVar.j((ShareOpenGraphContent) shareContent);
                return;
            } else if (shareContent instanceof ShareMediaContent) {
                cVar.e((ShareMediaContent) shareContent);
                return;
            } else if (shareContent instanceof ShareCameraEffectContent) {
                cVar.b((ShareCameraEffectContent) shareContent);
                return;
            } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                cVar.h((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
                return;
            } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                cVar.g((ShareMessengerMediaTemplateContent) shareContent);
                return;
            } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
                cVar.f((ShareMessengerGenericTemplateContent) shareContent);
                return;
            } else if (shareContent instanceof ShareStoryContent) {
                cVar.o((ShareStoryContent) shareContent);
                return;
            } else {
                return;
            }
        }
        throw new FacebookException("Must provide non-null content to share");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(ShareCameraEffectContent shareCameraEffectContent, c cVar) {
        if (x.S(shareCameraEffectContent.l())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    public static void v(ShareContent shareContent) {
        t(shareContent, q());
    }

    public static void w(ShareContent shareContent) {
        t(shareContent, q());
    }

    public static void x(ShareContent shareContent) {
        t(shareContent, r());
    }

    public static void y(ShareContent shareContent) {
        t(shareContent, s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(ShareLinkContent shareLinkContent, c cVar) {
        Uri m = shareLinkContent.m();
        if (m != null && !x.U(m)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }
}
