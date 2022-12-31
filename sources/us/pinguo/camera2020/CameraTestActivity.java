package us.pinguo.camera2020;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.cameramanger.viewfinder.TextureViewFinder;
/* compiled from: CameraTestActivity.kt */
/* loaded from: classes.dex */
public final class CameraTestActivity extends AppCompatActivity {
    public Map<Integer, View> a = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(us.pinguo.cameramanger.c cameraManager, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        s.h(cameraManager, "$cameraManager");
        cameraManager.f(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(us.pinguo.cameramanger.c cameraManager, CameraTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(cameraManager, "$cameraManager");
        s.h(this$0, "this$0");
        cameraManager.h(new CameraTestActivity$onCreate$2$1(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(us.pinguo.cameramanger.c cameraManager, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(cameraManager, "$cameraManager");
        cameraManager.D(cameraManager.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(us.pinguo.cameramanger.c cameraManager, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(cameraManager, "$cameraManager");
        cameraManager.j(CameraFrame.FRAME_16_9);
    }

    public View _$_findCachedViewById(int i2) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        us.pinguo.common.log.a.n(true);
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        final us.pinguo.cameramanger.c cVar = new us.pinguo.cameramanger.c(LensFacing.BACK, CameraFrame.FRAME_4_3);
        cVar.g(displayMetrics.widthPixels, displayMetrics.heightPixels);
        TextureViewFinder texturePreviewView = (TextureViewFinder) _$_findCachedViewById(R.id.texturePreviewView);
        s.g(texturePreviewView, "texturePreviewView");
        cVar.w(texturePreviewView);
        cVar.r(this);
        ((CheckBox) _$_findCachedViewById(R.id.torchCheck)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraTestActivity.q0(us.pinguo.cameramanger.c.this, compoundButton, z);
            }
        });
        ((Button) _$_findCachedViewById(R.id.shutter)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraTestActivity.r0(us.pinguo.cameramanger.c.this, this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.toggleCamera)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraTestActivity.s0(us.pinguo.cameramanger.c.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.changeFrame)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraTestActivity.t0(us.pinguo.cameramanger.c.this, view);
            }
        });
    }
}
