package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.s;
import com.facebook.internal.t;
import com.facebook.internal.x;
import com.facebook.share.internal.h;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class a implements x.d<s.b, Bundle> {
        a() {
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public Bundle apply(s.b bVar) {
            Bundle bundle = new Bundle();
            bundle.putString("uri", bVar.g());
            String o = k.o(bVar.h());
            if (o != null) {
                x.g0(bundle, "extension", o);
            }
            return bundle;
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class b implements x.d<ShareMedia, Bundle> {
        final /* synthetic */ UUID a;
        final /* synthetic */ List b;

        b(UUID uuid, List list) {
            this.a = uuid;
            this.b = list;
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public Bundle apply(ShareMedia shareMedia) {
            s.b a = k.a(this.a, shareMedia);
            this.b.add(a);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia.a().name());
            bundle.putString("uri", a.g());
            String o = k.o(a.h());
            if (o != null) {
                x.g0(bundle, "extension", o);
            }
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    public static class c extends com.facebook.share.internal.i {
        final /* synthetic */ com.facebook.e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.facebook.e eVar, com.facebook.e eVar2) {
            super(eVar);
            this.b = eVar2;
        }

        @Override // com.facebook.share.internal.i
        public void a(com.facebook.internal.a aVar) {
            k.r(this.b);
        }

        @Override // com.facebook.share.internal.i
        public void b(com.facebook.internal.a aVar, FacebookException facebookException) {
            k.s(this.b, facebookException);
        }

        @Override // com.facebook.share.internal.i
        public void c(com.facebook.internal.a aVar, Bundle bundle) {
            if (bundle != null) {
                String i2 = k.i(bundle);
                if (i2 != null && !"post".equalsIgnoreCase(i2)) {
                    if ("cancel".equalsIgnoreCase(i2)) {
                        k.r(this.b);
                        return;
                    } else {
                        k.s(this.b, new FacebookException("UnknownError"));
                        return;
                    }
                }
                k.t(this.b, k.k(bundle));
            }
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class d implements CallbackManagerImpl.a {
        final /* synthetic */ int a;

        d(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return k.q(this.a, i2, intent, k.l(null));
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class e implements CallbackManagerImpl.a {
        final /* synthetic */ int a;
        final /* synthetic */ com.facebook.e b;

        e(int i2, com.facebook.e eVar) {
            this.a = i2;
            this.b = eVar;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return k.q(this.a, i2, intent, k.l(this.b));
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class f implements x.d<SharePhoto, s.b> {
        final /* synthetic */ UUID a;

        f(UUID uuid) {
            this.a = uuid;
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public s.b apply(SharePhoto sharePhoto) {
            return k.a(this.a, sharePhoto);
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class g implements x.d<s.b, String> {
        g() {
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public String apply(s.b bVar) {
            return bVar.g();
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class h implements x.d<ShareMedia, Bundle> {
        final /* synthetic */ UUID a;
        final /* synthetic */ List b;

        h(UUID uuid, List list) {
            this.a = uuid;
            this.b = list;
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public Bundle apply(ShareMedia shareMedia) {
            s.b a = k.a(this.a, shareMedia);
            this.b.add(a);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia.a().name());
            bundle.putString("uri", a.g());
            return bundle;
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class i implements h.a {
        final /* synthetic */ UUID a;
        final /* synthetic */ ArrayList b;

        i(UUID uuid, ArrayList arrayList) {
            this.a = uuid;
            this.b = arrayList;
        }

        @Override // com.facebook.share.internal.h.a
        public JSONObject a(SharePhoto sharePhoto) {
            s.b a = k.a(this.a, sharePhoto);
            if (a == null) {
                return null;
            }
            this.b.add(a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", a.g());
                if (sharePhoto.h()) {
                    jSONObject.put("user_generated", true);
                }
                return jSONObject;
            } catch (JSONException e2) {
                throw new FacebookException("Unable to attach images", e2);
            }
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* loaded from: classes.dex */
    static class j implements h.a {
        j() {
        }

        @Override // com.facebook.share.internal.h.a
        public JSONObject a(SharePhoto sharePhoto) {
            Uri g2 = sharePhoto.g();
            if (x.U(g2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", g2.toString());
                    return jSONObject;
                } catch (JSONException e2) {
                    throw new FacebookException("Unable to attach images", e2);
                }
            }
            throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
        }
    }

    /* compiled from: ShareInternalUtility.java */
    /* renamed from: com.facebook.share.internal.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0120k implements x.d<SharePhoto, s.b> {
        final /* synthetic */ UUID a;

        C0120k(UUID uuid) {
            this.a = uuid;
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public s.b apply(SharePhoto sharePhoto) {
            return k.a(this.a, sharePhoto);
        }
    }

    public static JSONObject A(JSONObject jSONObject, boolean z) {
        if (com.facebook.internal.instrument.e.a.c(k.class) || jSONObject == null) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONArray names = jSONObject.names();
                for (int i2 = 0; i2 < names.length(); i2++) {
                    String string = names.getString(i2);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = A((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = z((JSONArray) obj, true);
                    }
                    Pair<String, String> f2 = f(string);
                    String str = (String) f2.first;
                    String str2 = (String) f2.second;
                    if (z) {
                        if (str != null && str.equals("fbsdk")) {
                            jSONObject2.put(string, obj);
                        } else {
                            if (str != null && !str.equals("og")) {
                                jSONObject3.put(str2, obj);
                            }
                            jSONObject2.put(str2, obj);
                        }
                    } else if (str != null && str.equals("fb")) {
                        jSONObject2.put(string, obj);
                    } else {
                        jSONObject2.put(str2, obj);
                    }
                }
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("data", jSONObject3);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                throw new FacebookException("Failed to create json object from share content");
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static JSONObject B(UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Set V;
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            ShareOpenGraphAction k2 = shareOpenGraphContent.k();
            ArrayList arrayList = new ArrayList();
            JSONObject b2 = com.facebook.share.internal.h.b(k2, new i(uuid, arrayList));
            s.a(arrayList);
            if (shareOpenGraphContent.f() != null && x.S(b2.optString("place"))) {
                b2.put("place", shareOpenGraphContent.f());
            }
            if (shareOpenGraphContent.c() != null) {
                JSONArray optJSONArray = b2.optJSONArray(JsonMarshaller.TAGS);
                if (optJSONArray == null) {
                    V = new HashSet();
                } else {
                    V = x.V(optJSONArray);
                }
                for (String str : shareOpenGraphContent.c()) {
                    V.add(str);
                }
                b2.put(JsonMarshaller.TAGS, new JSONArray((Collection) V));
            }
            return b2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static JSONObject C(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            return com.facebook.share.internal.h.b(shareOpenGraphContent.k(), new j());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    static /* synthetic */ s.b a(UUID uuid, ShareMedia shareMedia) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            return d(uuid, shareMedia);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    private static com.facebook.internal.a b(int i2, int i3, Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            UUID r = t.r(intent);
            if (r == null) {
                return null;
            }
            return com.facebook.internal.a.a(r, i2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    private static s.b c(UUID uuid, Uri uri, Bitmap bitmap) {
        s.b bVar = null;
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
        if (bitmap == null) {
            if (uri != null) {
                bVar = s.e(uuid, uri);
            }
            return bVar;
        }
        bVar = s.d(uuid, bitmap);
        return bVar;
    }

    private static s.b d(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            if (shareMedia instanceof SharePhoto) {
                SharePhoto sharePhoto = (SharePhoto) shareMedia;
                bitmap = sharePhoto.c();
                uri = sharePhoto.g();
            } else if (shareMedia instanceof ShareVideo) {
                uri = ((ShareVideo) shareMedia).c();
                bitmap = null;
            } else {
                uri = null;
                bitmap = null;
            }
            return c(uuid, uri, bitmap);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    @Nullable
    public static Bundle e(ShareStoryContent shareStoryContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && shareStoryContent != null) {
            try {
                if (shareStoryContent.l() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.l());
                    ArrayList arrayList2 = new ArrayList();
                    List a0 = x.a0(arrayList, new b(uuid, arrayList2));
                    s.a(arrayList2);
                    return (Bundle) a0.get(0);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    public static Pair<String, String> f(String str) {
        String str2;
        int i2;
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || str.length() <= (i2 = indexOf + 1)) {
                str2 = null;
            } else {
                str2 = str.substring(0, indexOf);
                str = str.substring(i2);
            }
            return new Pair<>(str2, str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static List<Bundle> g(ShareMediaContent shareMediaContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && shareMediaContent != null) {
            try {
                List<ShareMedia> k2 = shareMediaContent.k();
                if (k2 != null) {
                    ArrayList arrayList = new ArrayList();
                    List<Bundle> a0 = x.a0(k2, new h(uuid, arrayList));
                    s.a(arrayList);
                    return a0;
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    @Nullable
    public static LikeView.ObjectType h(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        if (objectType == objectType2) {
            return objectType;
        }
        try {
            LikeView.ObjectType objectType3 = LikeView.ObjectType.UNKNOWN;
            if (objectType == objectType3) {
                return objectType2;
            }
            if (objectType2 == objectType3) {
                return objectType;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static String i(Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            if (bundle.containsKey("completionGesture")) {
                return bundle.getString("completionGesture");
            }
            return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static List<String> j(SharePhotoContent sharePhotoContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && sharePhotoContent != null) {
            try {
                List<SharePhoto> k2 = sharePhotoContent.k();
                if (k2 != null) {
                    List a0 = x.a0(k2, new f(uuid));
                    List<String> a02 = x.a0(a0, new g());
                    s.a(a0);
                    return a02;
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    public static String k(Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            if (bundle.containsKey("postId")) {
                return bundle.getString("postId");
            }
            if (bundle.containsKey("com.facebook.platform.extra.POST_ID")) {
                return bundle.getString("com.facebook.platform.extra.POST_ID");
            }
            return bundle.getString("post_id");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static com.facebook.share.internal.i l(com.facebook.e<com.facebook.share.b> eVar) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            return new c(eVar, eVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    @Nullable
    public static Bundle m(ShareStoryContent shareStoryContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && shareStoryContent != null) {
            try {
                if (shareStoryContent.n() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.n());
                    List a0 = x.a0(arrayList, new C0120k(uuid));
                    List a02 = x.a0(a0, new a());
                    s.a(a0);
                    return (Bundle) a02.get(0);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    public static Bundle n(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && shareCameraEffectContent != null) {
            try {
                CameraEffectTextures m = shareCameraEffectContent.m();
                if (m != null) {
                    Bundle bundle = new Bundle();
                    ArrayList arrayList = new ArrayList();
                    for (String str : m.f()) {
                        s.b c2 = c(uuid, m.c(str), m.b(str));
                        arrayList.add(c2);
                        bundle.putString(str, c2.g());
                    }
                    s.a(arrayList);
                    return bundle;
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    @Nullable
    public static String o(Uri uri) {
        if (com.facebook.internal.instrument.e.a.c(k.class) || uri == null) {
            return null;
        }
        try {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return null;
            }
            return uri2.substring(lastIndexOf);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static String p(ShareVideoContent shareVideoContent, UUID uuid) {
        if (!com.facebook.internal.instrument.e.a.c(k.class) && shareVideoContent != null) {
            try {
                if (shareVideoContent.n() != null) {
                    s.b e2 = s.e(uuid, shareVideoContent.n().c());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(e2);
                    s.a(arrayList);
                    return e2.g();
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, k.class);
            }
        }
        return null;
    }

    public static boolean q(int i2, int i3, Intent intent, com.facebook.share.internal.i iVar) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return false;
        }
        try {
            com.facebook.internal.a b2 = b(i2, i3, intent);
            if (b2 == null) {
                return false;
            }
            s.c(b2.b());
            if (iVar == null) {
                return true;
            }
            FacebookException t = t.t(t.s(intent));
            if (t != null) {
                if (t instanceof FacebookOperationCanceledException) {
                    iVar.a(b2);
                } else {
                    iVar.b(b2, t);
                }
            } else {
                iVar.c(b2, t.A(intent));
            }
            return true;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return false;
        }
    }

    static void r(com.facebook.e<com.facebook.share.b> eVar) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            u("cancelled", null);
            if (eVar != null) {
                eVar.onCancel();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    static void s(com.facebook.e<com.facebook.share.b> eVar, FacebookException facebookException) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            u("error", facebookException.getMessage());
            if (eVar != null) {
                eVar.onError(facebookException);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    static void t(com.facebook.e<com.facebook.share.b> eVar, String str) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            u("succeeded", null);
            if (eVar != null) {
                eVar.onSuccess(new com.facebook.share.b(str));
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    private static void u(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(com.facebook.f.f());
            Bundle bundle = new Bundle();
            bundle.putString("fb_share_dialog_outcome", str);
            if (str2 != null) {
                bundle.putString("error_message", str2);
            }
            internalAppEventsLogger.j("fb_share_dialog_result", bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    public static GraphRequest v(AccessToken accessToken, Uri uri, GraphRequest.e eVar) throws FileNotFoundException {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            if (x.R(uri)) {
                return w(accessToken, new File(uri.getPath()), eVar);
            }
            if (x.O(uri)) {
                GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("file", parcelableResourceWithMimeType);
                return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, eVar);
            }
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static GraphRequest w(AccessToken accessToken, File file, GraphRequest.e eVar) throws FileNotFoundException {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, PGImageSDK.SDK_STATUS_CREATE), "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, eVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }

    public static void x(int i2, com.facebook.d dVar, com.facebook.e<com.facebook.share.b> eVar) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            if (dVar instanceof CallbackManagerImpl) {
                ((CallbackManagerImpl) dVar).b(i2, new e(i2, eVar));
                return;
            }
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    public static void y(int i2) {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return;
        }
        try {
            CallbackManagerImpl.c(i2, new d(i2));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
        }
    }

    public static JSONArray z(JSONArray jSONArray, boolean z) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(k.class)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if (obj instanceof JSONArray) {
                    obj = z((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = A((JSONObject) obj, z);
                }
                jSONArray2.put(obj);
            }
            return jSONArray2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, k.class);
            return null;
        }
    }
}
