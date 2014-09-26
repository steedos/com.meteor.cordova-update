package com.meteor.cordova.updater;

import java.io.File;

import android.net.Uri;
import android.util.Log;

public class FilesystemUriRemapper implements UriRemapper {
    private static final String TAG = "meteor.cordova.updater";

    final File base;

    public FilesystemUriRemapper(File base) {
        this.base = base;
    }

    @Override
    public Uri remapUri(Uri uri) {
        String path = uri.getPath();
        File file = new File(base, path);
        Log.d(TAG, "Checking for file: " + file);
        if (!file.exists()) {
            return null;
        }
        return Uri.fromFile(file);
    }
}