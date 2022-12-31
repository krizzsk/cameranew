package us.pinguo.camera2020.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
/* compiled from: CameraScreenSaverActivity.kt */
/* loaded from: classes2.dex */
public final class CameraScreenSaverActivity extends Activity {
    public static final a b = new a(null);
    public Map<Integer, View> a = new LinkedHashMap();

    /* compiled from: CameraScreenSaverActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.s.h(context, "context");
            us.pinguo.foundation.statistics.h.b.t("show");
            context.startActivity(new Intent(context, CameraScreenSaverActivity.class));
        }
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_camera_screen_saver);
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String string = getResources().getString(R.string.text_screen_saver_title);
        kotlin.jvm.internal.s.g(string, "resources.getString(R.st….text_screen_saver_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{90L}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        ((TextView) a(R.id.camera_sleep_tv)).setText(format);
        us.pinguo.util.h.o(this);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    public final void wakeUp(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        us.pinguo.foundation.statistics.h.b.t("click");
        finish();
    }
}
