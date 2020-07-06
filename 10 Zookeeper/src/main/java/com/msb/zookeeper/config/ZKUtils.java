package com.msb.zookeeper.config;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 马士兵教育
 * @create: 2019-09-20 20:08
 */
public class ZKUtils {

    private  static ZooKeeper zk;

    private static String address = "10.103.8.101:2182,10.103.8.102:2182,10.103.8.103:2182/testLock";

    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch init  =  new CountDownLatch(1);
    public static ZooKeeper  getZK(){

        try {
            zk = new ZooKeeper(address,1000,watch);
            watch.setCc(init);
            init.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return zk;
    }


}
