package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gz;
/* loaded from: classes3.dex */
public class TJContentActivity extends Activity {
    private static volatile ContentProducer a;
    private ContentProducer b;
    private boolean c = false;

    /* loaded from: classes3.dex */
    public static abstract class AbstractContentProducer implements ContentProducer {
        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void dismiss(Activity activity) {
        }

        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        }
    }

    /* loaded from: classes3.dex */
    public interface ContentProducer {
        void dismiss(Activity activity);

        void onActivityResult(Activity activity, int i2, int i3, Intent intent);

        void show(Activity activity);
    }

    private boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("com.tapjoy.internal.content.producer.id");
        if (stringExtra == null) {
            return false;
        }
        synchronized (TJContentActivity.class) {
            if (a == null || !stringExtra.equals(toIdentityString(a))) {
                return false;
            }
            this.b = a;
            a = null;
            if (intent.getBooleanExtra("com.tapjoy.internal.content.fullscreen", false)) {
                getWindow().setFlags(1024, 1024);
            }
            this.b.show(this);
            return true;
        }
    }

    public static void start(Context context, ContentProducer contentProducer, boolean z) {
        Intent intent = new Intent(context, TJContentActivity.class);
        intent.setFlags(276889600);
        intent.putExtra("com.tapjoy.internal.content.producer.id", toIdentityString(contentProducer));
        intent.putExtra("com.tapjoy.internal.content.fullscreen", z);
        synchronized (TJContentActivity.class) {
            a = contentProducer;
            context.startActivity(intent);
        }
    }

    public static String toIdentityString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + System.identityHashCode(obj);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.b.onActivityResult(this, i2, i3, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (a(getIntent())) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ContentProducer contentProducer = this.b;
        if (contentProducer != null) {
            contentProducer.dismiss(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (gz.a().n) {
            this.c = true;
            gn.a(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.c) {
            this.c = false;
            gn.b(this);
        }
        super.onStop();
    }
}
