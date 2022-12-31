package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
public class j extends FakeActivity {
    private PlatformActionListener a;
    private Platform b;
    private Platform.ShareParams c;

    /* renamed from: d  reason: collision with root package name */
    private String f60d;

    public void a(PlatformActionListener platformActionListener, Platform platform, Platform.ShareParams shareParams, String str) {
        this.a = platformActionListener;
        this.b = platform;
        this.c = shareParams;
        this.f60d = str;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        finish();
        if (this.a != null) {
            Bundle bundleExtra = intent != null ? intent.getBundleExtra("com.facebook.platform.protocol.RESULT_ARGS") : null;
            if (bundleExtra == null) {
                if (i2 == 64206 && i3 == 0) {
                    this.a.onCancel(this.b, 9);
                    return;
                } else {
                    this.a.onError(this.b, 9, new Throwable("share error!"));
                    return;
                }
            }
            String string = bundleExtra.getString("completionGesture");
            boolean z = bundleExtra.getBoolean("didComplete");
            if (TextUtils.isEmpty(string)) {
                if (z) {
                    this.a.onComplete(this.b, 9, null);
                } else {
                    this.a.onCancel(this.b, 9);
                }
            } else if (string.equalsIgnoreCase("cancel")) {
                this.a.onCancel(this.b, 9);
            } else if (string.equalsIgnoreCase("post")) {
                this.a.onComplete(this.b, 9, null);
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
            if (a() != null) {
                this.activity.startActivityForResult(a(), 64206);
            }
        } catch (Throwable th) {
            finish();
            this.a.onError(this.b, 9, th);
        }
    }

    public Intent a() {
        Intent intent = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
        intent.setPackage("com.facebook.katana");
        intent.addCategory("android.intent.category.DEFAULT");
        Bundle bundle = new Bundle();
        bundle.putBoolean("DATA_FAILURES_FATAL", false);
        bundle.putString("TITLE", this.c.getTitle());
        if (!TextUtils.isEmpty(this.c.getUrl())) {
            bundle.putString("LINK", this.b.getShortLintk(this.c.getUrl(), false));
            bundle.putString("type", "LINK");
            if (!TextUtils.isEmpty(this.c.getQuote())) {
                bundle.putString("QUOTE", this.c.getQuote());
            }
            if (!TextUtils.isEmpty(this.c.getHashtag())) {
                bundle.putString("HASHTAG", this.c.getHashtag());
            }
        } else if (!TextUtils.isEmpty(this.c.getFilePath())) {
            File file = new File(this.c.getFilePath());
            if (file.exists()) {
                Context context = MobSDK.getContext();
                Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                MobSDK.getContext().grantUriPermission("com.facebook.katana", a, 3);
                bundle.putString("VIDEO", a.toString());
            }
            bundle.putString("type", "VIDEO");
            bundle.putString("DESCRIPTION", this.c.getText());
            bundle.putString("TITLE", this.c.getTitle());
            if (!TextUtils.isEmpty(this.c.getHashtag())) {
                bundle.putString("HASHTAG", this.c.getHashtag());
            }
        } else if (this.c.getImageArray() != null && this.c.getImageArray().length > 0) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                List<String> arrayList2 = new ArrayList();
                if (this.c.getImageArray() != null) {
                    arrayList2 = Arrays.asList(this.c.getImageArray());
                }
                for (String str : arrayList2) {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            Context context2 = MobSDK.getContext();
                            Uri a2 = ShareSDKFileProvider.a(context2, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file2);
                            MobSDK.getContext().grantUriPermission("com.facebook.katana", a2, 3);
                            arrayList.add(String.valueOf(a2));
                        } else {
                            arrayList.add(Uri.fromFile(file2).toString());
                        }
                    } else {
                        SSDKLog.b().w("Facebook share iamge ShareActivity file is not exist");
                    }
                }
                if (!TextUtils.isEmpty(this.c.getHashtag())) {
                    bundle.putString("HASHTAG", this.c.getHashtag());
                }
                bundle.putStringArrayList("PHOTOS", arrayList);
                bundle.putString("DESCRIPTION", this.c.getText());
                bundle.putString("NAME", this.c.getTitle());
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20171115).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.FEED_DIALOG").putExtra("com.facebook.platform.extra.APPLICATION_ID", this.f60d);
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", "cf61947c-a8fe-4fa3-aa7c-fbeb7f291352");
        DeviceHelper deviceHelper = DeviceHelper.getInstance(getContext());
        String appName = deviceHelper.getAppName();
        if (!TextUtils.isEmpty(appName) && deviceHelper.getNetworkTypeForStatic().equals(PortalFollowFeeds.TYPE_NONE)) {
            bundle2.putString("app_name", appName);
        }
        intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
        return intent;
    }
}
