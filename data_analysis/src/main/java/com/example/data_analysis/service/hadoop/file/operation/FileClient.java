package com.example.data_analysis.service.hadoop.file.operation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class FileClient implements InitializingBean {

    FileSystem fileSystem = null;



    @Override
    public void afterPropertiesSet() throws Exception {
       //初始化连接信息
        URI uri = new URI("hdfs://127.0.0.1:9000");
        Configuration configuration = new Configuration();
        fileSystem = FileSystem.get(uri, configuration,"huangshuai");
    }
}
