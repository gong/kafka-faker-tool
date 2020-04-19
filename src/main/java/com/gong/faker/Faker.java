package com.gong.faker;

import static java.lang.System.exit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.gong.faker.conf.SystemProperty;
import com.gong.faker.entity.Conf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 程序入口
 * @author gongxin
 */
public class Faker {
    private static final Logger logger = LoggerFactory.getLogger(Faker.class);

    public static void start(Conf conf) {
        logger.info(conf.toString());
    }

    public static void main(String[] args) {
        String confPath;
        if (args == null || args.length == 0) {
            logger.info("配置文件缺失！");
            exit(1);
        }
        confPath = args[0];
        File file = new File(SystemProperty.home + "/" + confPath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.info("配置文件路径不对，没有读取到文件！");
            exit(1);
        }
        Conf conf = null;
        try {
            conf = JSON.parseObject(fileInputStream, Conf.class, Feature.DisableCircularReferenceDetect);
        } catch (IOException e) {
            logger.info("配置文件，反序列化失败！");
            exit(1);
        }
        start(conf);
    }

}
