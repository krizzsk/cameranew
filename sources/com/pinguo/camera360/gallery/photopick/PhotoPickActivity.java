package com.pinguo.camera360.gallery.photopick;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.gallery.RootActivity;
import com.pinguo.camera360.gallery.photopick.PhotoPickBroker;
import com.pinguo.camera360.gallery.photopick.PhotoPickLauncher;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.ui.view.HorizontalListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import us.pinguo.camera2020.activity.y;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PhotoPickActivity extends RootActivity {
    private a t;
    private int u;
    private int v;
    private PhotoPickLauncher.LaunchMode w = PhotoPickLauncher.LaunchMode.MULTI_PHOTO;
    private Handler x = new Handler();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener, Observer {
        private View a;
        private f b;
        private HorizontalListView c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f6431d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f6432e;

        /* renamed from: f  reason: collision with root package name */
        private View f6433f;

        public a(boolean z) {
            PhotoPickBroker.k().o(PhotoPickActivity.this.u);
            this.b = new f(PhotoPickActivity.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.c = (HorizontalListView) PhotoPickActivity.this.findViewById(R.id.gv_album_photo_choice);
            TextView textView = (TextView) PhotoPickActivity.this.findViewById(R.id.tv_album_photo_select_count);
            this.f6431d = textView;
            textView.setText(textView.getContext().getString(R.string.gallery_select_count, 0, Integer.valueOf(PhotoPickActivity.this.u)));
            this.f6432e = (TextView) PhotoPickActivity.this.findViewById(R.id.tv_album_photo_select_start);
            this.f6433f = PhotoPickActivity.this.findViewById(R.id.ly_album_photo_select_puzzle);
            View findViewById = PhotoPickActivity.this.findViewById(R.id.ly_album_selected_photos);
            this.a = findViewById;
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
            this.f6433f.setEnabled(false);
            this.f6433f.setOnClickListener(this);
            this.c.setAdapter((ListAdapter) this.b);
        }

        public void b() {
        }

        public void d() {
            PhotoPickBroker.k().deleteObserver(this);
        }

        public void e() {
            PhotoPickBroker.k().addObserver(this);
        }

        public void f(int i2) {
            View view = this.a;
            view.setVisibility(i2);
            VdsAgent.onSetViewVisibility(view, i2);
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (view.getId() != R.id.ly_album_photo_select_puzzle) {
                return;
            }
            PhotoPickActivity.this.W0();
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            int size = PhotoPickBroker.k().j().size();
            if (size >= PhotoPickActivity.this.v && size <= PhotoPickActivity.this.u) {
                this.f6433f.setEnabled(true);
                this.f6431d.setEnabled(true);
                this.f6432e.setEnabled(true);
            } else {
                this.f6433f.setEnabled(false);
                this.f6431d.setEnabled(false);
                this.f6432e.setEnabled(false);
            }
            TextView textView = this.f6431d;
            textView.setText(textView.getContext().getString(R.string.gallery_select_count, Integer.valueOf(size), Integer.valueOf(PhotoPickActivity.this.u)));
            this.b.notifyDataSetChanged();
            if ((obj instanceof PhotoPickBroker.EventType) && ((PhotoPickBroker.EventType) obj) == PhotoPickBroker.EventType.EVENT_ADD) {
                this.c.setSelection(size - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0() {
        if (this.q) {
            return;
        }
        X0(this, this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0() {
        if (this.q) {
            return;
        }
        this.x.post(new Runnable() { // from class: com.pinguo.camera360.gallery.photopick.a
            @Override // java.lang.Runnable
            public final void run() {
                PhotoPickActivity.this.S0();
            }
        });
    }

    public static void X0(RootActivity rootActivity, PhotoPickLauncher.LaunchMode launchMode) {
        Bundle bundle = new Bundle();
        if (launchMode.isNewMode()) {
            bundle.putInt("media-type", 1001);
            bundle.putString("media-path-id", "path-set");
            bundle.putSerializable("photo_pick_mode", launchMode);
            rootActivity.E0().o(d.class, bundle);
            return;
        }
        if (launchMode == PhotoPickLauncher.LaunchMode.SINGLE_VIDEO) {
            bundle.putInt("media-type", 1102);
        } else {
            bundle.putInt("media-type", 1202);
        }
        bundle.putString("media-path-id", "path-big-album-def");
        bundle.putSerializable("photo_pick_mode", launchMode);
        rootActivity.E0().o(c.class, bundle);
    }

    public void V0() {
        y.b().e(0, getIntent());
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("us.pinguo.inspire.finish_publish"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0() {
        List<e> j2 = PhotoPickBroker.k().j();
        if (j2.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(j2.size());
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(j2.size());
        for (e eVar : j2) {
            String str = eVar.c;
            if (str != null && new File(str).exists()) {
                arrayList.add(str);
                arrayList2.add(eVar.f6437d);
            } else {
                z0(getResources().getString(R.string.select_some_file_not_exists));
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("photo_path_list", arrayList);
        bundle.putParcelableArrayList("photo_id_list", arrayList2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // com.pinguo.camera360.gallery.RootActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (E0().e() == null) {
            V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_layout_photo_choice);
        if (getIntent().hasExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE)) {
            this.w = PhotoPickLauncher.a(getIntent().getIntExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 1));
        }
        PhotoPickLauncher.LaunchMode launchMode = this.w;
        PhotoPickLauncher.LaunchMode launchMode2 = PhotoPickLauncher.LaunchMode.MULTI_PHOTO_FOR_PUZZLE;
        if (launchMode == launchMode2) {
            this.u = 9;
            this.v = 2;
        } else {
            this.u = getIntent().getIntExtra(InspirePublishFragment.KEY_PHOTO_PICK_COUNT_LIMIT, 9);
            this.v = 1;
        }
        PhotoPickBroker.k().f();
        a aVar = new a(this.w == launchMode2);
        this.t = aVar;
        aVar.c();
        if (getIntent().hasExtra("output") || this.w.isSinglePhotoMode()) {
            this.t.f(8);
        }
        F0().post(new Runnable() { // from class: com.pinguo.camera360.gallery.photopick.b
            @Override // java.lang.Runnable
            public final void run() {
                PhotoPickActivity.this.U0();
            }
        });
        a.d.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.t.b();
        PhotoPickBroker.k().g();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.t.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.t.e();
    }
}
