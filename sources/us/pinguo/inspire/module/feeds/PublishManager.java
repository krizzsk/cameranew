package us.pinguo.inspire.module.feeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.ArrayList;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.statistics.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.feeds.PublishManager;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.utils.UUIDUtils;
/* loaded from: classes9.dex */
public class PublishManager {

    /* loaded from: classes9.dex */
    public interface PublishCompleteLister {
        void onPublishCancel();

        void onPublishComplete(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(String str, InspireRedirectActivity inspireRedirectActivity, PublishCompleteLister publishCompleteLister, int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            launchPublishPageFromPortal(inspireRedirectActivity, arrayList, null, publishCompleteLister);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(String str, InspireRedirectActivity inspireRedirectActivity, PublishCompleteLister publishCompleteLister, int i2, Intent intent) {
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_VIDEO_URL);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("key_exist_video_url");
            }
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(stringExtra)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                arrayList = arrayList2;
                stringExtra = null;
            }
            launchPublishPageFromPortal(inspireRedirectActivity, arrayList, stringExtra, publishCompleteLister, intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(InspireRedirectActivity inspireRedirectActivity, String str, InspireTask inspireTask, int i2, Intent intent) {
        if (i2 == -1) {
            if (intent.hasExtra("video_edit_extra")) {
                Bundle bundleExtra = intent.getBundleExtra("video_edit_extra");
                Intent intent2 = new Intent(inspireRedirectActivity, VideoEdit2Activity.class);
                intent2.putExtras(bundleExtra);
                inspireRedirectActivity.startActivity(intent2);
            } else if (intent.hasExtra("PUBLISH_EXTRA_PICTURE_PARAMS")) {
                launchPublishPageFromTask(inspireRedirectActivity, str, null, null, intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS"), inspireTask);
            } else {
                String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_VIDEO_URL);
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = intent.getStringExtra("key_exist_video_url");
                }
                String str2 = stringExtra;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                launchPublishPageFromTask(inspireRedirectActivity, str, str2, null, null, inspireTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(InspireRedirectActivity inspireRedirectActivity, PublishCompleteLister publishCompleteLister, int i2, Intent intent) {
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_VIDEO_URL);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("key_exist_video_url");
            }
            launchPublishPageFromPortal(inspireRedirectActivity, null, stringExtra, publishCompleteLister);
        }
    }

    public static Uri generateFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        return Uri.fromFile(file);
    }

    public static Uri generatePhotoFile() {
        return generateFile(Inspire.a().getExternalCacheDir() + "/inspire/C360_" + UUIDUtils.generateUUID() + ".data");
    }

    private static Uri generateVideoFile(Context context) {
        return generateFile(context.getExternalCacheDir() + "/inspire/VIDEO_" + UUIDUtils.generateUUID() + ".mp4");
    }

