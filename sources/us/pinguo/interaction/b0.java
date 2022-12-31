package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.o.c;
/* compiled from: DestinationSplice.java */
/* loaded from: classes4.dex */
public class b0 extends us.pinguo.foundation.interaction.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DestinationSplice.java */
    /* loaded from: classes4.dex */
    public class a implements c.a {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ b b;

        a(b0 b0Var, AlertDialog alertDialog, b bVar) {
            this.a = alertDialog;
            this.b = bVar;
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void b() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void c() {
            AlertDialog alertDialog = this.a;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }

        @Override // us.pinguo.foundation.o.c.a
        public void d() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void e() {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void f(int i2) {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void g() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DestinationSplice.java */
    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    private void i(Context context, String str, b bVar) {
        us.pinguo.foundation.o.c.a.a(str, new a(this, us.pinguo.ui.b.a.a(context), bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(Uri uri, Context context, Intent intent) {
        super.b(uri, context, intent);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.camera360.dynamic_feature_splice.PhotoPickActivityNew");
        intent.setFlags(603979776);
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(final Uri uri, final Context context, final Intent intent) {
        us.pinguo.foundation.o.c cVar = us.pinguo.foundation.o.c.a;
        i(context, "c360_dynamic_feature_splice", new b() { // from class: us.pinguo.interaction.d
            @Override // us.pinguo.interaction.b0.b
            public final void a() {
                b0.this.k(uri, context, intent);
            }
        });
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/puzzle/splice".equals(uri.toString());
    }
}
