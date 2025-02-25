/*
 * This is the source code of Telegram for Android v. 7.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2020.
 */

package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class BuildVars {

    public static boolean DEBUG_VERSION = false;
    public static boolean LOGS_ENABLED = false;
    public static boolean DEBUG_PRIVATE_VERSION = false;
    public static boolean BUILD_HOST_IS_WINDOWS = false;
    public static boolean USE_CLOUD_STRINGS = true;
    public static boolean CHECK_UPDATES = true;
    public static boolean NO_SCOPED_STORAGE = Build.VERSION.SDK_INT <= 29;
    public static int BUILD_VERSION = 3026;
    public static int BUILD_VERSION_FULL = 30262;
    public static String BUILD_VENDOR = "com.android.vending";
    public static String BUILD_DUROV = "org.telegram.messenger";
    public static String BUILD_VERSION_STRING = "9.3.3";
    public static int APP_ID = 4;
    public static String APP_HASH = "014b35b6184100b085b0d0572f9b5103";
    public static String APPCENTER_HASH = "f9726602-67c9-48d2-b5d0-4761f1c1a8f3";

    public static String SMS_HASH = "oLeq9AcOZkT";
    public static String PLAYSTORE_APP_URL = "https://github.com/nikitasius/Telegraher/releases";
    public static String GOOGLE_AUTH_CLIENT_ID = "760348033671-81kmi3pi84p11ub8hp9a1funsv0rn2p9.apps.googleusercontent.com";


    // You can use this flag to disable Google Play Billing (If you're making fork and want it to be in Google Play)
    public static boolean IS_BILLING_UNAVAILABLE = false;

    static {
        if (ApplicationLoader.applicationContext != null) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("systemConfig", Context.MODE_PRIVATE);
            LOGS_ENABLED = DEBUG_VERSION || sharedPreferences.getBoolean("logsEnabled", DEBUG_VERSION);
        }
    }

    public static boolean useInvoiceBilling() {
        return false;
    }

    private static boolean hasDirectCurrency() {
        return false;
    }

    private static Boolean standaloneApp;
    public static boolean isStandaloneApp() {
        standaloneApp = false;
        return standaloneApp;
    }

    private static Boolean betaApp;
    public static boolean isBetaApp() {
        betaApp = false;
        return betaApp;
    }


    public static boolean isHuaweiStoreApp() {
        return ApplicationLoader.isHuaweiStoreBuild();
    }
}
