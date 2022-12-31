package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.e;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.f;
import com.facebook.internal.g;
import com.facebook.internal.h;
import com.facebook.internal.n;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.j;
import com.facebook.share.internal.k;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MessageDialog.java */
@Deprecated
/* loaded from: classes.dex */
public final class a extends h<ShareContent, com.facebook.share.b> {

    /* renamed from: f  reason: collision with root package name */
    private boolean f3265f;

    /* compiled from: MessageDialog.java */
    /* loaded from: classes.dex */
    private class b extends h<ShareContent, com.facebook.share.b>.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MessageDialog.java */
        /* renamed from: com.facebook.share.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0122a implements g.a {
            final /* synthetic */ com.facebook.internal.a a;
            final /* synthetic */ ShareContent b;
            final /* synthetic */ boolean c;

            C0122a(b bVar, com.facebook.internal.a aVar, ShareContent shareContent, boolean z) {
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
            super(a.this);
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z) {
            return shareContent != null && a.q(shareContent.getClass());
        }

        @Override // com.facebook.internal.h.a
        /* renamed from: e */
        public com.facebook.internal.a b(ShareContent shareContent) {
            j.v(shareContent);
            com.facebook.internal.a e2 = a.this.e();
            boolean s = a.this.s();
            a.t(a.this.f(), shareContent, e2);
            g.i(e2, new C0122a(this, e2, shareContent, s), a.r(shareContent.getClass()));
            return e2;
        }
    }

    static {
        CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity, int i2) {
        super(activity, i2);
        this.f3265f = false;
        k.y(i2);
    }

    public static boolean q(Class<? extends ShareContent> cls) {
        f r = r(cls);
        return r != null && g.a(r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f r(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        if (ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Context context, ShareContent shareContent, com.facebook.internal.a aVar) {
        String str;
        f r = r(shareContent.getClass());
        if (r == MessageDialogFeature.MESSAGE_DIALOG) {
            str = "status";
        } else if (r == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
            str = "GenericTemplate";
        } else if (r == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE) {
            str = "MediaTemplate";
        } else {
            str = r == MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE ? "OpenGraphMusicTemplate" : "unknown";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_content_type", str);
        bundle.putString("fb_share_dialog_content_uuid", aVar.b().toString());
        bundle.putString("fb_share_dialog_content_page_id", shareContent.b());
        internalAppEventsLogger.j("fb_messenger_share_dialog_show", bundle);
    }

    @Override // com.facebook.internal.h
    protected com.facebook.internal.a e() {
        return new com.facebook.internal.a(h());
    }

    @Override // com.facebook.internal.h
    protected List<h<ShareContent, com.facebook.share.b>.a> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        return arrayList;
    }

    @Override // com.facebook.internal.h
    protected void j(CallbackManagerImpl callbackManagerImpl, e<com.facebook.share.b> eVar) {
        k.x(h(), callbackManagerImpl, eVar);
    }

    public boolean s() {
        return this.f3265f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Fragment fragment, int i2) {
        this(new n(fragment), i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(android.app.Fragment fragment, int i2) {
        this(new n(fragment), i2);
    }

    private a(n nVar, int i2) {
        super(nVar, i2);
        this.f3265f = false;
        k.y(i2);
    }
}
