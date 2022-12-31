package com.pinguo.camera360.homepage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageFragment2020.kt */
/* loaded from: classes3.dex */
public final class r0 extends Handler {
    private final WeakReference<HomePageFragment2020> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(WeakReference<HomePageFragment2020> fragRef) {
        super(Looper.getMainLooper());
        kotlin.jvm.internal.s.h(fragRef, "fragRef");
        this.a = fragRef;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        HomePageFragment2020 homePageFragment2020;
        kotlin.jvm.internal.s.h(msg, "msg");
        if (msg.what != 9011 || (homePageFragment2020 = this.a.get()) == null) {
            return;
        }
        ViewPager2 viewPager2 = (ViewPager2) homePageFragment2020._$_findCachedViewById(R.id.pagerBanner);
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        sendEmptyMessageDelayed(9011, 4000L);
    }
}
