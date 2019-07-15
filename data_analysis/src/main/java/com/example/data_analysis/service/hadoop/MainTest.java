package com.example.data_analysis.service.hadoop;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.net.URI;

public class MainTest {

    public static void main(String[] args) {

        //连接Hadoop 读取文件
        String uri = "hdfs://127.0.0.1:9000/tmp/input/file.txt";
        Configuration configuration = new Configuration();
        //configuration.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        //configuration.set("hadoop.home.dir", "/Users/huangshuai/Documents/hadoop-2.9.2");
        //configuration.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        try {
            FileSystem fileSystem = FileSystem.get(URI.create(uri), configuration);
            FSDataInputStream in = null;
            in = fileSystem.open(new Path(uri));
            FileStatus fileStatus=fileSystem.getFileStatus(new Path(uri));
            byte[] buffer=new byte[1024];
            in.read(4096, buffer, 0, 1024);
            IOUtils.copyBytes(in, System.out, 4096, false);
            IOUtils.closeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