    private static void launchCamera(final InspireRedirectActivity inspireRedirectActivity, final PublishCompleteLister publishCompleteLister) {
        Uri generatePhotoFile = generatePhotoFile(inspireRedirectActivity);
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        intent.putExtra("camera_type", 1);
        intent.putExtra(us.pinguo.foundation.constant.a.f10984h, true);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.j
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                PublishManager.a(path, inspireRedirectActivity, publishCompleteLister, i2, intent2);
            }
        });
    }

    private static void launchCameraOrVideo(final InspireRedirectActivity inspireRedirectActivity, final PublishCompleteLister publishCompleteLister) {
        Uri generatePhotoFile = generatePhotoFile(inspireRedirectActivity);
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        intent.putExtra("camera_type", 3);
        intent.putExtra("key_no_watermark", false);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.g
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                PublishManager.b(path, inspireRedirectActivity, publishCompleteLister, i2, intent2);
            }
        });
    }

    public static void launchEffectCamera(String str, String str2, int i2, String str3, final InspireRedirectActivity inspireRedirectActivity, final InspireTask inspireTask, int i3, int i4) {
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("camera_type", i2);
        intent.putExtra("bundle_key_filter", str);
        intent.putExtra("bundle_key_package", str2);
        intent.putExtra("bundle_key_is_sticker", str3);
        intent.putExtra("bundle_key_sticker_goto_type", i4);
        intent.putExtra("key_cam", i3);
        intent.putExtra("bundle_key_init_unity", true);
        intent.putExtra(us.pinguo.foundation.constant.a.f10980d, true);
        intent.putExtra("output", generatePhotoFile);
        intent.putExtra("task", inspireTask);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.h
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i5, Intent intent2) {
                PublishManager.c(InspireRedirectActivity.this, path, inspireTask, i5, intent2);
            }
        });
    }

    public static void launchPublishPage(int i2, String str, String str2, Context context) {
        Intent intent = new Intent(context, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_MEDIA_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_ENTRANCE_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_IMAGE_PATH, str);
        if (str2 != null) {
            intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_FIRST_FRAME_PATH, str2);
        }
        context.startActivity(intent);
    }

    public static void launchPublishPageFromPortal(Activity activity, ArrayList<String> arrayList, String str, PublishCompleteLister publishCompleteLister) {
        launchPublishPageFromPortal(activity, arrayList, str, publishCompleteLister, null);
    }

    public static void launchPublishPageFromTask(Activity activity, String str, String str2, final PublishCompleteLister publishCompleteLister, String str3, InspireTask inspireTask) {
        Intent intent = new Intent(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra("key_participant_from", InspirePublishFragment.FROM_TASK_EFFECT);
        intent.putExtra("task", inspireTask);
        if (str2 == null) {
            intent.putExtra(InspirePublishFragment.MEDIA_TYPE_TASK_EFFECT_PHOTO, str);
        } else {
            intent.putExtra(InspirePublishFragment.MEDIA_TYPE_TASK_EFFECT_VIDEO, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("PUBLISH_EXTRA_PICTURE_PARAMS", str3);
        }
        ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.PublishManager.3
            @Override // us.pinguo.foundation.proxy.c
            public void onActivityResult(int i2, Intent intent2) {
                PublishManager.resultForLaunchPublish(PublishCompleteLister.this, i2, intent2);
            }
        });
    }

    public static void launchPublishPageWithPictureParam(int i2, int i3, String str, String str2, Context context, String str3) {
        Log.d("lxf", "launchPublishPage, bmpPath:" + str);
        Intent intent = new Intent(context, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_MEDIA_TYPE, i3);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_ENTRANCE_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_IMAGE_PATH, str);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("PUBLISH_EXTRA_PICTURE_PARAMS", str3);
        }
        if (str2 != null) {
            intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_FIRST_FRAME_PATH, str2);
        }
        context.startActivity(intent);
    }

    private static void launchVideoCamera(final InspireRedirectActivity inspireRedirectActivity, final PublishCompleteLister publishCompleteLister) {
        Uri generateVideoFile = generateVideoFile(inspireRedirectActivity);
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("key_no_watermark", true);
        intent.putExtra("camera_type", 2);
        intent.putExtra("output", generateVideoFile);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.i
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                PublishManager.e(InspireRedirectActivity.this, publishCompleteLister, i2, intent2);
            }
        });
    }

    private static Observable<String> liveStream(String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<String>>() { // from class: us.pinguo.inspire.module.feeds.PublishManager.4
        }.url("/feed/live/report").put("status", str).build()).map(new Payload()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<String> loadStreamJson() {
        return liveStream(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void resultForLaunchPublish(PublishCompleteLister publishCompleteLister, int i2, Intent intent) {
        if (publishCompleteLister == null) {
            return;
        }
        if (i2 == -1) {
            publishCompleteLister.onPublishComplete(intent != null ? intent.getStringExtra("client_id") : null);
        } else {
            publishCompleteLister.onPublishCancel();
        }
    }

    public static Observable<String> stopLiveStream() {
        return liveStream("off");
    }

    public static void launchPublishPageFromPortal(Activity activity, ArrayList<String> arrayList, String str, final PublishCompleteLister publishCompleteLister, String str2) {
        Intent intent = new Intent(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra("key_participant_from", "from_portal_pic");
        if (arrayList != null) {
            intent.putExtra("from_portal_pic", arrayList);
        } else {
            intent.putExtra(InspirePublishFragment.MEDIA_TYPE_VIDEO, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("PUBLISH_EXTRA_PICTURE_PARAMS", str2);
        }
        ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.PublishManager.2
            @Override // us.pinguo.foundation.proxy.c
            public void onActivityResult(int i2, Intent intent2) {
                PublishManager.resultForLaunchPublish(PublishCompleteLister.this, i2, intent2);
            }
        });
    }

    private static Uri generatePhotoFile(Context context) {
        return generateFile(context.getExternalCacheDir() + "/inspire/IMG_" + UUIDUtils.generateUUID() + ".jpg");
    }

    public static void launchPublishPage(int i2, Activity activity, final PublishCompleteLister publishCompleteLister) {
        if (!(activity instanceof InspireRedirectActivity) || i2 == 7) {
            Intent intent = new Intent(activity, InspireContentActivity.class);
            intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
            intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_MEDIA_TYPE, i2);
            ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.PublishManager.1
                @Override // us.pinguo.foundation.proxy.c
                public void onActivityResult(int i3, Intent intent2) {
                    PublishManager.resultForLaunchPublish(PublishCompleteLister.this, i3, intent2);
                }
            });
        } else if (i2 == 1) {
            launchCamera((InspireRedirectActivity) activity, publishCompleteLister);
        } else if (i2 == 2) {
            launchVideoCamera((InspireRedirectActivity) activity, publishCompleteLister);
        } else if (i2 == 8) {
            launchCameraOrVideo((InspireRedirectActivity) activity, publishCompleteLister);
            k.a(2);
        }
    }

    public static void launchPublishPageWithPictureParam(int i2, String str, String str2, InspireRedirectActivity inspireRedirectActivity, String str3, final PublishCompleteLister publishCompleteLister) {
        Log.d("lxf", "launchPublishPage, bmpPath:" + str);
        Intent intent = new Intent(inspireRedirectActivity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_MEDIA_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_ENTRANCE_TYPE, i2);
        intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_IMAGE_PATH, str);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("PUBLISH_EXTRA_PICTURE_PARAMS", str3);
        }
        if (str2 != null) {
            intent.putExtra(InspirePublishFragment.PUBLISH_EXTRA_FIRST_FRAME_PATH, str2);
        }
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.f
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i3, Intent intent2) {
                PublishManager.resultForLaunchPublish(PublishManager.PublishCompleteLister.this, i3, intent2);
            }
        });
    }

    public static void launchEffectCamera(String str, String str2, int i2, String str3, InspireRedirectActivity inspireRedirectActivity, InspireTask inspireTask) {
        launchEffectCamera(str, str2, i2, str3, inspireRedirectActivity, inspireTask, 0, 1);
    }
}
