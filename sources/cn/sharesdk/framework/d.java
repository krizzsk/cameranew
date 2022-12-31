package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
/* compiled from: InnerPlatformActionListener.java */
/* loaded from: classes.dex */
public class d implements PlatformActionListener {
    private PlatformActionListener a;
    private HashMap<Platform, Platform.ShareParams> b = new HashMap<>();
    private int c;

    private void b() {
        new Thread(new Runnable() { // from class: cn.sharesdk.framework.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cn.sharesdk.framework.authorize.f.c().d();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i2) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            platformActionListener.onCancel(platform, i2);
            this.a = null;
            this.c = 0;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
        if (platform instanceof CustomPlatform) {
            PlatformActionListener platformActionListener = this.a;
            if (platformActionListener != null) {
                platformActionListener.onComplete(platform, i2, hashMap);
                this.a = null;
                this.c = 0;
            }
        } else if (i2 == 1) {
            a(platform, i2, hashMap);
        } else if (i2 != 9) {
            PlatformActionListener platformActionListener2 = this.a;
            if (platformActionListener2 != null) {
                platformActionListener2.onComplete(platform, i2, hashMap);
                if (Wechat.NAME.equals(platform.getName())) {
                    return;
                }
                int i3 = this.c;
                if (i3 == 0 || i3 == i2) {
                    this.a = null;
                    this.c = 0;
                }
            }
        } else {
            b(platform, i2, hashMap);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i2, Throwable th) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            platformActionListener.onError(platform, i2, th);
            this.a = null;
            this.c = 0;
        }
    }

    private void b(Platform platform, int i2, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        Platform platform2;
        Platform.ShareParams remove = this.b.remove(platform);
        if (hashMap != null) {
            remove = (Platform.ShareParams) hashMap.remove("ShareParams");
        }
        try {
            hashMap2 = (HashMap) hashMap.clone();
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            hashMap2 = hashMap;
        }
        if (remove != null) {
            cn.sharesdk.framework.b.b.f fVar = new cn.sharesdk.framework.b.b.f();
            fVar.n = remove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if ((WechatMoments.NAME.equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                try {
                    platform2 = ShareSDK.getPlatform(Wechat.NAME);
                } catch (Throwable th2) {
                    SSDKLog.b().d(th2, "InnerPlatformActionListener wechat is null", new Object[0]);
                    platform2 = null;
                }
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            fVar.b = userId;
            fVar.a = platform.getPlatformId();
            f.a filterShareContent = platform.filterShareContent(remove, hashMap2);
            if (filterShareContent != null) {
                fVar.c = filterShareContent.a;
                fVar.f97d = filterShareContent;
            }
            if (platform != null) {
                fVar.m = b(platform);
            }
            cn.sharesdk.framework.b.d a = cn.sharesdk.framework.b.d.a();
            if (a != null) {
                a.a(fVar);
            }
        }
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            try {
                platformActionListener.onComplete(platform, i2, hashMap);
                this.a = null;
                this.c = 0;
            } catch (Throwable th3) {
                SSDKLog.b().d(th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PlatformActionListener platformActionListener) {
        this.a = platformActionListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformActionListener a() {
        return this.a;
    }

    public void a(Platform platform, Platform.ShareParams shareParams) {
        this.b.put(platform, shareParams);
    }

    private void a(Platform platform, final int i2, final HashMap<String, Object> hashMap) {
        if (cn.sharesdk.framework.authorize.f.c().b() == null) {
            b();
        }
        final PlatformActionListener platformActionListener = this.a;
        this.a = new PlatformActionListener() { // from class: cn.sharesdk.framework.d.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i3) {
                d.this.a = platformActionListener;
                if (d.this.a != null) {
                    d.this.a.onComplete(platform2, i2, hashMap);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i3, HashMap<String, Object> hashMap2) {
                d.this.a = platformActionListener;
                if (d.this.a != null) {
                    try {
                        if (ShareSDK.getEnableAuthTag()) {
                            String fromHashMap = new Hashon().fromHashMap(cn.sharesdk.framework.authorize.f.c().b());
                            if (!TextUtils.isEmpty(fromHashMap)) {
                                platform2.getDb().put("userTags", fromHashMap);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    d.this.a.onComplete(platform2, i2, hashMap);
                }
                cn.sharesdk.framework.b.b.b bVar = new cn.sharesdk.framework.b.b.b();
                bVar.a = platform2.getPlatformId();
                bVar.b = "TencentWeibo".equals(platform2.getName()) ? platform2.getDb().get("name") : platform2.getDb().getUserId();
                bVar.c = new Hashon().fromHashMap(hashMap2);
                bVar.f87d = d.this.a(platform2);
                cn.sharesdk.framework.b.d a = cn.sharesdk.framework.b.d.a();
                if (a != null) {
                    a.a(bVar);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i3, Throwable th) {
                SSDKLog.b().w(th);
                d.this.a = platformActionListener;
                if (d.this.a != null) {
                    d.this.a.onComplete(platform2, i2, hashMap);
                }
            }
        };
        platform.showUser(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Platform platform, final int i2, final Object obj) {
        if (cn.sharesdk.framework.authorize.f.c().b() == null) {
            b();
        }
        this.c = i2;
        final PlatformActionListener platformActionListener = this.a;
        this.a = new PlatformActionListener() { // from class: cn.sharesdk.framework.d.3
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i3) {
                d.this.a = platformActionListener;
                if (d.this.a != null) {
                    d.this.a.onCancel(platform2, i2);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i3, HashMap<String, Object> hashMap) {
                if (ShareSDK.getEnableAuthTag()) {
                    String fromHashMap = new Hashon().fromHashMap(cn.sharesdk.framework.authorize.f.c().b());
                    if (!TextUtils.isEmpty(fromHashMap)) {
                        platform2.getDb().put("userTags", fromHashMap);
                    }
                }
                d.this.a = platformActionListener;
                platform2.afterRegister(i2, obj);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i3, Throwable th) {
                d.this.a = platformActionListener;
                if (d.this.a != null) {
                    d.this.a.onError(platform2, i3, th);
                }
            }
        };
        platform.doAuthorize(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Platform platform) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            return a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th2) {
            th = th2;
            SSDKLog.b().w(th);
            return null;
        }
    }

    private String a(PlatformDb platformDb, String[] strArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        for (String str : strArr) {
            if (i2 > 0) {
                sb2.append('|');
                sb.append('|');
            }
            i2++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        SSDKLog.b().i("======UserData: " + sb.toString(), new Object[0]);
        return sb2.toString();
    }

    private String b(Platform platform) {
        Platform platform2;
        PlatformDb db = platform.getDb();
        if ((WechatMoments.NAME.equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender())) {
            try {
                platform2 = ShareSDK.getPlatform(Wechat.NAME);
            } catch (Throwable th) {
                SSDKLog.b().d(th, "InnerPlatformActionListener getUserDataBrief catch ", new Object[0]);
                platform2 = null;
            }
            if (platform2 != null) {
                db = platform2.getDb();
            }
        }
        try {
            return a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th2) {
            SSDKLog.b().w(th2);
            return null;
        }
    }
}
