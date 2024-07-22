package com.gf.tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.IOException;
import java.io.InputStream;

import cn.xjiangwei.RobotHelper.MainApplication;
import cn.xjiangwei.RobotHelper.Tools.Image;
import cn.xjiangwei.RobotHelper.Tools.MLog;
import cn.xjiangwei.RobotHelper.Tools.Point;
import cn.xjiangwei.RobotHelper.Tools.Robot;
import cn.xjiangwei.RobotHelper.Tools.ScreenCaptureUtil;
import cn.xjiangwei.RobotHelper.Tools.ShellUtils;
import cn.xjiangwei.RobotHelper.Tools.TessactOcr;
import cn.xjiangwei.RobotHelper.Tools.Toast;

import static android.os.SystemClock.sleep;

public class TB {
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();

    /**
     * 在这个函数里面写你的业务逻辑
     */
    public void start() {


        LogUtil.sendLog("获取任务列表");
        sleep(5000); //点击开始后等待5秒后再执行，因为状态栏收起有动画时间，建议保留这行代码

        LogUtil.sendLog("开始执行任务");
        MLog.setDebug(true);

        Robot.setExecType(Robot.ExecTypeROOT);

        //打开淘宝 com.taobao.taobao
        //com.taobao.taobao/com.taobao.browser.BrowserActivity
        LogUtil.sendLog("打开淘宝商品页");
        String cmd = "am start -n com.taobao.taobao/com.taobao.browser.BrowserActivity -d https://creator.guanghe.taobao.com/page/unify/contentDetail?contentId=472131055028&tab=1&mode=0&contentType=article&source=guanghe -f 0x10200000";
        ShellUtils.execCommand(cmd, true);


        sleep(5000);

        LogUtil.sendLog("返回淘宝首页");
        cmd = "am start com.taobao.taobao/com.taobao.tao.TBMainActivity";
        ShellUtils.execCommand(cmd, true);
        /*//点击首页
        Robot.tap(0x51, 0x5ef);
        sleep(3000);
        //点击搜索
        Robot.tap(0x2a1, 0x65);
        sleep(1000);
        // 输入关键词
        ShellUtils.execCommand("am broadcast -a ADB_INPUT_TEXT --es msg 天元公学", true);
        sleep(2000);
        //点击搜索
        Robot.tap(0x2aa, 0x5c);
        *//****************************  文本输入Demo   ******************************//*
        boolean ret = Robot.input("Hello World!");
        if (ret) {
            MLog.info("文本输入成功！");
        } else {
            MLog.error("文本输入失败！请检查当前焦点是否在文本框，或RobotHelper输入法是否设置为默认输入法！");
        }
        sleep(2000);
        ret = Robot.input("你好呀！");
        if (ret) {
            MLog.info("文本输入成功！");
        } else {
            MLog.error("文本输入失败！请检查当前焦点是否在文本框，或RobotHelper输入法是否设置为默认输入法！");
        }


        *//****************************  模板匹配demo  *******************************//*
        InputStream is = null;
        try {
            is = MainApplication.getInstance().getAssets().open("ImgMatch.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        //在当前屏幕中查找模板图片
        Point point = Image.matchTemplate(ScreenCaptureUtil.getScreenCap(), bitmap, 0.1);
        MLog.info("找到模板", point.toString());
        // 点击找到的这个图
        Robot.tap(point);


        *//**************************** 文字识别demo  **********************************//*
        try {
            //识别素材文件中的ocrTest.png图片中的文字
            is = MainApplication.getInstance().getAssets().open("ocrTest.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmap = BitmapFactory.decodeStream(is);

        String res = TessactOcr.img2string(ScreenCaptureUtil.getScreenCap(0, 0, 200, 30), "chi_sim", "", "");
        MLog.info("文字识别结果：" + res);


        *//*****************************  特征点找图  ************************************//*
        //当前屏幕中查找chrome图标（特征点是3120X1440分辨率手机制作）
        point = Image.findPointByMulColor(ScreenCaptureUtil.getScreenCap(), "434FD7,65|0|414DDB,90|55|46CDFF,5|86|5FA119");
        //点击chrome图标
        Robot.tap(point);*/


        /*****************************  双指缩放操作  ************************************/


//        Robot.pinchOpen(100);  // 目前仅在xposed模式中实现了该方法，distance值为0到100
//        Robot.pinchClose(100);  // 目前仅在xposed模式中实现了该方法，


        /***** 提示  *****/
        Toast.show("运行结束！");
        //声音提示
        Toast.notice();

    }
}
