package us.pinguo.androidsdk.pgedit;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: PGFullScreenPicActivity.kt */
/* loaded from: classes3.dex */
public final class PGFullScreenPicActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    private static final String PATH = PGEditResultActivity2.PATH;
    private static final String SIZE = BigAlbumStore.PhotoColumns.SIZE;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* compiled from: PGFullScreenPicActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final String getPATH() {
            return PGFullScreenPicActivity.PATH;
        }

        public final String getSIZE() {
            return PGFullScreenPicActivity.SIZE;
        }
    }

    private final Bitmap getScaleBitmap() {
        List p0;
        int h2;
        String stringExtra = getIntent().getStringExtra(PATH);
        String stringExtra2 = getIntent().getStringExtra(SIZE);
        if (stringExtra2 == null) {
            return null;
        }
        p0 = StringsKt__StringsKt.p0(stringExtra2, new String[]{"x"}, false, 0, 6, null);
        if (((String) p0.get(0)).compareTo((String) p0.get(1)) > 0) {
            h2 = us.pinguo.foundation.t.b.a.j(this);
        } else {
            h2 = us.pinguo.foundation.t.b.a.h(this);
        }
        return us.pinguo.util.e.j(stringExtra, h2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPic$lambda-1$lambda-0  reason: not valid java name */
    public static final void m63showPic$lambda1$lambda0(PGFullScreenPicActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 21) {
            this$0.finishAfterTransition();
        } else {
            this$0.finish();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        getWindow().requestFeature(13);
        Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.image_transition);
        getWindow().setEnterTransition(inflateTransition);
        getWindow().setExitTransition(inflateTransition);
        setContentView(R.layout.activity_full_screen_pic);
        us.pinguo.util.h.o(this);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        s.g(lp, "lp");
        us.pinguo.util.h.a(lp);
        getWindow().setAttributes(lp);
        showPic();
        this.mEnableBaseNotch = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            us.pinguo.util.h.o(this);
        }
    }

    public final void showPic() {
        Bitmap scaleBitmap = getScaleBitmap();
        if (scaleBitmap == null) {
            return;
        }
        int i2 = R.id.imageview;
        ((ImageView) _$_findCachedViewById(i2)).setImageBitmap(scaleBitmap);
        ((ImageView) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.androidsdk.pgedit.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGFullScreenPicActivity.m63showPic$lambda1$lambda0(PGFullScreenPicActivity.this, view);
            }
        });
    }
}
