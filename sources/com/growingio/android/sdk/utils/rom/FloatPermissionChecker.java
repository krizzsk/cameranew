package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class FloatPermissionChecker {
    public static final String TAG = "GIO.FloatPermissionChecker";
    private RomPermissionChecker mCommonRomChecker;
    private RomPermissionChecker mCurrentRomChecker;

    /* loaded from: classes2.dex */
    public static class Builder {
        private RomPermissionChecker mCommonRomChecker;
        private RomPermissionChecker mCurrentRomChecker;

        public Builder(Activity activity) {
            this.mCurrentRomChecker = FloatPermissionUtil.getPermissionChecker(activity);
            this.mCommonRomChecker = new CommonRomChecker(activity);
        }

        public FloatPermissionChecker build() {
            return new FloatPermissionChecker(this.mCurrentRomChecker, this.mCommonRomChecker);
        }

        public Builder setCurrentRomChecker(RomPermissionChecker romPermissionChecker) {
            this.mCurrentRomChecker = romPermissionChecker;
            return this;
        }
    }

    public FloatPermissionChecker(RomPermissionChecker romPermissionChecker, RomPermissionChecker romPermissionChecker2) {
        this.mCurrentRomChecker = romPermissionChecker;
        this.mCommonRomChecker = romPermissionChecker2;
    }

    public boolean checkOp() {
        return this.mCurrentRomChecker.check();
    }

    @Nullable
    public Intent getIntentOrNull() {
        Intent validIntent = this.mCurrentRomChecker.getValidIntent();
        return (!(this.mCurrentRomChecker instanceof CommonRomChecker) && validIntent == null) ? this.mCommonRomChecker.getApplyPermissionIntent() : validIntent;
    }
}
