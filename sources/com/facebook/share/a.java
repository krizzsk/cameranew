package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.e;
import com.facebook.f;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.h;
import com.facebook.internal.n;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
/* compiled from: DeviceShareDialog.java */
@Deprecated
/* loaded from: classes.dex */
public class a extends h<ShareContent, b> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f3189f = CallbackManagerImpl.RequestCodeOffset.DeviceShare.toRequestCode();

    /* compiled from: DeviceShareDialog.java */
    /* renamed from: com.facebook.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0116a implements CallbackManagerImpl.a {
        final /* synthetic */ e a;

        C0116a(a aVar, e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            if (intent.hasExtra("error")) {
                this.a.onError(((FacebookRequestError) intent.getParcelableExtra("error")).h());
                return true;
            }
            this.a.onSuccess(new b());
            return true;
        }
    }

    /* compiled from: DeviceShareDialog.java */
    /* loaded from: classes.dex */
    public static class b {
    }

    public a(Activity activity) {
        super(activity, f3189f);
    }

    @Override // com.facebook.internal.h
    protected com.facebook.internal.a e() {
        return null;
    }

    @Override // com.facebook.internal.h
    protected List<h<ShareContent, b>.a> g() {
        return null;
    }

    @Override // com.facebook.internal.h
    protected void j(CallbackManagerImpl callbackManagerImpl, e<b> eVar) {
        callbackManagerImpl.b(h(), new C0116a(this, eVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.h
    /* renamed from: n */
    public boolean c(ShareContent shareContent, Object obj) {
        return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.h
    /* renamed from: o */
    public void l(ShareContent shareContent, Object obj) {
        if (shareContent != null) {
            if (!(shareContent instanceof ShareLinkContent) && !(shareContent instanceof ShareOpenGraphContent)) {
                throw new FacebookException(a.class.getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
            }
            Intent intent = new Intent();
            intent.setClass(f.f(), FacebookActivity.class);
            intent.setAction("DeviceShareDialogFragment");
            intent.putExtra(FirebaseAnalytics.Param.CONTENT, shareContent);
            m(intent, h());
            return;
        }
        throw new FacebookException("Must provide non-null content to share");
    }

    public a(Fragment fragment) {
        super(new n(fragment), f3189f);
    }

    public a(androidx.fragment.app.Fragment fragment) {
        super(new n(fragment), f3189f);
    }
}
