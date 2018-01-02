package eep.sippr.eepj.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisGeneratorRun {
	private final static Logger logger = LoggerFactory.getLogger(MybatisGeneratorRun.class);
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generator/generatorConfig.xml"));
		DefaultShellCallback shellCallback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
		myBatisGenerator.generate(null);
		for (String string : warnings) {
			logger.warn(string);
		}
	}
}