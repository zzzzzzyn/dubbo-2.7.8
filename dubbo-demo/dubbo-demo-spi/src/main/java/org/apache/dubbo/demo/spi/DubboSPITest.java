package org.apache.dubbo.demo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.serialize.Serialization;

public class DubboSPITest {

    public static void main(String[] args) {
        extensLoaderRobot();
        System.out.println("====================================");
        extensLoaderSerialization();
    }

    public static void extensLoaderRobot() {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }

    /**
     * 自定义序列化实现
     */
    public static void extensLoaderSerialization() {
        ExtensionLoader<Serialization> extensionLoader =
                ExtensionLoader.getExtensionLoader(Serialization.class);
        System.out.println("hession2 contentType: " + extensionLoader.getDefaultExtension().getContentType());
        Serialization serialization = extensionLoader.getExtension("mySerialization");
        System.out.println("mySerialization contentType: " + serialization.getContentType());
    }

}
