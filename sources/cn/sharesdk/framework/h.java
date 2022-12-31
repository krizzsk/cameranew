package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import androidx.core.view.ViewCompat;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.FirstPic;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
/* compiled from: ShareSDKCore.java */
/* loaded from: classes.dex */
public class h {
    public static ArrayList<Platform> a() {
        ArrayList<Platform> f2 = f();
        a(f2);
        return f2;
    }

    public static Activity b() {
        return cn.sharesdk.framework.authorize.b.c().b();
    }

    public static boolean c() {
        return cn.sharesdk.framework.authorize.b.c().a();
    }

    public static boolean d() {
        return cn.sharesdk.framework.authorize.f.c().a();
    }

    public static HashMap<String, Object> e() {
        MobLinkAPI.a();
        return MobLinkAPI.d();
    }

    private static ArrayList<Platform> f() {
        String[] strArr = {"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments", "cn.sharesdk.dingding.friends.Dingding", "cn.sharesdk.youtube.Youtube", "cn.sharesdk.meipai.Meipai", "cn.sharesdk.telegram.Telegram", "cn.sharesdk.cmcc.Cmcc", "cn.sharesdk.reddit.Reddit", "cn.sharesdk.telecom.Telecom", "cn.sharesdk.accountkit.Accountkit", "cn.sharesdk.douyin.Douyin", "cn.sharesdk.wework.Wework", "cn.sharesdk.oasis.Oasis", "cn.sharesdk.hwaccount.HWAccount", "cn.sharesdk.xmaccount.XMAccount", "cn.sharesdk.snapchat.Snapchat", "cn.sharesdk.littleredbook.Littleredbook", "cn.sharesdk.kuaishou.Kuaishou", "cn.sharesdk.watermelonvideo.Watermelonvideo", "cn.sharesdk.tiktok.Tiktok"};
        ArrayList<Platform> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < 55; i2++) {
            try {
                arrayList.add((Platform) Class.forName(strArr[i2]).newInstance());
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static void a(ArrayList<Platform> arrayList) {
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, new Comparator<Platform>() { // from class: cn.sharesdk.framework.h.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Platform platform, Platform platform2) {
                int platformId;
                int platformId2;
                if (platform.getSortId() != platform2.getSortId()) {
                    platformId = platform.getSortId();
                    platformId2 = platform2.getSortId();
                } else {
                    platformId = platform.getPlatformId();
                    platformId2 = platform2.getPlatformId();
                }
                return platformId - platformId2;
            }
        });
    }

    public static void b(boolean z) {
        cn.sharesdk.framework.authorize.f c = cn.sharesdk.framework.authorize.f.c();
        if (c != null) {
            c.a(z);
        }
    }

    public static void a(Activity activity) {
        cn.sharesdk.framework.authorize.b c = cn.sharesdk.framework.authorize.b.c();
        if (c != null) {
            c.a(activity);
        }
    }

    public static void a(boolean z) {
        cn.sharesdk.framework.authorize.b c = cn.sharesdk.framework.authorize.b.c();
        if (c != null) {
            c.a(z);
        }
    }

    public static void a(Context context, ReadQrImageListener readQrImageListener) {
        FirstPic.a(context, readQrImageListener);
    }

    public static void a(String str, String str2, String str3, String str4, WaterMarkListener waterMarkListener) {
        cn.sharesdk.framework.loopshare.watermark.c.a(str, str2, str3, str4, waterMarkListener);
    }

    public static Bitmap a(String str, int i2, int i3) {
        k.a();
        return k.a(str, i2, i3, "UTF_8", "H", "2", ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public static void a(HashMap<String, Object> hashMap, MoblinkActionListener moblinkActionListener) {
        try {
            MobLinkAPI.a();
            MobLinkAPI.a(hashMap, moblinkActionListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCore mobLinkGetMobID " + th, new Object[0]);
        }
    }

    public static void a(HashMap<String, Object> hashMap, String str, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            MobLinkAPI.a();
            MobLinkAPI.a(hashMap, str, loopSharePasswordListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCore preparePassWord " + th, new Object[0]);
        }
    }

    public static void a(boolean z, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            MobLinkAPI.a();
            MobLinkAPI.a(z, loopSharePasswordListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCore readPassWord " + th, new Object[0]);
        }
    }

    public static void a(LoopShareResultListener loopShareResultListener) {
        try {
            MobLinkAPI.a();
            MobLinkAPI.b(loopShareResultListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCore prepareLoopShare " + th, new Object[0]);
        }
    }

    public static void a(Handler handler) {
        cn.sharesdk.framework.b.d a = cn.sharesdk.framework.b.d.a();
        if (a != null) {
            a.a(handler);
            a.e();
        }
    }

    public static void a(int i2, Platform platform) {
        cn.sharesdk.framework.b.b.d dVar = new cn.sharesdk.framework.b.b.d();
        if (i2 == 1) {
            dVar.a = "SHARESDK_ENTER_SHAREMENU";
        } else if (i2 == 2) {
            dVar.a = "SHARESDK_CANCEL_SHAREMENU";
        } else if (i2 == 3) {
            dVar.a = "SHARESDK_EDIT_SHARE";
        } else if (i2 == 4) {
            dVar.a = "SHARESDK_FAILED_SHARE";
        } else if (i2 == 5) {
            dVar.a = "SHARESDK_CANCEL_SHARE";
        }
        if (platform != null) {
            dVar.b = platform.getPlatformId();
        }
        cn.sharesdk.framework.b.d a = cn.sharesdk.framework.b.d.a();
        if (a != null) {
            a.a(dVar);
        }
    }

    public static void a(String str, int i2) {
        cn.sharesdk.framework.b.d a = cn.sharesdk.framework.b.d.a();
        if (a == null) {
            return;
        }
        cn.sharesdk.framework.b.b.a aVar = new cn.sharesdk.framework.b.b.a();
        aVar.b = str;
        aVar.a = i2;
        a.a(aVar);
    }

    public static HashMap<Integer, HashMap<String, Object>> a(HashMap<String, Object> hashMap) {
        int i2;
        HashMap<Integer, HashMap<String, Object>> hashMap2 = null;
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = (ArrayList) hashMap.get("fakelist");
            if (arrayList == null) {
                return null;
            }
            hashMap2 = new HashMap<>();
            EventRecorder.addBegin(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                HashMap<String, Object> hashMap3 = (HashMap) it.next();
                if (hashMap3 != null) {
                    try {
                        i2 = ResHelper.parseInt(String.valueOf(hashMap3.get("snsplat")));
                    } catch (Throwable th) {
                        SSDKLog.b().w(th);
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        hashMap2.put(Integer.valueOf(i2), hashMap3);
                    }
                }
            }
            EventRecorder.addEnd(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
        }
        return hashMap2;
    }
}
