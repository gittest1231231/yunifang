package bw.ynifang.modle.net;

/**
 * Created by Administrator on 2016/12/6.
 */

public class Api {
    public static final boolean isOnline=true;
    private static final String host_onLine="";
    private static final String host_dev="";
    private static final String host=isOnline ? host_onLine : host_dev;
    public static final String url_ceshi=host+"";
}
