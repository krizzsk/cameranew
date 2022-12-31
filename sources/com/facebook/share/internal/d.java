package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.g;
import com.facebook.internal.n;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LikeDialog.java */
@Deprecated
/* loaded from: classes.dex */
public class d extends com.facebook.internal.h<LikeContent, C0119d> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f3230f = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();

    /* compiled from: LikeDialog.java */
    /* loaded from: classes.dex */
    class a extends i {
        final /* synthetic */ com.facebook.e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d dVar, com.facebook.e eVar, com.facebook.e eVar2) {
            super(eVar);
            this.b = eVar2;
        }

        @Override // com.facebook.share.internal.i
        public void c(com.facebook.internal.a aVar, Bundle bundle) {
            this.b.onSuccess(new C0119d(bundle));
        }
    }

    /* compiled from: LikeDialog.java */
    /* loaded from: classes.dex */
    class b implements CallbackManagerImpl.a {
        final /* synthetic */ i a;

        b(i iVar) {
            this.a = iVar;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return k.q(d.this.h(), i2, intent, this.a);
        }
    }

    /* compiled from: LikeDialog.java */
    /* loaded from: classes.dex */
    private class c extends com.facebook.internal.h<LikeContent, C0119d>.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LikeDialog.java */
        /* loaded from: classes.dex */
        public class a implements g.a {
            final /* synthetic */ LikeContent a;

            a(c cVar, LikeContent likeContent) {
                this.a = likeContent;
            }

            @Override // com.facebook.internal.g.a
            public Bundle a() {
                Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
                return new Bundle();
            }

            @Override // com.facebook.internal.g.a
            public Bundle getParameters() {
                return d.r(this.a);
            }
        }

        private c() {
            super(d.this);
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(LikeContent likeContent, boolean z) {
            return false;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(LikeContent likeContent) {
            com.facebook.internal.a e2 = d.this.e();
            com.facebook.internal.g.i(e2, new a(this, likeContent), d.s());
            return e2;
        }

        /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    /* compiled from: LikeDialog.java */
    @Deprecated
    /* renamed from: com.facebook.share.internal.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0119d {
        public C0119d(Bundle bundle) {
        }
    }

    /* compiled from: LikeDialog.java */
    /* loaded from: classes.dex */
    private class e extends com.facebook.internal.h<LikeContent, C0119d>.a {
        private e() {
            super(d.this);
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(LikeContent likeContent, boolean z) {
            return false;
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(LikeContent likeContent) {
            com.facebook.internal.a e2 = d.this.e();
            com.facebook.internal.g.l(e2, d.r(likeContent), d.s());
            return e2;
        }

        /* synthetic */ e(d dVar, a aVar) {
            this();
        }
    }

    @Deprecated
    public d(Activity activity) {
        super(activity, f3230f);
    }

    @Deprecated
    public static boolean p() {
        return false;
    }

    @Deprecated
    public static boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle r(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.a());
        bundle.putString("object_type", likeContent.b());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.internal.f s() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    @Override // com.facebook.internal.h
    protected com.facebook.internal.a e() {
        return new com.facebook.internal.a(h());
    }

    @Override // com.facebook.internal.h
    protected List<com.facebook.internal.h<LikeContent, C0119d>.a> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(this, null));
        arrayList.add(new e(this, null));
        return arrayList;
    }

    @Override // com.facebook.internal.h
    protected void j(CallbackManagerImpl callbackManagerImpl, com.facebook.e<C0119d> eVar) {
        callbackManagerImpl.b(h(), new b(eVar == null ? null : new a(this, eVar, eVar)));
    }

    @Override // com.facebook.internal.h
    @Deprecated
    /* renamed from: t */
    public void k(LikeContent likeContent) {
    }

    @Deprecated
    public d(n nVar) {
        super(nVar, f3230f);
    }
}
