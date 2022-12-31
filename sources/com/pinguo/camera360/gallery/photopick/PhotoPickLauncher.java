package com.pinguo.camera360.gallery.photopick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public class PhotoPickLauncher {

    /* loaded from: classes3.dex */
    public enum LaunchMode {
        SINGLE_PHOTO,
        MULTI_PHOTO,
        MULTI_PHOTO_WITH_VIDEO,
        MULTI_PHOTO_FOR_PUZZLE,
        MULTI_PHOTO_WITH_VIDEO_NEW,
        MULTI_PHOTO_NEW,
        SINGLE_PHOTO_NEW,
        SINGLE_VIDEO;

        public boolean isMultiPhotoNotPuzzleMode() {
            return this == MULTI_PHOTO || this == MULTI_PHOTO_WITH_VIDEO || this == MULTI_PHOTO_WITH_VIDEO_NEW || this == MULTI_PHOTO_NEW;
        }

        public boolean isMultiPhotoWithVideoMode() {
            return this == MULTI_PHOTO_WITH_VIDEO || this == MULTI_PHOTO_WITH_VIDEO_NEW || this == SINGLE_VIDEO;
        }

        public boolean isNewMode() {
            return this == SINGLE_PHOTO_NEW || this == MULTI_PHOTO_WITH_VIDEO_NEW || this == MULTI_PHOTO_NEW;
        }

        public boolean isSinglePhotoMode() {
            return this == SINGLE_PHOTO || this == SINGLE_PHOTO_NEW;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LaunchMode a(int i2) {
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    return LaunchMode.MULTI_PHOTO_WITH_VIDEO;
                case 3:
                    return LaunchMode.MULTI_PHOTO_FOR_PUZZLE;
                case 4:
                    return LaunchMode.MULTI_PHOTO_WITH_VIDEO_NEW;
                case 5:
                    return LaunchMode.MULTI_PHOTO_NEW;
                case 6:
                    return LaunchMode.SINGLE_PHOTO_NEW;
                case 7:
                    return LaunchMode.SINGLE_VIDEO;
                default:
                    return LaunchMode.MULTI_PHOTO;
            }
        }
        return LaunchMode.SINGLE_PHOTO;
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 3);
        context.startActivity(intent);
    }

    public static void c(Activity activity, int i2) {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 0);
        activity.startActivityForResult(intent, i2);
    }
}
