package us.pinguo.camera360.shop.update;

import android.os.Environment;
import android.util.Log;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.camera360.shop.data.install.table.StickerUpdateTable;
import us.pinguo.camera360.shop.data.m.c;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.common.db.f;
import us.pinguo.foundation.k;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.util.l;
/* loaded from: classes4.dex */
public class OldFilterUpdate implements NoProguard {
    private static boolean isTaskStart;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Thread {
        String a;

        public a(String str) {
            this.a = str;
            setName("clear_task");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            l.j(k.b + "/sticker/");
            l.j(this.a + "/.filter");
            l.j(this.a + "/TempData/wikitudeAr");
        }
    }

    static {
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.CategoryTable$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("category");
                bVar.v(TapjoyAuctionFlags.AUCTION_ID, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("namejson", IjkMediaCodecInfo.RANK_SECURE, "namejson");
                bVar.u("filterType", IjkMediaCodecInfo.RANK_SECURE, "filterType");
                bVar.u(SharePluginInfo.ISSUE_SUB_TYPE, IjkMediaCodecInfo.RANK_SECURE, SharePluginInfo.ISSUE_SUB_TYPE);
                bVar.u("icon", IjkMediaCodecInfo.RANK_SECURE, "icon");
                bVar.k("sort", "sort");
                bVar.u("displayMd5", IjkMediaCodecInfo.RANK_SECURE, "displayMd5");
                bVar.u("packageMd5", IjkMediaCodecInfo.RANK_SECURE, "packageMd5");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                bVar.k("vip", "vip");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.EffectTable$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("effect");
                bVar.q("_aid", "_aid");
                bVar.u(TapjoyAuctionFlags.AUCTION_ID, IjkMediaCodecInfo.RANK_SECURE, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("packageId", IjkMediaCodecInfo.RANK_SECURE, "packageId");
                bVar.u("key", IjkMediaCodecInfo.RANK_SECURE, "key");
                bVar.u("preCmd", IjkMediaCodecInfo.RANK_SECURE, "preCmd");
                bVar.u("gpuCmd", IjkMediaCodecInfo.RANK_SECURE, "gpuCmd");
                bVar.u("textureStr", IjkMediaCodecInfo.RANK_SECURE, "textureStr");
                bVar.u("paramStr", IjkMediaCodecInfo.RANK_SECURE, "paramStr");
                bVar.u(SharePluginInfo.ISSUE_SUB_TYPE, IjkMediaCodecInfo.RANK_SECURE, SharePluginInfo.ISSUE_SUB_TYPE);
                bVar.m("supportPreview", "1", "supportPreview");
                bVar.k("version", "version");
                bVar.u("skinParam", IjkMediaCodecInfo.RANK_SECURE, "skinParam");
                bVar.u("versionDir", IjkMediaCodecInfo.RANK_SECURE, "versionDir");
                bVar.u("onlineParam", IjkMediaCodecInfo.RANK_SECURE, "onlineParam");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.ItemTable$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("item");
                bVar.q("_aid", "_aid");
                bVar.u(TapjoyAuctionFlags.AUCTION_ID, IjkMediaCodecInfo.RANK_SECURE, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("namejson", IjkMediaCodecInfo.RANK_SECURE, "namejson");
                bVar.u("icon", IjkMediaCodecInfo.RANK_SECURE, "icon");
                bVar.k("sortInPackage", "sortInPackage");
                bVar.u("packageId", IjkMediaCodecInfo.RANK_SECURE, "packageId");
                bVar.u("packageMd5", IjkMediaCodecInfo.RANK_SECURE, "packageMd5");
                bVar.m("isCollect", "0", "isCollect");
                bVar.k("collectTime", "collectTime");
                bVar.m("hasMusic", "0", "hasMusic");
                bVar.u("type", IjkMediaCodecInfo.RANK_SECURE, "type");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.CategoryTable1$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("category1");
                bVar.v(TapjoyAuctionFlags.AUCTION_ID, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("namejson", IjkMediaCodecInfo.RANK_SECURE, "namejson");
                bVar.u("filterType", IjkMediaCodecInfo.RANK_SECURE, "filterType");
                bVar.u(SharePluginInfo.ISSUE_SUB_TYPE, IjkMediaCodecInfo.RANK_SECURE, SharePluginInfo.ISSUE_SUB_TYPE);
                bVar.u("icon", IjkMediaCodecInfo.RANK_SECURE, "icon");
                bVar.k("sort", "sort");
                bVar.u("displayMd5", IjkMediaCodecInfo.RANK_SECURE, "displayMd5");
                bVar.u("packageMd5", IjkMediaCodecInfo.RANK_SECURE, "packageMd5");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.EffectTable1$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("effect1");
                bVar.q("_aid", "_aid");
                bVar.u(TapjoyAuctionFlags.AUCTION_ID, IjkMediaCodecInfo.RANK_SECURE, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("packageId", IjkMediaCodecInfo.RANK_SECURE, "packageId");
                bVar.u("key", IjkMediaCodecInfo.RANK_SECURE, "key");
                bVar.u("preCmd", IjkMediaCodecInfo.RANK_SECURE, "preCmd");
                bVar.u("gpuCmd", IjkMediaCodecInfo.RANK_SECURE, "gpuCmd");
                bVar.u("textureStr", IjkMediaCodecInfo.RANK_SECURE, "textureStr");
                bVar.u("paramStr", IjkMediaCodecInfo.RANK_SECURE, "paramStr");
                bVar.m("supportPreview", "1", "supportPreview");
                bVar.k("version", "version");
                bVar.u("skinParam", IjkMediaCodecInfo.RANK_SECURE, "skinParam");
                bVar.u("versionDir", IjkMediaCodecInfo.RANK_SECURE, "versionDir");
                bVar.u(SharePluginInfo.ISSUE_SUB_TYPE, IjkMediaCodecInfo.RANK_SECURE, SharePluginInfo.ISSUE_SUB_TYPE);
                bVar.u("onlineParam", IjkMediaCodecInfo.RANK_SECURE, "onlineParam");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.ItemTable1$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("item1");
                bVar.q("_aid", "_aid");
                bVar.u(TapjoyAuctionFlags.AUCTION_ID, IjkMediaCodecInfo.RANK_SECURE, TapjoyAuctionFlags.AUCTION_ID);
                bVar.u("namejson", IjkMediaCodecInfo.RANK_SECURE, "namejson");
                bVar.u("icon", IjkMediaCodecInfo.RANK_SECURE, "icon");
                bVar.k("sortInPackage", "sortInPackage");
                bVar.u("packageId", IjkMediaCodecInfo.RANK_SECURE, "packageId");
                bVar.u("packageMd5", IjkMediaCodecInfo.RANK_SECURE, "packageMd5");
                bVar.m("isCollect", "0", "isCollect");
                bVar.k("collectTime", "collectTime");
                bVar.m("hasMusic", "0", "hasMusic");
                bVar.u("type", IjkMediaCodecInfo.RANK_SECURE, "type");
                bVar.u("temp1", IjkMediaCodecInfo.RANK_SECURE, "temp1");
                bVar.u("temp2", IjkMediaCodecInfo.RANK_SECURE, "temp2");
                bVar.u("temp3", IjkMediaCodecInfo.RANK_SECURE, "temp3");
                bVar.u("temp4", IjkMediaCodecInfo.RANK_SECURE, "temp4");
                return bVar.f();
            }
        };
        new Object() { // from class: us.pinguo.camera360.shop.data.install.table.StickerUpdateTable$$Table
            public f db() {
                f.b bVar = new f.b();
                bVar.w("stickerupdate");
                bVar.v("packageId", "packageId");
                return bVar.f();
            }
        };
        new StickerUpdateTable();
        isTaskStart = false;
    }

    private OldFilterUpdate() {
    }

    private static void copyDb() {
        try {
            FilterRepository.a.A();
        } catch (Exception e2) {
            Log.e("OldFilterUpdate", "error", e2);
        }
    }

    private static void startClearTask(String str) {
        if (isTaskStart) {
            return;
        }
        isTaskStart = true;
        new a(str).start();
    }

    public static void updateData(boolean z, boolean z2, boolean z3) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = (externalStorageDirectory == null ? "/sdcard" : externalStorageDirectory.getAbsolutePath()) + "/Camera360";
        if (z) {
            copyDb();
            u.b().a();
            startClearTask(str);
        } else if (z2 || z3) {
            c.a.a();
            if (!BaseApplication.d().getDatabasePath("filter.db").exists()) {
                copyDb();
                startClearTask(str);
                return;
            }
            startClearTask(str);
            if (z2) {
                u.b().a();
            }
        }
    }

    public static void writeNewUserData() {
        copyDb();
        u.b().a();
    }
}
