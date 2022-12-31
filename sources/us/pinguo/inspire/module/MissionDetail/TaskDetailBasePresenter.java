package us.pinguo.inspire.module.MissionDetail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.JoinStatus;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.feeds.PublishManager;
import us.pinguo.inspire.module.photomovie.PhotoMovieActivity;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public abstract class TaskDetailBasePresenter extends us.pinguo.foundation.p.a {
    public static final int REQUEST_PARTICIPATE = 21;
    public static final String SCENE_LIST = "-1";
    private static final String STICKER_CATEGROY_NULL = "sticker_category_null";
    private static final String STICKER_NULL = "sticker_null";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(InspireRedirectActivity inspireRedirectActivity, InspireTask inspireTask, int i2, Intent intent) {
        String stringExtra;
        if (-1 != i2 || (stringExtra = intent.getStringExtra("photo_path")) == null) {
            return;
        }
        inspireRedirectActivity.startActivity(VideoEdit2Activity.getStartIntent(inspireRedirectActivity, stringExtra, inspireTask, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Activity activity, InspireTask inspireTask, int i2, Intent intent) {
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_VIDEO_URL);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("key_exist_video_url");
            }
            PublishManager.launchPublishPageFromTask(activity, null, stringExtra, null, intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS"), inspireTask);
        }
    }

    private boolean checkWorkGuidedFromCamera(final Activity activity, InspireTask inspireTask) {
        if (inspireTask.isVideo()) {
            String stringExtra = activity.getIntent().getStringExtra(us.pinguo.foundation.constant.a.c);
            if (stringExtra != null) {
                Intent startIntent = VideoEdit2Activity.getStartIntent(activity, stringExtra, inspireTask, 0);
                Parcelable parcelableExtra = activity.getIntent().getParcelableExtra(us.pinguo.foundation.constant.a.f10981e);
                if (parcelableExtra != null) {
                    startIntent.putExtra(us.pinguo.foundation.constant.a.f10981e, parcelableExtra);
                }
                activity.startActivity(startIntent);
                return true;
            }
        } else {
            String stringExtra2 = activity.getIntent().getStringExtra(us.pinguo.foundation.constant.a.b);
            if (stringExtra2 != null) {
                activity.getIntent().removeExtra(us.pinguo.foundation.constant.a.b);
                File externalCacheDir = activity.getExternalCacheDir();
                if (new File(externalCacheDir, stringExtra2).exists()) {
                    PublishManager.PublishCompleteLister publishCompleteLister = new PublishManager.PublishCompleteLister() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter.1
                        @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
                        public void onPublishCancel() {
                            activity.getIntent().removeExtra(us.pinguo.foundation.constant.a.b);
                        }

                        @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
                        public void onPublishComplete(String str) {
                        }
                    };
                    PublishManager.launchPublishPageFromTask(activity, externalCacheDir + "/" + stringExtra2, null, publishCompleteLister, null, inspireTask);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickAlbum(Activity activity, InspireTask inspireTask) {
        if (inspireTask.isVideo()) {
            participantNormal(activity, inspireTask, InspirePublishFragment.FROM_ALBUM_VIDEO);
        } else {
            participantNormal(activity, inspireTask, InspirePublishFragment.FROM_NORMAL);
        }
        us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Ablum_Click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onClickPhotoCamera(Activity activity, InspireTask inspireTask) {
        participantNormal(activity, inspireTask, InspirePublishFragment.FROM_NORMAL_CAMERA);
        us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Camera_Click");
    }

    public static void onParticipateForInfo(Activity activity, InspireWork.TaskInfo taskInfo, boolean z) {
        String str;
        if (taskInfo == null) {
            return;
        }
        InspireTask task = taskInfo.toTask();
        if (TextUtils.isEmpty(taskInfo.sceneGotoUrl)) {
            if (z) {
                if (!us.pinguo.librouter.c.d.b().getInterface().k()) {
                    j0.c(R.string.current_device_not_support_task);
                    return;
                } else {
                    participantVideoCamera(activity, task);
                    return;
                }
            }
            onClickPhotoCamera(activity, task);
            return;
        }
        Uri parse = Uri.parse(taskInfo.sceneGotoUrl);
        if (parse == null) {
            return;
        }
        if (taskInfo.sceneGotoUrl.startsWith("app://camera360/cameraSocial")) {
            participantEffect(activity, parse, task);
        } else if (task.sceneGotoUrl.startsWith("app://camera360/dStickerWithReturn")) {
            participantAnimEffect(activity, task);
        } else {
            String lastPathSegment = parse.getLastPathSegment();
            if ("video".equals(lastPathSegment)) {
                String[] stickerId = TaskDetailActivity.getStickerId(task.sceneGotoUrl);
                String str2 = STICKER_NULL;
                if (stickerId == null || stickerId.length != 2) {
                    str = STICKER_NULL;
                } else {
                    str = stickerId[0];
                    String str3 = stickerId[1];
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (!us.pinguo.librouter.c.d.b().getInterface().l(str2, null)) {
                    j0.c(R.string.sticker_is_not_exist);
                } else {
                    participantVideoCamera(activity, task);
                }
            } else if ("photo".equals(lastPathSegment)) {
                participantEffect(activity, Uri.parse("app://camera360/cameraSocial?cameraType=1"), task);
                us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Camera_Click");
            }
        }
    }

    public static void onParticipatePhotoMovie(Activity activity, InspireTask inspireTask, String str) {
        Intent intent = new Intent(activity, PhotoMovieActivity.class);
        intent.putExtra("task", inspireTask);
        if (str == null) {
            str = "";
        }
        intent.putExtra("work_id", str);
        activity.startActivity(intent);
    }

    private static void participantAnimEffect(final Activity activity, final InspireTask inspireTask) {
        Intent intent = new Intent();
        intent.setAction("com.camera360.AEFFECT");
        ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.MissionDetail.s
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                TaskDetailBasePresenter.b(activity, inspireTask, i2, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void participantEffect(Activity activity, Uri uri, InspireTask inspireTask) {
        String queryParameter = uri.getQueryParameter("pkgId");
        String queryParameter2 = uri.getQueryParameter("filterId");
        String queryParameter3 = uri.getQueryParameter("cameraType");
        String queryParameter4 = uri.getQueryParameter("stickerShowMode");
        String queryParameter5 = uri.getQueryParameter("isSticker");
        String queryParameter6 = uri.getQueryParameter("camera");
        if ("true".equals(queryParameter5) && !us.pinguo.librouter.c.d.b().getInterface().l(queryParameter, null)) {
            j0.c(R.string.sticker_is_not_exist);
        } else if ("2".equals(queryParameter3) && !us.pinguo.librouter.c.d.b().getInterface().k()) {
            j0.c(R.string.current_device_not_support_task);
        } else {
            PublishManager.launchEffectCamera(queryParameter2, queryParameter, !TextUtils.isEmpty(queryParameter3) ? Integer.parseInt(queryParameter3) : 0, queryParameter5, (InspireRedirectActivity) activity, inspireTask, !TextUtils.isEmpty(queryParameter6) ? Integer.parseInt(queryParameter6) : 0, !TextUtils.isEmpty(queryParameter4) ? Integer.parseInt(queryParameter4) : 1);
        }
    }

    private static void participantNormal(Activity activity, InspireTask inspireTask, String str) {
        Intent intent = new Intent();
        intent.setClass(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        intent.putExtra("task", inspireTask);
        Bundle bundle = new Bundle();
        bundle.putParcelable("task", inspireTask);
        bundle.putString("key_participant_from", str);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 21);
    }

    private static void participantVideoCamera(Activity activity, InspireTask inspireTask) {
        participantEffect(activity, Uri.parse("app://camera360/cameraSocial?cameraType=4"), inspireTask);
        us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Camera_Click");
    }

    private void showPhotoActionDialog(Activity activity, InspireTask inspireTask) {
        showPhotoActionDialog(activity, inspireTask, null);
    }

    public abstract /* synthetic */ void attachView(us.pinguo.foundation.p.b bVar);

    protected abstract void downloadSceneTemplate();

    public void launchGalleryForVideoEdit(final InspireRedirectActivity inspireRedirectActivity, final InspireTask inspireTask) {
        Intent intent = new Intent();
        intent.setClassName(inspireRedirectActivity, "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_COUNT_LIMIT, 1);
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 7);
        intent.putExtra(InspirePublishFragment.KEY_VIDEO_TIME_LIMIT, 60);
        inspireRedirectActivity.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.MissionDetail.t
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                TaskDetailBasePresenter.a(InspireRedirectActivity.this, inspireTask, i2, intent2);
            }
        });
    }

    public void onParticipate(Activity activity, InspireTask inspireTask) {
        String str;
        if (inspireTask != null && !inspireTask.finished) {
            JoinStatus joinStatus = inspireTask.isJoin;
            if (joinStatus != null && joinStatus.status != 1) {
                j0.d(joinStatus.message);
                return;
            } else if (inspireTask.taskType == 5) {
                onParticipatePhotoMovie(activity, inspireTask, "");
                return;
            } else {
                InspireStatistics.taskInfoJoinBtnClick(s0.getInstance().getUserId(), inspireTask.taskId);
                if (checkWorkGuidedFromCamera(activity, inspireTask)) {
                    return;
                }
                if (!TextUtils.isEmpty(inspireTask.sceneGotoUrl)) {
                    Uri parse = Uri.parse(inspireTask.sceneGotoUrl);
                    if (parse == null) {
                        return;
                    }
                    if (inspireTask.sceneGotoUrl.startsWith("app://camera360/cameraSocial")) {
                        if ("true".equals(parse.getQueryParameter("album"))) {
                            showPhotoActionDialog(activity, inspireTask, parse);
                            return;
                        } else {
                            participantEffect(activity, parse, inspireTask);
                            return;
                        }
                    } else if (inspireTask.sceneGotoUrl.startsWith("app://camera360/dStickerWithReturn")) {
                        participantAnimEffect(activity, inspireTask);
                        return;
                    } else {
                        String lastPathSegment = parse.getLastPathSegment();
                        if ("sceneTemplate".equals(lastPathSegment)) {
                            String sceneId = TaskDetailActivity.getSceneId(inspireTask.sceneGotoUrl);
                            if (TextUtils.isEmpty(sceneId)) {
                                return;
                            }
                            if (!SCENE_LIST.equals(sceneId) && !us.pinguo.librouter.c.d.b().getInterface().c(sceneId)) {
                                downloadSceneTemplate();
                                return;
                            } else {
                                participateBySceneTemplate(activity, inspireTask, sceneId);
                                return;
                            }
                        } else if ("video".equals(lastPathSegment)) {
                            String[] stickerId = TaskDetailActivity.getStickerId(inspireTask.sceneGotoUrl);
                            String str2 = STICKER_NULL;
                            if (stickerId == null || stickerId.length != 2) {
                                str = STICKER_NULL;
                            } else {
                                str = stickerId[0];
                                String str3 = stickerId[1];
                            }
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                            if (!us.pinguo.librouter.c.d.b().getInterface().l(str2, null)) {
                                j0.c(R.string.sticker_is_not_exist);
                                return;
                            } else {
                                participantVideoCamera(activity, inspireTask);
                                return;
                            }
                        } else if ("photo".equals(lastPathSegment)) {
                            participantEffect(activity, Uri.parse("app://camera360/cameraSocial?cameraType=1"), inspireTask);
                            us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Camera_Click");
                            return;
                        } else {
                            showPhotoActionDialog(activity, inspireTask);
                            return;
                        }
                    }
                } else if (inspireTask.isVideo()) {
                    if (!us.pinguo.librouter.c.d.b().getInterface().k()) {
                        j0.c(R.string.current_device_not_support_task);
                        return;
                    } else {
                        participantVideoCamera(activity, inspireTask);
                        return;
                    }
                } else {
                    showPhotoActionDialog(activity, inspireTask);
                    return;
                }
            }
        }
        j0.c(R.string.task_finished);
    }

    public void participateBySceneTemplate(Activity activity, InspireTask inspireTask, String str) {
        Intent intent = new Intent();
        intent.setClass(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspirePublishFragment.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("task", inspireTask);
        bundle.putString("scene_id", str);
        bundle.putString("key_participant_from", InspirePublishFragment.FROM_SCENE_TEMPLATE);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 21);
        us.pinguo.foundation.statistics.l.onEvent(activity, "Community_Challenge_Detail_Join_Camera_Click");
    }

    private void showPhotoActionDialog(final Activity activity, final InspireTask inspireTask, final Uri uri) {
        String string;
        if (inspireTask.isVideo()) {
            string = activity.getString(R.string.make_video);
        } else {
            string = activity.getString(R.string.take_photo);
        }
        us.pinguo.foundation.utils.w.s(activity, new CharSequence[]{string, activity.getString(R.string.take_from_album), activity.getString(us.pinguo.foundation.R.string.cancel)}, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 0) {
                    Uri uri2 = uri;
                    if (uri2 != null) {
                        TaskDetailBasePresenter.participantEffect(activity, uri2, inspireTask);
                    } else {
                        TaskDetailBasePresenter.onClickPhotoCamera(activity, inspireTask);
                    }
                } else if (i2 == 1) {
                    if (!inspireTask.isVideo()) {
                        TaskDetailBasePresenter.this.onClickAlbum(activity, inspireTask);
                    } else {
                        TaskDetailBasePresenter.this.launchGalleryForVideoEdit((InspireRedirectActivity) activity, inspireTask);
                    }
                }
                dialogInterface.dismiss();
            }
        }, null);
    }
}
