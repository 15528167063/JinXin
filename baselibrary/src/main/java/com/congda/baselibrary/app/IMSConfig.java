package com.congda.baselibrary.app;

import java.io.File;

public class IMSConfig {

    public static final String BASE_URL="http://65.52.160.124:9020/kefu-front/";

    public static final String PATH_DATA = BaseApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String FIRST_OPEN = "first_open";
}
