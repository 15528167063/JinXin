package com.congda.baselibrary.app;

import java.io.File;

public class IMSConfig {

    public static final String BASE_URL="http://api-cs.clexin.com/tomato-app/";

    public static final String PATH_DATA = BaseApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String FIRST_OPEN = "first_open";
}
