/*
 * Copyright (c) 2021 LG Electronics Inc.
 * SPDX-License-Identifier: AGPL-3.0-only 
 */

package oss.fosslight.util;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oss.fosslight.common.CommonFunction;
import oss.fosslight.common.ShellCommander;

public class SPDXUtil2 {
	static final Logger logger = LoggerFactory.getLogger("DEFAULT_LOG");
	static String ROOT_DIR = CommonFunction.getProperty("root.dir");
	
	public static void spreadsheetToRDF(String prjId, String spPath, String rdfPath) throws Exception {
		// 기존 파일 변환 결과 파일이 존재하는 경우 삭제
		File rdfFile = Paths.get(rdfPath).toFile();
		rdfFile.deleteOnExit();
		
		logger.debug("spreadsheetToRDF ("+prjId+") :" + spPath + " => " + rdfPath);
		String command = "java -jar " + ROOT_DIR + "/SPDX/spdx-tools-2.2.2-jar-with-dependencies.jar SpreadsheetToRDF " + spPath + " " + rdfPath;
		logger.info("command : " + command);
		ShellCommander.shellCommandWaitFor(command);
	}
	
	public static void spreadsheetToTAG(String prjId, String spPath, String tagfPath) throws Exception {
		// 기존 파일 변환 결과 파일이 존재하는 경우 삭제
		File rdfFile = Paths.get(tagfPath).toFile();
		rdfFile.deleteOnExit();

		logger.debug("SpreadsheetToTAG ("+prjId+") :" + spPath + " => " + tagfPath);
		String command = "java -jar " + ROOT_DIR + "/SPDX/spdx-tools-2.2.2-jar-with-dependencies.jar SpreadsheetToTag " + spPath + " " + tagfPath;
		logger.info("command : " + command);
		ShellCommander.shellCommandWaitFor(command);
	}
}
