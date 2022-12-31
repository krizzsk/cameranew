package com.pinguo.camera360.cloud.cropImage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.foundation.base.BaseActivity;
/* loaded from: classes3.dex */
public class MonitoredActivity extends BaseActivity {
    private final ArrayList<b> a = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class a implements b {
        @Override // com.pinguo.camera360.cloud.cropImage.MonitoredActivity.b
        public void a(MonitoredActivity monitoredActivity) {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MonitoredActivity monitoredActivity);

        void b(MonitoredActivity monitoredActivity);

        void c(MonitoredActivity monitoredActivity);

        void d(MonitoredActivity monitoredActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    public void q0(b bVar) {
        if (this.a.contains(bVar)) {
            return;
        }
        this.a.add(bVar);
    }

    public void r0(b bVar) {
        this.a.remove(bVar);
    }
}
