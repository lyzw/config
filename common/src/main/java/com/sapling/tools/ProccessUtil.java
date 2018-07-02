package com.sapling.tools;

import java.lang.management.ManagementFactory;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/2
 * @since v1.0
 */
public class ProccessUtil {

    public static String currentPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] split = name.split("@");
        if (split.length != 2) {
            throw new RuntimeException("Got unexpected process name: " + name);
        }
        ManagementFactory.getRuntimeMXBean().getStartTime()

        return split[0];
    }



    public static void main(String[] args) {
        System.out.println(currentPid());
    }
}
