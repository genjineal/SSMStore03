package com.wtu.test;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorTest {
    @Test
    public void mybatisGeneratorTest() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> list = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mg.XML");
        ConfigurationParser cp = new ConfigurationParser(list);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, list);
        myBatisGenerator.generate(null);
    }
}
